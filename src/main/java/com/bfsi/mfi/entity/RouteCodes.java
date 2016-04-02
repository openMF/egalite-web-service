package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "mfi_route_codes")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RouteCodes extends MaintenanceEntity {
	public RouteCodes() {
	}

	@Column(name = "cbs_route_code", nullable = false)
	private String cbsRouteCode;
	@Column(name = "ibs_location_code", nullable = false)
	private String ibsLocationCode;
	@Column(name = "route_code_desc", nullable = false)
	private String routeCodeDesc;
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
	@Column(name = "frm_address_line_1", nullable = false)
	private String frmAddressLine1;
	@Column(name = "frm_address_line2", nullable = false)
	private String frmAddressLine2;
	@Column(name = "frm_address_line_3", nullable = false)
	private String frmAddressLine3;
	@Column(name = "frm_address_line_4", nullable = false)
	private String frmAddressLine4;
	@Column(name = "frm_zip_code", nullable = false)
	private String frmZipCode;
	@Column(name = "frm_city", nullable = false)
	private String frmCity;
	@Column(name = "frm_state", nullable = false)
	private String frmState;
	@Column(name = "frm_country", nullable = false)
	private String frmCountry;
	@Column(name = "to_address_line_1", nullable = false)
	private String toAddressLine1;
	@Column(name = "to_address_line_2", nullable = false)
	private String toAddressLine2;
	@Column(name = "to_address_line_3", nullable = false)
	private String toAddressLine3;
	@Column(name = "to_address_line_4", nullable = false)
	private String toAddressLine4;
	@Column(name = "to_zip_code", nullable = false)
	private String toZipCode;
	@Column(name = "to_city", nullable = false)
	private String toCity;
	@Column(name = "to_state", nullable = false)
	private String toState;
	@Column(name = "to_country", nullable = false)
	private String toCountry;
	@Column(name = "is_active", nullable = false)
	private String isActive;
	@Column(name = "auth_status", nullable = false)
	private String authStatus;

	private String onFridayStr;
	private String onSundayStr;
	private String onMondayStr;
	private String onTuesdayStr;
	private String onWednesdayStr;
	private String onThursdayStr;
	private String onSaturdayStr;
	
	/*For Tag No: EGA-MN15-000002 Starts*/
	
	@Column(name = "CODE_TYPE", nullable = false)
	private String codeType;
	@Column(name = "CODE_VALUE", nullable = false)
	private String codeValue;
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	@Column(name = "ISO_EQUIVALENT_CODE", nullable = false)
	private String isoEquivalentCode;
	/*For Tag No: EGA-MN15-000002 Ends*/

	public String getOnSundayStr() {
		return onSundayStr;
	}

	public void setOnSundayStr(String onSundayStr) {
		if (onSundayStr.equals("0"))
			onSunday = false;
		else
			onSunday = true;

		this.onSundayStr = onSundayStr;
	}

	public String getOnMondayStr() {
		return onMondayStr;
	}

	public void setOnMondayStr(String onMondayStr) {
		if (onMondayStr.equals("0"))
			onMonday = false;
		else
			onMonday = true;

		this.onMondayStr = onMondayStr;
	}

	public String getOnTuesdayStr() {
		return onTuesdayStr;
	}

	public void setOnTuesdayStr(String onTuesdayStr) {
		if (onTuesdayStr.equals("0"))
			onTuesday = false;
		else
			onTuesday = true;

		this.onTuesdayStr = onTuesdayStr;
	}

	public String getOnWednesdayStr() {
		return onWednesdayStr;
	}

	public void setOnWednesdayStr(String onWednesdayStr) {
		if (onWednesdayStr.equals("0"))
			onWednesday = false;
		else
			onWednesday = true;

		this.onWednesdayStr = onWednesdayStr;
	}

	public String getOnThursdayStr() {
		return onThursdayStr;
	}

	public void setOnThursdayStr(String onThursdayStr) {
		if (onThursdayStr.equals("0"))
			onThursday = false;
		else
			onThursday = true;

		this.onThursdayStr = onThursdayStr;
	}

	public String getOnSaturdayStr() {
		return onSaturdayStr;
	}

	public void setOnSaturdayStr(String onSaturdayStr) {
		if (onSaturdayStr.equals("0"))
			onSaturday = false;
		else
			onSaturday = true;

		this.onSaturdayStr = onSaturdayStr;
	}

	public String getOnFridayStr() {
		return onFridayStr;
	}

	public void setOnFridayStr(String onFridayStr) {

		if (onFridayStr.equals("0"))
			onFriday = false;
		else
			onFriday = true;

		this.onFridayStr = onFridayStr;
	}

	public String getCbsRouteCode() {
		return cbsRouteCode;
	}

	public void setCbsRouteCode(String cbsRouteCode) {
		this.cbsRouteCode = cbsRouteCode;
	}

	public String getIbsLocationCode() {
		return ibsLocationCode;
	}

	public void setIbsLocationCode(String ibsLocationCode) {
		this.ibsLocationCode = ibsLocationCode;
	}

	public String getRouteCodeDesc() {
		return routeCodeDesc;
	}

	public void setRouteCodeDesc(String routeCodeDesc) {
		this.routeCodeDesc = routeCodeDesc;
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

		if (onSunday)
			onSundayStr = "1";
		else
			onSundayStr = "0";
	}

	public boolean getOnMonday() {
		return onMonday;
	}

	public void setOnMonday(boolean onMonday) {
		this.onMonday = onMonday;

		if (onMonday)
			onMondayStr = "1";
		else
			onMondayStr = "0";
	}

	public boolean getOnTuesday() {
		return onTuesday;
	}

	public void setOnTuesday(boolean onTuesday) {
		this.onTuesday = onTuesday;

		if (onTuesday)
			onTuesdayStr = "1";
		else
			onTuesdayStr = "0";
	}

	public boolean getOnWednesday() {
		return onWednesday;
	}

	public void setOnWednesday(boolean onWednesday) {
		this.onWednesday = onWednesday;

		if (onWednesday)
			onWednesdayStr = "1";
		else
			onWednesdayStr = "0";
	}

	public boolean getOnThursday() {
		return onThursday;
	}

	public void setOnThursday(boolean onThursday) {
		this.onThursday = onThursday;

		if (onThursday)
			onThursdayStr = "1";
		else
			onThursdayStr = "0";
	}

	public boolean getOnFriday() {
		return onFriday;
	}

	public void setOnFriday(boolean onFriday) {
		this.onFriday = onFriday;

		if (onFriday)
			onFridayStr = "1";
		else
			onFridayStr = "0";
	}

	public boolean getOnSaturday() {
		return onSaturday;
	}

	public void setOnSaturday(boolean onSaturday) {
		this.onSaturday = onSaturday;

		if (onSaturday)
			onSaturdayStr = "1";
		else
			onSaturdayStr = "0";
	}

	public String getFrmAddressLine1() {
		return frmAddressLine1;
	}

	public void setFrmAddressLine1(String frmAddressLine1) {
		this.frmAddressLine1 = frmAddressLine1;
	}

	public String getFrmAddressLine2() {
		return frmAddressLine2;
	}

	public void setFrmAddressLine2(String frmAddressLine2) {
		this.frmAddressLine2 = frmAddressLine2;
	}

	/*
	 * public String getFrmAddressLine3() { return frmAddressLine3; } public
	 * void setFrmAddressLine3(String frmAddressLine3) { this.frmAddressLine3 =
	 * frmAddressLine3; }
	 */
	public String getFrmAddressLine3() {
		return (frmAddressLine3 == null) ? "" : frmAddressLine3;
	}

	public void setFrmAddressLine3(String frmAddressLine3) {
		if (frmAddressLine3 == null)
			this.frmAddressLine3 = " ";
		else
			this.frmAddressLine3 = frmAddressLine3;

	}

	public String getFrmAddressLine4() {
		return frmAddressLine4;
	}

	public void setFrmAddressLine4(String frmAddressLine4) {
		this.frmAddressLine4 = frmAddressLine4;
	}

	public String getFrmZipCode() {
		return frmZipCode;
	}

	public void setFrmZipCode(String frmZipCode) {
		this.frmZipCode = frmZipCode;
	}

	public String getFrmCity() {
		return frmCity;
	}

	public void setFrmCity(String frmCity) {
		this.frmCity = frmCity;
	}

	public String getFrmState() {
		return frmState;
	}

	public void setFrmState(String frmState) {
		this.frmState = frmState;
	}

	public String getFrmCountry() {
		return frmCountry;
	}

	public void setFrmCountry(String frmCountry) {
		this.frmCountry = frmCountry;
	}

	public String getToAddressLine1() {
		return toAddressLine1;
	}

	public void setToAddressLine1(String toAddressLine1) {
		this.toAddressLine1 = toAddressLine1;
	}

	public String getToAddressLine2() {
		return toAddressLine2;
	}

	public void setToAddressLine2(String toAddressLine2) {
		this.toAddressLine2 = toAddressLine2;
	}

	/*
	 * public String getToAddressLine3() { return toAddressLine3; } public void
	 * setToAddressLine3(String toAddressLine3) { this.toAddressLine3 =
	 * toAddressLine3; }
	 */

	public String getToAddressLine3() {
		return (toAddressLine3 == null) ? "" : toAddressLine3;
	}

	public void setToAddressLine3(String toAddressLine3) {
		if (toAddressLine3 == null)
			this.toAddressLine3 = " ";
		else
			this.toAddressLine3 = toAddressLine3;

	}

	public String getToAddressLine4() {
		return toAddressLine4;
	}

	public void setToAddressLine4(String toAddressLine4) {
		this.toAddressLine4 = toAddressLine4;
	}

	public String getToZipCode() {
		return toZipCode;
	}

	public void setToZipCode(String toZipCode) {
		this.toZipCode = toZipCode;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getToState() {
		return toState;
	}

	public void setToState(String toState) {
		this.toState = toState;
	}

	public String getToCountry() {
		return toCountry;
	}

	public void setToCountry(String toCountry) {
		this.toCountry = toCountry;
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
	
	/*Tag No: EGA-MN15-000002 Starts*/

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
	/*Tag No: EGA-MN15-000002 Ends*/
}