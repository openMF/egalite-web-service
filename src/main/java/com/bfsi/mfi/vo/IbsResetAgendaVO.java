package com.bfsi.mfi.vo;

import java.util.Date;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.IbsResetAgenda;
import com.bfsi.mfi.util.MessageUtil;

public class IbsResetAgendaVO extends MaintenanceVO<IbsResetAgenda> {
	public IbsResetAgendaVO() {
		entity = new IbsResetAgenda();
	}

	public IbsResetAgendaVO(IbsResetAgenda entity) {
		super(entity);
	}

	private String reAgendaStatusText;

	public String getResetOption() {
		return entity.getResetOption();
	}

	public void setResetOption(String resetOption) {
		// System.out.println("sET setResetOption:: "+resetOption);
		entity.setResetOption(resetOption);
	}

	public String getAgentId() {
		return entity.getAgentId();
	}

	public void setAgentId(String agentId) {
		entity.setAgentId(agentId);
	}

	public String getResetRemarks() {
		return entity.getResetRemarks();
	}

	public void setResetRemarks(String resetRemarks) {
		entity.setResetRemarks(resetRemarks);
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

	public String getInitByUserId() {
		return entity.getInitByUserId();
	}

	public void setInitByUserId(String initByUserId) {
		entity.setInitByUserId(initByUserId);
	}

	public String getVerifyByUserId() {
		return entity.getVerifyByUserId();
	}

	public void setVerifyByUserId(String verifyByUserId) {
		entity.setVerifyByUserId(verifyByUserId);
	}

	public Date getResetInitDateTime() {
		return entity.getResetInitDateTime();
	}

	public void setResetInitDateTime(Date resetInitDateTime) {
		entity.setResetInitDateTime(resetInitDateTime);
	}

	public Date getResetAuthDateTime() {
		return entity.getResetAuthDateTime();
	}

	public void setResetAuthDateTime(Date resetAuthDateTime) {
		entity.setResetAuthDateTime(resetAuthDateTime);
	}

	public String getReAgendaStatusText() {
		FacesContext context = FacesContext.getCurrentInstance();
		String devId = getIsActive().trim();
		if (getIsActive().equalsIgnoreCase("A")) {
			reAgendaStatusText = MessageUtil.getMessage("role.active", context);
			return reAgendaStatusText;
		} else if (devId.equalsIgnoreCase("I")) {
			reAgendaStatusText = MessageUtil.getMessage("role.inActive",
					context);
			return reAgendaStatusText;
		} else {
			reAgendaStatusText = "";
			return reAgendaStatusText;
		}
	}

	public void setReAgendaStatusText(String reAgendaStatusText) {
		this.reAgendaStatusText = reAgendaStatusText;
	}
	  /* EGA-MN15-000007 Processing Status Start*/
	public String getProcessStatus() {
		return entity.getProcessStatus();
	}

	public void setProcessStatus(String processStatus) {
		entity.setProcessStatus(processStatus);

	}
	  /* EGA-MN15-000007 Processing Status End*/

	public Object clone() {
		IbsResetAgendaVO copyObj = new IbsResetAgendaVO();

		copyObj.setId(getId());
		copyObj.setResetOption(getResetOption());
		copyObj.setAgentId(getAgentId());
		copyObj.setResetRemarks(getResetRemarks());
		copyObj.setInitByUserId(getInitByUserId());
		copyObj.setVerifyByUserId(getVerifyByUserId());
		copyObj.setResetInitDateTime(getResetInitDateTime());
		copyObj.setResetAuthDateTime(getResetAuthDateTime());
		copyObj.setAuthStatus(getAuthStatus());
		copyObj.setAuthStatusText(getAuthStatusText());
		copyObj.setIsActive(getIsActive());
		copyObj.setProcessStatus(getProcessStatus());//EGA-MN15-000007 added for processing status
		return copyObj;
	}

}
