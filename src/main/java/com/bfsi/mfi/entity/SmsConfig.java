package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "mfi_sms_config")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SmsConfig extends MaintenanceEntity {
	public SmsConfig() {
	}

	/*txn_code		varchar2(3),	super id
	send_sms_from_mbs	varchar2(1),sms_format_mbs	varchar2(300),send_sms_from_ibs	varchar2(1),	
	sms_format_ibs		varchar2(300),is_active		varchar2(1),auth_status		varchar2(1)*/
	
	@Column(name = "send_sms_from_mbs", nullable = false)
	private boolean sendSmsFromMbs;
	@Column(name = "sms_template_mbs", nullable = false)
	private String smsTemplateMbs;
	@Column(name = "send_sms_from_ibs", nullable = false)
	private boolean sendSmsFromIbs;
	@Column(name = "sms_template_ibs", nullable = false)
	private String smsTemplateIbs;
	@Column(name = "is_active", nullable = false)
	private String isActive;
	@Column(name = "auth_status", nullable = false)
	private String authStatus;
	
	private String smsText;
	private String sendSmsFromMbsStr;
	private String sendSmsFromIbsStr;
	
	
	
	public String getSendSmsFromMbsStr() {
		return sendSmsFromMbsStr;
	}
	public void setSendSmsFromMbsStr(String sendSmsFromMbsStr) {
		if(sendSmsFromMbsStr.equals("0"))
			sendSmsFromMbs= false;
		else
			sendSmsFromMbs= true;
		this.sendSmsFromMbsStr = sendSmsFromMbsStr;
	}
	public String getSendSmsFromIbsStr() {
		return sendSmsFromIbsStr;
	}
	public void setSendSmsFromIbsStr(String sendSmsFromIbsStr) {
		if(sendSmsFromIbsStr.equals("0"))
			sendSmsFromIbs= false;
		else
			sendSmsFromIbs= true;
		this.sendSmsFromIbsStr = sendSmsFromIbsStr;
	}

	public String getSmsText() {
		return smsText;
	}
	public void setSmsText(String smsText) {
		this.smsText = smsText;
	}
	
	
	
	
	
	public boolean getSendSmsFromMbs() {
		return sendSmsFromMbs;
	}
	public void setSendSmsFromMbs(boolean sendSmsFromMbs) {

		if(sendSmsFromMbs)
			sendSmsFromMbsStr="1";
		else
			sendSmsFromMbsStr="0";
		this.sendSmsFromMbs = sendSmsFromMbs;
	}
	public String getSmsTemplateMbs() {
		return smsTemplateMbs;
	}
	public void setSmsTemplateMbs(String smsTemplateMbs) {
		this.smsTemplateMbs = smsTemplateMbs;
	}
	public boolean getSendSmsFromIbs() {
		return sendSmsFromIbs;
	}
	public void setSendSmsFromIbs(boolean sendSmsFromIbs) {
		
		if(sendSmsFromIbs)
			sendSmsFromIbsStr="1";
		else
			sendSmsFromIbsStr="0";
		this.sendSmsFromIbs = sendSmsFromIbs;
	}
	public String getSmsTemplateIbs() {
		return smsTemplateIbs;
	}
	public void setSmsTemplateIbs(String smsTemplateIbs) {
		this.smsTemplateIbs = smsTemplateIbs;
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
