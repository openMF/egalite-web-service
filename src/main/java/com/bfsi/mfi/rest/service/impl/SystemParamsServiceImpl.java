package com.bfsi.mfi.rest.service.impl;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.constants.RestServiceConstants;
import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.rest.model.ParametersResponse;
import com.bfsi.mfi.rest.service.SystemParamsService;
import com.bfsi.mfi.service.SystemParameterService;
import com.bfsi.mfi.util.EncryptDecryptUtil;
import com.bfsi.mfi.util.EncryptionUtils;
import com.bfsi.mfi.util.LoggerUtil;


@Component("systemParamsServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/parameters")
public class SystemParamsServiceImpl implements SystemParamsService {

	@Autowired
	private SystemParameterService systemParameterService;
	
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;

	public SystemParameterService getSystemParameterService() {
		return systemParameterService;
	}

	public void setSystemParameterService(
			SystemParameterService systemParameterService) {
		this.systemParameterService = systemParameterService;
	}

	@Override
	@POST
	public JsonResponseWrapper getParameters(JsonRequestWrapper p_wrapRequest) {
		ParametersResponse response = new ParametersResponse();
		 try {
				p_wrapRequest.setDataKey(EncryptionUtils.decrypt(RestServiceConstants.DEFAULT_ENC_KEY, p_wrapRequest.getDataKey()));
			} catch (Exception e) {
				LoggerUtil.mbsJobError(" Error : MFI10101 :",e);	
				return new JsonResponseWrapper();
			}
		
		try {
			response.setParamsValue(getSystemParameterService()
					.getParamsValue());
			response.setStatus(true);
            if( response.getParamsValue().containsKey("CONSOLE_CHECKEDIN_USER"))
           response.getParamsValue().remove("CONSOLE_CHECKEDIN_USER");

		} catch (ServiceException e) {
			response.setStatus(false);
			response.setStatusText(e.getMessage());
			LoggerUtil.mbsJobError(" Error : MFI10101 :",e);	
		}
		
		return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
	}

}
