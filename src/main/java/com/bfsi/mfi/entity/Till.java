package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "MFI_MBS_TILLID_V")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Till extends MaintenanceEntity {
	
	public Till() {
	}

	@Column(name = "TILL_ID", nullable = false)
	private String tillId;
	
	private String ccyCode;
	
	public String getTillId() {
		return tillId;
	}

	public void setTillId(String tillId) {
		this.tillId = tillId;
	}

	public String getCcyCode() {
		return ccyCode;
	}

	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}
	
}
