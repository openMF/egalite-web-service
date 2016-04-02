package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.CbsDropList;

public class CbsDropListVO extends MaintenanceVO<CbsDropList> {

	public CbsDropListVO() {
		entity = new CbsDropList();
	}

	public CbsDropListVO(CbsDropList entity) {
		super(entity);
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

	public String getCbsUpldJobId() {
		return entity.getCbsUpldJobId();
	}

	public void setCbsUpldJobId(String cbsUpldJobId) {
		entity.setCbsUpldJobId(cbsUpldJobId);
	}

	public String getIbsInternalErr() {
		return entity.getIbsInternalErr();
	}

	public void setIbsInternalErr(String ibsInternalErr) {
		entity.setIbsInternalErr(ibsInternalErr);
	}

	public String getIbsErrorDescription() {
		return entity.getIbsErrorDescription();
	}

	public void setIbsErrorDescription(String ibsErrorDescription) {
		entity.setIbsErrorDescription(ibsErrorDescription);
	}

}
