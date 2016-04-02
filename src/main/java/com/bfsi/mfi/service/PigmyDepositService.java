package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.PigmyDeposit;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.PigmyDepositVO;

public interface PigmyDepositService extends
		MaintenanceService<PigmyDepositVO, PigmyDeposit> {
	
	List<PigmyDepositVO> getPigmyDeposits(String agentId, String batchSize)
			throws ServiceException;

	Boolean updatePigmyDepositStaus(List<String> depositAccNoList)
			throws ServiceException;
}
