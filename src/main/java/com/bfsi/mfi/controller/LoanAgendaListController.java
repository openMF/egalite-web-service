package com.bfsi.mfi.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.AgendaView;
import com.bfsi.mfi.service.AgendaLoanService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.AgendaViewVO;

/**
 * @author Nirmal kanna S
 *
 */
@ManagedBean(name = "loanAgendaListController")
@ViewScoped
public class LoanAgendaListController extends MaintenanceListController<AgendaViewVO, AgendaView>
		implements Serializable 	{

	private static final long serialVersionUID = -1376002694395713795L;
	
	@ManagedProperty(value = "#{agendaLoanService}")
	private AgendaLoanService agendaLoanService;
	
	public AgendaLoanService getAgendaLoanService() {
		return agendaLoanService;
	}

	public void setAgendaLoanService(AgendaLoanService agendaLoanService) {
		this.agendaLoanService = agendaLoanService;
	}

	@Override
	protected MaintenanceService<AgendaViewVO, AgendaView> getMaintenanceService() {
		return agendaLoanService;
	}

	@Override
	protected String getViewRecordUrl() {
		return "viewLoanAgenda";
	}
}