package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.Customer;


public interface CustomerDao extends ReadOnlyMaintenanceDao<Customer>  {
	List<Customer> getCustomersDetail(String agentId,String locCode,String batchSize,List<String> recvdIds);
	public void updateCustomerStatus(List<String> customerIdList,String status);
	//void readBlob(String customerId);
	
	
	List<Customer> getSearch(String customerId, String locationCode,String localBranchCode);
	
}

