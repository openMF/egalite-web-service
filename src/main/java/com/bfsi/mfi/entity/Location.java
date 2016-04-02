package com.bfsi.mfi.entity;

/**
 * Location entity
 * 
 * @author Bablu kumar
 * 
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "MFI_LOCATIONS")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Location extends MaintenanceEntity {
	public Location() {
	}

	@Column(name = "LOCATION_DESC", nullable = false)
	private String locationDesc;
	@Column(name = "CBS_LOCATION_CODE", nullable = false)
	private String cbsLocationCode;
	@Column(name = "CBS_BRANCH_CODE", nullable = false)
	private String cbsBranchCode;
	@Column(name = "ADDRESS1", nullable = false)
	private String address1;
	@Column(name = "ADDRESS2", nullable = false)
	private String address2;
	
	private String address3;
	@Column(name = "ADDRESS4", nullable = false)
	private String address4;
	@Column(name = "ZIP_CODE", nullable = false)
	private String zipCode;
	@Column(name = "CITY", nullable = false)
	private String city;
	@Column(name = "STATE", nullable = false)
	private String state;
	@Column(name = "COUNTRY", nullable = false)
	private String country;
	@Column(name = "CONTACTNUMBER", nullable = false)
	private String contactNumber;
	@Column(name = "AUTH_STATUS", nullable = false)
	private String authStatus;
	@Column(name = "IS_ACTIVE", nullable = false)
	private String isActive;
	// for country code
	@Column(name = "COUNTRY_CODE", nullable = false)
	private String countryCode;
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	@Column(name = "ISO_NUM_COUNTRY_CODE", nullable = false)
	private String iso;
	
/*For Tag No: EGA-MN15-000003 Starts*/
	
	@Column(name = "CODE_TYPE", nullable = false)
	private String codeType;
	@Column(name = "CODE_VALUE", nullable = false)
	private String codeValue;
/*	@Column(name = "DESCRIPTION", nullable = false)
	private String description;*/
	@Column(name = "ISO_EQUIVALENT_CODE", nullable = false)
	private String isoEquivalentCode;
	/*For Tag No: EGA-MN15-000003 Ends*/

	public String getLocationDesc() {
		return locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	public String getCbsLocationCode() {
		return cbsLocationCode;
	}

	public void setCbsLocationCode(String cbsLocationCode) {
		this.cbsLocationCode = cbsLocationCode;
	}

	public String getCbsBranchCode() {
		return cbsBranchCode;
	}

	public void setCbsBranchCode(String cbsBranchCode) {
		this.cbsBranchCode = cbsBranchCode;
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

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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

	// For Currency Code
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
	
	/*Tag No: EGA-MN15-000003 Starts*/

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	/*public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}*/

	public String getIsoEquivalentCode() {
		return isoEquivalentCode;
	}

	public void setIsoEquivalentCode(String isoEquivalentCode) {
		this.isoEquivalentCode = isoEquivalentCode;
	}
	/*Tag No: EGA-MN15-000003 Ends*/

}
