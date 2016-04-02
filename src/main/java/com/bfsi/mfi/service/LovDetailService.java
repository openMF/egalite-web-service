package com.bfsi.mfi.service;

/**
 * @author Jyoti Ranjan
 * 
 */

import java.util.List;

import com.bfsi.mfi.entity.LovDetail;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.LovVO;

public interface LovDetailService extends MaintenanceService<LovVO, LovDetail>{

	int getInterValue(String lovId) throws ServiceException;

	boolean isLovStatustoInactive(String idd) throws ServiceException;
	
	String getAutoLovId() throws ServiceException;

	LovVO createInfo(LovVO lovVo) throws ServiceException;

	String deleteUnAuthorized(String id) throws ServiceException;

	List<LovVO> getDispValue(String lovId) throws ServiceException;

}
