package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.CbsCodesVO;

public interface CbsCodesService extends MaintenanceService<CbsCodesVO, CbsCodes>{
	public List<CbsCodesVO> getCbsLocationCodes() throws ServiceException ;
	public List<CbsCodesVO> getCbsBranchCodes() throws ServiceException ;
	public List<CbsCodesVO> getCbsRouteCodes() throws ServiceException ;
	public List<CbsCodesVO> getCbsCenterCodes() throws ServiceException ;
	public List<CbsCodesVO> getCbsAgentCodes() throws ServiceException ;
}
