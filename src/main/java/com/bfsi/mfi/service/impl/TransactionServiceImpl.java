package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.cbsadapter.CbsAdapterService;
import com.bfsi.mfi.dao.TransactionDao;
import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.entity.Disbursement;
import com.bfsi.mfi.entity.Repayment;
import com.bfsi.mfi.entity.TransactionServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.job.JobManager;
import com.bfsi.mfi.service.AuthCheckService;
import com.bfsi.mfi.service.TransactionService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgentTransactionVO;

@Service(value = "transactionService")
public class TransactionServiceImpl extends
		MaintenanceServiceImpl<AgentTransactionVO, AgentTransaction> implements
		TransactionService {

	private static final String SUCCESS = "Success";
	private static final String REPAYMENT = "R";
	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private AuthCheckService authcheckservice;

	@Autowired
	private CbsAdapterService cbsAdapterService;

	@Autowired
	private JobManager jobManager;
	
	

	

	public JobManager getJobManager() {
		return jobManager;
	}

	public void setJobManager(JobManager jobManager) {
		this.jobManager = jobManager;
	}

	public CbsAdapterService getCbsAdapterService() {
		return cbsAdapterService;
	}

	public void setCbsAdapterService(CbsAdapterService cbsAdapterService) {
		this.cbsAdapterService = cbsAdapterService;
	}

	public AuthCheckService getAuthcheckservice() {
		return authcheckservice;
	}

	public void setAuthcheckservice(AuthCheckService authcheckservice) {
		this.authcheckservice = authcheckservice;
	}

	@SuppressWarnings("unchecked")
	protected TransactionDao getMaintenanceDao() {
		return transactionDao;
	}

	@Override
	protected AgentTransaction getEntity(AgentTransactionVO vo) {
		AgentTransaction userEntity = new AgentTransaction();
		BeanUtils.copyProperties(vo, userEntity);
		return userEntity;
	}

	@Override
	protected AgentTransactionVO getValueObject(AgentTransaction entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Map<String, String> verifyPostedTransactions(List<String> txnidlist,
			String sessionid) throws ServiceException {
		Map<String, Object> l_postedTranResponse=null;
		Map<String, String> l_tranResponse=new HashMap<String, String>();
		for(String l_txnId: txnidlist){
			l_postedTranResponse=	getMaintenanceDao().getPostedTransaction(l_txnId);
			if(l_postedTranResponse!=null)
				l_tranResponse.put(l_postedTranResponse.get("TXNID").toString(), l_postedTranResponse.get("SESSIONID").toString());
		}
		return l_tranResponse;
	}
	
	@Override
	public Map<String, String> uploadTxnStatus(List<String> txnidlist,
			String sessionid) throws ServiceException {
		Map<String, String> receivedtxns = new HashMap<String, String>();
		List<AgentTransaction> pendingtxns = new ArrayList<AgentTransaction>();

		AgentTransaction agenttxn = null;

		for (String txnid : txnidlist) {
			agenttxn = null;
			try {
				agenttxn = getMaintenanceDao().get(txnid);
			} catch (DataAccessException e) {
				String message = "Error  while getting Txn details with Txn id:"
						+ txnid + ". Error: " + e.getMessage();
				logger.error(message, e);
				throw new ServiceException(message, e);
			}
			if (agenttxn != null) {

				receivedtxns.put(agenttxn.getTxnId(), agenttxn.getSessionId());
			} else {

				agenttxn = new AgentTransaction();
				agenttxn.setTxnId(txnid);
				agenttxn.setSessionId(sessionid);
				pendingtxns.add(agenttxn);
			}
		}
		if (!pendingtxns.isEmpty()) {
			try {
				getMaintenanceDao().deleteTransaction(pendingtxns);
				getMaintenanceDao().inserTxnStatus(pendingtxns);
				
				
			} catch (DataAccessException e) {
				String message = "Error while updating Txn status as Pending:"
						+ ". Error: " + e.getMessage();
				logger.error(message, e);
				throw new ServiceException(message, e);
			}
		}

		return receivedtxns;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public TransactionServiceResponse uploadTransactions(List<AgentTransactionVO> p_txnsList)
			throws ServiceException {
		TransactionServiceResponse l_transRes=new TransactionServiceResponse();
		List<String> l_recvdTrans=new ArrayList<String>();
		AgentTransaction l_agntTran = null;
		
for(AgentTransactionVO l_tran:p_txnsList)	{
	l_agntTran=getEntity(l_tran);	
	try {
		l_transRes=	getMaintenanceDao().uploadTransaction(l_agntTran);
		if(l_transRes.getStatus())
			l_recvdTrans.add(l_tran.getTxnId());		
	} 
	catch (DataAccessException e) {
		LoggerUtil.ibsJobError("DataAccessException while uploading transaction with id: "+l_agntTran.getTxnId(), e);
	}
	catch (Exception e) {
		LoggerUtil.ibsJobError("Unhandled exception while uploading transaction with id: "+l_agntTran.getTxnId(), e);
		throw new ServiceException("Unhandled exception while uploading transaction with id: "+l_agntTran.getTxnId(),e);
	}
	
}
l_transRes.setReceivedTransactions(l_recvdTrans);
l_transRes.setStatus(true);
		return l_transRes;
	}



	
	@Transactional(rollbackFor = Exception.class)
	public String uploadTransactions_1(List<AgentTransactionVO> txnlist)
			throws ServiceException {
		AgentTransaction transaction = null;
		Disbursement disbursement = null;
		Repayment repayment = null;

		List<AgentTransaction> txndatalist = new ArrayList<AgentTransaction>();
		List<Disbursement> disburselist = new ArrayList<Disbursement>();
		List<Repayment> repaymentlist = new ArrayList<Repayment>();

		getAuthcheckservice().checkAuthStatus(txnlist);
		for (AgentTransactionVO txndata : txnlist) {

			transaction = getEntity(txndata);
			txndatalist.add(transaction);
			if (transaction.getTxnType().equals(REPAYMENT)) {
				repayment = new Repayment();
				repayment.setTxnId(transaction.getTxnId());
				repayment.setTxnNarrative(transaction.getTxnNarrative());
				repayment.setTxnAmount(transaction.getTxnAmount());
				repayment.setRepaymentInst(transaction.getRepaymentInst());
				repayment.setTxnCcy(transaction.getTxnCcy());
				
				//nambiAK Vikash
				repayment.setId(transaction.getLoanAcNo());
				repayment.setTxnBranchCode(transaction.getBranchCode());
				repayment.setTxnComponentName(transaction.getTxnComponentName());
				repayment.setTxnSchDueDate(transaction.getTxnSchDueDate());
				repayment.setTxnSchStDate(transaction.getTxnSchStDate());
								
				repaymentlist.add(repayment);
			} else {
				disbursement = new Disbursement();
				disbursement.setTxnId(transaction.getTxnId());
				disbursement.setTxnNarrative(transaction.getTxnNarrative());
				disbursement.setTxnAmount(transaction.getTxnAmount());
				disbursement.setTxnCcy(transaction.getTxnCcy());
				
				//nambiAK Vikash
				disbursement.setId(transaction.getLoanAcNo());
				disbursement.setTxnBranchCode(transaction.getBranchCode());
				disbursement.setTxnComponentName(transaction.getTxnComponentName());
				disbursement.setTxnSchDueDate(transaction.getTxnSchDueDate());
				disbursement.setTxnSchStDate(transaction.getTxnSchStDate());
				
				disburselist.add(disbursement);
			}
		}
		try {
			getMaintenanceDao().insertTransactions(txndatalist, repaymentlist, disburselist);
			getMaintenanceDao().updateRepaySCHScheduleRecords(repaymentlist);
			getMaintenanceDao().updateDisbSCHScheduleRecords(disburselist);
			
		} catch (DataAccessException e) {
			String message = "Error while uploading Transaction :"
					+ ". Error: " + e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}

		try {
			for (AgentTransactionVO trans : txnlist) {
				transaction = getEntity(trans);
				getMaintenanceDao().updateTxnStatus(transaction.getTxnId());
			}
			return SUCCESS;
		} catch (DataAccessException e) {
			String message = "Error while updating Transaction status as Received:"
					+ ". Error: " + e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}

	}

	

}