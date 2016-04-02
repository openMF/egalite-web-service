package com.bfsi.mfi.dao.jdbc;

import org.springframework.stereotype.Component;

import com.bfsi.mfi.dao.AgentValidatorDao;
import com.bfsi.mfi.entity.BaseServiceRequest;
/**
 * 
 * @author Shabu
 *
 */
@Component
public class AgentValidatorJdbcDao implements AgentValidatorDao{
	

	@Override
	public String validateAgent(BaseServiceRequest p_request) {
		
		return null;
	}

}
