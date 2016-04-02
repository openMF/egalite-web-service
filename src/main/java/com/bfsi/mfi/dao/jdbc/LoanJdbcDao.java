package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.bean.LoanBean;
import com.bfsi.mfi.dao.LoanDao;
import com.bfsi.mfi.entity.DisburseSchedule;
import com.bfsi.mfi.entity.Loan;
import com.bfsi.mfi.entity.LoanDetailView;
import com.bfsi.mfi.entity.LoanDetailsListView;
import com.bfsi.mfi.entity.RepaymentLiquidation;
import com.bfsi.mfi.entity.RepaymentSchedule;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.ApplicationUtil;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("loanDao")
public class LoanJdbcDao extends ReadOnlyMaintenanceJdbcDao<Loan> implements
		LoanDao {
	
	private static final String SYNC_STATUS_PEN = "P";
	private static final String SYNC_STATUS_NA = "NA";
	private static final String SYNC_STATUS_UPDATE = "U";
	
	private static final String FLAG_PAYMNT_PARTIAL = "Y";
	private static final String SYNC_STATUS_ACK = "A";
	
	@Override
	protected RowMapper<Loan> getRowMapper() {
		return new LoanMapper();
	}
	

	public RowMapper<Loan> getLoanAccountsMapper() {
		return new LoanAccountsMapper();
	}

	protected RowMapper<RepaymentSchedule> getRepaySchdlMapper() {
		return new RepaySchdlMapper();
	}

	
	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.LAC_QUERY_SELECT_ALL;
	}

	/**
	 * For getting list of loan ,disbursement, agent from loan_enrich table.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<LoanDetailsListView> getList() {
		String sql = ApplicationQuery.LAC_CUSTOMISE_QUERY_SELECT_ALL;//
		return jdbcTemplate.query(sql, (Map) null, new CustomiseLoanMapper());
	}

	
	/**  
	 * Geting loan base on search criteria.  
	 * **/
	@Override
	public List<LoanDetailsListView> getSearch(String loanAcNo, String brCode,
			String custId, String cfCode, String agtId, String locCode, String parentLoanAcNo, String parentCustID){
		
		LoanBean bean = new LoanBean();
		bean.setLOAN_AC_NO(loanAcNo);
		bean.setBRANCH_CODE(brCode);
		bean.setCUSTOMER_ID(custId);
		bean.setCREDIT_OFFICER_CODE(cfCode);
		bean.setAGENT_ID(agtId);
		bean.setLOCATION_CODE(locCode);
		bean.setPARENT_LOAN_AC_NO(parentLoanAcNo);
		bean.setPARENT_CUST_ID(parentCustID);
		
		Class objClass= bean.getClass();
		
		String query = ApplicationQuery.LOAN_QUERY_ALLWHERE;
		query = ApplicationUtil.getDynamicQuery(bean, objClass, query); 
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<LoanDetailsListView> loans = jdbcTemplate.query(query,
				(Map) null, new CustomiseLoanMapper());
		return (loans != null) ? loans : new ArrayList<LoanDetailsListView>();
		
	}
	
	
	
	protected String getSelectByPkQuery() {
		return null;  //ApplicationQuery.LAC_QUERY_SELECT_BY_PK;
	}

	//view
	public LoanDetailView getLoanView(String id) {
		String sql = ApplicationQuery.LAC_QUERY_SELECT_BY_PK;
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		return jdbcTemplate.queryForObject(sql, params, new ViewLoanMapper());
	}
	
	@Override
	public List<Loan> getLoanForCustomer(String customerId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("customerId", customerId);
		try {
			return jdbcTemplate.query(ApplicationQuery.LAC_QUERY_SELECT_LOAN, params,
					getLoanAccountsMapper());

		} catch (DataAccessException e) {
			LoggerUtil.ibsJobError("DataAccessException : MFI10001", e);
			return null;
		}

	}

	// Add RowMapper for loan details and agent_id from loan_enrich.//
	public static final class ViewLoanMapper implements RowMapper<LoanDetailView> {
		public LoanDetailView mapRow(ResultSet rs, int rowNum) throws SQLException {
			LoanDetailView loanDetailView = new LoanDetailView();

			loanDetailView.setId(rs.getString("LOAN_AC_NO"));
			loanDetailView.setBranchCode(rs.getString("branch_code"));
			loanDetailView.setCustomerId(rs.getString("customer_id"));
			loanDetailView.setCustomerFullName(rs.getString("customer_full_name"));
			
			loanDetailView.setParentLoanAcNo(rs.getString("parent_loan_ac_no"));//NEW
			loanDetailView.setParentCustId(rs.getString("parent_cust_id"));
			loanDetailView.setIsParentLoan(rs.getString("is_parent_loan"));
			loanDetailView.setIsGroupLoan(rs.getString("is_group_loan"));
			loanDetailView.setLoanType(rs.getString("Loan_type"));
			loanDetailView.setGroupType(rs.getString("Group_type"));//
			
			loanDetailView.setCreditOfficerCode(rs.getString("credit_officer_code"));
			loanDetailView.setCreditOfficerName(rs.getString("Credit_officer_name")); 
			loanDetailView.setAgentId(rs.getString("agent_id"));
			loanDetailView.setAgentName(rs.getString("agent_name"));
			loanDetailView.setLocationCode(rs.getString("location_code"));
			loanDetailView.setLocationDesc(rs.getString("location_desc"));
			loanDetailView.setAllocationByCode(rs.getString("allocation_by_code"));
			loanDetailView.setAllocationByName(rs.getString("allocation_by_name"));
			loanDetailView.setAllocationStatus(rs.getString("allocation_status"));
			loanDetailView.setGroupId(rs.getString("group_id"));
			//loanDetailView.setGroupCode(rs.getString("group_code"));
			
			loanDetailView.setSanctionedDate(BaseJdbcDao.getUtilDate(rs.getDate("sanctioned_date")));
			loanDetailView.setLastDisbursedDate(BaseJdbcDao.getUtilDate(rs.getDate("last_disbursed_date")));
			
			loanDetailView.setDisbrType(rs.getString("disbr_type"));
			loanDetailView.setLoanAcCcy(rs.getString("loan_ac_ccy"));
			loanDetailView.setIsFullyDisbursed(rs.getString("is_fully_disbursed"));
			
			loanDetailView.setInterestRate(rs.getDouble("interest_rate"));
			loanDetailView.setInterestAccured(rs.getDouble("interest_accrued"));
			loanDetailView.setPrincipalAmount(rs.getDouble("principal_amount"));
			loanDetailView.setPrincipalPaid(rs.getDouble("principal_paid"));
			loanDetailView.setPrincipalOutstanding(rs.getDouble("principal_outstanding"));
			
			loanDetailView.setLoanStatus(rs.getString("loan_status"));
			
			loanDetailView.setLastRepaymentDate(BaseJdbcDao.getUtilDate(rs.getDate("last_repayment_date")));
			
			loanDetailView.setRecordStat(rs.getString("record_stat"));
			loanDetailView.setCbsUpldJobId(rs.getString("cbs_upld_job_id"));
			//loanDetailView.setSyncStatus(rs.getString("sync_status"));
			//loanDetailView.setSyncTime(rs.getString("sync_time"));
			
			return loanDetailView;
		}
	}

	public static final class LoanMapper implements RowMapper<Loan> {
		public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
			Loan loan = new Loan();
		
			loan.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			loan.setCustomerId(rs.getString("CUSTOMER_ID"));
			loan.setCustomerName(rs.getString("CUSTOMER_NAME"));
			loan.setLocationName(rs.getString("LOCATION_NAME"));
			loan.setLocationId(rs.getString("LOCATION_ID"));
			loan.setNextRepaymentDate(rs.getDate("NEXT_REPAYMENT_DATE"));
			loan.setOverDueStatus(rs.getString("OVERDUE_STATUS"));
			loan.setDisbursementDate(rs.getDate("LAST_DISBR_DATE"));
			loan.setOverDueDate(rs.getDate("OVER_DUE_DATE"));
			loan.setSanctionedDate(rs.getDate("SANCTIONED_DATE"));
			loan.setGroupFlag(rs.getString("GROUP_FLAG"));
			loan.setGroupName(rs.getString("GROUP_NAME"));
			loan.setLastRepaymentDate(rs.getDate("LAST_REPAYMENT_DATE"));
			loan.setDisbursementStatus(rs.getString("DISBURSEMENT_STATUS"));
			loan.setGroupId(rs.getString("GROUP_ID"));
			loan.setAgentId(rs.getString("AGENT_ID"));
			loan.setSyncStatus(rs.getString("SYNC_STATUS"));
			loan.setCreditOfficer(rs.getString("CREDIT_OFFICER"));
			loan.setAmountSanctioned(rs.getDouble("AMOUNT_SANCTIONED"));
			loan.setAmtDisbursed(rs.getDouble("AMOUNT_DISBURSED"));
			loan.setBranchCode(rs.getString("BRANCH_CODE"));
			loan.setLoanAcCcy(rs.getString("LOAN_AC_CCY"));

			loan.getAgent().setId(rs.getString("AGTID")); // getting from loan
															// enrich table.
															 
		  return loan;
		}
	}
	
	// Add RowMapper for only loan details.
	public static final class OnlyLoanMapper implements RowMapper<Loan> {
		public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
			Loan loan = new Loan();
			loan.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			loan.setCustomerId(rs.getString("CUSTOMER_ID"));
			loan.setCustomerName(rs.getString("CUSTOMER_NAME"));
			loan.setLocationName(rs.getString("LOCATION_NAME"));
			loan.setLocationId(rs.getString("LOCATION_ID"));
			loan.setNextRepaymentDate(rs.getDate("NEXT_REPAYMENT_DATE"));
			loan.setOverDueStatus(rs.getString("OVERDUE_STATUS"));
			loan.setDisbursementDate(rs.getDate("LAST_DISBR_DATE"));
			loan.setOverDueDate(rs.getDate("OVER_DUE_DATE"));
			loan.setSanctionedDate(rs.getDate("SANCTIONED_DATE"));
			loan.setGroupFlag(rs.getString("GROUP_FLAG"));
			loan.setGroupName(rs.getString("GROUP_NAME"));
			loan.setLastRepaymentDate(rs.getDate("LAST_REPAYMENT_DATE"));
			loan.setDisbursementStatus(rs.getString("DISBURSEMENT_STATUS"));
			loan.setGroupId(rs.getString("GROUP_ID"));
			loan.setAgentId(rs.getString("AGENT_ID"));
			loan.setSyncStatus(rs.getString("SYNC_STATUS"));
			loan.setCreditOfficer(rs.getString("CREDIT_OFFICER"));
			loan.setAmountSanctioned(rs.getDouble("AMOUNT_SANCTIONED"));
			loan.setAmtDisbursed(rs.getDouble("AMOUNT_DISBURSED"));
			loan.setBranchCode(rs.getString("BRANCH_CODE"));
			loan.setLoanAcCcy(rs.getString("LOAN_AC_CCY"));

			return loan;
		}
	}

	/**
	 * RowMapper for get loan details from loan table, Disbursement amount and
	 * date from disburse
	 * 
	 * table and Agent_id from loan_enrich table base on conditions.
	 * 
	 */
	public static final class CustomiseLoanMapper implements RowMapper<LoanDetailsListView> {
		public LoanDetailsListView mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			LoanDetailsListView loanDetailsListView = new LoanDetailsListView();
			
			loanDetailsListView.setId(rs.getString("LOAN_AC_NO"));//id use loan_ac_no taken from Maintenance class.
			loanDetailsListView.setBranchCode(rs.getString("branch_code"));
			loanDetailsListView.setCustomerId(rs.getString("customer_id"));
			
			loanDetailsListView.setCreditOfficerCode(rs.getString("credit_officer_code"));
			loanDetailsListView.setAllocationStatus(rs.getString("allocation_status"));
			loanDetailsListView.setAgentId(rs.getString("agent_id"));
			loanDetailsListView.setLocationCode(rs.getString("location_code"));
			loanDetailsListView.setCurrency(rs.getString("Currency"));
			
			loanDetailsListView.setPrincipalAmount(rs.getDouble("principal_amount"));
			loanDetailsListView.setPrincipalPaid(rs.getDouble("principal_paid"));
			loanDetailsListView.setPrincipalOutstanding(rs.getDouble("principal_outstanding"));
			
			//parent_loan_ac_no,parent_cust_id,is_parent_loan,is_group_loan,
			loanDetailsListView.setParentLoanAcNo(rs.getString("parent_loan_ac_no"));
			loanDetailsListView.setParentCustId(rs.getString("parent_cust_id"));
			loanDetailsListView.setIsParentLoan(rs.getString("is_parent_loan"));
			loanDetailsListView.setIsGroupLoan(rs.getString("is_group_loan"));
		
			return loanDetailsListView;
		}
	}

	private static final class LoanAccountsMapper implements RowMapper<Loan> {
		public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
			Loan loan = new Loan();
			loan.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			loan.setSanctionedDate(rs.getDate("SANCTIONED_DATE"));
			return loan;
		}
	}

	@Override
	public List<Loan> getLoanDetails(String agentId, String batchSize) {
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("agentId", agentId);
		params.put("batchSize", Integer.valueOf(batchSize));		
		params.put("status", SYNC_STATUS_PEN);
		params.put("status2", SYNC_STATUS_NA);
		params.put("status3", SYNC_STATUS_UPDATE);/**NambiAK*/
		
		List<Loan> loans = jdbcTemplate.query(ApplicationQuery.LAC_QUERY_LOAN_DETAIL, params,
				new LoanDetailsMapper());
		return (loans != null) ? loans : new ArrayList<Loan>();
	}

	@Override
	public List<DisburseSchedule> getDisbrSchedules(String loanActNo) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("loanActNo", loanActNo);
		List<DisburseSchedule> disbrSchdls = jdbcTemplate.query(
				ApplicationQuery.LAC_QUERY_DISBURSE_SCHDLE, params, new DisbrScheduleMapper());

		return (disbrSchdls != null) ? disbrSchdls
				: new ArrayList<DisburseSchedule>();
	}

	@Override
	public List<RepaymentSchedule> getRepaySchedules(String loanAcNo) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", loanAcNo);
		List<RepaymentSchedule> repaySchdls = jdbcTemplate.query(
				ApplicationQuery.LAC_QUERY_REPAY_SCHDLE, params, new RepaySchdlMapper());

		return (repaySchdls != null) ? repaySchdls
				: new ArrayList<RepaymentSchedule>();
	}

	@Override
	public List<RepaymentLiquidation> getRepayLiquidation(String loanAcNo) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("loanActNo", loanAcNo);
		List<RepaymentLiquidation> repayLiq = jdbcTemplate.query(
				ApplicationQuery.LAC_QUERY_REPAY_LIQ, params, new RepayLiqMapper());

		return (repayLiq != null) ? repayLiq
				: new ArrayList<RepaymentLiquidation>();
	}

	@Override
	public void updateLoanStatus(List<String> loanAccNoList, String status) {
		Map<String, String> params = new HashMap<String, String>(
				loanAccNoList.size());
		params.put("status", status);
		StringBuilder sqlQuery = new StringBuilder(
				ApplicationQuery.LAC_QUERY_UPDATE);//"UPDATE IFTB_LOAN_DETAILS SET SYNC_STATUS= :status WHERE LOAN_AC_NO IN ("
		String delimiter = "";
		/**
		 * 	
		 * @Developer Jyoti/Shabu
		 * @Bug: 300
		 */
		
		List<String> filteredLoansList=new ArrayList<String>();
		for(String accNo: loanAccNoList){
			if(!status.equals(SYNC_STATUS_ACK) || shouldChangeStatus(accNo))
				filteredLoansList.add(accNo);
		}
		
		boolean hasRecordsToUpdate = filteredLoansList.isEmpty()?false:true;
				
		for (int i = 0; i < filteredLoansList.size(); i++) {
			/**
			 * 	
			 * @Developer Jyoti/Shabu
			 * @Bug: 300
			 */
			
			
			//if(shouldChangeStatus(loanAccNoList.get(i))){
				hasRecordsToUpdate =true;
				params.put("param" + i, filteredLoansList.get(i));
				sqlQuery.append(delimiter + ":param" + i);
				
				if (i == 0) {
					delimiter = delimiter + ",";
				}
			//}
		}
		String query = sqlQuery.toString() + ")";
		
		/**
		 * 	
		 * @Developer Jyoti/Shabu
		 * @Bug: 300
		 */
		if(hasRecordsToUpdate)
		jdbcTemplate.update(query, params);
	}

	private static final class RepaySchdlMapper implements
			RowMapper<RepaymentSchedule> {

		@Override
		public RepaymentSchedule mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			RepaymentSchedule repaySchdl = new RepaymentSchedule();
			repaySchdl.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			repaySchdl.setBranchCode(rs.getString("BRANCH_CODE"));
			repaySchdl.setSettlementCcy(rs.getString("SETTLEMENT_CCY"));
			repaySchdl.setComponentName(rs.getString("COMPONENT_NAME"));
			/* repaySchdl.setScheduleType(rs.getString("SCHEDULE_TYPE")); */
			repaySchdl.setScheduleStDate(BaseJdbcDao.getUtilDate(rs
					.getDate("SCHEDULE_ST_DATE")));
			repaySchdl.setScheduleDueDate(BaseJdbcDao.getUtilDate(rs
					.getDate("SCHEDULE_DUE_DATE")));
			repaySchdl.setAmountDue(rs.getDouble("AMOUNT_DUE"));
			repaySchdl.setAdjAmount(rs.getDouble("ADJ_AMOUNT"));
			repaySchdl.setAmountSettled(rs.getDouble("AMOUNT_SETTLED"));
			repaySchdl.setAmountOverDue(rs.getDouble("AMOUNT_OVERDUE"));
			repaySchdl.setAccruedAmount(rs.getDouble("ACCRUED_AMOUNT"));

			repaySchdl.setLcyEquivalent(rs.getDouble("LCY_EQUIVALENT"));
			return repaySchdl;
		}

	}

	private static final class RepayLiqMapper implements
			RowMapper<RepaymentLiquidation> {
		public RepaymentLiquidation mapRow(ResultSet rs, int rowNum)
				throws SQLException {

			RepaymentLiquidation repayLiq = new RepaymentLiquidation();
			repayLiq.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			repayLiq.setBranchCode(rs.getString("BRANCH_CODE"));
			repayLiq.setValueDate(BaseJdbcDao.getUtilDate(rs
					.getDate("VALUE_DATE")));
			repayLiq.setExecutionDate(BaseJdbcDao.getUtilDate(rs
					.getDate("EXECUTION_DATE")));
			repayLiq.setPaymentStatus(rs.getString("PAYMENT_STATUS"));
			repayLiq.setSettleMode(rs.getString("SETTLE_MODE"));
			repayLiq.setSettleCurrency(rs.getString("SETTLE_CCY"));
			repayLiq.setSettleAmont(rs.getDouble("SETTLE_AMOUNT"));
			repayLiq.setEventSeqNum(rs.getDouble("EVENT_SEQ_NO"));
			return repayLiq;
		}
	}

	private static final class DisbrScheduleMapper implements
			RowMapper<DisburseSchedule> {
		public DisburseSchedule mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			DisburseSchedule disbrSchedule = new DisburseSchedule();
			disbrSchedule.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			disbrSchedule.setBranchCode(rs.getString("BRANCH_CODE"));
			disbrSchedule.setComponentName(rs.getString("COMPONENT_NAME"));
			disbrSchedule.setScheduleStDate(BaseJdbcDao.getUtilDate(rs
					.getDate("SCHEDULE_ST_DATE")));
			disbrSchedule.setScheduleDueDate(BaseJdbcDao.getUtilDate(rs
					.getDate("SCHEDULE_DUE_DATE")));
			disbrSchedule.setAmountToDisbr(rs.getDouble("AMOUNT_TO_DISBR"));
			disbrSchedule.setdType(rs.getString("DTYPE"));
			disbrSchedule.setManualAmtTrans(rs.getDouble("MANUAL_AMT_DISBR"));
			disbrSchedule.setCurDisbrAmt(rs.getDouble("CUR_DISBR_AMT"));
			disbrSchedule.setAmtDisbursed(rs.getDouble("AMT_DISBURSED"));
			return disbrSchedule;
		}
	}

	private static final class LoanDetailsMapper implements RowMapper<Loan> {
		public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
			Loan loan = new Loan();
			loan.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			loan.setCustomerId(rs.getString("CUSTOMER_ID"));
			loan.setCustomerName(rs.getString("CUSTOMER_NAME"));
			loan.setLocationName(rs.getString("LOCATION_NAME"));
			loan.setLocationId(rs.getString("LOCATION_ID"));
			loan.setNextRepaymentDate(BaseJdbcDao.getUtilDate(rs
					.getDate("NEXT_REPAYMENT_DATE")));
			loan.setOverDueStatus(rs.getString("OVERDUE_STATUS"));
			loan.setDisbursementDate(BaseJdbcDao.getUtilDate(rs
					.getDate("LAST_DISBR_DATE")));
			loan.setOverDueDate(BaseJdbcDao.getUtilDate(rs
					.getDate("OVER_DUE_DATE")));
			loan.setSanctionedDate(BaseJdbcDao.getUtilDate(rs
					.getDate("SANCTIONED_DATE")));
			loan.setGroupFlag(rs.getString("GROUP_FLAG"));
			loan.setGroupName(rs.getString("GROUP_NAME"));
			loan.setLastRepaymentDate(BaseJdbcDao.getUtilDate(rs
					.getDate("LAST_REPAYMENT_DATE")));
			loan.setDisbursementStatus(rs.getString("DISBURSEMENT_STATUS"));
			loan.setGroupId(rs.getString("GROUP_ID"));
			loan.setAmtDisbursed(rs.getDouble("AMOUNT_DISBURSED"));
			loan.setPrincOutstand(rs.getDouble("PRINC_OUTSTAND"));
			loan.setAmountSanctioned(rs.getDouble("AMOUNT_SANCTIONED"));
			loan.setLoanAcCcy(rs.getString("LOAN_AC_CCY"));
			loan.setBranchCode(rs.getString("BRANCH_CODE"));
			return loan;
		}
	}

	@Override
	public List<Loan> getDetaisForLoan(String customerId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("customerId", customerId);
		List<Loan> loans = jdbcTemplate.query(ApplicationQuery.LAC_QUERY_SELECT_LOAN, params,
				new LoanMapper());
		return (loans != null) ? loans : new ArrayList<Loan>();
	}
/**
 * 	
 * @Developer Jyoti/Shabu
 * @Bug: 300
 */
private boolean shouldChangeStatus(String p_accNo){
		
		int count = 0;
		Map<String, String> params = new HashMap<String, String>();
		params.put("loanAccNo",p_accNo );
		params.put("flag", FLAG_PAYMNT_PARTIAL);
		//params.put("status", "A");
		count = jdbcTemplate.queryForInt(ApplicationQuery.LAC_QUERY_SHOULD_CHANGE_STATUS, params);
		return count >0 ? false:true;
	}

}
