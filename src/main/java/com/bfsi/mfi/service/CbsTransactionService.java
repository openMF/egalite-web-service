package com.bfsi.mfi.service;

import org.springframework.beans.BeanUtils;

import com.bfsi.mfi.cbs.adapter.AdapterFactory;
import com.bfsi.mfi.cbs.adapter.CbsActionType;
import com.bfsi.mfi.cbs.adapter.CbsTransactionServiceAdapter;
import com.bfsi.mfi.cbs.model.CbsTransaction;
import com.bfsi.mfi.cbs.request.CbsBaseRequest;
import com.bfsi.mfi.cbs.request.CbsCashDepositRequest;
import com.bfsi.mfi.cbs.request.CbsCashWithdrawRequest;
import com.bfsi.mfi.cbs.request.CbsDepositCollectionRequest;
import com.bfsi.mfi.cbs.request.CbsDepositMaturityPayoutRequest;
import com.bfsi.mfi.cbs.request.CbsDepositNewAccountRequest;
import com.bfsi.mfi.cbs.request.CbsDepositPrepaymentRequest;
import com.bfsi.mfi.cbs.request.CbsDepositRedemptionPayoutRequest;
import com.bfsi.mfi.cbs.request.CbsGenericRequest;
import com.bfsi.mfi.cbs.request.CbsLoanDisbursementRequest;
import com.bfsi.mfi.cbs.request.CbsLoanPrepaymentRequest;
import com.bfsi.mfi.cbs.request.CbsLoanRepaymentRequest;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.exception.ServiceException;
/**
 * 
 * @author Shabu
 *
 */
public abstract class CbsTransactionService {

	public abstract void process() throws ServiceException;
	
	public abstract void populateTxnTables();

	@SuppressWarnings("unchecked")
	protected CbsTransactionServiceAdapter<CbsBaseRequest, CbsBaseResponse> getAdapter(
			CbsTransaction p_txn) throws Exception {
		CbsActionType l_action = null;
		
		l_action = CbsActionType.TRANSGENRERICREQUEST;
		
		/*if (p_txn.getTxnCode().equals("L01"))
			l_action = CbsActionType.LOANDISBUREMENT;
		else if (p_txn.getTxnCode().equals("L02"))
			l_action = CbsActionType.LOANREPAYMENT;
		else if (p_txn.getTxnCode().equals("L21"))
			l_action = CbsActionType.LOANPREPAYMENT;
		else if (p_txn.getTxnCode().equals("D01"))
			l_action = CbsActionType.DEPOSITCOLLECTION;
		else if (p_txn.getTxnCode().equals("D02"))
			l_action = CbsActionType.DEPOSITMATURITYPAYOUT;
		else if (p_txn.getTxnCode().equals("D03"))
			l_action = CbsActionType.DEPOSITREDEMPTIONPAYOUT;
		else if (p_txn.getTxnCode().equals("C21"))
			l_action = CbsActionType.CASHDEPOSIT;
		else if (p_txn.getTxnCode().equals("C22"))
			l_action = CbsActionType.CASHWITHDRAW;
		else if (p_txn.getTxnCode().equals("D21"))
			l_action = CbsActionType.DEPOSITNEWACCREQUEST;
		else if (p_txn.getTxnCode().equals("D23"))
			l_action = CbsActionType.DEPOSITPREPAYREQUEST;*/
		return (CbsTransactionServiceAdapter<CbsBaseRequest, CbsBaseResponse>) AdapterFactory.getAdapter(l_action);

	}

	protected CbsBaseRequest buildRequest(CbsTransaction p_txn) {
		/*if (p_txn.getTxnCode().equals("L01"))
			return buildLoanDisbursementRequest(p_txn);
		else if (p_txn.getTxnCode().equals("L02"))
			return buildLoanRepaymentRequest(p_txn);
		else if (p_txn.getTxnCode().equals("L21"))
			return buildLoanPreapymentRequest(p_txn);
		else if (p_txn.getTxnCode().equals("D01"))
			return buildDepositCollectionRequest(p_txn);
		else if (p_txn.getTxnCode().equals("D02"))
			return buildDepositMaturitPayoutRequest(p_txn);
		else if (p_txn.getTxnCode().equals("D03"))
			return buildDepositRedemptionRequest(p_txn);
		else if (p_txn.getTxnCode().equals("C21"))
			return buildCashDepositRequest(p_txn);
		else if (p_txn.getTxnCode().equals("C22"))
			return buildCashWithdrawalRequest(p_txn);
		else if (p_txn.getTxnCode().equals("D21"))
			return buildDepositNewAccountRequest(p_txn);
		else if (p_txn.getTxnCode().equals("D23"))
			return buildDepositPrepaymentRequest(p_txn);*/
		return buildGenricRequest(p_txn);
	}
	
	protected CbsGenericRequest buildGenricRequest(CbsTransaction p_txn) {
		CbsGenericRequest l_req =new CbsGenericRequest();
		BeanUtils.copyProperties(p_txn, l_req);
		return l_req;
	}
	
	private CbsDepositNewAccountRequest buildDepositNewAccountRequest(CbsTransaction p_txn){
		CbsDepositNewAccountRequest l_req =new CbsDepositNewAccountRequest();
		BeanUtils.copyProperties(p_txn, l_req);
		return l_req;
	}
	
	private CbsDepositPrepaymentRequest buildDepositPrepaymentRequest (CbsTransaction p_txn){
		CbsDepositPrepaymentRequest l_req = new CbsDepositPrepaymentRequest();
		BeanUtils.copyProperties(p_txn, l_req);
		return l_req;
	}

	private CbsLoanRepaymentRequest buildLoanRepaymentRequest(
			CbsTransaction p_txn) {
		CbsLoanRepaymentRequest l_req = new CbsLoanRepaymentRequest();
		l_req.setIbsOutSeqNo(p_txn.getMfiOutSeqno());
		l_req.setTxnRefNo(p_txn.getMbsTxnRefNo());
		//l_req.setSeqNo(p_txn.);
		l_req.setLoanAccNo(p_txn.getCbsAcRefNo());
		l_req.setCustId(p_txn.getCustomerId());
		l_req.setBranchCode(p_txn.getCbsBranchCode());
		l_req.setModuleCode(p_txn.getModuleCode());
		l_req.setTxnCode(p_txn.getTxnCode());
		l_req.setTxnIdentifier(p_txn.getTxnIdentifier());
		l_req.setAmountDue(p_txn.getAgnAmtDue());
		l_req.setAmountSettled(p_txn.getAgnAmtSettled());
		l_req.setCcyCode(p_txn.getAgnAmtDueCcy());
		l_req.setFullPartIndicator(p_txn.getFullPartialInd());
		
		
		l_req.setIsGroupLoan(p_txn.getIsGroupLoan());
		l_req.setIsParentLoan(p_txn.getIsParentLoan());
		l_req.setIsParentCust(p_txn.getIsParentCust());
		l_req.setParentCustId(p_txn.getParentCustId());
		l_req.setParentCbsAccRefNo(p_txn.getParentCbsAccRefNo());
		
		l_req.setTxnInitTime(p_txn.getLogTime());

		return l_req;
	}

	private CbsLoanDisbursementRequest buildLoanDisbursementRequest(
			CbsTransaction p_txn) {
		CbsLoanDisbursementRequest l_req = new CbsLoanDisbursementRequest();
		l_req.setIbsOutSeqNo(p_txn.getMfiOutSeqno());
		l_req.setTxnRefNo(p_txn.getMbsTxnRefNo());
		//l_req.setSeqNo(p_txn.);
		l_req.setLoanAccNo(p_txn.getCbsAcRefNo());
		l_req.setCustId(p_txn.getCustomerId());
		l_req.setBranchCode(p_txn.getCbsBranchCode());
		l_req.setModuleCode(p_txn.getModuleCode());
		l_req.setTxnCode(p_txn.getTxnCode());
		l_req.setTxnIdentifier(p_txn.getTxnIdentifier());
		l_req.setAmountDue(p_txn.getAgnAmtDue());
		l_req.setAmountSettled(p_txn.getAgnAmtSettled());
		l_req.setCcyCode(p_txn.getAgnAmtDueCcy());
		l_req.setFullPartIndicator(p_txn.getFullPartialInd());
		
		
		l_req.setIsGroupLoan(p_txn.getIsGroupLoan());
		l_req.setIsParentLoan(p_txn.getIsParentLoan());
		l_req.setIsParentCust(p_txn.getIsParentCust());
		l_req.setParentCustId(p_txn.getParentCustId());
		l_req.setParentCbsAccRefNo(p_txn.getParentCbsAccRefNo());
		l_req.setTxnInitTime(p_txn.getLogTime());
		return l_req;
	}
	
	private CbsLoanPrepaymentRequest buildLoanPreapymentRequest(
			CbsTransaction p_txn) {
		CbsLoanPrepaymentRequest l_req = new CbsLoanPrepaymentRequest();
		l_req.setIbsOutSeqNo(p_txn.getMfiOutSeqno());
		l_req.setTxnRefNo(p_txn.getMbsTxnRefNo());
		//l_req.setSeqNo(p_txn.);
		l_req.setLoanAccNo(p_txn.getCbsAcRefNo());
		l_req.setCustId(p_txn.getCustomerId());
		l_req.setBranchCode(p_txn.getCbsBranchCode());
		l_req.setModuleCode(p_txn.getModuleCode());
		l_req.setTxnCode(p_txn.getTxnCode());
		l_req.setTxnIdentifier(p_txn.getTxnIdentifier());
		l_req.setAmountDue(p_txn.getAgnAmtDue());
		l_req.setAmountSettled(p_txn.getAgnAmtSettled());
		l_req.setCcyCode(p_txn.getAgnAmtDueCcy());
		l_req.setFullPartIndicator(p_txn.getFullPartialInd());
		
		
		l_req.setIsGroupLoan(p_txn.getIsGroupLoan());
		l_req.setIsParentLoan(p_txn.getIsParentLoan());
		l_req.setIsParentCust(p_txn.getIsParentCust());
		l_req.setParentCustId(p_txn.getParentCustId());
		l_req.setParentCbsAccRefNo(p_txn.getParentCbsAccRefNo());
		l_req.setTxnInitTime(p_txn.getLogTime());
		return l_req;
	}
	private CbsDepositCollectionRequest buildDepositCollectionRequest(
			CbsTransaction p_txn) {
		CbsDepositCollectionRequest l_req = new CbsDepositCollectionRequest();
		
		l_req.setIbsOutSeqNo(p_txn.getMfiOutSeqno());
		l_req.setTxnRefNo(p_txn.getMbsTxnRefNo());
		//l_req.setSeqNo(p_txn.get);
		l_req.setDepositAccNo(p_txn.getCbsAcRefNo());
		l_req.setCustId(p_txn.getCustomerId());
		l_req.setBranchCode(p_txn.getCbsBranchCode());
		l_req.setModuleCode(p_txn.getModuleCode());
		l_req.setTxnCode(p_txn.getTxnCode());
		l_req.setTxnIdentifier(p_txn.getTxnIdentifier());
		l_req.setAmountDue(p_txn.getAgnAmtDue());
		l_req.setAmountSettled(p_txn.getAgnAmtSettled());
		l_req.setCcyCode(p_txn.getAgnAmtDueCcy());
		l_req.setFullPartIndicator(p_txn.getFullPartialInd());
		
		l_req.setTxnInitTime(p_txn.getLogTime());
		
		return l_req;
	}
	private CbsDepositMaturityPayoutRequest buildDepositMaturitPayoutRequest(
			CbsTransaction p_txn) {
		CbsDepositMaturityPayoutRequest l_req = new CbsDepositMaturityPayoutRequest();
		l_req.setIbsOutSeqNo(p_txn.getMfiOutSeqno());
		l_req.setTxnRefNo(p_txn.getMbsTxnRefNo());
		//l_req.setSeqNo(p_txn.get);
		l_req.setDepositAccNo(p_txn.getCbsAcRefNo());
		l_req.setCustId(p_txn.getCustomerId());
		l_req.setBranchCode(p_txn.getCbsBranchCode());
		l_req.setModuleCode(p_txn.getModuleCode());
		l_req.setTxnCode(p_txn.getTxnCode());
		l_req.setTxnIdentifier(p_txn.getTxnIdentifier());
		l_req.setAmountDue(p_txn.getAgnAmtDue());
		l_req.setAmountSettled(p_txn.getAgnAmtSettled());
		l_req.setCcyCode(p_txn.getAgnAmtDueCcy());
		l_req.setFullPartIndicator(p_txn.getFullPartialInd());
		l_req.setTxnInitTime(p_txn.getLogTime());
		return l_req;
	}
	private CbsDepositRedemptionPayoutRequest buildDepositRedemptionRequest(
			CbsTransaction p_txn) {
		CbsDepositRedemptionPayoutRequest l_req = new CbsDepositRedemptionPayoutRequest();
		l_req.setIbsOutSeqNo(p_txn.getMfiOutSeqno());
		l_req.setTxnRefNo(p_txn.getMbsTxnRefNo());
		//l_req.setSeqNo(p_txn.get);
		l_req.setDepositAccNo(p_txn.getCbsAcRefNo());
		l_req.setCustId(p_txn.getCustomerId());
		l_req.setBranchCode(p_txn.getCbsBranchCode());
		l_req.setModuleCode(p_txn.getModuleCode());
		l_req.setTxnCode(p_txn.getTxnCode());
		l_req.setTxnIdentifier(p_txn.getTxnIdentifier());
		l_req.setAmountDue(p_txn.getAgnAmtDue());
		l_req.setAmountSettled(p_txn.getAgnAmtSettled());
		l_req.setCcyCode(p_txn.getAgnAmtDueCcy());
		l_req.setFullPartIndicator(p_txn.getFullPartialInd());
		l_req.setTxnInitTime(p_txn.getLogTime());
		return l_req;
	}
	
	private CbsCashDepositRequest buildCashDepositRequest(
			CbsTransaction p_tran) {

		CbsCashDepositRequest l_req = new CbsCashDepositRequest();
		l_req.setIbsOutSeqNo(p_tran.getMfiOutSeqno());
		l_req.setTxnRefNo(p_tran.getMbsTxnRefNo());
		//l_req.setSeqNo(p_tran.getMbsSeqNo());
		l_req.setAccNo(p_tran.getCbsAcRefNo());
		l_req.setCustId(p_tran.getCustomerId());
		l_req.setBranchCode(p_tran.getCbsBranchCode());
		l_req.setModuleCode(p_tran.getModuleCode());
		l_req.setTxnCode(p_tran.getTxnCode());
		l_req.setTxnIdentifier(p_tran.getTxnIdentifier());
		l_req.setAmountDue(p_tran.getAgnAmtSettled());
		l_req.setAmountSettled(p_tran.getAgnAmtSettled());
		l_req.setCcyCode(p_tran.getTxnCcy());
		
		l_req.setTxnInitTime(p_tran.getLogTime());
		return l_req;
	}

	private CbsCashWithdrawRequest buildCashWithdrawalRequest(
			CbsTransaction p_tran) {
		CbsCashWithdrawRequest l_req = new CbsCashWithdrawRequest();
		l_req.setIbsOutSeqNo(p_tran.getMfiOutSeqno());
		l_req.setTxnRefNo(p_tran.getMbsTxnRefNo());
		//l_req.setSeqNo(p_tran.getMbsSeqNo());
		l_req.setAccNo(p_tran.getCbsAcRefNo());
		l_req.setCustId(p_tran.getCustomerId());
		l_req.setBranchCode(p_tran.getCbsBranchCode());
		l_req.setModuleCode(p_tran.getModuleCode());
		l_req.setTxnCode(p_tran.getTxnCode());
		l_req.setTxnIdentifier(p_tran.getTxnIdentifier());
		l_req.setAmountDue(p_tran.getAgnAmtSettled());
		l_req.setAmountSettled(p_tran.getAgnAmtSettled());
		l_req.setCcyCode(p_tran.getTxnCcy());
		
		l_req.setTxnInitTime(p_tran.getLogTime());
		return l_req;
	}
}
