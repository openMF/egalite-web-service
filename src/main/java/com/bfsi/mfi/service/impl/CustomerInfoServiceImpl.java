package com.bfsi.mfi.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.CustomerBiometricDao;
import com.bfsi.mfi.dao.CustomerInfoDao;
import com.bfsi.mfi.dao.DocumentDao;
import com.bfsi.mfi.dao.MaintenanceDao;
import com.bfsi.mfi.entity.CustomerEnrolServiceResponse;
import com.bfsi.mfi.entity.CustomerEnrolmentServiceRequest;
import com.bfsi.mfi.entity.CustomerInfo;
import com.bfsi.mfi.entity.Document;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CustomerInfoService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CustomerEnrolmentInfoVO;
import com.bfsi.mfi.vo.CustomerInfoVO;

@Service(value = "customerInfoService")
public class CustomerInfoServiceImpl extends
		MaintenanceServiceImpl<CustomerInfoVO, CustomerInfo> implements
		CustomerInfoService {
	@Autowired
	private CustomerInfoDao customerInfoDao;
	
	@Autowired
	private DocumentDao documentDao;
	
	@Autowired
	private CustomerBiometricDao customerBiometricDao;

	public DocumentDao getDocumentDao() {
		return documentDao;
	}

	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	public CustomerBiometricDao getCustomerBiometricDao() {
		return customerBiometricDao;
	}

	public void setCustomerBiometricDao(CustomerBiometricDao customerBiometricDao) {
		this.customerBiometricDao = customerBiometricDao;
	}

	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}

	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}

	@Override
	protected <T extends MaintenanceDao<CustomerInfo>> T getMaintenanceDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected CustomerInfo getEntity(CustomerInfoVO vo) {
		return vo.getEntity();
	}

	@Override
	protected CustomerInfoVO getValueObject(CustomerInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public CustomerEnrolServiceResponse submitCustomerInfo(List<CustomerInfoVO> customerInfoList)
			throws ServiceException {
		CustomerInfo customerInfo = null;
		List<Document> documentList = null;
		//List<String> enrollmentIdList = new ArrayList<String>();
		CustomerEnrolServiceResponse l_serRes=new CustomerEnrolServiceResponse();
		List<String> l_enrolConfirmIdList=new ArrayList<String>();

		for (CustomerInfoVO customerVO : customerInfoList) {
			customerInfo = getEntity(customerVO);
			try {
				getCustomerInfoDao().insertCustomerInfo(customerInfo);
				documentList = customerInfo.getDocuments();
				//enrollmentIdList.add(customerVO.getId());
				if (documentList != null) {
					for (int i = 0; i < documentList.size(); i++) {
						documentList.get(i).setId(customerVO.getId());
					}
					getDocumentDao().insertDocumentInfo(documentList);
				}
				l_enrolConfirmIdList.add(customerVO.getId());
				/*
				 * for (Document document : documentList) { documentTag =
				 * document.getDocumentTag().toString();
				 * getDocumentDao().insertDocumentInfo(customerVO.getId(),
				 * document.getDocumentId(), document.getDocumentName(),
				 * documentTag); }
				 */
			} catch (DataAccessException e) {
				String message = "Error while inserting Customer Information  with EnrollmentID :"
						+ customerVO.getId() + ". Error: " + e.getMessage();
				LoggerUtil.ibsJobError(message, e);
				//throw new ServiceException(message, e);
			}
			catch (Exception e) {
				String message = "Error while inserting Customer Information  with EnrollmentID :"
						+ customerVO.getId() + ". Error: " + e.getMessage();
				LoggerUtil.ibsJobError(message, e);
				throw new ServiceException(message, e);
			}
			/*try {
				if (!enrollmentIdList.isEmpty())
					getCustomerInfoDao().updateEnrollmentIdStatus(
							enrollmentIdList);
			} catch (DataAccessException e) {
				String message = "Error while updating EnrollmentID with Status as Received :"
						+ customerVO.getId() + ". Error: " + e.getMessage();
				logger.error(message, e);
				throw new ServiceException(message, e);
			}*/
		}
		l_serRes.setStatus(true);
		l_serRes.setRecvdIds(l_enrolConfirmIdList);
		return l_serRes;
	}

	@Override
	public void insertDocumentData(InputStream stream, String docName,
			String enrollmentId) throws ServiceException {
		byte[] data = null;
		try {
			data = getBytes(stream);
		} catch (IOException e) {
			String message = "Error while generating Byte array from InputStream  with EnrollmentID :"
					+ enrollmentId + ". Error: " + e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}
		try {
			getDocumentDao().updateCustomerDocumentData(data, docName,
					enrollmentId);
		} catch (DataAccessException e) {
			String message = "Error while updating Customer Document Data with EnrollmentID :"
					+ enrollmentId + ". Error: " + e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}
	}

	private static byte[] getBytes(InputStream is) throws IOException {

		int len;
		int size = 1024;
		byte[] buf;

		if (is instanceof ByteArrayInputStream) {
			size = is.available();
			buf = new byte[size];
			len = is.read(buf, 0, size);
		} else {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			buf = new byte[size];
			while ((len = is.read(buf, 0, size)) != -1)
				bos.write(buf, 0, len);
			buf = bos.toByteArray();
		}
		return buf;
	}

	@Override
	public Map<String, String> uploadCustomerEnrollStatus(List<String> idList,
			String syncsessionid) throws ServiceException {
		Map<String, String> receivedIdList = new HashMap<String, String>();
		Map<String, String> pendingIdList = new HashMap<String, String>();
		List<String> pendingList = new ArrayList<String>();
		String sessionId = null;
		for (String id : idList) {
			try {
				sessionId = getCustomerInfoDao().checkReceivedId(id);
			} catch (DataAccessException e) {
				String message = "Error while checking EnrollmentId with  status as RECEIVED:"
						+ ". Error: " + e.getMessage();
				logger.error(message, e);
				throw new ServiceException(message, e);
			}
			if (sessionId != null) {
				receivedIdList.put( id,sessionId);
			} else {
				pendingIdList.put(id, syncsessionid);
				pendingList.add(id);
			}
		}
		if (!pendingIdList.isEmpty()) {
			try {
				getCustomerInfoDao().deleteIdRecord(pendingList);
				for (int i = 0; i < pendingList.size(); i++) {
					getCustomerInfoDao().insertIdStatus(pendingList.get(i),
							syncsessionid);
				}

			} catch (DataAccessException e) {
				String message = "Error while updating EnrollmentId with status as Pending:"
						+ ". Error: " + e.getMessage();
				logger.error(message, e);
				throw new ServiceException(message, e);
			}
		}
		return receivedIdList;
	}

	@Override
	@Transactional
	public ServiceResponse uploadCustomerDetails(
			CustomerEnrolmentServiceRequest p_enrolReq) {
		try{
		for(CustomerEnrolmentInfoVO l_custVo:p_enrolReq.getCustEnrolVo()){
			//Added For Asomi Nirmal kanna S
			l_custVo.setWorkFlowQueType("A");
			l_custVo.setAuthStatus("A");
			
			getCustomerInfoDao().submitCustPersonalInfo(l_custVo.getEntity());
			getCustomerInfoDao().submitCustomerDocInfo(l_custVo.getDocument().getEntity());
			getCustomerBiometricDao().submitCustBiometricInfo(l_custVo.getBiometric().getEntity());
		}
		}
		catch(DataAccessException e){
			throw new ServiceException("Data Access exception while uploading enrolment details",e);
		}
		ServiceResponse l_res=new ServiceResponse();
		l_res.setStatus(true);
		return l_res;
	}
}
