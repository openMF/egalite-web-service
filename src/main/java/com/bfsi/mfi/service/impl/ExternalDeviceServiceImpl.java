package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.ExternalexternalDeviceDao;
import com.bfsi.mfi.entity.ExternalDevice;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ExternalDeviceService;
import com.bfsi.mfi.vo.ExternalDeviceVO;


@Service(value = "externalDeviceService")
public class ExternalDeviceServiceImpl extends MaintenanceServiceImpl<ExternalDeviceVO, ExternalDevice>
           implements ExternalDeviceService{
	
	@Autowired
	private ExternalexternalDeviceDao externalexternalDeviceDao;

	@Override
	public ExternalDeviceVO update(ExternalDeviceVO vo) throws ServiceException {
		vo.setAuthStatus("U");
		try {
			return super.update(vo);
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while updating auth status", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected ExternalexternalDeviceDao getMaintenanceDao() {
		return externalexternalDeviceDao;
	}

	@Override
	protected ExternalDevice getEntity(ExternalDeviceVO vo) {
		// vo.getLicenceFile();
		return vo.getEntity();
	}

	@Override
	protected ExternalDeviceVO getValueObject(ExternalDevice entity) {
		ExternalDeviceVO externalDeviceVO = new ExternalDeviceVO(entity);
		return externalDeviceVO;
	}

	@Override
	public List<ExternalDeviceVO> getDevicesForAllocation() {
		List<ExternalDevice> externalDevice = externalexternalDeviceDao.getDevicesForAllocation();
		if (externalDevice != null) {
			List<ExternalDeviceVO> deviceVOs = new ArrayList<ExternalDeviceVO>(externalDevice.size());
			for (ExternalDevice lov : externalDevice) {
				ExternalDeviceVO deviceVO = new ExternalDeviceVO();
				BeanUtils.copyProperties(lov, deviceVO);
				deviceVOs.add(deviceVO);
			}
			return deviceVOs;
		} else {
			return new ArrayList<ExternalDeviceVO>();
		}
	}

	@Override
	public String getAutoDeviceId() {
		String externalDevices = externalexternalDeviceDao.getAutoDeviceId();
		return externalDevices;
	}

	@Override
	public boolean isUniqueIdAvailable(String uniqueId) throws ServiceException {
		try {
			return externalexternalDeviceDao.isUniqueIdAvailable(uniqueId);
		} catch (DataAccessException e) {

			throw new ServiceException("Error while checking availability of Unique Id:", e);
		}
	}
	
	// For ModifyUniqueid
	@Override
	public boolean isModifyUniqueIdAvailable(String id) throws ServiceException {
		try {
			return externalexternalDeviceDao.isModifyUniqueIdAvailable(id);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while checking availability of ModifyUnique Id:", e);
		}
	}
	
	@Override
	public ExternalDeviceVO getDeviceDetail(String uniqueId) throws ServiceException {
		ExternalDeviceVO deviceVo = null;
		try {
			ExternalDevice device = externalexternalDeviceDao.getDeviceDetail(uniqueId);
			deviceVo = getValueObject(device);

		} catch (DataAccessException e) {
			throw new ServiceException("Error while retrieving entity with id:", e);
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
			success= externalexternalDeviceDao.deleteDevice(id);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while validating password: ", e);
		}
		return success;
	}

	@Override
	public List<ExternalDeviceVO> getAllocatedDevices(String id) {
		List<ExternalDevice> extdevice = externalexternalDeviceDao.getAllocatedDevices(id);
		if (extdevice != null) {
			List<ExternalDeviceVO> extdeviceVOs = new ArrayList<ExternalDeviceVO>(extdevice.size());
			for (ExternalDevice lov : extdevice) {
				ExternalDeviceVO deviceVO = new ExternalDeviceVO();
				BeanUtils.copyProperties(lov, deviceVO);
				extdeviceVOs.add(deviceVO);
			}
			return extdeviceVOs;
		} else {
			return new ArrayList<ExternalDeviceVO>();
		}
	}

	
	
	/*public ExternalDeviceVO create(ExternalDeviceVO vo) throws ServiceException {
		ExternalDeviceVO extVo = new ExternalDeviceVO();
		extVo.setLicenceFile(vo.getLicenceFile());
		vo.getLicenceFile();
		
	}*/
}
