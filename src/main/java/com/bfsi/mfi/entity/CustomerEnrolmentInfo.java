package com.bfsi.mfi.entity;

import java.util.Date;

/**
 * 
 * @author Shabu
 *
 */
public class CustomerEnrolmentInfo extends MaintenanceEntity {
	private String enrolmentId;
	private String workFlowQueType;
	private String firstName;
	private String lastName;
	private String middleName;
	private Date dob;
	private String gender;
	private String residenceType;
	private String nationality;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private String email;
	private String contactNo;
	private String maritalStatus;
	private String profession;
	private String professionRemark;
	private String accountCategory;
	private String accType;
	private String accCurrency;
	private String isActive;
	private String moduleCode;
	private String txnCode;
	private Date txnInitTime;
	private Date txnSyncTime;
	private String agentId;
	private String deviceId;
	private String locCode;
	private int txnStatus;
	private String txnErrorCode;
	private String txnErrorMsg;
	private String authStatus;
	private String groupIndlType;
	private String tmpGrpId;
	private String isKycOnly;
	private String customerId;
	private String poc;
	private String isSentToCbs;
	private CustomerDocumentInfo document;
	private CustomerBiometricInfo biometric;
	
	
	
	public String getIsSentToCbs() {
		return isSentToCbs;
	}
	public void setIsSentToCbs(String isSentToCbs) {
		this.isSentToCbs = isSentToCbs;
	}
	public String getEnrolmentId() {
		return enrolmentId;
	}
	public void setEnrolmentId(String enrolmentId) {
		this.enrolmentId = enrolmentId;
	}
	public String getWorkFlowQueType() {
		return workFlowQueType;
	}
	public void setWorkFlowQueType(String workFlowQueType) {
		this.workFlowQueType = workFlowQueType;
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
	public String getResidenceType() {
		return residenceType;
	}
	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
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
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getAccCurrency() {
		return accCurrency;
	}
	public void setAccCurrency(String accCurrency) {
		this.accCurrency = accCurrency;
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
	public String getLocCode() {
		return locCode;
	}
	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}
	public int getTxnStatus() {
		return txnStatus;
	}
	public void setTxnStatus(int txnStatus) {
		this.txnStatus = txnStatus;
	}
	public String getTxnErrorCode() {
		return txnErrorCode;
	}
	public void setTxnErrorCode(String txnErrorCode) {
		this.txnErrorCode = txnErrorCode;
	}
	public String getTxnErrorMsg() {
		return txnErrorMsg;
	}
	public void setTxnErrorMsg(String txnErrorMsg) {
		this.txnErrorMsg = txnErrorMsg;
	}
	public String getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}
	public String getGroupIndlType() {
		return groupIndlType;
	}
	public void setGroupIndlType(String groupIndlType) {
		this.groupIndlType = groupIndlType;
	}
	public String getTmpGrpId() {
		return tmpGrpId;
	}
	public void setTmpGrpId(String tmpGrpId) {
		this.tmpGrpId = tmpGrpId;
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
	public String getPoc() {
		return poc;
	}
	public void setPoc(String poc) {
		this.poc = poc;
	}
	public CustomerDocumentInfo getDocument() {
		return document;
	}
	public void setDocument(CustomerDocumentInfo document) {
		this.document = document;
	}
	public CustomerBiometricInfo getBiometric() {
		return biometric;
	}
	public void setBiometric(CustomerBiometricInfo biometric) {
		this.biometric = biometric;
	}
}
