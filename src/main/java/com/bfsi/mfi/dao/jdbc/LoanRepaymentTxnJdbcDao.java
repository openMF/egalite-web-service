package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.LoanRepaymentTxnDao;
import com.bfsi.mfi.entity.MfiMbsTxnLnrepayV;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("loanRepaymentTxnDao")
public class LoanRepaymentTxnJdbcDao  extends ReadOnlyMaintenanceJdbcDao<MfiMbsTxnLnrepayV> implements LoanRepaymentTxnDao  {

	

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.REPTXN_QUERY_SELECT_ALL;
	}

	
	protected RowMapper<MfiMbsTxnLnrepayV> getRepaymantMapper() {
		return new RepaymentMapper();
	}	
	
	protected RowMapper<MfiMbsTxnLnrepayV> getRowMapper() {
		return new RepaymentMapper();
	}	
	
	private static final class RepaymentMapper implements RowMapper<MfiMbsTxnLnrepayV> 
	{
		public MfiMbsTxnLnrepayV mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			MfiMbsTxnLnrepayV mfimbstxnlnrepayv=new MfiMbsTxnLnrepayV();
			
			mfimbstxnlnrepayv.setId(rs.getString("MBS_TXN_ID"));
			mfimbstxnlnrepayv.setAgendaId(rs.getString("AGENDA_ID"));
			mfimbstxnlnrepayv.setSeqNo(rs.getLong("SEQ_NO"));
			mfimbstxnlnrepayv.setTxnCode(rs.getString("TXN_CODE"));
			mfimbstxnlnrepayv.setCbsAcRefNo(rs.getString("CBS_AC_REF_NO"));
			mfimbstxnlnrepayv.setBranchCode(rs.getString("BRANCH_CODE"));
			mfimbstxnlnrepayv.setCustomerId(rs.getString("CUSTOMER_ID"));
			mfimbstxnlnrepayv.setCustomerFullName(rs.getString("CUSTOMER_FULL_NAME"));
			mfimbstxnlnrepayv.setAgentId(rs.getString("AGENT_ID"));
			mfimbstxnlnrepayv.setAgentName(rs.getString("AGENT_NAME"));
			mfimbstxnlnrepayv.setLocationCode(rs.getString("LOCATION_CODE"));
			mfimbstxnlnrepayv.setLocationDesc(rs.getString("LOCATION_DESC"));
			mfimbstxnlnrepayv.setRepaymentAmountDue(rs.getDouble("REPAYMENT_AMOUNT_DUE"));
			mfimbstxnlnrepayv.setSettledAmount(rs.getDouble("SETTLED_AMOUNT"));
			mfimbstxnlnrepayv.setTxnNarrative(rs.getString("TXN_NARRATIVE"));
			mfimbstxnlnrepayv.setTxnInitTime(rs.getTimestamp("TXN_INIT_TIME"));
			mfimbstxnlnrepayv.setTxnSyncTime(rs.getTimestamp("TXN_SYNC_TIME"));
			mfimbstxnlnrepayv.setTxnStatusDesc(rs.getString("TXN_STATUS_DESC"));
		//	mfimbstxnlnrepayv.setParentLoanAcNo(rs.getString("PARENT_LOAN_AC_NO"));
			

			/*repaymentTxn.setTxnId(rs.getString(1));
			repaymentTxn.setTxnNarrative(rs.getString(2));
			repaymentTxn.setAmount(rs.getDouble(3));
			repaymentTxn.setRepaymentInst(rs.getString(4));
			repaymentTxn.setTxnTimestamp(rs.getDate(5));
			repaymentTxn.setTxnType(rs.getString(6));
			repaymentTxn.setAgentId(rs.getString(7)+" "+rs.getString(8));
			repaymentTxn.setLoanAcNo(rs.getString(9));
			repaymentTxn.setSyncTime(rs.getDate(10));
			repaymentTxn.setCustomerId(rs.getString(11));
			repaymentTxn.setDeviceId(rs.getString(12));
			repaymentTxn.setAuthStatus(rs.getString(13));
			repaymentTxn.setTxnStatus(rs.getString(14));
			repaymentTxn.setTxnCcy(rs.getString(15));*/
			
			/*For Tag No : EGA-MN15-000020 Starts*/
			mfimbstxnlnrepayv.setGeneratedSms(rs.getString("GENERATED_SMS"));
			mfimbstxnlnrepayv.setSmsMobileNo(rs.getString("SMS_MOBILE_NO"));
			mfimbstxnlnrepayv.setSmsContent(rs.getString("SMS_CONTENT"));
			mfimbstxnlnrepayv.setGeneratedRevr(rs.getString("GENERATED_REVR"));
			mfimbstxnlnrepayv.setFullPartInd(rs.getString("FULL_PART_IND"));
			mfimbstxnlnrepayv.setSyncType(rs.getString("SYNC_TYPE"));
			/*For Tag No : EGA-MN15-000020 End*/
			return mfimbstxnlnrepayv;
		}
	}

	public MfiMbsTxnLnrepayV get(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		//params.put("id1", id);
		//params.put("id2", id);
		return jdbcTemplate.queryForObject(ApplicationQuery.REPTXN_QUERY_SELECT_ALL_REPAY, params, getRepaymantMapper());
	}


	@Override
	public MfiMbsTxnLnrepayV create(MfiMbsTxnLnrepayV entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MfiMbsTxnLnrepayV update(MfiMbsTxnLnrepayV entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MfiMbsTxnLnrepayV delete(MfiMbsTxnLnrepayV entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MfiMbsTxnLnrepayV authorize(MfiMbsTxnLnrepayV entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MfiMbsTxnLnrepayV> getchildLoan(String cbsAcRefNo){

			Map<String, String> params = new HashMap<String, String>();
			params.put("cbsAcRefNo", cbsAcRefNo);

			List<MfiMbsTxnLnrepayV> childLoan = jdbcTemplate.query(
					ApplicationQuery.CHILDREPAY_QUERY_SELECT_ALL, params, new ChildLoanMapper());

			return ((childLoan != null) ? childLoan
					: new ArrayList<MfiMbsTxnLnrepayV>());
	}

	private static final class ChildLoanMapper implements RowMapper<MfiMbsTxnLnrepayV> {
	public MfiMbsTxnLnrepayV mapRow(ResultSet rs, int rowNum) throws SQLException {
		MfiMbsTxnLnrepayV childLoanAc = new MfiMbsTxnLnrepayV();
	childLoanAc.setParentLoanAcNo(rs.getString("PARENT_LOAN_AC_NO"));
	childLoanAc.setCustomerId(rs.getString("CUSTOMER_ID"));
	childLoanAc.setParentCustId(rs.getString("PARENT_CUST_ID"));
	childLoanAc.setIsParentLoan(rs.getString("IS_PARENT_LOAN"));
	childLoanAc.setIsGroupLoan(rs.getString("IS_GROUP_LOAN"));
	childLoanAc.setLoanACNo(rs.getString("LOAN_AC_NO"));
	return childLoanAc;
}
	}

}
