package com.bfsi.mfi.dao;

import com.bfsi.mfi.entity.SmsTemplate;

public interface SmsTemplateDao extends MaintenanceDao<SmsTemplate>{
	String getAutoTemplateId();
	String deleteSmsTemplate(String id);
}
