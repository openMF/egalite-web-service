package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "MFI_EGA_CHARTER")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EgaCharter extends MaintenanceEntity{
	public EgaCharter() {
	}

	//CHARTER_CODE use as super id
	
	
	@Column(name = "RUN_STATUS", nullable = false)
	private String runStatus;
	@Column(name = "HAS_ERROR", nullable = false)
	private String hasError;
	
	
	public String getRunStatus() {
		return runStatus;
	}
	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}
	public String getHasError() {
		return hasError;
	}
	public void setHasError(String hasError) {
		this.hasError = hasError;
	}
	
	
	
	
}
