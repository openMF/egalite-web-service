package com.bfsi.mfi.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.bfsi.mfi.vo.AuditTrailVO;

@ManagedBean(name = "auditTrailController")
@SessionScoped
public class AuditTrailController implements Serializable {
	private static final long serialVersionUID = -8760557586405475447L;

	private boolean enabled = false;
	private List<AuditTrailVO> auditTrails = new ArrayList<AuditTrailVO>();
	private AuditTrailVO selectedAuditTrail = null;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<AuditTrailVO> getAuditTrails() {
		return auditTrails;
	}

	public void setAuditTrails(List<AuditTrailVO> auditTrails) {
		this.auditTrails = auditTrails;
	}

	public AuditTrailVO getSelectedAuditTrail() {
		return selectedAuditTrail;
	}

	public void setSelectedAuditTrail(AuditTrailVO selectedAuditTrail) {
		this.selectedAuditTrail = selectedAuditTrail;
	}
}