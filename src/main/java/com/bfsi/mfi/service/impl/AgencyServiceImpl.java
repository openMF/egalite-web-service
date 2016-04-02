package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.AgencyDao;
import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.entity.Agent;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.AgencyService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.CbsCodesVO;

@Service(value = "agencyService")
public class AgencyServiceImpl extends MaintenanceServiceImpl<AgencyVO, Agency>
		implements AgencyService {

	@Autowired
	private AgencyDao agencyDao;

	@Override
	public AgencyVO update(AgencyVO vo) throws ServiceException {
		vo.setAuthStatus("U");
		try {
			return super.update(vo);
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while updating auth status", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected AgencyDao getMaintenanceDao() {
		return agencyDao;
	}

	protected Agency getEntity(AgencyVO vo) {
		return vo.getEntity();
	}

	@Override
	protected AgencyVO getValueObject(Agency entity) {
		AgencyVO agencyVO = new AgencyVO(entity);
		return agencyVO;
	}

	@Override
	public List<AgencyVO> getAgencyForAllocation() {
		List<Agency> agency = agencyDao.getAgencyForAllocation();
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
	@Override
	public boolean isAgencyCodeAvailable(String agencyCode) throws ServiceException {
		try {
			return agencyDao.isAgencyCodeAvailable(agencyCode);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while checking availability of Unique Id:", e);
		}
	}
	
	// For Delete Operation
	@Override
	public String deleteAgency(String id) throws ServiceException {
		String success;
		try {
			success= agencyDao.deleteAgency(id);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while deleting Agency: ", e);
		}
		return success;
	}
	
	@Override
	public List<AgencyVO> getAuthorized() {
		List<Agency> agency = agencyDao.getAuthorized();
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

	// For ModifyRole Status
	@Override
	public boolean isAgencyStatustoInactive(String agencyId) throws ServiceException {
		try {
			return agencyDao.isAgencyStatustoInactive(agencyId);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while checking availability of Agency Status:", e);
		}
	}
	
	//BFSIMFI-263 Guru Start 
	@Override
	public String getAutoAgencyCode() throws ServiceException
	{
		String agencyCodes;
		try {
			
			agencyCodes = agencyDao.getAutoAgencyCode();
			return agencyCodes;
			
		} catch (DataAccessException e) {
			throw new ServiceException("Error while generating the Automatic agency Code: ", e);
		}
	}
	//BFSIMFI-263 Guru End
	@Override
	public List<AgencyVO> getcountryCodes() {
		List<Agency> agency = agencyDao.getcountryCodes();
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
/*	@Override
	public boolean isCbsCoCodeAvailable(String cbsCoCode) throws ServiceException {
		try {
			LoggerUtil.ibsJobDebug("validating  isCbsCoCodeAvailable for Agency = " + cbsCoCode);
			return agencyDao.isCbsCoCodeAvailable(cbsCoCode);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while isCbsCoCodeAvailable for Agency for Agency =  "+cbsCoCode, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while isCbsCoCodeAvailable for Agency for Agency =  "+cbsCoCode, e);
        }

	}*/
	
	
	@Override
	public List<CbsCodesVO> getAgencyCbsCode() throws ServiceException {
		List<CbsCodes> cbsCodesList = agencyDao.getAgencyCbsCode();
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

	
}
