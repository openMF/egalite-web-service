package com.bfsi.mfi.dao;

import com.bfsi.mfi.entity.EnrollCustomer;


public interface EnrichEnrollCustomerDao extends MaintenanceDao<EnrollCustomer> {
	boolean modifyEnrichVals(String[] customerVals);
	boolean deleteEnrichedEnroll(String customerCode);
	boolean resetEnrichStat(String customerCode);
}
