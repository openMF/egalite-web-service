package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.ErrorCode;
import com.bfsi.mfi.service.ErrorCodeService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.ErrorCodeVO;

@ManagedBean(name = "errorCodeListController")
@ViewScoped
public class ErrorCodeListController  extends MaintenanceListController<ErrorCodeVO, ErrorCode>{
	
	@ManagedProperty(value = "#{errorCodeService}")
	private ErrorCodeService errorCodeService;
		
	
	
	public ErrorCodeService getErrorCodeService() {
		return errorCodeService;
	}


	public void setErrorCodeService(ErrorCodeService errorCodeService) {
		this.errorCodeService = errorCodeService;
	}


	@Override
	protected MaintenanceService<ErrorCodeVO, ErrorCode> getMaintenanceService() {
		// TODO Auto-generated method stub
		return errorCodeService;
	}

}
