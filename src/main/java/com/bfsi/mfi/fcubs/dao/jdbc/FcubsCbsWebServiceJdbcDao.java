package com.bfsi.mfi.fcubs.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.jdbc.BaseJdbcDao;
import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.fcubs.dao.FcubsCbsWebServiceDao;
import com.bfsi.mfi.rest.constants.ServiceConstants;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("fcubsCbsWebDao")
public class FcubsCbsWebServiceJdbcDao extends BaseJdbcDao implements
		FcubsCbsWebServiceDao 
{
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*private static final String QUERY_SELECT_TRANSACTION = "SELECT TXN_ID,TXN_TIMESTAMP,TXN_TYPE,AGENT_ID,LOAN_AC_NO,CUSTOMER_ID,AUTH_STATUS,TXN_STATUS,TXN_AMOUNT,TXN_CCY,BRANCH_CODE"
			+ " FROM IFTB_TRANSACTIONS WHERE TXN_STATUS=:status AND ROWNUM <= 1 ORDER BY TXN_ID FOR UPDATE ";*/
	
	/* Vishal Start */	
	private static final String QUERY_SELECT_TRANSACTION = "SELECT TXN_ID,TXN_TIMESTAMP,TXN_TYPE,AGENT_ID,LOAN_AC_NO,CUSTOMER_ID,AUTH_STATUS,TXN_STATUS,TXN_AMOUNT,TXN_CCY,BRANCH_CODE"
			+ " FROM IFTB_TRANSACTIONS WHERE TXN_STATUS=:status AND TXN_TYPE NOT IN ('C','M','T') AND ROWNUM <= 1 ORDER BY TXN_ID FOR UPDATE "; 
	/* Vishal End */
	private static final String QUERY_UPDATE_TRANSACTION = "UPDATE IFTB_TRANSACTIONS SET TXN_STATUS=:status1 WHERE TXN_ID=:txnId ";

	private static final String QUERY_SELECT_REPAYMENT = "SELECT TXN_NARRATIVE FROM IFTB_REPAYMENT WHERE TXN_ID=:txnId ";

	private static final String QUERY_SELECT_DISBURSEMENT = "SELECT TXN_NARRATIVE FROM IFTB_DISBURSEMENT WHERE TXN_ID=:txnId";

	private static final String QUERY_UPDATE_ACKTXN = "UPDATE IFTB_TRANSACTIONS SET TXN_STATUS=:status WHERE TXN_ID=:txnId ";

	private static final String QUERY_UPDATE_PROCESSINGTXN = "UPDATE IFTB_TRANSACTIONS SET TXN_STATUS=:readyStatus WHERE TXN_STATUS=:processStatus ";

	private static final String QUERY_UPDATE_TXNSTATUS = "UPDATE IFTB_TRANSACTIONS SET TXN_STATUS=:readyStatus WHERE TXN_ID=:txnId AND TXN_STATUS=:processStatus ";

	private static final String QUERY_UPDATE_TXNERROR = "UPDATE IFTB_TRANSACTIONS SET TXN_ERROR=:errorDesc WHERE TXN_ID=:txnId ";
	
	

	private static final class TransactionMapper implements
			RowMapper<AgentTransaction> {

		public AgentTransaction mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			AgentTransaction agentTrans = new AgentTransaction();
			agentTrans.setTxnId(rs.getString("TXN_ID"));
			agentTrans.setTxnTimestamp(BaseJdbcDao.getUtilDate(rs
					.getDate("TXN_TIMESTAMP")));
			agentTrans.setTxnType(rs.getString("TXN_TYPE"));
			agentTrans.setAgentId(rs.getString("AGENT_ID"));
			agentTrans.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			agentTrans.setCustomerId(rs.getString("CUSTOMER_ID"));
			agentTrans.setAuthStatus(rs.getString("AUTH_STATUS"));
			agentTrans.setTxnStatus(Integer.valueOf(rs.getString("TXN_STATUS")));
			agentTrans.setTxnAmount(rs.getDouble("TXN_AMOUNT"));
			agentTrans.setTxnCcy(rs.getString("TXN_CCY"));
			agentTrans.setBranchCode(rs.getString("BRANCH_CODE"));
			return agentTrans;
		}
	}

	@Override
	public void updateStatusToReady() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("readyStatus", ServiceConstants.READY_TO_CBS);
		params.put("processStatus", ServiceConstants.PROCESSED_STATUS);
		jdbcTemplate.update(QUERY_UPDATE_PROCESSINGTXN, params);
	}

	@Override
	public AgentTransaction uploadTxnForCbs() {
		AgentTransaction txn = null;
		Map<String, String> params = new HashMap<String, String>();
		params.put("status", ServiceConstants.READY_TO_CBS);
		try {
			txn = jdbcTemplate.queryForObject(QUERY_SELECT_TRANSACTION, params,
					new TransactionMapper());
		} catch (DataAccessException e) {
			//LoggerUtil.ibsJobError("DataAccessException : MFI10001", e);
			return null;
		}
		return txn;

	}

	@Override
	public void updateTxnForCbs(String txnId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("status1", ServiceConstants.PROCESSED_STATUS);
		params.put("txnId", txnId);
		jdbcTemplate.update(QUERY_UPDATE_TRANSACTION, params);
	}

	@Override
	public String getTxnNarrativeForRepay(String txnId) {
		Map<String, String> params = new HashMap<String, String>();
		String txnNarrative = null;
		params.put("txnId", txnId);
		try {
			txnNarrative = jdbcTemplate.queryForObject(QUERY_SELECT_REPAYMENT,
					params, String.class);
		} catch (DataAccessException e) {
			//LoggerUtil.ibsJobError("DataAccessException : MFI10001", e);
			return null;
		}
		return txnNarrative;
	}

	@Override
	public String getTxnNarrativeForDisbr(String txnId) {
		Map<String, String> params = new HashMap<String, String>();
		String txnNarrative = null;
		params.put("txnId", txnId);
		try {
			txnNarrative = jdbcTemplate.queryForObject(
					QUERY_SELECT_DISBURSEMENT, params, String.class);
		} catch (DataAccessException e) {
			//LoggerUtil.ibsJobError("DataAccessException : MFI10001", e);
			return null;
		}
		return txnNarrative;
	}

	@Override
	public void updateTxnWithCbsRes(String txnId, String status) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("status", status);
		params.put("txnId", txnId);
		jdbcTemplate.update(QUERY_UPDATE_ACKTXN, params);

	}

	@Override
	public void updateStatusToReady(String txnId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("readyStatus", ServiceConstants.READY_TO_CBS);
		params.put("processStatus", ServiceConstants.PROCESSED_STATUS);
		params.put("txnId", txnId);
		jdbcTemplate.update(QUERY_UPDATE_TXNSTATUS, params);

	}

	@Override
	public void updateTxnWithErrorMsg(String errorDesc, String txnId) {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("txnId", txnId);
		/* Vishal Start */
		if(errorDesc != null){
			if(errorDesc.trim().length() > 150){
				errorDesc = errorDesc.trim().substring(0, 145) + "...";
				params.put("errorDesc", errorDesc);
				
			} else {
				params.put("errorDesc", errorDesc.trim());
				
			}
			
		} else {
			params.put("errorDesc", "");
			
		}
		
		/* Vishal End */
		//params.put("errorDesc", errorDesc);
		jdbcTemplate.update(QUERY_UPDATE_TXNERROR, params);
	}

	
}
