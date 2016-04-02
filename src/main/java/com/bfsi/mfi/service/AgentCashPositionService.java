package com.bfsi.mfi.service;

import com.bfsi.mfi.entity.CashPositionServiceRequest;
import com.bfsi.mfi.entity.CashPositionServiceResponse;

/**
 * 
 * @author Shabu
 *
 */
public interface AgentCashPositionService {

	public CashPositionServiceResponse getAgentCashPositionDetails(
			CashPositionServiceRequest p_req);

}
