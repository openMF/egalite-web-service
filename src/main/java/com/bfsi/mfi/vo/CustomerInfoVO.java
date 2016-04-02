package com.bfsi.mfi.vo;

import java.util.Date;
import java.util.List;

import com.bfsi.mfi.entity.CustomerInfo;
import com.bfsi.mfi.entity.Document;

public class CustomerInfoVO extends MaintenanceVO<CustomerInfo> {
	public CustomerInfoVO() {
		entity = new CustomerInfo();
	}

	public CustomerInfoVO(CustomerInfo entity) {
		super(entity);
	}

	public String getEnrollmentId() {
		return super.getId();
	}

	public void setEnrollmentId(String enrollmentId) {
		super.setId(enrollmentId);
	}

	public String getAccountType() {
		return entity.getAccountType();
	}

	public void setAccountType(String accountType) {
		entity.setAccountType(accountType);
	}

	public String getAccTypeRemark() {
		return entity.getAccTypeRemark();
	}

	public void setAccTypeRemark(String accTypeRemark) {
		entity.setAccTypeRemark(accTypeRemark);
	}

	public String getFirstName() {
		return entity.getFirstName();
	}

	public void setFirstName(String firstName) {
		entity.setFirstName(firstName);
	}

	public String getLastName() {
		return entity.getLastName();
	}

	public void setLastName(String lastName) {
		entity.setLastName(lastName);
	}

	public String getMiddleName() {
		return entity.getMiddleName();
	}

	public void setMiddleName(String middleName) {
		entity.setMiddleName(middleName);
	}

	public String getGender() {
		return entity.getGender();
	}

	public void setGender(String gender) {
		entity.setGender(gender);
	}

	public Date getDob() {
		return entity.getDob();
	}

	public void setDob(Date dob) {
		entity.setDob(dob);
	}

	public String getAddress1() {
		return entity.getAddress1();
	}

	public void setAddress1(String address1) {
		entity.setAddress1(address1);
	}

	public String getAddress2() {
		return entity.getAddress2();
	}

	public void setAddress2(String address2) {
		entity.setAddress2(address2);
	}

	public String getEmailId() {
		return entity.getEmailId();
	}

	public void setEmailId(String emailId) {
		entity.setEmailId(emailId);
	}

	public String getContactNumber() {
		return entity.getContactNumber();
	}

	public void setContactNumber(String contactNumber) {
		entity.setContactNumber(contactNumber);
	}

	public String getCountry() {
		return entity.getCountry();
	}

	public void setCountry(String country) {
		entity.setCountry(country);
	}

	public String getState() {
		return entity.getState();
	}

	public void setState(String state) {
		entity.setState(state);
	}

	public String getZipCode() {
		return entity.getZipCode();
	}

	public void setZipCode(String zipCode) {
		entity.setZipCode(zipCode);
	}

	public String getCurrency() {
		return entity.getCurrency();
	}

	public void setCurrency(String currency) {
		entity.setCurrency(currency);
	}

	public String getResidentialType() {
		return entity.getResidentialType();
	}

	public void setResidentialType(String residentialType) {
		entity.setResidentialType(residentialType);
	}

	public String getNationality() {
		return entity.getNationality();
	}

	public void setNationality(String nationality) {
		entity.setNationality(nationality);
	}

	public String getMartialStatus() {
		return entity.getMartialStatus();
	}

	public void setMartialStatus(String martialStatus) {
		entity.setMartialStatus(martialStatus);
	}

	public String getProfession() {
		return entity.getProfession();
	}

	public void setProfession(String profession) {
		entity.setProfession(profession);
	}

	public String getProfessionRemark() {
		return entity.getProfessionRemark();
	}

	public void setProfessionRemark(String professionRemark) {
		entity.setProfessionRemark(professionRemark);
	}

	public List<Document> getDocuments() {
		return entity.getDocuments();
	}

	public void setDocuments(List<Document> documents) {
		entity.setDocuments(documents);
	}

	public Date getEnrollmentdate() {
		return entity.getEnrollmentdate();
	}

	public void setEnrollmentdate(Date enrollmentdate) {
		entity.setEnrollmentdate(enrollmentdate);
	}

	public String getEnrollStaus() {
		return entity.getEnrollStaus();
	}

	public void setEnrollStaus(String enrollStaus) {
		entity.setEnrollStaus(enrollStaus);
	}

	public String getDeviceId() {
		return entity.getDeviceId();
	}

	public void setDeviceId(String deviceId) {
		entity.setDeviceId(deviceId);
	}

	public Date getSyncTime() {
		return entity.getSyncTime();
	}

	public void setSyncTime(Date syncTime) {
		entity.setSyncTime(syncTime);
	}

}
