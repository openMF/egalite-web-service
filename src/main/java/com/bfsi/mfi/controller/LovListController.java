package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.LovDetail;
import com.bfsi.mfi.service.LovDetailService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.LovVO;


@ManagedBean(name = "lovListController")
@ViewScoped
public class LovListController extends
                         MaintenanceListController<LovVO, LovDetail> {

	@ManagedProperty(value = "#{lovDetailService}")
	private LovDetailService lovDetailService;
	
	@Override
	protected String getViewRecordUrl() {
		return "viewAddLovTypeDetail"; //viewAddLovTypeDetail.xhtml
	}
	
	public LovDetailService getLovDetailService() {
		return lovDetailService;
	}

	public void setLovDetailService(LovDetailService lovDetailService) {
		this.lovDetailService = lovDetailService;
	}


	@Override
	protected MaintenanceService<LovVO, LovDetail> getMaintenanceService() {
		return lovDetailService;
	}
	

	
	
	
}
