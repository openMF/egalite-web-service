package com.bfsi.mfi.rest.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.cxf.common.util.Base64Utility;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.entity.CustomerBiometricServiceRequest;
import com.bfsi.mfi.entity.CustomerEnrolmentServiceRequest;
import com.bfsi.mfi.exception.ServiceException;

import com.bfsi.mfi.rest.model.CustomerBiometricDetails;
import com.bfsi.mfi.rest.model.CustomerBiometricRequest;
import com.bfsi.mfi.rest.model.CustomerBiometricResponse;
import com.bfsi.mfi.rest.model.CustomerEnrolmentDetails;
import com.bfsi.mfi.rest.model.CustomerEnrolmentRequest;
import com.bfsi.mfi.rest.model.CustomerEnrolmentResponse;
import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.rest.service.CustomerEnrolmentSyncService;
import com.bfsi.mfi.service.CustomerBiometricService;
import com.bfsi.mfi.service.CustomerInfoService;
import com.bfsi.mfi.util.EncryptDecryptUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CustomerBiometricInfoVO;
import com.bfsi.mfi.vo.CustomerDocumentInfoVO;
import com.bfsi.mfi.vo.CustomerEnrolmentInfoVO;

/**
 * 
 * @author Shabu
 * 
 */
@Component("customerEnrolmentSyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/customer")
public class CustomerEnrolmentSyncServiceImpl implements
		CustomerEnrolmentSyncService {

	@Autowired
	private CustomerInfoService customerInfoService;
	
	@Autowired
	private CustomerBiometricService customerBiometricService;
	
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;

	@Override
	@Path("/enrollment")
	@POST
	public JsonResponseWrapper submitCustomerDetails(
			JsonRequestWrapper p_wrapRequest) {
		CustomerEnrolmentRequest p_request=null;
	try {
		 p_request=(CustomerEnrolmentRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, CustomerEnrolmentRequest.class);
	} catch (Exception e) {
		LoggerUtil.mbsJobError("exception", e);
		return new JsonResponseWrapper();
	}
		
		CustomerEnrolmentResponse l_res=null;
		CustomerEnrolmentServiceRequest l_serReq = new CustomerEnrolmentServiceRequest();
		try {
			 l_res = validate(p_request);
			 if(!l_res.getStatus())
				 return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
						 
			 l_res.setStatus(false);
			/*if (p_request.getEnrolList() == null
					|| p_request.getEnrolList().isEmpty()) {
				l_res.setMessageCode("");
				return l_res;
			}*/
			List<CustomerEnrolmentInfoVO> l_eustEnrolList = new ArrayList<CustomerEnrolmentInfoVO>();
			List<String> l_recvdId = new ArrayList<String>();
			for (CustomerEnrolmentDetails l_custData : p_request.getEnrolList()) {
				CustomerEnrolmentInfoVO l_custInfoVo = new CustomerEnrolmentInfoVO();
				BeanUtils.copyProperties(l_custData, l_custInfoVo,
						new String[] { "document", "biometric", "txnInitTime", "dob",
								"txnSyncTime" });
				CustomerDocumentInfoVO l_docVo = new CustomerDocumentInfoVO();
				BeanUtils.copyProperties(l_custData.getDocument(), l_docVo,
						new String[] { "kycCustImage", "kycIdImage1",
								"kycIdImage2", "kycIdImage3" });

				l_custInfoVo.setWorkFlowQueType("E");
				l_custInfoVo.setAuthStatus("U");
				l_custInfoVo.setIsSentToCbs("N");
				LoggerUtil.mbsJobDebug("Enrol Id :" +l_custData.getEnrolmentId()+" POC :" +l_custData.getPoc()+" Grp Indi Type :" +l_custData.getGroupIndlType()+" Temp Grp Id :" +l_custData.getTmpGrpId());
								
				
				if (l_custData.getDocument().getKycCustImage() != null) {
					l_docVo.setKycCustImage(Base64Utility.decode(l_custData
							.getDocument().getKycCustImage()));
				}
				if (l_custData.getDocument().getKycIdImage1() != null) {
					l_docVo.setKycIdImage1(Base64Utility.decode(l_custData
							.getDocument().getKycIdImage1()));
				}
				if (l_custData.getDocument().getKycIdImage2() != null) {
					l_docVo.setKycIdImage2(Base64Utility.decode(l_custData
							.getDocument().getKycIdImage2()));
				}
				if (l_custData.getDocument().getKycIdImage3() != null) {
					l_docVo.setKycIdImage3(Base64Utility.decode(l_custData
							.getDocument().getKycIdImage3()));
				}

				l_custInfoVo.setDocument(l_docVo);
				Calendar l_cal = Calendar.getInstance();
				if (l_custData.getTxnInitTime() != null) {
					l_cal.setTimeInMillis(l_custData.getTxnInitTime());
					l_custInfoVo.setTxnInitTime(l_cal.getTime());
				}
				if (l_custData.getDob() != null) {
					l_cal.setTimeInMillis(l_custData.getDob());
					l_custInfoVo.setDob(l_cal.getTime());
				}
				if (l_custData.getTxnSyncTime() != null) {
					l_cal.setTimeInMillis(l_custData.getTxnSyncTime());
					l_custInfoVo.setTxnSyncTime(l_cal.getTime());
				}
				// set biometric data
				 CustomerBiometricInfoVO l_custBioVo = setBiometricValueObject(l_custData.getBiometric());
				 l_custInfoVo.setBiometric(l_custBioVo);

				l_eustEnrolList.add(l_custInfoVo);
				l_recvdId.add(l_custData.getEnrolmentId());
			}

			l_serReq.setCustEnrolVo(l_eustEnrolList);
			customerInfoService.uploadCustomerDetails(l_serReq);
			l_res.setRecvdIds(l_recvdId);
			l_res.setStatus(true);
		} catch (ServiceException e) {
			LoggerUtil.mbsJobError(
					"Service exception while customer enrolment: MFI10101", e);
			l_res.setMessageCode("MFI10101");
		} catch (Exception e) {
			LoggerUtil
					.mbsJobError(
							"unhandled exception while customer enrolment: MFI10101",
							e);
			l_res.setMessageCode("MFI10101");
		}
		 return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
	}

	private CustomerEnrolmentResponse validate(
			CustomerEnrolmentRequest p_request) {
		CustomerEnrolmentResponse l_res = new CustomerEnrolmentResponse();

		if (p_request.getEnrolList() == null
				|| p_request.getEnrolList().isEmpty()) {
			l_res.setMessageCode("MFI10131");
			return l_res;
		}

		for (CustomerEnrolmentDetails each : p_request.getEnrolList()) {
			if (each.getEnrolmentId() == null) {
				l_res.setMessageCode("MFI10132");
				return l_res;
			}
			if (each.getDocument() == null
					|| each.getDocument().getEnrolmentId() == null
					|| !each.getDocument().getEnrolmentId()
							.equals(each.getEnrolmentId())) {
				l_res.setMessageCode("MFI10133");
				return l_res;
			}
			if (each.getBiometric() == null	
				|| each.getBiometric().getEnrolmentId() == null
				|| !each.getBiometric().getEnrolmentId().equals(each.getEnrolmentId())) {
				l_res.setMessageCode("MFI10134");
				return l_res;
			}
		}
		l_res.setStatus(true);
		return l_res;
	}
	
	@Override
	@Path("/biometric")
	@POST
	public JsonResponseWrapper submitCustomerBiometricDetails(
			JsonRequestWrapper p_wrapRequest) {
		CustomerBiometricRequest p_request=null;
		try {
			 p_request=(CustomerBiometricRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, CustomerBiometricRequest.class);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("exception", e);
			return new JsonResponseWrapper();
		}
		
		
		CustomerBiometricResponse l_res = null;
		CustomerBiometricServiceRequest l_serReq = new CustomerBiometricServiceRequest();
		
		try {
			 l_res = validateBiometric(p_request);
			 if(!l_res.getStatus())
				 return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
			 
			 l_res.setStatus(false);
			 List<CustomerBiometricInfoVO> l_custBioList = new ArrayList<CustomerBiometricInfoVO>();
			 List<String> l_recvdId = new ArrayList<String>();
			 CustomerBiometricInfoVO l_custBioVo = null;
			 for (CustomerBiometricDetails l_bioData : p_request.getBiometricList()) {
				 l_custBioVo = setBiometricValueObject(l_bioData);				 
				 l_custBioList.add(l_custBioVo);
				 l_recvdId.add(l_bioData.getEnrolmentId());				
			 }
			 
			 l_serReq.setCustBioVo(l_custBioList);
			 customerBiometricService.uploadCustomerBiometricDetails(l_serReq);
			 l_res.setRecvdIds(l_recvdId);
			 l_res.setStatus(true);
			 
		} catch (ServiceException e) {
			LoggerUtil.mbsJobError(
					"Service exception while customer biometric: MFI10101", e);
			l_res.setMessageCode("MFI10101");
		} catch (Exception e) {
			LoggerUtil
					.mbsJobError(
							"unhandled exception while customer biometric: MFI10101",
							e);
			l_res.setMessageCode("MFI10101");
		}
		 return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
	}
	
	private CustomerBiometricResponse validateBiometric(
			CustomerBiometricRequest p_request) {
		CustomerBiometricResponse l_res = new CustomerBiometricResponse();

		if (p_request.getBiometricList() == null
				|| p_request.getBiometricList().isEmpty()) {
			l_res.setMessageCode("MFI10134");
			return l_res;
		}

		for (CustomerBiometricDetails each : p_request.getBiometricList()) {
			if (each.getEnrolmentId() == null 
					/*|| each.getLhifTmpltData()  == null 
					|| each.getLhlfTmpltData()  == null 
					|| each.getLhmfTmpltData()  == null 
					|| each.getLhrfTmpltData() == null 
					|| each.getLhtfTmpltData()  == null 
					|| each.getRhifTmpltData()  == null 
					|| each.getRhlfTmpltData() == null 
					|| each.getRhmfTmpltData() == null 
					|| each.getRhrfTmpltData() == null 
					|| each.getRhtfTmpltData() == null */
					) {
				l_res.setMessageCode("MFI10135");
				return l_res;
			}			
		}
		l_res.setStatus(true);
		return l_res;
	}
	
	private CustomerBiometricInfoVO setBiometricValueObject(CustomerBiometricDetails p_bioData){
		CustomerBiometricInfoVO l_custBioVo = new CustomerBiometricInfoVO();
		try {
		 l_custBioVo.setEnrolmentId(p_bioData.getEnrolmentId());
		 if (p_bioData.getLhlfTmpltData() != null) {
			 l_custBioVo.setLhlfTmpltData(Base64Utility.decode(p_bioData.getLhlfTmpltData())); 
		 }
		 if (p_bioData.getLhrfTmpltData() != null) {
			 l_custBioVo.setLhrfTmpltData(Base64Utility.decode(p_bioData.getLhrfTmpltData())); 
		 }
		 if (p_bioData.getLhmfTmpltData() != null) {
			 l_custBioVo.setLhmfTmpltData(Base64Utility.decode(p_bioData.getLhmfTmpltData())); 
		 }
		 if (p_bioData.getLhifTmpltData() != null) {
			 l_custBioVo.setLhifTmpltData(Base64Utility.decode(p_bioData.getLhifTmpltData())); 
		 }
		 if (p_bioData.getLhtfTmpltData() != null) {
			 l_custBioVo.setLhtfTmpltData(Base64Utility.decode(p_bioData.getLhtfTmpltData())); 
		 }
		 if (p_bioData.getRhlfTmpltData() != null) {
			 l_custBioVo.setRhlfTmpltData(Base64Utility.decode(p_bioData.getRhlfTmpltData())); 
		 }
		 if (p_bioData.getRhrfTmpltData() != null) {
			 l_custBioVo.setRhrfTmpltData(Base64Utility.decode(p_bioData.getRhrfTmpltData())); 
		 }
		 if (p_bioData.getRhmfTmpltData() != null) {
			 l_custBioVo.setRhmfTmpltData(Base64Utility.decode(p_bioData.getRhmfTmpltData())); 
		 }
		 if (p_bioData.getRhifTmpltData() != null) {
			 l_custBioVo.setRhifTmpltData(Base64Utility.decode(p_bioData.getRhifTmpltData())); 
		 }
		 if (p_bioData.getRhtfTmpltData() != null) {
			 l_custBioVo.setRhtfTmpltData(Base64Utility.decode(p_bioData.getRhtfTmpltData())); 
		 }
		 
		 
		 //Added
		 if (p_bioData.getRhlfScanData() != null) {
			 l_custBioVo.setRhlfScanData(Base64Utility.decode(p_bioData.getRhlfScanData())); 
		 }
		 if (p_bioData.getRhrfScanData() != null) {
			 l_custBioVo.setRhrfScanData(Base64Utility.decode(p_bioData.getRhrfScanData())); 
		 }
		 if (p_bioData.getRhmfScanData() != null) {
			 l_custBioVo.setRhmfScanData(Base64Utility.decode(p_bioData.getRhmfScanData())); 
		 }
		 if (p_bioData.getRhifScanData() != null) {
			 l_custBioVo.setRhifScanData(Base64Utility.decode(p_bioData.getRhifScanData())); 
		 }
		 if (p_bioData.getRhtfScanData() != null) {
			 l_custBioVo.setRhtfScanData(Base64Utility.decode(p_bioData.getRhtfScanData())); 
		 }
		 if (p_bioData.getLhlfScanData() != null) {
			 l_custBioVo.setLhlfScanData(Base64Utility.decode(p_bioData.getLhlfScanData())); 
		 }
		 if (p_bioData.getLhrfScanData() != null) {
			 l_custBioVo.setLhrfScanData(Base64Utility.decode(p_bioData.getLhrfScanData())); 
		 }
		 if (p_bioData.getLhmfScanData() != null) {
			 l_custBioVo.setLhmfScanData(Base64Utility.decode(p_bioData.getLhmfScanData())); 
		 }
		 if (p_bioData.getLhifScanData() != null) {
			 l_custBioVo.setLhifScanData(Base64Utility.decode(p_bioData.getLhifScanData())); 
		 }
		 if (p_bioData.getLhtfScanData() != null) {
			 l_custBioVo.setLhtfScanData(Base64Utility.decode(p_bioData.getLhtfScanData())); 
		 }
		} catch(Exception e){
			LoggerUtil
			.mbsJobError(
					"unhandled exception while customer biometric: MFI10101",
					e);	
		}
		 
		return l_custBioVo;
		
	}

}
