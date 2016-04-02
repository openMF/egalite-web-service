package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.SmsTemplateDao;
import com.bfsi.mfi.entity.SmsTemplate;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.SmsTemplateService;
import com.bfsi.mfi.vo.SmsTemplateVO;

@Service(value = "smsTemplateService")
public class SmsTemplateServiceImpl extends
		MaintenanceServiceImpl<SmsTemplateVO, SmsTemplate> implements
		SmsTemplateService {
	@Autowired
	private SmsTemplateDao  smsTemplateDao ;
	
	@SuppressWarnings("unchecked")
	@Override
	protected SmsTemplateDao getMaintenanceDao() {
		return smsTemplateDao;
	}

	@Override
	protected SmsTemplate getEntity(SmsTemplateVO vo) {
		return vo.getEntity();
	}

	@Override
	protected SmsTemplateVO getValueObject(SmsTemplate entity) {
		SmsTemplateVO smsTemplateVO = new SmsTemplateVO(entity);
		return smsTemplateVO;
	}
	
	@Override
	public String getAutoTemplateId() {
		String smsTempId = smsTemplateDao.getAutoTemplateId();
		return smsTempId;
	}
	
	
	@Override
	public SmsTemplateVO createInfo(SmsTemplateVO smstemplatevo){
		
		return super.create(smstemplatevo);
	}
	// For Delete Operation
	@Override
	public String deleteSmsTemplate(String id) throws ServiceException {
		String success;
		try {
			success = smsTemplateDao.deleteSmsTemplate(id);
		} catch (DataAccessException e) {
			throw new ServiceException(
					"Error while deleting Sms Config details: ", e);
		}
		return success;
	}

}
