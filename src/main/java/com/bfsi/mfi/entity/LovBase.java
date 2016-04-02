package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;



@Entity(name = "MFI_MBS_LOV_BASE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LovBase extends MaintenanceEntity{
	public LovBase() {
	}
	
	/*@Column(name = "LOV_ID", nullable = false)
	private String lovId;*/
	@Column(name = "LOV_DESC", nullable = false)
	private String lovDesc;
	@Column(name = "IS_ACTIVE", nullable = false)
	private String isActive;
	
	public String getLovDesc() {
		return lovDesc;
	}
	public void setLovDesc(String lovDesc) {
		this.lovDesc = lovDesc;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
	
	
}
