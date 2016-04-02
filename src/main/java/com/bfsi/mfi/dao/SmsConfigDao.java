package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.SmsConfig;

public interface SmsConfigDao extends MaintenanceDao<SmsConfig>{


	public boolean isTxnCodeAvailable(String txnCode);
	List<SmsConfig> getAuthorized();
	String deleteSmsConfig(String id);
}
