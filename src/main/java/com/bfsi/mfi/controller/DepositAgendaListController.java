package com.bfsi.mfi.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.AgendaView;
import com.bfsi.mfi.service.AgendaDepositService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.AgendaViewVO;

/**
 * @author Nirmal kanna S
 *
 */
@ManagedBean(name = "depositAgendaListController")
@ViewScoped
public class DepositAgendaListController extends MaintenanceListController<AgendaViewVO, AgendaView>
		implements Serializable 	{

	private static final long serialVersionUID = -1376002694395713795L;
	
	@ManagedProperty(value = "#{agendaDepositService}")
	private AgendaDepositService agendaDepositService;
		@Override
	
	protected MaintenanceService<AgendaViewVO, AgendaView> getMaintenanceService() {
		return agendaDepositService;
	}

	public AgendaDepositService getAgendaDepositService() {
		return agendaDepositService;
	}

	public void setAgendaDepositService(AgendaDepositService agendaDepositService) {
		this.agendaDepositService = agendaDepositService;
	}

	@Override
	protected String getViewRecordUrl() {
		return "viewDepositAgenda";
	}
}