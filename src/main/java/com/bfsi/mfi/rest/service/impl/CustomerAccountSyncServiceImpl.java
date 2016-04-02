package com.bfsi.mfi.rest.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.entity.CustomerAccountServiceRequest;
import com.bfsi.mfi.entity.CustomerAccountServiceResponse;
import com.bfsi.mfi.exception.ServiceException;

import com.bfsi.mfi.rest.model.CustomerAccount;
import com.bfsi.mfi.rest.model.CustomerAccountRequest;
import com.bfsi.mfi.rest.model.CustomerAccountResponse;
import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.rest.service.CustomerAccountSyncService;
import com.bfsi.mfi.service.CustomerAccountService;
import com.bfsi.mfi.util.EncryptDecryptUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CustomerAccountVO;



@Component("customerAccountSyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/customerAccount")
public class CustomerAccountSyncServiceImpl implements CustomerAccountSyncService {
	
	private static Map<String, Map<String, Object>> RECVD_MAP = new ConcurrentHashMap<String, Map<String, Object>>();
	private static final String RECVD_ID = "RECVDID";
	private static final String AGENT_SESSION = "AGENTSESSION";
	@Autowired
	private CustomerAccountService customerAccountService;
	
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;

	@Override
	@POST	
	public JsonResponseWrapper getCustomerAccounts(
			JsonRequestWrapper p_wrapRequest) {
		CustomerAccountRequest p_req=null;
		try {
			 p_req=(CustomerAccountRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, CustomerAccountRequest.class);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("exception", e);
			return new JsonResponseWrapper();
		}
		
		
		CustomerAccountResponse l_res = null;
		CustomerAccountServiceResponse l_serRes = null;
		CustomerAccount l_customerAcc = null;
		List<CustomerAccount> l_CustomerAccList = new ArrayList<CustomerAccount>();
		CustomerAccountServiceRequest l_serReq = new CustomerAccountServiceRequest();		
		try {
			l_res = validate(p_req);
			if (!l_res.getStatus()) {
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
			}
			BeanUtils.copyProperties(p_req, l_serReq,
					new String[] { "deviceId" });
			l_serReq.setRcvCustAcc(updateReceivedIds(p_req));
			l_serRes = customerAccountService.getCustomerAccount(l_serReq) ;
			if (!l_serRes.getStatus()) {
				l_res.setMessageCode("MFI10101");
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
			}
			for (CustomerAccountVO l_customerAccVo : l_serRes.getCustomeAccList()) {
				l_customerAcc = new CustomerAccount();
				 BeanUtils.copyProperties(l_customerAccVo, l_customerAcc, new String[]{});
				 l_CustomerAccList.add(l_customerAcc);
			}
			
			if(l_CustomerAccList.isEmpty()){
				endSession(p_req);
			}
			l_res.setStatus(true);
			l_res.setCustAccList(l_CustomerAccList);
			
		}catch (ServiceException e) {
			LoggerUtil.mbsJobError("Service exception while getting Customer Acount: MFI10101",e);
			l_res.setMessageCode("MFI10101");
		} catch (Exception e) {
			LoggerUtil.mbsJobError(	"unhandled exception while getting Customer Acount: MFI10101",	e);
			l_res.setMessageCode("MFI10101");
		}
		return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
				
	}
	
	private void beginSession(CustomerAccountRequest p_request) {
		Map<String, Object> l_agentMap = null;
		if (shouldStartNewSession(p_request)) {
			l_agentMap = new HashMap<String, Object>();
			l_agentMap.put(RECVD_ID, new ArrayList<String>());
			l_agentMap.put(AGENT_SESSION, p_request.getSyncSessionId());
			RECVD_MAP.put(p_request.getAgentId(), l_agentMap);
		}
	}
	
	private void endSession(CustomerAccountRequest p_request) {
		if (RECVD_MAP.containsKey(p_request.getAgentId()))
			RECVD_MAP.remove(p_request.getAgentId());
	}
	
	private boolean shouldStartNewSession(CustomerAccountRequest p_request) {

		if (!RECVD_MAP.containsKey(p_request.getAgentId())) {
			LoggerUtil.mbsJobDebug("Agent Is NULL in the map: "
					+ p_request.getAgentId());
			return true;
		}

		if (!RECVD_MAP.get(p_request.getAgentId()).containsKey(AGENT_SESSION)) {
			LoggerUtil.mbsJobDebug("Session Id is null in the map ");
			RECVD_MAP.remove(p_request.getAgentId());
			return true;
		}
		if (((String) RECVD_MAP.get(p_request.getAgentId()).get(AGENT_SESSION))
				.equals(p_request.getSyncSessionId())) {
			LoggerUtil.mbsJobDebug("getting records for same session");
			return false;
		}
		LoggerUtil.mbsJobDebug("session Is different");
		RECVD_MAP.remove(p_request.getAgentId());
		return true;
	}
	
	@SuppressWarnings("unchecked")
	private List<String> updateReceivedIds(CustomerAccountRequest p_request) {

		List<String> l_Ids = p_request.getRcvCustAcc() == null ? new ArrayList<String>()
				: p_request.getRcvCustAcc();

		beginSession(p_request);

		List<String> l_recvdIds = new ArrayList<String>();

		if (!RECVD_MAP.get(p_request.getAgentId()).containsKey(RECVD_ID))
			RECVD_MAP.get(p_request.getAgentId()).put(RECVD_ID,
					new ArrayList<String>());

		l_recvdIds = (List<String>) RECVD_MAP.get(p_request.getAgentId()).get(
				RECVD_ID);
		l_recvdIds.addAll(l_Ids);
		RECVD_MAP.get(p_request.getAgentId()).put(RECVD_ID, l_recvdIds);

		LoggerUtil.mbsJobDebug("Map after initi for agent: "
				+ p_request.getAgentId() + "::" + RECVD_MAP);
		return l_recvdIds;
	}
	
	private CustomerAccountResponse validate(CustomerAccountRequest p_request) {
		CustomerAccountResponse l_res = new CustomerAccountResponse();
		if (p_request.getAgentId() == null) {
			l_res.setMessageCode("MFI10114");
			return l_res;
		}
		if (p_request.getLocCode() == null) {
			l_res.setMessageCode("MFI10115");
			return l_res;
		}
		if (p_request.getSyncSessionId() == null) {
			l_res.setMessageCode("MFI10116");
			return l_res;
		}
		if (p_request.getBatchSize() <= 0) {
			l_res.setMessageCode("MFI10117");
			return l_res;
		}
		l_res.setStatus(true);
		return l_res;

	}

}
