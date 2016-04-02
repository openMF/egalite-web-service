package com.bfsi.mfi.rest.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;









import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.constants.RestServiceConstants;
import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.rest.model.ParametersResponse;
import com.bfsi.mfi.rest.model.SmsTemplate;
import com.bfsi.mfi.rest.model.StaticDataRequest;
import com.bfsi.mfi.rest.model.StaticDataResponse;
import com.bfsi.mfi.rest.service.AgentDetailService;
import com.bfsi.mfi.rest.service.BranchSyncService;
import com.bfsi.mfi.rest.service.CurrencySyncService;
import com.bfsi.mfi.rest.service.CustomerDetailService;
import com.bfsi.mfi.rest.service.DeviceDetailService;
import com.bfsi.mfi.rest.service.StaticDataSyncService;
import com.bfsi.mfi.rest.service.SystemParamsService;
import com.bfsi.mfi.service.SmsTemplateSyncService;
import com.bfsi.mfi.util.EncryptDecryptUtil;
import com.bfsi.mfi.util.EncryptionUtils;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.SmsTemplateSyncVO;

/**
 * 
 * @author Vishal
 *
 */

@Component("staticDataSyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/static")
public class StaticDataSyncServiceImpl implements StaticDataSyncService {
	
	@Autowired
	private BranchSyncService branchService;
	
	@Autowired
	private CurrencySyncService currencyService;
	
	@Autowired
	private CustomerDetailService customerService;
	
	@Autowired
	private AgentDetailService agentService;
	
	@Autowired
	private DeviceDetailService deviceService;
	
	
	@Autowired
	private SystemParamsService systemParamsService;
	
	@Autowired
	private SmsTemplateSyncService smsTemplateSyncService;
	
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;
	
		
	
	@Override
	@POST	
	public JsonResponseWrapper getStaticDataList(JsonRequestWrapper p_wrapRequest) {	
		StaticDataRequest request=null;
		
		try {
			 request=(StaticDataRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, StaticDataRequest.class);
		} catch (Exception e) {

LoggerUtil.mbsJobError("exception", e);
return new JsonResponseWrapper();
		}
		
	
		
		StaticDataResponse response = new StaticDataResponse();
		String agentId = null;
		String uniqueId = null;
		String batchSize = null;
		if(request != null){
			agentId = request.getAgentId();
			uniqueId = request.getDeviceId();	
			batchSize = String.valueOf(request.getBatchSize());
		} 
		LoggerUtil.mbsJobDebug("Static Data Upload agentId : uniqueId : batchSize :: "+agentId + " : " +uniqueId + " : "+batchSize);
		if(agentId == null || uniqueId==null) {
			
			response.setMessageCode("MFI10113");
			LoggerUtil.mbsJobDebug("Agent Id or Device Id should not be Null");
			return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
			
		} 		
			try{
				Message message = PhaseInterceptorChain.getCurrentMessage();
				HttpServletRequest req = (HttpServletRequest) message
						.get(AbstractHTTPDestination.HTTP_REQUEST);
				HttpSession session = req.getSession(true);
				session.setAttribute("agentId", agentId);
				session.setAttribute("uniqueId", uniqueId);
				//session.setAttribute("batchSize", batchSize);
				// call the implementation method
				response  =  getEachStaticDataList(p_wrapRequest);
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
			} catch(ServiceException ex){
				LoggerUtil.mbsJobError("ServiceException while get static data list : MFI10001", ex);				
				response.setMessageCode("MFI10101");			
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
			}
			catch(Exception ex){
				LoggerUtil.mbsJobError("Unhandled Exception while get static data list : MFI10001", ex);				
				response.setMessageCode("MFI10101");			
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
			}
		
		
	}
	
	
	private StaticDataResponse getEachStaticDataList(JsonRequestWrapper p_wrapRequest) {
		StaticDataResponse response = new StaticDataResponse();		
		LoggerUtil.mbsJobDebug("Static Data Upload started");
		List<SmsTemplateSyncVO> l_smsTempVoList = new ArrayList<SmsTemplateSyncVO>();
		List<SmsTemplate> l_smsTempList = new ArrayList<SmsTemplate>();
		SmsTemplate l_smsTemp = null;
		
		// setting System Parameter in responce

		try {
			String l_dataKey = new String(p_wrapRequest.getDataKey());
			p_wrapRequest.setDataKey(EncryptionUtils.encrypt(RestServiceConstants.DEFAULT_ENC_KEY, p_wrapRequest.getDataKey()));
			JsonResponseWrapper l_resWrp=systemParamsService.getParameters(p_wrapRequest);
			p_wrapRequest.setDataKey(l_dataKey);
			l_resWrp.setDataKey(l_dataKey);
			ParametersResponse l_parasRes=(ParametersResponse) encryptDecryptUtil.getResponseObject(l_resWrp, ParametersResponse.class);
			
			response.setParamsValue(l_parasRes.getParamsValue());
				
		} catch (Exception ex) {
			LoggerUtil.mbsJobError("ServiceException while get System Parameter : MFI10001", ex);				
			response.setMessageCode("MFI10001");				
			return response;
		}

		// Setting branch details in response
		
		try {			
			response.setBranchDetail(branchService.getBranchList().getBranchDetail());
				
		} catch (ServiceException ex) {
			LoggerUtil.mbsJobError("ServiceException while get branch list : MFI10001", ex);				
			response.setMessageCode("MFI10001");				
			return response;
		}
		
		// setting currency details in response	
		
		try {	
			response.setCurrencyDetail(currencyService.getCurrencyList().getCurrencyDetail());
				
		} catch (ServiceException ex) {
			LoggerUtil.mbsJobError("ServiceException while get currency list : MFI10001", ex);				
			response.setMessageCode("MFI10001");				
			return response;
		}
		
		// setting customer details in response
		
	/*	try {			
			response.setCustomerList(customerService.getCustomers().getCustomerDetail());
				
		} catch (ServiceException ex) {
			LoggerUtil.mbsJobError("ServiceException while get Customer list : MFI10001", ex);				
			response.setMessageCode("MFI10001");				
			return response;
		}*/
		
		// setting Agent details in response
		
		try {			
			response.setAgentDetail(agentService.getAgentDetail().getAgentdetail());
				
		} catch (ServiceException ex) {
			LoggerUtil.mbsJobError("ServiceException while get agent list : MFI10001", ex);				
			response.setMessageCode("MFI10001");				
			return response;
		}
		
		// setting Device Details in responce
		
		try {			
			response.setDevicedetail(deviceService.getDeviceDetail().getDevicedetail());
				
		} catch (ServiceException ex) {
			LoggerUtil.mbsJobError("ServiceException while get device list : MFI10001", ex);				
			response.setMessageCode("MFI10001");				
			return response;
		} 
		
		// setting Sms Template in responce
		try {	
			l_smsTempVoList = smsTemplateSyncService.getSmsTemplate();
			for(SmsTemplateSyncVO l_smsTempVo : l_smsTempVoList){
				l_smsTemp = new SmsTemplate();
				BeanUtils.copyProperties(l_smsTempVo, l_smsTemp);
				l_smsTempList.add(l_smsTemp);				
			}
			response.setSmsTempList(l_smsTempList);
				
		} catch (ServiceException ex) {
			LoggerUtil.mbsJobError("ServiceException while get sms Template list : MFI10001", ex);				
			response.setMessageCode("MFI10001");				
			return response;
		}
		response.setStatus(true);
		LoggerUtil.mbsJobDebug("Static Data Upload End");
		return response;
	}	

}
