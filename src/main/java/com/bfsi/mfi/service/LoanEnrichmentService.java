package com.bfsi.mfi.service;

/**
 * @author Jyoti Ranjan
 * 
 */

import java.util.List;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.AgentAllocationsVO;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.LoanVO;

public interface LoanEnrichmentService {

	/**
	 * Fetching Loan details and agent firstname.
	 * 
	 */
	List<AgentAllocationsVO> get() throws ServiceException;

	/**
	 * Fetching Loan details that are unassigned
	 * 
	 */
	List<AgentAllocationsVO> getUnassigned() throws ServiceException;

	/**
	 * Update AgentID.
	 * 
	 */
	void insert(List<AgentAllocationsVO> agentAllocations) throws ServiceException;

	/**
	 * Bulk Update AgentID.
	 * 
	 */
	void insertBulk(List<LoanVO> loans, AgentVO agent, String loggedInUser) throws ServiceException;
}
