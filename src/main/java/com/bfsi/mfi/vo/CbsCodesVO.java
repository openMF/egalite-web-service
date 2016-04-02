package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.CbsCodes;

public class CbsCodesVO extends MaintenanceVO<CbsCodes> {
	public CbsCodesVO() {
		entity = new CbsCodes();
	}

	public CbsCodesVO(CbsCodes entity) {
		super(entity);
	}
	public String getDropListId() {
		return super.getId();
	}

	public void setDropListId(String dropListId) {
		super.setId(dropListId);
	}
	public String getBranchCode() {
		return entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode);
	}

	public String getDlType() {
		return entity.getDlType();
	}

	public void setDlType(String dlType) {
		entity.setDlType(dlType);
		
	}

	public String getDlValue() {
		return entity.getDlValue();
	}

	public void setDlValue(String dlValue) {
		entity.setDlValue(dlValue);
	}

	public String getDlDesc() {
		return entity.getDlDesc();
	}

	public void setDlDesc(String dlDesc) {
		entity.setDlDesc(dlDesc);
		
	}

	public String getAuthStatus() {
		return entity.getAuthStatus();
	}

	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus);
	}
	

	public String getIsActive() {
		return entity.getIsActive();
	}

	public void setIsActive(String isActive) {
		entity.setIsActive(isActive);
		
	}
}
