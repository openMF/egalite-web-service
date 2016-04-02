package com.bfsi.mfi.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.User;
import com.bfsi.mfi.util.MessageUtil;

/**
 * User Value Object to be bound to the screen
 * 
 * @author arun
 * 
 */
public class UserVO extends MaintenanceVO<User>
{

	public UserVO() {
		entity = new User();
	}
	
	public UserVO(User entity) {
		super(entity);
	}

	private List<String> roles = new ArrayList<String>();
	private List<RoleVO> allocatedRoles = new ArrayList<RoleVO>();
	private String userStatusText;
	
	public String getUserStatusText() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (getUserStatus().equalsIgnoreCase("A")) {
			userStatusText = MessageUtil.getMessage("device.active",context);
			return userStatusText;
		}	else if (getUserStatus().equalsIgnoreCase("F")) {
			userStatusText = MessageUtil.getMessage("device.new",context);
			return userStatusText;
		}	else {
			userStatusText = MessageUtil.getMessage("device.inActive",context);
			return userStatusText;
		}
	}
	
	public String getCbsCoCode() {
		return entity.getCbsCoCode();
	}

	public void setCbsCoCode(String cbsCoCode) {
		entity.setCbsCoCode(cbsCoCode);
	}

	public void setUserStatusText(String userStatusText) {
		this.userStatusText = userStatusText;
	}

	public String getFirstName() {
		return entity.getFirstName();
	}

	public void setFirstName(String firstName) {
		entity.setFirstName(firstName);
	}

	public String getcPassword() {
		return entity.getcPassword();
	}

	public void setcPassword(String cPassword) {
		entity.setcPassword(cPassword);
	}
	
	public String getNewPassword() {
		return entity.getNewPassword();
	}

	public void setNewPassword(String newPassword) {
		entity.setNewPassword(newPassword);
	}
	public String getLastName() {
		return entity.getLastName();
	}

	public void setLastName(String lastName) {
		entity.setLastName(lastName);
	}

	public String getCommAddr1() {
		return ("".equals(entity.getCommAddr1())) ? "" : entity.getCommAddr1();
	}

	public void setCommAddr1(String commAddr1) {
		entity.setCommAddr1(commAddr1);
	}

	public String getCommAddr2() {
		return ("".equals(entity.getCommAddr2())) ? "" : entity.getCommAddr2();
	}

	public void setCommAddr2(String commAddr2) {
		entity.setCommAddr2(commAddr2);
	}

	public String getCommAddr3() {
		return ("".equals(entity.getCommAddr3())) ? "" : entity.getCommAddr3();
	}

	public void setCommAddr3(String commAddr3) {
		entity.setCommAddr3(commAddr3);
	}

	public String getCommAddr4() {
		return ("".equals(entity.getCommAddr4())) ? "" : entity.getCommAddr4();
	}

	public void setCommAddr4(String commAddr4) {
		entity.setCommAddr4(commAddr4);
	}
	
	public String getPermAddr1() {
		return ("".equals(entity.getPermAddr1())) ? "" : entity.getPermAddr1();
	}

	public void setPermAddr1(String PermAddr) {
		entity.setPermAddr1(PermAddr);
	}

	public String getPermAddr2() {
		return ("".equals(entity.getPermAddr2())) ? "" : entity.getPermAddr2();
	}

	public void setPermAddr2(String PermAddr2) {
		entity.setPermAddr2(PermAddr2);
	}

	public String getPermAddr3() {
		return ("".equals(entity.getPermAddr3())) ? "" : entity.getPermAddr3();
	}

	public void setPermAddr3(String PermAddr3) {
		entity.setPermAddr3(PermAddr3);
	}

	public String getPermAddr4() {
		return ("".equals(entity.getPermAddr4())) ? "" : entity.getPermAddr4();
	}

	public void setPermAddr4(String PermAddr4) {
		entity.setPermAddr4(PermAddr4);
	}

	public String getBranchCode() {
		return entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode);
	}

	public Date getDob() {
		return entity.getDob();
	}

	public void setDob(Date dob) {
		entity.setDob(dob);
	}

	public String getGender() {
		return entity.getGender();
	}

	public void setGender(String gender) {
		entity.setGender(gender);
	}

	public String getMobile() {
		return entity.getMobile();
	}

	public void setMobile(String mobile) {
		entity.setMobile(mobile);
	}

	public String getEmailId() {
		return entity.getEmailId();
	}

	public void setEmailId(String emailId) {
		entity.setEmailId(emailId);
	}

	public String getPassword() {
		return entity.getPassword();
	}

	public void setPassword(String password) {
		entity.setPassword(password);
	}

	public String getUserType() {
		return entity.getUserType() == null?"1":entity.getUserType();
	}

	public void setUserType(String userType) {
		entity.setUserType(userType);
	}

	public String getUserStatus() {

		return entity.getUserStatus();
	}

	public void setUserStatus(String userStatus) {
		entity.setUserStatus(userStatus);
	}

	public Date getStartDate() {
		return entity.getStartDate();
	}

	public void setStartDate(Date startDate) {
		entity.setStartDate(startDate);
	}

	public Date getEndDate() {
		return entity.getEndDate();
	}

	public void setEndDate(Date endDate) {
		entity.setEndDate(endDate);
	}

	public Integer getNoOfFailedLogins() {
		return entity.getNoOfFailedLogins();
	}

	public void setNoOfFailedLogins(Integer noOfFailedLogins) {
		entity.setNoOfFailedLogins(noOfFailedLogins);
	}

	public Date getLastLoginDate() {
		return entity.getLastLoginDate();
	}

	public void setLastLoginDate(Date lastLoginDate) {
		entity.setLastLoginDate(lastLoginDate);
	}

	public String getPrevPassword1() {
		return entity.getPrevPassword1();
	}

	public void setPrevPassword1(String prevPassword1) {
		entity.setPrevPassword1(prevPassword1);
	}

	public String getPrevPassword2() {
		return entity.getPrevPassword2();
	}

	public void setPrevPassword2(String prevPassword2) {
		entity.setPrevPassword2(prevPassword2);
	}

	public String getAuthStatus() {
		return entity.getAuthStatus();
	}

	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus);
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<RoleVO> getAllocatedRoles() {
		return allocatedRoles;
	}

	public void setAllocatedRoles(List<RoleVO> allocatedRoles) {
		this.allocatedRoles = allocatedRoles;
	}

	public Object clone() {
		UserVO copyObj = new UserVO();
		copyObj.setBranchCode(this.getBranchCode());
		copyObj.setFirstName(this.getFirstName());
		copyObj.setLastName(this.getLastName());
		copyObj.setPassword(this.getPassword());
		copyObj.setDob(this.getDob());
		copyObj.setGender(this.getGender());
		copyObj.setMobile(this.getMobile());
		copyObj.setEmailId(this.getEmailId());
		copyObj.setStartDate(this.getStartDate());
		copyObj.setEndDate(this.getEndDate());
		copyObj.setUserStatus(this.getUserStatus());
		copyObj.setCommAddr1(this.getCommAddr1());
		copyObj.setCommAddr2(this.getCommAddr2());
		copyObj.setCommAddr3(this.getCommAddr3());
		copyObj.setCommAddr4(this.getCommAddr4());
		copyObj.setPermAddr1(this.getPermAddr1());
		copyObj.setPermAddr2(this.getPermAddr2());
		copyObj.setPermAddr3(this.getPermAddr3());
		copyObj.setPermAddr4(this.getPermAddr4());
		copyObj.setUserType(this.getUserType());
		copyObj.setCbsCoCode(this.getCbsCoCode());
		
		return copyObj;
	}
}
