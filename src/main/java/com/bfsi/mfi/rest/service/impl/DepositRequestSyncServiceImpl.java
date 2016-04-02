package com.bfsi.mfi.rest.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.bfsi.mfi.rest.constants.Constants;
import com.bfsi.mfi.rest.model.BaseResponse;
import com.bfsi.mfi.rest.model.BeginPigmyDepositRequest;
import com.bfsi.mfi.rest.model.BeginPigmyDepositResponse;
import com.bfsi.mfi.rest.model.DepositRequestDeatil;
import com.bfsi.mfi.rest.model.PigmyDepositRequest;
import com.bfsi.mfi.rest.service.DepositRequestSyncService;
import com.bfsi.mfi.service.DepositRequestService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.DepositRequestVO;

@Component("depositReqSyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/request")
public class DepositRequestSyncServiceImpl implements DepositRequestSyncService {

	@Autowired
	private DepositRequestService depositRequestService;

	public DepositRequestService getDepositRequestService() {
		return depositRequestService;
	}

	public void setDepositRequestService(
			DepositRequestService depositRequestService) {
		this.depositRequestService = depositRequestService;
	}

	@Override
	@POST
	@Path("/posttxn")
	public BaseResponse submitAccOpeningReq(PigmyDepositRequest request) {
		BaseResponse response = new BaseResponse();
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest req = (HttpServletRequest) message
				.get(AbstractHTTPDestination.HTTP_REQUEST);
		HttpSession sess = req.getSession(false);
		String deviceId;
		try {
			deviceId = sess.getAttribute("uniqueId").toString();

		} catch (Exception ex) {
			LoggerUtil.mbsJobError("Unhandeled Exception : MFI10001", ex);
			response.setStatusText(Constants.SESSION_EXPIRED);
			return response;
		}
		List<DepositRequestDeatil> requestList = new ArrayList<DepositRequestDeatil>();
		requestList = request.getDepAccReqList();
		if (requestList.isEmpty()) {
			response.setStatus(false);
			response.setStatusText(Constants.REQUSET_LIST_EMPTY);
			return response;

		}
		List<DepositRequestVO> depReqList = new ArrayList<DepositRequestVO>();
		for (int i = 0; i < requestList.size(); i++) {
			depReqList.add(new DepositRequestVO());
			BeanUtils
					.copyProperties(requestList.get(i), depReqList.get(i),
							new String[] { "requestDate", "depOpenDate",
									"redempReqDate", "maturityDate",
									"firstPaymentDate" });
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateformt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		for (int i = 0; i < requestList.size(); i++) {
			Date syncTime = new Date();
			try {
				syncTime = dateformt.parse(dateformt.format(syncTime));
				Date requestDate = format.parse(requestList.get(i)
						.getRequestDate());

				depReqList.get(i).setSyncTime(syncTime);
				depReqList.get(i).setRequestDate(requestDate);
				depReqList.get(i).setDeviceId(deviceId);
				depReqList.get(i).setAuthStatus(Constants.AUTH_STATUS);
				depReqList.get(i).setRequeststatus(Constants.REQUEST_RECEIVED);
				
				/**
				 *  Add code for MaturityDate for new deposit request.
				 **/
				 SimpleDateFormat userFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			     Date date = null;
			     date = userFormat.parse(requestList.get(i).getMaturityDate());	
				 depReqList.get(i).setMaturityDate(date);
               
				if (requestList.get(i).getRequestType()
						.equals(Constants.NEW_ACCOUNT_OPENING)) {
					depReqList.get(i).setDepositAccNum(Constants.NEW_ACCOUNT);
					Date firstPaymentDate = format.parse(requestList.get(i)
							.getFirstPaymentDate());
					depReqList.get(i).setFirstPaymentDate(firstPaymentDate);
				}
				/*
				 * if (requestList.get(i).getRequestType()
				 * .equals(Constants.PREMATURE_REDEMPTION)) {
				 * 
				 * Date depOpenDate = format.parse(requestList.get(i)
				 * .getDepOpenDate());
				 * 
				 * Date redempReqDate = format.parse(requestList.get(i)
				 * .getRedempReqDate());
				 * 
				 * depReqList.get(i).setDepOpenDate(depOpenDate);
				 * depReqList.get(i).setRedempReqDate(redempReqDate); } if
				 * (requestList.get(i).getRequestType()
				 * .equals(Constants.PREMATURE_OF_DEPOSIT)) {
				 * 
				 * Date depOpenDate = format.parse(requestList.get(i)
				 * .getDepOpenDate()); Date maturityDate =
				 * format.parse(requestList.get(i) .getMaturityDate());
				 * 
				 * depReqList.get(i).setDepOpenDate(depOpenDate);
				 * depReqList.get(i).setMaturityDate(maturityDate);
				 * 
				 * }
				 */
			} catch (ParseException e) {
				response.setStatusText(e.getMessage());
				return response;
			}
		}

		try {
			response.setStatusText(getDepositRequestService()
					.uploadPigmyDepositRequest(depReqList));
			response.setStatus(true);

		} catch (ServiceException ex) {
			response.setStatusText(ex.getMessage());
			ex.printStackTrace();
		}

		return response;
	}

	@Override
	@POST
	@Path("/begintxn")
	public BeginPigmyDepositResponse beginAccOpeningReq(
			BeginPigmyDepositRequest request) {
		BeginPigmyDepositResponse response = new BeginPigmyDepositResponse();
		List<String> reqidlist = new ArrayList<String>();
		String syncsessionid = request.getSynsessionid();
		reqidlist = request.getRequestIdList();
		if (reqidlist.isEmpty() || syncsessionid == null) {
			response.setStatus(false);
			response.setStatusText(Constants.REQUSET_LIST_EMPTY);
			return response;
		}
		try {
			response.setReceivedReqId(getDepositRequestService()
					.uploadRequestStatus(reqidlist, syncsessionid));
			response.setStatus(true);
		} catch (ServiceException ex) {
			response.setStatusText(ex.getMessage());
			ex.printStackTrace();
		}
		return response;
	}
	
}
