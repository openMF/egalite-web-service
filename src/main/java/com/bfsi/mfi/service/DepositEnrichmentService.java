package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.DepositEnrichment;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.AgentAllocationsForDepositVO;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.PigmyDepositVO;

public interface DepositEnrichmentService {

//	List<AgentAllocationsForDepositVO> get() throws ServiceException;
	List<AgentAllocationsForDepositVO> getUnassigned() throws ServiceException;
	void insert(List<AgentAllocationsForDepositVO> agentAllocations) throws ServiceException;
	void insertBulk(List<PigmyDepositVO> deposits, AgentVO agent, String loggedInUser) throws ServiceException;
}
