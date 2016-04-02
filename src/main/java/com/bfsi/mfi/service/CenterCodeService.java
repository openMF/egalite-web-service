package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.CenterCodes;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.CbsCodesVO;
import com.bfsi.mfi.vo.CenterCodesVO;
import com.bfsi.mfi.vo.LocationVO;

/**
 * @author arun
 * 
 */
public interface CenterCodeService extends
		MaintenanceService<CenterCodesVO, CenterCodes> {

	List<CenterCodesVO> getAuthorized();

	List<AgencyVO> getcountryCodes();

	String deleteCenter(String id) throws ServiceException;

	String getAutoCenterCode() throws ServiceException;

	List<CbsCodesVO> getCbsCenterCode() throws ServiceException;

	List<LocationVO> getlocationCodes();

	/* For Tag No: EGA-MN15-000004 Start */
	List<CenterCodesVO> getdistricts();

	List<CenterCodesVO> getcitys();

	List<CenterCodesVO> getstates();

	boolean isCenterCodeAvailable(String centerCode) throws ServiceException;
	/* For Tag No: EGA-MN15-000004 End */

}
