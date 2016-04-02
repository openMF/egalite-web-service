package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.AgentValidatorDao;
import com.bfsi.mfi.entity.BaseServiceRequest;
import com.bfsi.mfi.service.AgentValidatorService;

/**
 * 
 * @author Shabu
 *
 */
@Service
public class AgentValidatorServiceImpl implements
		AgentValidatorService {
	@Autowired
	private AgentValidatorDao agentValidatorDao;

	@Override
	public String validateAgent(BaseServiceRequest p_request) {
		String l_resCode=null;
		try {
			l_resCode=agentValidatorDao.validateAgent(p_request);
		} catch (DataAccessException e) {
			l_resCode="ERROR";
		}
		catch (Exception e) {
			l_resCode="ERROR";
		}
		
		return l_resCode;
	}

}
