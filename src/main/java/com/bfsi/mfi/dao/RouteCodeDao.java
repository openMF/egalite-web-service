package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.entity.Location;
import com.bfsi.mfi.entity.RouteCodes;
import com.bfsi.mfi.exception.ServiceException;

/**
 * ListValueDao
 * 
 * @author Bablu kumar
 * @param <ListValue>
 */

public interface RouteCodeDao extends MaintenanceDao<RouteCodes> {

	//List<Agency> getAgencyForAllocation();

	List<RouteCodes> getAuthorized();
	//String deleteAgency(String id) throws ServiceException; 
	public List<Agency> getcountryCodes();
	String deleteRoute(String id) throws ServiceException;
	
	String getAutoRouteCode() throws ServiceException;
	public List<CbsCodes> getCbsRouteCode();
	public List<Location> getlocationCodes();
	/*For Tag No: EGA-MN15-000002 Start*/
	public List<RouteCodes> getdistricts();
	public List<RouteCodes> getcitys();
	public List<RouteCodes> getstates();
	boolean isRouteCodeAvailable(String routeCode);
	/*For Tag No: EGA-MN15-000002 End*/
	


}
