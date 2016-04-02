package com.bfsi.mfi.dao.jdbc;

import java.sql.Types;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.dao.ProcessCashTransactionDao;
import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

/**
 * 
 * @author Shabu
 *
 */
//PENDING
//1. map the new procedure input arguments that are required to include as part of real-time transactions
//2. Contact Anil for any new columns required in txn_receiver table
@Repository
public class ProcessCashTransactionJdbcDao extends BaseJdbcDao implements ProcessCashTransactionDao<AgentTransaction,ServiceResponse> {
		
	
	

	@Override
	public ServiceResponse logTransaction(AgentTransaction p_tran) {
		ServiceResponse l_resResponse=new ServiceResponse();
		 Map<String, Object> l_procRes=null;
		 try{
		ProcHandler procHandler= new ProcHandler(ApplicationQuery.TRAN_INSERT_REC_PROC);
		
		procHandler.registerOutputParam("result", Types.NUMERIC);

		procHandler.registerInputParam("p_mbs_txn_id", p_tran.getTxnId(), Types.VARCHAR); 
		procHandler.registerInputParam("p_mbs_txn_seq_no", p_tran.getMbsSeqNo(), Types.NUMERIC);  //
		procHandler.registerInputParam("p_module_code", p_tran.getModuleCode(), Types.VARCHAR);
		procHandler.registerInputParam("p_txn_code", p_tran.getTxnCode(), Types.VARCHAR);
		procHandler.registerInputParam("p_agenda_id", p_tran.getAgendaId(), Types.VARCHAR);
		procHandler.registerInputParam("p_seq_no", p_tran.getSeqNo(), Types.NUMERIC);
		procHandler.registerInputParam("p_cbs_ac_ref_no", p_tran.getCbsAccRefNo(), Types.VARCHAR);
		procHandler.registerInputParam("p_branch_code", p_tran.getBranchCode(), Types.VARCHAR);
		procHandler.registerInputParam("p_customer_id", p_tran.getCustomerId(), Types.VARCHAR);
		procHandler.registerInputParam("p_txn_init_time", p_tran.getTxnInitTime(), Types.DATE);
		procHandler.registerInputParam("p_txn_sync_time", p_tran.getTxnSyncTime(), Types.DATE);
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
				
		l_procRes = procHandler.execute(true);
		
		String l_status=l_procRes.get("result").toString();
		LoggerUtil.ibsJobDebug("Proc Response:: "+l_status);
		if(l_status.equals("0"))
			l_resResponse.setStatus(true);
		else
			l_resResponse.setStatus(false);
		 }
		 catch(Exception e)
		 {
			 LoggerUtil.ibsJobError("Unhandeled Exception : MFI10001", e);
			 l_resResponse.setStatus(false);
		 }
			
		return l_resResponse;
	}


	@Override
	public ServiceResponse updateLogTransaction(String p_outSeqNo, CbsBaseResponse p_res) {
		ServiceResponse l_resResponse=new ServiceResponse();
		 Map<String, Object> l_procRes=null;
		 try{
		ProcHandler procHandler= new ProcHandler(ApplicationQuery.TRAN_UPDATE_REC_PROC);
		
		procHandler.registerOutputParam("error_code", Types.VARCHAR);
		procHandler.registerOutputParam("error_msg", Types.VARCHAR);

		procHandler.registerInputParam("p_mfi_out_seqno", p_outSeqNo, Types.VARCHAR);
		procHandler.registerInputParam("p_cbs_response_stat", p_res.getCbsResStat(), Types.VARCHAR);
		procHandler.registerInputParam("p_cbs_response_txn_ref_no", p_res.getCbsResTxnRefNo(), Types.VARCHAR);
		procHandler.registerInputParam("p_cbs_error_code", p_res.getResponseCode(), Types.VARCHAR);
		procHandler.registerInputParam("p_cbs_error_desc", p_res.getResponseMessage(), Types.VARCHAR);		
				
		l_procRes = procHandler.execute(true);
		
		String l_status=l_procRes.get("error_code").toString();
		if(l_status.equals("0"))
			l_resResponse.setStatus(true);
		else
			l_resResponse.setStatus(false);
		 }
		 catch(Exception e)
		 {
			 LoggerUtil.ibsJobError("Unhandeled Exception : MFI10001", e);
			 l_resResponse.setStatus(false);
		 }
			
		return l_resResponse;
	}

}
