package com.bfsi.mfi.cbs.adapter.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.jdbc.core.RowMapper;

import com.bfsi.mfi.cbs.adapter.CbsLoanSyncServiceAdapter;
import com.bfsi.mfi.cbs.model.CbsLoanDetails;
import com.bfsi.mfi.cbs.model.CbsLoanDisbursements;
import com.bfsi.mfi.cbs.model.CbsLoanPaidSchedules;
import com.bfsi.mfi.cbs.model.CbsLoanSchedules;
import com.bfsi.mfi.cbs.request.LoanSyncRequest;
import com.bfsi.mfi.cbs.response.LoanSyncResponse;
import com.bfsi.mfi.query.InterfaceQuery;

/**
 * 
 * @author Vishal
 *
 */

public class CbsLoanSyncServiceSqlAdapter extends   CbsLoanSyncServiceAdapter {
	private ServletContext servletContext =null;
	
	@Override
	public LoanSyncResponse extractLoans(LoanSyncRequest p_request) {
		// TODO Auto-generated method stub
		LoanSyncResponse l_res=new LoanSyncResponse();
		l_res.setLoanDetails(getLoansFromCbs(new Date()));
		return l_res;		
	}

	@Override
	public LoanSyncResponse extractLoanDisbr(List<CbsLoanDetails> p_loans, LoanSyncRequest p_request) {
		// TODO Auto-generated method stub
		LoanSyncResponse l_res=new LoanSyncResponse();
		l_res.setLoanDisbr(getLoanDisbrFromCbs(p_loans, new Date()));
		return l_res;
	}

	@Override
	public LoanSyncResponse extractLoanPaidSch(List<CbsLoanDetails> p_loans, LoanSyncRequest p_request) {
		// TODO Auto-generated method stub
		LoanSyncResponse l_res=new LoanSyncResponse();
		l_res.setLoanPaidSch(getLoanPaidSchFromCbs(p_loans, new Date()));
		return l_res;
	}

	@Override
	public LoanSyncResponse extractLoanSch(List<CbsLoanDetails> p_loans, LoanSyncRequest p_request) {
		// TODO Auto-generated method stub
		LoanSyncResponse l_res=new LoanSyncResponse();
		l_res.setLoanSch(getLoanSchFromCbs(p_loans, new Date()));
		return l_res;
	}
	
	private List<CbsLoanDetails> getLoansFromCbs(Date p_syncTime){
		Map<String, String> l_params = new HashMap<String, String>();
		List<CbsLoanDetails> l_loan = null;
		l_loan = getJdbcTemplate().query(InterfaceQuery.CBS_QUERY_LOAN_DETAILS, l_params, new CbsLoanDetailMapper());
		return l_loan==null?new ArrayList<CbsLoanDetails>():l_loan;
		
	}
	
	private List<CbsLoanDisbursements> getLoanDisbrFromCbs(List<CbsLoanDetails> p_loans, Date p_syncTime){
		//Map<String, String> l_params = getParamForObject(p_loans);
		Map<String, String> l_params = new HashMap<String, String>();
		List<CbsLoanDisbursements> l_disbr = null;
		//String l_Sql = getQueryForObject(p_loans, ApplicationQuery.CBS_QUERY_LOAN_DISBURSEMENT);
		l_disbr = getJdbcTemplate().query(InterfaceQuery.CBS_QUERY_LOAN_DISBURSEMENT, l_params, new CbsLoanDisbursementMapper());
		return l_disbr==null ?new ArrayList<CbsLoanDisbursements>():l_disbr;
	}
	
	private List<CbsLoanPaidSchedules> getLoanPaidSchFromCbs(List<CbsLoanDetails> p_loans, Date p_syncTime){
		//Map<String, String> l_params = getParamForObject(p_loans);
		Map<String, String> l_params = new HashMap<String, String>();
		List<CbsLoanPaidSchedules> l_paidSch = null;
		//String l_Sql = getQueryForObject(p_loans, ApplicationQuery.CBS_QUERY_LOAN_PAID_SCH);
		l_paidSch = getJdbcTemplate().query(InterfaceQuery.CBS_QUERY_LOAN_PAID_SCH, l_params, new CbsLoanPaidSchMapper());
		return l_paidSch ==null ? new ArrayList<CbsLoanPaidSchedules>():l_paidSch;
		
	}
	
	private List<CbsLoanSchedules> getLoanSchFromCbs(List<CbsLoanDetails> p_loans, Date p_syncTime){
		List<CbsLoanSchedules> l_loanSch = null;
		//Map<String, String> l_params = getParamForObject(p_loans);
		Map<String, String> l_params = new HashMap<String, String>();
		//String l_Sql = getQueryForObject(p_loans, ApplicationQuery.CBS_QUERY_LOAN_SCH);
		l_loanSch = getJdbcTemplate().query(InterfaceQuery.CBS_QUERY_LOAN_SCH, l_params, new CbsLoanSchMapper());
		return l_loanSch==null ? new ArrayList<CbsLoanSchedules>():l_loanSch;
		
	}
	
	private static final class CbsLoanDetailMapper implements RowMapper<CbsLoanDetails>{
		@Override
		public CbsLoanDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsLoanDetails cbsLoanDetails =new CbsLoanDetails ();		
			
			cbsLoanDetails.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			cbsLoanDetails.setBranchCode(rs.getString("BRANCH_CODE"));
			cbsLoanDetails.setPrntLoanAcNo(rs.getString("parent_loan_ac_no"));
			cbsLoanDetails.setCustomerId(rs.getString("CUSTOMER_ID"));

			cbsLoanDetails.setCreditOfficeCode(rs.getString("CREDIT_OFFICER_CODE"));
			cbsLoanDetails.setCbsGroupId(rs.getString("CBS_GROUP_ID"));	
			// new feild Added
			cbsLoanDetails.setPrntLoanAcNo(rs.getString("PARENT_LOAN_AC_NO"));
			cbsLoanDetails.setPrntCustId(rs.getString("PARENT_CUST_ID"));
			cbsLoanDetails.setIsprntLoan(rs.getString("IS_PARENT_LOAN"));
			cbsLoanDetails.setIsgroupLoan(rs.getString("IS_GROUP_LOAN"));
			cbsLoanDetails.setCbsLoanShortCode(rs.getString("CBS_LOAN_SHORT_CODE"));
			cbsLoanDetails.setCbsLcrCode(rs.getString("CBS_LCR_CODE"));
			cbsLoanDetails.setCbsLcrType(rs.getString("CBS_LCR_TYPE"));
			cbsLoanDetails.setCbsAgentCode(rs.getString("CBS_AGENT_CODE"));

			cbsLoanDetails.setPrntCustId(rs.getString("parent_cust_id"));
			cbsLoanDetails.setIsprntLoan(rs.getString("is_parent_loan"));
			cbsLoanDetails.setIsgroupLoan(rs.getString("is_group_loan"));
			cbsLoanDetails.setCbsLoanShortCode(rs.getString("cbs_loan_short_Code"));
			cbsLoanDetails.setCreditOfficeCode(rs.getString("CREDIT_OFFICER_CODE"));
			cbsLoanDetails.setLoanStatus(rs.getString("LOAN_STATUS"));	
			cbsLoanDetails.setCbsLcrCode(rs.getString("cbs_lcr_code"));
			cbsLoanDetails.setCbsLcrType(rs.getString("cbs_lcr_type"));
			cbsLoanDetails.setCbsAgentCode(rs.getString("cbs_agent_code"));

			cbsLoanDetails.setSanctionDate(rs.getDate("SANCTIONED_DATE"));			
			cbsLoanDetails.setLastDisbursedDate(rs.getDate("LAST_DISBURSED_DATE"));
			cbsLoanDetails.setDisbursType(rs.getString("DISBR_TYPE"));
			cbsLoanDetails.setLoanAcCcy(rs.getString("LOAN_AC_CCY"));
			cbsLoanDetails.setIsFullyDisbursed(rs.getString("IS_FULLY_DISBURSED"));			
			cbsLoanDetails.setSanctionedPrincipalAmt(rs.getLong("SANCTIONED_PRINCIPAL_AMT"));
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
				cbsLoanDisbr.setPrntLoanAcNo(rs.getString("parent_loan_ac_no"));
				cbsLoanDisbr.setCustomerId(rs.getString("CUSTOMER_ID"));
				cbsLoanDisbr.setPrntCustId(rs.getString("parent_cust_id"));
				cbsLoanDisbr.setIsprntLoan(rs.getString("is_parent_loan"));
				cbsLoanDisbr.setIsgroupLoan(rs.getString("is_group_loan"));
				cbsLoanDisbr.setDisbrType(rs.getString("DISBR_TYPE"));				
				cbsLoanDisbr.setSchStDate(rs.getDate("SCH_ST_DATE"));
				cbsLoanDisbr.setSchEndDate(rs.getDate("SCH_END_DATE"));
				cbsLoanDisbr.setCbsGroupId(rs.getString("CBS_GROUP_ID"));	
				cbsLoanDisbr.setComponentName(rs.getString("COMPONENT_NAME"));
				cbsLoanDisbr.setComponentCcyCode(rs.getString("COMPONENT_CCY_CODE"));
				cbsLoanDisbr.setComponentLcyCode(rs.getString("COMPONENT_LCY_CODE"));
				cbsLoanDisbr.setAmtToDisbr(rs.getLong("AMT_TO_DISBR"));
				cbsLoanDisbr.setAmtToDisbrLcy(rs.getLong("AMT_TO_DISBR_LCY"));
				
				// new feild Added

				cbsLoanDisbr.setPrntLoanAcNo(rs.getString("PARENT_LOAN_AC_NO"));
				cbsLoanDisbr.setCustomerId(rs.getString("CUSTOMER_ID"));
				cbsLoanDisbr.setPrntCustId(rs.getString("PARENT_CUST_ID"));
				cbsLoanDisbr.setIsprntLoan(rs.getString("IS_PARENT_LOAN"));
				cbsLoanDisbr.setIsgroupLoan(rs.getString("IS_GROUP_LOAN"));		
				cbsLoanDisbr.setCbsGroupId(rs.getString("CBS_GROUP_ID"));	

				// END 
				
				
							
				return cbsLoanDisbr;
			}		
		
		}
	
	private static final class CbsLoanPaidSchMapper implements RowMapper<CbsLoanPaidSchedules>{
		@Override
		public CbsLoanPaidSchedules mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsLoanPaidSchedules cbsLoanPaidSch = new CbsLoanPaidSchedules ();
			
			cbsLoanPaidSch.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			cbsLoanPaidSch.setBranchCode(rs.getString("BRANCH_CODE"));
			cbsLoanPaidSch.setPrntLoanAcNo(rs.getString("parent_loan_ac_no"));
			cbsLoanPaidSch.setCustomerId(rs.getString("CUSTOMER_ID"));
			cbsLoanPaidSch.setPrntCustId(rs.getString("parent_cust_id"));
			cbsLoanPaidSch.setIsprntLoan(rs.getString("is_parent_loan"));
			cbsLoanPaidSch.setIsgroupLoan(rs.getString("is_group_loan"));
			cbsLoanPaidSch.setCbsGroupId(rs.getString("CBS_GROUP_ID"));	
			cbsLoanPaidSch.setSchDueDate(rs.getDate("SCH_DUE_DATE"));
			cbsLoanPaidSch.setSchPaidDate(rs.getDate("SCH_PAID_DATE"));
			cbsLoanPaidSch.setSettlementCcyCode(rs.getString("SETTLEMENT_CCY_CODE"));
			cbsLoanPaidSch.setAmtSettled(rs.getLong("AMT_SETTLED"));
			cbsLoanPaidSch.setFullPartialInd(rs.getString("FULL_PARTIAL_IND"));	

			
			// new feild Added
			cbsLoanPaidSch.setPrntLoanAcNo(rs.getString("PARENT_LOAN_AC_NO"));
			cbsLoanPaidSch.setCustomerId(rs.getString("CUSTOMER_ID"));
			cbsLoanPaidSch.setPrntCustId(rs.getString("PARENT_CUST_ID"));
			cbsLoanPaidSch.setIsprntLoan(rs.getString("IS_PARENT_LOAN"));
			cbsLoanPaidSch.setIsgroupLoan(rs.getString("IS_GROUP_LOAN"));		
			cbsLoanPaidSch.setCbsGroupId(rs.getString("CBS_GROUP_ID"));	
			// END 
						

			return cbsLoanPaidSch;
		}
	
	}
	
	private static final class CbsLoanSchMapper implements RowMapper<CbsLoanSchedules>{
		@Override
		public CbsLoanSchedules mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsLoanSchedules cbsLoanSch = new CbsLoanSchedules();
			
			cbsLoanSch.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			cbsLoanSch.setBranchCode(rs.getString("BRANCH_CODE"));	
			cbsLoanSch.setPrntLoanAcNo(rs.getString("parent_loan_ac_no"));
			cbsLoanSch.setCustomerId(rs.getString("CUSTOMER_ID"));
			cbsLoanSch.setPrntCustId(rs.getString("parent_cust_id"));
			cbsLoanSch.setIsprntLoan(rs.getString("is_parent_loan"));
			cbsLoanSch.setIsgroupLoan(rs.getString("is_group_loan"));
			cbsLoanSch.setIsFutureSch(rs.getString("is_future_sch"));
			cbsLoanSch.setSchType(rs.getString("SCH_TYPE"));
			cbsLoanSch.setSchStDate(rs.getDate("SCH_ST_DATE"));
			cbsLoanSch.setSchEndDate(rs.getDate("SCH_END_DATE"));
			cbsLoanSch.setCbsGroupId(rs.getString("CBS_GROUP_ID"));	
			cbsLoanSch.setComponentName(rs.getString("COMPONENT_NAME"));			
			cbsLoanSch.setComponentCcyCode(rs.getString("COMPONENT_CCY_CODE"));
			cbsLoanSch.setComponentLcyCode(rs.getString("COMPONENT_LCY_CODE"));
			cbsLoanSch.setAmtDue(rs.getLong("AMT_DUE"));
			cbsLoanSch.setAmtDueLcy(rs.getLong("AMT_DUE_LCY"));	
			

			// new feild Added
			cbsLoanSch.setPrntLoanAcNo(rs.getString("PARENT_LOAN_AC_NO"));
			cbsLoanSch.setCustomerId(rs.getString("CUSTOMER_ID"));
			cbsLoanSch.setPrntCustId(rs.getString("PARENT_CUST_ID"));
			cbsLoanSch.setIsprntLoan(rs.getString("IS_PARENT_LOAN"));
			cbsLoanSch.setIsgroupLoan(rs.getString("IS_GROUP_LOAN"));		
			cbsLoanSch.setCbsGroupId(rs.getString("CBS_GROUP_ID"));	
			cbsLoanSch.setIsFutureSch(rs.getString("IS_FUTURE_SCH"));
			// END 
						

			return cbsLoanSch;
		}
	
	}	
	
	@SuppressWarnings("unused")
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
	
	@SuppressWarnings("unused")
	private Map<String, String> getParamForObject(List<CbsLoanDetails> cbsLoanList) {
		Map<String, String> l_params = new HashMap<String, String>();
		
		for(int l_i=0;l_i<cbsLoanList.size();l_i++){
			l_params.put("param" + l_i, cbsLoanList.get(l_i).getLoanAcNo());			
		}		
		return l_params;
	}

	@Override
	public ServletContext getServletContext() {
		
		return this.servletContext;
	}

	@Override
	public void setServletContext(ServletContext p_servletContext) {
		servletContext=p_servletContext;
		
	}

}
