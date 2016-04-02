package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "MFI_EXTERNAL_DEVICE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ExternalDevice extends MaintenanceEntity{
	public ExternalDevice() {
	}
     
	@Column(name = "MAC_ID", nullable = false)
	private String macId;
	
	@Column(name = "MANUFACTURER", nullable = false)
	private String manufacturer;

	@Column(name = "ISSUED_DATE", nullable = false)
	private Date issuedDate = new Date();

	@Column(name = "ISSUED_BY_CO", nullable = false)
	private String issuedByCo;

	@Column(name = "MODEL_NO", nullable = false)
	private String modelNo;

	@Column(name = "AUTH_STATUS", nullable = false)
	private String authStatus;
	
	@Column(name = "IS_ACTIVE", nullable = false)
	private String isActive;
	
	@Column(name = "LICENCE_FILE", nullable = false)
	private byte[] licenceFile; //blob
	
	@Column(name = "LICENCE_FILE_NAME", nullable = false)
	private String licenceFileName;
	
	
	public String getMacId() {
		return macId;
	}

	public void setMacId(String macId) {
		this.macId = macId;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getIssuedByCo() {
		return issuedByCo;
	}

	public void setIssuedByCo(String issuedByCo) {
		this.issuedByCo = issuedByCo;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public byte[] getLicenceFile() {
		return licenceFile;
	}

	public void setLicenceFile(byte[] licenceFile) {
		this.licenceFile = licenceFile;
	}

	public String getLicenceFileName() {
		return licenceFileName;
	}

	public void setLicenceFileName(String licenceFileName) {
		this.licenceFileName = licenceFileName;
	}
	
	
	
}
