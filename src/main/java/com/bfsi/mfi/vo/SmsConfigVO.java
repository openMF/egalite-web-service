package com.bfsi.mfi.vo;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.SmsConfig;
import com.bfsi.mfi.util.MessageUtil;

public class SmsConfigVO extends MaintenanceVO<SmsConfig> {
	public SmsConfigVO() {
		entity = new SmsConfig();
	}

	public SmsConfigVO(SmsConfig entity) {
		super(entity);
	}

	private String smsConfigStatusText;

	public String getSmsConfigStatusText() {

		FacesContext context = FacesContext.getCurrentInstance();
		if (getIsActive().equalsIgnoreCase("A")) {
			smsConfigStatusText = MessageUtil.getMessage("device.active",
					context);
			return smsConfigStatusText;
		} else {
			smsConfigStatusText = MessageUtil.getMessage("device.inActive",
					context);
			return smsConfigStatusText;
		}

	}

	public void setSmsConfigStatusText(String smsConfigStatusText) {
		this.smsConfigStatusText = smsConfigStatusText;
	}

	public boolean getSendSmsFromMbs() {
		return entity.getSendSmsFromMbs();
	}

	public void setSendSmsFromMbs(boolean sendSmsFromMbs) {
		entity.setSendSmsFromMbs(sendSmsFromMbs);
	}

	public String getSmsTemplateMbs() {
		return entity.getSmsTemplateMbs();
	}

	public void setSmsTemplateMbs(String smsTemplateMbs) {
		entity.setSmsTemplateMbs(smsTemplateMbs);

	}

	public boolean getSendSmsFromIbs() {
		return entity.getSendSmsFromIbs();
	}

	public void setSendSmsFromIbs(boolean sendSmsFromIbs) {
		entity.setSendSmsFromIbs(sendSmsFromIbs);
	}

	public String getSmsTemplateIbs() {
		return entity.getSmsTemplateIbs();
	}

	public void setSmsTemplateIbs(String smsTemplateIbs) {
		entity.setSmsTemplateIbs(smsTemplateIbs);

	}

	public String getIsActive() {
		return entity.getIsActive();
	}

	public void setIsActive(String isActive) {
		entity.setIsActive(isActive);
	}

	public String getAuthStatus() {
		return entity.getAuthStatus();
	}

	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus);
	}

	public String getSmsText() {
		return entity.getSmsText();
	}

	public void setSmsText(String smsText) {
		entity.setSmsText(smsText);

	}

	public Object clone() {
		SmsConfigVO copyObj = new SmsConfigVO();
		/*
		 * copyObj.setId(super.getId());
		 * copyObj.setCbsBranchCode(getCbsBranchCode());
		 * copyObj.setCbsGroupId(getCbsGroupId());
		 * copyObj.setGroupName(getGroupName());
		 * copyObj.setCbsCoId(getCbsCoId()); copyObj.setIbsCoId(getIbsCoId());
		 * copyObj.setContactNumber(getContactNumber());
		 * copyObj.setIsActive(getIsActive());
		 * copyObj.setAuthStatusText(getAuthStatusText());
		 */
		copyObj.setId(super.getId());
		copyObj.setSendSmsFromMbs(getSendSmsFromMbs());
		copyObj.setSmsTemplateIbs(getSmsTemplateIbs());

		copyObj.setSendSmsFromIbs(getSendSmsFromIbs());
		copyObj.setSmsTemplateMbs(getSmsTemplateMbs());

		copyObj.setIsActive(getIsActive());
		copyObj.setAuthStatusText(getAuthStatusText());
		return copyObj;
	}

}
