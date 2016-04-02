package com.bfsi.mfi.cbs.adapter.soap;

import java.math.BigDecimal;
import java.util.List;

import com.bfsi.mfi.cbs.adapter.CbsTransactionServiceAdapter;
import com.bfsi.mfi.cbs.request.CbsCashWithdrawRequest;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.exception.CbsServiceException;
import com.bfsi.mfi.rest.constants.ServiceConstants;
import com.bfsi.mfi.util.ApplicationUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.ofss.fcubs.gw.ws.types.FCUBSRTService;
import com.ofss.fcubs.gw.ws.types.FCUBSRTServiceSEI;
import com.ofss.fcubs.service.fcubsrtservice.CREATETRANSACTIONIOPKREQ;
import com.ofss.fcubs.service.fcubsrtservice.CREATETRANSACTIONIOPKRES;
import com.ofss.fcubs.service.fcubsrtservice.ERRORDETAILSType;
import com.ofss.fcubs.service.fcubsrtservice.ERRORType;
import com.ofss.fcubs.service.fcubsrtservice.FCUBSHEADERType;
import com.ofss.fcubs.service.fcubsrtservice.RetailTellerTypeIO;
import com.ofss.fcubs.service.fcubsrtservice.WARNINGDETAILSType;
import com.ofss.fcubs.service.fcubsrtservice.WARNINGType;

/**
 * 
 * @author Shabu
 * 
 */

public class CbsCashWithdrawServiceSoapAdapter implements
		CbsTransactionServiceAdapter<CbsCashWithdrawRequest, CbsBaseResponse> {
	
	private static final String  WITHDRAW_PRODUCT = "CHWL";
	private static final String  WITHDRAW_TXNTRAN = "CHW";

	@Override
	public CbsBaseResponse performTransaction(
			CbsCashWithdrawRequest p_tranRequest) throws CbsServiceException {

		CbsBaseResponse l_res = new CbsBaseResponse();	
		
		l_res.setCbsResStat("SUCCESS");
		l_res.setCbsResTxnRefNo("112323");
		l_res.setResponseCode("0");
		l_res.setResponseMessage("WITHDRAWAL SUCCCESS");
		l_res.setStatus(true);
		return l_res;
		
		/*String l_cbsResCode = null;	
		String l_cbsResDesc = null;
		WARNINGType l_warnType = null;
		List<WARNINGDETAILSType> l_warnDetails = null;
		ERRORType l_errorType = null;
		List<ERRORDETAILSType> l_errorDetails = null;
		LoggerUtil.cbsJobDebug("Withdraw Trans Started");
		try {	
			FCUBSRTService l_service = new FCUBSRTService();		
			FCUBSRTServiceSEI l_serviceSEI = l_service.getFCUBSRTServiceSEI();
			
			CREATETRANSACTIONIOPKREQ l_cbsReq = cashWithdrawTranRequest(p_tranRequest);		
			CREATETRANSACTIONIOPKRES l_cbsRes = l_serviceSEI.createTransactionIO(l_cbsReq);		
			if(l_cbsRes != null){				
				l_cbsResCode = l_cbsRes.getFCUBSHEADER().getMSGSTAT().value();			
			} 
			
			if("SUCCESS".equalsIgnoreCase(l_cbsResCode)){
				l_warnType = l_cbsRes.getFCUBSBODY().getFCUBSWARNINGRESP();
				if (l_warnType != null) {
					l_warnDetails = l_warnType.getWARNING();
				}
				
				if(l_warnDetails != null && !l_warnDetails.isEmpty()){
					l_cbsResDesc = l_warnDetails.get(0).getWDESC();
				}
				l_res.setStatus(true);
				l_res.setResponseCode(l_cbsResCode);
				l_res.setResponseMessage(l_cbsResDesc);
				
			} else {
				l_errorType = l_cbsRes.getFCUBSBODY().getFCUBSERRORRESP();
				if (l_errorType != null) {
					l_errorDetails = l_errorType.getERROR();
				}
				
				if(l_errorDetails != null && !l_errorDetails.isEmpty()){
					l_cbsResDesc = l_errorDetails.get(0).getEDESC();
				}
				
				l_res.setStatus(false);
				l_res.setResponseCode(l_cbsResCode);
				l_res.setResponseMessage(l_cbsResDesc);
			}
			LoggerUtil.cbsJobDebug("Withdraw Trans Ended");
			return l_res;
		} catch(Exception e){
			l_res.setStatus(false);
			l_res.setResponseCode("MFI10101");
			l_res.setResponseMessage("Unhandeled Exception while process withdraw request.");
			LoggerUtil.cbsJobError("Unhandeled Exception :", e);
			return l_res;
		}*/
	}
	
/*	private CREATETRANSACTIONIOPKREQ cashWithdrawTranRequest(CbsCashWithdrawRequest p_tranRequest) {
		CREATETRANSACTIONIOPKREQ requestMsg =  new CREATETRANSACTIONIOPKREQ();
		
		Request Header
		FCUBSHEADERType fcubsHeaderType = new FCUBSHEADERType();
		fcubsHeaderType.setSOURCE(ServiceConstants.RT_SOURCE);
		fcubsHeaderType.setUBSCOMP(com.ofss.fcubs.service.fcubsrtservice.UBSCOMPType.FCUBS);
		fcubsHeaderType.setUSERID(ServiceConstants.RT_USERID);
		fcubsHeaderType.setBRANCH(p_tranRequest.getBranchCode());
		fcubsHeaderType.setSERVICE(ServiceConstants.RT_SERVICE);
		fcubsHeaderType.setOPERATION(ServiceConstants.RT_OPERATION);
		
		requestMsg.setFCUBSHEADER(fcubsHeaderType);
		
		Request Body
		CREATETRANSACTIONIOPKREQ.FCUBSBODY  fcubsBody = new CREATETRANSACTIONIOPKREQ.FCUBSBODY();		
		RetailTellerTypeIO transactionDetails = new RetailTellerTypeIO();		
		transactionDetails.setPRD(WITHDRAW_PRODUCT);
		transactionDetails.setBRN(p_tranRequest.getBranchCode());
		transactionDetails.setTXNBRN(p_tranRequest.getBranchCode());
		transactionDetails.setTXNACC(p_tranRequest.getAccNo());
		transactionDetails.setTXNCCY(p_tranRequest.getTxnCcy());
		transactionDetails.setTXNAMT(new BigDecimal(p_tranRequest.getTxnAmt()));
		transactionDetails.setTXNTRN(WITHDRAW_TXNTRAN);
		transactionDetails.setTXNDATE(ApplicationUtil.DateAsStringFormat(p_tranRequest.getTxnTime(), "dd-MM-yyyy"));
		
		fcubsBody.setTransactionDetailsIO(transactionDetails);
		
				
		requestMsg.setFCUBSBODY(fcubsBody);
		
		return requestMsg;
	}*/

}
