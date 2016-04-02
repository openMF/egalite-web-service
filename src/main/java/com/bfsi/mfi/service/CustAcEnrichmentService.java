package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.CustAcEnrichmentVO;

public interface CustAcEnrichmentService {
	
	/**
	 * Fetching Customer A/c details and agent firstname.
	 * 
	 */
	List<CustAcEnrichmentVO> get() throws ServiceException;

	/**
	 * Fetching Customer A/c details that are unassigned
	 * 
	 */
	List<CustAcEnrichmentVO> getUnassigned() throws ServiceException;

	/**
	 * Update AgentID.
	 * 
	 */
	void insert(List<CustAcEnrichmentVO> agentAllocations) throws ServiceException;

	/**
	 * Bulk Update AgentID.
	 * 
	 */
	void insertBulk(List<CustAcEnrichmentVO> custACs, AgentVO agent, String loggedInUser) throws ServiceException;

}
