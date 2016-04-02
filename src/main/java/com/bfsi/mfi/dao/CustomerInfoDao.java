package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.CustomerDocumentInfo;
import com.bfsi.mfi.entity.CustomerEnrolmentInfo;
import com.bfsi.mfi.entity.CustomerInfo;

public interface CustomerInfoDao extends MaintenanceDao<CustomerInfo> {

	void insertCustomerInfo(CustomerInfo customerInfo);

	String checkReceivedId(String id);

	void deleteIdRecord(List<String> pendingIdList);

	void insertIdStatus(String id, String syncsessionid);

	void updateEnrollmentIdStatus(List<String> enrollmentIdList);

	void submitCustPersonalInfo(CustomerEnrolmentInfo p_custInfo);

	void submitCustomerDocInfo(CustomerDocumentInfo p_custDocInfo);

}
