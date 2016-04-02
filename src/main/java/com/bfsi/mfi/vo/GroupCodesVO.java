package com.bfsi.mfi.vo;

/**
 * @author Jyoti Ranjan
 * 
 */
import com.bfsi.mfi.entity.GroupCodes;

public class GroupCodesVO extends MaintenanceVO<GroupCodes>{
	public GroupCodesVO() {
		entity = new GroupCodes();
	}

	public GroupCodesVO(GroupCodes entity) {
		super(entity);
	}
	
	
	
	public String getCbsBranchCode() {
		return entity.getCbsBranchCode();
	}
	public void setCbsBranchCode(String cbsBranchCode) {
		entity.setCbsBranchCode(cbsBranchCode);
	}
	public String getCbsGroupId() {
		return entity.getCbsGroupId();
	}
	public void setCbsGroupId(String cbsGroupId) {
		entity.setCbsGroupId(cbsGroupId);
	}
	public String getGroupName() {
		return entity.getGroupName();
	}
	public void setGroupName(String groupName) {
		entity.setGroupName(groupName); 
	}
	public String getCbsCoId() {
		return entity.getCbsCoId();
	}
	public void setCbsCoId(String cbsCoId) {
		entity.setCbsCoId(cbsCoId); 
	}
	public String getIbsCoId() {
		return entity.getIbsCoId();
	}
	public void setIbsCoId(String ibsCoId) {
		entity.setIbsCoId(ibsCoId); 
	}
	public String getContactNumber() {
		return entity.getContactNumber();
	}
	public void setContactNumber(String contactNumber) {
		entity.setContactNumber(contactNumber);
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
	public Object clone() {
		GroupCodesVO copyObj = new GroupCodesVO();
		copyObj.setId(super.getId());
		copyObj.setCbsBranchCode(getCbsBranchCode());
		copyObj.setCbsGroupId(getCbsGroupId());
		copyObj.setGroupName(getGroupName());
		copyObj.setCbsCoId(getCbsCoId());
		copyObj.setIbsCoId(getIbsCoId());
		copyObj.setContactNumber(getContactNumber());
		copyObj.setIsActive(getIsActive());
		copyObj.setAuthStatusText(getAuthStatusText());
		return copyObj;
	}
}
