package com.bfsi.mfi.vo;

/**
 * @author Jyoti Ranjan
 *
 */

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.ExternalDevice;
import com.bfsi.mfi.util.MessageUtil;

public class ExternalDeviceVO extends MaintenanceVO<ExternalDevice>{
	public ExternalDeviceVO() {
		entity = new ExternalDevice();
	}
	
	public ExternalDeviceVO(ExternalDevice entity) {
		super(entity);
	}
	
	private String deviceStatusText;
	private String issuedDateText;
	
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

	
	
	public String getMacId() {
		return entity.getMacId();
	}

	public void setMacId(String macId) {
		entity.setMacId(macId); 
	}

	public String getManufacturer() {
		return entity.getManufacturer();
	}

	public void setManufacturer(String manufacturer) {
		entity.setManufacturer(manufacturer); 
	}

	public Date getIssuedDate() {
		return entity.getIssuedDate();
	}

	public void setIssuedDate(Date issuedDate) {
		entity.setIssuedDate(issuedDate); 
	}

	public String getIssuedByCo() {
		return entity.getIssuedByCo();
	}

	public void setIssuedByCo(String issuedByCo) {
		entity.setIssuedByCo(issuedByCo); 
	}

	public String getModelNo() {
		return entity.getModelNo();
	}

	public void setModelNo(String modelNo) {
		entity.setModelNo(modelNo); 
	}

	public String getAuthStatus() {
		return entity.getAuthStatus();
	}

	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus); 
	}

	public String getIsActive() {
		return entity.getIsActive();
	}

	public void setIsActive(String isActive) {
		entity.setIsActive(isActive); 
	}

	public byte[] getLicenceFile() {
		return entity.getLicenceFile();
	}

	public void setLicenceFile(byte[] licenceFile) {
		entity.setLicenceFile(licenceFile); 
	}
	
	
	public String getLicenceFileName() {
		return entity.getLicenceFileName();
	}

	public void setLicenceFileName(String licenceFileName) {
		entity.setLicenceFileName(licenceFileName); 
	}
	
	
	public Object clone() {
		ExternalDeviceVO copyObj = new ExternalDeviceVO();
		
		copyObj.setId(getId());
		copyObj.setMacId(getMacId());
		copyObj.setManufacturer(getManufacturer());
		copyObj.setIssuedDate(getIssuedDate());
		copyObj.setIssuedByCo(getIssuedByCo());
		copyObj.setModelNo(getModelNo());
		copyObj.setIsActive(getIsActive());
		copyObj.setIssuedByCo(getIssuedByCo());
		copyObj.setLicenceFile(getLicenceFile());
		copyObj.setLicenceFileName(getLicenceFileName());
		
		return copyObj;
	}
	
}
