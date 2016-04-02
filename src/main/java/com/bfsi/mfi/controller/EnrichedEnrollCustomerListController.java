package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.EnrollCustomer;
import com.bfsi.mfi.service.EnrichEnrollCustomerService;
import com.bfsi.mfi.vo.EnrollCustomerVO;

@ManagedBean(name = "enrichedEnrollCustomerListController")
@ViewScoped
public class EnrichedEnrollCustomerListController extends	MaintenanceListController <EnrollCustomerVO, EnrollCustomer> {

	@ManagedProperty(value = "#{enrichEnrollCustomerService}")
	private EnrichEnrollCustomerService enrichEnrollCustomerService;

//	private EnrollCustomerVO existing = new EnrollCustomerVO();
	private EnrollCustomerVO enrollCustomer = new EnrollCustomerVO();
	
	
	public EnrollCustomerVO getEnrollCustomer() {
		return enrollCustomer;
	}

	public void setEnrollCustomer(EnrollCustomerVO enrollCustomer) {
		this.enrollCustomer = enrollCustomer;
	}

	public EnrichEnrollCustomerService getEnrichEnrollCustomerService() {
		return enrichEnrollCustomerService;
	}

	public void setEnrichEnrollCustomerService(
			EnrichEnrollCustomerService enrichEnrollCustomerService) {
		this.enrichEnrollCustomerService = enrichEnrollCustomerService;
	}

	@Override
	protected String getViewRecordUrl() {
		return "viewEnrichedEnrollCustomerDetail";
	}
	
	
	@Override
	protected EnrichEnrollCustomerService getMaintenanceService() { 
		return enrichEnrollCustomerService;
	}
	
}
