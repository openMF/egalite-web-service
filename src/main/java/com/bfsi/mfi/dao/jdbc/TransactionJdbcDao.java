package com.bfsi.mfi.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.TransactionDao;
import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.entity.Disbursement;
import com.bfsi.mfi.entity.Repayment;
import com.bfsi.mfi.entity.TransactionServiceResponse;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("transactionDao")
public class TransactionJdbcDao extends MaintenanceJdbcDao<AgentTransaction>
		implements TransactionDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final String RECEIVED_STATUS = "RECEIVED";
	private static final String PENDING_STATUS = "PENDING";

	
	/**Shabu - Start
	 * Bug: 300
	 * */
	private static final String FLAG_PAYMNT_FULL = "N";
	private static final String FLAG_PAYMNT_PARTIAL = "Y";
	/**Shabu - End
	 * Bug: 300
	 * */


	
	private int row_count =0;
	/**Shabu - End
	 * Bug: 300
	 * */
	
	@Override
	protected AgentTransactionMapper getRowMapper() {
		return new AgentTransactionMapper();
	}

	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectAllQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectByPkQuery() {

		return ApplicationQuery.TRANS_QUERY_SELECT_BY_PK;
	}

	private static final class AgentTransactionMapper implements
			RowMapper<AgentTransaction> {
		
		public AgentTransaction mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			
			AgentTransaction agentTrans = new AgentTransaction();
			agentTrans.setTxnId(rs.getString("TXN_ID"));
			agentTrans.setSessionId(rs.getString("SESSION_ID"));
			agentTrans.setSyncStatus(rs.getString("STATUS"));
			return agentTrans;
		}
	}

	@Override
	public void updateTxnStatus(String txn_id) 
	{
		logger.info("updateTxnStatus started");
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", txn_id);
			params.put("status", PENDING_STATUS);
			params.put("status1", RECEIVED_STATUS);
			jdbcTemplate.update(ApplicationQuery.TRANS_QUERY_UPDATE_TXNSTATUS, params);
			logger.info("update Txn Status success");
		}
		catch(Exception e)
		{
			logger.error("updating  Txn Status is failed ");
		}
		logger.info("update Txn Status Completed");
	}

	@Override
	public void insertTransactions(List<AgentTransaction> txn,
			List<Repayment> repaytxn, List<Disbursement> disbursetxn) {

		logger.info("insertTransactions started");
		SqlParameterSource[] txnParams = SqlParameterSourceUtils
				.createBatch(txn.toArray());

		SqlParameterSource[] repayTxnParms = SqlParameterSourceUtils
				.createBatch(repaytxn.toArray());

		SqlParameterSource[] disTxnParams = SqlParameterSourceUtils
				.createBatch(disbursetxn.toArray());

		try
		{
			jdbcTemplate.batchUpdate(ApplicationQuery.TRANS_QUERY_INSERT_TRANS, txnParams);
			jdbcTemplate.batchUpdate(ApplicationQuery.TRANS_QUERY_INSERT_REPAY, repayTxnParms);
			jdbcTemplate.batchUpdate(ApplicationQuery.TRANS_QUERY_INSERT_DISBURSE, disTxnParams);
		}
		catch(Exception e)
		{
			logger.error("Insertion for Transaction is failed");
		}
		logger.info("insertTransactions finished");
	}

	@Override
	public void inserTxnStatus(final List<AgentTransaction> pendingTxnlist) {
		logger.info("inserTxnStatus started");
		SqlParameterSource[] params = SqlParameterSourceUtils
				.createBatch(pendingTxnlist.toArray());
		try {
			
			jdbcTemplate.batchUpdate(ApplicationQuery.TRANS_QUERY_INSERT, params);
			logger.info("insert Txn Status Success");
		}
		catch (Exception e)
		{
			logger.error("insert Txn Status is failed");
		}
		logger.info("inserTxnStatus completed");
	}

	@Override
	public void deleteTransaction(List<AgentTransaction> agenttxn) {
		logger.info("deleteTransaction started");
		try {
			
			Map<String, String> params = new HashMap<String, String>(agenttxn.size());
			params.put("status", PENDING_STATUS);
			StringBuilder sqlQuery = new StringBuilder("DELETE FROM IFTB_TRANSACTION_STATUS WHERE STATUS=:status AND TXN_ID  IN (");
			String delimiter = "";
			for(int i =0 ;i<agenttxn.size();i++){
				params.put("param"+i, agenttxn.get(i).getTxnId());
				sqlQuery.append(delimiter+":param"+i);
				if(i == 0){
					delimiter=delimiter+",";
				}
			}
			String query = sqlQuery.toString()+")";
			jdbcTemplate.update(query, params);
		}
		catch(Exception e)
		{
			logger.error("Transaction deletion is failed");
		}
		logger.info(" Transaction deleted completed");
		

	}
	
	
	//"UPDATE IFTB_CLAC_SCH_SETTLEMENT SET AMOUNT_SETTLED=:txnAmount WHERE LOAN_AC_NO=:id";
	
	/**nambiAK**/
	public void updateRepaySCHScheduleRecords(List<Repayment> repaytxn) {
				
		logger.info("updateRepaySCHScheduleRecords started");
		for (Repayment sysvo : repaytxn) {
			/**Shabu - Start
			 * Bug: 300
			 * */
			/*SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(sysvo);
			jdbcTemplate.execute(QUERY_UPDATE_SCH_REPAY_TXN_AMOUNT, namedParameters,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
			});		*/	
			
			updateRepaymentAmount(sysvo);
			if(isPartialLoanPayment(sysvo))
				updateLoanStatus(sysvo,FLAG_PAYMNT_PARTIAL);
			else
				updateLoanStatus(sysvo,FLAG_PAYMNT_FULL);
			
			/**Shabu - End
			 * Bug: 300
			 * */
			logger.info("updateRepaySCHScheduleRecords finished");

		}
	}
	
	
	/**nambiAK Vikash**/
	public void updateDisbSCHScheduleRecords(List<Disbursement> disbtxn) {
		
		logger.info("updateDisbSCHScheduleRecords started");
		
		for (Disbursement sysvo : disbtxn) 
		{
			logger.info(sysvo+" : updateDisbSCHScheduleRecords : txnSchStDate : "+sysvo.getTxnSchStDate()+" txnSchDueDate : "+sysvo.getTxnSchDueDate());
			logger.info(sysvo+" : updateDisbSCHScheduleRecords : loan Ac No : "+sysvo.getId()+" branchcode : "+sysvo.getTxnBranchCode()+" Cname : "+sysvo.getTxnComponentName());
			SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(sysvo);
			
			//Nirmal kanna S Added
			row_count = jdbcTemplate.queryForInt(ApplicationQuery.TRANS_QUERY_COUNT_SCH_DISB_TXN_AMOUNT, namedParameters);
			
			if (row_count > 0)
			{
				logger.info("The Disbursement is updating for A/C No = " + sysvo.getId());
				
				jdbcTemplate.execute(ApplicationQuery.TRANS_QUERY_UPDATE_SCH_DISB_TXN_AMOUNT, namedParameters,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
				});	
			}
			else
			{
				logger.error("The Disbursement record updated failed for A/C No = " + sysvo.getId());
			}
			logger.info("The Disbursement update is finished");
		}
	}
	/**Shabu - Start
	 * Bug: 300
	 * */
	private void updateRepaymentAmount(Repayment p_Repayment){
		
		logger.info("updateRepaymentAmount started");
		logger.info("updateRepaymentAmount : txnSchStDate : "+p_Repayment.getTxnSchStDate()+" txnSchDueDate : "+p_Repayment.getTxnSchDueDate());
		logger.info(p_Repayment+" : updateDisbSCHScheduleRecords : loan Ac No : "+p_Repayment.getId()+" branchcode : "+p_Repayment.getTxnBranchCode()+" Cname : "+p_Repayment.getTxnComponentName());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(p_Repayment);
		
		//Nirmal kanna S Added 
		
		row_count = jdbcTemplate.queryForInt(ApplicationQuery.TRANS_QUERY_COUNT_SCH_REPAY_TXN_AMOUNT, namedParameters);
		
		if (row_count > 0)
		{
			logger.info("The Repayment Loan is updating for A/C No = " + p_Repayment.getId());
			
			jdbcTemplate.execute(ApplicationQuery.TRANS_QUERY_UPDATE_SCH_REPAY_TXN_AMOUNT, namedParameters,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(
							PreparedStatement stmt) throws SQLException,
							DataAccessException {
						return stmt.executeUpdate();
					}
			});
		}
		else
		{
			logger.error("The Repayment Loan is getting failed for Loan A/C No = " + p_Repayment.getId());
		}
		logger.info("updateRepaymentAmount finished");
	}
	
	private boolean isPartialLoanPayment(Repayment p_Repayment){
		
		logger.info("isPartialLoanPayment started");
		int count = 0;
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", p_Repayment.getId());
		params.put("txnBranchCode", p_Repayment.getTxnBranchCode());
		params.put("txnCcy", p_Repayment.getTxnCcy());
		params.put("txnComponentName", p_Repayment.getTxnComponentName());
		
		params.put("txnSchStDate", p_Repayment.getTxnSchStDate());
		params.put("txnSchDueDate", p_Repayment.getTxnSchDueDate());
		logger.info("txnSchStDate : "+p_Repayment.getTxnSchStDate()+" txnSchDueDate : "+p_Repayment.getTxnSchDueDate());
		logger.info(p_Repayment+" : updateDisbSCHScheduleRecords : loan Ac No : "+p_Repayment.getId()+" branchcode : "+p_Repayment.getTxnBranchCode()+" Cname : "+p_Repayment.getTxnComponentName());
		
		count = jdbcTemplate.queryForInt(ApplicationQuery.TRANS_QUERY_PARTIAL_LOAN_PAYMNT, params);
		logger.info("isPartialLoanPayment finished");
		return count >0 ? true:false;
	}
	
	private void updateLoanStatus(Repayment p_Repayment, String flag){
		
		logger.info("updateLoanStatus started");
		Map<String, String> params = new HashMap<String, String>();
		params.put("flag", flag);
		//params.put("syncTime", new String());
		params.put("loanAccNo", p_Repayment.getId());
		jdbcTemplate.update(ApplicationQuery.TRANS_QUERY_UPDATE_PART_APYMNT_FLG, params);
		logger.info("updateLoanStatus finished");
	}
	/**Shabu - End
	 * Bug: 300
	 * */
	public Map<String, Object> getPostedTransaction(String p_txnId)
	{
		//SyncServiceProcHandler procHandler= new SyncServiceProcHandler(dataSource, TRAN_VERIFY_REC_PROC);
		//return procHandler.executeReceivedTrans(p_txnId);
		return null;
	}

	@Override
	public TransactionServiceResponse uploadTransaction(AgentTransaction p_tran) {
		LoggerUtil.ibsJobDebug("Submitting Txn: "+p_tran);
		TransactionServiceResponse l_resResponse=new TransactionServiceResponse();
		 Map<String, Object> l_procRes=null;
		 
		ProcHandler procHandler= new ProcHandler(ApplicationQuery.TRAN_INSERT_REC_PROC);
		
		procHandler.registerOutputParam("result", Types.VARCHAR);
		
		
		
		procHandler.registerInputParam("p_mbs_txn_id", p_tran.getTxnId(), Types.VARCHAR); 
		procHandler.registerInputParam("p_mbs_txn_seq_no", p_tran.getMbsSeqNo(), Types.NUMERIC);  //
		procHandler.registerInputParam("p_module_code", p_tran.getModuleCode(), Types.VARCHAR);
		procHandler.registerInputParam("p_txn_code", p_tran.getTxnCode(), Types.VARCHAR);
		procHandler.registerInputParam("p_agenda_id", p_tran.getAgendaId(), Types.VARCHAR);
		procHandler.registerInputParam("p_seq_no", p_tran.getSeqNo(), Types.NUMERIC);
		procHandler.registerInputParam("p_cbs_ac_ref_no", p_tran.getCbsAccRefNo(), Types.VARCHAR);
		procHandler.registerInputParam("p_branch_code", p_tran.getBranchCode(), Types.VARCHAR);
		procHandler.registerInputParam("p_customer_id", p_tran.getCustomerId(), Types.VARCHAR);
		procHandler.registerInputParam("p_txn_init_time", p_tran.getTxnInitTime(), Types.TIMESTAMP);
		procHandler.registerInputParam("p_txn_sync_time", p_tran.getTxnSyncTime(), Types.TIMESTAMP);
		procHandler.registerInputParam("p_agent_id", p_tran.getAgentId(), Types.VARCHAR);
		procHandler.registerInputParam("p_device_id", p_tran.getDeviceId(), Types.VARCHAR);
		procHandler.registerInputParam("p_location_code", p_tran.getLocCode(), Types.VARCHAR);
		procHandler.registerInputParam("p_ln_is_future_sch", p_tran.getIsLoanFutureSch(), Types.VARCHAR);
		procHandler.registerInputParam("p_txn_ccy_code", p_tran.getTxnCcy(), Types.VARCHAR);
		procHandler.registerInputParam("p_txn_lcy_code", p_tran.getTxnLocalCcy(), Types.VARCHAR);
		procHandler.registerInputParam("p_txn_amt", p_tran.getTxnAmount(), Types.NUMERIC);
		procHandler.registerInputParam("p_txn_amt_lcy", p_tran.getTxnLocalCcyAmount(), Types.NUMERIC);
		procHandler.registerInputParam("p_txn_settled_amt", p_tran.getTxnSettlementAmount(), Types.NUMERIC);
		procHandler.registerInputParam("p_txn_settled_amt_lcy", p_tran.getTxnSettleLocalCcyAmount(), Types.NUMERIC);
		procHandler.registerInputParam("p_txn_narrative", p_tran.getNarrative(), Types.VARCHAR);
		procHandler.registerInputParam("p_req_dep_no_inst", p_tran.getDepNoOfInstalement(), Types.NUMERIC);
		procHandler.registerInputParam("p_req_red_req_dt", p_tran.getDepoRedeemReqDate(), Types.DATE);
		procHandler.registerInputParam("p_req_red_full_part_ind", p_tran.getIsFullRepoRedeem(), Types.VARCHAR);
		procHandler.registerInputParam("p_req_maturity_date", p_tran.getMaturityDate(), Types.DATE);
		procHandler.registerInputParam("p_req_int_rate", p_tran.getIntrRate(), Types.NUMERIC);
		procHandler.registerInputParam("p_req_dp_tenure_type", p_tran.getDepoTenureType(), Types.VARCHAR);
		procHandler.registerInputParam("p_req_dp_frequency_type", p_tran.getDepoFreqType(), Types.VARCHAR);
		procHandler.registerInputParam("p_req_dp_frequency", p_tran.getDepoFreq(), Types.NUMERIC);
		procHandler.registerInputParam("p_req_dp_tenure", p_tran.getDepoTenure(), Types.NUMERIC);
		procHandler.registerInputParam("p_real_time_status", p_tran.getRealtimeStatus(), Types.VARCHAR);
		procHandler.registerInputParam("p_generated_sms", p_tran.getGeneratedSms(), Types.VARCHAR);//
		procHandler.registerInputParam("p_sms_mobile_no", p_tran.getSmsMobNo(), Types.VARCHAR);//
		procHandler.registerInputParam("p_sms_content", p_tran.getSmsContent(), Types.VARCHAR);//
		procHandler.registerInputParam("p_generated_revr", p_tran.getGenerateReversal(), Types.VARCHAR);//
		procHandler.registerInputParam("p_full_part_ind", p_tran.getFullPartIndicator(), Types.VARCHAR);//
		procHandler.registerInputParam("p_sync_type", p_tran.getSyncType(), Types.VARCHAR);//
		
		//procHandler.registerOutputParam("p_out_seq_number", Types.VARCHAR);
				
		l_procRes = procHandler.execute(true);
		String result = l_procRes.get("result").toString();
		if(result != null){
			String []resultArray = result.split("~");			
			if(resultArray[0].equals("0")){
				l_resResponse.setStatus(true);
			}
		} else {
			l_resResponse.setStatus(false);
		}
		
		/*if(l_procRes.get("result").toString().equals("0"))			
			l_resResponse.setStatus(true);*/
			
		LoggerUtil.ibsJobDebug("Result:  ::"+l_procRes.get("result"));
		return l_resResponse;
	}
	
}
