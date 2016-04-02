package com.bfsi.mfi.dao;

import com.bfsi.mfi.entity.AgentValidationServiceRequest;


/**
 * 
 * @author Shabu
 *
 */
//EGA-MN15-000017
public interface AgentValidationDao {
	public String checkAgentValidity(AgentValidationServiceRequest p_request);

}
