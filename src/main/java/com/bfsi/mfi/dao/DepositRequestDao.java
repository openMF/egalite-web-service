package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.DepositRequest;
import com.bfsi.mfi.entity.DepositTransaction;

public interface DepositRequestDao extends MaintenanceDao<DepositRequest> {

	void insertAccOpenReq(List<DepositRequest> depositAccOpenReqList);

	void insertPreMatureReq(List<DepositRequest> preMatureDepReqList);

	void insertPreWithdrwalReq(List<DepositRequest> preWithdrawlReqList);

	void insertRequestList(List<DepositRequest> depositReqList);

	void updateDepositStatus(List<String> reqIdList, String receivedStatus,
			String pendingStatus);

	String isReqIdAvailable(String reqId);

	void deleteReqWithPen(List<String> pendingreqId);

	void inserReqIDwithPen(String reqId, String syncSessionId);

	void insertDepTxnList(List<DepositTransaction> depTxnIdList);

	void insertDepCollTxn(List<DepositTransaction> depCollecList);

	void insertDepMatTxn(List<DepositTransaction> depMatList);

	void insertDepRedTxn(List<DepositTransaction> depRedemList);
}
