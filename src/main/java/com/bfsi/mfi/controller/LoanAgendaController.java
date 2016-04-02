package com.bfsi.mfi.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.AgendaView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.AgendaLoanService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgendaViewVO;


/**
 * @className : AgentController.java
 * @description : Controller class for agents Registration
 * @author : Nirmal kanna S
 */

@ManagedBean(name = "loanAgendaController")
@ViewScoped
public class LoanAgendaController extends MaintenanceController<AgendaViewVO, AgendaView>
			implements Serializable
	{
	private static final long serialVersionUID = -8144614324632010903L;
	@ManagedProperty(value = "#{agendaLoanService}")
	private AgendaLoanService agendaLoanService;
	
	private AgendaViewVO agenda = new AgendaViewVO();
	
	public void loadLoanAgenda() throws ServiceException {
		
		LoggerUtil.ibsJobDebug("Validation in loadAgent() method");
		//System.out.println("Id=" + agenda.getAgendaId());
		String id = agenda.getAgendaId();
		this.agenda = agendaLoanService.get(id);
	}

	public AgendaLoanService getLoanAgendaService() {
		return agendaLoanService;
	}


	public AgendaLoanService getAgendaLoanService() {
		return agendaLoanService;
	}

	public void setAgendaLoanService(AgendaLoanService agendaLoanService) {
		this.agendaLoanService = agendaLoanService;
	}

	public void setLoanAgendaService(AgendaLoanService loanAgendaService) {
		this.agendaLoanService = loanAgendaService;
	}

	public AgendaViewVO getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaViewVO agenda) {
		this.agenda = agenda;
	}

	@Override
	public AgendaViewVO getMaintenanceVO() {
		return (AgendaViewVO) agendaLoanService;
	}

	@Override
	protected MaintenanceService<AgendaViewVO, AgendaView> getMaintenanceService() {
		return getMaintenanceService();
	}
}