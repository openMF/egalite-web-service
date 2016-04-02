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

import com.bfsi.mfi.entity.CashPositionServiceRequest;
import com.bfsi.mfi.entity.CashPositionServiceResponse;
import com.bfsi.mfi.exception.ServiceException;

import com.bfsi.mfi.rest.model.CashPositionRequest;
import com.bfsi.mfi.rest.model.CashPositionResponse;
import com.bfsi.mfi.rest.model.CashRecord;
import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.rest.service.AgentCashPositionSyncService;
import com.bfsi.mfi.service.AgentCashPositionService;
import com.bfsi.mfi.util.EncryptDecryptUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgentCashRecordVO;

/**
 * 
 * @author Shabu
 * 
 */
@Component("agentCashPositionSyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/agentCashRecords")
public class AgentCashPositionSyncServiceImpl implements
		AgentCashPositionSyncService {

	@Autowired
	private AgentCashPositionService agentCashPositionService;
	
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;

	@Override
	@POST
	public JsonResponseWrapper getAgentCashPosition(
			JsonRequestWrapper p_wrapRequest) {
		CashPositionRequest p_request=null;
try {
	 p_request=(CashPositionRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, CashPositionRequest.class);
} catch (Exception e) {
	LoggerUtil.mbsJobError("exception", e);
	return new JsonResponseWrapper();
}
		
		
		CashPositionResponse l_res = validate(p_request);
		if (!l_res.getStatus()) {
			
			return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
		}
		l_res.setStatus(false);

		try {

			CashPositionServiceRequest l_serReq = new CashPositionServiceRequest();
			BeanUtils.copyProperties(p_request, l_serReq,
					new String[] { "recvdIds" });
			if (p_request.getRecvdIds() != null
					&& p_request.getRecvdIds().size() > 0)
				l_serReq.setRecvdIds(p_request.getRecvdIds().toArray(
						new String[p_request.getRecvdIds().size()]));

			CashPositionServiceResponse l_serRes = agentCashPositionService
					.getAgentCashPositionDetails(l_serReq);

			List<CashRecord> l_cashRecords = new ArrayList<CashRecord>();
			for (AgentCashRecordVO l_recVo : l_serRes.getCashRecords()) {
				CashRecord l_cashRec = new CashRecord();
				BeanUtils.copyProperties(l_recVo, l_cashRec,
						new String[] { "txnDateTime" });
				if (l_recVo.getTxnDateTime() != null)
					l_cashRec
							.setTxnDateTime(l_recVo.getTxnDateTime().getTime());
				l_cashRecords.add(l_cashRec);
			}

			l_res.setCashRecords(l_cashRecords);
			l_res.setStatus(true);

		} catch (ServiceException e) {
			LoggerUtil
					.mbsJobError(
							"Service exception while getting agent cash  details: MFI10101",
							e);
			l_res.setMessageCode("MFI10101");

		} catch (Exception e) {
			LoggerUtil
					.mbsJobError(
							"unhandled exception while getting agent cash details: MFI10101",
							e);
			l_res.setMessageCode("MFI10101");

		}

		return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
	}

	private CashPositionResponse validate(CashPositionRequest p_request) {
		CashPositionResponse l_res = new CashPositionResponse();

		if (p_request.getAgentId() == null) {
			l_res.setMessageCode("MFI10114");
			return l_res;
		}

		if (p_request.getDeviceId() == null) {
			l_res.setMessageCode("MFI10121");
			return l_res;
		}
		if (p_request.getLocCode() == null) {
			l_res.setMessageCode("MFI10115");
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
