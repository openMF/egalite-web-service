package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "MFI_AGENCIES")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Agency extends MaintenanceEntity {
	public Agency() {
	}

	@Column(name = "AGENCY_DESC", nullable = false)
	private String agencyDesc;
	@Column(name = "ADDRESS1", nullable = false)
	private String address1;
	@Column(name = "ADDRESS2", nullable = false)
	private String address2;
	@Column(name = "ADDRESS3", nullable = false)
	private String address3;
	@Column(name = "ADDRESS4", nullable = false)
	private String address4;
	@Column(name = "CONTACT_NUMBER", nullable = false)
	private String contactNumber;
	@Column(name = "AUTH_STATUS", nullable = false)
	private String authStatus;
	@Column(name = "IS_ACTIVE", nullable = false)
	private String isActive;
	@Column(name = "CATEGORY", nullable = false)
	private String category;
	@Column(name = "ALLOCATED_CO", nullable = false)
	private String allocatedCo;
	@Column(name = "ZIP_CODE", nullable = false)
	private String zipCode;
	@Column(name = "CITY", nullable = false)
	private String city;
	@Column(name = "STATE", nullable = false)
	private String state;
	@Column(name = "COUNTRY", nullable = false)
	private String country;
	@Column(name = "EMAIL_ADDRESS", nullable = false)
	private String emailAddress;
	// for country code
	@Column(name = "COUNTRY_CODE", nullable = false)
	private String countryCode;
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	@Column(name = "ISO_NUM_COUNTRY_CODE", nullable = false)
	private String iso;
	


	public String getAgencyDesc() {
		return agencyDesc;
	}

	public void setAgencyDesc(String agencyDesc) {
		this.agencyDesc = agencyDesc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAllocatedCo() {
		return allocatedCo;
	}

	public void setAllocatedCo(String allocatedCo) {
		this.allocatedCo = allocatedCo;
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

	/*	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}*/
	
	public String getAddress3() {
		return (address3 == null) ? "" : address3;
	}

	public void setAddress3(String address3) {
	if(address3 == null )
		this.address3 = " ";
	else
		this.address3 = address3;
		
		
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
// for Country code

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
	
}