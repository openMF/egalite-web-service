package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.entity.LovBase;
import com.bfsi.mfi.service.LovBaseService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.LovBaseVO;


@ManagedBean(name = "lovBaseListController")
@ViewScoped
public class LovBaseListController extends
                      MaintenanceListController<LovBaseVO, LovBase>{
	
	@ManagedProperty(value = "#{lovBaseService}")
	private LovBaseService lovBaseService;
	
	@Override
	protected String getViewRecordUrl() {
		return "viewLovBase";
	}

	public LovBaseService getLovBaseService() {
		return lovBaseService;
	}

	public void setLovBaseService(LovBaseService lovBaseService) {
		this.lovBaseService = lovBaseService;
	}

	@Override
	protected MaintenanceService<LovBaseVO, LovBase> getMaintenanceService() {
		return lovBaseService;
	}
}
