package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "mfi_center_codes")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CenterCodes extends MaintenanceEntity {
	public CenterCodes() {
	}

	@Column(name = "cbs_center_code", nullable = false)
	private String cbsCenterCode;
	@Column(name = "ibs_location_code", nullable = false)
	private String ibsLocationCode;
	@Column(name = "center_code_desc", nullable = false)
	private String centerCodeDesc;
	@Column(name = "cbs_branch_code", nullable = false)
	private String cbsBranchCode;
	@Column(name = "contact_number", nullable = false)
	private String contactNumber;
	@Column(name = "on_sunday", nullable = false)
	private boolean onSunday;
	@Column(name = "on_monday", nullable = false)
	private boolean onMonday;
	@Column(name = "on_tuesday", nullable = false)
	private boolean onTuesday;
	@Column(name = "on_wednesday", nullable = false)
	private boolean onWednesday;
	@Column(name = "on_thursday", nullable = false)
	private boolean onThursday;
	@Column(name = "on_friday", nullable = false)
	private boolean onFriday;
	@Column(name = "on_saturday", nullable = false)
	private boolean onSaturday;
	@Column(name = "address_line_1", nullable = false)
	private String addressLine1;
	@Column(name = "address_line2", nullable = false)
	private String addressLine2;
	@Column(name = "address_line_3", nullable = false)
	private String addressLine3;
	@Column(name = "address_line_4", nullable = false)
	private String addressLine4;
	@Column(name = "zip_code", nullable = false)
	private String zipCode;
	@Column(name = "city", nullable = false)
	private String city;
	@Column(name = "state", nullable = false)
	private String state;
	@Column(name = "country", nullable = false)
	private String country;
	@Column(name = "is_active", nullable = false)
	private String isActive;
	@Column(name = "auth_status", nullable = false)
	private String authStatus;
	
	
	/*For Tag No: EGA-MN15-000004 Starts*/
	
	@Column(name = "CODE_TYPE", nullable = false)
	private String codeType;
	@Column(name = "CODE_VALUE", nullable = false)
	private String codeValue;
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	@Column(name = "ISO_EQUIVALENT_CODE", nullable = false)
	private String isoEquivalentCode;
	/*For Tag No: EGA-MN15-000004 Ends*/
	
	private String onFridayStr;
	private String onSundayStr;
	private String onMondayStr;
	private String onTuesdayStr;
	private String onWednesdayStr;
	private String onThursdayStr;
	private String onSaturdayStr;
	
	
	
	
	public String getOnSundayStr() {
		return onSundayStr;
	}
	public void setOnSundayStr(String onSundayStr) {
		if(onSundayStr.equals("0"))
			onSunday= false;
		else
			onSunday= true;
		
		this.onSundayStr = onSundayStr;
	}
	public String getOnMondayStr() {
		return onMondayStr;
	}
	public void setOnMondayStr(String onMondayStr) {
		if(onMondayStr.equals("0"))
			onMonday= false;
		else
			onMonday= true;
		
		this.onMondayStr = onMondayStr;
	}
	public String getOnTuesdayStr() {
		return onTuesdayStr;
	}
	public void setOnTuesdayStr(String onTuesdayStr) {
		if(onTuesdayStr.equals("0"))
			onTuesday= false;
		else
			onTuesday= true;
		
		this.onTuesdayStr = onTuesdayStr;
	}
	public String getOnWednesdayStr() {
		return onWednesdayStr;
	}
	public void setOnWednesdayStr(String onWednesdayStr) {
		if(onWednesdayStr.equals("0"))
			onWednesday= false;
		else
			onWednesday= true;
		
		this.onWednesdayStr = onWednesdayStr;
	}
	public String getOnThursdayStr() {
		return onThursdayStr;
	}
	public void setOnThursdayStr(String onThursdayStr) {
		if(onThursdayStr.equals("0"))
			onThursday= false;
		else
			onThursday= true;
		
		this.onThursdayStr = onThursdayStr;
	}
	public String getOnSaturdayStr() {
		return onSaturdayStr;
	}
	public void setOnSaturdayStr(String onSaturdayStr) {
		if(onSaturdayStr.equals("0"))
			onSaturday= false;
		else
			onSaturday= true;
		
		this.onSaturdayStr = onSaturdayStr;
	}
	public String getOnFridayStr() {
		return onFridayStr;
	}
	public void setOnFridayStr(String onFridayStr) {
		
		if(onFridayStr.equals("0"))
			onFriday= false;
		else
			onFriday= true;
		
		this.onFridayStr = onFridayStr;
	}
	public String getCbsCenterCode() {
		return cbsCenterCode;
	}
	public void setCbsCenterCode(String cbsCenterCode) {
		this.cbsCenterCode = cbsCenterCode;
	}
	public String getIbsLocationCode() {
		return ibsLocationCode;
	}
	public void setIbsLocationCode(String ibsLocationCode) {
		this.ibsLocationCode = ibsLocationCode;
	}
	public String getCenterCodeDesc() {
		return centerCodeDesc;
	}
	public void setCenterCodeDesc(String centerCodeDesc) {
		this.centerCodeDesc = centerCodeDesc;
	}
	public String getCbsBranchCode() {
		return cbsBranchCode;
	}
	public void setCbsBranchCode(String cbsBranchCode) {
		this.cbsBranchCode = cbsBranchCode;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public boolean getOnSunday() {
		return onSunday;
	}
	public void setOnSunday(boolean onSunday) {
		this.onSunday = onSunday;
		
		if(onSunday)
			onSundayStr="1";
		else
			onSundayStr="0";
	}
	public boolean getOnMonday() {
		return onMonday;
	}
	public void setOnMonday(boolean onMonday) {
		this.onMonday = onMonday;
		
		if(onMonday)
			onMondayStr="1";
		else
			onMondayStr="0";
	}
	public boolean getOnTuesday() {
		return onTuesday;
	}
	public void setOnTuesday(boolean onTuesday) {
		this.onTuesday = onTuesday;
		
		if(onTuesday)
			onTuesdayStr="1";
		else
			onTuesdayStr="0";
	}
	public boolean getOnWednesday() {
		return onWednesday;
	}
	public void setOnWednesday(boolean onWednesday) {
		this.onWednesday = onWednesday;
		
		if(onWednesday)
			onWednesdayStr="1";
		else
			onWednesdayStr="0";
	}
	public boolean getOnThursday() {
		return onThursday;
	}
	public void setOnThursday(boolean onThursday) {
		this.onThursday = onThursday;
		
		if(onThursday)
			onThursdayStr="1";
		else
			onThursdayStr="0";
	}
	public boolean getOnFriday() {
		return onFriday;
	}
	public void setOnFriday(boolean onFriday) {
		this.onFriday = onFriday;
		
		if(onFriday)
			onFridayStr="1";
		else
			onFridayStr="0";
	}
	public boolean getOnSaturday() {
		return onSaturday;
	}
	public void setOnSaturday(boolean onSaturday) {
		this.onSaturday = onSaturday;
		
		if(onSaturday)
			onSaturdayStr="1";
		else
			onSaturdayStr="0";
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
	/*public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}*/
	
	public String getAddressLine3() {
		return (addressLine3 == null) ? "" : addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
	if(addressLine3 == null )
		this.addressLine3 = " ";
	else
		this.addressLine3 = addressLine3;
		
		
	}
	
	public String getAddressLine4() {
		return addressLine4;
	}
	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
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

	/*Tag No: EGA-MN15-000004 Starts*/

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsoEquivalentCode() {
		return isoEquivalentCode;
	}

	public void setIsoEquivalentCode(String isoEquivalentCode) {
		this.isoEquivalentCode = isoEquivalentCode;
	}
	/*Tag No: EGA-MN15-000004 Ends*/
}
	