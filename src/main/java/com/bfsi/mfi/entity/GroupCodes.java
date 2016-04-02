package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "MFI_GROUP_CODES")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GroupCodes extends MaintenanceEntity{
	public GroupCodes() {
	}

	@Column(name = "cbs_branch_code", nullable = false)
	private String cbsBranchCode;
	@Column(name = "cbs_group_id", nullable = false)
	private String cbsGroupId;
	@Column(name = "group_name", nullable = false)
	private String groupName;
	@Column(name = "cbs_co_id", nullable = false)
	private String cbsCoId;
	@Column(name = "ibs_co_id", nullable = false)
	private String ibsCoId;
	@Column(name = "contact_number", nullable = false)
	private String contactNumber;
	@Column(name = "is_active", nullable = false)
	private String isActive;
	@Column(name = "auth_status", nullable = false)
	private String authStatus;
	
	public String getCbsBranchCode() {
		return cbsBranchCode;
	}
	public void setCbsBranchCode(String cbsBranchCode) {
		this.cbsBranchCode = cbsBranchCode;
	}
	public String getCbsGroupId() {
		return cbsGroupId;
	}
	public void setCbsGroupId(String cbsGroupId) {
		this.cbsGroupId = cbsGroupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getCbsCoId() {
		return cbsCoId;
	}
	public void setCbsCoId(String cbsCoId) {
		this.cbsCoId = cbsCoId;
	}
	public String getIbsCoId() {
		return ibsCoId;
	}
	public void setIbsCoId(String ibsCoId) {
		this.ibsCoId = ibsCoId;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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
