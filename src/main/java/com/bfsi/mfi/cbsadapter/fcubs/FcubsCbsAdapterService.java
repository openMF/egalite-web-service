package com.bfsi.mfi.cbsadapter.fcubs;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.cbsadapter.CbsAdapterService;
import com.bfsi.mfi.dao.BranchDao;
import com.bfsi.mfi.dao.SystemParameterDao;
import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.entity.Branch;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.fcubs.dao.FcubsCbsDao;
import com.bfsi.mfi.fcubs.dao.FcubsCbsWebServiceDao;
import com.bfsi.mfi.rest.constants.ServiceConstants;
import com.bfsi.mfi.service.SystemParameterService;
import com.bfsi.mfi.util.LoggerUtil;
import com.ofss.fcubs.gw.ws.types.FCUBSCLService;
import com.ofss.fcubs.gw.ws.types.FCUBSCLServiceSEI;
import com.ofss.fcubs.service.fcubsclservice.CREATEDISBURSEMENTIOPKREQ;
import com.ofss.fcubs.service.fcubsclservice.CREATEDISBURSEMENTIOPKRES;
import com.ofss.fcubs.service.fcubsclservice.CREATEPAYMENTFSFSREQ;
import com.ofss.fcubs.service.fcubsclservice.CREATEPAYMENTFSFSRES;
import com.ofss.fcubs.service.fcubsclservice.DisbursementCreateIOType;
import com.ofss.fcubs.service.fcubsclservice.DisbursementCreateIOType.DsbrDetail;
import com.ofss.fcubs.service.fcubsclservice.DisbursementCreateIOType.DsbrUserdef;
import com.ofss.fcubs.service.fcubsclservice.ERRORDETAILSType;
import com.ofss.fcubs.service.fcubsclservice.ERRORType;
import com.ofss.fcubs.service.fcubsclservice.FCUBSHEADERType;
import com.ofss.fcubs.service.fcubsclservice.MsgStatType;
import com.ofss.fcubs.service.fcubsclservice.PaymentFullType;
import com.ofss.fcubs.service.fcubsclservice.PaymentFullType.Rmk;
import com.ofss.fcubs.service.fcubsclservice.PaymentFullType.Settelments;
import com.ofss.fcubs.service.fcubsclservice.UBSCOMPType;

@Service
public class FcubsCbsAdapterService implements CbsAdapterService 
{
	private static final int WEBSERVICE_RETRY_INTERVAL = 15000;
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FcubsCbsDao fcubsCbsDao;

	@Autowired
	private FcubsCbsWebServiceDao fcubsCbsWebDao;

	@Autowired
	private SystemParameterDao systemParameterDao;
	
	
	//Shabu
	@Autowired
	private BranchDao branchDao;

	public FcubsCbsWebServiceDao getFcubsCbsWebDao() {
		return fcubsCbsWebDao;
	}

	public void setFcubsCbsWebDao(FcubsCbsWebServiceDao fcubsCbsWebDao) {
		this.fcubsCbsWebDao = fcubsCbsWebDao;
	}

	public FcubsCbsDao getFcubsCbsDao() {
		return fcubsCbsDao;
	}

	public void setFcubsCbsDao(FcubsCbsDao fcubsCbsDao) {
		this.fcubsCbsDao = fcubsCbsDao;
	}

	@Override
	public void fetchCbsBranches(String jobId) {
		getFcubsCbsDao().getBranchData(jobId);
	}

	@Override
	public void fetchCbsCustomers(String jobId) {
		getFcubsCbsDao().getCustomerData(jobId);
	}

	@Override
	public void fetchCbsMfiLoans(String jobId) {
		getFcubsCbsDao().getLoanData(jobId);
	}

	@Override
	public void fetchCbsMfiDeposit(String jobId) {
		getFcubsCbsDao().getDepositData(jobId);
		
	}

	
	@Override
	public void fetchCbsFx(String jobId) {
		getFcubsCbsDao().getFxCurrencyData(jobId);
	}

	@Override
	public void postTxn() {
		AgentTransaction transaction = null;
		while (true) {
			try {
				transaction = uploadTxnStatusForCbs();
				if (transaction != null && transaction.getId() != null) {
					postTxnToFcubsWebService(transaction);
				} else {
					break;
				}
			} catch (ServiceException e) {
				LoggerUtil.cbsJobError("ServiceException : MFI10001", e);
				break;
			}
		}
	}

	@Transactional(rollbackFor = Exception.class)
	private AgentTransaction uploadTxnStatusForCbs() throws ServiceException {
		String txnNarrative = null;
		AgentTransaction txn = null;
		try {
		
			txn = getFcubsCbsWebDao().uploadTxnForCbs();
			if (txn != null &&txn.getId() != null) {
				getFcubsCbsWebDao().updateTxnForCbs(txn.getTxnId());

				if (txn.getTxnType().equals(ServiceConstants.REAPYMENT_STATUS)) {
					txnNarrative = getFcubsCbsWebDao().getTxnNarrativeForRepay(
							txn.getTxnId());
				} else {
					txnNarrative = getFcubsCbsWebDao().getTxnNarrativeForDisbr(
							txn.getTxnId());
				}
				txn.setTxnNarrative(txnNarrative);
			}
		} catch (DataAccessException e) {
			String message = "Error while updating Transaction for CBS WebService:"
					+ e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}
		return txn;
	}

	private void postTxnToFcubsWebService(AgentTransaction txn)
			throws ServiceException {
		String responseMsg = null;
		int numOfRetry = systemParameterDao
				.getIntParamValue(SystemParameterService.NUMBER_OF_RETRY);
		int retryCount = 0;
		Exception exception = null;
		
		if(txn == null || txn.getId() == null)
			return;
		logger.info("sendTransaction to CBS - TXN ID: "+txn.getId());
		logger.info(txn.toString());

		do {
			try {
				// send transaction to webservice
				responseMsg = sendTransaction(txn);

				// update status of transaction based on the response from web
				// service
				/* vishal Start */
				if (responseMsg != null && responseMsg.equals(ServiceConstants.SUCCESS)) {
				/* vishal End */
					getFcubsCbsWebDao().updateTxnWithCbsRes(txn.getTxnId(),
							ServiceConstants.ACK_STATUS);
					break;
				} else {
					logger.info("sendTransaction to CBS -FAILED:: RETRY: "+(retryCount +1));
					getFcubsCbsWebDao().updateTxnWithCbsRes(txn.getTxnId(),
							ServiceConstants.FAILURE);
					
					retryCount++;
					try {
						Thread.sleep(WEBSERVICE_RETRY_INTERVAL);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					continue;
				}
			} catch (DataAccessException ex) {
				String message = "Error while Posting Transaction to CBS WebService:"
						+ ex.getMessage();
				logger.error(message, ex);
				// unexpected state, abort the process by throwing exception
				throw new ServiceException(message, ex);
			} catch (WebServiceException e) {
				LoggerUtil.cbsJobError("ServiceException  : MFI10001", e);
				exception = e;
				// retry under the presumption that the this is communication
				// exception
				retryCount++;
				try {
					Thread.sleep(WEBSERVICE_RETRY_INTERVAL);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		} while (retryCount <= numOfRetry);

		// If failed even after retries, update the record & throw exception
		if (retryCount == numOfRetry + 1) {
			getFcubsCbsWebDao().updateStatusToReady(txn.getTxnId());
			retryCount = 0;
			String message = "Communication error while Posting Transaction to CBS WebService:";
			// logger.
			logger.error(message);
			throw new ServiceException(message);
		}
	}

	private String sendTransaction(AgentTransaction txn) {
		//String responseMsg ;
		/* vishal Start */
		String responseMsg = null;
		/* vishal end */
		List<ERRORType> errorType = null;
		List<ERRORDETAILSType> errorDetails = null;
		String errorDesc = null;


		try {
			FCUBSCLService service = new FCUBSCLService(); 
			FCUBSCLServiceSEI ser = service.getFCUBSCLServiceSEI();
			FCUBSHEADERType fcubsHeaderType = getFcubsHeaderTypeObject();
			if (txn.getTxnType().equals(ServiceConstants.REAPYMENT_STATUS)) {
				logger.info("sendTransaction to CBS::REPAYMENT : "+txn.getId());
				CREATEPAYMENTFSFSREQ requestMsg = populateCreatePaymentReq(txn,
						fcubsHeaderType);
				CREATEPAYMENTFSFSRES response = ser.createPaymentFS(requestMsg);
				/* vishal Start */
				if(response != null){
				/* vishal end */	
					
					responseMsg = response.getFCUBSHEADER().getMSGSTAT().value();
					errorType = response.getFCUBSBODY().getFCUBSERRORRESP();
				}
				else{
					logger.info("sendTransaction to CBS::REPAYMENT NULL RESPONSE: "+ txn.getId());
				}
				

			} else {
				logger.info("sendTransaction to CBS::DISBURSEMENT : "+txn.getId());
				CREATEDISBURSEMENTIOPKREQ requestMsg = populateCreateDisbrReq(
						txn, fcubsHeaderType);
				CREATEDISBURSEMENTIOPKRES response = ser
						.createDisbursementIO(requestMsg);
				/* vishal Start */
				if(response != null){				
					responseMsg = response.getFCUBSHEADER().getMSGSTAT().value();
					errorType = response.getFCUBSBODY().getFCUBSERRORRESP();
				} else {
					logger.info("sendTransaction to CBS::FAILED ::RESPONSE NULL:: "+txn.getId());
			
				}
				/* vishal end */
			}
			/* vishal Start */
			if (errorType != null && !errorType.isEmpty()) {
			/* vishal End */
				errorDetails = errorType.get(0).getERROR();
			/* vishal Start */
				if (errorDetails != null && !errorDetails.isEmpty()) {
			/* vishal End */
					errorDesc = errorDetails.get(0).getEDESC();
					getFcubsCbsWebDao().updateTxnWithErrorMsg(errorDesc,
							txn.getTxnId());
				}
			}

		} catch (WebServiceException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			throw new WebServiceException();
		}
		return responseMsg;
	}

	private CREATEDISBURSEMENTIOPKREQ populateCreateDisbrReq(
			AgentTransaction txn, FCUBSHEADERType fcubsHeaderType) {

		CREATEDISBURSEMENTIOPKREQ requestMsg = new CREATEDISBURSEMENTIOPKREQ();
		CREATEDISBURSEMENTIOPKREQ.FCUBSBODY fcubsBody = new CREATEDISBURSEMENTIOPKREQ.FCUBSBODY();
		DisbursementCreateIOType disbrIotype = new DisbursementCreateIOType();
		DsbrDetail disbr = new DsbrDetail();
		DsbrUserdef userDef = new DsbrUserdef();

		XMLGregorianCalendar txnDate = getTxnDate(txn.getTxnTimestamp());
		
		
		//Shabu
				XMLGregorianCalendar wsBranchDate = null;
				Date branchDate =getBranchDate(txn.getBranchCode());
				if(branchDate != null)
					wsBranchDate = getTxnDate(branchDate);

		// String branch = getBranch(txn.getLoanAcNo());

		fcubsHeaderType.setUSERID(ServiceConstants.DIS_USERID);
		fcubsHeaderType.setOPERATION(ServiceConstants.DIS_OPERATION);
		fcubsHeaderType.setFUNCTIONID(ServiceConstants.DIS_FUNCTIONID);
		fcubsHeaderType.setBRANCH(txn.getBranchCode());
		requestMsg.setFCUBSHEADER(fcubsHeaderType);

		userDef.setFIELDCHAR1(txn.getTxnId());

		disbr.setSTTLMODE(ServiceConstants.SETTLE_MODE);
		disbr.setSTTLCCY(txn.getTxnCcy());
		disbr.setSETTLEBRANCH(txn.getBranchCode());
		disbr.setSTTLACC(ServiceConstants.SETTLE_ACC);
		disbr.setSTTLAMT(new BigDecimal(txn.getTxnAmount()));
		disbr.setSTTLLCYEQ(new BigDecimal(txn.getTxnAmount()));

		disbrIotype.setACTNO(txn.getLoanAcNo());
		disbrIotype.setBR(txn.getBranchCode());
		disbrIotype.setESN(new BigDecimal(1));
		disbrIotype.setVALDT(txnDate);
		disbrIotype.setEXECUTIONDATE(wsBranchDate);
		disbrIotype.setAUTHSTAT(ServiceConstants.AUTHSTAT);
		disbrIotype.setREMARKS(txn.getTxnNarrative());
		disbrIotype.getDsbrDetail().add(disbr);
		disbrIotype.setDsbrUserdef(userDef);

		fcubsBody.setDsbrMasterIO(disbrIotype);
		requestMsg.setFCUBSBODY(fcubsBody);
		return requestMsg;
	}

	private XMLGregorianCalendar getTxnDate(Date txnTimestamp) {
		XMLGregorianCalendar txnDate = null;
		GregorianCalendar gregCal = new GregorianCalendar();
		gregCal.setTime(txnTimestamp);
		
		try {
			/*txnDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(
					gregCal);*/
			txnDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(
					new BigInteger(""+gregCal.get(Calendar.YEAR)),gregCal.get(Calendar.MONTH)+1,gregCal.get(Calendar.DAY_OF_MONTH),gregCal.get(Calendar.HOUR)
					,gregCal.get(Calendar.MINUTE)
					,gregCal.get(Calendar.SECOND)
					,new BigDecimal("0"),DatatypeConstants.FIELD_UNDEFINED);
			
			
		} catch (DatatypeConfigurationException e) { 
			e.printStackTrace();
		}
		return txnDate;
	}

	private CREATEPAYMENTFSFSREQ populateCreatePaymentReq(AgentTransaction txn,
			FCUBSHEADERType fcubsHeaderType) {
		CREATEPAYMENTFSFSREQ requestMsg = new CREATEPAYMENTFSFSREQ();
		CREATEPAYMENTFSFSREQ.FCUBSBODY fcubsBody = new CREATEPAYMENTFSFSREQ.FCUBSBODY();
		PaymentFullType payFullType = new PaymentFullType();
		Settelments settlement = new Settelments();
		Rmk remark = new Rmk();
		
		
		logger.info("LOGGING TRANS POST TO UBS : "+txn.getId());

		// String branch = getBranch(txn.getLoanAcNo());
		XMLGregorianCalendar txnDate = getTxnDate(txn.getTxnTimestamp());
		
		//Shabu
		XMLGregorianCalendar wsBranchDate = null;
		Date branchDate =getBranchDate(txn.getBranchCode());
		if(branchDate != null)
			wsBranchDate = getTxnDate(branchDate);
		
		
		
		
		logger.info("LOGGING TRANS VAL DATE : "+txnDate);
		
		fcubsHeaderType.setUSERID(ServiceConstants.REPAY_USERID);
		fcubsHeaderType.setOPERATION(ServiceConstants.REPAY_OPERATION);
		fcubsHeaderType.setFUNCTIONID(ServiceConstants.REPAY_FUNCTIONID);
		fcubsHeaderType.setBRANCH(txn.getBranchCode());
		
		
		logger.info("HEADER ::: "
				+ "USERID: "+fcubsHeaderType.getUSERID() 
				+" OPERATION: " + fcubsHeaderType.getOPERATION()
				+" FUNCTIONID: "+ fcubsHeaderType.getFUNCTIONID() 
				+" BRANCH: "+ fcubsHeaderType.getBRANCH() 
				+" SOURCE: "+ fcubsHeaderType.getSOURCE()
				+" UBSCOMP: "+ UBSCOMPType.FCUBS
				+" MODULEID: "+ fcubsHeaderType.getMODULEID()
				+" SERVICE: "+ fcubsHeaderType.getSERVICE()
				+" ACTION: "+ fcubsHeaderType.getACTION()
				+" MSGSTAT: "+ fcubsHeaderType.getMSGSTAT());
		
		requestMsg.setFCUBSHEADER(fcubsHeaderType);

		settlement.setSTLMOD(ServiceConstants.SETTLE_MODE);
		settlement.setSTLBRN(txn.getBranchCode());
		settlement.setSTLACC(ServiceConstants.SETTLE_ACC);
		settlement.setSTLAMT(new BigDecimal(String.valueOf(txn.getTxnAmount())));
		settlement.setLONCCYEQV(new BigDecimal(String.valueOf(txn.getTxnAmount())));
		settlement.setSTLCCY(txn.getTxnCcy());
		
		logger.info("SETTLEMENT ::: STLMOD: "+settlement.getSTLMOD() +" STLBRN: " + settlement.getSTLBRN()+" STLACC: " + settlement.getSTLACC() 
				+" STLAMT: "+ settlement.getSTLAMT()+" LONCCYEQV: "+ settlement.getLONCCYEQV()+" STLCCY: "+ settlement.getSTLCCY() +"  REMARK: "+txn.getTxnNarrative());

		remark.setRMK1(txn.getTxnNarrative());

		payFullType.setACCNO(txn.getLoanAcNo());
		payFullType.setBRNCODE(txn.getBranchCode());
		payFullType.setESN(new BigDecimal(1));
		payFullType.setVALDT(txnDate);
		
		//Shabu
		payFullType.setEXECDT(wsBranchDate);
		
		payFullType.setAUTHSTAT(ServiceConstants.AUTHSTAT);

		payFullType.getRmk().add(remark);
		payFullType.getSettelments().add(settlement);
		
		logger.info("PAYFULLTYPE ::: ACCNO: "+payFullType.getACCNO() +" BRNCODE: " + payFullType.getBRNCODE()+" ESN: " + payFullType.getESN()
				+" VALDT: "+ payFullType.getVALDT()+" EXECDT: "+payFullType.getEXECDT()+" AUTHSTAT: "+ payFullType.getAUTHSTAT());
		
		fcubsBody.setLiqFull(payFullType);
		requestMsg.setFCUBSBODY(fcubsBody);
		return requestMsg;
	}

	/*
	 * private String getBranch(String loanAcNo) { String branch =
	 * loanAcNo.substring(0, 3); return branch; }
	 */
	private FCUBSHEADERType getFcubsHeaderTypeObject() {
		FCUBSHEADERType fcubsHeaderType = new FCUBSHEADERType();
		fcubsHeaderType.setSOURCE(ServiceConstants.SOURCE);
		fcubsHeaderType.setUBSCOMP(UBSCOMPType.FCUBS);
		fcubsHeaderType.setMODULEID(ServiceConstants.MODULEID);
		fcubsHeaderType.setSERVICE(ServiceConstants.SERVICE);
		fcubsHeaderType.setACTION("NEW");
		fcubsHeaderType.setMSGSTAT(MsgStatType.SUCCESS);
		return fcubsHeaderType;

	}

	@Override
	public void prepareForPostTxn() {
		fcubsCbsWebDao.updateStatusToReady();
	}

	@Override
	public void fetchCbsCcy(String jobId) {
		getFcubsCbsDao().getCurrency(jobId);

	}
	
	private Date getBranchDate(String p_branchCode){
		Branch l_br = null;
		try {
			 l_br =branchDao.get(p_branchCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l_br == null? null:l_br.getBranchDate();
		
	}
	
	public static void main(String[] args){
		
	}

	
}
