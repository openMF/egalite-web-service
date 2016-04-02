package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.ExternalDevice;
import com.bfsi.mfi.exception.ServiceException;

public interface ExternalexternalDeviceDao extends MaintenanceDao<ExternalDevice>{
	
	public List<ExternalDevice> getDevicesForAllocation();

	String getAutoDeviceId();
	
	boolean isUniqueIdAvailable(String macId);

	public ExternalDevice getDeviceDetail(String uniqueId);
	
	String deleteDevice(String id) throws ServiceException;

	public List<ExternalDevice> getAllocatedDevices(String id);
	//For Modify UniqueID
	boolean isModifyUniqueIdAvailable(String id);

}
