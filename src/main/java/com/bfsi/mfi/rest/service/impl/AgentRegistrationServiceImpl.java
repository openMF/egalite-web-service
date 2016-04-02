package com.bfsi.mfi.rest.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.constants.Constants;
import com.bfsi.mfi.rest.constants.RestServiceConstants;
import com.bfsi.mfi.rest.model.AgentRegistrationRequest;
import com.bfsi.mfi.rest.model.AgentRegistrationResponse;
import com.bfsi.mfi.rest.model.BaseRequest;
import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.rest.service.AgentRegistrationService;
import com.bfsi.mfi.service.AgentService;
import com.bfsi.mfi.util.EncryptDecryptUtil;
import com.bfsi.mfi.util.EncryptionUtils;
import com.bfsi.mfi.util.LoggerUtil;

@Component("agentRegistrationServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/reg")
public class AgentRegistrationServiceImpl implements AgentRegistrationService {
	private static final Logger logger = Logger
			.getLogger(AgentRegistrationServiceImpl.class);
	@Autowired
	private AgentService agentService;
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;

	public AgentService getAgentServiceImp() {
		return agentService;
	}

	public void setAgentServiceImp(AgentService agentService) {
		this.agentService = agentService;
	}

	@Override
	@POST
	@Path("/registration")
	public JsonResponseWrapper doRegistration(
			JsonRequestWrapper p_wrapRequest) {
		AgentRegistrationRequest request=null;
		try {
			 p_wrapRequest.setDataKey(EncryptionUtils.decrypt(RestServiceConstants.DEFAULT_ENC_KEY, p_wrapRequest.getDataKey()));
			 request=(AgentRegistrationRequest)encryptDecryptUtil.getRequestObjectWithExternalKey(p_wrapRequest, AgentRegistrationRequest.class);
			
		} catch (Exception e) {
			LoggerUtil.mbsJobError("Registration Error : MFI10101 :",e);	
			return new JsonResponseWrapper();
		}
	
		AgentRegistrationResponse response = new AgentRegistrationResponse();
		ServiceResponse l_serRes=null;
		String agentId = request.getAgentId();
		String uniqueId = request.getDeviceId();
		String registKey = request.getRegistKey();
		if (agentId == null || uniqueId == null || registKey == null) {
			response.setMessageCode("MFI10102");
			LoggerUtil.mbsJobError("agentId is null or uniqueId is null or registKey is null");
			return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
		}
		try {
			l_serRes = getAgentServiceImp().submitRegistration(
					agentId, uniqueId, registKey);
			if(!l_serRes.getStatus()){
				response.setStatus(l_serRes.getStatus());
				response.setMessageCode(l_serRes.getMessageCode());
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
				}
			response.setDataKey(getAgentServiceImp().generateDataKey(
					agentId));
			Message message = PhaseInterceptorChain.getCurrentMessage();
			HttpServletRequest req = (HttpServletRequest) message
					.get(AbstractHTTPDestination.HTTP_REQUEST);
			HttpSession session = req.getSession(true);
			session.setAttribute("agentId", agentId);
			session.setAttribute("uniqueId", uniqueId);			
			response.setStatus(true);
			response.setMessageCode("MFI10103");
			LoggerUtil.mbsJobDebug("Registration is success. : MFI10103");	
		} catch (ServiceException e) {
			response.setMessageCode("MFI10101");
			LoggerUtil.mbsJobError("Registration Error : MFI10101 :",e);
		}
		 catch (Exception e) {
				response.setMessageCode("MFI10101");
				LoggerUtil.mbsJobError("Registration Error : MFI10101 :",e);				
			}
		return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
	}

	@Override
	@POST
	@Path("/login")
	public JsonResponseWrapper agentLogin(JsonRequestWrapper p_wrapRequest) {
		AgentRegistrationRequest request=null;
		try {
			 request=(AgentRegistrationRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, AgentRegistrationRequest.class);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("exception", e);
			return new  JsonResponseWrapper();
		}
		
		
		AgentRegistrationResponse response = new AgentRegistrationResponse();
		String uniqueId = request.getDeviceId();
		String dataKey = request.getDataKey();
		String agentId = request.getAgentId();
		ServiceResponse l_serRes=null;
		if (agentId == null || uniqueId == null || dataKey == null) {
			LoggerUtil.mbsJobError("agentId is null or uniqueId is null or registKey is null");
			response.setMessageCode("MFI10102");
			return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
		}
		try {
			l_serRes=getAgentServiceImp().agentLoginStatus(
					agentId, uniqueId, dataKey);
			
			if(!l_serRes.getStatus()){
				response.setMessageCode(l_serRes.getMessageCode());
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
			}
			
			Message message = PhaseInterceptorChain.getCurrentMessage();
			HttpServletRequest req = (HttpServletRequest) message
					.get(AbstractHTTPDestination.HTTP_REQUEST);
			HttpSession session = req.getSession(true);
		    session.setAttribute("uniqueId", uniqueId);
			session.setAttribute("agentId", agentId);
			response.setStatus(true);
			response.setMessageCode("MFI10112");
		} catch (ServiceException e) {
			response.setMessageCode("MFI00501");
			LoggerUtil.mbsJobError("Login Error : MFI10101 :",e);
		}
		catch (Exception e) {
			response.setMessageCode("MFI00501");
			LoggerUtil.mbsJobError("Login Error : MFI10101 :",e);
		}
		
		return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
	}

	@Override
	@POST
	@Path("/forgetKey")
	public JsonResponseWrapper doRegistrationForForgetKey(
			JsonRequestWrapper p_wrapRequest) {
		AgentRegistrationRequest request=null;
		try {
			 request=(AgentRegistrationRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, AgentRegistrationRequest.class);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("Exception", e);
			return new JsonResponseWrapper();
		}
		
		AgentRegistrationResponse response = new AgentRegistrationResponse();
		String agentId = request.getAgentId();
		String uniqueId = request.getDeviceId();
		String registKey = request.getRegistKey();
		if (agentId == null || uniqueId == null || registKey == null) {
			response.setStatusText(Constants.NULL_REQUEST_DATA);
			response.setStatus(Constants.STATUS);
			logger.error("agentId is null or uniqueId is null or registKey is null");
			return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
		}
		try {
			response.setStatusText(getAgentServiceImp()
					.submitRegistrationForForgetKey(agentId, uniqueId,
							registKey));
			if (response.getStatusText().equals(Constants.SUCCESS)) {
				response.setDataKey(getAgentServiceImp().generateDataKey(
						agentId));
				response.setStatus(true);
				logger.info("Agent forget Key in Success");
			}

		} catch (ServiceException e) {
			response.setStatusText(e.getMessage());
			logger.error(e);
			e.printStackTrace();
		}

		return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
	}

	@Override
	@POST
	@Path("/registrationConfirm/")
	public JsonResponseWrapper doRegistrationConfirmation(JsonRequestWrapper p_wrapRequest) {
		BaseRequest request=null;
		try {
			 request=(BaseRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, BaseRequest.class);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("Exception",e);
			return new JsonResponseWrapper();
		}
		
		AgentRegistrationResponse response = new AgentRegistrationResponse();
		ServiceResponse l_serRes=null;
		String agentId=request.getAgentId();
		/*try {
			Message message = PhaseInterceptorChain.getCurrentMessage();
			HttpServletRequest req = (HttpServletRequest) message
					.get(AbstractHTTPDestination.HTTP_REQUEST);
			HttpSession sess = req.getSession(false);
			agentId = sess.getAttribute("agentId").toString();
		} catch (Exception ex) {
			response.setMessageCode("MFI10111");
			LoggerUtil.mbsJobError("Failure in registration confirm:: MFI00511",ex);
			return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
		}*/
		try {
			l_serRes=	getAgentServiceImp()
					.doRegistrationConfirmaton(agentId);
			response.setStatus(l_serRes.getStatus());
			response.setMessageCode(l_serRes.getMessageCode());
		} catch (ServiceException e) {
			response.setMessageCode("MFI10101");
			LoggerUtil.mbsJobError("Failure in registration confirm:: MFI00501",e);			
		}
		catch (Exception e) {
			response.setMessageCode("MFI10101");
			LoggerUtil.mbsJobError("Failure in registration confirm:: MFI00501",e);	
		}
		return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
	}

}
