package com.bfsi.mfi.dao;



import java.util.Date;
import java.util.List;

import com.bfsi.mfi.cbs.model.CbsTransaction;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.entity.MaintenanceEntity;
import com.bfsi.mfi.entity.ServiceResponse;


/**
 * 
 * @author Shabu
 *
 */
public interface CbsTransactionDao <T extends MaintenanceEntity,V extends ServiceResponse> {
	
	public void updateReqTransactionStatus(List<CbsTransaction> p_tran,String p_status);
	public void updateResTransactionStatus(String p_txnId,CbsBaseResponse p_res);
	public List<CbsTransaction> getUnprocessedTransaction(String rowNum);
	public ServiceResponse updateLogTransaction(String l_outSeqNo, CbsBaseResponse p_res);
	public String getIbsTxnOutSeqNo(String p_mbsTxnId);
	public V logTransaction(T p_transaction);
	public void updateTxnStatus(String p_outSeqNo,String p_status);
	
	public ServiceResponse startDailyJob();
	public Date getCurrentBusinessDate();
}
