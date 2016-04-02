package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.LovBase;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.LovBaseVO;

public interface LovBaseService extends MaintenanceService<LovBaseVO, LovBase>{

	List<LovBase> getLovIds() throws ServiceException;

	boolean isLovIdAvailable(String id) throws ServiceException;

	String deleteBaseLov(String id) throws ServiceException;

	boolean isLovStatustoInactive(String id)throws ServiceException;

	

}
