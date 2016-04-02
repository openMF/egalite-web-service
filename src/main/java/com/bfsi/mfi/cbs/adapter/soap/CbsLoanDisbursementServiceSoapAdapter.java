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
import com.bfsi.mfi.cbs.request.CbsLoanDisbursementRequest;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.exception.CbsServiceException;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.constants.ServiceConstants;
import com.ofss.fcubs.gw.ws.types.FCUBSCLService;
import com.ofss.fcubs.gw.ws.types.FCUBSCLServiceSEI;
import com.ofss.fcubs.service.fcubsclservice.CREATEDISBURSEMENTIOPKREQ;
import com.ofss.fcubs.service.fcubsclservice.CREATEDISBURSEMENTIOPKRES;
import com.ofss.fcubs.service.fcubsclservice.DisbursementCreateIOType;
import com.ofss.fcubs.service.fcubsclservice.ERRORDETAILSType;
import com.ofss.fcubs.service.fcubsclservice.ERRORType;
import com.ofss.fcubs.service.fcubsclservice.FCUBSHEADERType;
import com.ofss.fcubs.service.fcubsclservice.MsgStatType;
import com.ofss.fcubs.service.fcubsclservice.UBSCOMPType;
import com.ofss.fcubs.service.fcubsclservice.DisbursementCreateIOType.DsbrDetail;
import com.ofss.fcubs.service.fcubsclservice.DisbursementCreateIOType.DsbrUserdef;

/**
 * 
 * @author Shabu
 * 
 */
public class CbsLoanDisbursementServiceSoapAdapter
		implements
		CbsTransactionServiceAdapter<CbsLoanDisbursementRequest, CbsBaseResponse> {

	@Override
	public CbsBaseResponse performTransaction(
			CbsLoanDisbursementRequest p_tranRequest) throws ServiceException {
		List<ERRORType> errorType = null;
		List<ERRORDETAILSType> errorDetails = null;

		CbsBaseResponse l_res = new CbsBaseResponse();
		/*try {
			FCUBSCLService service = new FCUBSCLService();
			FCUBSCLServiceSEI ser = service.getFCUBSCLServiceSEI();
			FCUBSHEADERType fcubsHeaderType = getFcubsHeaderTypeObject();
			CREATEDISBURSEMENTIOPKREQ requestMsg = populateCreateDisbrReq(
					p_tranRequest, fcubsHeaderType);
			CREATEDISBURSEMENTIOPKRES response = ser
					.createDisbursementIO(requestMsg);
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
		}*/
		l_res.setStatus(true);
		l_res.setResponseCode("0");
		l_res.setCbsResTxnRefNo("11110000");
		l_res.setResponseCode("SUCCESS");
		l_res.setResponseMessage("transaction process successfully");
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

	private CREATEDISBURSEMENTIOPKREQ populateCreateDisbrReq(
			CbsLoanDisbursementRequest p_tranRequest,
			FCUBSHEADERType fcubsHeaderType) {

		CREATEDISBURSEMENTIOPKREQ requestMsg = new CREATEDISBURSEMENTIOPKREQ();
		CREATEDISBURSEMENTIOPKREQ.FCUBSBODY fcubsBody = new CREATEDISBURSEMENTIOPKREQ.FCUBSBODY();
		DisbursementCreateIOType disbrIotype = new DisbursementCreateIOType();
		DsbrDetail disbr = new DsbrDetail();
		DsbrUserdef userDef = new DsbrUserdef();

		//XMLGregorianCalendar txnDate = getTxnDate(p_tranRequest.getTxnDate());
		
		fcubsHeaderType.setUSERID(ServiceConstants.DIS_USERID);
		fcubsHeaderType.setOPERATION(ServiceConstants.DIS_OPERATION);
		fcubsHeaderType.setFUNCTIONID(ServiceConstants.DIS_FUNCTIONID);
		fcubsHeaderType.setBRANCH(p_tranRequest.getBranchCode());
		requestMsg.setFCUBSHEADER(fcubsHeaderType);

		userDef.setFIELDCHAR1(p_tranRequest.getTxnRefNo());

		disbr.setSTTLMODE(ServiceConstants.SETTLE_MODE);
		//disbr.setSTTLCCY(p_tranRequest.getTxnCcy());
		disbr.setSETTLEBRANCH(p_tranRequest.getBranchCode());
		disbr.setSTTLACC(ServiceConstants.SETTLE_ACC);
	//	disbr.setSTTLAMT(new BigDecimal(p_tranRequest.getTxnAmt()));
		//disbr.setSTTLLCYEQ(new BigDecimal(p_tranRequest.getTxnAmt()));

		disbrIotype.setACTNO(p_tranRequest.getLoanAccNo());
		disbrIotype.setBR(p_tranRequest.getBranchCode());
		disbrIotype.setESN(new BigDecimal(1));
		//disbrIotype.setVALDT(txnDate);
		//disbrIotype.setEXECUTIONDATE(txnDate);
		disbrIotype.setAUTHSTAT(ServiceConstants.AUTHSTAT);
	//	disbrIotype.setREMARKS(p_tranRequest.getNarrative());
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

}
