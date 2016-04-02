package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.CbsDropList;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.CbsDropListVO;

/**
 * @author arun
 * 
 */
public interface CbsDropListService extends MaintenanceService<CbsDropListVO, CbsDropList> {

	String getCbsDropListValues(List<CbsDropList> cbsDropList) throws ServiceException;
}
