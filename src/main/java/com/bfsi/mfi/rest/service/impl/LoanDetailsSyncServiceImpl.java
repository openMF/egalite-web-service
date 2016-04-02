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

import com.bfsi.mfi.entity.LoanDetailsServiceRequest;
import com.bfsi.mfi.entity.LoanDetailsServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.rest.model.Loan;
import com.bfsi.mfi.rest.model.LoanDetailsRequest;
import com.bfsi.mfi.rest.model.LoanDetailsResponse;
import com.bfsi.mfi.rest.model.LoanPaidSch;
import com.bfsi.mfi.rest.service.LoanDetailsSyncService;
import com.bfsi.mfi.service.LoanDetailsService;
import com.bfsi.mfi.util.EncryptDecryptUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.LoanDetailVO;
import com.bfsi.mfi.vo.LoanPaidSchVO;

/**
 * 
 * @author Shabu
 * 
 */

@Component("loanDetailsSyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/loandetails")
public class LoanDetailsSyncServiceImpl implements LoanDetailsSyncService {

	@Autowired
	private LoanDetailsService loanDetailsService;

	private static Map<String, Map<String, Object>> RECVD_MAP = new ConcurrentHashMap<String, Map<String, Object>>();
	private static final String RECVD_ID = "RECVDID";
	private static final String AGENT_SESSION = "AGENTSESSION";
	
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;

	@Override
	@POST
	public JsonResponseWrapper getLoanDetails(JsonRequestWrapper p_wrapRequest) {
		LoanDetailsRequest p_request=null;
		try {
			 p_request=(LoanDetailsRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, LoanDetailsRequest.class);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("exception", e);
			return new JsonResponseWrapper();
		}
		

		LoanDetailsServiceResponse l_serRes = null;
		LoanDetailsResponse l_res = null;
		LoanDetailsServiceRequest l_serReq = new LoanDetailsServiceRequest();
		List<Loan> l_loanList = new ArrayList<Loan>();
		Loan l_loan = null;
		List<LoanPaidSchVO> l_loanPaidSchListVO = null;		
		LoanPaidSch l_loanPaidSch = null;		

		try {
			l_res = validate(p_request);
			if (!l_res.getStatus())
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
			l_res.setStatus(false);
			BeanUtils.copyProperties(p_request, l_serReq,
					new String[] { "deviceId" });

			LoggerUtil.mbsJobDebug("Map before initi for agent: "
					+ p_request.getAgentId() + "::" + RECVD_MAP);

			l_serReq.setRecvdLoans(updateReceivedIds(p_request));

			l_serRes = loanDetailsService.getLoanDetails(l_serReq);

			if (!l_serRes.getStatus()) {
				l_res.setMessageCode("MFI10101");
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
			}

			for (LoanDetailVO l_loanVO : l_serRes.getLoanList()) {
				List<LoanPaidSch> l_loanPaidListSch = new ArrayList<LoanPaidSch>();;
				l_loan = new Loan();
				BeanUtils.copyProperties(l_loanVO, l_loan, new String[] {
						"sanctionedDate", "lastDisbursedDate", "lastRepayDate",
						"recordStatus", "cbsUploadJobId", "syncStatus",
						"syncTime", "isAllocated" });

				if (l_loanVO.getSanctionedDate() != null)
					l_loan.setSanctionedDate(l_loanVO.getSanctionedDate()
							.getTime());
				if (l_loanVO.getLastDisbursedDate() != null)
					l_loan.setLastDisbursedDate(l_loanVO.getLastDisbursedDate()
							.getTime());
				if (l_loanVO.getLastRepayDate() != null)
					l_loan.setLastRepayDate(l_loanVO.getLastRepayDate()
							.getTime());
				
				// add Paid Sch List
				l_loanPaidSchListVO = loanDetailsService.getLoanPaidSch(l_loanVO.getLoanAccNo(),l_serReq);	
				for (LoanPaidSchVO l_loanPaidSchVO : l_loanPaidSchListVO) {
					l_loanPaidSch = new LoanPaidSch();
					BeanUtils.copyProperties(l_loanPaidSchVO,l_loanPaidSch, new String[] {
							"loanAcNo","parentLoanAcNo","parentCustomerId",
							"isParentLoan","isGroupLoan","groupId",
							"schDueDate","schPaidDate","agentId",
							"locCode","deviceId"});
					
					l_loanPaidSch.setCbsAcRefNo(l_loanPaidSchVO.getLoanAcNo());
					if (l_loanPaidSchVO.getSchDueDate() != null){
						l_loanPaidSch.setSchDueDate(l_loanPaidSchVO.getSchDueDate()
								.getTime());
					}
					if(l_loanPaidSchVO.getSchPaidDate() !=null){						
						l_loanPaidSch.setSchPaidDate(l_loanPaidSchVO.getSchPaidDate()
								.getTime());
					}
					l_loanPaidListSch.add(l_loanPaidSch);
				}
				l_loan.setLoanPaidSch(l_loanPaidListSch);
				l_loanList.add(l_loan);
			}			
			if (l_loanList.isEmpty()){
				endSession(p_request);
			} 
			
			l_res.setLoanList(l_loanList);
			l_res.setStatus(true);
		} catch (ServiceException e) {
			LoggerUtil
					.mbsJobError(
							"Service exception while getting loan details: MFI10101",
							e);
			l_res.setMessageCode("MFI10101");
		} catch (Exception e) {
			LoggerUtil.mbsJobError(
					"unhandled exception while getting loan details: MFI10101",
					e);
			l_res.setMessageCode("MFI10101");
		}

		return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
	}

	@SuppressWarnings("unchecked")
	private List<String> updateReceivedIds(LoanDetailsRequest p_request) {

		List<String> l_Ids = p_request.getRecvdLoans() == null ? new ArrayList<String>()
				: p_request.getRecvdLoans();

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

	private void beginSession(LoanDetailsRequest p_request) {
		Map<String, Object> l_agentMap = null;
		if (shouldStartNewSession(p_request)) {
			l_agentMap = new HashMap<String, Object>();
			l_agentMap.put(RECVD_ID, new ArrayList<String>());
			l_agentMap.put(AGENT_SESSION, p_request.getSyncSessionId());
			RECVD_MAP.put(p_request.getAgentId(), l_agentMap);
		}
	}

	private void endSession(LoanDetailsRequest p_request) {
		if (RECVD_MAP.containsKey(p_request.getAgentId()))
			RECVD_MAP.remove(p_request.getAgentId());
	}

	private boolean shouldStartNewSession(LoanDetailsRequest p_request) {

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

	private LoanDetailsResponse validate(LoanDetailsRequest p_request) {
		LoanDetailsResponse l_res = new LoanDetailsResponse();
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
