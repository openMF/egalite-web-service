package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.EnrollCustomer;
import com.bfsi.mfi.service.EnrollCustomerService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.EnrollCustomerVO;

@ManagedBean(name = "enrollCustomerListController")
@ViewScoped
public class EnrollCustomerListController extends MaintenanceListController <EnrollCustomerVO, EnrollCustomer> {

	@ManagedProperty(value = "#{enrollCustomerService}")
	private EnrollCustomerService enrollCustomerService;
	
	
	public EnrollCustomerService getEnrollCustomerService() {
		return enrollCustomerService;
	}


	public void setEnrollCustomerService(EnrollCustomerService enrollCustomerService) {
		this.enrollCustomerService = enrollCustomerService;
	}

	@Override
	protected String getViewRecordUrl() {
		return "viewEnrollCustomerDetail";
	}
	
	
	@Override
	protected MaintenanceService<EnrollCustomerVO, EnrollCustomer> getMaintenanceService() {
		return enrollCustomerService;
	}

}
