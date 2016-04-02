package com.bfsi.mfi.service;

import com.bfsi.mfi.entity.SmsTemplate;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.SmsTemplateVO;

public interface SmsTemplateService extends
		MaintenanceService<SmsTemplateVO, SmsTemplate> {
	String getAutoTemplateId() ;

	SmsTemplateVO createInfo(SmsTemplateVO smstemplatevo);
	String deleteSmsTemplate(String id) throws ServiceException;
}
