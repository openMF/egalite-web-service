package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.Customer;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.CustomerVO;

public interface CustomerService extends ReadOnlyMaintenanceService<CustomerVO, Customer>{

	List<CustomerVO> getCustomers(String agentId,String locCode,String batchSize,List<String> recvdIds) throws ServiceException;

	Boolean updateCustomerStatus(List<String> customerIdList) throws ServiceException;

	
	List<CustomerVO> getSearch(String customerId, String locationCode, String localBranchCode) throws ServiceException;
	
	//void readBlobAsStream()
}


