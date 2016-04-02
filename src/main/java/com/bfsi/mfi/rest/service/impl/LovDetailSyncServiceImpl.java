package com.bfsi.mfi.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.entity.LovServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.rest.model.Lov;
import com.bfsi.mfi.rest.model.LovRequest;
import com.bfsi.mfi.rest.model.LovResponse;
import com.bfsi.mfi.rest.service.LovDetailSyncService;
import com.bfsi.mfi.service.LovService;
import com.bfsi.mfi.util.EncryptDecryptUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.LovVO;

/**
 * 
 * @author Vishal
 *
 */

@Component("lovDetailSyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/lovDetail")
public class LovDetailSyncServiceImpl implements LovDetailSyncService {
	
	@Autowired
	private LovService lovService;
	
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;

	@Override
	@POST
	public JsonResponseWrapper getLovDetails(JsonRequestWrapper p_wrapRequest) {
		LovRequest p_request=null;
		try {
			 p_request=(LovRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, LovRequest.class);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("exception", e);
			return new JsonResponseWrapper();
		}
		
		
		LovResponse l_res = new LovResponse();
		LovServiceResponse l_serRes = null;
		List<Lov> l_lovList = new ArrayList<Lov>();
		Lov l_lov = null;
		try {
			if(p_request == null){
				l_res.setMessageCode("MFI00251");
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
			}
			
			/*if(p_request.getAgentId() == null || p_request.getDeviceId() == null ){
				l_res.setMessageCode("MFI00250");
				return l_res;
			}*/
			
			l_serRes = lovService.getLovDetails();
			if (!l_serRes.getStatus()) {
				l_res.setMessageCode("MFI00259");
				LoggerUtil.mbsJobDebug("Lov list size is Null :MFI00259");
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
			}
			for (LovVO l_lovVo : l_serRes.getLovList()) {
				l_lov = new Lov();
				BeanUtils.copyProperties(l_lovVo, l_lov);
				l_lovList.add(l_lov);
			}
			l_res.setLovList(l_lovList);
			l_res.setStatus(true);			
			
		} catch (ServiceException e) {
			l_res.setMessageCode("MFI10001");
			LoggerUtil.mbsJobError("ServiceException While in Lov Sync service call : MFI10001",e);
		} catch (Exception e) {
			l_res.setMessageCode("MFI10001");
			LoggerUtil.mbsJobError("Unhandeled Exception While in Lov Sync service call : MFI10001",e);
		}		
		return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
	}

}
