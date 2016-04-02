package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.SmsTemplate;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.SmsTemplateService;
import com.bfsi.mfi.vo.SmsTemplateVO;

@ManagedBean(name = "smsTemplateListController")
@ViewScoped
public class SmsTemplateListController extends
		MaintenanceListController<SmsTemplateVO, SmsTemplate> {
	@ManagedProperty(value = "#{smsTemplateService}")
	private SmsTemplateService smsTemplateService;

	public SmsTemplateService getSmsTemplateService() {
		return smsTemplateService;
	}

	public void setSmsTemplateService(SmsTemplateService smsTemplateService) {
		this.smsTemplateService = smsTemplateService;
	}
	@Override
	protected String getViewRecordUrl() {
		return "viewSMSTemplate";
	}
	@Override
	protected MaintenanceService<SmsTemplateVO, SmsTemplate> getMaintenanceService() {
		return smsTemplateService;
	}
}
