package com.bfsi.mfi.fcubs.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.cbs.entity.CbsLoanDetails;
import com.bfsi.mfi.cbs.entity.CbsLoanDisbursements;
import com.bfsi.mfi.cbs.entity.CbsLoanPaidSchedules;
import com.bfsi.mfi.cbs.entity.CbsLoanSchedules;
import com.bfsi.mfi.cbs.entity.StgLoanDetails;
import com.bfsi.mfi.cbs.entity.StgLoanDisbursements;
import com.bfsi.mfi.cbs.entity.StgLoanPaidSchedules;
import com.bfsi.mfi.cbs.entity.StgLoanSchedules;
import com.bfsi.mfi.fcubs.dao.FcubsCbsDao;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.ApplicationUtil;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("fcubsCbsJdbcdao")
public class FcubsCbsJdbcdao  extends CbsBaseJdbcDao implements FcubsCbsDao {
	private static final String PROC_NAME_BRANCH = "CBS_BRN_SYNC";
	private static final String PROC_NAME_CUSTOMER = "CBS_CUST_SYNC";
	private static final String PROC_NAME_LOAN = "CBS_LOAN_SYNC";
	private static final String PROC_NAME_FX = "CBS_FX_SYNC";
	private static final String PROC_NAME_CURRENCY = "CBS_CCY_SYNC";
	private static final String PROC_NAME_DEPOSIT = "CBS_DEPOSIT_SYNC";
	/*Guru Start*/
	private static final String PROC_NAME_PAYMENT = "CBS_UPLD_RD_PMNT";
	/*Guru End*/
	private static final String BRANCH_CODE = "000";
	private FcubsStoredProc branchProc;
	private FcubsStoredProc customerProc;
	private FcubsStoredProc loanProc;
	private FcubsStoredProc fxCurrencyProc;
	private FcubsStoredProc currencyProc;
	private FcubsStoredProc depositProc;
	
	private FcubsStoredProc paymentProc;
	/*Guru End*/
	
	List<CbsLoanDetails> cbsLoanDetailsList = null;
	// deposit Proc new

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.branchProc = new FcubsStoredProc(dataSource, PROC_NAME_BRANCH);
		this.customerProc = new FcubsStoredProc(dataSource, PROC_NAME_CUSTOMER);
		this.loanProc = new FcubsStoredProc(dataSource, PROC_NAME_LOAN);
		this.fxCurrencyProc = new FcubsStoredProc(dataSource, PROC_NAME_FX);
		this.currencyProc = new FcubsStoredProc(dataSource, PROC_NAME_CURRENCY);
		this.depositProc = new FcubsStoredProc(dataSource, PROC_NAME_DEPOSIT);
		
		this.paymentProc = new FcubsStoredProc(dataSource, PROC_NAME_PAYMENT);
		
	}
	
	@Override
	public void getPaymentData(String jobId)
	{
		paymentProc.execute(jobId);
	}
	

	@Override
	public void getLoanData(String jobId) {
			getCbsLoanDetails(jobId);
			getCbsLoanDisbursements(jobId);
			getCbsLoanPaidSch(jobId);
			getCbsLoanSch(jobId);
			updateLoanSyncTime();
	}

	@Override
	public void getDepositData(String jobId) {
		depositProc.execute(jobId);
		
	}
	
	@Override
	public void getBranchData(String jobId) {
		branchProc.execute(jobId);
	}

	@Override
	public void getCustomerData(String jobId) {
		customerProc.execute(jobId);
	}

	@Override
	public void getFxCurrencyData(String jobId) {
		fxCurrencyProc.execute(jobId);
	}

	@Override
	public void getCurrency(String jobId) {
		currencyProc.execute(jobId);
	}
	

	
	private void getCbsLoanDetails(String jobId) {
		
		LoggerUtil.cbsJobDebug(" Loan Details Job Started ");
		StgLoanDetails stgLoanDetail = null;
		try {
			//Date loanSyncDate = getCbsLoanSyncTime();
			//String loanSyncTime = ApplicationUtil.DateAsStringFormat(loanSyncDate, "yyyy-MM-dd HH:mm:ss");			
			Map<String, String> params = new HashMap<String, String>();	
			//params.put("loanSyncTime", loanSyncTime);
			cbsLoanDetailsList = cbsJdbcTemplate.query(ApplicationQuery.CBS_QUERY_LOAN_DETAILS, params, new CbsLoanDetailMapper());			
			if(cbsLoanDetailsList != null && !cbsLoanDetailsList.isEmpty()){
				/* delete the existing loan record */
				deleteLoanDetails(cbsLoanDetailsList);				
				for(CbsLoanDetails cbsLoanDetail : cbsLoanDetailsList ) {
					stgLoanDetail = new StgLoanDetails();
					BeanUtils.copyProperties(cbsLoanDetail, stgLoanDetail);
					stgLoanDetail.setCbsUpldJobId(jobId);
					/* insert the existing loan record */
					SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
							stgLoanDetail);
					jdbcTemplate.execute(ApplicationQuery.STG_INSERT_QUERY_LOAN_DETAILS, namedParameters,
							new PreparedStatementCallback<Object>() {
								@Override
								public Object doInPreparedStatement(PreparedStatement stmt)
										throws SQLException, DataAccessException {
									return stmt.executeUpdate();
								}
							});
					
				}
			}
		} catch(Exception e){
			LoggerUtil.cbsJobError("Unhandeled Exception while get Cbs Loan Details : MFI10001",e);
		}
		LoggerUtil.cbsJobDebug(" Loan Details Job End ");		
		
	}
	
	
	public void getCbsLoanDisbursements(String jobId) {
		
		LoggerUtil.cbsJobDebug(" Loan Disbursements Job Started ");
		StgLoanDisbursements stgLoanDisbursements = null;
		try{
			if(cbsLoanDetailsList != null && !cbsLoanDetailsList.isEmpty()){
				String selectSql = getQueryForObject(cbsLoanDetailsList, ApplicationQuery.CBS_QUERY_LOAN_DISBURSEMENT);				
				Map<String, String> params = getParamForObject(cbsLoanDetailsList);				
				List<CbsLoanDisbursements> cbsLoanDisbursementsList = cbsJdbcTemplate.query(selectSql, params, new CbsLoanDisbursementMapper());
				
				if(cbsLoanDisbursementsList != null && !cbsLoanDisbursementsList.isEmpty()){
					/* delete the existing loan Disbr record */
					deleteLoanDisbursement(cbsLoanDisbursementsList);
					for(CbsLoanDisbursements cbsLoanDisbursement : cbsLoanDisbursementsList ) {
						stgLoanDisbursements = new StgLoanDisbursements();
						BeanUtils.copyProperties(cbsLoanDisbursement, stgLoanDisbursements);
						stgLoanDisbursements.setCbsUploadJobId(jobId);
						//LoggerUtil.ibsJobDebug("Query create ->"+ApplicationQuery.STG_INSERT_QUERY_LOAN_DISBURSEMENT);
						SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
								stgLoanDisbursements);
						jdbcTemplate.execute(ApplicationQuery.STG_INSERT_QUERY_LOAN_DISBURSEMENT, namedParameters,
								new PreparedStatementCallback<Object>() {
									@Override
									public Object doInPreparedStatement(PreparedStatement stmt)
											throws SQLException, DataAccessException {
										return stmt.executeUpdate();
									}
								});
						
					}
				}
			}
		}catch(Exception e){
			LoggerUtil.cbsJobError("Unhandeled Exception while get Cbs Loan Disbursement : MFI10001",e);
		}
		LoggerUtil.cbsJobDebug(" Loan Disbursements Job End ");
	}
	
	
	
	private void getCbsLoanPaidSch(String jobId) {
		
		LoggerUtil.cbsJobDebug(" Loan Paid Schedules Job Started ");
		StgLoanPaidSchedules stgLoanPaidSch = null;
		try{
			if(cbsLoanDetailsList != null && !cbsLoanDetailsList.isEmpty()) {
				String selectSql = getQueryForObject(cbsLoanDetailsList, ApplicationQuery.CBS_QUERY_LOAN_PAID_SCH);							
				Map<String, String> params = getParamForObject(cbsLoanDetailsList);				
				List<CbsLoanPaidSchedules> cbsLoanPaidSchList = cbsJdbcTemplate.query(selectSql, params, new CbsLoanPaidSchMapper());
				
				if(cbsLoanPaidSchList != null && !cbsLoanPaidSchList.isEmpty()){
					/* delete the existing loan paid Sch */
					deleteLoanPaidSch(cbsLoanPaidSchList);
					for(CbsLoanPaidSchedules cbsLoanPaidSch : cbsLoanPaidSchList ) {
						stgLoanPaidSch = new StgLoanPaidSchedules();
						BeanUtils.copyProperties(cbsLoanPaidSch, stgLoanPaidSch);
						stgLoanPaidSch.setCbsUpldJobId(jobId);
						//LoggerUtil.cbsJobDebug("Query create ->"+ApplicationQuery.STG_INSERT_QUERY_LOAN_PAID_SCH);
						SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
								stgLoanPaidSch);
						jdbcTemplate.execute(ApplicationQuery.STG_INSERT_QUERY_LOAN_PAID_SCH, namedParameters,
								new PreparedStatementCallback<Object>() {
									@Override
									public Object doInPreparedStatement(PreparedStatement stmt)
											throws SQLException, DataAccessException {
										return stmt.executeUpdate();
									}
								});
						
					}
				}
			}
		} catch(Exception e){
			LoggerUtil.cbsJobError("Unhandeled Exception while get Cbs Loan Paid Schedule : MFI10001",e);
		}
		LoggerUtil.cbsJobDebug(" Loan Paid Schedules Job End ");		
		
	}
	
	
	private void getCbsLoanSch(String jobId) {
		
		LoggerUtil.cbsJobDebug(" Loan Schedules Job Started ");
		StgLoanSchedules stgLoanSch = null;
		try{
			if(cbsLoanDetailsList != null && !cbsLoanDetailsList.isEmpty()){
				String selectSql = getQueryForObject(cbsLoanDetailsList, ApplicationQuery.CBS_QUERY_LOAN_SCH);				
				Map<String, String> params = getParamForObject(cbsLoanDetailsList);
				List<CbsLoanSchedules> cbsLoanSchList = cbsJdbcTemplate.query(selectSql, params, new CbsLoanSchMapper());
				
				if(cbsLoanSchList != null && !cbsLoanSchList.isEmpty()){
					/* delete the existing loan sch record */
					deleteLoanSch(cbsLoanSchList);
					for(CbsLoanSchedules cbsLoanSch : cbsLoanSchList ) {
						stgLoanSch = new StgLoanSchedules();
						BeanUtils.copyProperties(cbsLoanSch, stgLoanSch);
						stgLoanSch.setCbsUploadJobId(jobId);
						SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
								stgLoanSch);
						jdbcTemplate.execute(ApplicationQuery.STG_INSERT_QUERY_LOAN_SCH, namedParameters,
								new PreparedStatementCallback<Object>() {
									@Override
									public Object doInPreparedStatement(PreparedStatement stmt)
											throws SQLException, DataAccessException {
										return stmt.executeUpdate();
									}
								});									
					}
				}
			}
		} catch(Exception e){
			LoggerUtil.cbsJobError("Unhandeled Exception while get Cbs Loan Schedule : MFI10001",e);
		}
		LoggerUtil.cbsJobDebug(" Loan Schedules Job End ");		
		
	}
	
	private void updateLoanSyncTime() {
			
			LoggerUtil.cbsJobDebug(" Update Loan Sync Time Started ");
			Date loanSyncDate = null;
			try {
					Map<String, String> params = new HashMap<String, String>();	
					params.put("branchCode", BRANCH_CODE);
					SqlRowSet rs = cbsJdbcTemplate.queryForRowSet(ApplicationQuery.CBS_QUERY_LOAN_SYNC_TIME, params);
					int rowCount = 0;
					if(rs != null ){
						while (rs.next()) {
							loanSyncDate = rs.getDate("TODAY");
			                rowCount++;
						}
					} 
				} catch(Exception e){
					LoggerUtil.cbsJobError("Unhandeled Exception while get CBS loan Sync Time : MFI10001", e);
				}
			
			try {
					String loanSyncTime = ApplicationUtil.DateAsStringFormat(loanSyncDate, "yyyyMMddhhmmss");
					Map<String, String> params = new HashMap<String, String>();	
					params.put("loanSyncTime", loanSyncTime);
					jdbcTemplate.update(ApplicationQuery.MFI_UPDATE_LOAN_SYNC_TIME, params);
					
			} catch(Exception e){
				LoggerUtil.cbsJobError("Unhandeled Exception while update the MFI Sync Time : MFI10001", e);
			}
			LoggerUtil.cbsJobDebug(" Update Loan Sync Time Ended ");			
		}
	
	
	/*
	private Date getCbsLoanSyncTime() {
		Date loanSyncTime = null;
		try {
		Map<String, String> params = new HashMap<String, String>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(ApplicationQuery.CBS_QUERY_LOAN_SYNC_TIME, params);
		int rowCount = 0;
		if(rs != null ){
			while (rs.next()) {
				loanSyncTime = rs.getDate("LOAN_SYNC");
                rowCount++;
			}
		} 
		} catch(Exception e){
			loanSyncTime = null;			
			LoggerUtil.cbsJobError("Unhandeled Exception while get loan Sync Time : MFI10001", e);
		}
		
		if(loanSyncTime == null){
			loanSyncTime = ApplicationUtil.longAsDateFormat(System.currentTimeMillis());
		}
		return loanSyncTime;
	}*/
	
	
	private String getQueryForObject(List<CbsLoanDetails> cbsLoanList, String query) {
		StringBuilder l_queryBuilder=new StringBuilder(query);
		String l_delimiter="";
		for(int l_i=0;l_i<cbsLoanList.size();l_i++){			
			l_queryBuilder.append(l_delimiter + ":param" + l_i);
			l_delimiter=",";
		}
		l_queryBuilder.append(')');		
		return l_queryBuilder.toString();
	}
	
	private Map<String, String> getParamForObject(List<CbsLoanDetails> cbsLoanList) {
		Map<String, String> l_params = new HashMap<String, String>();
		
		for(int l_i=0;l_i<cbsLoanList.size();l_i++){
			l_params.put("param" + l_i, cbsLoanList.get(l_i).getLoanAcNo());			
		}		
		return l_params;
	}
	
	private void deleteLoanDetails(List<CbsLoanDetails> cbsLoanList) {		
		Map<String, String>[] l_params = new HashMap[cbsLoanList.size()];
		//StringBuilder l_queryBuilder=new StringBuilder(ApplicationQuery.STG_QUERY_DELETE_LOAN_DETAILS);
		//String l_delimiter="";
		for(int l_i=0;l_i<cbsLoanList.size();l_i++){
			l_params[l_i]=new HashMap<String, String>();
			l_params[l_i].put("loanAccNo", cbsLoanList.get(l_i).getLoanAcNo());
			//l_queryBuilder.append(l_delimiter + ":param" + l_i);
			//l_delimiter=",";
		}
		//l_queryBuilder.append(")");				
		jdbcTemplate.batchUpdate(ApplicationQuery.STG_QUERY_DELETE_LOAN_DETAILS, l_params);		
	}
	
	private void deleteLoanDisbursement(List<CbsLoanDisbursements> cbsLoanDisList) {		
		Map<String, String>[] l_params = new HashMap[cbsLoanDisList.size()];
		//StringBuilder l_queryBuilder=new StringBuilder(ApplicationQuery.STG_QUERY_DELETE_LOAN_DISBR);
		//String l_delimiter="";
		for(int l_i=0;l_i<cbsLoanDisList.size();l_i++){
			l_params[l_i]=new HashMap<String, String>();
			l_params[l_i].put("loanAccNo", cbsLoanDisList.get(l_i).getLoanAcNo());
			l_params[l_i].put("branchCode", cbsLoanDisList.get(l_i).getBranchCode());
			l_params[l_i].put("componentName", cbsLoanDisList.get(l_i).getComponentName());
			l_params[l_i].put("disbrType", cbsLoanDisList.get(l_i).getDisbrType());
			l_params[l_i].put("schStDate", ApplicationUtil.DateAsStringFormat(cbsLoanDisList.get(l_i).getSchStDate(),"dd-MM-yy"));
			l_params[l_i].put("schEndDate", ApplicationUtil.DateAsStringFormat(cbsLoanDisList.get(l_i).getSchEndDate(),"dd-MM-yy"));			
			//l_queryBuilder.append(l_delimiter + ":param" + l_i);
			//l_delimiter=",";
		}
		//l_queryBuilder.append(")");				
		jdbcTemplate.batchUpdate(ApplicationQuery.STG_QUERY_DELETE_LOAN_DISBR, l_params);		
	}
	
	private void deleteLoanSch(List<CbsLoanSchedules> cbsLoanSchList) {		
		Map<String, String>[] l_params = new HashMap[cbsLoanSchList.size()];
		
		//StringBuilder l_queryBuilder=new StringBuilder(ApplicationQuery.STG_QUERY_DELETE_LOAN_SCH);
		//String l_delimiter="";
		for(int l_i=0;l_i<cbsLoanSchList.size();l_i++){
			l_params[l_i]=new HashMap<String, String>();
			l_params[l_i].put("loanAccNo", cbsLoanSchList.get(l_i).getLoanAcNo());
			l_params[l_i].put("branchCode", cbsLoanSchList.get(l_i).getBranchCode());
			l_params[l_i].put("componentName", cbsLoanSchList.get(l_i).getComponentName());
			l_params[l_i].put("schType", cbsLoanSchList.get(l_i).getSchType());
			l_params[l_i].put("schStDate", ApplicationUtil.DateAsStringFormat(cbsLoanSchList.get(l_i).getSchStDate(),"dd-MM-yy"));
			l_params[l_i].put("schEndDate", ApplicationUtil.DateAsStringFormat(cbsLoanSchList.get(l_i).getSchEndDate(),"dd-MM-yy"));
			//l_queryBuilder.append(l_delimiter + ":param" + l_i);
			//l_delimiter=",";
			
		}
	//	l_queryBuilder.append(")");	
		jdbcTemplate.batchUpdate(ApplicationQuery.STG_QUERY_DELETE_LOAN_SCH, l_params);
	
	}
	
	private void deleteLoanPaidSch(List<CbsLoanPaidSchedules> cbsLoanPaidSchList) {		
		Map<String, String>[] l_params = new HashMap[cbsLoanPaidSchList.size()];
		//StringBuilder l_queryBuilder=new StringBuilder(ApplicationQuery.STG_QUERY_DELETE_LOAN_PAID_SCH);
		//String l_delimiter="";
		for(int l_i=0;l_i<cbsLoanPaidSchList.size();l_i++){
			l_params[l_i]=new HashMap<String, String>();
			l_params[l_i].put("loanAccNo", cbsLoanPaidSchList.get(l_i).getLoanAcNo());
			//l_queryBuilder.append(l_delimiter + ":param" + l_i);
			//l_delimiter=",";
		}
		//l_queryBuilder.append(")");				
		jdbcTemplate.batchUpdate(ApplicationQuery.STG_QUERY_DELETE_LOAN_PAID_SCH, l_params);		
	}
	
	private class FcubsStoredProc extends StoredProcedure {

		public FcubsStoredProc(DataSource datasource, String procName) {
			super(datasource, procName);
			LoggerUtil.ibsJobDebug("Initializing stored proc: Proc Name-> "+procName);
			declareParameter(new SqlParameter("P_JOBID", Types.VARCHAR));
			// //declaring sql in parameter to pass input
			// declareParameter( new SqlOutParameter( "name", Types.VARCHAR ) );
			// //declaring sql out parameter
			compile();
		}

		public Object execute(String jobId) {
			LoggerUtil.ibsJobDebug("Executing stored proc: Job Id-> "+jobId);
			Map<String, Object> results = super.execute(jobId);
			return results;
			// return results.get("name"); //reading output of stored procedure
			// using out parameters } }
		}
	}


	private static final class CbsLoanDetailMapper implements RowMapper<CbsLoanDetails>{
		@Override
		public CbsLoanDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsLoanDetails cbsLoanDetails =new CbsLoanDetails ();		
			
			cbsLoanDetails.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			cbsLoanDetails.setBranchCode(rs.getString("BRANCH_CODE"));
			cbsLoanDetails.setCustomerId(rs.getString("CUSTOMER_ID"));
			cbsLoanDetails.setCreditOfficeCode(rs.getString("CREDIT_OFFICER_CODE"));
			cbsLoanDetails.setGroupId(rs.getString("GROUP_ID"));
			cbsLoanDetails.setGroupCode(rs.getString("GROUP_CODE"));
			cbsLoanDetails.setLoanStatus(rs.getString("LOAN_STATUS"));
			cbsLoanDetails.setLocationCode(rs.getString("LOCATION_CODE"));			
			cbsLoanDetails.setSanctionDate(rs.getDate("SANCTIONED_DATE"));			
			cbsLoanDetails.setLastDisbursedDate(rs.getDate("LAST_DISBURSED_DATE"));
			cbsLoanDetails.setDisbursType(rs.getString("DISBR_TYPE"));
			cbsLoanDetails.setLoanAcCcy(rs.getString("LOAN_AC_CCY"));
			cbsLoanDetails.setIsFullyDisbursed(rs.getString("IS_FULLY_DISBURSED"));			
			cbsLoanDetails.setSanctionedPrincipalAmt(rs.getLong("SANTIONED_PRINCIPAL_AMT"));
			cbsLoanDetails.setDisbursedPrincipalAmt(rs.getLong("DISBURSED_PRINCIPAL_AMT"));
			cbsLoanDetails.setInterestRate(rs.getLong("INTEREST_RATE"));
			cbsLoanDetails.setInterestAccured(rs.getLong("INTEREST_ACCRUED"));
			cbsLoanDetails.setPrincipalAmtRepaid(rs.getLong("PRINCIPAL_AMT_REPAID"));
			cbsLoanDetails.setPrincipalOutStanding(rs.getLong("PRINCIPAL_OUTSTANDING"));			
			cbsLoanDetails.setLastRepaymentDate(rs.getDate("LAST_REPAYMENT_DATE"));
			cbsLoanDetails.setRecordStat(rs.getString("RECORD_STAT"));	
			return cbsLoanDetails;
		}
	
	}
	
	private static final class CbsLoanDisbursementMapper implements RowMapper<CbsLoanDisbursements>{
		
		@Override
		public CbsLoanDisbursements mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsLoanDisbursements cbsLoanDisbr = new CbsLoanDisbursements ();
			
			cbsLoanDisbr.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			cbsLoanDisbr.setBranchCode(rs.getString("BRANCH_CODE"));
			cbsLoanDisbr.setComponentName(rs.getString("COMPONENT_NAME"));
			cbsLoanDisbr.setDisbrType(rs.getString("DISBR_TYPE"));
			cbsLoanDisbr.setSchStDate(rs.getDate("SCH_ST_DATE"));
			cbsLoanDisbr.setSchEndDate(rs.getDate("SCH_END_DATE"));
			cbsLoanDisbr.setComponentCcyCode(rs.getString("COMPONENT_CCY_CODE"));
			cbsLoanDisbr.setComponentLcyCode(rs.getString("COMPONENT_LCY_CODE"));
			cbsLoanDisbr.setAmtToDisbr(rs.getLong("AMT_TO_DISBR"));
			cbsLoanDisbr.setAmtToDisbrLcy(rs.getLong("AMT_TO_DISBR_LCY"));
						
			return cbsLoanDisbr;
		}		
	
	}
	
	private static final class CbsLoanPaidSchMapper implements RowMapper<CbsLoanPaidSchedules>{
		@Override
		public CbsLoanPaidSchedules mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsLoanPaidSchedules cbsLoanPaidSch = new CbsLoanPaidSchedules ();
			
			cbsLoanPaidSch.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			cbsLoanPaidSch.setBranchCode(rs.getString("BRANCH_CODE"));			
			cbsLoanPaidSch.setSchDueDate(rs.getDate("SCH_DUE_DATE"));
			cbsLoanPaidSch.setSchPaidDate(rs.getDate("SCH_PAID_DATE"));
			cbsLoanPaidSch.setSettlementCcyCode(rs.getString("SETTLEMENT_CCY_CODE"));
			cbsLoanPaidSch.setAmtSettled(rs.getLong("AMT_SETTLED"));
			cbsLoanPaidSch.setFullPartialInd(rs.getString("FULL_PARTIAL_IND"));			
						
			return cbsLoanPaidSch;
		}
	
	}
	
	private static final class CbsLoanSchMapper implements RowMapper<CbsLoanSchedules>{
		@Override
		public CbsLoanSchedules mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsLoanSchedules cbsLoanSch = new CbsLoanSchedules();
			
			cbsLoanSch.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			cbsLoanSch.setBranchCode(rs.getString("BRANCH_CODE"));			
			cbsLoanSch.setComponentName(rs.getString("COMPONENT_NAME"));
			cbsLoanSch.setSchType(rs.getString("SCH_TYPE"));
			cbsLoanSch.setSchStDate(rs.getDate("SCH_ST_DATE"));
			cbsLoanSch.setSchEndDate(rs.getDate("SCH_END_DATE"));
			cbsLoanSch.setComponentCcyCode(rs.getString("COMPONENT_CCY_CODE"));
			cbsLoanSch.setComponentLcyCode(rs.getString("COMPONENT_LCY_CODE"));
			cbsLoanSch.setAmtDue(rs.getLong("AMT_DUE"));
			cbsLoanSch.setAmtDueLcy(rs.getLong("AMT_DUE_LCY"));			
						
			return cbsLoanSch;
		}
	
	}	
	
}
