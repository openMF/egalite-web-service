package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.Branch;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.BranchVO;
import com.bfsi.mfi.vo.CbsCodesVO;

/**
 * @author arun
 * 
 */
public interface BranchService extends MaintenanceService<BranchVO, Branch> {
	/**
	 * Checks if given user id is already available or not
	 * 
	 * @param userId
	 * @return true if no user exists with given user id, false otherwise
	 */
	List<BranchVO> getBranchCode();

	List<BranchVO> getBranchList() throws ServiceException;
	
	public List<CbsCodesVO> getUserCbsBranchCode() throws ServiceException;
	
}
