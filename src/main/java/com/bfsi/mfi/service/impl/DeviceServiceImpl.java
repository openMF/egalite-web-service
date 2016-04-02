package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.DeviceDao;
import com.bfsi.mfi.entity.Device;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DeviceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.DeviceVO;

@Service(value = "deviceService")
public class DeviceServiceImpl extends MaintenanceServiceImpl<DeviceVO, Device>
		implements DeviceService {
	
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	@Autowired
	private DeviceDao deviceDao;

	@Override
	public DeviceVO update(DeviceVO vo) throws ServiceException {
		vo.setAuthStatus("U");
		try {
			return super.update(vo);
		} catch (DataAccessException e) {
			throw new ServiceException(
					"DataAccessException while updating auth status", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected DeviceDao getMaintenanceDao() {
		return deviceDao;
	}

	@Override
	protected Device getEntity(DeviceVO vo) {
		return vo.getEntity();
	}

	@Override
	protected DeviceVO getValueObject(Device entity) {
		DeviceVO deviceVO = new DeviceVO(entity);
		return deviceVO;
	}

	@Override
	public List<DeviceVO> getDevicesForAllocation() {
		List<Device> device = deviceDao.getDevicesForAllocation();
		if (device != null) {
			List<DeviceVO> deviceVOs = new ArrayList<DeviceVO>(device.size());
			for (Device lov : device) {
				DeviceVO deviceVO = new DeviceVO();
				BeanUtils.copyProperties(lov, deviceVO);
				deviceVOs.add(deviceVO);
			}
			return deviceVOs;
		} else {
			return new ArrayList<DeviceVO>();
		}
	}

	@Override
	public String getAutoDeviceId() {
		String devices = deviceDao.getAutoDeviceId();
		return devices;
	}

	@Override
	public boolean isUniqueIdAvailable(String uniqueId) throws ServiceException {
		try {
			return deviceDao.isUniqueIdAvailable(uniqueId);
		} catch (DataAccessException e) {

			throw new ServiceException(
					"Error while checking availability of Unique Id:", e);
		}
	}

	// For ModifyUniqueid
	@Override
	public boolean isModifyUniqueIdAvailable(String id) throws ServiceException {
		try {
			return deviceDao.isModifyUniqueIdAvailable(id);
		} catch (DataAccessException e) {
			throw new ServiceException(
					"Error while checking availability of ModifyUnique Id:", e);
		}
	}

	@Override
	public DeviceVO getDeviceDetail(String uniqueId) throws ServiceException {
		DeviceVO deviceVo = null;
		try {
			Device device = deviceDao.getDeviceDetail(uniqueId);
			deviceVo = getValueObject(device);

		} catch (DataAccessException e) {
			throw new ServiceException(
					"Error while retrieving entity with id:", e);
		}
		return deviceVo;
	}

	/*
	 * @Override public Device deviceDetails(String device_id){ try{ Device
	 * device = getMaintenanceDao().get(device_id); return device; } catch
	 * (DataAccessException e) { return null; }
	 * 
	 * 
	 * }
	 */
	// For delete opertaion

	@Override
	public String deleteDevice(String id) throws ServiceException {
		String success;
		try {
			success = deviceDao.deleteDevice(id);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while validating password: ", e);
		}
		return success;
	}

	@Override
	public List<DeviceVO> getAllocatedDevices(String id) {
		List<Device> device = deviceDao.getAllocatedDevices(id);
		if (device != null) {
			List<DeviceVO> deviceVOs = new ArrayList<DeviceVO>(device.size());
			for (Device lov : device) {
				DeviceVO deviceVO = new DeviceVO();
				BeanUtils.copyProperties(lov, deviceVO);
				deviceVOs.add(deviceVO);
			}
			return deviceVOs;
		} else {
			return new ArrayList<DeviceVO>();
		}
	}

	public void updateDeviceIssuedDate(String deviceId) throws ServiceException {
		//System.out.println("Device Id to reverk back the issue date: "+deviceId);

		try {
			LoggerUtil
					.ibsJobDebug("Calling DAO  for updating device Issued Date: ");
			deviceDao.updateDeviceIssuedDate(deviceId);

		} catch (DataAccessException e) {

			throw new ServiceException(
					"DataAccessException while updating device Issued Date: ",
					e);
		}

	}
	public void updateIssueDateNull(String deviceId) throws ServiceException
	{


		try {
			LoggerUtil
					.ibsJobDebug("Calling DAO  for updating device Issued Date: ");
			deviceDao.updateIssueDateNull(deviceId);

		} catch (DataAccessException e) {

			throw new ServiceException(
					"DataAccessException while updating device Issued Date: ",
					e);
		}

		
	}

}
