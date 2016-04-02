package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.Location;
import com.bfsi.mfi.service.LocationService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.LocationVO;

/**
 * @author Bablu kumar
 *
 */
@ManagedBean(name = "locationListController")
@ViewScoped
public class LocationListController extends
		MaintenanceListController<LocationVO, Location> {
	@ManagedProperty(value = "#{locationService}")
	private LocationService locationService;

	@Override
	protected String getViewRecordUrl() {
		return "viewLocationDetail";
	}

	
	public LocationService getLocationService() {
		return locationService;
	}


	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}


	@Override
	protected MaintenanceService<LocationVO, Location> getMaintenanceService() {
		return locationService;
	}

}
