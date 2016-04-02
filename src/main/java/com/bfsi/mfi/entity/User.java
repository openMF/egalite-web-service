package com.bfsi.mfi.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User entity
 * 
 * @author arun
 * 
 */
@Entity(name = "MFI_USERS")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User extends MaintenanceEntity 
{
	private String firstName;
	private String lastName;
	private String branchCode;
	private Date dob;
	private String gender;
	private Address commAddress;
	private Address permAddress;
	private String mobile;
	private String emailId;
	private String password;
	private String userType;
	private String userStatus;
	private Date startDate = new Date();
	private Date endDate;
	private Integer noOfFailedLogins;
	private Date lastLoginDate;
	private String prevPassword1;
	private String prevPassword2;
	private String cPassword;
	private String newPassword;
	private String sessionId;
	
	private String cbsCoCode;
	
	private List<String> roles = new ArrayList<String>();
	private List<Role> listRoles = new ArrayList<Role>();

	
	public String getCbsCoCode() {
		return cbsCoCode;
	}

	public void setCbsCoCode(String cbsCoCode) {
		this.cbsCoCode = cbsCoCode;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	public String getCommAddr1() {
		return (commAddress == null) ? "" : commAddress.getAddrLine1();
	}

	public void setCommAddr1(String commAddr1) {
		if (commAddress == null) {
			commAddress = new Address();
		}
		commAddress.setAddrLine1(commAddr1);
	}

	public String getCommAddr2() {
		return (commAddress == null) ? "" : commAddress.getAddrLine2();
	}

	public void setCommAddr2(String commAddr2) {
		if (commAddress == null) {
			commAddress = new Address();
		}
		commAddress.setAddrLine2(commAddr2);
	}

	public String getCommAddr3() {
		return (commAddress == null) ? "" : commAddress.getAddrLine3();
	}

	public void setCommAddr3(String commAddr3) {
		if (commAddress == null) {
			commAddress = new Address();
		}
		commAddress.setAddrLine3(commAddr3);
	}

	public String  getCommAddr4() {
		return (commAddress == null) ? "" : commAddress.getAddrLine4();
	}

	public void setCommAddr4(String commAddr4) {
		if (commAddress == null) {
			commAddress = new Address();
		}
		commAddress.setAddrLine4(commAddr4);
	}

	public String getPermAddr1() {
		return (permAddress == null) ? "" : permAddress.getAddrLine1();
	}

	public void setPermAddr1(String permAddr1) {
		if (permAddress == null) {
			permAddress = new Address();
		}
		permAddress.setAddrLine1(permAddr1);
	}

	public String getPermAddr2() {
		return (permAddress == null) ? "" : permAddress.getAddrLine2();
	}

	public void setPermAddr2(String permAddr2) {
		if (permAddress == null) {
			permAddress = new Address();
		}
		permAddress.setAddrLine2(permAddr2);
	}

	public String getPermAddr3() {
		return (permAddress == null) ? "" : permAddress.getAddrLine3();
	}

	public void setPermAddr3(String permAddr3) {
		if (permAddress == null) {
			permAddress = new Address();
		}
		permAddress.setAddrLine3(permAddr3);
	}

	public String getPermAddr4() {
		return (permAddress == null) ? "" : permAddress.getAddrLine4();
	}

	public void setPermAddr4(String permAddr4) {
		if (permAddress == null) {
			permAddress = new Address();
		}
		permAddress.setAddrLine4(permAddr4);
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getNoOfFailedLogins() {
		return noOfFailedLogins;
	}

	public void setNoOfFailedLogins(Integer noOfFailedLogins) {
		this.noOfFailedLogins = noOfFailedLogins;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getPrevPassword1() {
		return prevPassword1;
	}

	public void setPrevPassword1(String prevPassword1) {
		this.prevPassword1 = prevPassword1;
	}

	public String getPrevPassword2() {
		return prevPassword2;
	}

	public void setPrevPassword2(String prevPassword2) {
		this.prevPassword2 = prevPassword2;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<Role> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<Role> listRoles) {
		this.listRoles = listRoles;
	}

}