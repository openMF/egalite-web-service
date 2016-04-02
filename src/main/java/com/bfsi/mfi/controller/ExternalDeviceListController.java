package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.ExternalDevice;
import com.bfsi.mfi.service.ExternalDeviceService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.ExternalDeviceVO;

@ManagedBean(name = "externalDeviceListController")
@ViewScoped
public class ExternalDeviceListController extends
		                        MaintenanceListController<ExternalDeviceVO, ExternalDevice> {
	
	
	@ManagedProperty(value = "#{externalDeviceService}")
	private ExternalDeviceService externalDeviceService;

	public ExternalDeviceService getExternalDeviceService() {
		return externalDeviceService;
	}

	public void setExternalDeviceService(ExternalDeviceService externalDeviceService) {
		this.externalDeviceService = externalDeviceService;
	}

	@Override
	protected MaintenanceService<ExternalDeviceVO, ExternalDevice> getMaintenanceService() {
		return externalDeviceService;
	}

	@Override
	protected String getViewRecordUrl() {
		return "viewExternalDevice"; //viewExternalDevice.xhtml
	}
}