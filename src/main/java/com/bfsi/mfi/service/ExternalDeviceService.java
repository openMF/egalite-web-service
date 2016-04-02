package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.ExternalDevice;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.ExternalDeviceVO;

public interface ExternalDeviceService extends MaintenanceService<ExternalDeviceVO, ExternalDevice>{
   List<ExternalDeviceVO> getDevicesForAllocation();
	
	List<ExternalDeviceVO> getAllocatedDevices(String id);
	
	String getAutoDeviceId() ;
	// Device deviceDetails(String agent_id);
	
	boolean isUniqueIdAvailable(String uniqueId) throws ServiceException;

	ExternalDeviceVO getDeviceDetail(String uniqueId) throws ServiceException;
	
	String deleteDevice(String id) throws ServiceException;
	//For Modify UniqueID
	boolean isModifyUniqueIdAvailable(String id) throws ServiceException;
}
