package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.Till;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.TillVO;

public interface TillIdService extends MaintenanceService<TillVO, Till> 
{
	public List<TillVO> getTillIds()  throws ServiceException;
	public String getAutoTillId() throws ServiceException;
}
