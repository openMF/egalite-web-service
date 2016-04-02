package com.bfsi.mfi.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "MFI_AGENTS")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Agent extends MaintenanceEntity {
	public Agent() {
	}

	@Column(name = "AGENT_TYPE", nullable = false)
	private String agentType;
	@Column(name = "CREDIT_OFFICER_ID", nullable = false)
	private String creditOfficer;
	@Column(name = "CASH_LIMIT", nullable = false)
	private long cashLimit;
	@Column(name = "DEVICE_ID", nullable = false)
	private String deviceId;
	@Column(name = "IS_ACTIVE", nullable = false)
	private String isActive;
	@Column(name = "FIRST_NAME", nullable = false)
	private String fname;
	@Column(name = "LAST_NAME", nullable = false)
	private String lname;
	@Column(name = "DATE_OF_BIRTH", nullable = false)
	private Date dob;
	@Column(name = "GENDER", nullable = false)
	private String gender;
	@Column(name = "COMM_ADDRESS1", nullable = false)
	private Address commAddress;
	@Column(name = "CONTACT_NUMBER", nullable = false)
	private String contactNumber;
	@Column(name = "EMAIL_ADDRESS", nullable = false)
	private String emailAddress;
	@Column(name = "AGENT_START_DATE", nullable = false)
	private Date startDate = new Date();
	@Column(name = "AGENT_END_DATE", nullable = false)
	private Date endDate;
	@Column(name = "AGENT_PREFERED_LANG", nullable = false)
	private String agentLang;
	@Column(name = "ROLE_ID", nullable = false)
	private String roleId;
	@Column(name = "AGENCY_CODE", nullable = false)
	private String agencyCode;
	@Column(name = "AUTH_STATUS", nullable = false)
	private String authStatus;
	@Column(name = "USER_NAME", nullable = false)
	private String userName;
	@Column(name = "DATA_KEY", nullable = false)
	private String dataValue;
	@Column(name = "REG_KEY", nullable = false)
	private String regKey;
	@Column(name = "REG_KEY_EXPIRY_TIME", nullable = false)
	private Date regKeyExpiryTime;
	@Column(name = "ZIP_CODE", nullable = false)
	private String zipCode;
	@Column(name = "CITY", nullable = false)
	private String city;
	@Column(name = "STATE", nullable = false)
	private String state;
	@Column(name = "COUNTRY", nullable = false)
	private String country;
	@Column(name = "LOCATION_CODE", nullable = false)
	private String locationCode;
	
	// for country code
	@Column(name = "COUNTRY_CODE", nullable = false)
	private String countryCode;
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	@Column(name = "ISO_NUM_COUNTRY_CODE", nullable = false)
	private String iso;
	
	
	@Column(name = "CBS_AGENT_CODE", nullable = false)
	private String cbsagentcode;
	@Column(name = "AGENT_ACC_ID", nullable = false)
	private String agentAccId;
	
	@Column(name = "EXTERNAL_DEVICEID", nullable = false)
	private String externalDeviceId;
	
	private List<Role> listRoles = new ArrayList<Role>();
	private List<String> roles = new ArrayList<String>();
	
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

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	private String regStatus;

	public String getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}

	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public String getRegKey() {
		return regKey;
	}

	public void setRegKey(String regkey) {
		this.regKey = regkey;
	}

	public Date getRegKeyExpiryTime() {
		return regKeyExpiryTime;
	}

	public void setRegKeyExpiryTime(Date regKeyExpiryTime) {
		this.regKeyExpiryTime = regKeyExpiryTime;
	}

	public Address getCommAddress() {
		return commAddress;
	}

	public void setCommAddress(Address commAddress) {
		this.commAddress = commAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getCreditOfficer() {
		return creditOfficer;
	}

	public void setCreditOfficer(String creditOfficer) {
		this.creditOfficer = creditOfficer;
	}

	public long getCashLimit() {
		return cashLimit;
	}

	public void setCashLimit(long cashLimit) {
		this.cashLimit = cashLimit;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}


	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	public String getCommAddr4() {
		return (commAddress == null) ? "" : commAddress.getAddrLine4();
	}

	public void setCommAddr4(String commAddr4) {
		if (commAddress == null) {
			commAddress = new Address();
		}
		commAddress.setAddrLine4(commAddr4);
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public String getAgentLang() {
		return agentLang;
	}

	public void setAgentLang(String agentLang) {
		this.agentLang = agentLang;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getCbsagentcode() {
		return cbsagentcode;
	}

	public void setCbsagentcode(String cbsagentcode) {
		this.cbsagentcode = cbsagentcode;
	}

	public String getAgentAccId() {
		return agentAccId;
	}

	public void setAgentAccId(String agentAccId) {
		this.agentAccId = agentAccId;
	}
	
	public String getExternalDeviceId() {
		return externalDeviceId;
	}

	public void setExternalDeviceId(String externalDeviceId) {
		this.externalDeviceId = externalDeviceId;
	}
}