package com.bfsi.mfi.service;

import com.bfsi.mfi.entity.EnrollCustomer;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.EnrollCustomerVO;

public interface EnrichEnrollCustomerService extends MaintenanceService <EnrollCustomerVO, EnrollCustomer> {
	//boolean updateEnrichStat(String customerCode) throws ServiceException;
	boolean modifyEnrichVals(String[] customerVals) throws ServiceException;
	boolean deleteEnrichedEnroll(String customerCode) throws ServiceException;
	boolean resetEnrichStat(String customerCode) throws ServiceException;

}
