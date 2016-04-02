package com.bfsi.mfi.rest.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
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

import com.bfsi.mfi.entity.TransactionServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.constants.Constants;
import com.bfsi.mfi.rest.model.BeginTransactionRequest;
import com.bfsi.mfi.rest.model.BeginTransactionResponse;
import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.rest.model.PostTransactionRequest;
import com.bfsi.mfi.rest.model.PostTransactionResponse;
import com.bfsi.mfi.rest.model.TransactionRequest;
import com.bfsi.mfi.rest.service.TransactionSyncService;
import com.bfsi.mfi.service.TransactionService;
import com.bfsi.mfi.util.EncryptDecryptUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgentTransactionVO;

@Component("transactionSyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/transaction")
public class TransactionSyncServiceImpl implements TransactionSyncService {
	private static final String RAEDY_FOR_CBS = "R";
	@Autowired
	private TransactionService transactionService;
	

	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;
	
	
	@Override
	@POST
	@Path("/post")
	public JsonResponseWrapper postTransactions(
			JsonRequestWrapper p_wrapRequest) {
		PostTransactionRequest p_tranReq=null;
		try {
			 p_tranReq=(PostTransactionRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, PostTransactionRequest.class);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("exception", e);
			return new JsonResponseWrapper();
		}
		
		PostTransactionResponse response = new PostTransactionResponse();

		
		
		/*Message l_message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest l_req = (HttpServletRequest) l_message
				.get(AbstractHTTPDestination.HTTP_REQUEST);
		HttpSession l_sess = l_req.getSession(false);
		
		try {
			l_sess.getAttribute("uniqueId").toString();

		} catch (Exception ex) {
			response.setMessageCode("MFI20001");
			return response;
		}*/

		List<TransactionRequest> l_txnList = p_tranReq.getTxnrequest();
		if (l_txnList==null || l_txnList.isEmpty()) {
			response.setMessageCode("MFI10119");
			return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
		}
		List<AgentTransactionVO> l_agntTxnList=new ArrayList<AgentTransactionVO>();
		AgentTransactionVO l_agntTxn=null;
		for(TransactionRequest l_txn:l_txnList){
			l_agntTxn=new AgentTransactionVO();
			BeanUtils.copyProperties(l_txn, l_agntTxn, new String[]{"txnInitTime","txnSyncTime","depoRedeemReqDate","maturityDate"});
			Calendar l_cal=Calendar.getInstance();
			if(l_txn.getTxnSyncTime()!=null){
				l_cal.setTimeInMillis(l_txn.getTxnSyncTime());
				l_agntTxn.setTxnSyncTime(l_cal.getTime());
			}
			if(l_txn.getTxnInitTime()!=null){
				l_cal.setTimeInMillis(l_txn.getTxnInitTime());
				l_agntTxn.setTxnInitTime(l_cal.getTime());
			}
			if(l_txn.getDepoRedeemReqDate()!=null){
				l_cal.setTimeInMillis(l_txn.getDepoRedeemReqDate());
				l_agntTxn.setDepoRedeemReqDate(l_cal.getTime());
			}
			if(l_txn.getMaturityDate()!=null){
				l_cal.setTimeInMillis(l_txn.getMaturityDate());
				l_agntTxn.setMaturityDate(l_cal.getTime());
			}
			l_agntTxnList.add(l_agntTxn);
		}
		try{
		TransactionServiceResponse 	l_serRes = getTransactionServiceImpl().uploadTransactions(l_agntTxnList);
		if(l_serRes.getStatus())
			response.setRecvdTrans(l_serRes.getReceivedTransactions());
		response.setStatus(true);
		}
		catch (ServiceException ex) {
				LoggerUtil.mbsJobError("ServiceException : MFI10001", ex);
				response.setMessageCode("MFI20001");
		}
		catch (Exception ex) {
			LoggerUtil.mbsJobError("Unhandeled Exception : MFI10001", ex);
				response.setMessageCode("MFI20001");
		}
		
		return encryptDecryptUtil.getResponseObject(p_wrapRequest,response);
	}

	@Override
	
	public PostTransactionResponse postSyncTransaction(
			PostTransactionRequest request) {
		PostTransactionResponse response = new PostTransactionResponse();

		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest req = (HttpServletRequest) message
				.get(AbstractHTTPDestination.HTTP_REQUEST);
		HttpSession sess = req.getSession(false);
		
		try {
			sess.getAttribute("uniqueId").toString();

		} catch (Exception ex) {
			LoggerUtil.mbsJobError("Unhandeled Exception : MFI10001", ex);
			response.setStatusText(Constants.SESSION_EXPIRED);
			return response;
		}

		List<TransactionRequest> txnlist = request.getTxnrequest();
		String validationStatus = validate(txnlist);
		/* || !validationStatus.equals(Constants.SUCCESS) */
		/*if (txnlist.isEmpty() ) {
			response.setStatus(false);
			response.setStatusText(Constants.TXN_LIST_EMPTY);
			return response;
		}
		List<AgentTransactionVO> translist = new ArrayList<AgentTransactionVO>();
		for (int i = 0; i < txnlist.size(); i++) {
			translist.add(new AgentTransactionVO());
			BeanUtils.copyProperties(txnlist.get(i), translist.get(i),
					new String[] { "txnTimestamp", "syncTime" });
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateformt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date syncDate = new Date();
		Date txnDate = new Date();

		for (int i = 0; i < txnlist.size(); i++) {
			String txnTime = txnlist.get(i).getTxnTimestamp();
			System.out.println("Date" + txnTime);
			try {
				txnDate = dateFormat.parse(txnTime);
				syncDate = dateformt.parse(dateformt.format(syncDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			translist.get(i).setTxnTimestamp(txnDate);
			translist.get(i).setSyncTime(syncDate);
			translist.get(i).setDeviceId(deviceId);
			translist.get(i).setTxnStatus(RAEDY_FOR_CBS);
		}

		try {
			response.setStatusText(getTransactionServiceImpl()
					.uploadTransactions(translist));
			response.setStatus(true);

		} catch (ServiceException ex) {
			response.setStatusText(ex.getMessage());
			ex.printStackTrace();
		}*/

		return response;
	}

	@Override
	@POST
	@Path("/begin")
	public BeginTransactionResponse beginSyncTransaction(
			BeginTransactionRequest request) {

		BeginTransactionResponse response = new BeginTransactionResponse();
		List<String> txnidlist = new ArrayList<String>();
		String syncsessionid = request.getSynsessionid();
		txnidlist = request.getTxnid();
		if (txnidlist.isEmpty()) {
			//response.setStatus(false);
			//response.setStatusText(Constants.TXN_ID_LIST_EMPTY);
			response.setMessageCode("MFI20001");
			return response;
		}
		else if(syncsessionid == null){
			response.setMessageCode("MFI20002");
			return response;
		}
		/*
		try {
			response.setAgentTransaction(getTransactionServiceImpl()
					.uploadTxnStatus(txnidlist, syncsessionid));
			response.setStatus(true);
		} catch (ServiceException ex) {
			response.setStatusText(ex.getMessage());
			ex.printStackTrace();
		}
		return response;*/
		try{
		response.setAgentTransaction(getTransactionServiceImpl()
		.verifyPostedTransactions(txnidlist, syncsessionid));
		response.setStatus(true);
		}
		catch (ServiceException ex) {
			LoggerUtil.mbsJobError("ServiceException : MFI10001", ex);
			response.setMessageCode("MFI20000");
		}
		catch (Exception ex) {
			LoggerUtil.mbsJobError("Unhandeled Exception : MFI10001", ex);
			response.setMessageCode("MFI20000");
		}
		return response;
	}

	public TransactionService getTransactionServiceImpl() {
		return transactionService;
	}

	public void setTransactionServiceImpl(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	private String validate(List<TransactionRequest> txnlist) {
		for (TransactionRequest trans : txnlist) {
			if (trans.getTxnId() == null) {
				return Constants.NULL_TXN_ID;
			}
			if (trans.getAgentId() == null) {
				return Constants.NULL_AGENT_ID;
			}
			if (trans.getCustomerId() == null) {
				return Constants.NULL_CUST_ID;
			}
			if (trans.getLoanAcNo() == null) {
				return Constants.NULL_LOAN_NO;
			}
			if (trans.getTxnAmount() == null) {
				return Constants.NULL_TXN_AMT;
			}
			if (trans.getTxnType() == null) {
				return Constants.NULL_TXN_TYPE;
			}
			if (trans.getTxnNarrative() == null) {
				return Constants.NULL_TXN_NARRTVE;
			}
			if (trans.getTxnCcy() == null) {
				return Constants.NULL_TXN_CURRENCY;
			}
			if (trans.getTxnTimestamp() == null) {
				return Constants.NULL_TXN_TIMESTAMP;
			}

		}
		return Constants.SUCCESS;
	}
	@SuppressWarnings("unused")
	private PostTransactionResponse validate(PostTransactionRequest p_request){
		PostTransactionResponse l_res=new PostTransactionResponse();
		
		if(p_request.getTxnrequest()==null ||p_request.getTxnrequest().isEmpty()){
			l_res.setMessageCode("");
			return l_res;
		}
		
		for (TransactionRequest trans : p_request.getTxnrequest()) {
			if (trans.getTxnId() == null) {
				//return Constants.NULL_TXN_ID;
			}
			if (trans.getAgentId() == null) {
				//return Constants.NULL_AGENT_ID;
			}
			if (trans.getCustomerId() == null) {
				//return Constants.NULL_CUST_ID;
			}
			if (trans.getLoanAcNo() == null) {
				//return Constants.NULL_LOAN_NO;
			}
			if (trans.getTxnAmount() == null) {
				//return Constants.NULL_TXN_AMT;
			}
			if (trans.getTxnType() == null) {
				//return Constants.NULL_TXN_TYPE;
			}
			if (trans.getTxnNarrative() == null) {
				//return Constants.NULL_TXN_NARRTVE;
			}
			if (trans.getTxnCcy() == null) {
				//return Constants.NULL_TXN_CURRENCY;
			}
			if (trans.getTxnTimestamp() == null) {
				//return Constants.NULL_TXN_TIMESTAMP;
			}

		}
		
		l_res.setStatus(true);
		return l_res;
	}

	private PostTransactionRequest getDummyRequest(){
		PostTransactionRequest response = new PostTransactionRequest();
		TransactionRequest txnReq=new TransactionRequest();
		TransactionRequest txnReq1=new TransactionRequest();
		List<TransactionRequest> txns=new ArrayList<TransactionRequest>();
		txnReq.setTxnId("q1v212dd3y7");
		txnReq.setAgendaId("541d2rte5s");
		txnReq.setAgentId("4");
		txnReq.setDeviceId("7");
		txnReq.setTxnCode("L02");
		txnReq.setTxnAmount(223.12);
		txnReq1.setTxnSettlementAmount(434.2);
		txnReq.setTxnCcy("INR");
		txnReq.setTxnLocalCcyAmount(455.2);
		txnReq.setTxnSettleLocalCcyAmount(455.2);
		txnReq.setModuleCode("LN");
		txnReq.setSeqNo(4);
		txnReq.setCbsAccRefNo("415565");
		
		//txnReq.setTxnInitTime(new Date());
		//txnReq.setTxnSyncTime(new Date());
		//txnReq.setDepoRedeemReqDate(new Date());
		
		
		txnReq1.setTxnId("q1v212dfd37");
		txnReq1.setAgendaId("541det2te5s");
		txnReq1.setAgentId("8");
		txnReq1.setDeviceId("4");
		txnReq1.setTxnCode("L02");
		txnReq1.setTxnAmount(223.12);
		txnReq1.setTxnSettlementAmount(434.2);
		txnReq1.setTxnCcy("INR");
		txnReq1.setTxnLocalCcyAmount(455.2);
		txnReq1.setTxnSettleLocalCcyAmount(87.2);
		txnReq1.setModuleCode("LN");
		txnReq1.setSeqNo(4);
		txnReq1.setCbsAccRefNo("415565");
		
		//txnReq1.setTxnInitTime(new Date());
		//txnReq1.setTxnSyncTime(new Date());
		//txnReq1.setDepoRedeemReqDate(new Date());
		
		
		
		txns.add(txnReq);
		txns.add(txnReq1);
		response.setTxnrequest(txns);
		return response;
		
	}

}
