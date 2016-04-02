package com.bfsi.mfi.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.cbs.model.CbsTransaction;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.dao.CbsTransactionDao;
import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CbsTransactionService;
import com.bfsi.mfi.util.LoggerUtil;

/**
 * 
 * @author Shabu
 * 
 */
@Service("cbsTransactionService")
public class CbsTransactionServiceImpl extends CbsTransactionService {

	private static final String ROW_NUM = "10";

	@Autowired
	private CbsTransactionDao<AgentTransaction, ServiceResponse> cbsTransactionDao;
	


	@Override
	public void process() throws ServiceException {
		Date l_bussinessDate =null;
		LoggerUtil.ibsJobDebug("--background process--=======");
		//EGA-MN15-000024   START
		CbsBaseResponse l_cbsSerRes =null;
		boolean l_forceExit=false;
		//EGA-MN15-000024   END
		while (true) {
			try {
				l_bussinessDate = cbsTransactionDao.getCurrentBusinessDate();
				List<CbsTransaction> l_tranList = pickTransaction();
				if (l_tranList == null || l_tranList.isEmpty()) {
					break;
				} else {
					for (CbsTransaction l_tran : l_tranList) {
						l_tran.setBusiDate(l_bussinessDate);
						//EGA-MN15-000024   START
						l_cbsSerRes=processTransaction(l_tran);
						if(l_cbsSerRes!=null && l_cbsSerRes.getCbsResStat().equals("X")){
							l_forceExit=true;
							break;
						}
						//EGA-MN15-000024   END
					}
					//EGA-MN15-000024   START
					if(l_forceExit)
						break;
					//EGA-MN15-000024   END
				}
			} catch (Exception e) {
				LoggerUtil.cbsJobError(
						"Exception while processing transaction", e);
				break;
			}
		}
	}

	private CbsBaseResponse processTransaction(final CbsTransaction p_tran)
			throws Exception {

		CbsBaseResponse l_res = sendTransactionToCbs(p_tran);
		ServiceResponse l_txnLogResponse = null;
		try {
			l_txnLogResponse = cbsTransactionDao.updateLogTransaction(
					p_tran.getMfiOutSeqno(), l_res);
			if (!l_txnLogResponse.getStatus()) {
				updateCbsOnFailure();
			}
		} catch (Exception e) {
			updateCbsOnFailure();
		}
		return l_res;
	}

	private synchronized List<CbsTransaction> pickTransaction() {
		List<CbsTransaction> l_tran = null;
		try {
			l_tran = cbsTransactionDao.getUnprocessedTransaction(ROW_NUM);
		} catch (DataAccessException e) {
			LoggerUtil.cbsJobError("DataAccessException :", e);
			return null;
		}
		// commented because of vikash is doing by proc
		//cbsTransactionDao.updateReqTransactionStatus(l_tran, "Y");
		return l_tran;
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

	private CbsBaseResponse sendTransactionToCbs(final CbsTransaction p_tran) {
		CbsBaseResponse l_res = null;
		ExecutorService l_executor = null;
		try {
			l_executor = Executors.newSingleThreadExecutor();
			Future<CbsBaseResponse> l_future = l_executor
					.submit(new Callable<CbsBaseResponse>() {
						@Override
						public CbsBaseResponse call() throws Exception {
							/*LoggerUtil.cbsJobDebug("Txn : "+p_tran);
							LoggerUtil.cbsJobDebug("Txn Code: "+p_tran.getTxnCode());
							LoggerUtil.cbsJobDebug("Txn Adapter: "+getAdapter(p_tran));
							LoggerUtil.cbsJobDebug("Txn Req: "+buildRequest(p_tran));
							*/return getAdapter(p_tran).performTransaction(
									buildRequest(p_tran));
						}
					});
			l_res = l_future.get(10, TimeUnit.SECONDS);
			if (l_res == null)
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
		return l_res;
	}

	@Override

	public synchronized void populateTxnTables() {
		try {
		ServiceResponse l_res=	cbsTransactionDao.startDailyJob();
		LoggerUtil.ibsJobDebug("PL/SQL Job status: "+l_res.getStatus());
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Exception while running PL/SQL job", e);
		}
		
	}
}
