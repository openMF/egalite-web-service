package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.DepositRequestDao;
import com.bfsi.mfi.dao.MaintenanceDao;
import com.bfsi.mfi.entity.DepositRequest;
import com.bfsi.mfi.entity.DepositTransaction;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DepositRequestService;
import com.bfsi.mfi.vo.DepositRequestVO;
import com.bfsi.mfi.vo.DepositTransactionVO;

@Service(value = "depositRequestService")
public class DepositRequestServiceImpl extends
		MaintenanceServiceImpl<DepositRequestVO, DepositRequest> implements
		DepositRequestService {

	public static final String NEW_ACCOUNT_OPENING = "N";
	public static final String PREMATURE_REDEMPTION = "R";
	public static final String PREMATURE_OF_DEPOSIT = "P";
	private static final String SUCCESS = "Success";
	private static final String RECEIVED_STATUS = "RECEIVED";
	private static final String PENDING_STATUS = "PENDING";
	public static final Object DEPOSIT_COLLECTION = "C";
	public static final Object DEPOSIT_REDEMPTION = "T";
	public static final Object DEPOSIT_MATURITY = "M";
	@Autowired
	private DepositRequestDao depositRequestDao;

	public DepositRequestDao getDepositRequestDao() {
		return depositRequestDao;
	}

	public void setDepositRequestDao(DepositRequestDao depositRequestDao) {
		this.depositRequestDao = depositRequestDao;
	}

	@Override
	protected <T extends MaintenanceDao<DepositRequest>> T getMaintenanceDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DepositRequest getEntity(DepositRequestVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DepositRequestVO getValueObject(DepositRequest entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String uploadPigmyDepositRequest(List<DepositRequestVO> depReqList)
			throws ServiceException {
		List<DepositRequest> depositReqList = new ArrayList<DepositRequest>();
		List<DepositRequest> depositAccOpenReqList = new ArrayList<DepositRequest>();
		List<DepositRequest> preMatureDepReqList = new ArrayList<DepositRequest>();
		List<DepositRequest> preWithdrawlReqList = new ArrayList<DepositRequest>();
		List<String> reqIdList = new ArrayList<String>();
		DepositRequest depReq = null;
		for (DepositRequestVO depositReq : depReqList) {
			depReq = depositReq.getEntity();
			depositReqList.add(depReq);
		}
		for (DepositRequest depRequest : depositReqList) {
			reqIdList.add(depRequest.getRequestId());
			if (depRequest.getRequestType().equals(NEW_ACCOUNT_OPENING)) {
				depositAccOpenReqList.add(depRequest);
			}
			if (depRequest.getRequestType().equals(PREMATURE_OF_DEPOSIT)) {
				preMatureDepReqList.add(depRequest);
			}
			if (depRequest.getRequestType().equals(PREMATURE_REDEMPTION)) {
				preWithdrawlReqList.add(depRequest);
			}

		}
		try {
			getDepositRequestDao().insertRequestList(depositReqList);
			if (!depositAccOpenReqList.isEmpty())
				getDepositRequestDao().insertAccOpenReq(depositAccOpenReqList);
			if (!preMatureDepReqList.isEmpty())
				getDepositRequestDao().insertPreMatureReq(preMatureDepReqList);
			if (!preWithdrawlReqList.isEmpty())
				getDepositRequestDao().insertPreWithdrwalReq(
						preWithdrawlReqList);
		} catch (DataAccessException e) {
			String message = "Error while uploading Deposit Request :"
					+ ". Error: " + e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}
		try {
			if (!reqIdList.isEmpty()) {
				getDepositRequestDao().updateDepositStatus(reqIdList,
						RECEIVED_STATUS, PENDING_STATUS);
			}
			return SUCCESS;
		} catch (DataAccessException e) {
			String message = "Error while updating Deposit Request status as Received:"
					+ ". Error: " + e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}
	}

	@Override
	public Map<String, String> uploadRequestStatus(List<String> reqIdlist,
			String syncSessionId) throws ServiceException {
		Map<String, String> receivedReqID = new HashMap<String, String>();
		List<String> pendingreqId = new ArrayList<String>();

		String sessionId = null;
		for (String reqId : reqIdlist) {
			try {
				sessionId = getDepositRequestDao().isReqIdAvailable(reqId);
			} catch (DataAccessException e) {
				String message = "Error  while getting deposit  detail with  id:"
						+ reqId + ". Error: " + e.getMessage();
				logger.error(message, e);
				throw new ServiceException(message, e);
			}
			if (sessionId != null) {

				receivedReqID.put(reqId, sessionId);
			} else {

				pendingreqId.add(reqId);
			}
		}
		if (!pendingreqId.isEmpty()) {
			try {
				getDepositRequestDao().deleteReqWithPen(pendingreqId);
				for (int i = 0; i < pendingreqId.size(); i++) {
					getDepositRequestDao().inserReqIDwithPen(
							pendingreqId.get(i), syncSessionId);

				}

			} catch (DataAccessException e) {
				String message = "Error while updating deposits status as Pending:"
						+ ". Error: " + e.getMessage();
				logger.error(message, e);
				throw new ServiceException(message, e);
			}
		}

		return receivedReqID;

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String uploadDepositTxnRequest(
			List<DepositTransactionVO> depTranslist) throws ServiceException {
		List<DepositTransaction> depTxnList = new ArrayList<DepositTransaction>();
		List<DepositTransaction> depCollecList = new ArrayList<DepositTransaction>();
		List<DepositTransaction> depRedemList = new ArrayList<DepositTransaction>();
		List<DepositTransaction> depMatList = new ArrayList<DepositTransaction>();
		List<String> depTxnIdList = new ArrayList<String>();
		// DepositTransaction depTxn = null;
		for (DepositTransactionVO depTxnVo : depTranslist) {
			depTxnList.add(depTxnVo.getEntity());
		}
		for (DepositTransaction depTxn : depTxnList) {

			depTxnIdList.add(depTxn.getTxnId());
			if (depTxn.getTxnType().equals(DEPOSIT_COLLECTION)) {
				depCollecList.add(depTxn);
			}
			if (depTxn.getTxnType().equals(DEPOSIT_REDEMPTION)) {
				depRedemList.add(depTxn);
			}

			if (depTxn.getTxnType().equals(DEPOSIT_MATURITY)) {
				depMatList.add(depTxn);
			}

		}
		try {
			if (!depTxnList.isEmpty())
				getDepositRequestDao().insertDepTxnList(depTxnList);
			if (!depCollecList.isEmpty())
				getDepositRequestDao().insertDepCollTxn(depCollecList);
			if (!depMatList.isEmpty())
				getDepositRequestDao().insertDepMatTxn(depMatList);
			if (!depRedemList.isEmpty())
				getDepositRequestDao().insertDepRedTxn(depRedemList);
		} catch (DataAccessException e) {
			String message = "Error while uploading Deposit Transaction :"
					+ ". Error: " + e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}
		try {
			if (!depTxnIdList.isEmpty()) {
				getDepositRequestDao().updateDepositStatus(depTxnIdList,
						RECEIVED_STATUS, PENDING_STATUS);
			}
			return SUCCESS;
		} catch (DataAccessException e) {
			String message = "Error while updating Deposit Transactions status as Received:"
					+ ". Error: " + e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}
	}
}
