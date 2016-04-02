package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.CbsCodesVO;

/**
 * @author arun
 * 
 */
public interface AgencyService extends MaintenanceService<AgencyVO, Agency> {
	List<AgencyVO> getAgencyForAllocation();
	
	List<AgencyVO> getAuthorized();
	boolean isAgencyCodeAvailable(String agencyCode) throws ServiceException;
	String deleteAgency(String id) throws ServiceException; 
	boolean isAgencyStatustoInactive(String agencyId) throws ServiceException;
	//BFSIMFI-263 Guru Start 
	String getAutoAgencyCode() throws ServiceException;
	//BFSIMFI-263 Guru End
	List<AgencyVO> getcountryCodes();
	//boolean isCbsCoCodeAvailable(String cbsCoCode) throws ServiceException;
	List<CbsCodesVO> getAgencyCbsCode() throws ServiceException;
}
