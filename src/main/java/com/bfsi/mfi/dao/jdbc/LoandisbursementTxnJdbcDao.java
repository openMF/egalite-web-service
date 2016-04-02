package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.LoanDisbursementTxnDao;
import com.bfsi.mfi.entity.MfiMbsTxnLndisbrV;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("loanDisbursementTxnDao")
public class LoandisbursementTxnJdbcDao extends ReadOnlyMaintenanceJdbcDao<MfiMbsTxnLndisbrV> implements LoanDisbursementTxnDao 
{
	
	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.DISBTXN_QUERY_SELECT_ALL;
	}

	@Override
	protected RowMapper<MfiMbsTxnLndisbrV> getRowMapper() {
		return new DisbursementTxnMapper();
	}	
	
/*	protected RowMapper<MfiMbsTxnLndisbrV> getDisbursementMapper() {
		return new DisbursementTxnMapper();
	}	
	*/
	private static final class DisbursementTxnMapper implements RowMapper<MfiMbsTxnLndisbrV> 
	{
		public MfiMbsTxnLndisbrV mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			MfiMbsTxnLndisbrV mfimbstxnlndisbr = new MfiMbsTxnLndisbrV();
			/*disbursementTxn.setTxnId(rs.getString(1));
			disbursementTxn.setTxnNarrative(rs.getString(2));
			disbursementTxn.setAmount(rs.getDouble(3));
			disbursementTxn.setTxnTimestamp(rs.getDate(4));
			disbursementTxn.setTxnType(rs.getString(5));
			disbursementTxn.setAgentId(rs.getString(6)+" "+rs.getString(7));
			disbursementTxn.setLoanAcNo(rs.getString(8));
			disbursementTxn.setSyncTime(rs.getDate(9));
			disbursementTxn.setCustomerId(rs.getString(10));
			disbursementTxn.setDeviceId(rs.getString(11));
			disbursementTxn.setAuthStatus(rs.getString(12));
			disbursementTxn.setTxnStatus(rs.getString(13));
			disbursementTxn.setTxnCcy(rs.getString(14));
			return disbursementTxn;*/
			//mfimbstxnlndisbr.setMbsTxnId(rs.getString(1));
			//mfimbstxnlndisbr.setMbsTxnId(rs.getString("MBS_TXN_ID"));
			mfimbstxnlndisbr.setId(rs.getString("MBS_TXN_ID"));
			mfimbstxnlndisbr.setAgendaId(rs.getString("AGENDA_ID"));
			mfimbstxnlndisbr.setSeqNo(rs.getLong("SEQ_NO"));
			mfimbstxnlndisbr.setTxnCode(rs.getString("TXN_CODE"));
			mfimbstxnlndisbr.setCbsAcRefNo(rs.getString("CBS_AC_REF_NO"));
			mfimbstxnlndisbr.setBranchCode(rs.getString("BRANCH_CODE"));
			mfimbstxnlndisbr.setCustomerId(rs.getString("CUSTOMER_ID"));
			mfimbstxnlndisbr.setCustomerFullName(rs.getString("CUSTOMER_FULL_NAME"));
			mfimbstxnlndisbr.setAgentId(rs.getString("AGENT_ID"));
			mfimbstxnlndisbr.setAgentName(rs.getString("AGENT_NAME"));
			mfimbstxnlndisbr.setLocationCode(rs.getString("LOCATION_CODE"));
			mfimbstxnlndisbr.setLocationDesc(rs.getString("LOCATION_DESC"));
			mfimbstxnlndisbr.setAmountToDisburse(rs.getDouble("AMOUNT_TO_DISBURSE"));
			mfimbstxnlndisbr.setDisbursedAmount(rs.getDouble("DISBURSED_AMOUNT"));
			mfimbstxnlndisbr.setTxnNarrative(rs.getString("TXN_NARRATIVE"));
			mfimbstxnlndisbr.setTxnInitTime(rs.getTimestamp("TXN_INIT_TIME"));
			mfimbstxnlndisbr.setTxnSyncTime(rs.getTimestamp("TXN_SYNC_TIME"));
			mfimbstxnlndisbr.setTxnStatusDesc(rs.getString("TXN_STATUS_DESC"));
			mfimbstxnlndisbr.setTxnErrCode(rs.getString("TXN_ERR_CODE"));
			mfimbstxnlndisbr.setTxnErrMessage(rs.getString("TXN_ERR_MESSAGE"));
		//	mfimbstxnlndisbr.setParentLoanAcNo(rs.getString("PARENT_LOAN_AC_NO"));
			/*For Tag No : EGA-MN15-000020 Starts*/
			mfimbstxnlndisbr.setGeneratedSms(rs.getString("GENERATED_SMS"));
			mfimbstxnlndisbr.setSmsMobileNo(rs.getString("SMS_MOBILE_NO"));
			mfimbstxnlndisbr.setSmsContent(rs.getString("SMS_CONTENT"));
			mfimbstxnlndisbr.setGeneratedRevr(rs.getString("GENERATED_REVR"));
			mfimbstxnlndisbr.setFullPartInd(rs.getString("FULL_PART_IND"));
			mfimbstxnlndisbr.setSyncType(rs.getString("SYNC_TYPE"));
			/*For Tag No : EGA-MN15-000020 End*/
			
            return mfimbstxnlndisbr;
			
		}
	}

	@Override
	public MfiMbsTxnLndisbrV get(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
       // params.put("id1", id);
		//params.put("id2", id);
		return jdbcTemplate.queryForObject(ApplicationQuery.DISBTXN_QUERY_SELECT_ALL_DISB, params, getRowMapper());
	}

	@Override
	public MfiMbsTxnLndisbrV create(MfiMbsTxnLndisbrV entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MfiMbsTxnLndisbrV update(MfiMbsTxnLndisbrV entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MfiMbsTxnLndisbrV delete(MfiMbsTxnLndisbrV entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MfiMbsTxnLndisbrV authorize(MfiMbsTxnLndisbrV entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<MfiMbsTxnLndisbrV> getchildLoan(String cbsAcRefNo){

			Map<String, String> params = new HashMap<String, String>();
			params.put("cbsAcRefNo", cbsAcRefNo);

			List<MfiMbsTxnLndisbrV> childLoan = jdbcTemplate.query(
					ApplicationQuery.CHILD_QUERY_SELECT_ALL, params, new ChildLoanMapper());

			return ((childLoan != null) ? childLoan
					: new ArrayList<MfiMbsTxnLndisbrV>());
	}

	private static final class ChildLoanMapper implements RowMapper<MfiMbsTxnLndisbrV> {
	public MfiMbsTxnLndisbrV mapRow(ResultSet rs, int rowNum) throws SQLException {
		MfiMbsTxnLndisbrV childLoanAc = new MfiMbsTxnLndisbrV();
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
