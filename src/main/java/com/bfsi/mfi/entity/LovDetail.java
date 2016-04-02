package com.bfsi.mfi.entity;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "MFI_MBS_LOV_DISPLAY")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LovDetail extends MaintenanceEntity {
	public LovDetail() {
	}
	
	private String lovId;
	private String lovDesc;
	private String intrValue;
	private String displayValue;
	private int orderBy;
	private String isActive;
	private String authStatus;
	
	//super id used for DISP_ID
	
	public String getLovId() {
		return lovId;
	}
	public void setLovId(String lovId) {
		this.lovId = lovId;
	}
	public String getLovDesc() {
		return lovDesc;
	}
	public void setLovDesc(String lovDesc) {
		this.lovDesc = lovDesc;
	}
	
	public String getIntrValue() {
		return intrValue;
	}
	public void setIntrValue(String intrValue) {
		this.intrValue = intrValue;
	}
	public String getDisplayValue() {
		return displayValue;
	}
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
	public int getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}	
	
}
