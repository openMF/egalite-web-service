package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.CenterCodeDao;
import com.bfsi.mfi.dao.MaintenanceDao;
import com.bfsi.mfi.dao.RouteCodeDao;
import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.entity.CenterCodes;
import com.bfsi.mfi.entity.Location;
import com.bfsi.mfi.entity.RouteCodes;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CenterCodeService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.CbsCodesVO;
import com.bfsi.mfi.vo.CenterCodesVO;
import com.bfsi.mfi.vo.LocationVO;
import com.bfsi.mfi.vo.RouteCodesVO;

@Service(value = "centerCodeService")
public class CenterCodeServiceImpl extends
		MaintenanceServiceImpl<CenterCodesVO, CenterCodes> implements
		CenterCodeService {

	@Autowired
	private CenterCodeDao centerCodeDao;

	// Tag No: EGA-MN15-000004 for SU auto Update

	@Override
	public CenterCodesVO update(CenterCodesVO vo) throws ServiceException {
		vo.setAuthStatus("U");
		CenterCodesVO centerVO = super.update(vo);
		if (isCurrentUserSuperAdmin()) {
			authorize(vo);
			LoggerUtil.ibsJobDebug("Calling authorize method for = "
					+ vo.getId());
		}
		return centerVO;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected CenterCodeDao getMaintenanceDao() {
		return centerCodeDao;
	}

	protected CenterCodes getEntity(CenterCodesVO vo) {
		return vo.getEntity();
	}

	@Override
	protected CenterCodesVO getValueObject(CenterCodes entity) {
		CenterCodesVO centerCodesVO = new CenterCodesVO(entity);
		return centerCodesVO;
	}

	// For Delete Operation
	@Override
	public String deleteCenter(String id) throws ServiceException {
		String success;
		try {
			success = centerCodeDao.deleteCenter(id);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while deleting Route: ", e);
		}
		return success;
	}

	@Override
	public List<CenterCodesVO> getAuthorized() {
		List<CenterCodes> centerCodes = centerCodeDao.getAuthorized();
		if (centerCodes != null) {
			List<CenterCodesVO> centerCodesVOs = new ArrayList<CenterCodesVO>(
					centerCodes.size());
			for (CenterCodes lov : centerCodes) {
				CenterCodesVO centerCodesVO = new CenterCodesVO();
				BeanUtils.copyProperties(lov, centerCodesVO);
				centerCodesVOs.add(centerCodesVO);
			}
			return centerCodesVOs;
		} else {
			return new ArrayList<CenterCodesVO>();
		}
	}

	// BFSIMFI-263 Guru End
	@Override
	public List<AgencyVO> getcountryCodes() {
		List<Agency> agency = centerCodeDao.getcountryCodes();
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

	/* EGALITE-45 start */
	@Override
	public String getAutoCenterCode() throws ServiceException {
		String routeCode;
		try {
			routeCode = centerCodeDao.getAutoCenterCode();
			LoggerUtil.ibsJobDebug("Calling DAO for getAutoCenterCode");
			return routeCode;
		} catch (DataAccessException e) {
			throw new ServiceException(
					"DataAccessException while validating getAutoCenterCode for CenterCode: "
							+ e);
		} catch (Exception e) {
			throw new ServiceException(
					"Unhandled exception while validating getAutoCenterCode for CenterCode: "
							+ e);
		}
	}

	/* EGALITE-45 start */

	@Override
	public List<CbsCodesVO> getCbsCenterCode() throws ServiceException {
		List<CbsCodes> cbsCodesList = centerCodeDao.getCbsCenterCode();
		if (cbsCodesList != null) {
			List<CbsCodesVO> cbsCodeVOList = new ArrayList<CbsCodesVO>(
					cbsCodesList.size());
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
		List<Location> location = centerCodeDao.getlocationCodes();
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

	/* Tag No: EGA-MN15-000004 Start */
	@Override
	public List<CenterCodesVO> getdistricts() {
		List<CenterCodes> dist = centerCodeDao.getdistricts();
		if (dist != null) {
			List<CenterCodesVO> distVOs = new ArrayList<CenterCodesVO>(
					dist.size());
			for (CenterCodes lov : dist) {
				CenterCodesVO distVO = new CenterCodesVO();
				BeanUtils.copyProperties(lov, distVO);
				distVOs.add(distVO);
			}
			return distVOs;
		} else {
			return new ArrayList<CenterCodesVO>();
		}
	}

	@Override
	public List<CenterCodesVO> getcitys() {
		List<CenterCodes> dist = centerCodeDao.getcitys();
		if (dist != null) {
			List<CenterCodesVO> cityVOs = new ArrayList<CenterCodesVO>(
					dist.size());
			for (CenterCodes lov : dist) {
				CenterCodesVO distVO = new CenterCodesVO();
				BeanUtils.copyProperties(lov, distVO);
				cityVOs.add(distVO);
			}
			return cityVOs;
		} else {
			return new ArrayList<CenterCodesVO>();
		}
	}

	@Override
	public List<CenterCodesVO> getstates() {
		List<CenterCodes> dist = centerCodeDao.getstates();
		if (dist != null) {
			List<CenterCodesVO> stateVOs = new ArrayList<CenterCodesVO>(
					dist.size());
			for (CenterCodes lov : dist) {
				CenterCodesVO distVO = new CenterCodesVO();
				BeanUtils.copyProperties(lov, distVO);
				stateVOs.add(distVO);
			}
			return stateVOs;
		} else {
			return new ArrayList<CenterCodesVO>();
		}
	}

	@Override
	public boolean isCenterCodeAvailable(String centerCode)
			throws ServiceException {
		try {
			return centerCodeDao.isCenterCodeAvailable(centerCode);
		} catch (DataAccessException e) {
			String message = "Error while checking availability of Center Code:"
					+ centerCode + ". Error: " + e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}
	}

	// For SU Authorise

	private static final String SUPER_ADMIN_USER_NAME = "SU";

	@Override
	public CenterCodesVO create(CenterCodesVO centerCode) throws ServiceException {

		centerCode.setAuthStatus("U");

		super.create(centerCode);
		// auto authorize role record if current user is super admin
		if (isCurrentUserSuperAdmin()) {
			authorize(centerCode);
		}
		return centerCode;
	}

	private boolean isCurrentUserSuperAdmin() {
		UserDetails details = getUserDetails();
		String loggedInUser = details.getUsername();
		return loggedInUser.equals(SUPER_ADMIN_USER_NAME);
	}

	/* Tag No: EGA-MN15-000004 Ends */
}
