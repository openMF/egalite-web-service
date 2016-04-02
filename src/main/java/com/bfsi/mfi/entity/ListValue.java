package com.bfsi.mfi.entity;

public class ListValue extends MaintenanceEntity 
{
	public static final String LIST_NAME_AGENT_TYPE = "agentType";
	public static final String LIST_NAME_GENDER = "gender";
	public static final String LIST_NAME_AGENT_STATUS = "isActive";
	public static final String LIST_NAME_AGENT_LANGUAGE = "language";
	public static final String LIST_NAME_AGENT_CUST_CATEGORY = "custCategory";
	public static final String LIST_NAME_AGENT_RELATION_OFFICER = "relOfficer";
	public static final String LIST_NAME_AGENT_HOMEBRANCH = "homeBranch";
	public static final String LIST_NAME_USER_TYPE = "userType";
	public static final String LIST_NAME_KYCID_TYPES = "idType";
	public static final String LIST_NAME_KYCPROOF_TYPES = "prooofType";
	public static final String LIST_NAME_AGENCY_CATEGORY = "category";
	public static final String LIST_NAME_AUTH_STATUS = "authorize";
	public static final String LIST_NAME_DEVICE_TYPE = "deviceType";
	public static final String LIST_NAME_COUNTRY_NAME = "country";
	public static final String LIST_NAME_AGENDA_OPTIONS = "resetOptAgenda";
	public static final String LIST_NAME_KYC_TYPE="KYC01";//Tag no : EGA-MN15-000018
	public static final String LIST_NAME_KYC_TYPE_PRT="PRT01";//Tag no : EGA-MN15-000018 
	public ListValue() {
	}

	// @Column(name = "AGENT_ID", nullable = false)
	private String listName;
	// @Column(name = "AGENT_ID", nullable = false)
	private String listValue;
	// @Column(name = "AGENT_ID", nullable = false)
	private String desn;

	// @Column(name = "AGENT_ID", nullable = false)

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getListValue() {
		return listValue;
	}

	public void setListValue(String listValue) {
		this.listValue = listValue;
	}

	public String getDesn() {
		return desn;
	}

	public void setDesn(String desn) {
		this.desn = desn;
	}
}