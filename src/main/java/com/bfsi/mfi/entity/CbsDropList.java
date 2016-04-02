package com.bfsi.mfi.entity;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "stg_cbs_drop_list")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CbsDropList extends MaintenanceEntity {
	
	public CbsDropList() {
	}

	private String branchCode;
	private String dlType;
	private String dlValue;
	private String dlDesc;
	private String cbsUpldJobId;
	private String ibsInternalErr;
	private String ibsErrorDescription;
	
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
	public String getCbsUpldJobId() {
		return cbsUpldJobId;
	}
	public void setCbsUpldJobId(String cbsUpldJobId) {
		this.cbsUpldJobId = cbsUpldJobId;
	}
	public String getIbsInternalErr() {
		return ibsInternalErr;
	}
	public void setIbsInternalErr(String ibsInternalErr) {
		this.ibsInternalErr = ibsInternalErr;
	}
	public String getIbsErrorDescription() {
		return ibsErrorDescription;
	}
	public void setIbsErrorDescription(String ibsErrorDescription) {
		this.ibsErrorDescription = ibsErrorDescription;
	}
}