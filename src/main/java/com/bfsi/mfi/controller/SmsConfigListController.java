package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.SmsConfig;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.SmsConfigService;
import com.bfsi.mfi.vo.SmsConfigVO;

@ManagedBean(name = "smsConfigListController")
@ViewScoped
public class SmsConfigListController extends
		MaintenanceListController<SmsConfigVO, SmsConfig> {


	@ManagedProperty(value = "#{smsConfigService}")
	private SmsConfigService smsConfigService;
	
	public SmsConfigService getSmsConfigService() {
		return smsConfigService;
	}
	public void setSmsConfigService(SmsConfigService smsConfigService) {
		this.smsConfigService = smsConfigService;
	}
	@Override
	protected String getViewRecordUrl() {
		return "viewSMSConfig";
	}
	@Override
	protected MaintenanceService<SmsConfigVO, SmsConfig> getMaintenanceService() {
		return smsConfigService;
	}
}
