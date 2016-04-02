package com.bfsi.mfi.service;

import java.io.IOException;
import java.util.List;

import com.bfsi.mfi.entity.EnrollCustomer;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.CustEnrolBiometricVO;
import com.bfsi.mfi.vo.EnrollCustomerVO;

public interface EnrollCustomerService extends MaintenanceService <EnrollCustomerVO, EnrollCustomer> {

	List<EnrollCustomerVO> getEnrollCustomerForAllocation();
	
	List<EnrollCustomerVO> getAuthorized();
	boolean isEnrollCustomerCodeAvailable(String customerCode) throws ServiceException;
	boolean updateEnrichStat(String customerCode, EnrollCustomerVO VO) throws ServiceException, IOException;
	
	
	EnrollCustomerVO rejected(EnrollCustomerVO vo) throws ServiceException;

	EnrollCustomerVO getModifyRecord(String id) throws ServiceException;

	CustEnrolBiometricVO getBiomatric(String id)throws ServiceException;

	List<EnrollCustomerVO> getDatatList(String tempGroupId)throws ServiceException;
	String getValueKyc(String id,String listName); //Tag no : EGA-MN15-000018
}
