package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.Location;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.CbsCodesVO;
import com.bfsi.mfi.vo.LocationVO;

/**
 * @author arun
 * 
 */
public interface LocationService extends
		MaintenanceService<LocationVO, Location> {

	List<LocationVO> getcountryCodes();

	List<LocationVO> getlocationCodes();

	String getAutoLocationCode() throws ServiceException;

	boolean isLocationStatustoInactive(String locationId)
			throws ServiceException;

	String deleteLocation(String id) throws ServiceException;

	List<LocationVO> getAuthorized();

	List<LocationVO> getAgentlocationCodes() throws ServiceException;

	boolean isCbsLocCodeAvailable(String cbsLocCode) throws ServiceException;

	List<CbsCodesVO> getLocCbsCode() throws ServiceException;

	/* For Tag No: EGA-MN15-000003 Start */
	List<LocationVO> getdistricts();

	List<LocationVO> getcitys();

	List<LocationVO> getstates();

	boolean isLocationCodeAvailable(String locationCode)
			throws ServiceException;
	/* For Tag No: EGA-MN15-000003 End */
	
}
