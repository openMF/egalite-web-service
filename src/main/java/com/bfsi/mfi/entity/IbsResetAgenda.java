package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "MFI_IBS_RESET_AGENDA")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class IbsResetAgenda extends MaintenanceEntity {
     public IbsResetAgenda(){
     }	
     
     @Column(name = "RESET_OPTION", nullable = false)
 	 private String resetOption;
     
     @Column(name = "AGENT_ID", nullable = false)
 	 private String agentId;
     @Column(name = "RESET_REMARKS", nullable = false)
 	 private String resetRemarks;
     @Column(name = "IS_ACTIVE", nullable = false)
 	 private String isActive;
     @Column(name = "AUTH_STAT", nullable = false)
 	 private String authStatus;
     @Column(name = "INIT_BY_USER_ID", nullable = false)
 	 private String initByUserId;
     @Column(name = "VERIFY_BY_USER_ID", nullable = false)
 	 private String verifyByUserId;
     
     @Column(name = "RESET_INIT_DATETIME", nullable = false)
 	 private Date resetInitDateTime; 
     @Column(name = "RESET_AUTH_DATETIME", nullable = false)
 	 private Date resetAuthDateTime;
     
    /* EGA-MN15-000007 Processing Status Start*/
     @Column(name = "PROCESS_STAT", nullable = false)
   	 private String processStatus;
     
 	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
     /* EGA-MN15-000007 Processing Status End*/
 
	

	public String getResetOption() {
		return resetOption;
	}
	public void setResetOption(String resetOption) {
		this.resetOption = resetOption;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getResetRemarks() {
		return resetRemarks;
	}
	public void setResetRemarks(String resetRemarks) {
		this.resetRemarks = resetRemarks;
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
	public String getInitByUserId() {
		return initByUserId;
	}
	public void setInitByUserId(String initByUserId) {
		this.initByUserId = initByUserId;
	}
	public String getVerifyByUserId() {
		return verifyByUserId;
	}
	public void setVerifyByUserId(String verifyByUserId) {
		this.verifyByUserId = verifyByUserId;
	}
	public Date getResetInitDateTime() {
		return resetInitDateTime;
	}
	public void setResetInitDateTime(Date resetInitDateTime) {
		this.resetInitDateTime = resetInitDateTime;
	}
	public Date getResetAuthDateTime() {
		return resetAuthDateTime;
	}
	public void setResetAuthDateTime(Date resetAuthDateTime) {
		this.resetAuthDateTime = resetAuthDateTime;
	}
 
     
} 
