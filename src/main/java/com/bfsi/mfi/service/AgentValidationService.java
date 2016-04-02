package com.bfsi.mfi.service;

import com.bfsi.mfi.entity.AgentValidationServiceRequest;
import com.bfsi.mfi.entity.ServiceResponse;
/**
 * 
 * @author Shabu
 *
 */
//EGA-MN15-000017
public interface AgentValidationService {
	
	public ServiceResponse doAgentValidation(AgentValidationServiceRequest p_request);

}
