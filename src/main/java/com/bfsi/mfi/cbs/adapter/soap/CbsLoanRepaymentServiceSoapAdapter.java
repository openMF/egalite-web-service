package com.bfsi.mfi.cbs.adapter.soap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.bfsi.mfi.cbs.adapter.CbsTransactionServiceAdapter;
import com.bfsi.mfi.cbs.request.CbsLoanRepaymentRequest;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.exception.CbsServiceException;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.constants.ServiceConstants;
import com.ofss.fcubs.gw.ws.types.FCUBSCLService;
import com.ofss.fcubs.gw.ws.types.FCUBSCLServiceSEI;
import com.ofss.fcubs.service.fcubsclservice.CREATEPAYMENTFSFSREQ;
import com.ofss.fcubs.service.fcubsclservice.CREATEPAYMENTFSFSRES;
import com.ofss.fcubs.service.fcubsclservice.ERRORDETAILSType;
import com.ofss.fcubs.service.fcubsclservice.ERRORType;
import com.ofss.fcubs.service.fcubsclservice.FCUBSHEADERType;
import com.ofss.fcubs.service.fcubsclservice.MsgStatType;
import com.ofss.fcubs.service.fcubsclservice.PaymentFullType;
import com.ofss.fcubs.service.fcubsclservice.UBSCOMPType;
import com.ofss.fcubs.service.fcubsclservice.PaymentFullType.Rmk;
import com.ofss.fcubs.service.fcubsclservice.PaymentFullType.Settelments;

/**
 * 
 * @author Shabu
 *
 */
public class CbsLoanRepaymentServiceSoapAdapter implements
		CbsTransactionServiceAdapter<CbsLoanRepaymentRequest, CbsBaseResponse> {

	@Override
	public CbsBaseResponse performTransaction(
			CbsLoanRepaymentRequest p_tranRequest) throws ServiceException {
		List<ERRORType> errorType = null;
		List<ERRORDETAILSType> errorDetails = null;

		CbsBaseResponse l_res = new CbsBaseResponse();
		try {
			FCUBSCLService service = new FCUBSCLService();
			FCUBSCLServiceSEI ser = service.getFCUBSCLServiceSEI();
			FCUBSHEADERType fcubsHeaderType = getFcubsHeaderTypeObject();
			CREATEPAYMENTFSFSREQ requestMsg = populateCreatePaymentReq(
					p_tranRequest, fcubsHeaderType);
			CREATEPAYMENTFSFSRES response = ser.createPaymentFS(requestMsg);
			if (response != null) {
				l_res.setResponseMessage(response.getFCUBSHEADER().getMSGSTAT()
						.value());
				errorType = response.getFCUBSBODY().getFCUBSERRORRESP();
			} else
				throw new CbsServiceException();

			if (errorType != null && !errorType.isEmpty()) {
				errorDetails = errorType.get(0).getERROR();
				if (errorDetails != null && !errorDetails.isEmpty()) {
					l_res.setResponseMessage(errorDetails.get(0).getEDESC());
				}
				l_res.setResponseCode("FAL");
			} else {
				l_res.setStatus(true);
				l_res.setResponseCode("SUC");
			}

		} catch (Exception e) {
			l_res.setResponseCode("EXC");
		}
		return l_res;
	}

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

	private XMLGregorianCalendar getTxnDate(Date txnTimestamp) {
		XMLGregorianCalendar txnDate = null;
		GregorianCalendar gregCal = new GregorianCalendar();
		gregCal.setTime(txnTimestamp);

		try {
			txnDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(
					new BigInteger("" + gregCal.get(Calendar.YEAR)),
					gregCal.get(Calendar.MONTH) + 1,
					gregCal.get(Calendar.DAY_OF_MONTH),
					gregCal.get(Calendar.HOUR), gregCal.get(Calendar.MINUTE),
					gregCal.get(Calendar.SECOND), new BigDecimal("0"),
					DatatypeConstants.FIELD_UNDEFINED);

		} catch (Exception e) {

			throw new CbsServiceException();
		}
		return txnDate;
	}

	private CREATEPAYMENTFSFSREQ populateCreatePaymentReq(
			CbsLoanRepaymentRequest p_tranRequest,
			FCUBSHEADERType fcubsHeaderType) {
		CREATEPAYMENTFSFSREQ requestMsg = new CREATEPAYMENTFSFSREQ();
		CREATEPAYMENTFSFSREQ.FCUBSBODY fcubsBody = new CREATEPAYMENTFSFSREQ.FCUBSBODY();
		PaymentFullType payFullType = new PaymentFullType();
		Settelments settlement = new Settelments();
		Rmk remark = new Rmk();

		//XMLGregorianCalendar txnDate = getTxnDate(p_tranRequest.getTxnDate());

		fcubsHeaderType.setUSERID(ServiceConstants.REPAY_USERID);
		fcubsHeaderType.setOPERATION(ServiceConstants.REPAY_OPERATION);
		fcubsHeaderType.setFUNCTIONID(ServiceConstants.REPAY_FUNCTIONID);
		fcubsHeaderType.setBRANCH(p_tranRequest.getBranchCode());

		requestMsg.setFCUBSHEADER(fcubsHeaderType);

		settlement.setSTLMOD(ServiceConstants.SETTLE_MODE);
		settlement.setSTLBRN(p_tranRequest.getBranchCode());
		settlement.setSTLACC(ServiceConstants.SETTLE_ACC);
		//settlement.setSTLAMT(new BigDecimal(String.valueOf(p_tranRequest
			//	.getTxnAmt())));
		//settlement.setLONCCYEQV(new BigDecimal(String.valueOf(p_tranRequest
			//	.getTxnAmt())));
	//	settlement.setSTLCCY(p_tranRequest.getTxnCcy());

		//remark.setRMK1(p_tranRequest.getNarrative());

		payFullType.setACCNO(p_tranRequest.getLoanAccNo());
		payFullType.setBRNCODE(p_tranRequest.getBranchCode());
		payFullType.setESN(new BigDecimal(1));

		//payFullType.setVALDT(txnDate);
		//payFullType.setEXECDT(txnDate);

		payFullType.setAUTHSTAT(ServiceConstants.AUTHSTAT);

		payFullType.getRmk().add(remark);
		payFullType.getSettelments().add(settlement);

		fcubsBody.setLiqFull(payFullType);
		requestMsg.setFCUBSBODY(fcubsBody);
		return requestMsg;
	}
}
