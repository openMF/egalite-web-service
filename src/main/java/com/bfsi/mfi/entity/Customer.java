package com.bfsi.mfi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "CBS_CUSTOMER_DETAIL")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer extends MaintenanceEntity {
	public Customer() {
	}

	List<Loan> loanList;

	public List<Loan> getLoanList() {
		return loanList;
	}

	public void setLoanList(List<Loan> loanList) {
		this.loanList = loanList;
	}

	@Column(name = "CUSTOMER_FULL_NAME", nullable = false)
	private String customerFullName;

	@Column(name = "CUSTOMER_SHORT_NAME", nullable = false)
	private String customerShortName;

	@Column(name = "CUSTOMER_CATEGORY", nullable = false)
	private String customerCategory;

	@Column(name = "GENDER", nullable = false)
	private String gender;

	@Column(name = "DOB", nullable = false)
	private Date dob;

	@Column(name = "CUSTOMER_SINCE", nullable = false)
	private Date customerSince;

	@Column(name = "LOCATION_CODE", nullable = false)
	private String locationCode;

	@Column(name = "ADDRESS_LINE1", nullable = false)
	private String addressLine1;
	@Column(name = "ADDRESS_LINE2", nullable = false)
	private String addressLine2;
	@Column(name = "ADDRESS_LINE3", nullable = false)
	private String addressLine3;

	@Column(name = "ADDRESS_LINE4", nullable = false)
	private String addressLine4;

	@Column(name = "ZIP_CODE", nullable = false)
	private String zipcode;

	@Column(name = "CITY", nullable = false)
	private String city;

	@Column(name = "STATE", nullable = false)
	private String state;

	@Column(name = "COUNTRY", nullable = false)
	private String country;

	@Column(name = "NATIONALITY", nullable = false)
	private String nationality;
	
	@Column(name = "ALLOCATED_AGENT_ID", nullable = false)
	private String allocatedAgentId;

	@Column(name = "LOCAL_BRANCH_CODE", nullable = false)
	private String localBranchCode;
	@Column(name = "PREFERRED_LANGUAGE", nullable = false)
	private String preferredLanguage;
	@Column(name = "EMAIL_ADDRESS", nullable = false)
	private String emailAddress;
	/*@Column(name = "SMS_REQUIRED", nullable = false)
	private String smsRequired;*/

	@Column(name = "MOBILE_NUMBER", nullable = false)
	private String mobileNumber;

	@Column(name = "CREDIT_OFFICER", nullable = false)
	private String creditOfficer;

	@Column(name = "VIEW_FILE", nullable = false)
	private String viewFile;

	@Column(name = "IMAGE", nullable = false)
	private byte[] image;

	@Column(name = "RECORD_STAT", nullable = false)
	private String recordStat;

	@Column(name = "CBS_UPLD_JOB_ID", nullable = false)
	private String cbsUpldJobId;

	@Column(name = "cbs_group_code", nullable = false)
	private String cbsGroupCode;
	@Column(name = "sms_from_ibs", nullable = false)
	private String smsFromIbs;
	@Column(name = "sms_from_mbs", nullable = false)
	private String smsFromMbs;
	@Column(name = "collect_kyc", nullable = false)
	private String collectKyc;
	@Column(name = "parent_cust_id", nullable = false)
	private String parentCustId;
	@Column(name = "is_parent_cust", nullable = false)
	private String isParentCust;
	
	@Column(name = "GROUP_ID", nullable = false)
	private String groupId;
	
	
	
	/*@Column(name = "SYNC_STATUS", nullable = false)
	private String syncStatus;
	@Column(name = "SYNC_TIME", nullable = false)
	private String syncTime;*/

	/*
	 * @Column(name = "IMAGE", nullable = false) private Blob image;
	 * 
	 * public Blob getImage() { return image; }
	 * 
	 * public void setImage(Blob image) { this.image = image; }
	 */

	public String getCbsGroupCode() {
		return cbsGroupCode;
	}

	public void setCbsGroupCode(String cbsGroupCode) {
		this.cbsGroupCode = cbsGroupCode;
	}

	public String getSmsFromIbs() {
		return smsFromIbs;
	}

	public void setSmsFromIbs(String smsFromIbs) {
		this.smsFromIbs = smsFromIbs;
	}

	public String getSmsFromMbs() {
		return smsFromMbs;
	}

	public void setSmsFromMbs(String smsFromMbs) {
		this.smsFromMbs = smsFromMbs;
	}

	public String getCollectKyc() {
		return collectKyc;
	}

	public void setCollectKyc(String collectKyc) {
		this.collectKyc = collectKyc;
	}

	public String getParentCustId() {
		return parentCustId;
	}

	public void setParentCustId(String parentCustId) {
		this.parentCustId = parentCustId;
	}

	public String getIsParentCust() {
		return isParentCust;
	}

	public void setIsParentCust(String isParentCust) {
		this.isParentCust = isParentCust;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getCustomerShortName() {
		return customerShortName;
	}

	public void setCustomerShortName(String customerShortName) {
		this.customerShortName = customerShortName;
	}

	public String getRecordStat() {
		return recordStat;
	}

	public void setRecordStat(String recordStat) {
		this.recordStat = recordStat;
	}

	public String getCustomerCategory() {
		return customerCategory;
	}

	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAddressLine4() {
		return addressLine4;
	}

	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCustomerId() {
		return super.getId();
	}

	public void setCustomerId(String customerId) {
		super.setId(customerId);
	}

	public String getCustomerFullName() {
		return customerFullName;
	}

	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getViewFile() {
		return viewFile;
	}

	public void setViewFile(String viewFile) {
		this.viewFile = viewFile;
	}

	public String getCreditOfficer() {
		return creditOfficer;
	}

	public String getAllocatedAgentId() {
		return allocatedAgentId;
	}

	public void setAllocatedAgentId(String allocatedAgentId) {
		this.allocatedAgentId = allocatedAgentId;
	}

	public void setCreditOfficer(String creditOfficer) {
		this.creditOfficer = creditOfficer;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getLocalBranchCode() {
		return localBranchCode;
	}

	public void setLocalBranchCode(String localBranchCode) {
		this.localBranchCode = localBranchCode;
	}

	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getCbsUpldJobId() {
		return cbsUpldJobId;
	}

	public void setCbsUpldJobId(String cbsUpldJobId) {
		this.cbsUpldJobId = cbsUpldJobId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Date getCustomerSince() {
		return customerSince;
	}

	public void setCustomerSince(Date customerSince) {
		this.customerSince = customerSince;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	
	
	
}
