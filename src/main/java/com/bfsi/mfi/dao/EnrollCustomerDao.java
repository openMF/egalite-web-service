package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.CustEnrolBiometric;
import com.bfsi.mfi.entity.EnrollCustomer;

public interface EnrollCustomerDao extends MaintenanceDao<EnrollCustomer> {
	List<EnrollCustomer> getEnrollCustomerForAllocation();

	List<EnrollCustomer> getAuthorized();

	boolean isEnrollCustomerCodeAvailable(String enrollCustomerCode);

	boolean updateEnrichStat(String customerCode);
	
	EnrollCustomer rejected(EnrollCustomer entity);

	EnrollCustomer getModifyRecord(String id);

	CustEnrolBiometric getBiomatric(String id);

	List<EnrollCustomer> getDatatList(String tempGroupId);
	public String getValueKyc(String id,String listName);// Tag no : EGA-MN15-000018

	

}
