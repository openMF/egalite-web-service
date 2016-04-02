package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.RefCode;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.ReferenceCodeService;
import com.bfsi.mfi.vo.RefCodeVO;


/**
 * @author Bablu kumar
 *
 */
@ManagedBean(name = "referenceListController")
@ViewScoped
public class ReferenceCodeListController extends
		MaintenanceListController<RefCodeVO, RefCode> {
	@ManagedProperty(value = "#{refcodeService}")
	private ReferenceCodeService refcodeService;

	@Override
	protected String getViewRecordUrl() {
		return "viewRefCode";
	}

	
	public ReferenceCodeService getRefcodeService() {
		return refcodeService;
	}


	public void setRefcodeService(ReferenceCodeService refcodeService) {
		this.refcodeService = refcodeService;
	}


	@Override
	protected MaintenanceService<RefCodeVO, RefCode> getMaintenanceService() {
		return refcodeService;
	}
}