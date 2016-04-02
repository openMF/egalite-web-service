package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.Device;
import com.bfsi.mfi.service.DeviceService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.DeviceVO;

@ManagedBean(name = "deviceListController")
@ViewScoped
public class DeviceListController extends
		MaintenanceListController<DeviceVO, Device> {
	@ManagedProperty(value = "#{deviceService}")
	private DeviceService deviceService;

	public DeviceService getDeviceService() {
		return deviceService;
	}

	public DeviceService getdDeviceService() {
		return deviceService;
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	@Override
	protected MaintenanceService<DeviceVO, Device> getMaintenanceService() {
		return deviceService;
	}

	@Override
	protected String getViewRecordUrl() {
		return "viewDevice";
	}
}