package com.bfsi.mfi.vo;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.LovDetail;
import com.bfsi.mfi.util.MessageUtil;

public class LovVO extends MaintenanceVO<LovDetail>{
	
	public LovVO(){
		entity = new LovDetail();
	}
	
	public LovVO(LovDetail entity){
		super(entity);
	}
	
	public String getLovId() {
		return this.entity.getLovId();
	}
	public void setLovId(String lovId) {
		entity.setLovId(lovId);
	}
	
	public String getLovDesc() {
		return this.entity.getLovDesc();
	}
	public void setLovDesc(String lovDesc) {
		entity.setLovDesc(lovDesc); 
	}
	
	public String getIntrValue() {
		return this.entity.getIntrValue();
	}
	public void setIntrValue(String intrValue) {
		entity.setIntrValue(intrValue);
	}
	public String getDisplayValue() {
		return this.entity.getDisplayValue();
	}
	public void setDisplayValue(String displayValue) {
		entity.setDisplayValue(displayValue);
	}
	public int getOrderBy() {
		return this.entity.getOrderBy();
	}
	public void setOrderBy(int orderBy) {
		entity.setOrderBy(orderBy);
	}
	public String getIsActive() {
		return this.entity.getIsActive();
	}
	public void setIsActive(String isActive) {
		entity.setIsActive(isActive);
	}
	public String getAuthStatus() {
		return this.entity.getAuthStatus();
	}
	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus);
	}
	
	
	
	
	
	public Object clone() {
		LovVO copyObj = new LovVO();
		
		copyObj.setId(getId());
		copyObj.setLovId(getLovId());
		copyObj.setLovDesc(getLovDesc());
		copyObj.setIntrValue(getIntrValue());
		copyObj.setDisplayValue(getDisplayValue());
		copyObj.setOrderBy(getOrderBy());
		copyObj.setAuthStatus(getAuthStatus());
		copyObj.setIsActive(getIsActive());
		copyObj.setAuthStatusText(getAuthStatusText());
		
		
		return copyObj;
	}

	
	private String agencyStatusText;

	public String getagencyStatusText() {
		FacesContext context = FacesContext.getCurrentInstance();
		String devId = getIsActive().trim();
		if (getIsActive().equalsIgnoreCase("A")) {
			agencyStatusText = MessageUtil.getMessage("role.active", context);
			return agencyStatusText;
		} else if (devId.equalsIgnoreCase("I")) {
			agencyStatusText = MessageUtil.getMessage("role.inActive", context);
			return agencyStatusText;
		} else {
			agencyStatusText = "";
			return agencyStatusText;
		}
	}

	public void setAgencyStatusText(String agencyStatusText) {
		this.agencyStatusText = agencyStatusText;
	}
}
