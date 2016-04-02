package com.bfsi.mfi.controller;

import com.bfsi.mfi.entity.MaintenanceEntity;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.ReadOnlyMaintenanceService;
import com.bfsi.mfi.vo.MaintenanceVO;

/**
 * @author arun
 * 
 * @param <V>
 * @param <E>
 */
@SuppressWarnings("rawtypes")
public abstract class MaintenanceListController<V extends MaintenanceVO, E extends MaintenanceEntity>
		extends ReadOnlyMaintenanceListController<V, E> {
	
	protected ReadOnlyMaintenanceService<V, E> getReadOnlyMaintenanceService() {
		return getMaintenanceService();
	}

	protected abstract MaintenanceService<V, E> getMaintenanceService();

	protected String getViewRecordUrl() {
		return "view";
	}

}