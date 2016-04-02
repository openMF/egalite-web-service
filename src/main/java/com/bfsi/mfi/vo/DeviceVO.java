package com.bfsi.mfi.vo;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.Device;
import com.bfsi.mfi.util.MessageUtil;

/**
 * @author bablu
 *
 */
public class DeviceVO extends MaintenanceVO<Device>  {

	public DeviceVO() {
		entity = new Device();
	}
	
	public DeviceVO(Device entity) {
		super(entity);
	}
	
	private String deviceStatusText;
	private String deviceTypeText;
	private String issuedDateText;
	private String lastSyncText;
	
	public String getIssuedDateText() {
		if (getIssuedDate() != null) {
			Date IssueDate = getIssuedDate();
			Format formatter = new SimpleDateFormat("dd-MMM-yyyy");
			String formattedDate = formatter.format(IssueDate);
			issuedDateText = formattedDate.toString();
			return issuedDateText;
		} else {
			issuedDateText = "";
			return issuedDateText;
		}
	}

	public void setIssuedDateText(String issuedDateText) {
		this.issuedDateText = issuedDateText;
	}

	public String getLastSyncText(){
		if (getLastSync() != null) {
			Date LastSync = getLastSync();
			Format formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
			String formattedDate = formatter.format(LastSync);
			lastSyncText = formattedDate.toString();
			return lastSyncText;
		} else {
			lastSyncText = "";
			return lastSyncText;
		}
	}

	public void setLastSyncText(String lastSyncText) {
		this.lastSyncText = lastSyncText;
	}

	public String getIsActive() {
		return entity.getIsActive();
	}

	public void setIsActive(String isActive) {
		entity.setIsActive(isActive);
	}

	public String getDeviceId() {
		return super.getId();
	}

	public void setDeviceId(String deviceId) {
		super.setId(deviceId);
	}

	public String getDeviceType() {
		return entity.getDeviceType();
	}

	public void setDeviceType(String deviceType) {
		entity.setDeviceType(deviceType);
	}

	public String getUniqueId() {
		return entity.getUniqueId();
	}

	public void setUniqueId(String uniqueId) {
		entity.setUniqueId(uniqueId);
	}

	public Date getIssuedDate() {
		return entity.getIssuedDate();
	}

	public void setIssuedDate(Date issuedDate) {
		entity.setIssuedDate(issuedDate);
	}

	public Date getLastSync() {
		return entity.getLastSync();
	}

	public void setLastSync(Date lastSync) {
		entity.setLastSync(lastSync);
	}

	public String getIssuedByCo() {
		return entity.getIssuedByCo();
	}

	public void setIssuedByCo(String issuedByCo) {
		entity.setIssuedByCo(issuedByCo);
	}

	public String getBrandModel() {
		return entity.getBrandModel();
	}

	public void setBrandModel(String brandModel) {
		entity.setBrandModel(brandModel);
	}

	public String getOperatingSystem() {
		return entity.getOperatingSystem();
	}

	public void setOperatingSystem(String operatingSystem) {
		entity.setOperatingSystem(operatingSystem);
	}

	public String getAppVersion() {
		return entity.getAppVersion();
	}

	public void setAppVersion(String appVersion) {
		entity.setAppVersion(appVersion);
	}

	public String getSimNumber() {
		return entity.getSimNumber();
	}

	public void setSimNumber(String simNumber) {
		entity.setSimNumber(simNumber);
	}

	public String getDeviceStatusText() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (getIsActive().equalsIgnoreCase("A")) {
			deviceStatusText = MessageUtil.getMessage("device.active",context);
			return deviceStatusText;
		} else {
			deviceStatusText = MessageUtil.getMessage("device.inActive",context);
			return deviceStatusText;
		}
	}

	public void setDeviceStatusText(String deviceStatusText) {
		this.deviceStatusText = deviceStatusText;
	}

	public String getDeviceTypeText() {
		FacesContext context = FacesContext.getCurrentInstance();
		String devId=getDeviceType().trim();
		if (devId.equalsIgnoreCase("1")) {
			deviceTypeText = MessageUtil.getMessage("device.mobile",context);
			return deviceTypeText;
		}
		else if (devId.equalsIgnoreCase("2")) {
			deviceTypeText = MessageUtil.getMessage("device.tablet",context);
			return deviceTypeText;
		}
		else{
			deviceTypeText = "";
			return deviceTypeText;
		}
	}

	public void setDeviceTypeText(String deviceTypeText) {
		this.deviceTypeText = deviceTypeText;
	}
	

	
	public Object clone() {
		DeviceVO copyObj = new DeviceVO();
		copyObj.setDeviceId(getDeviceId());
		copyObj.setDeviceType(getDeviceType());
		copyObj.setUniqueId(getUniqueId());
		copyObj.setIssuedDate(getIssuedDate());
		copyObj.setLastSync(getLastSync());
		copyObj.setIsActive(getIsActive());
		copyObj.setIssuedByCo(getIssuedByCo());
		copyObj.setBrandModel(getBrandModel());
		copyObj.setOperatingSystem(getOperatingSystem());
		copyObj.setAppVersion(getAppVersion());
		copyObj.setSimNumber(getSimNumber());
		return copyObj;
	}

}
