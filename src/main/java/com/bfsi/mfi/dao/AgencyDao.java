package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.exception.ServiceException;

/**
 * ListValueDao
 * 
 * @author Bablu kumar
 * @param <ListValue>
 */

public interface AgencyDao extends MaintenanceDao<Agency> {

	List<Agency> getAgencyForAllocation();

	List<Agency> getAuthorized();
	boolean isAgencyCodeAvailable(String agencyCode);
	//public Agency getAgencyDetail(String agencyCode);
	String deleteAgency(String id) throws ServiceException; 
	boolean isAgencyStatustoInactive(String agencyId);
	

	//BFSIMFI-263 Guru Start -
	String getAutoAgencyCode();
	//BFSIMFI-263 Guru End
	public List<Agency> getcountryCodes();
	boolean isCbsCoCodeAvailable(String cbsCoCode);
	public List<CbsCodes> getAgencyCbsCode();
}
