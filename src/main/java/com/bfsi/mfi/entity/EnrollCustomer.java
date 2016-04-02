package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "mfi_cust_enrol_info")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EnrollCustomer extends MaintenanceEntity {

	public EnrollCustomer() {}
	
	@Column(name = "WORKFLOW_Q_TYPE", nullable = false)
	private String workFlowQType;
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	@Column(name = "MIDDLE_NAME", nullable = false)
	private String middleName;
	@Column(name = "DOB", nullable = false)
	private Date dob;
	@Column(name = "GENDER", nullable = false)
	private String gender;
	@Column(name = "RESIDENCE_TYPE", nullable = false)
	private String residentialType;
	@Column(name = "NATIONALITY", nullable = false)
	private String nationality;
	@Column(name = "ADDRESS1", nullable = false)
	private String address1;
	@Column(name = "ADDRESS2", nullable = false)
	private String address2;
	@Column(name = "ADDRESS3", nullable = false)
	private String address3;
	@Column(name = "ADDRESS4", nullable = false)
	private String address4;
	@Column(name = "CITY", nullable = false)
	private String city;
	@Column(name = "STATE", nullable = false)
	private String state;
	@Column(name = "ZIP_CODE", nullable = false)
	private String zipCode;
	@Column(name = "COUNTRY", nullable = false)
	private String country;
	@Column(name = "EMAIL_ID", nullable = false)
	private String emailId;
	@Column(name = "CONTACT_NO", nullable = false)
	private String contactNumber;
	@Column(name = "MARTIAL_STATUS", nullable = false)
	private String martialStatus;
	@Column(name = "PROFESSION", nullable = false)
	private String profession;
	@Column(name = "PROFESSION_REMARK", nullable = false)
	private String professionRemark;
	@Column(name = "ACCOUNT_CATEGORY", nullable = false)
	private String accountCategory;
    @Column(name = "ACCOUNT_TYPE", nullable = true)
	private String accountType;
	@Column(name = "CURRENCY", nullable = false)
	private String currency;
	@Column(name = "IS_ACTIVE", nullable = false)
	private String isActive;
	@Column(name = "MODULE_CODE", nullable = false)
	private String moduleCode;
	@Column(name = "TXN_CODE", nullable = false)
	private String txnCode;
	@Column(name = "TXN_INIT_TIME", nullable = false)
	private Date txnInitTime;
	@Column(name = "TXN_SYNC_TIME", nullable = false)
	private Date txnSyncTime;
	@Column(name = "AGENT_ID", nullable = false)
    private String agentId;
	@Column(name = "DEVICE_ID", nullable = false)
    private String deviceId;
	@Column(name = "LOCATION_CODE", nullable = false)
    private String locationCode;
	@Column(name = "TXN_STATUS", nullable = false)
    private Integer txnStatus;
	@Column(name = "TXN_ERR_CODE", nullable = false)
    private String txnErrCode;
	@Column(name = "TXN_ERR_MESSAGE", nullable = false)
    private String txnErrMessage;
	@Column(name = "AUTH_STATUS", nullable = false)
    private String authStatus;
	
	//add  mfi customer enrol kyc
	private CustEnrolKyc custEnrolKyc = new CustEnrolKyc();
	
	//newly added columns..
	@Column(name = "GROUP_INDIVIDUAL_TYPE", nullable = false)
    private String groupIndividualType;
	@Column(name = "TEMP_GROUP_ID", nullable = false)
    private String tempGroupId;
	@Column(name = "IS_KYC_ONLY", nullable = false)
    private String isKycOnly;
	@Column(name = "CUSTOMER_ID", nullable = false)
    private String customerId;
	@Column(name = "IS_SENT_TO_CBS", nullable = false)
    private String isSentToCbs;
	@Column(name = "CBS_RESPONSE_STAT", nullable = false)
    private String cbsResponseStat;
	@Column(name = "CBS_RESPONSE_TXN_REF_NO", nullable = false)
    private String cbsResponseTxnRefNo;
	@Column(name = "POC", nullable = false)
    private String poc;
	
	
	public String getWorkFlowQType() {
		return workFlowQType;
	}
	public void setWorkFlowQType(String workFlowQType) {
		this.workFlowQType = workFlowQType;
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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public String getAccountCategory() {
		return accountCategory;
	}
	public void setAccountCategory(String accountCategory) {
		this.accountCategory = accountCategory;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getModuleCode() {
		return moduleCode;
	}
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
	public String getTxnCode() {
		return txnCode;
	}
	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}
	public Date getTxnInitTime() {
		return txnInitTime;
	}
	public void setTxnInitTime(Date txnInitTime) {
		this.txnInitTime = txnInitTime;
	}
	public Date getTxnSyncTime() {
		return txnSyncTime;
	}
	public void setTxnSyncTime(Date txnSyncTime) {
		this.txnSyncTime = txnSyncTime;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public Integer getTxnStatus() {
		return txnStatus;
	}
	public void setTxnStatus(Integer txnStatus) {
		this.txnStatus = txnStatus;
	}
	public String getTxnErrCode() {
		return txnErrCode;
	}
	public void setTxnErrCode(String txnErrCode) {
		this.txnErrCode = txnErrCode;
	}
	public String getTxnErrMessage() {
		return txnErrMessage;
	}
	public void setTxnErrMessage(String txnErrMessage) {
		this.txnErrMessage = txnErrMessage;
	}
	
	public String getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}
	
	//kyc geter and setter
	
	public CustEnrolKyc getCustEnrolKyc() {
		return custEnrolKyc;
	}
	public void setCustEnrolKyc(CustEnrolKyc custEnrolKyc) {
		this.custEnrolKyc = custEnrolKyc;
	}
	
	
	//newly added columns getter and setter....
	
	public String getGroupIndividualType() {
		return groupIndividualType;
	}
	public void setGroupIndividualType(String groupIndividualType) {
		this.groupIndividualType = groupIndividualType;
	}
	public String getTempGroupId() {
		return tempGroupId;
	}
	public void setTempGroupId(String tempGroupId) {
		this.tempGroupId = tempGroupId;
	}
	public String getIsKycOnly() {
		return isKycOnly;
	}
	public void setIsKycOnly(String isKycOnly) {
		this.isKycOnly = isKycOnly;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getIsSentToCbs() {
		return isSentToCbs;
	}
	public void setIsSentToCbs(String isSentToCbs) {
		this.isSentToCbs = isSentToCbs;
	}
	public String getCbsResponseStat() {
		return cbsResponseStat;
	}
	public void setCbsResponseStat(String cbsResponseStat) {
		this.cbsResponseStat = cbsResponseStat;
	}
	public String getCbsResponseTxnRefNo() {
		return cbsResponseTxnRefNo;
	}
	public void setCbsResponseTxnRefNo(String cbsResponseTxnRefNo) {
		this.cbsResponseTxnRefNo = cbsResponseTxnRefNo;
	}
	public String getPoc() {
		return poc;
	}
	public void setPoc(String poc) {
		this.poc = poc;
	}
	
	
}
