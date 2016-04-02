package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "MFI_CBS_DROP_LIST")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CbsCodes extends MaintenanceEntity {
	public CbsCodes() {
	}

	@Column(name = "DROP_LIST_ID", nullable = false)
	private String dropListId;
	@Column(name = "BRANCH_CODE", nullable = false)
	private String branchCode;
	@Column(name = "DL_TYPE", nullable = false)
	private String dlType;
	@Column(name = "DL_VALUE", nullable = false)
	private String dlValue;
	@Column(name = "DL_DESC", nullable = false)
	private String dlDesc;
	@Column(name = "AUTH_STATUS", nullable = false)
	private String authStatus;
	@Column(name = "IS_ACTIVE", nullable = false)
	private String isActive;

	public String getDropListId() {
		return dropListId;
	}

	public void setDropListId(String dropListId) {
		this.dropListId = dropListId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getDlType() {
		return dlType;
	}

	public void setDlType(String dlType) {
		this.dlType = dlType;
	}

	public String getDlValue() {
		return dlValue;
	}

	public void setDlValue(String dlValue) {
		this.dlValue = dlValue;
	}

	public String getDlDesc() {
		return dlDesc;
	}

	public void setDlDesc(String dlDesc) {
		this.dlDesc = dlDesc;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
