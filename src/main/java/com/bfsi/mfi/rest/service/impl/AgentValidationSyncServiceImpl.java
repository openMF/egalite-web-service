package com.bfsi.mfi.rest.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.entity.AgentValidationServiceRequest;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.model.AgentValidationRequest;
import com.bfsi.mfi.rest.model.BaseResponse;
import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.rest.service.AgentValidationSyncService;
import com.bfsi.mfi.service.AgentValidationService;
import com.bfsi.mfi.util.EncryptDecryptUtil;
import com.bfsi.mfi.util.LoggerUtil;

/**
 * 
 * @author Shabu
 * 
 */
// EGA-MN15-000017
@Component("agentValidationSyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/validate")
public class AgentValidationSyncServiceImpl implements
		AgentValidationSyncService {

	@Autowired
	private AgentValidationService agentValidationService;
	
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;

	@Override
	@POST
	@Path("/agent")
	public JsonResponseWrapper validateAgent(JsonRequestWrapper p_wrapRequest) {
		AgentValidationRequest p_request=null;
		try {
			 p_request=(AgentValidationRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, AgentValidationRequest.class);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("exception", e);
			return new JsonResponseWrapper();
		}
		BaseResponse l_res = new BaseResponse();

		try {
			
			AgentValidationServiceRequest l_serReq=new AgentValidationServiceRequest();
			BeanUtils.copyProperties(p_request, l_serReq);
			
			ServiceResponse l_serRes=agentValidationService.doAgentValidation(l_serReq);
			
			BeanUtils.copyProperties(l_serRes, l_res);
			l_res.setStatusText(l_serRes.getHostMessage());
			

		} catch (ServiceException e) {
			l_res.setMessageCode("MFI10101");
			LoggerUtil.mbsJobError("Service Exception while doing validation : MFI10101 :",
					e);
		} catch (Exception e) {
			l_res.setMessageCode("MFI10101");
			LoggerUtil.mbsJobError("Unhandled exception while doing validation : MFI10101 :",
					e);
		}
		return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
	}

}
