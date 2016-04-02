package com.bfsi.mfi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.Device;
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DeviceService;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.UserService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.DeviceVO;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.UserVO;

@ManagedBean(name = "deviceController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addDevice"),
		@Permission(type = PermissionType.MODIFY, name = "modifyDevice"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authDevice"),
		@Permission(type = PermissionType.LIST, name = "listDevices"),
		@Permission(type = PermissionType.DELETE, name = "deleteDevice") })
public class DeviceController extends MaintenanceController<DeviceVO, Device> {
	@ManagedProperty(value = "#{deviceService}")
	private DeviceService deviceService;
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	private static String result;
	private static boolean response ;
	private static final String OUTCOME_SUCCESS = "success";
	private final String osType = "Andriod";
	private String isStatusActive;
	private String deviceType;

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getIsStatusActive() {
		return isStatusActive;
	}

	public void setIsStatusActive(String isStatusActive) {
		this.isStatusActive = isStatusActive;
	}

	public String getOsType() {
		return osType;
	}

	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	
	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	private DeviceVO existing = new DeviceVO();

	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}

	private DeviceVO device = new DeviceVO();

	private List<ListValueVO> deviceTypes;
	private List<ListValueVO> deviceStatuss;
	private List<ListValueVO> authStatuss;
	private String autoDeviceId;
	private List<UserVO> creditOfficers;

	@PostConstruct
	public void init() {

		deviceTypes = listservice.get("deviceType");
		ListOfValuesUtil.addLocaleDescription(deviceTypes);

		deviceStatuss = listservice.get("deviceStatus");
		ListOfValuesUtil.addLocaleDescription(deviceStatuss);

		autoDeviceId = deviceService.getAutoDeviceId();
		device.setDeviceId(autoDeviceId);

		authStatuss = listservice.get("authStatus");
		ListOfValuesUtil.addLocaleDescription(authStatuss);
		
		try {
			creditOfficers = userService.getCreditOfficers();
		
		} catch (ServiceException e) {
            LoggerUtil.ibsJobError("ServiceException while Loading init(Post) Method: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}
		catch (Exception e) {
            LoggerUtil.ibsJobError("Unhandled exception while Loading init(Post) Method: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}

	}

	/**
	 * Allow modification only when any value is changed
	 * 
	 * @return
	 * @throws ServiceException 
	 */
	public String checkModifyForUpdate() throws ServiceException {

		device.setUniqueId(device.getUniqueId().trim());
		if (device.getDeviceId().equals(existing.getDeviceId())
				&& device.getDeviceType().equals(existing.getDeviceType())
				&& device.getUniqueId().equals(existing.getUniqueId())				
				&& device.getIsActive().equals(existing.getIsActive())
				&& device.getIssuedByCo().equals(existing.getIssuedByCo())
				&& device.getBrandModel().equals(existing.getBrandModel())
				&& device.getOperatingSystem().equals(
						existing.getOperatingSystem())
				&& device.getAppVersion().equals(existing.getAppVersion())
				&& device.getSimNumber().equals(existing.getSimNumber())) {

			LoggerUtil.ibsJobDebug("No field Modified: MFI01203");
			MessageUtil.addMessage("MFI01203");
			return null;
		}
		else if(!(device.getUniqueId().equals(existing.getUniqueId())))
		{
			boolean UniqId = validateUniqueId();
			if (UniqId) 
			{
				result = "success";
				super.update();
			}
			else {
				result = "";
			}
		}
		else {
			result = "success";
			super.update();
		}
		return result;
	}

	public void loadDevice() {
		DeviceVO deviceVO = new DeviceVO();
		deviceVO.setDeviceId(device.getDeviceId());
		try {
			this.device = deviceService.get(device.getDeviceId());
			deviceType = listservice.getValue(device.getDeviceType(),ListValue.LIST_NAME_DEVICE_TYPE);
			isStatusActive= listservice.getValue(device.getIsActive(),ListValue.LIST_NAME_AGENT_STATUS);
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loading deviceservice: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while loading deviceservice: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		}
		loadAndShowAuditTrail(device);
		existing = (DeviceVO) device.clone();

	}

	public List<ListValueVO> getDeviceStatuss() {
		return deviceStatuss;
	}

	public void setDeviceStatuss(List<ListValueVO> deviceStatuss) {
		this.deviceStatuss = deviceStatuss;
	}

	public List<ListValueVO> getDeviceTypes() {
		return deviceTypes;
	}

	public void setDeviceTypes(List<ListValueVO> deviceTypes) {
		this.deviceTypes = deviceTypes;
	}

	public DeviceService getDeviceService() {
		return deviceService;
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public DeviceVO getDevice() {
		return device;
	}

	public void setDevice(DeviceVO device) {
		this.device = device;
	}

	@Override
	public DeviceVO getMaintenanceVO() {
		device.setOperatingSystem(osType);
		return device;
	}

	@Override
	protected DeviceService getMaintenanceService() {
		return deviceService;
	}

	public boolean validateUniqueId() throws ServiceException {
		String uniqueId = device.getUniqueId().trim();
		try {
			if (!deviceService.isUniqueIdAvailable(uniqueId)) {
				LoggerUtil.ibsJobDebug("Unique Id already used: MFI00801");
				MessageUtil.addMessage("MFI00801");
				response = false;
			} else {

				response = true;
			}
		}

		catch (ServiceException e) {
			LoggerUtil.ibsJobError("Unexpected error while Checking userId: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			response = false;
		}
		return response;
	}

	// For ModifyUniqueId
	public String validateModifyUniqueId() throws ServiceException {
		String id = device.getId().trim();
		try {
			if (!deviceService.isModifyUniqueIdAvailable(id)) {
				LoggerUtil.ibsJobDebug("Unique Id already used: MFI00801");
				MessageUtil.addMessage("MFI00801");
				result = "failure";
			} else {

				result = "success";
			}
		}

		catch (ServiceException e) {
			LoggerUtil.ibsJobError("Unexpected error while Checking userId: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = "failure";
		}
		return result;
	}

	// For Validating Issued Date which will not allow future date.
	public boolean validateissuedDate() throws ServiceException {
		try {
			Date myDate = device.getIssuedDate();
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String dob_date = dateFormat.format(myDate);

			Date date = new Date();
			String curr_date = dateFormat.format(date);

			Date d_date = dateFormat.parse(dob_date);
			Date c_date = dateFormat.parse(curr_date);

			if (d_date.after(c_date)) {
				LoggerUtil.ibsJobDebug("No Future Issued Date Allowed: MFI00802");
				MessageUtil.addMessage("MFI00802");
				response = false;
			}
			else {
				response = true;
			}
			} catch (ServiceException e) {
	            LoggerUtil.ibsJobError("ServiceException while validating DOB: MFI10001", e);
	            MessageUtil.addMessage("MFI10001");
	            response = false;
		     }
		     catch (Exception e) {
		            LoggerUtil.ibsJobError("Unhandled exception while validating DOB: MFI10001", e);
		            MessageUtil.addMessage("MFI10001");
		            response = false;
		     }
		return response;
	}

	public String createDevice() throws ServiceException {
		boolean  r_resp;
		device.setUniqueId(device.getUniqueId().trim());
		try {
			 r_resp = validateUniqueId();
			boolean issuedDate = validateissuedDate();
			if ( r_resp && issuedDate) {
				super.create();
				result = "success";
			} /*else {
				result = "";
			}*/
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("Unexpected error while creating Device: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		return result;
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	// For Modification with unique ID
	public String callModify() {
		String id;
		try {

			id = validateModifyUniqueId();
			if (id.equals("success")) {
				result = checkModifyForUpdate();
			} else {
				result = "success";
			}

		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("Unexpected error while Modifing Device: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		return result;
	}

	// For Delete Operation

	public String deleteUnAuthorized() throws ServiceException {
		try {
			result = deviceService.deleteDevice(device.getId());

			LoggerUtil.ibsJobDebug("Device Record deleted successfully: "
					+ getMaintenanceVO().getId());
			MessageUtil.addMessage("MFI10011", getMaintenanceVO().getId());
			return OUTCOME_SUCCESS;
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("Unhandled exception while deleting record: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = "failure";
		}
		return result;
	}

	public List<ListValueVO> getAuthStatuss() {
		return authStatuss;	
	}

	public void setAuthStatuss(List<ListValueVO> authStatuss) {
		this.authStatuss = authStatuss;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<UserVO> getCreditOfficers() {
		return creditOfficers;
	}

	public void setCreditOfficers(List<UserVO> creditOfficers) {
		this.creditOfficers = creditOfficers;
	}


}