package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.service.AgencyService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.AgencyVO;

@ManagedBean(name = "agencyListController")
@ViewScoped
public class AgencyListController extends
		MaintenanceListController<AgencyVO, Agency> {
	@ManagedProperty(value = "#{agencyService}")
	private AgencyService agencyService;

	@Override
	protected String getViewRecordUrl() {
		return "viewAgencyDetail";
	}

	public AgencyService getAgencyService() {
		return agencyService;
	}

	public void setAgencyService(AgencyService agencyService) {
		this.agencyService = agencyService;
	}

	@Override
	protected MaintenanceService<AgencyVO, Agency> getMaintenanceService() {
		return agencyService;
	}

}
