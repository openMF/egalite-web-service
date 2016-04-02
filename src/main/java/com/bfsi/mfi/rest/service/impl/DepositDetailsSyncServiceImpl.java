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

import com.bfsi.mfi.entity.DepositDetailsServiceRequest;
import com.bfsi.mfi.entity.DepositDetailsServiceResponse;
import com.bfsi.mfi.exception.ServiceException;

import com.bfsi.mfi.rest.model.Deposit;
import com.bfsi.mfi.rest.model.DepositDetailsRequest;
import com.bfsi.mfi.rest.model.DepositDetailsResponse;
import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.rest.service.DepositDetailsSyncService;
import com.bfsi.mfi.service.DepositDetailsService;
import com.bfsi.mfi.util.EncryptDecryptUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.DepositDetailVO;

/**
 * 
 * @author Shabu
 * 
 */
@Component("depositDetailsSyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/depositdetails")
public class DepositDetailsSyncServiceImpl implements DepositDetailsSyncService {

	@Autowired
	private DepositDetailsService depositDetailsService;
	private static Map<String, Map<String, Object>> RECVD_MAP = new ConcurrentHashMap<String, Map<String, Object>>();
	private static final String RECVD_ID = "RECVDID";
	private static final String AGENT_SESSION = "AGENTSESSION";
	
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;

	@Override
	@POST
	public JsonResponseWrapper getDepositDetails(
			JsonRequestWrapper p_wrapRequest) {
		DepositDetailsRequest p_request=null;
		try {
			 p_request=(DepositDetailsRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, DepositDetailsRequest.class);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("exception", e);
			return new JsonResponseWrapper();
		}
		
		

		DepositDetailsResponse l_res = null;
		DepositDetailsServiceResponse l_serRes = null;
		DepositDetailsServiceRequest l_serReq = new DepositDetailsServiceRequest();
		Deposit l_deposit = null;
		List<Deposit> l_depositList = new ArrayList<Deposit>();
		try {
			l_res = validate(p_request);
			if (!l_res.getStatus())
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
			l_res.setStatus(false);
			BeanUtils.copyProperties(p_request, l_serReq,
					new String[] { "deviceId" });

			l_serReq.setRecvdDeposits(updateReceivedIds(p_request));

			l_serRes = depositDetailsService.getDepositDetails(l_serReq);
			if (!l_serRes.getStatus()) {
				l_res.setMessageCode("MFI10101");
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
			}
			for (DepositDetailVO l_depositVo : l_serRes.getDepositList()) {
				l_deposit = new Deposit();
				BeanUtils.copyProperties(l_depositVo, l_deposit, new String[] {
						"openDate", "maturityDate", "redemptionPayoutDate",
						"recordStatus", "cbsUploadJobId", "syncStatus",
						"syncTime", "isAllocated" });
				if (l_depositVo.getMaturityDate() != null)
					l_deposit.setOpenDate(l_depositVo.getOpenDate().getTime());
				if (l_depositVo.getMaturityDate() != null)
					l_deposit.setMaturityDate(l_depositVo.getMaturityDate()
							.getTime());
				if (l_depositVo.getRedemptionPayoutDate() != null)
					l_deposit.setRedemptionPayoutDate(l_depositVo
							.getRedemptionPayoutDate().getTime());
				l_depositList.add(l_deposit);
			}
			if (l_depositList.isEmpty())
				endSession(p_request);
			l_res.setStatus(true);
			l_res.setDepositList(l_depositList);
		} catch (ServiceException e) {
			LoggerUtil
					.mbsJobError(
							"Service exception while getting deposit details: MFI10101",
							e);
			l_res.setMessageCode("MFI10101");
		} catch (Exception e) {
			LoggerUtil.mbsJobError(
					"unhandled exception while getting loan deposit: MFI10101",
					e);
			l_res.setMessageCode("MFI10101");
		}

		return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
	}

	@SuppressWarnings("unchecked")
	private List<String> updateReceivedIds(DepositDetailsRequest p_request) {

		List<String> l_Ids = p_request.getRecvdDeposits() == null ? new ArrayList<String>()
				: p_request.getRecvdDeposits();

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

	private void beginSession(DepositDetailsRequest p_request) {
		Map<String, Object> l_agentMap = null;
		if (shouldStartNewSession(p_request)) {
			l_agentMap = new HashMap<String, Object>();
			l_agentMap.put(RECVD_ID, new ArrayList<String>());
			l_agentMap.put(AGENT_SESSION, p_request.getSyncSessionId());
			RECVD_MAP.put(p_request.getAgentId(), l_agentMap);
		}
	}

	private void endSession(DepositDetailsRequest p_request) {
		if (RECVD_MAP.containsKey(p_request.getAgentId()))
			RECVD_MAP.remove(p_request.getAgentId());
	}

	private boolean shouldStartNewSession(DepositDetailsRequest p_request) {

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

	private DepositDetailsResponse validate(DepositDetailsRequest p_request) {
		DepositDetailsResponse l_res = new DepositDetailsResponse();
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
