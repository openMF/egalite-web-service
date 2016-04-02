package com.bfsi.mfi.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.DocumentDao;
import com.bfsi.mfi.dao.EnrollCustomerDao;
import com.bfsi.mfi.entity.CustEnrolBiometric;
import com.bfsi.mfi.entity.CustEnrolKyc;
import com.bfsi.mfi.entity.Document;
import com.bfsi.mfi.entity.EnrollCustomer;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.EnrollCustomerService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CustEnrolBiometricVO;
import com.bfsi.mfi.vo.CustEnrolKycVO;
import com.bfsi.mfi.vo.EnrollCustomerVO;


@Service(value = "enrollCustomerService")
@Transactional(rollbackFor = { ServiceException.class })
public class EnrollCustomerServiceImpl extends
		MaintenanceServiceImpl<EnrollCustomerVO, EnrollCustomer> implements
		EnrollCustomerService {

	@Autowired
	private EnrollCustomerDao enrollCustomerDao;
	
	@Autowired
	private DocumentDao documentDao;

	private DefaultStreamedContent customerImage;
	private DefaultStreamedContent streamImage1;
	private DefaultStreamedContent streamImage2;
	private DefaultStreamedContent streamImage3;
	
	private final String defaultImage ="";
	
	@Override
	public EnrollCustomerVO get(String id) throws ServiceException {
		LoggerUtil.ibsJobDebug("getting  EnrollCustomer with id: " + id);
		EnrollCustomerVO enrollCustomer = null;
		try {
			enrollCustomer = super.get(id);
			Map<String, Document> docMap = new HashMap<String, Document>();
			
			/*List<Document> documents = documentDao
					.getCustomerDocuments(enrollCustomer.getEnrollmentId());*/
			/*if (documents != null) {
				for (Document doc : documents) {
					docMap.put(doc.getDocumentName(), doc);
				}
			}*/
			//enrollCustomer.setDocuments(docMap);
			
		} catch (DataAccessException e) {
			String message = "DataAccessException while getting  EnrollCustomer with id: "
					+ id;
			LoggerUtil.ibsJobError(message, e);
			throw new ServiceException(message, e);
		}
		return enrollCustomer;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected EnrollCustomerDao getMaintenanceDao() {
		return enrollCustomerDao;
	}

	@Override
	protected EnrollCustomer getEntity(EnrollCustomerVO vo) {
		EnrollCustomer enrollCustomer = new EnrollCustomer();
		
		CustEnrolKyc kyc = new CustEnrolKyc();
		CustEnrolKycVO kycvo = vo.getCustEnrolKyc();
		BeanUtils.copyProperties(kycvo, kyc);
		
		enrollCustomer.setCustEnrolKyc(kyc); 
		
		enrollCustomer.setId(vo.getId());
		enrollCustomer.setWorkFlowQType(vo.getWorkFlowQType());
		enrollCustomer.setFirstName(vo.getFirstName());
		enrollCustomer.setLastName(vo.getLastName());
		enrollCustomer.setMiddleName(vo.getMiddleName());
		enrollCustomer.setDob(vo.getDob());
		enrollCustomer.setGender(vo.getGender());
		enrollCustomer.setResidentialType(vo.getResidentialType());
		enrollCustomer.setNationality(vo.getNationality());
		enrollCustomer.setAddress1(vo.getAddress1());
		enrollCustomer.setAddress2(vo.getAddress2());
		//Newly added columns address3 & address4
		enrollCustomer.setAddress3(vo.getAddress3());
		enrollCustomer.setAddress4(vo.getAddress4());
		enrollCustomer.setCity(vo.getCity());
		enrollCustomer.setState(vo.getState());
		enrollCustomer.setZipCode(vo.getZipCode());
		enrollCustomer.setCountry(vo.getCountry());
		enrollCustomer.setEmailId(vo.getEmailId());
		enrollCustomer.setContactNumber(vo.getContactNumber());
		enrollCustomer.setMartialStatus(vo.getMartialStatus());
		enrollCustomer.setProfession(vo.getProfession());
		enrollCustomer.setProfessionRemark(vo.getProfessionRemark());
		enrollCustomer.setAccountCategory(vo.getAccountCategory());
		enrollCustomer.setAccountType(vo.getAccountType());
		enrollCustomer.setCurrency(vo.getCurrency());
		enrollCustomer.setIsActive(vo.getIsActive());
		enrollCustomer.setModuleCode(vo.getModuleCode());
		enrollCustomer.setTxnCode(vo.getTxnCode());
		enrollCustomer.setTxnInitTime(vo.getTxnInitTime());
		enrollCustomer.setTxnSyncTime(vo.getTxnSyncTime());
		enrollCustomer.setAgentId(vo.getAgentId());
		enrollCustomer.setDeviceId(vo.getDeviceId());
		enrollCustomer.setLocationCode(vo.getLocationCode());
		enrollCustomer.setTxnStatus(vo.getTxnStatus());
		enrollCustomer.setTxnErrCode(vo.getTxnErrCode());
		enrollCustomer.setTxnErrMessage(vo.getTxnErrMessage());
		enrollCustomer.setAuthStatus(vo.getAuthStatus());
		
		//Newly added columns below...
		enrollCustomer.setGroupIndividualType(vo.getGroupIndividualType());
		enrollCustomer.setTempGroupId(vo.getTempGroupId());
		enrollCustomer.setIsKycOnly(vo.getIsKycOnly());
		enrollCustomer.setCustomerId(vo.getCustomerId());
		enrollCustomer.setIsSentToCbs(vo.getIsSentToCbs()); 
		enrollCustomer.setCbsResponseStat(vo.getCbsResponseStat());
		enrollCustomer.setCbsResponseTxnRefNo(vo.getCbsResponseTxnRefNo());
		enrollCustomer.setPoc(vo.getPoc());
		
		return enrollCustomer; //vo.getEntity();
	}

	@Override
	protected EnrollCustomerVO getValueObject(EnrollCustomer entity) {
		    EnrollCustomerVO enrollCustomerVO = new EnrollCustomerVO(entity);
		    
		    //****added image convertion byte array to stream content 
		    CustEnrolKycVO vo =  new CustEnrolKycVO(); //new CustEnrolKycVO(entity.getCustEnrolKyc());
		    CustEnrolKyc ck =  entity.getCustEnrolKyc(); //new CustEnrolKyc();
		    
		    customerImage = new DefaultStreamedContent(new ByteArrayInputStream(entity.getCustEnrolKyc().getKycImageCustomer()), "image/png");
		    streamImage1 = new DefaultStreamedContent(new ByteArrayInputStream(entity.getCustEnrolKyc().getKycId1Image()), "image/png");
		    streamImage2 = new DefaultStreamedContent(new ByteArrayInputStream(entity.getCustEnrolKyc().getKycId2Image()), "image/png");
		    streamImage3 = new DefaultStreamedContent(new ByteArrayInputStream(entity.getCustEnrolKyc().getKycId3Image()), "image/png");
		    
		    vo.setCustomerImage(customerImage);
		    vo.setStreamImage1(streamImage1);
		    vo.setStreamImage2(streamImage2);
		    vo.setStreamImage3(streamImage3);
		   // added
		   
		    BeanUtils.copyProperties(ck, vo);
		    
		   // System.out.println("kyc details after page load");
		   // System.out.println("getKycId1ProofType:: "+vo.getKycId1ProofType());
		    
			//enrollCustomerVO.setCustEnrolKycVO(new CustEnrolKycVO(entity.getCustEnrolKyc()));
			enrollCustomerVO.setCustEnrolKyc(vo);//added
			
			enrollCustomerVO.setId(entity.getId());
			enrollCustomerVO.setWorkFlowQType(entity.getWorkFlowQType());
			enrollCustomerVO.setFirstName(entity.getFirstName());
			enrollCustomerVO.setLastName(entity.getLastName());
			enrollCustomerVO.setMiddleName(entity.getMiddleName());
			enrollCustomerVO.setDob(entity.getDob());
			enrollCustomerVO.setGender(entity.getGender());
			enrollCustomerVO.setResidentialType(entity.getResidentialType());
			enrollCustomerVO.setNationality(entity.getNationality());
			enrollCustomerVO.setAddress1(entity.getAddress1());
			enrollCustomerVO.setAddress2(entity.getAddress2());
			//Newly added columns address3 & address4
			enrollCustomerVO.setAddress3(entity.getAddress3());
			enrollCustomerVO.setAddress4(entity.getAddress4());
			enrollCustomerVO.setCity(entity.getCity());
			enrollCustomerVO.setState(entity.getState());
			enrollCustomerVO.setZipCode(entity.getZipCode());
			enrollCustomerVO.setCountry(entity.getCountry());
			enrollCustomerVO.setEmailId(entity.getEmailId());
			enrollCustomerVO.setContactNumber(entity.getContactNumber());
			enrollCustomerVO.setMartialStatus(entity.getMartialStatus());
			enrollCustomerVO.setProfession(entity.getProfession());
			enrollCustomerVO.setProfessionRemark(entity.getProfessionRemark());
			enrollCustomerVO.setAccountCategory(entity.getAccountCategory());
			enrollCustomerVO.setAccountType(entity.getAccountType());
			enrollCustomerVO.setCurrency(entity.getCurrency());
			enrollCustomerVO.setIsActive(entity.getIsActive());
			enrollCustomerVO.setModuleCode(entity.getModuleCode());
			enrollCustomerVO.setTxnCode(entity.getTxnCode());
			enrollCustomerVO.setTxnInitTime(entity.getTxnInitTime());
			enrollCustomerVO.setTxnSyncTime(entity.getTxnSyncTime());
			enrollCustomerVO.setAgentId(entity.getAgentId());
			enrollCustomerVO.setDeviceId(entity.getDeviceId());
			enrollCustomerVO.setLocationCode(entity.getLocationCode());
			enrollCustomerVO.setTxnStatus(entity.getTxnStatus());
			enrollCustomerVO.setTxnErrCode(entity.getTxnErrCode());
			enrollCustomerVO.setTxnErrMessage(entity.getTxnErrMessage());
			enrollCustomerVO.setAuthStatus(entity.getAuthStatus());
			
			//Newly added columns below...
			enrollCustomerVO.setGroupIndividualType(entity.getGroupIndividualType());
			enrollCustomerVO.setTempGroupId(entity.getTempGroupId());
			enrollCustomerVO.setIsKycOnly(entity.getIsKycOnly());
			enrollCustomerVO.setCustomerId(entity.getCustomerId());
			enrollCustomerVO.setIsSentToCbs(entity.getIsSentToCbs()); 
			enrollCustomerVO.setCbsResponseStat(entity.getCbsResponseStat());
			enrollCustomerVO.setCbsResponseTxnRefNo(entity.getCbsResponseTxnRefNo());
			enrollCustomerVO.setPoc(entity.getPoc());
			
			return enrollCustomerVO;	
	}

	@Override
	public List<EnrollCustomerVO> getEnrollCustomerForAllocation() {
		LoggerUtil.ibsJobDebug("Inside getEnrollCustomerForAllocation ");
		try {
			List<EnrollCustomer> enrolCustomer = enrollCustomerDao
					.getEnrollCustomerForAllocation();
			if (enrolCustomer != null) {
				List<EnrollCustomerVO> enrollCustomerVOs = new ArrayList<EnrollCustomerVO>(
						enrolCustomer.size());
				for (EnrollCustomer lov : enrolCustomer) {
					EnrollCustomerVO enrollCustomerVO = new EnrollCustomerVO(
							lov);
					enrollCustomerVOs.add(enrollCustomerVO);
				}
				return enrollCustomerVOs;
			}
			return new ArrayList<EnrollCustomerVO>();
		} catch (DataAccessException e) {
			String message = "DataAccessException while getEnrollCustomerForAllocation";
			LoggerUtil.ibsJobError(message, e);
			throw new ServiceException(message, e);
		}
	}

	@Override
	public List<EnrollCustomerVO> getAuthorized() {
		LoggerUtil.ibsJobDebug("Inside getAuthorized ");
		try {
			List<EnrollCustomer> customer = enrollCustomerDao.getAuthorized();
			if (customer != null) {
				List<EnrollCustomerVO> enrollCustomerVOs = new ArrayList<EnrollCustomerVO>(
						customer.size());
				for (EnrollCustomer lov : customer) {
					EnrollCustomerVO enrollCustomerVO = new EnrollCustomerVO(
							lov);
					enrollCustomerVOs.add(enrollCustomerVO);
				}
				return enrollCustomerVOs;
			}
			return new ArrayList<EnrollCustomerVO>();
		} catch (DataAccessException e) {
			String message = "DataAccessException while getAuthorized";
			LoggerUtil.ibsJobError(message, e);
			throw new ServiceException(message, e);
		}

	}

	@Override
	public boolean isEnrollCustomerCodeAvailable(String customerCode)
			throws ServiceException {
		LoggerUtil
				.ibsJobDebug("Checking isEnrollCustomerCodeAvailable with code: "
						+ customerCode);
		try {
			return enrollCustomerDao
					.isEnrollCustomerCodeAvailable(customerCode);
		} catch (DataAccessException e) {
			String message = "DataAccessException while checking availability of Unique code:"
					+ customerCode;
			LoggerUtil.ibsJobError(message, e);
			throw new ServiceException(message, e);
		}
	}

	@Override
	public EnrollCustomerVO create(EnrollCustomerVO vo) throws ServiceException {
		LoggerUtil.ibsJobDebug("Creating enrol customer wit code: "
				+ vo.getId());
		try {
			vo = super.create(vo);
			updateEnrichStat(vo.getId(), vo);
			return vo;
		} catch (DataAccessException e) {
			String message = "DataAccessException while creating enrolcustomer with code: "
					+ vo.getId();
			LoggerUtil.ibsJobError(message, e);
			throw new ServiceException(message, e);
		}

	}

	@Override
	public boolean updateEnrichStat(String customerCode,
			EnrollCustomerVO enrollCustomerVO) throws ServiceException {
		LoggerUtil.ibsJobDebug("starting updateEnrichStat for customer code: "
				+ customerCode);
		try {
			return enrollCustomerDao.updateEnrichStat(customerCode);
		} catch (DataAccessException e) {
			String message = "DataAccessException while doing updateEnrichStat for custome code: "
					+ customerCode;
			LoggerUtil.ibsJobError(message, e);
			throw new ServiceException(message, e);
		}
	}

	public DocumentDao getDocumentDao() {
		return documentDao;
	}

	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}
	
	
	public EnrollCustomerVO rejected(EnrollCustomerVO vo) throws ServiceException{
		LoggerUtil.ibsJobDebug("Calling abstart reject to reject the object id:"+vo.getId() +"Object type: "+vo.getClass().getName());
		//E entity = getEntity(vo);
		EnrollCustomer entity = getEntity(vo);
		entity.setChecker(getLoggedInUserId());
		entity.setCheckerTimestamp(new Date());
		try {
			getMaintenanceDao().rejected(entity);
			return vo;
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while authorizing the object id:"+vo.getId() +"Object type: "+vo.getClass().getName(), e);
		}
	}
	
	
	public EnrollCustomerVO getModifyRecord(String id) throws ServiceException {
		LoggerUtil.ibsJobDebug("Calling abstart get to getModifyRecord  object: "+this.getClass().getName() +" with id: "+id);
		try {
			EnrollCustomer entity = enrollCustomerDao.getModifyRecord(id);
			return getValueObject(entity);
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while getting  object: "+this.getClass().getName()+" with id: "+id, e);
		}
		
	}
	
	@Override
	public CustEnrolBiometricVO getBiomatric(String id)throws ServiceException{
		try {
			CustEnrolBiometric entityBio = enrollCustomerDao.getBiomatric(id);

			if(entityBio!=null)
			   return getValueObjectBiomatric(entityBio);
			else
		      return getValueObjectBiomatricDefault(entityBio);
		
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while getting  object: "+this.getClass().getName()+" with id: "+id, e);
		}
		
	}
	
	private ServletContext getServletContext() {
		return (ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext();
	}

	
	protected CustEnrolBiometricVO getValueObjectBiomatric(CustEnrolBiometric entity) {
		CustEnrolBiometricVO vo = new CustEnrolBiometricVO(entity);
		
		byte[] res = getDefaultImage();
		byte[] resRight = getRightImage();
			
		vo.setId(entity.getId());
		if(entity.getRhlfTepltdata()!=null && entity.getRhlfTepltdata().length>0){
			//vo.setRhlfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getRhlfTepltdata()), "image/png"));
			vo.setRhlfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setRhlfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
		//System.out.println("dEFAULT iMAGE LENGTHJ: "+res.length);
		
		if(entity.getRhrfTemltdata()!=null && entity.getRhrfTemltdata().length>0){
			//vo.setRhrfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getRhrfTemltdata()), "image/png"));
			vo.setRhrfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setRhrfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
		if(entity.getRhmfTemltdata()!=null && entity.getRhmfTemltdata().length>0){
			//vo.setRhmfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getRhmfTemltdata()), "image/png"));
			vo.setRhmfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setRhmfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
	  
		if(entity.getRhifTmpltdata()!=null && entity.getRhifTmpltdata().length>0){
			//vo.setRhifTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getRhifTmpltdata()), "image/png"));
			vo.setRhifTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setRhifTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
	    
		if(entity.getRhtfTmpltdata()!=null && entity.getRhtfTmpltdata().length>0){
			//vo.setRhtfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getRhtfTmpltdata()), "image/png"));
			vo.setRhtfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setRhtfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
	  
	    
		if(entity.getLhlfTmpldata()!=null && entity.getLhlfTmpldata().length>0){
			//vo.setLhlfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getLhlfTmpldata()), "image/png"));
			vo.setLhlfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setLhlfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
		
		if(entity.getLhrfTmpltdata()!=null && entity.getLhrfTmpltdata().length>0){
			//vo.setLhrfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getLhrfTmpltdata()), "image/png"));
			vo.setLhrfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setLhrfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
	   
		if(entity.getLhmfTmpltdata()!=null && entity.getLhmfTmpltdata().length>0){
			//vo.setLhmfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getLhmfTmpltdata()), "image/png"));
			vo.setLhmfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setLhmfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
	  
		if(entity.getLhifTmpltdata()!=null && entity.getLhifTmpltdata().length>0){
			//vo.setLhifTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getLhifTmpltdata()), "image/png"));
			vo.setLhifTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setLhifTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
	   
		if(entity.getLhtfTmpltdata()!=null && entity.getLhtfTmpltdata().length>0){
			//vo.setLhtfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getLhtfTmpltdata()), "image/png"));
			vo.setLhtfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setLhtfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
	  //----------------------
		if(entity.getRhlfImageScan()!=null && entity.getRhlfImageScan().length>0){
			//vo.setRhlfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getRhlfImageScan()), "image/png"));
			vo.setRhlfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setRhlfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
		
		if(entity.getRhrfImageScan()!=null && entity.getRhrfImageScan().length>0){
			//vo.setRhrfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getRhrfImageScan()), "image/png"));
			vo.setRhrfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setRhrfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
		
		if(entity.getRhmfImageScan()!=null && entity.getRhmfImageScan().length>0){
			//vo.setRhmfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getRhmfImageScan()), "image/png"));
			vo.setRhmfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setRhmfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
	   
		if(entity.getRhifImageScan()!=null && entity.getRhifImageScan().length>0){
			//vo.setRhifImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getRhifImageScan()), "image/png"));
			vo.setRhifImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setRhifImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
	 
		if(entity.getRhtfImageScan()!=null && entity.getRhtfImageScan().length>0){
			//vo.setRhtfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getRhtfImageScan()), "image/png"));
			vo.setRhtfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setRhtfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
	   
		if(entity.getLhlfImaageScan()!=null && entity.getLhlfImaageScan().length>0){
			//vo.setLhlfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getLhlfImaageScan()), "image/png"));
			vo.setLhlfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setLhlfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
	    
		if(entity.getLhrfImageScan()!=null && entity.getLhrfImageScan().length>0){
			//vo.setLhrfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getLhrfImageScan()), "image/png"));
			vo.setLhrfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setLhrfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
	  
		if(entity.getLhmfImageScan()!=null && entity.getLhmfImageScan().length>0){
			//vo.setLhmfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getLhmfImageScan()), "image/png"));
			 vo.setLhmfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setLhmfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
	   
		if(entity.getLhifImageScan()!=null && entity.getLhifImageScan().length>0){
			//vo.setLhifImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getLhifImageScan()), "image/png"));
			vo.setLhifImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setLhifImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
	   
		if(entity.getLhtfImageScan()!=null && entity.getLhtfImageScan().length>0){
			//vo.setLhtfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getLhtfImageScan()), "image/png"));
			vo.setLhtfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(resRight), "image/png"));
		} else {
			vo.setLhtfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
		}
		
	   // vo.setLhtfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(entity.getLhtfImageScan()), "image/png"));
	    
		return vo;	
		}
	
	
	
	protected CustEnrolBiometricVO getValueObjectBiomatricDefault(CustEnrolBiometric entity) {
		CustEnrolBiometricVO vo = new CustEnrolBiometricVO(entity);
		
		byte[] res = getDefaultImage();
			vo.setRhlfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setRhrfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setRhmfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setRhifTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setRhtfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
	
			vo.setLhlfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setLhrfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setLhmfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setLhifTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setLhtfTempltImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
	  
			vo.setRhlfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setRhrfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setRhmfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setRhifImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setRhtfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			
			vo.setLhlfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setLhrfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setLhmfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setLhifImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			vo.setLhtfImageScanImage(new DefaultStreamedContent(new ByteArrayInputStream(res), "image/png"));
			
		    return vo;	
		}
	
	
	

	private byte[] getDefaultImage() {
		ServletContext ctx = getServletContext();
		String pathToKey = ctx.getRealPath("/");
		//System.out.println("realpath:: "+pathToKey);
		 pathToKey = pathToKey.concat("resources\\images\\default_biomatric.png");
				//System.out.println("patth================"+pathToKey);
		 File file = new File(pathToKey);
		// FileInputStream fis = new FileInputStream(file);
		 ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        byte[] buf = new byte[1024];
	        try {
	        	FileInputStream fis = new FileInputStream(file);
	            for (int readNum; (readNum = fis.read(buf)) != -1;) {
	                //Writes to this byte array output stream
	                bos.write(buf, 0, readNum); 
	                //System.out.println("read " + readNum + " bytes,");
	            }
	        } catch (IOException ex) {
	        	ex.printStackTrace(); 
	        }
	 
	        byte[] res = bos.toByteArray();
		return res;
	}
	
	
	
	private byte[] getRightImage() {
		ServletContext ctx = getServletContext();
		String pathToKey = ctx.getRealPath("/");
		//System.out.println("realpath:: "+pathToKey);
		 pathToKey = pathToKey.concat("resources\\images\\right_biometric.png");
				//System.out.println("patth================"+pathToKey);
		 File file = new File(pathToKey);
		// FileInputStream fis = new FileInputStream(file);
		 ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        byte[] buf = new byte[1024];
	        try {
	        	FileInputStream fis = new FileInputStream(file);
	            for (int readNum; (readNum = fis.read(buf)) != -1;) {
	                //Writes to this byte array output stream
	                bos.write(buf, 0, readNum); 
	                //System.out.println("read " + readNum + " bytes,");
	            }
	        } catch (IOException ex) {
	        	ex.printStackTrace(); 
	        }
	 
	        byte[] res = bos.toByteArray();
		return res;
	}
	
	
	
	
	@Override
	public List<EnrollCustomerVO> getDatatList(String tempGroupId)throws ServiceException {
		LoggerUtil.ibsJobDebug("Inside getDatatList ");
		try {
			List<EnrollCustomer> customer = enrollCustomerDao.getDatatList(tempGroupId);
			if (customer != null) {
				List<EnrollCustomerVO> enrollCustomerVOs = new ArrayList<EnrollCustomerVO>(
						customer.size());
				for (EnrollCustomer lov : customer) {
					EnrollCustomerVO enrollCustomerVO = new EnrollCustomerVO(
							lov);
					enrollCustomerVOs.add(enrollCustomerVO);
				}
				return enrollCustomerVOs;
			}
			return new ArrayList<EnrollCustomerVO>();
		} catch (DataAccessException e) {
			String message = "DataAccessException while getDatatList";
			LoggerUtil.ibsJobError(message, e);
			throw new ServiceException(message, e);
		}	
	}
	
	/*Tag no : EGA-MN15-000018 Start*/
	@Override
	public String getValueKyc(String id, String listName) {
		
		String value = null;
		try{
			value= enrollCustomerDao.getValueKyc(id, listName);
		}catch (ServiceException e) {
			LoggerUtil.mbsJobError("ServiceException While in List Values Kyc : MFI10001",e);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("Unhandeled Exception While in List Values Kyc : MFI10001",e);
		}
		return value;
	}
	/*Tag no : EGA-MN15-000018 Start End*/
}
