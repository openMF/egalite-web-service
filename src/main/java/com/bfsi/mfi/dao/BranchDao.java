package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.Branch;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.exception.ServiceException;

public interface BranchDao extends MaintenanceDao<Branch> {
	List<String> getBranchCodes();

	public List<Branch> getBranchCode();

	public List<CbsCodes> getUserCbsBranchCode() throws ServiceException;
	
	List<Branch> getBranchList();
}
