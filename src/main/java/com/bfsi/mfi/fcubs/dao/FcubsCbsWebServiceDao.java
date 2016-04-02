package com.bfsi.mfi.fcubs.dao;

import com.bfsi.mfi.entity.AgentTransaction;

public interface FcubsCbsWebServiceDao {

	public void updateStatusToReady();

	public AgentTransaction uploadTxnForCbs();

	public void updateTxnForCbs(String txnId);

	public String getTxnNarrativeForRepay(String txnId);

	public String getTxnNarrativeForDisbr(String txnId);

	public void updateTxnWithCbsRes(String txnId,String status);

	public void updateStatusToReady(String txnId);

	public void updateTxnWithErrorMsg(String errorDesc, String txnId);
}
