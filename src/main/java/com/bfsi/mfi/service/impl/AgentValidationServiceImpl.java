package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.AgentValidationDao;
import com.bfsi.mfi.entity.AgentValidationServiceRequest;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.AgentValidationService;

/**
 * 
 * @author Shabu
 *
 */
// EGA-MN15-000017
@Service
public class AgentValidationServiceImpl implements AgentValidationService {

	@Autowired
	private AgentValidationDao agentValidationDao;

	@Override
	public ServiceResponse doAgentValidation(
			AgentValidationServiceRequest p_request) {

		ServiceResponse l_serRes = new ServiceResponse();
		try {

			String l_resString[] = agentValidationDao.checkAgentValidity(
					p_request).split("~");
			if (l_resString[0].equals("0"))
				l_serRes.setStatus(true);
			else {
				l_serRes.setMessageCode(l_resString[1]);
				l_serRes.setHostMessage(l_resString[2]);
			}

		} catch (DataAccessException e) {
			throw new ServiceException(
					"Data Access Exception while validationg agent", e);
		}

		return l_serRes;
	}

}
