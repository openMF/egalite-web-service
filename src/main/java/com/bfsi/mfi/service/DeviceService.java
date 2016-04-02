package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.Device;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.DeviceVO;
import com.bfsi.mfi.vo.SystemParameterVO;

/**
 * @author Bablu
 * 
 */
public interface DeviceService extends MaintenanceService<DeviceVO, Device> {

	List<DeviceVO> getDevicesForAllocation();
	
	List<DeviceVO> getAllocatedDevices(String id);
	
	String getAutoDeviceId() ;
	// Device deviceDetails(String agent_id);
	
	boolean isUniqueIdAvailable(String uniqueId) throws ServiceException;

	DeviceVO getDeviceDetail(String uniqueId) throws ServiceException;
	String deleteDevice(String id) throws ServiceException;
	//For Modify UniqueID
	boolean isModifyUniqueIdAvailable(String id) throws ServiceException;
	 void updateDeviceIssuedDate(String deviceId) throws ServiceException;
	 void updateIssueDateNull(String deviceId) throws ServiceException;
	

}
