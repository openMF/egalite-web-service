package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.LoanPrePaymentDao;
import com.bfsi.mfi.entity.MfiMbsTxnLnprepayV;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("loanPrePaymentDao")
public class LoanPrePaymentJdbcDao  extends ReadOnlyMaintenanceJdbcDao<MfiMbsTxnLnprepayV> implements LoanPrePaymentDao{

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.PREPAY_QUERY_SELECT_ALL;
	}
	
	protected RowMapper<MfiMbsTxnLnprepayV> getPrePaymentMapper() {
		return new PrePaymentMapper();
	}	
	protected RowMapper<MfiMbsTxnLnprepayV> getRowMapper() {
		return new PrePaymentMapper();
	}
	
	private static final class PrePaymentMapper implements RowMapper<MfiMbsTxnLnprepayV> 
	{
		public MfiMbsTxnLnprepayV mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			MfiMbsTxnLnprepayV mfimbstxnlnprepayv=new MfiMbsTxnLnprepayV();
			
			mfimbstxnlnprepayv.setId(rs.getString("MBS_TXN_ID"));
			mfimbstxnlnprepayv.setAgendaId(rs.getString("AGENDA_ID"));
			mfimbstxnlnprepayv.setSeqNo(rs.getLong("SEQ_NO"));
			mfimbstxnlnprepayv.setTxnCode(rs.getString("TXN_CODE"));
			mfimbstxnlnprepayv.setCbsAcRefNo(rs.getString("CBS_AC_REF_NO"));
			mfimbstxnlnprepayv.setBranchCode(rs.getString("BRANCH_CODE"));
			mfimbstxnlnprepayv.setCustomerId(rs.getString("CUSTOMER_ID"));
			mfimbstxnlnprepayv.setCustomerFullName(rs.getString("CUSTOMER_FULL_NAME"));
			mfimbstxnlnprepayv.setAgentId(rs.getString("AGENT_ID"));
			mfimbstxnlnprepayv.setAgentName(rs.getString("AGENT_NAME"));
			mfimbstxnlnprepayv.setLocationCode(rs.getString("LOCATION_CODE"));
			mfimbstxnlnprepayv.setLocationDesc(rs.getString("LOCATION_DESC"));
			mfimbstxnlnprepayv.setAmountToBePrepaid(rs.getDouble("AMOUNT_TO_BE_PREPAID"));
			mfimbstxnlnprepayv.setPaidAmount(rs.getDouble("PAID_AMOUNT"));
			mfimbstxnlnprepayv.setTxnNarrative(rs.getString("TXN_NARRATIVE"));
			mfimbstxnlnprepayv.setTxnInitTime(rs.getTimestamp("TXN_INIT_TIME"));
			mfimbstxnlnprepayv.setTxnSyncTime(rs.getTimestamp("TXN_SYNC_TIME"));
			mfimbstxnlnprepayv.setTxnStatusDesc(rs.getString("TXN_STATUS_DESC"));
			mfimbstxnlnprepayv.setTxnErrCode(rs.getString("TXN_ERR_CODE"));
			mfimbstxnlnprepayv.setTxnErrMessage(rs.getString("TXN_ERR_MESSAGE"));

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
			mfimbstxnlnprepayv.setGeneratedSms(rs.getString("GENERATED_SMS"));
			mfimbstxnlnprepayv.setSmsMobileNo(rs.getString("SMS_MOBILE_NO"));
			mfimbstxnlnprepayv.setSmsContent(rs.getString("SMS_CONTENT"));
			mfimbstxnlnprepayv.setGeneratedRevr(rs.getString("GENERATED_REVR"));
			mfimbstxnlnprepayv.setFullPartInd(rs.getString("FULL_PART_IND"));
			mfimbstxnlnprepayv.setSyncType(rs.getString("SYNC_TYPE"));
			/*For Tag No : EGA-MN15-000020 End*/
			
			return mfimbstxnlnprepayv;
		}
	}
	
	
	public MfiMbsTxnLnprepayV get(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		//params.put("id1", id);
		//params.put("id2", id);
		return jdbcTemplate.queryForObject(ApplicationQuery.PREPAY_QUERY_SELECT_ALLTXN, params, getPrePaymentMapper());
	}
	
	@Override
	public MfiMbsTxnLnprepayV create(MfiMbsTxnLnprepayV entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MfiMbsTxnLnprepayV update(MfiMbsTxnLnprepayV entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MfiMbsTxnLnprepayV delete(MfiMbsTxnLnprepayV entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MfiMbsTxnLnprepayV authorize(MfiMbsTxnLnprepayV entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
