package com.bfsi.mfi.service;

import java.util.List;
import java.util.Map;

import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.entity.TransactionServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.AgentTransactionVO;

/**
 * @author Pooja
 * 
 */

public interface TransactionService extends
		MaintenanceService<AgentTransactionVO, AgentTransaction> {

	Map<String, String> uploadTxnStatus(List<String> txnidlist, String sessionid)
			throws ServiceException;

	TransactionServiceResponse uploadTransactions(List<AgentTransactionVO> txnlist)
			throws ServiceException;

	Map<String, String> verifyPostedTransactions(List<String> txnidlist,
			String sessionid) throws ServiceException;

}
