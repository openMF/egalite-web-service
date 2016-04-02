package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.LoanDetailsDao;
import com.bfsi.mfi.entity.LoanDetail;
import com.bfsi.mfi.entity.LoanDetailsServiceRequest;
import com.bfsi.mfi.entity.LoanPaidSchDetail;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

/**
 * 
 * @author Shabu
 *
 */
@Repository
public class LoanDetailsJdbcDao extends BaseJdbcDao implements LoanDetailsDao {
	
	
	@Override
	public List<LoanDetail> getLoans(LoanDetailsServiceRequest p_request) {
		LoggerUtil.ibsJobDebug("Getting Loan Details for agent: "+p_request.getAgentId());
		Map<String, Object> l_params = new HashMap<String, Object>();
		l_params.put("agentId", p_request.getAgentId());
		l_params.put("batchSize", Integer.valueOf(p_request.getBatchSize()));
		l_params.put("locCode", p_request.getLocCode());
		StringBuilder l_queryBuilder=new StringBuilder(ApplicationQuery.QUERY_GET_ALL_LOAN_FOR_AGENT);
		String l_delimiter="";
		if(!p_request.getRecvdLoans().isEmpty()){
			l_queryBuilder.append(" AND LOAN_AC_NO NOT IN(");
		}
		for(int l_i=0;l_i<p_request.getRecvdLoans().size();l_i++){
			l_params.put("param"+l_i, p_request.getRecvdLoans().get(l_i));
			l_queryBuilder.append(l_delimiter + ":param" + l_i);
			l_delimiter=",";
		}
		if(!p_request.getRecvdLoans().isEmpty()){
			l_queryBuilder.append(')');
		}
		l_queryBuilder.append(ApplicationQuery.QUERY_BATCH_STRING);
		List<LoanDetail> l_loansList=jdbcTemplate.query(l_queryBuilder.toString(), l_params, new LoanDetailMapper());
		return l_loansList == null?new ArrayList<LoanDetail>():l_loansList;
	}
	
	private static final class LoanDetailMapper implements RowMapper<LoanDetail>{

		@Override
		public LoanDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
			LoanDetail l_loan=new LoanDetail();
			l_loan.setLoanAccNo(rs.getString("LOAN_AC_NO"));
			l_loan.setBranchCode(rs.getString("BRANCH_CODE"));
			l_loan.setCustomerId(rs.getString("CUSTOMER_ID"));
			l_loan.setCustomerName(rs.getString("CUSTOMER_FULL_NAME"));
			
			l_loan.setParentCustId(rs.getString("PARENT_CUST_ID"));
			l_loan.setIsParentLoan(rs.getString("IS_PARENT_LOAN"));
			l_loan.setIsGrpLoan(rs.getString("IS_GROUP_LOAN"));
			
			
			l_loan.setParentLoanAcNo(rs.getString("PARENT_LOAN_AC_NO"));
			l_loan.setGroupId(rs.getString("GROUP_ID"));
			l_loan.setLocCode(rs.getString("LOC_CODE"));
			
			l_loan.setCreditOfficerCode(rs.getString("CREDIT_OFFICER_CODE"));
			//l_loan.setCreditOfficerName(rs.getString("CREDIT_OFFICER_NAME"));
			//l_loan.setGroupName(rs.getString("GROUP_NAME"));
			
			//l_loan.setLocName(rs.getString("LOC_NAME"));
			
			//l_loan.setGroupCode(rs.getString("GROUP_CODE"));
			//l_loan.setLoanStatus(rs.getString("LOAN_STATUS"));
			l_loan.setSanctionedDate(rs.getDate("SANCTIONED_DATE"));
			l_loan.setLastDisbursedDate(rs.getDate("LAST_DISBURSED_DATE"));
			l_loan.setDisbrType(rs.getString("DISBR_TYPE"));
			l_loan.setLoanAccCcy(rs.getString("LOAN_AC_CCY"));
			l_loan.setIsFullyDisbursed(rs.getString("IS_FULLY_DISBURSED"));
			l_loan.setSanctPrincAmt(rs.getDouble("SANCTIONED_PRINCIPAL_AMT"));
			l_loan.setDisbPrincAmt(rs.getDouble("DISBURSED_PRINCIPAL_AMT"));
			l_loan.setIntrRate(rs.getDouble("INTEREST_RATE"));
			l_loan.setIntrAccured(rs.getDouble("INTEREST_ACCRUED"));
			l_loan.setPrincRepaidAmt(rs.getDouble("PRINCIPAL_AMT_REPAID"));
			l_loan.setPrincOutstanding(rs.getDouble("PRINCIPAL_OUTSTANDING"));
			l_loan.setLastRepayDate(rs.getDate("LAST_REPAYMENT_DATE"));
			//l_loan.setRecordStatus(rs.getString("RECORD_STAT"));
			//l_loan.setCbsUploadJobId(rs.getString("CBS_UPLD_JOB_ID"));
			//l_loan.setSyncStatus(rs.getString("SYNC_STATUS"));
			//l_loan.setSyncTime(rs.getString("SYNC_TIME"));
			//l_loan.setIsAllocated(rs.getString("IS_ALLOCATED"));
			
			
			l_loan.setAgentId(rs.getString("AGENT_ID"));
						
			return l_loan;
		}
		
	}

	@Override
	public List<LoanPaidSchDetail> getLoanPaidSch(String p_loanAcNo , LoanDetailsServiceRequest p_request) {
		LoggerUtil.ibsJobDebug("Getting Loan Paid Sch Details for agent: "+p_request.getAgentId());
		List<LoanPaidSchDetail> l_loansPaidSchList = null;
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("agentId", p_request.getAgentId());
		l_params.put("locCode", p_request.getLocCode());
		l_params.put("loanAcNo", p_loanAcNo);
		l_loansPaidSchList = jdbcTemplate.query(ApplicationQuery.QUERY_GET_LOAN_PAID_SCH, l_params, new LoanPaidSchMapper());
		return l_loansPaidSchList == null?new ArrayList<LoanPaidSchDetail>():l_loansPaidSchList;
	}
	
	private static final class LoanPaidSchMapper implements RowMapper<LoanPaidSchDetail>{

		@Override
		public LoanPaidSchDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
			LoanPaidSchDetail l_loanPaidSch = new LoanPaidSchDetail();
			
			l_loanPaidSch.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			l_loanPaidSch.setBranchCode(rs.getString("BRANCH_CODE"));
			l_loanPaidSch.setParentLoanAcNo(rs.getString("PARENT_LOAN_AC_NO"));
			l_loanPaidSch.setCustomerId(rs.getString("CUSTOMER_ID"));
			l_loanPaidSch.setParentCustomerId(rs.getString("PARENT_CUST_ID"));
			l_loanPaidSch.setIsParentLoan(rs.getString("IS_PARENT_LOAN"));
			l_loanPaidSch.setIsGroupLoan(rs.getString("IS_GROUP_LOAN"));
			l_loanPaidSch.setGroupId(rs.getString("GROUP_ID"));
			l_loanPaidSch.setCustomerName(rs.getString("CUSTOMER_NAME"));
			l_loanPaidSch.setSchDueDate(rs.getDate("SCH_DUE_DATE"));
			l_loanPaidSch.setSchPaidDate(rs.getDate("SCH_PAID_DATE"));
			l_loanPaidSch.setStlmtCcyCode(rs.getString("SETTLEMENT_CCY_CODE"));
			l_loanPaidSch.setAmtSettled(rs.getDouble("AMT_SETTLED"));
			l_loanPaidSch.setFullPartialInd(rs.getString("FULL_PARTIAL_IND"));
			l_loanPaidSch.setAgentId(rs.getString("AGENT_ID"));
			l_loanPaidSch.setLocCode(rs.getString("LOCATION_CODE"));
			l_loanPaidSch.setDeviceId(rs.getString("DEVICE_ID"));			
		
						
			return l_loanPaidSch;
		}
		
	}
}
