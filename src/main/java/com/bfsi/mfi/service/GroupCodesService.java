package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.GroupCodes;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.GroupCodesVO;

public interface GroupCodesService extends MaintenanceService<GroupCodesVO, GroupCodes>{
	String getAutoGroupCode() throws ServiceException;
	String deleteGroupCode(String id) throws ServiceException; 
	List<GroupCodesVO> getAuthorized();
}
