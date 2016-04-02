package com.bfsi.mfi.service;

import com.bfsi.mfi.cbs.adapter.AdapterFactory;
import com.bfsi.mfi.cbs.adapter.CbsActionType;
import com.bfsi.mfi.cbs.adapter.CbsTransactionServiceAdapter;
import com.bfsi.mfi.cbs.request.CbsBaseRequest;
import com.bfsi.mfi.cbs.request.CbsCashDepositRequest;
import com.bfsi.mfi.cbs.request.CbsCashWithdrawRequest;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.entity.CashTransactionServiceRequest;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;

/**
 * 
 * @author Shabu
 * 
 */
public abstract class CashTransactionService {
	public abstract ServiceResponse processCashRequest(
			CashTransactionServiceRequest p_request) throws ServiceException;

	@SuppressWarnings("unchecked")
	protected CbsTransactionServiceAdapter<CbsBaseRequest, CbsBaseResponse> getAdapter(
			AgentTransaction p_tran) throws Exception {
		CbsActionType l_action = null;
		if (p_tran.getTxnCode().equals("C21"))
			l_action = CbsActionType.CASHDEPOSIT;
		else if(p_tran.getTxnCode().equals("C22"))
			l_action = CbsActionType.CASHWITHDRAW;
		return (CbsTransactionServiceAdapter<CbsBaseRequest, CbsBaseResponse>) AdapterFactory
				.getAdapter(l_action);
	}

	protected CbsBaseRequest buildRequest(AgentTransaction p_tran) {
		if (p_tran.getTxnCode().equals("C21"))
			return buildCashDepositRequest(p_tran);
		else if(p_tran.getTxnCode().equals("C22"))
			return buildCashWithdrawalRequest(p_tran);
		return null;
	}

	private CbsCashDepositRequest buildCashDepositRequest(
			AgentTransaction p_tran) {

		CbsCashDepositRequest l_req = new CbsCashDepositRequest();
		l_req.setIbsOutSeqNo(p_tran.getIbsTxnOutSeqNo());
		l_req.setTxnRefNo(p_tran.getTxnId());
		l_req.setSeqNo(p_tran.getMbsSeqNo());
		l_req.setAccNo(p_tran.getCbsAccRefNo());
		l_req.setCustId(p_tran.getCustomerId());
		l_req.setBranchCode(p_tran.getBranchCode());
		l_req.setModuleCode(p_tran.getModuleCode());
		l_req.setTxnCode(p_tran.getTxnCode());
		l_req.setTxnIdentifier("N");
		l_req.setAmountDue(p_tran.getTxnAmount());
		l_req.setAmountSettled(p_tran.getTxnSettlementAmount());
		l_req.setCcyCode(p_tran.getTxnCcy());
		l_req.setTxnInitTime(p_tran.getTxnInitTime());
		// Set bussiness Date for cbs
		l_req.setBusiDate(p_tran.getBusiDate());
		

		return l_req;
	}

	private CbsCashWithdrawRequest buildCashWithdrawalRequest(
			AgentTransaction p_tran) {
		CbsCashWithdrawRequest l_req = new CbsCashWithdrawRequest();
		l_req.setIbsOutSeqNo(p_tran.getIbsTxnOutSeqNo());
		l_req.setTxnRefNo(p_tran.getTxnId());
		l_req.setSeqNo(p_tran.getMbsSeqNo());
		l_req.setAccNo(p_tran.getCbsAccRefNo());
		l_req.setCustId(p_tran.getCustomerId());
		l_req.setBranchCode(p_tran.getBranchCode());
		l_req.setModuleCode(p_tran.getModuleCode());
		l_req.setTxnCode(p_tran.getTxnCode());
		l_req.setTxnIdentifier("N");
		l_req.setAmountDue(p_tran.getTxnAmount());
		l_req.setAmountSettled(p_tran.getTxnSettlementAmount());
		l_req.setCcyCode(p_tran.getTxnCcy());		
		l_req.setTxnInitTime(p_tran.getTxnInitTime());
		// Set bussiness Date for cbs
		l_req.setBusiDate(p_tran.getBusiDate());
		return l_req;
	}

}
