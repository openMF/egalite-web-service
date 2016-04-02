package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.PigmyDeposit;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.PigmyDepositService;
import com.bfsi.mfi.vo.PigmyDepositVO;

@ManagedBean(name = "pigmyDepositListContoller")
@ViewScoped
public class PigmyDepositListContoller extends
		MaintenanceListController<PigmyDepositVO, PigmyDeposit> {
	
	@ManagedProperty(value = "#{pigmyDepositService}")
	private PigmyDepositService pigmyDepositService;
	
	@Override 
	protected String getViewRecordUrl() {
		return "viewpigmyDepositAccount";
	}
	
	public PigmyDepositService getPigmyDepositService() {
		return pigmyDepositService;
	}

	public void setPigmyDepositService(PigmyDepositService pigmyDepositService) {
		this.pigmyDepositService = pigmyDepositService;
	}
	
	@Override
	protected MaintenanceService<PigmyDepositVO, PigmyDeposit> getMaintenanceService() {
		return  pigmyDepositService;
	}

}