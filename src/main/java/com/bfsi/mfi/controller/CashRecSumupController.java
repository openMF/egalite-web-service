package com.bfsi.mfi.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.CashRecSumupView;
import com.bfsi.mfi.service.CashRecService;
import com.bfsi.mfi.service.ReadOnlyMaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.CashRecSumupViewVO;
import com.bfsi.mfi.vo.CashRecordDetailVO;

@ManagedBean(name = "cashRecSumupController")
@ViewScoped
public class CashRecSumupController extends ReadOnlyMaintenanceController<CashRecSumupViewVO, CashRecSumupView> {
	
	
	
	
	private List<CashRecordDetailVO> cashRecDetailList;
	
	@ManagedProperty(value = "#{cashRecService}")
	private CashRecService cashRecService;
	private String agentId;
	
	

	public List<CashRecordDetailVO> getCashRecDetailList() {
		return cashRecDetailList;
	}



	public void setCashRecDetailList(List<CashRecordDetailVO> cashRecDetailList) {
		this.cashRecDetailList = cashRecDetailList;
	}

	public CashRecService getCashRecService() {
		return cashRecService;
	}



	public void setCashRecService(CashRecService cashRecService) {
		this.cashRecService = cashRecService;
	}



	public String getAgentId() {
		return agentId;
	}



	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}



	@Override
	public CashRecSumupViewVO getMaintenanceVO() {
		
		return null;
	}
	
	

	@Override
	protected ReadOnlyMaintenanceService<CashRecSumupViewVO, CashRecSumupView> getReadOnlyMaintenanceService() {
		
		return cashRecService;
	}

	public void loadCashRecord(){
		
		try {
			setCashRecDetailList(cashRecService.getCashRecordDetail(agentId));
		} catch (Exception e) {
			LoggerUtil
			.ibsJobError(
					"Unhandled exception while loading loadCashRecord: MFI10001",
					e);
	MessageUtil.addMessage("MFI10001");
		}
	
		
		
		
	}

}
