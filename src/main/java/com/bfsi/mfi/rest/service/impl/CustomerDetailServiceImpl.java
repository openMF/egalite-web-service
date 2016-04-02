package com.bfsi.mfi.rest.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.constants.Constants;
import com.bfsi.mfi.rest.model.CustomerConfirmationRequest;
import com.bfsi.mfi.rest.model.CustomerConfirmationResponse;
import com.bfsi.mfi.rest.model.CustomerDetail;
import com.bfsi.mfi.rest.model.CustomerDetailsRequest;
import com.bfsi.mfi.rest.model.CustomerResponse;

import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.rest.service.CustomerDetailService;
import com.bfsi.mfi.service.CustomerService;
import com.bfsi.mfi.util.ApplicationUtil;
import com.bfsi.mfi.util.EncryptDecryptUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CustomerVO;

@Component("customerDetailServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/customers")
public class CustomerDetailServiceImpl implements CustomerDetailService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private static Map<String, Map<String, Object>> RECVD_MAP = new ConcurrentHashMap<String, Map<String, Object>>();
	private static final String RECVD_ID = "RECVDID";
	private static final String AGENT_SESSION = "AGENTSESSION";

	@Autowired
	private CustomerService customerService;
	
	
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	//@GET
	//@Path("/detail")
	public CustomerResponse getCustomers() {
		
		CustomerResponse response = new CustomerResponse();
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest req = (HttpServletRequest) message
				.get(AbstractHTTPDestination.HTTP_REQUEST);
		HttpSession sess = req.getSession(false);
		String agentId = null;
		String batchSize = null;
		try {
			agentId = sess.getAttribute("agentId").toString();
			//batchSize = sess.getAttribute("batchSize").toString();
		} catch (Exception e) {
			response.setStatus(false);
			response.setCustomerDetail(null);
			response.setMessageCode("MFI00253");
			LoggerUtil.mbsJobError("unhandeled Exception while get Customer Deatils : MFI00253", e);
			return response;			
		}
		List<CustomerDetail> customerList = new ArrayList<CustomerDetail>();
		List<CustomerVO> customerVoList = new ArrayList<CustomerVO>();
		try {
			customerVoList = getCustomerService().getCustomers(agentId,null,batchSize,null);
			if(customerVoList != null) {
				for (int i = 0; i < customerVoList.size(); i++) {
					customerList.add(new CustomerDetail());
					BeanUtils.copyProperties(customerVoList.get(i),
							customerList.get(i),new String[]{"dob","customerSince"});
					customerList.get(i).setDob(ApplicationUtil.dateAsLongFormat(customerVoList.get(i).getDob()));
					customerList.get(i).setCustomerSince(ApplicationUtil.dateAsLongFormat(customerVoList.get(i).getCustomerSince()));
				}
				for (int i = 0; i < customerList.size(); i++) {
					if (customerList.get(i).getDob() == 0L){ //bug-233 Jyoti Ranjan
						customerList.get(i).setDob(ApplicationUtil.dateAsLongFormat(getDefaultDate())); //new Date(0l)
						customerList.get(i).setCustomerSince(ApplicationUtil.dateAsLongFormat(getDefaultDate()));
					}
				}
				response.setCustomerDetail(customerList);
				response.setStatus(true);
				LoggerUtil.mbsJobDebug("Success in Customer details ");
			} else {
				response.setCustomerDetail(null);
				response.setStatus(false);
				response.setMessageCode("MFI00254");
				LoggerUtil.mbsJobDebug("Customer details is null ");
			}
		} catch (ServiceException e) {
			response.setStatus(false);
			response.setCustomerDetail(null);
			response.setMessageCode("MFI10001");
			LoggerUtil.mbsJobError("ServiceException while Getting Customer details : MFI10001 ",e);
			return response;
		}
		return response;
	}

	/* Get Default Date.
	 * Bug-233 Jyoti Ranjan */
	Calendar caldate = Calendar.getInstance();
	Date defaultDate;
	private Date getDefaultDate() {
		caldate.set(1111, 00, 01, 00, 00, 00);
		defaultDate=caldate.getTime();
		return defaultDate;
	}
	
	
	@Override
	//@POST
	//@Path("/confirm")
	public CustomerConfirmationResponse submitCustomerConfirmation(
			CustomerConfirmationRequest request) {
		CustomerConfirmationResponse response = new CustomerConfirmationResponse();
		List<String> customerIdList = request.getCustomerIdsList();
		if(customerIdList.isEmpty()){
			response.setStatus(false);
			response.setStatusText(Constants.CUST_LIST_EMPTY);
			return response;
		}
		try {
			response.setStatus(getCustomerService().updateCustomerStatus(
					customerIdList));
			logger.error("Success in Customer detail ");
		} catch (ServiceException e) {
			response.setStatus(false);
			response.setStatusText(e.getMessage());
			logger.error("Failed in Customer details = "+e);
			e.printStackTrace();
		}
		return response;
	}
	@Path("/detail")
	@POST
	@Override
	public JsonResponseWrapper getCustomerList(JsonRequestWrapper p_wrapRequest) {
		CustomerResponse response = null;
		CustomerDetailsRequest p_request=null;
		try {
			 p_request=(CustomerDetailsRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, CustomerDetailsRequest.class);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("exception", e);
			return new JsonResponseWrapper();
		}
		
		
		response = validate(p_request);
		if (!response.getStatus())
			return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
		response.setStatus(false);
		
		List<CustomerDetail> customerList = new ArrayList<CustomerDetail>();
		List<CustomerVO> customerVoList = new ArrayList<CustomerVO>();
		try {
			List<String> l_recvdIds=new ArrayList<String>();
			l_recvdIds.addAll(updateReceivedIds(p_request));
			customerVoList = getCustomerService().getCustomers(p_request.getAgentId(),p_request.getLocCode(),String.valueOf(p_request.getBatchSize()),l_recvdIds);
			if(customerVoList==null ||customerVoList.isEmpty())
				endSession(p_request);
			if(customerVoList != null && !customerVoList.isEmpty()) {
				
				for (int i = 0; i < customerVoList.size(); i++) {
					customerList.add(new CustomerDetail());
					BeanUtils.copyProperties(customerVoList.get(i),
					customerList.get(i),new String[]{"dob","customerSince"});
					customerList.get(i).setSmsRequired(customerVoList.get(i).getSmsFromMbs());
					customerList.get(i).setAgentId(customerVoList.get(i).getAllocatedAgentId());
					customerList.get(i).setDob(ApplicationUtil.dateAsLongFormat(customerVoList.get(i).getDob()));
					customerList.get(i).setCustomerSince(ApplicationUtil.dateAsLongFormat(customerVoList.get(i).getCustomerSince()));
				}
				for (int i = 0; i < customerList.size(); i++) {
					if (customerList.get(i).getDob() == 0L){ //bug-233 Jyoti Ranjan
						customerList.get(i).setDob(ApplicationUtil.dateAsLongFormat(getDefaultDate())); //new Date(0l)
						customerList.get(i).setCustomerSince(ApplicationUtil.dateAsLongFormat(getDefaultDate()));
					}
				}
				response.setCustomerDetail(customerList);
				response.setStatus(true);
				LoggerUtil.mbsJobDebug("Success in Customer details ");
			} else {
				response.setCustomerDetail(new ArrayList<CustomerDetail>());
				response.setStatus(true);
				LoggerUtil.mbsJobDebug("Customer details is empty ");
			}
		} catch (ServiceException e) {
			response.setStatus(false);
			response.setCustomerDetail(null);
			response.setMessageCode("MFI10001");
			LoggerUtil.mbsJobError("ServiceException while Getting Customer details : MFI10001 ",e);
			return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
		}
		return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
	}
	
	@SuppressWarnings("unchecked")
	private List<String> updateReceivedIds(CustomerDetailsRequest p_request) {

		List<String> l_Ids = p_request.getRecvdIds() == null ? new ArrayList<String>()
				: p_request.getRecvdIds();

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

	private void beginSession(CustomerDetailsRequest p_request) {
		Map<String, Object> l_agentMap = null;
		if (shouldStartNewSession(p_request)) {
			l_agentMap = new HashMap<String, Object>();
			l_agentMap.put(RECVD_ID, new ArrayList<String>());
			l_agentMap.put(AGENT_SESSION, p_request.getSyncSessionId());
			RECVD_MAP.put(p_request.getAgentId(), l_agentMap);
		}
	}

	private void endSession(CustomerDetailsRequest p_request) {
		if (RECVD_MAP.containsKey(p_request.getAgentId()))
			RECVD_MAP.remove(p_request.getAgentId());
	}

	private boolean shouldStartNewSession(CustomerDetailsRequest p_request) {

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

	private CustomerResponse validate(CustomerDetailsRequest p_request) {
		CustomerResponse l_res = new CustomerResponse();
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
