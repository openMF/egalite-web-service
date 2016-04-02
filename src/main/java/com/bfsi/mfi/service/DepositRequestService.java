package com.bfsi.mfi.service;

import java.util.List;
import java.util.Map;

import com.bfsi.mfi.entity.DepositRequest;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.DepositRequestVO;
import com.bfsi.mfi.vo.DepositTransactionVO;

public interface DepositRequestService extends
		MaintenanceService<DepositRequestVO, DepositRequest> {
	String uploadPigmyDepositRequest(List<DepositRequestVO> depReqList)
			throws ServiceException;

	Map<String, String> uploadRequestStatus(List<String> reqIdlist,
			String sessionid) throws ServiceException;

	String uploadDepositTxnRequest(List<DepositTransactionVO> depTranslist)
			throws ServiceException;
}
