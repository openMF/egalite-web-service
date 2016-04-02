package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "MFI_DEVICE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Device extends MaintenanceEntity {
	public Device() {
	}

	@Column(name = "DEVICE_TYPE", nullable = false)
	private String devicetype;

	@Column(name = "UNIQUE_ID", nullable = false)
	private String uniqueId;

	@Column(name = "ISSUED_DATE", nullable = false)
	private Date issuedDate = new Date();

	@Column(name = "LAST_SYNC", nullable = false)
	private Date lastSync;

	@Column(name = "IS_ACTIVE", nullable = false)
	private String isActive;

	@Column(name = "ISSUED_BY_CO", nullable = false)
	private String issuedByCo;

	@Column(name = "BRAND_MODEL", nullable = false)
	private String brandModel;

	@Column(name = "OPERATING_SYSTEM", nullable = false)
	private String operatingSystem;

	@Column(name = "APP_VERSION", nullable = false)
	private String appVersion;

	@Column(name = "SIM_NUMBER", nullable = false)
	private String simNumber;

	@Column(name = "AUTH_STATUS", nullable = false)
	private String authStatus;

	public String getDeviceType() {
		return devicetype;
	}

	public void setDeviceType(String deviceType) {
		this.devicetype = deviceType;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}


	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Date getLastSync() {
		return lastSync;
	}

	public void setLastSync(Date lastSync) {
		this.lastSync = lastSync;
	}


	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getIssuedByCo() {
		return issuedByCo;
	}

	public void setIssuedByCo(String issuedByCo) {
		this.issuedByCo = issuedByCo;
	}

	public String getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	public String getBrandModel() {
		return brandModel;
	}

	public void setBrandModel(String brandModel) {
		this.brandModel = brandModel;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authorize) {
		this.authStatus = authorize;
	}

}