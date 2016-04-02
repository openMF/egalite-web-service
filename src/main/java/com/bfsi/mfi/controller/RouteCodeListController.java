package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.entity.RouteCodes;
import com.bfsi.mfi.service.AgencyService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.RouteCodeService;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.RouteCodesVO;

@ManagedBean(name = "routeCodeListController")
@ViewScoped
public class RouteCodeListController extends
		MaintenanceListController<RouteCodesVO, RouteCodes> {
	@ManagedProperty(value = "#{routeCodeService}")
	private RouteCodeService routeCodeService;

	@Override
	protected String getViewRecordUrl() {
		return "viewRouteCodeDetail";
	}


	public RouteCodeService getRouteCodeService() {
		return routeCodeService;
	}


	public void setRouteCodeService(RouteCodeService routeCodeService) {
		this.routeCodeService = routeCodeService;
	}



	@Override
	protected MaintenanceService<RouteCodesVO, RouteCodes> getMaintenanceService() {
		return routeCodeService;
	}

}
