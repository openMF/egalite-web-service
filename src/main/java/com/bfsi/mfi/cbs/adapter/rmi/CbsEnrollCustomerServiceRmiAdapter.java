package com.bfsi.mfi.cbs.adapter.rmi;

import org.apache.cxf.common.util.Base64Utility;
import org.springframework.beans.BeanUtils;

import com.bfsi.mfi.cbs.adapter.CbsEnrollCustomerServiceAdapter;
import com.bfsi.mfi.cbs.model.CbsEnrollCustomer;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.util.LoggerUtil;
import com.cbs.bean.CbsBaseTransResponse;
import com.cbs.bean.CustomerDocument;
import com.cbs.bean.CustomerEnrolInfo;
import com.cbs.rmi.impl.CbsTranInterfaceImpl;
import com.cbs.service.CbsTranInterface;

/**
 * 
 * @author Vishal
 * 
 */
public class CbsEnrollCustomerServiceRmiAdapter implements
CbsEnrollCustomerServiceAdapter<CbsEnrollCustomer, CbsBaseResponse> {
	
	@Override
	public CbsBaseResponse processEnrollCustomer(CbsEnrollCustomer p_enrollCust)
			throws ServiceException {
		LoggerUtil.cbsJobDebug("Inside RMI for "+p_enrollCust.getClass().getName());
		CbsBaseResponse l_res = new CbsBaseResponse();
		//l_res.setStatus(true);
		//l_res.setCbsResTxnRefNo("000");
		//l_res.setResponseCode("P");
		//l_res.setResponseMessage("SUCCESS");
		
		try {
			
			CustomerEnrolInfo l_cbsReq=new CustomerEnrolInfo();
			CustomerDocument l_doc=new CustomerDocument();
			BeanUtils.copyProperties(p_enrollCust, l_cbsReq,new String[]{"document", "dob", "txnInitTime", "txnSyncTime"});
			
			if (p_enrollCust.getTxnInitTime() != null) {
				l_cbsReq.setTxnInitTime(p_enrollCust.getTxnInitTime().getTime());
			}
			if (p_enrollCust.getDob() != null) {
				
				l_cbsReq.setDob(p_enrollCust.getDob().getTime());
			}
			if (p_enrollCust.getTxnSyncTime() != null) {				
				l_cbsReq.setTxnSyncTime(p_enrollCust.getTxnSyncTime().getTime());
			}
			
			l_doc.setEnrolmentId(p_enrollCust.getEnrolmentId());
			
			if (p_enrollCust.getDocument().getKycCustImage() != null) {			
				l_doc.setKycCustImage(Base64Utility.encode(p_enrollCust.getDocument().getKycCustImage()));
			}
			if (p_enrollCust.getDocument().getKycIdImage1() != null) {			
				l_doc.setKycIdImage1(Base64Utility.encode(p_enrollCust.getDocument().getKycIdImage1()));
			}
			if (p_enrollCust.getDocument().getKycIdImage2() != null) {			
				l_doc.setKycIdImage2(Base64Utility.encode(p_enrollCust.getDocument().getKycIdImage2()));
			}
			if (p_enrollCust.getDocument().getKycIdImage3() != null) {			
				l_doc.setKycIdImage3(Base64Utility.encode(p_enrollCust.getDocument().getKycIdImage3()));
			}
			
			//Biometric 
			if (p_enrollCust.getDocument().getImageTemplateRHLF() != null) {			
				l_doc.setImageTemplateRHLF(Base64Utility.encode(p_enrollCust.getDocument().getImageTemplateRHLF()));
			}
			if (p_enrollCust.getDocument().getImageTemplateRHRF() != null) {			
				l_doc.setImageTemplateRHRF(Base64Utility.encode(p_enrollCust.getDocument().getImageTemplateRHRF()));
			}
			if (p_enrollCust.getDocument().getImageTemplateRHMF() != null) {			
				l_doc.setImageTemplateRHMF(Base64Utility.encode(p_enrollCust.getDocument().getImageTemplateRHMF()));
			}
			if (p_enrollCust.getDocument().getImageTemplateRHIF() != null) {			
				l_doc.setImageTemplateRHIF(Base64Utility.encode(p_enrollCust.getDocument().getImageTemplateRHIF()));
			}
			if (p_enrollCust.getDocument().getImageTemplateRHTF() != null) {			
				l_doc.setImageTemplateRHTF(Base64Utility.encode(p_enrollCust.getDocument().getImageTemplateRHTF()));
			}
			if (p_enrollCust.getDocument().getImageTemplateLHLF() != null) {			
				l_doc.setImageTemplateLHLF(Base64Utility.encode(p_enrollCust.getDocument().getImageTemplateLHLF()));
			}
			if (p_enrollCust.getDocument().getImageTemplateLHRF() != null) {			
				l_doc.setImageTemplateLHRF(Base64Utility.encode(p_enrollCust.getDocument().getImageTemplateLHRF()));
			}
			if (p_enrollCust.getDocument().getImageTemplateLHMF() != null) {			
				l_doc.setImageTemplateLHMF(Base64Utility.encode(p_enrollCust.getDocument().getImageTemplateLHMF()));
			}
			if (p_enrollCust.getDocument().getImageTemplateLHIF() != null) {			
				l_doc.setImageTemplateLHIF(Base64Utility.encode(p_enrollCust.getDocument().getImageTemplateLHIF()));
			}
			if (p_enrollCust.getDocument().getImageTemplateLHTF() != null) {			
				l_doc.setImageTemplateLHTF(Base64Utility.encode(p_enrollCust.getDocument().getImageTemplateLHTF()));
			}
			
			if (p_enrollCust.getDocument().getImageScanRHLF() != null) {			
				l_doc.setImageScanRHLF(Base64Utility.encode(p_enrollCust.getDocument().getImageScanRHLF()));
			}
			if (p_enrollCust.getDocument().getImageScanRHRF() != null) {			
				l_doc.setImageScanRHRF(Base64Utility.encode(p_enrollCust.getDocument().getImageScanRHRF()));
			}
			if (p_enrollCust.getDocument().getImageScanRHMF() != null) {			
				l_doc.setImageScanRHMF(Base64Utility.encode(p_enrollCust.getDocument().getImageScanRHMF()));
			}
			if (p_enrollCust.getDocument().getImageScanRHIF() != null) {			
				l_doc.setImageScanRHIF(Base64Utility.encode(p_enrollCust.getDocument().getImageScanRHIF()));
			}
			if (p_enrollCust.getDocument().getImageScanRHTF() != null) {			
				l_doc.setImageScanRHTF(Base64Utility.encode(p_enrollCust.getDocument().getImageScanRHTF()));
			}
			if (p_enrollCust.getDocument().getImageScanLHLF() != null) {			
				l_doc.setImageScanLHLF(Base64Utility.encode(p_enrollCust.getDocument().getImageScanLHLF()));
			}
			if (p_enrollCust.getDocument().getImageScanLHRF() != null) {			
				l_doc.setImageScanLHRF(Base64Utility.encode(p_enrollCust.getDocument().getImageScanLHRF()));
			}
			if (p_enrollCust.getDocument().getImageScanLHMF() != null) {			
				l_doc.setImageScanLHMF(Base64Utility.encode(p_enrollCust.getDocument().getImageScanLHMF()));
			}
			if (p_enrollCust.getDocument().getImageScanLHIF() != null) {			
				l_doc.setImageScanLHIF(Base64Utility.encode(p_enrollCust.getDocument().getImageScanLHIF()));
			}
			if (p_enrollCust.getDocument().getImageScanLHTF() != null) {			
				l_doc.setImageScanLHTF(Base64Utility.encode(p_enrollCust.getDocument().getImageScanLHTF()));
			}
			
			
			
			l_cbsReq.setDocument(l_doc);
			/*CbsTranInterface cbsService=	CbsRmiService.getCbsRmiService();
			CbsBaseTransResponse l_cbsRes=cbsService.postCustEnrol(l_cbsReq);*/
			
			CbsTranInterface tranIntr = new CbsTranInterfaceImpl();
			CbsBaseTransResponse l_cbsRes=tranIntr.postCustEnrol(l_cbsReq);
			
			
			if(l_cbsRes.getResponseCode().equals("0"))
				l_res.setStatus(true);
			else 
				l_res.setStatus(false);
			BeanUtils.copyProperties(l_cbsRes,l_res);
			
			LoggerUtil.cbsJobDebug("Rmi Response ::"+l_res.toString());
			
		} catch (Exception e) {
			l_res.setCbsResStat("X");
			l_res.setResponseCode("1");
			l_res.setResponseMessage("Customer Enrolment Request Failed.");
			e.printStackTrace();
		}
		
		return l_res;
	}


}
