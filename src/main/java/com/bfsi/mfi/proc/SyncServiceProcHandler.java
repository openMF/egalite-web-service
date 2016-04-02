package com.bfsi.mfi.proc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.entity.CashTransaction;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.util.LoggerUtil;


public class SyncServiceProcHandler extends StoredProcedure {
	
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	private DataSource dataSource;
	public SyncServiceProcHandler(DataSource p_dataSource, String p_procName)
	{
		super(p_dataSource, p_procName);
		this.dataSource=p_dataSource;
		LoggerUtil.ibsJobDebug("Initializing stored proc: Proc Name-> "+p_procName);
		
	}
	
	public Map<String, Object> executeReceivedTrans( String  p_txnId) {
		declareParameter(new SqlParameter("TXN_ID", Types.VARCHAR));
		declareParameter(new SqlOutParameter("ResultStatus", Types.VARCHAR));
		compile();
		LoggerUtil.ibsJobDebug("Executing stored proc: txn Id-> "+p_txnId);
		return  super.execute(p_txnId);
		
	}
	public Map<String, Object> processCashRequest( CashTransaction p_trans) {
		declareParameter(new SqlParameter("TXN_ID", Types.VARCHAR));
		declareParameter(new SqlOutParameter("ResultStatus", Types.VARCHAR));
		compile();
		
		return  super.execute(p_trans);
		
	}
	public Map<String, Object> processCashResponse( CashTransaction p_trans) {
		declareParameter(new SqlParameter("TXN_ID", Types.VARCHAR));
		declareParameter(new SqlOutParameter("ResultStatus", Types.VARCHAR));
		compile();
		
		return  super.execute(p_trans);
		
	}
	public Map<String, Object> processTransactionRequest( AgentTransaction p_tran)  {
	
		/*declareParameter(new SqlParameter("p_mbs_txn_id", Types.VARCHAR));
		declareParameter(new SqlParameter("p_module_code", Types.VARCHAR));
		declareParameter(new SqlParameter("p_txn_code", Types.VARCHAR));
		declareParameter(new SqlParameter("p_agenda_id", Types.VARCHAR));
		declareParameter(new SqlParameter("p_seq_no", Types.NUMERIC));
		declareParameter(new SqlParameter("p_cbs_ac_ref_no", Types.VARCHAR));
		declareParameter(new SqlParameter("p_branch_code", Types.VARCHAR));
		declareParameter(new SqlParameter("p_customer_id", Types.VARCHAR));
		declareParameter(new SqlParameter("p_txn_init_time", Types.DATE));
		declareParameter(new SqlParameter("p_txn_sync_time", Types.DATE));
		declareParameter(new SqlParameter("p_agent_id", Types.VARCHAR));
		declareParameter(new SqlParameter("p_device_id", Types.VARCHAR));
		declareParameter(new SqlParameter("p_location_code", Types.VARCHAR));
		declareParameter(new SqlParameter("p_ln_is_future_sch", Types.VARCHAR));
		declareParameter(new SqlParameter("p_txn_amt", Types.DOUBLE));
		declareParameter(new SqlParameter("p_txn_amt_lcy", Types.NUMERIC));
		declareParameter(new SqlParameter("p_txn_settled_amt", Types.NUMERIC));
		declareParameter(new SqlParameter("p_txn_settled_amt_lcy", Types.NUMERIC));
		declareParameter(new SqlParameter("p_txn_narrative", Types.VARCHAR));
		declareParameter(new SqlParameter("p_req_dep_no_inst", Types.NUMERIC));
		declareParameter(new SqlParameter("p_req_red_req_dt", Types.DATE));
		declareParameter(new SqlParameter("p_req_red_full_part_ind", Types.VARCHAR));
		declareParameter(new SqlParameter("p_req_maturity_date", Types.DATE));
		declareParameter(new SqlParameter("p_req_int_rate", Types.NUMERIC));
		declareParameter(new SqlParameter("p_req_dp_tenure_type", Types.VARCHAR));
		declareParameter(new SqlParameter("p_req_dp_frequency_type", Types.VARCHAR));
		declareParameter(new SqlParameter("p_req_dp_frequency", Types.NUMERIC));
		declareParameter(new SqlParameter("p_req_dp_tenure", Types.NUMERIC));
		
		declareParameter(new SqlOutParameter("result", Types.NUMERIC));
		setFunction(true);*/
		//compile();
		
		Map<String, Object> l_params=new HashMap<String, Object>();
		
		
		l_params.put("p_mbs_txn_id", p_tran.getTxnId());
		l_params.put("p_module_code", p_tran.getModuleCode());
		l_params.put("p_txn_code", p_tran.getTxnCode());
		l_params.put("p_agenda_id", p_tran.getAgendaId());
		l_params.put("p_seq_no", p_tran.getSeqNo());
		l_params.put("p_branch_code", p_tran.getBranchCode());
		l_params.put("p_customer_id", p_tran.getCustomerId());
		l_params.put("p_cbs_ac_ref_no", p_tran.getCbsAccRefNo());
		l_params.put("p_txn_init_time", p_tran.getTxnInitTime());
		l_params.put("p_txn_sync_time", p_tran.getTxnSyncTime());
		l_params.put("p_agent_id", p_tran.getAgentId());
		l_params.put("p_device_id", p_tran.getDeviceId());
		l_params.put("p_location_code", p_tran.getLocCode());
		l_params.put("p_ln_is_future_sch", p_tran.getIsLoanFutureSch());
		l_params.put("p_txn_amt", p_tran.getTxnAmount());
		l_params.put("p_txn_amt_lcy", null);
		l_params.put("p_txn_settled_amt", p_tran.getTxnSettlementAmount());
		l_params.put("p_txn_settled_amt_lcy", null);
		l_params.put("p_txn_narrative", p_tran.getNarrative());
		l_params.put("p_req_dep_no_inst", p_tran.getDepNoOfInstalement());
		l_params.put("p_req_red_req_dt", p_tran.getDepoRedeemReqDate());
		l_params.put("p_req_red_full_part_ind", p_tran.getIsFullRepoRedeem());
		l_params.put("p_req_maturity_date", p_tran.getMaturityDate());
		l_params.put("p_req_int_rate", p_tran.getIntrRate());
		l_params.put("p_req_dp_tenure_type", p_tran.getDepoTenureType());
		l_params.put("p_req_dp_frequency_type", p_tran.getDepoFreqType());
		l_params.put("p_req_dp_frequency", p_tran.getDepoFreq());
		l_params.put("p_req_dp_tenure", p_tran.getDepoTenure());
		
		try{
		Connection cn=dataSource.getConnection();
		CallableStatement st = cn.prepareCall("{? = call cintpkg.create_txn_receiver(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
		
		st.registerOutParameter(1,Types.NUMERIC);
		st.setString(2, p_tran.getTxnId());
		st.setString(3, p_tran.getModuleCode());
		st.setString(4, p_tran.getTxnCode());
		st.setString(5, p_tran.getAgendaId());
		st.setInt(6, p_tran.getSeqNo());
		st.setString(7, p_tran.getBranchCode());
		st.setString(8, p_tran.getCustomerId());
		st.setString(9, p_tran.getCbsAccRefNo());
		if(p_tran.getTxnInitTime() == null)
			st.setNull(10,  Types.DATE);
		else
		st.setDate(10, new java.sql.Date(p_tran.getTxnInitTime().getTime()));
		if(p_tran.getTxnSyncTime() == null)
			st.setNull(11,  Types.DATE);
		else
		st.setDate(11, new java.sql.Date(p_tran.getTxnSyncTime().getTime()));
		st.setString(12, p_tran.getAgentId());
		st.setString(13, p_tran.getDeviceId());
		st.setString(14, p_tran.getLocCode());
		st.setString(15, p_tran.getIsLoanFutureSch());
		st.setDouble(16, p_tran.getTxnAmount());
		if(p_tran.getTxnLocalCcyAmount() == null)
			st.setNull(17,  Types.DOUBLE);
		else
		st.setDouble(17, p_tran.getTxnLocalCcyAmount());
		if(p_tran.getTxnSettlementAmount() == null)
			st.setNull(18,  Types.DOUBLE);
		else
		st.setDouble(18, p_tran.getTxnSettlementAmount());
		if(p_tran.getTxnSettleLocalCcyAmount() == null)
			st.setNull(19,  Types.DOUBLE);
		else
		st.setDouble(19, p_tran.getTxnSettleLocalCcyAmount());
		st.setString(20, p_tran.getNarrative());
		st.setInt(21, p_tran.getDepNoOfInstalement());
		if(p_tran.getDepoRedeemReqDate() == null)
			st.setNull(22,  Types.DATE);
		else
		st.setDate(22, new java.sql.Date(p_tran.getDepoRedeemReqDate().getTime()));
		st.setString(23,p_tran.getIsFullRepoRedeem());
		if(p_tran.getMaturityDate() == null)
			st.setNull(24,  Types.DATE);
		else
		st.setDate(24,  new java.sql.Date(p_tran.getMaturityDate().getTime()));
		if(p_tran.getIntrRate() == null)
			st.setNull(25,  Types.DOUBLE);
		else
		st.setDouble(25, p_tran.getIntrRate());
		st.setString(26, p_tran.getDepoTenureType());
		st.setString(27, p_tran.getDepoFreqType());
		st.setInt(28, p_tran.getDepoFreq());
		st.setInt(29, p_tran.getDepoTenure());
		st.execute();
		
		//System.out.println("Result : "+st.getInt(1));
				
		}
		catch(Exception e)
		{
		  throw new ServiceException(e);
		}
		
		//return super.execute(l_params);
		return null;
		
		
	}
	public Map<String, Object> processUpdateAgendaStatus( List<String> p_agendaList) {
		
		declareParameter(new SqlParameter("agendaId", Types.ARRAY));
		declareParameter(new SqlParameter("agendaCount", Types.NUMERIC));
		
		declareParameter(new SqlOutParameter("ResultStatus", Types.VARCHAR));
		
		compile();
		
		Map<String, Object> l_params=new HashMap<String, Object>();
		l_params.put("agendaId", p_agendaList);
		l_params.put("agendaCount", p_agendaList.size());
		
		return super.execute(l_params);
		
		
	}
	public void registerInputParams(String p_idParam,Object p_value,int p_sqlType, Map<String, Object> p_paramsMap)
	{
		if(p_value==null)
			declareParameter(new SqlParameter(p_idParam, p_sqlType));
		else
			declareParameter(new SqlParameter(p_idParam, Types.NULL));
		p_paramsMap.put(p_idParam, p_value);
	}
	public void registerOutputParams(String p_idParam,int p_sqlType)
	{
		declareParameter(new SqlOutParameter(p_idParam, p_sqlType));
	}
}
