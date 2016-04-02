package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.DepositActivity;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.DepositActivityVO;

/**
 * @author bablu
 * 
 */
public interface DepositActivityService extends ReadOnlyMaintenanceService<DepositActivityVO, DepositActivity> {

	

	public List<DepositActivityVO> getDepositActivityView(String id)  throws ServiceException;

}