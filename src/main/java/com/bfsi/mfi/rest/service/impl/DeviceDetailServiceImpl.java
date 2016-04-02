package com.bfsi.mfi.rest.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.model.DeviceDetail;
import com.bfsi.mfi.rest.model.DeviceResponse;
import com.bfsi.mfi.rest.service.DeviceDetailService;
import com.bfsi.mfi.service.DeviceService;
import com.bfsi.mfi.util.ApplicationUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.DeviceVO;

@Component("deviceDetailServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/device/")
public class DeviceDetailServiceImpl implements DeviceDetailService {

	@Autowired
	private DeviceService deviceService;

	public DeviceService getDeviceServiceImp() {
		return deviceService;
	}

	public void setDeviceServiceImp(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	@Override
	@GET
	public DeviceResponse getDeviceDetail() {

		DeviceResponse response = new DeviceResponse();
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest req = (HttpServletRequest) message
				.get(AbstractHTTPDestination.HTTP_REQUEST);
		HttpSession sess = req.getSession(false);
		String id;
		try {
			id = sess.getAttribute("uniqueId").toString();
		} catch (Exception e) {
			response.setDevicedetail(null);
			response.setMessageCode("MFI00253");						
			LoggerUtil.mbsJobError("unhandeled Exception while get agent list : MFI00253", e);
			return response;
		}
		DeviceVO device;
		try {
			device = getDeviceServiceImp().getDeviceDetail(id);
			DeviceDetail deviceDetail = new DeviceDetail();
			BeanUtils.copyProperties(device, deviceDetail, new String[]{"issuedDate","lastSync"});
			deviceDetail.setIssuedDate(ApplicationUtil.dateAsLongFormat(device.getIssuedDate()));
			deviceDetail.setLastSync(ApplicationUtil.dateAsLongFormat(device.getLastSync()));
			if (deviceDetail.getLastSync() == 0L)
				deviceDetail.setLastSync(ApplicationUtil.dateAsLongFormat(new Date(0L)));
			response.setDevicedetail(deviceDetail);
			response.setStatus(true);
		} catch (ServiceException e) {
			response.setMessageCode("MFI10001");						
			LoggerUtil.mbsJobError("ServiceException while get agent list : MFI00253", e);
		}
		return response;
	}
}
