package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.RefCodeDetail;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.RefCodeDetailVO;
import com.bfsi.mfi.vo.RefCodeVO;

/**
 * @author Bablu kumar
 * 
 */
public interface ReferenceCodeDetailService extends ReadOnlyMaintenanceService<RefCodeDetailVO, RefCodeDetail> {
	public List<RefCodeDetailVO> getrefCodeDetail(String refCodeDetailId)  throws ServiceException;

	public String getrowUpdate(RefCodeDetail refCode) throws ServiceException;
	
	public void insertRefCode(RefCodeVO refcode);
	
}
