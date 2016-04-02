package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.CbsCodes;

public interface CbsCodesDao extends MaintenanceDao<CbsCodes>{
	public List<CbsCodes> getCbsLocationCodes();
	public List<CbsCodes> getCbsBranchCodes();
	public List<CbsCodes> getCbsRouteCodes();
	public List<CbsCodes> getCbsCenterCodes();
	public List<CbsCodes> getCbsAgentCodes();
}
