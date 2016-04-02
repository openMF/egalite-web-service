package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.RouteCodeDao;
import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.entity.Location;
import com.bfsi.mfi.entity.RouteCodes;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.RouteCodeService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.CbsCodesVO;
import com.bfsi.mfi.vo.LocationVO;
import com.bfsi.mfi.vo.RouteCodesVO;

@Service(value = "routeCodeService")
public class RouteCodeServiceImpl extends MaintenanceServiceImpl<RouteCodesVO, RouteCodes>
		implements RouteCodeService {

	@Autowired
	private RouteCodeDao routeCodeDao;

	// Tag No: EGA-MN15-000002 for SU auto Update
	
	@Override
	public RouteCodesVO update(RouteCodesVO vo) throws ServiceException {
		vo.setAuthStatus("U");
		RouteCodesVO routeVO = super.update(vo);
		if (isCurrentUserSuperAdmin()) {
			authorize(vo);
			LoggerUtil.ibsJobDebug("Calling authorize method for = " +vo.getId());
		}
		return routeVO;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected RouteCodeDao getMaintenanceDao() {
		return routeCodeDao;
	}

	protected RouteCodes getEntity(RouteCodesVO vo) {
		return vo.getEntity();
	}

	@Override
	protected RouteCodesVO getValueObject(RouteCodes entity) {
		RouteCodesVO routeCodesVO = new RouteCodesVO(entity);
		return routeCodesVO;
	}

	// For Delete Operation
	@Override
	public String deleteRoute(String id) throws ServiceException {
		String success;
		try {
			success= routeCodeDao.deleteRoute(id);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while deleting Route: ", e);
		}
		return success;
	}
	
	@Override
	public List<RouteCodesVO> getAuthorized() {
		List<RouteCodes> routeCodes = routeCodeDao.getAuthorized();
		if (routeCodes != null) {
			List<RouteCodesVO> routeCodesVOs = new ArrayList<RouteCodesVO>(routeCodes.size());
			for (RouteCodes lov : routeCodes) {
				RouteCodesVO routeCodesVO = new RouteCodesVO();
				BeanUtils.copyProperties(lov, routeCodesVO);
				routeCodesVOs.add(routeCodesVO);
			}
			return routeCodesVOs;
		} else {
			return new ArrayList<RouteCodesVO>();
		}
	}
	
	//BFSIMFI-263 Guru End
		@Override
		public List<AgencyVO> getcountryCodes() {
			List<Agency> agency = routeCodeDao.getcountryCodes();
			if (agency != null) {
				List<AgencyVO> agencyVOs = new ArrayList<AgencyVO>(agency.size());
				for (Agency lov : agency) {
					AgencyVO agencyVO = new AgencyVO();
					BeanUtils.copyProperties(lov, agencyVO);
					agencyVOs.add(agencyVO);
				}
				return agencyVOs;
			} else {
				return new ArrayList<AgencyVO>();
			}
		}
	/* EGALITE-38 start*/
		
		@Override
		public String getAutoRouteCode() throws ServiceException {

			String routeCode;
			try {
				routeCode = routeCodeDao.getAutoRouteCode();
				LoggerUtil.ibsJobDebug("Calling DAO for getAutoRouteCode" );
				return routeCode;
			} catch (DataAccessException e) {
	            throw new ServiceException("DataAccessException while validating getAutoRouteCode for RouteCode: " + e);
	        } catch (Exception e) {
	            throw new ServiceException("Unhandled exception while validating getAutoRouteCode for RouteCode: " + e);
	        }
		}
		
	/* EGALITE-38 end*/	
		@Override
		public List<CbsCodesVO> getCbsRouteCode() throws ServiceException {
			List<CbsCodes> cbsCodesList = routeCodeDao.getCbsRouteCode();
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
		@Override
		public List<LocationVO> getlocationCodes() {
			List<Location> location = routeCodeDao.getlocationCodes();
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
		/*Tag No: EGA-MN15-000002 Start*/
		@Override
		public List<RouteCodesVO> getdistricts() {
			List<RouteCodes> dist = routeCodeDao.getdistricts();
			if (dist != null) {
				List<RouteCodesVO> distVOs = new ArrayList<RouteCodesVO>(dist.size());
				for (RouteCodes lov : dist) {
					RouteCodesVO distVO = new RouteCodesVO();
					BeanUtils.copyProperties(lov, distVO);
					distVOs.add(distVO);
				}
				return distVOs;
			} else {
				return new ArrayList<RouteCodesVO>();
			}
		}
		
		@Override
		public List<RouteCodesVO> getcitys() {
			List<RouteCodes> dist = routeCodeDao.getcitys();
			if (dist != null) {
				List<RouteCodesVO> cityVOs = new ArrayList<RouteCodesVO>(dist.size());
				for (RouteCodes lov : dist) {
					RouteCodesVO distVO = new RouteCodesVO();
					BeanUtils.copyProperties(lov, distVO);
					cityVOs.add(distVO);
				}
				return cityVOs;
			} else {
				return new ArrayList<RouteCodesVO>();
			}
		}
		
		@Override
		public List<RouteCodesVO> getstates() {
			List<RouteCodes> dist = routeCodeDao.getstates();
			if (dist != null) {
				List<RouteCodesVO> stateVOs = new ArrayList<RouteCodesVO>(dist.size());
				for (RouteCodes lov : dist) {
					RouteCodesVO distVO = new RouteCodesVO();
					BeanUtils.copyProperties(lov, distVO);
					stateVOs.add(distVO);
				}
				return stateVOs;
			} else {
				return new ArrayList<RouteCodesVO>();
			}
		}
		
		@Override
		public boolean isRouteCodeAvailable(String routeCode) throws ServiceException {
			try {
				return routeCodeDao.isRouteCodeAvailable(routeCode);
			} catch (DataAccessException e) {
				String message = "Error while checking availability of Route Code:"
						+ routeCode + ". Error: " + e.getMessage();
				logger.error(message, e);
				throw new ServiceException(message, e);
			}
		}
		
		// For SU Authorise 
		
		private static final String SUPER_ADMIN_USER_NAME = "SU";
		@Override
		public RouteCodesVO create(RouteCodesVO routeCode) throws ServiceException {
			
			routeCode.setAuthStatus("U");

			super.create(routeCode);
			// auto authorize role record if current user is super admin
					if (isCurrentUserSuperAdmin()) {
						authorize(routeCode);
					}
			return routeCode;
		}
		
		private boolean isCurrentUserSuperAdmin() {
			UserDetails details = getUserDetails();
			String loggedInUser = details.getUsername();
			return loggedInUser.equals(SUPER_ADMIN_USER_NAME);
		}
		
		/*Tag No: EGA-MN15-000002 Ends*/
}
