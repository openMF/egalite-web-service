package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.CenterCodes;
import com.bfsi.mfi.service.CenterCodeService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.CenterCodesVO;

@ManagedBean(name = "centerCodeListController")
@ViewScoped
public class CenterCodeListController extends
		MaintenanceListController<CenterCodesVO, CenterCodes> {
	@ManagedProperty(value = "#{centerCodeService}")
	private CenterCodeService centerCodeService;

	@Override
	protected String getViewRecordUrl() {
		return "viewCenterCodeDetail";
	}

	public CenterCodeService getCenterCodeService() {
		return centerCodeService;
	}

	public void setCenterCodeService(CenterCodeService centerCodeService) {
		this.centerCodeService = centerCodeService;
	}

	@Override
	protected MaintenanceService<CenterCodesVO, CenterCodes> getMaintenanceService() {
		return centerCodeService;
	}

}
