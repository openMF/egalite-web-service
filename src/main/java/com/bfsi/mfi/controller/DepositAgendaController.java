package com.bfsi.mfi.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.AgendaView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.AgendaDepositService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgendaViewVO;


/**
 * @className : AgentController.java
 * @description : Controller class for agents Registration
 * @author : Nirmal kanna S
 */

@ManagedBean(name = "depositAgendaController")
@ViewScoped
public class DepositAgendaController extends MaintenanceController<AgendaViewVO, AgendaView>
			implements Serializable
	{
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	private static final long serialVersionUID = -8144614324632010903L;	
	
	@ManagedProperty(value = "#{agendaDepositService}")
	private AgendaDepositService agendaDepositService;
	
	private AgendaViewVO agenda = new AgendaViewVO();
	
	public void loadDepositAgenda() throws ServiceException {
		
		LoggerUtil.ibsJobDebug("Validation in loadAgent() method");
		//System.out.println("Id=" + agenda.getAgendaId());
		String id = agenda.getAgendaId();
		this.agenda = agendaDepositService.get(id);
	}

		@Override
	public AgendaViewVO getMaintenanceVO() {
		return (AgendaViewVO) agendaDepositService;
	}

	@Override
	protected MaintenanceService<AgendaViewVO, AgendaView> getMaintenanceService() {
		return getMaintenanceService();
	}

	public AgendaDepositService getAgendaDepositService() {
		return agendaDepositService;
	}

	public void setAgendaDepositService(AgendaDepositService agendaDepositService) {
		this.agendaDepositService = agendaDepositService;
	}

	public AgendaViewVO getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaViewVO agenda) {
		this.agenda = agenda;
	}
	
	
}