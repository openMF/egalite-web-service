package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.LocationDao;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.entity.Location;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LocationService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CbsCodesVO;
import com.bfsi.mfi.vo.LocationVO;

@Service(value = "locationService")
public class LocationServiceImpl extends
		MaintenanceServiceImpl<LocationVO, Location> implements LocationService {

	@Autowired
	private LocationDao locationDao;

	// Tag No: EGA-MN15-000003 for SU auto Update
	@Override
	public LocationVO update(LocationVO vo) throws ServiceException {
		vo.setAuthStatus("U");
		LocationVO locationVO = super.update(vo);
		if (isCurrentUserSuperAdmin()) {
			authorize(vo);
			LoggerUtil.ibsJobDebug("Calling authorize method for = " +vo.getId());
		}
		return locationVO;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected LocationDao getMaintenanceDao() {
		return locationDao;
	}

	protected Location getEntity(LocationVO vo) {
		return vo.getEntity();
	}

	@Override
	protected LocationVO getValueObject(Location entity) {
		LocationVO locationVO = new LocationVO(entity);
		return locationVO;
	}

	@Override
	public List<LocationVO> getAuthorized() {
		List<Location> location = locationDao.getAuthorized();
		if (location != null) {
			List<LocationVO> locationVOs = new ArrayList<LocationVO>(
					location.size());
			for (Location lov : location) {
				LocationVO agencyVO = new LocationVO();
				BeanUtils.copyProperties(lov, agencyVO);
				locationVOs.add(agencyVO);
			}
			return locationVOs;
		} else {
			return new ArrayList<LocationVO>();
		}
	}

	public List<LocationVO> getcountryCodes() {
		List<Location> location = locationDao.getcountryCodes();
		if (location != null) {
			List<LocationVO> locationVOs = new ArrayList<LocationVO>(
					location.size());
			for (Location lov : location) {
				LocationVO locationVO = new LocationVO();
				BeanUtils.copyProperties(lov, locationVO);
				locationVOs.add(locationVO);
			}
			return locationVOs;
		} else {
			return new ArrayList<LocationVO>();
		}
	}

	@Override
	public String getAutoLocationCode() throws ServiceException {
		String locationCodes;
		try {

			locationCodes = locationDao.getAutoLocationCode();
			return locationCodes;

		} catch (DataAccessException e) {
			throw new ServiceException(
					"Error while generating the Automatic agency Code: ", e);
		}
	}

	@Override
	public boolean isLocationStatustoInactive(String locationId)
			throws ServiceException {
		try {
			return locationDao.isLocationStatustoInactive(locationId);
		} catch (DataAccessException e) {
			throw new ServiceException(
					"Error while checking availability of Agency Status:", e);
		}
	}

	// For Delete Operation
	@Override
	public String deleteLocation(String id) throws ServiceException {
		String success;
		try {
			success = locationDao.deleteLocation(id);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while deleting Location: ", e);
		}
		return success;
	}

	// For Location Code
	public List<LocationVO> getlocationCodes() {
		List<Location> location = locationDao.getlocationCodes();
		if (location != null) {
			List<LocationVO> locationVOs = new ArrayList<LocationVO>(
					location.size());
			for (Location lov : location) {
				LocationVO locationVO = new LocationVO();
				BeanUtils.copyProperties(lov, locationVO);
				locationVOs.add(locationVO);
			}
			return locationVOs;
		} else {
			return new ArrayList<LocationVO>();
		}
	}

	// EGALITE-289 START
	@Override
	public List<LocationVO> getAgentlocationCodes() {
		List<Location> location = locationDao.getAgentlocationCodes();
		if (location != null) {
			List<LocationVO> locationVOs = new ArrayList<LocationVO>(
					location.size());
			for (Location lov : location) {
				LocationVO locationVO = new LocationVO();
				BeanUtils.copyProperties(lov, locationVO);
				locationVOs.add(locationVO);
			}
			return locationVOs;
		} else {
			return new ArrayList<LocationVO>();
		}
	}

	// EGALITE-289 END
	
	@Override
	public boolean isCbsLocCodeAvailable(String cbsLocCode) throws ServiceException {
		try {
			LoggerUtil.ibsJobDebug("validating  isCbsCoCodeAvailable for Agency = " + cbsLocCode);
			return locationDao.isCbsLocCodeAvailable(cbsLocCode);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while isCbsCoCodeAvailable for Agency for Agency =  "+cbsLocCode, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while isCbsCoCodeAvailable for Agency for Agency =  "+cbsLocCode, e);
        }

	}
	@Override
	public List<CbsCodesVO> getLocCbsCode() throws ServiceException {
		List<CbsCodes> cbsCodesList = locationDao.getLocCbsCode();
		if (cbsCodesList != null) {
			List<CbsCodesVO> cbsCodeVOList = new ArrayList<CbsCodesVO>(cbsCodesList.size());
			for (CbsCodes cbsCodes : cbsCodesList) {
				CbsCodesVO cbsCodeVO = new CbsCodesVO();
				BeanUtils.copyProperties(cbsCodes, cbsCodeVO);
				cbsCodeVOList.add(cbsCodeVO);
			}
			return cbsCodeVOList;
		} else {
			return new ArrayList<CbsCodesVO>();
		}
	}
	
	/*Tag No: EGA-MN15-000003 Start*/
	@Override
	public List<LocationVO> getdistricts() {
		List<Location> dist = locationDao.getdistricts();
		if (dist != null) {
			List<LocationVO> distVOs = new ArrayList<LocationVO>(dist.size());
			for (Location lov : dist) {
				LocationVO distVO = new LocationVO();
				BeanUtils.copyProperties(lov, distVO);
				distVOs.add(distVO);
			}
			return distVOs;
		} else {
			return new ArrayList<LocationVO>();
		}
	}
	
	@Override
	public List<LocationVO> getcitys() {
		List<Location> dist = locationDao.getcitys();
		if (dist != null) {
			List<LocationVO> cityVOs = new ArrayList<LocationVO>(dist.size());
			for (Location lov : dist) {
				LocationVO distVO = new LocationVO();
				BeanUtils.copyProperties(lov, distVO);
				cityVOs.add(distVO);
			}
			return cityVOs;
		} else {
			return new ArrayList<LocationVO>();
		}
	}
	
	@Override
	public List<LocationVO> getstates() {
		List<Location> dist = locationDao.getstates();
		if (dist != null) {
			List<LocationVO> stateVOs = new ArrayList<LocationVO>(dist.size());
			for (Location lov : dist) {
				LocationVO distVO = new LocationVO();
				BeanUtils.copyProperties(lov, distVO);
				stateVOs.add(distVO);
			}
			return stateVOs;
		} else {
			return new ArrayList<LocationVO>();
		}
	}
	
	@Override
	public boolean isLocationCodeAvailable(String locationCode) throws ServiceException {
		try {
			return locationDao.isLocationCodeAvailable(locationCode);
		} catch (DataAccessException e) {
			String message = "Error while checking availability of Location Code:"
					+ locationCode + ". Error: " + e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}
	}
	
	// For SU Authorise 
	private static final String SUPER_ADMIN_USER_NAME = "SU";
	
	@Override
	public LocationVO create(LocationVO location) throws ServiceException {
		
		location.setAuthStatus("U");
		super.create(location);
		
		// auto authorize role record if current user is super admin
		if (isCurrentUserSuperAdmin()) {
			authorize(location);
		}
		
		return location;
	}
	
	private boolean isCurrentUserSuperAdmin() {
		UserDetails details = getUserDetails();
		String loggedInUser = details.getUsername();
		return loggedInUser.equals(SUPER_ADMIN_USER_NAME);
	}

	/*Tag No: EGA-MN15-000003 Ends*/
}
