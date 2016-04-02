package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.entity.Location;
import com.bfsi.mfi.entity.RouteCodes;
import com.bfsi.mfi.exception.ServiceException;

/**
 * LocationDao
 * 
 * @author Bablu kumar
 * @param <ListValue>
 */

public interface LocationDao extends MaintenanceDao<Location> {

	public List<Location> getcountryCodes();

	public List<Location> getlocationCodes();

	String getAutoLocationCode();

	boolean isLocationStatustoInactive(String locationId);

	String deleteLocation(String id) throws ServiceException;

	List<Location> getAuthorized();

	public List<Location> getAgentlocationCodes();

	boolean isCbsLocCodeAvailable(String cbsLocCode);

	public List<CbsCodes> getLocCbsCode();

	/* For Tag No: EGA-MN15-000003 Start */
	public List<Location> getdistricts();

	public List<Location> getcitys();

	public List<Location> getstates();

	boolean isLocationCodeAvailable(String locationCode);

	/* For Tag No: EGA-MN15-000003 End */

}
