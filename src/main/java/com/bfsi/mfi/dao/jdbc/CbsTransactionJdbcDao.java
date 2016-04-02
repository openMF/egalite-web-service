package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.cbs.model.CbsTransaction;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.dao.CbsTransactionDao;
import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

/**
 * 
 * @author Shabu
 * 
 */
@Repository
public class CbsTransactionJdbcDao extends BaseJdbcDao implements
		CbsTransactionDao <AgentTransaction,ServiceResponse>{
	
	@Override
	public  void updateReqTransactionStatus(List<CbsTransaction> p_tran, String p_status) {

		try{
			@SuppressWarnings("unchecked")
			Map<String, String> []l_params=(Map<String, String>[]) new HashMap<?,?>[p_tran.size()];
			for(int l_i=0;l_i<p_tran.size();l_i++){
				l_params[l_i]=new HashMap<String, String>();
				l_params[l_i].put("mfiOutSeqno", p_tran.get(l_i).getMfiOutSeqno());
				l_params[l_i].put("isSentToCbs", p_status);
			}
			
			jdbcTemplate.batchUpdate(ApplicationQuery.QUERY_UPDATE_REQ_STATUS, l_params);
		} catch(DataAccessException e){
			
		}
	}
	
	@Override
	public void updateResTransactionStatus(String p_out_seq, CbsBaseResponse p_res) {
		
		LoggerUtil.ibsJobDebug("TXN Res From CBS:: "+p_res);
		Map<String, String> l_params = new HashMap<String, String>();		
		l_params.put("mfiOutSeqno", p_out_seq);
		l_params.put("cbsResStat", p_res.getCbsResStat());
		l_params.put("cbsResTxnRefNo", p_res.getCbsResTxnRefNo());
		l_params.put("cbsErrorCode", p_res.getResponseCode());
		l_params.put("cbsErrorDesc", p_res.getResponseMessage());
		jdbcTemplate.update(ApplicationQuery.QUERY_UPDATE_RES_STATUS, l_params);
		
	}
	
	@Override
	public ServiceResponse updateLogTransaction(String l_outSeqNo, CbsBaseResponse p_res) {
		ServiceResponse l_resResponse=new ServiceResponse();
		 Map<String, Object> l_procRes=null;
		 try{
			 LoggerUtil.ibsJobDebug("CBD Resp:: "+p_res);
		ProcHandler procHandler= new ProcHandler(ApplicationQuery.TRAN_UPDATE_REC_PROC);
		
		procHandler.registerOutputParam("result", Types.VARCHAR);

		procHandler.registerInputParam("p_mfi_out_seqno", l_outSeqNo, Types.VARCHAR);
		procHandler.registerInputParam("p_cbs_response_stat", p_res.getCbsResStat(), Types.VARCHAR);
		procHandler.registerInputParam("p_cbs_response_txn_ref_no", p_res.getCbsResTxnRefNo(), Types.VARCHAR);
		procHandler.registerInputParam("p_cbs_error_code", p_res.getResponseCode(), Types.VARCHAR);
		procHandler.registerInputParam("p_cbs_error_desc", p_res.getResponseMessage(), Types.VARCHAR);		
		
		//procHandler.registerOutputParam("error_code", Types.VARCHAR);
		//procHandler.registerOutputParam("error_msg", Types.VARCHAR);
				
		l_procRes = procHandler.execute(true);
			
		LoggerUtil.ibsJobDebug("Proc Result:: "+l_procRes);
		String l_status=l_procRes.get("result").toString();
		if(l_status != null){
			String []resultArray = l_status.split("~");			
			if(resultArray[0].equals("0")){
				l_resResponse.setStatus(true);
			} else {
				l_resResponse.setStatus(false);
				l_resResponse.setMessageCode(resultArray[1]);
				l_resResponse.setHostMessage(resultArray[2]);
			}
		} else {
			l_resResponse.setStatus(false);
		}
		
		/*if(l_status.equals("0"))
			l_resResponse.setStatus(true);
		else{
			l_resResponse.setStatus(false);
			l_resResponse.setMessageCode(l_procRes.get("error_code").toString());
			l_resResponse.setHostMessage(l_procRes.get("error_msg").toString());
		}*/
		 }
		 catch(Exception e)
		 {
			 LoggerUtil.ibsJobError("Unhandeled Exception : MFI10001", e);
			 l_resResponse.setStatus(false);
		 }
			
		return l_resResponse;
	}


	@Override
	public  List<CbsTransaction> getUnprocessedTransaction(String rowNum) {

		Map<String, Object> l_params = new HashMap<String, Object>();
		l_params.put("batchSize", Integer.valueOf(rowNum));
		
		/*return jdbcTemplate.query(ApplicationQuery.QUERY_GET_UNPROCESSED_RECORD.concat(ApplicationQuery.QUERY_BATCH_STRING_WHERE), l_params,
				new CbsTransactionRowMapper());*/
		
		return jdbcTemplate.query(ApplicationQuery.QUERY_GET_UNPROCESSED_RECORD.concat(ApplicationQuery.QUERY_BATCH_STRING_WHERE), l_params,
				new CbsTransactionRowMapper());
	}

	protected static final class CbsTransactionRowMapper implements
			RowMapper<CbsTransaction> {
		public CbsTransaction mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			CbsTransaction l_tran = new CbsTransaction();			
			 
			l_tran.setMfiOutSeqno(rs.getString("MFI_OUT_SEQNO"));
			l_tran.setMbsTxnRefNo(rs.getString("MBS_TXN_REF_NO"));
			l_tran.setMbsTxnSeqNo(rs.getString("MBS_TXN_SEQ_NO"));
			
			l_tran.setCbsAcRefNo(rs.getString("CBS_AC_REF_NO"));
			l_tran.setCustomerId(rs.getString("CUSTOMER_ID"));
			l_tran.setCbsBranchCode(rs.getString("CBS_BRANCH_CODE"));
			l_tran.setModuleCode(rs.getString("MODULE_CODE"));
			l_tran.setTxnCode(rs.getString("TXN_CODE"));
			l_tran.setTxnIdentifier(rs.getString("TXN_IDENTIFIER"));
			l_tran.setSyncType(rs.getString("SYNC_TYPE"));
			l_tran.setIsReqOrTxn(rs.getString("IS_REQ_OR_TXN"));
			l_tran.setIsSentToCbs(rs.getString("IS_SENT_TO_CBS"));
			l_tran.setLogTime(rs.getDate("LOG_TIME"));
			//EGA-MN15-000025 Start
			//l_tran.setCbsSentTime(rs.getDate("CBS_SENT_TIME"));  
			//l_tran.setCbsResStat(rs.getString("CBS_RESPONSE_STAT"));
			//l_tran.setCbsResTxnRefNo(rs.getString("CBS_RESPONSE_TXN_REF_NO"));
			//l_tran.setCbsResTime(rs.getDate("CBS_RESPOND_TIME"));
			
			//l_tran.setCbsErrCode(rs.getString("CBS_ERROR_CODE"));
			//l_tran.setCbsErrDesc(rs.getString("CBS_ERROR_DESC"));		
			//EGA-MN15-000025 End
			 l_tran.setIbsAgnId(rs.getString("IBS_AGENDA_ID"));
			 l_tran.setIbsAgnSeqNo(rs.getLong("IBS_AGENDA_SEQ_NO"));
			 l_tran.setAgnAmtDueCcy(rs.getString("TXN_AMT_DUE_LCY"));
			 l_tran.setAgnAmtDue(rs.getDouble("TXN_AMT_DUE"));
			 l_tran.setAgnAmtSettledCcy(rs.getString("TXN_AMT_SETTLED_LCY"));
			 l_tran.setAgnAmtSettled(rs.getDouble("TXN_AMT_SETTLED"));
			 
			 l_tran.setTxnCcy(rs.getString("TXN_CCY_CODE"));  
			 l_tran.setTxnLocalCcy(rs.getString("TXN_LCY_CODE"));  
			 
			 
			 l_tran.setFullPartialInd(rs.getString("FULL_PARTIAL_IND"));  
			
			// l_tran.setCbsAgentId(rs.getString("CBS_AGENT_ID"));
			// l_tran.setCbsLcrCode(rs.getString("CBS_LCR_CODE"));
			// l_tran.setCbsLcrType(rs.getString("CBS_LCR_TYPE"));
			 l_tran.setMbsTxnNarrative(rs.getString("MBS_TXN_NARRATIVE"));
			 l_tran.setReqDepNoInst(rs.getLong("REQ_DEP_NO_INST"));
			 l_tran.setReqRedReqDt(rs.getDate("REQ_RED_REQ_DT"));
			 l_tran.setReqRedFullPartInd(rs.getString("REQ_RED_FULL_PART_IND"));
			 l_tran.setReqMaturityDate(rs.getDate("REQ_MATURITY_DATE"));
			 l_tran.setReqIntRate(rs.getDouble("REQ_INT_RATE"));
			 l_tran.setReqDpTenureType(rs.getString("REQ_DP_TENURE_TYPE"));
			 l_tran.setReqDpFrqType(rs.getString("REQ_DP_FREQUENCY_TYPE"));
			 l_tran.setReqDpFrq(rs.getLong("REQ_DP_FREQUENCY"));
			 l_tran.setReqDpTenure(rs.getLong("REQ_DP_TENURE"));
			 
			 l_tran.setIsGroupLoan(rs.getString("IS_GROUP_LOAN"));
			 l_tran.setIsParentLoan(rs.getString("IS_PARENT_LOAN"));
			 l_tran.setIsParentCust(rs.getString("IS_PARENT_CUSTOMER"));
			 l_tran.setParentCustId(rs.getString("PARENT_CUSTOMER_ID"));
			 l_tran.setParentCbsAccRefNo(rs.getString("PARENT_CBS_AC_REF_NO"));
			return l_tran;
		}
	}

	@Override
	public String getIbsTxnOutSeqNo(String p_mbsTxnId) {
		Map<String, String> l_params=new HashMap<String, String>();
		l_params.put("mbsTxnRefNo", p_mbsTxnId);
		return jdbcTemplate.queryForObject(ApplicationQuery.QUERY_GET_TXN_OUT_SEQ_NO, l_params, String.class);
	}

	@Override
	public ServiceResponse logTransaction(AgentTransaction p_tran) {
		
		ServiceResponse l_resResponse=new ServiceResponse();
		 Map<String, Object> l_procRes=null;
		 LoggerUtil.ibsJobDebug("Receiving New Transaction from MBS:: "+p_tran.toString());
		 try{
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
		String l_status=l_procRes.get("result").toString();
		LoggerUtil.ibsJobDebug("Proc Response:: "+l_status);
		if(l_status != null){
			String []resultArray = l_status.split("~");			
			if(resultArray[0].equals("0")){
				l_resResponse.setStatus(true);
				l_resResponse.setMessageCode(resultArray[1]);
			}
		} else {
			l_resResponse.setStatus(false);
		}
		/*if(l_status.equals("0")){
			l_resResponse.setStatus(true);
			l_resResponse.setMessageCode(l_procRes.get("p_out_seq_number").toString());
		}
		else
			l_resResponse.setStatus(false);
		*/
		 }
		 catch(Exception e)
		 {
			 LoggerUtil.ibsJobError("Unhandeled Exception : MFI10001", e);
			 l_resResponse.setStatus(false);
		 }
			
		return l_resResponse;
	}

	@Override
	public void updateTxnStatus(String p_outSeqNo, String p_status) {
		Map<String, String> l_params=new HashMap<String, String>();
		
		l_params.put("mfiOutSeqno", p_outSeqNo);
		l_params.put("isSentToCbs", p_status);
		
		jdbcTemplate.update(ApplicationQuery.QUERY_UPDATE_REQ_STATUS, l_params);
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public ServiceResponse startDailyJob() {
		
		ServiceResponse l_resResponse=new ServiceResponse();
		Map<String, Object> l_procRes=null;
		ProcHandler procHandler= new ProcHandler(ApplicationQuery.FN_DAILY_JOB);
		procHandler.registerOutputParam("result", Types.NUMERIC);
		l_procRes = procHandler.execute(true);
		LoggerUtil.ibsJobDebug("Proc Result:: "+l_procRes);
		 
		if(l_procRes.get("result").toString().equals("0"))
			l_resResponse.setStatus(true);
		else
			l_resResponse.setStatus(false);

		return l_resResponse;
		
	}
	
	@Override
	public Date getCurrentBusinessDate() {
		try {
			return super.getBusinessDate();
		} catch (Exception e) {
			return null;
		}

	}
}
