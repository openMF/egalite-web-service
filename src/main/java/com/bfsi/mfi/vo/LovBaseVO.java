package com.bfsi.mfi.vo;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.LovBase;
import com.bfsi.mfi.util.MessageUtil;

public class LovBaseVO extends MaintenanceVO<LovBase>{
	public LovBaseVO(){
		entity = new LovBase();
	}
	
	public LovBaseVO(LovBase entity){
		super(entity);
	}
	
	
	public String getLovDesc() {
		return entity.getLovDesc();
	}
	public void setLovDesc(String lovDesc) {
		entity.setLovDesc(lovDesc);
	}
	public String getIsActive() {
		return entity.getIsActive();
	}
	public void setIsActive(String isActive) {
		entity.setIsActive(isActive); 
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
	
	public Object clone() {
		LovBaseVO copyObj = new LovBaseVO();
		copyObj.setId(getId());
		copyObj.setLovDesc(getLovDesc());
		copyObj.setIsActive(getIsActive());
		
		return copyObj;
	}
}
