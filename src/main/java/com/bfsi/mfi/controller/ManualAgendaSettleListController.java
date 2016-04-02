package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.ManualAgendaSettle;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.ManualAgendaSettleService;
import com.bfsi.mfi.vo.ManualAgendaSettleVO;


@ManagedBean(name = "manualAgendaSettleListController")
@ViewScoped
public class ManualAgendaSettleListController extends  MaintenanceListController<ManualAgendaSettleVO, ManualAgendaSettle>{
      
	@ManagedProperty(value = "#{manualAgendaSettleService}")
	private ManualAgendaSettleService manualAgendaSettleService;

	@Override
	protected String getViewRecordUrl() {
		return "viewManualAgendaSettle"; 
	}
	
	@Override
	protected MaintenanceService<ManualAgendaSettleVO, ManualAgendaSettle> getMaintenanceService() {
		return manualAgendaSettleService;
	}

	public ManualAgendaSettleService getManualAgendaSettleService() {
		return manualAgendaSettleService;
	}

	public void setManualAgendaSettleService(
			ManualAgendaSettleService manualAgendaSettleService) {
		this.manualAgendaSettleService = manualAgendaSettleService;
	}
	
	/*@Override
	public void listSelect(SelectEvent event) {
		LoggerUtil.ibsJobDebug("inside load for controller: "+this.getClass().getName() +" agendaId: "+ selectedRecord.getAgendaId());
		try{
		ConfigurableNavigationHandler nh = (ConfigurableNavigationHandler) FacesContext
				.getCurrentInstance().getApplication().getNavigationHandler();
		nh.performNavigation(getViewRecordUrl() + "?agendaId="
				+ selectedRecord.getAgendaId() + "&faces-redirect=true");
		}
		catch (ServiceException e) {
			LoggerUtil.ibsJobError("Service exception while loading record for controller: "+this.getClass().getName() +" : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while loading record for controller: "+this.getClass().getName() +" : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
	}*/
	
}
