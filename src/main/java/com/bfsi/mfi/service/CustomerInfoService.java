package com.bfsi.mfi.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.bfsi.mfi.entity.CustomerEnrolServiceResponse;
import com.bfsi.mfi.entity.CustomerEnrolmentServiceRequest;
import com.bfsi.mfi.entity.CustomerInfo;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.CustomerInfoVO;

public interface CustomerInfoService extends
		MaintenanceService<CustomerInfoVO, CustomerInfo> {

	public CustomerEnrolServiceResponse submitCustomerInfo(List<CustomerInfoVO> customerInfoList)
			throws ServiceException;

	public void insertDocumentData(InputStream stream, String docName,
			String enrollmentId) throws ServiceException;

	public Map<String, String> uploadCustomerEnrollStatus(List<String> idList,
			String syncsessionid) throws ServiceException;
	
	public ServiceResponse uploadCustomerDetails(CustomerEnrolmentServiceRequest p_enrolReq);

}
