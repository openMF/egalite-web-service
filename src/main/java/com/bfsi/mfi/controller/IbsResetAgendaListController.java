package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.IbsResetAgenda;
import com.bfsi.mfi.service.IbsResetAgendaService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.IbsResetAgendaVO;

@ManagedBean(name = "ibsResetAgendaListController")
@ViewScoped
public class IbsResetAgendaListController extends
                        MaintenanceListController<IbsResetAgendaVO, IbsResetAgenda>{
	
	@ManagedProperty(value = "#{ibsResetAgendaService}")
	private IbsResetAgendaService ibsResetAgendaService;
	
	@Override
	protected String getViewRecordUrl() {
		return "viewIbsResetAgenda"; 
	}
	
	@Override
	protected MaintenanceService<IbsResetAgendaVO, IbsResetAgenda> getMaintenanceService() {
		return ibsResetAgendaService;
	}

	public IbsResetAgendaService getIbsResetAgendaService() {
		return ibsResetAgendaService;
	}

	public void setIbsResetAgendaService(IbsResetAgendaService ibsResetAgendaService) {
		this.ibsResetAgendaService = ibsResetAgendaService;
	}
	
	

}
