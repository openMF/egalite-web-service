package com.bfsi.mfi.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.bfsi.mfi.entity.MaintenanceEntity;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ReadOnlyMaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.MaintenanceVO;

/**
 * @author arun
 * 
 * @param <V>
 * @param <E>
 */
@SuppressWarnings("rawtypes")
public abstract class ReadOnlyMaintenanceListController<V extends MaintenanceVO, E extends MaintenanceEntity>
		extends CommonListController<V> {
	@PostConstruct
	public void load() {
		LoggerUtil.ibsJobDebug("inside load: loading records for controller: " + this.getClass().getName());
		try {
			setRecords(getReadOnlyMaintenanceService().get());
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("Service exception while loading records for controller: " + this.getClass().getName() +" : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while loading records for controller: " + this.getClass().getName() +" : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
	}

	/**
	 * Listener to handle selection of a record in the table to open user record
	 * in read mode
	 * 
	 * @param event
	 */
	public void listSelect(SelectEvent event) {
		LoggerUtil.ibsJobDebug("inside load for controller: "+this.getClass().getName() +" id: "+ selectedRecord.getId());
		try{
		ConfigurableNavigationHandler nh = (ConfigurableNavigationHandler) FacesContext
				.getCurrentInstance().getApplication().getNavigationHandler();
		nh.performNavigation(getViewRecordUrl() + "?id="
				+ selectedRecord.getId() + "&faces-redirect=true");
		}
		catch (ServiceException e) {
			LoggerUtil.ibsJobError("Service exception while loading record for controller: "+this.getClass().getName() +" : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while loading record for controller: "+this.getClass().getName() +" : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
	}

	protected abstract ReadOnlyMaintenanceService<V, E> getReadOnlyMaintenanceService();

	protected String getViewRecordUrl() {
		return "view";
	}

}