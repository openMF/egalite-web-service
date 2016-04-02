package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.Device;
import com.bfsi.mfi.exception.ServiceException;

/**
 * User DAO
 * 
 * @author Bablu
 * 
 * @param <User>
 */
public interface DeviceDao extends MaintenanceDao<Device> {

	public List<Device> getDevicesForAllocation();

	String getAutoDeviceId();
	boolean isUniqueIdAvailable(String uniqueId);

	public Device getDeviceDetail(String uniqueId);
	String deleteDevice(String id) throws ServiceException;

	public List<Device> getAllocatedDevices(String id);
	//For Modify UniqueID
	boolean isModifyUniqueIdAvailable(String id);
	public void updateDeviceIssuedDate(String deviceId);
	public void updateIssueDateNull(String deviceId);

}
