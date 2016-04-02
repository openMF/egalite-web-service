package com.bfsi.mfi.entity;

import java.util.Date;
import java.util.List;

public class CustomerInfo extends MaintenanceEntity {
	private String firstName;
	private String lastName;
	private String middleName;
	private String gender;
	private Date dob;
	private String address1;
	private String address2;

	private String emailId;
	private String contactNumber;
	private String country;
	private String state;

	private String zipCode;
	private String currency;
	private String residentialType;
	private String nationality;
	private String martialStatus;
	private String profession;
	private String professionRemark;
	private Date enrollmentdate;
	private String enrollStaus;
	private String deviceId;
	private Date syncTime;
	private String accountType;
	private String accTypeRemark;
	private List<Document> documents;

	public String getAccTypeRemark() {
		return accTypeRemark;
	}

	public void setAccTypeRemark(String accTypeRemark) {
		this.accTypeRemark = accTypeRemark;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getEnrollStaus() {
		return enrollStaus;
	}

	public void setEnrollStaus(String enrollStaus) {
		this.enrollStaus = enrollStaus;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	public Date getEnrollmentdate() {
		return enrollmentdate;
	}

	public void setEnrollmentdate(Date enrollmentdate) {
		this.enrollmentdate = enrollmentdate;
	}

	public String getEnrollmentId() {
		return super.getId();
	}

	public void setEnrollmentId(String enrollmentId) {
		super.setId(enrollmentId);
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getResidentialType() {
		return residentialType;
	}

	public void setResidentialType(String residentialType) {
		this.residentialType = residentialType;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getProfessionRemark() {
		return professionRemark;
	}

	public void setProfessionRemark(String professionRemark) {
		this.professionRemark = professionRemark;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

}
