package com.bfsi.mfi.dao;

import java.util.List;
import java.util.Map;

import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.entity.Disbursement;
import com.bfsi.mfi.entity.Repayment;
import com.bfsi.mfi.entity.TransactionServiceResponse;

public interface TransactionDao extends MaintenanceDao<AgentTransaction> {

	

	public void inserTxnStatus(List<AgentTransaction> pendingtxnId);



	public void updateTxnStatus(String txn_id);

	

	public void insertTransactions(List<AgentTransaction> agenttxn,
			List<Repayment> reptxn, List<Disbursement> distxn) ;
	public void deleteTransaction(List<AgentTransaction> agenttxn);


/*nambiAK*/
	public void updateRepaySCHScheduleRecords(List<Repayment> repaymentlist);
	
/*nambiAK Vikash*/
	public void updateDisbSCHScheduleRecords(List<Disbursement> disbursementlist);	
	
	public Map<String, Object> getPostedTransaction(String p_txnId);
	
	
	public TransactionServiceResponse uploadTransaction(AgentTransaction agenttxn);
	
}
