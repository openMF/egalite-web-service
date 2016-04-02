package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.ModifyManualAgendaSettle;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.ModifyManualAgendaSettleService;
import com.bfsi.mfi.vo.ModifyManualAgendaSettleVO;


@ManagedBean(name = "modifyManualAgendaSettleListController")
@ViewScoped
public class ModifyManualAgendaSettleListController extends  MaintenanceListController<ModifyManualAgendaSettleVO, ModifyManualAgendaSettle>{
      
	@ManagedProperty(value = "#{modifyManualAgendaSettleService}")
	private ModifyManualAgendaSettleService modifyManualAgendaSettleService;

	@Override
	protected String getViewRecordUrl() {
		return "viewModifyManualAgendaSettle"; 
	}
	
	@Override
	protected MaintenanceService<ModifyManualAgendaSettleVO, ModifyManualAgendaSettle> getMaintenanceService() {
		return modifyManualAgendaSettleService;
	}

	public ModifyManualAgendaSettleService getModifyManualAgendaSettleService() {
		return modifyManualAgendaSettleService;
	}

	public void setModifyManualAgendaSettleService(
			ModifyManualAgendaSettleService modifyManualAgendaSettleService) {
		this.modifyManualAgendaSettleService = modifyManualAgendaSettleService;
	}

	
	
	
	
}
