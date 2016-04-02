package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.RouteCodes;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.CbsCodesVO;
import com.bfsi.mfi.vo.LocationVO;
import com.bfsi.mfi.vo.RouteCodesVO;

/**
 * @author arun
 * 
 */
public interface RouteCodeService extends MaintenanceService<RouteCodesVO, RouteCodes> {
	
	List<RouteCodesVO> getAuthorized();
	//String deleteAgency(String id) throws ServiceException; 
	List<AgencyVO> getcountryCodes();
	String deleteRoute(String id) throws ServiceException;
	String getAutoRouteCode() throws ServiceException;
	List<CbsCodesVO> getCbsRouteCode() throws ServiceException;
	List<LocationVO>getlocationCodes();
	/*For Tag No: EGA-MN15-000002 Start*/
	List<RouteCodesVO> getdistricts();
	List<RouteCodesVO> getcitys();
	List<RouteCodesVO> getstates();
	boolean isRouteCodeAvailable(String routeCode) throws ServiceException;
	/*For Tag No: EGA-MN15-000002 End*/
}
