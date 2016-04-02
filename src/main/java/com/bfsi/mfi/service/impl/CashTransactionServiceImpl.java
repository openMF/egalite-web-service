package com.bfsi.mfi.service.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.dao.AgentDao;
import com.bfsi.mfi.dao.CbsTransactionDao;
import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.entity.CashTransactionServiceRequest;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CashTransactionService;
import com.bfsi.mfi.util.LoggerUtil;

/**
 * 
 * @author Shabu
 * 
 */
// PENDING
// 1. implement time monitor for cabs call, throw exception when time expires
// 2. define Transaction state codes for the transaction
// 3. tweak the request object based on the CBS response to log the transaction,
// after adapter call
// 4. re-run tru the code and find logical errors, fix accordingly
// 5. do the basic validations
// 6. Do authorise the agent before passing the request
@Service
public class CashTransactionServiceImpl extends CashTransactionService {

	@Autowired
	private AgentDao agentDao;

	@Autowired
	private CbsTransactionDao<AgentTransaction, ServiceResponse> cbsTransactionDao;

	@Override
	public ServiceResponse processCashRequest(
			CashTransactionServiceRequest p_request) throws ServiceException {
		ServiceResponse l_response = new ServiceResponse();
		ServiceResponse l_txnLogResponse = null;
		AgentTransaction l_cashTran = new AgentTransaction();
		CbsBaseResponse l_cbsRes = null;

		try {
			BeanUtils.copyProperties(p_request.getTranVo(), l_cashTran);
			if (agentDao.validateAgentForTransaction(l_cashTran) < 1) {
				// l_response.setMessageCode("MFI10130");
				// return l_response;
			}
			l_cashTran.setRealtimeStatus("NEW");

			l_txnLogResponse = cbsTransactionDao.logTransaction(l_cashTran);

			if (!l_txnLogResponse.getStatus()) {
				// l_response.setMessageCode("FAILED_NO_REVERSE_CODE");
				l_response.setHostMessage("INTERNAL ERROR");
				l_response.setMessageCode("MFI10001");
				return l_response;
			}

			l_cashTran.setIbsTxnOutSeqNo(l_txnLogResponse.getMessageCode());
			// vikash will update by pl-sql function
			//cbsTransactionDao.updateTxnStatus(l_cashTran.getIbsTxnOutSeqNo(),	"Y");
			// Set bussiness Date for cbs
			l_cashTran.setBusiDate(cbsTransactionDao.getCurrentBusinessDate());
			l_cbsRes = sendTransactionToCbs(l_cashTran);
			l_response.setMessageCode(l_cbsRes.getResponseCode());
			l_response.setHostMessage(l_cbsRes.getResponseMessage());
			l_response.setStatus(l_cbsRes.getStatus());
			l_response.setHostRefNo(l_cbsRes.getCbsResTxnRefNo());

			if (!l_response.getStatus())
				// l_cashTran.setRealtimeStatus("FAILED_AT_CBS");
				l_cashTran.setRealtimeStatus("SUC");
			else
				// l_cashTran.setRealtimeStatus("COMPLETD");
				l_cashTran.setRealtimeStatus("FAL");
			LoggerUtil.ibsJobDebug("Generated Out Seq: "
					+ l_txnLogResponse.getMessageCode());
			l_txnLogResponse = cbsTransactionDao.updateLogTransaction(
					l_txnLogResponse.getMessageCode(), l_cbsRes);
			if (!l_txnLogResponse.getStatus()) {
				// l_response.setMessageCode("FAILED_REVERSE_CODE");
				l_response.setHostMessage(l_txnLogResponse.getHostMessage());
				l_response.setMessageCode(l_txnLogResponse.getMessageCode());
				l_response.setStatus(false);
				updateCbsOnFailure();
				return l_response;
			}

		} catch (Exception e) {
			LoggerUtil.mbsJobError("Unhadeled Exception : MFI10001", e);
			// l_response.setMessageCode("FAILED_REVERSE_CODE");
			l_response.setHostMessage("INTERNAL ERROR");
			l_response.setMessageCode("MFI10001");
			l_response.setStatus(false);
			updateCbsOnFailure();
		}
		return l_response;
	}

	private CbsBaseResponse sendTransactionToCbs(
			final AgentTransaction p_cashTran) throws Exception {
		CbsBaseResponse l_cbsRes = null;
		ExecutorService l_executor = null;
		try {
			l_executor = Executors.newSingleThreadExecutor();

			Future<CbsBaseResponse> l_future = l_executor
					.submit(new Callable<CbsBaseResponse>() {
						@Override
						public CbsBaseResponse call() throws Exception {
							return getAdapter(p_cashTran).performTransaction(
									buildRequest(p_cashTran));
						}
					});
			l_cbsRes = l_future.get(10, TimeUnit.SECONDS);
			if (l_cbsRes == null)
				return buildCbsResponseOnError();
		} catch (Exception e) {
			LoggerUtil.mbsJobError("Unhadeled Exception : MFI10001", e);
			return buildCbsResponseOnError();
		} finally {
			try {
				l_executor.shutdown();
			} catch (Exception e2) {

			}

		}
		return l_cbsRes;
	}

	// to do
	private void updateCbsOnFailure() {

	}

	private CbsBaseResponse buildCbsResponseOnError() {

		CbsBaseResponse l_res = new CbsBaseResponse();

		l_res.setCbsResStat("X");
		l_res.setStatus(false);
		l_res.setResponseMessage("Failed while sending transaction to the host");
		l_res.setResponseCode("MFI10001");

		return l_res;

	}

}
