package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.entity.CenterCodes;
import com.bfsi.mfi.entity.Location;
import com.bfsi.mfi.exception.ServiceException;

/**
 * ListValueDao
 * 
 * @author Bablu kumar
 * @param <ListValue>
 */

public interface CenterCodeDao extends MaintenanceDao<CenterCodes> {

	List<CenterCodes> getAuthorized();

	public List<Agency> getcountryCodes();

	String deleteCenter(String id) throws ServiceException;

	String getAutoCenterCode() throws ServiceException;

	public List<CbsCodes> getCbsCenterCode();

	public List<Location> getlocationCodes();

	/* For Tag No: EGA-MN15-000004 Start */
	public List<CenterCodes> getdistricts();

	public List<CenterCodes> getcitys();

	public List<CenterCodes> getstates();

	boolean isCenterCodeAvailable(String centerCode);

	/* For Tag No: EGA-MN15-000004 End */
}
