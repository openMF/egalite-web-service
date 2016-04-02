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
import com.bfsi.mfi.rest.model.BeginSyncResponse;
import com.bfsi.mfi.rest.model.BeginTransactionRequest;
import com.bfsi.mfi.rest.model.DepositTransactionRequest;
import com.bfsi.mfi.rest.model.PostDepositTransactionRequest;
import com.bfsi.mfi.rest.service.DepositTransactionSyncService;
import com.bfsi.mfi.service.DepositRequestService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.DepositTransactionVO;

@Component("depositTransactionServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/deposit")
public class DepositTransactionSyncServiceImpl implements
		DepositTransactionSyncService {
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
	public BaseResponse submitDepositTransaction(
			PostDepositTransactionRequest request) {
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

		List<DepositTransactionRequest> depTxnList = new ArrayList<DepositTransactionRequest>();
		depTxnList = request.getDepTxnRequest();
		if (depTxnList.isEmpty()) {
			response.setStatus(false);
			response.setStatusText(Constants.TXN_LIST_EMPTY);
			return response;
		}
		List<DepositTransactionVO> depTranslist = new ArrayList<DepositTransactionVO>();
		for (int i = 0; i < depTxnList.size(); i++) {
			depTranslist.add(new DepositTransactionVO());
			BeanUtils.copyProperties(depTxnList.get(i), depTranslist.get(i),
					new String[] { "txnTimestamp", "syncTime", "depOpenDate",
							"depMatDate", "redemDate" });
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateformt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date syncDate = new Date();
		Date txnDate = null;
		Date depOpenDate = null;
		Date depMatDate = null;
		Date redemDate = null;

		for (int i = 0; i < depTxnList.size(); i++) {
			String txnTime = depTxnList.get(i).getTxnTimestamp();
			try {
				txnDate = dateFormat.parse(txnTime);
				syncDate = dateformt.parse(dateformt.format(syncDate));
				depTranslist.get(i).setTxnTimestamp(txnDate);
				depTranslist.get(i).setSyncTime(syncDate);
				depTranslist.get(i).setDeviceId(deviceId);
				depTranslist.get(i).setTxnStatus(Constants.RAEDY_FOR_CBS);
				depTranslist.get(i).setAuthStatus(Constants.AUTH_STATUS);
				if (depTxnList.get(i).getTxnType()
						.equals(Constants.DEPOSIT_MATURITY)) {
					/*
					 * depOpenDate = dateFormat.parse(depTxnList.get(i)
					 * .getDepOpenDate());
					 */
					/* depTranslist.get(i).setDepOpenDate(depOpenDate); */
					depMatDate = dateFormat.parse(depTxnList.get(i)
							.getDepMatDate());

					depTranslist.get(i).setDepMatDate(depMatDate);
					depTranslist.get(i).setRedempFlag(Constants.NO);
				}
				if (depTxnList.get(i).getTxnType()
						.equals(Constants.DEPOSIT_REDEMPTION)) {
					/*
					 * depOpenDate = dateFormat.parse(depTxnList.get(i)
					 * .getDepOpenDate());
					 */
					/* depTranslist.get(i).setDepOpenDate(depOpenDate); */
					redemDate = dateFormat.parse(depTxnList.get(i)
							.getRedemDate());

					depTranslist.get(i).setRedemDate(redemDate);
					depTranslist.get(i).setRedempFlag(Constants.YES);
				}
			} catch (ParseException e) {
				response.setStatusText(e.getMessage());
				return response;
			}
		}

		try {
			response.setStatusText(getDepositRequestService()
					.uploadDepositTxnRequest(depTranslist));
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
	public BeginSyncResponse beginDepositTxn(BeginTransactionRequest request) {
		BeginSyncResponse response = new BeginSyncResponse();
		List<String> txnIdlist = new ArrayList<String>();
		String syncsessionid = request.getSynsessionid();
		txnIdlist = request.getTxnid();
		if (txnIdlist.isEmpty() || syncsessionid == null) {
			response.setStatus(false);
			response.setStatusText(Constants.TXN_ID_LIST_EMPTY);
			return response;
		}
		try {
			response.setReceivedId(getDepositRequestService()
					.uploadRequestStatus(txnIdlist, syncsessionid));
			response.setStatus(true);
		} catch (ServiceException ex) {
			response.setStatusText(ex.getMessage());
			ex.printStackTrace();
		}
		return response;
	}

}
