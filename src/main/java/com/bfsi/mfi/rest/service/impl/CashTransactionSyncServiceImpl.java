package com.bfsi.mfi.rest.service.impl;

import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.entity.CashTransactionServiceRequest;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;

import com.bfsi.mfi.rest.model.CashTransactionRequest;
import com.bfsi.mfi.rest.model.CashTransactionResponse;
import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.rest.service.CashTransactionSyncService;
import com.bfsi.mfi.service.CashTransactionService;
import com.bfsi.mfi.util.EncryptDecryptUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgentTransactionVO;

/**
 * 
 * @author Shabu
 * 
 */
@Component("cashTransactionSyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/cashtransaction")
// PENDING
// 1. re-run tru the code and find logical errors, fix accordingly
// 2. cross check the beanuil.copyProperties for variables
public class CashTransactionSyncServiceImpl implements
		CashTransactionSyncService {

	@Autowired
	private CashTransactionService cashTransactionService;
	
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;

	@Override
	@POST
	public JsonResponseWrapper processCashRequest(
			JsonRequestWrapper p_wrapRequest) {
		CashTransactionRequest p_request=null;
		try {
			 p_request=(CashTransactionRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, CashTransactionRequest.class);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("exception", e);
			return new JsonResponseWrapper();
		}
		
		
		CashTransactionServiceRequest l_serReq = new CashTransactionServiceRequest();
		l_serReq.setTranVo(new AgentTransactionVO());
		CashTransactionResponse l_res = null;
		try {
			l_res = validate(p_request);
			if (!l_res.getStatus())
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
			l_res.setStatus(false);
			BeanUtils.copyProperties(p_request,
					l_serReq.getTranVo(),
					new String[] { "txnInitTime", "accNo"});
			l_serReq.getTranVo().setCbsAccRefNo(p_request.getAccNo());
			l_serReq.getTranVo().setModuleCode("CW");
			l_serReq.getTranVo().setGenerateReversal("N");
			l_serReq.getTranVo().setTxnSettlementAmount(p_request.getTxnAmount());
			l_serReq.getTranVo().setSeqNo(1);
			l_serReq.getTranVo().setTxnAmount(null);
			
			Calendar l_cal = Calendar.getInstance();
		
			if (p_request.getTxnInitTime() != null) {
				l_cal.setTimeInMillis(p_request.getTxnInitTime());
				l_serReq.getTranVo().setTxnInitTime(l_cal.getTime());
			}
			
			ServiceResponse l_serRes = cashTransactionService
					.processCashRequest(l_serReq);

			l_res.setStatus(l_serRes.getStatus());
			l_res.setMessageCode(l_serRes.getMessageCode());
			l_res.setStatusText(l_serRes.getHostMessage());
			l_res.setHostRefNo(l_serRes.getHostRefNo());
		} catch (ServiceException e) {
			LoggerUtil.mbsJobError(
					"Service exception while processing cash request", e);
			//l_res.setMessageCode("FAILED_REVERSE_CODE"); MFI10101
			l_res.setMessageCode("MFI10101"); 
		} catch (Exception e) {
			LoggerUtil.mbsJobError(
					"unhandled exception while processing cash request", e);
			//l_res.setMessageCode("FAILED_REVERSE_CODE");
			l_res.setMessageCode("MFI10101"); 
		}

		return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
	}

	private CashTransactionResponse validate(CashTransactionRequest p_request) {
		CashTransactionResponse l_res = new CashTransactionResponse();
		if (p_request == null) {
			l_res.setMessageCode("MFI10120");
			return l_res;
		}
		if (p_request.getAgentId() == null) {
			l_res.setMessageCode("MFI10114");
			return l_res;
		}
		if (p_request.getDeviceId() == null) {
			l_res.setMessageCode("MFI10121");
			return l_res;
		}
		if (p_request.getCustomerId() == null) {
			l_res.setMessageCode("MFI10122");
			return l_res;
		}
		if (p_request.getTxnInitTime() == null) {
			l_res.setMessageCode("MFI101223");
			return l_res;
		}
		if (p_request.getAccNo() == null) {
			l_res.setMessageCode("MFI101224");
			return l_res;
		}
		if (p_request.getTxnCode() == null) {
			l_res.setMessageCode("MFI101225");
			return l_res;
		}
		if (p_request.getTxnAmount() == null
				|| p_request.getTxnAmount() <= 0) {
			l_res.setMessageCode("MFI101226");
			return l_res;
		}
		if (p_request.getTxnCcy() == null) {
			l_res.setMessageCode("MFI101227");
			return l_res;
		}
		if (p_request.getBranchCode() == null) {
			l_res.setMessageCode("MFI101228");
			return l_res;
		}
		if (p_request.getTxnId() == null) {
			l_res.setMessageCode("MFI101229");
			return l_res;
		}
		if (p_request.getLocCode() == null) {
			l_res.setMessageCode("MFI101215");
			return l_res;
		}
		l_res.setStatus(true);
		return l_res;
	}
}
