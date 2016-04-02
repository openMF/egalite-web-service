package com.bfsi.mfi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bfsi.mfi.entity.MaintenanceEntity;
import com.bfsi.mfi.service.ReadOnlyMaintenanceService;
import com.bfsi.mfi.vo.MaintenanceVO;

@SuppressWarnings("rawtypes")
public abstract class ReadOnlyMaintenanceController<V extends MaintenanceVO, E extends MaintenanceEntity> {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public abstract V getMaintenanceVO();

	protected abstract ReadOnlyMaintenanceService<V, E> getReadOnlyMaintenanceService();

	/**
	 * Used when we need to display message to user about a record. This should
	 * return the id / name of the record in context. By default it returns id.
	 * Override this method if you want to display name
	 * 
	 * @return
	 */
	protected String getIdForMessage() {
		return getMaintenanceVO().getId();
	}

}
