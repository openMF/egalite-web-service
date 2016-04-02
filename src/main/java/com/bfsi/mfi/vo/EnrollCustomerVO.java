package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.EnrollCustomer;

public class EnrollCustomerVO extends MaintenanceVO<EnrollCustomer> {
	
	public EnrollCustomerVO() {
		entity = new EnrollCustomer();
	}

	public EnrollCustomerVO(EnrollCustomer entity) {
		super(entity);
	}
	
	private CustEnrolKycVO custEnrolKyc;
	
	
	
	/*private Map<String, Document> documents = null;
	
	private String enrollDateText;
	
	public String getEnrollDateText() {
		if (getEnrollmentdate() != null) {
			Date IssueDate = getEnrollmentdate();
			Format formatter = new SimpleDateFormat("dd-MMM-yyyy");
			String formattedDate = formatter.format(IssueDate);
			enrollDateText = formattedDate.toString();
			return enrollDateText;
		} else {
			enrollDateText = "";
			return enrollDateText;
		}
	}

	public void setEnrollDateText(String enrollDateText) {
		this.enrollDateText = enrollDateText;
	}*/
	
	

	public CustEnrolKycVO getCustEnrolKyc() {
		return custEnrolKyc;
	}

	public void setCustEnrolKyc(CustEnrolKycVO custEnrolKyc) {
		this.custEnrolKyc = custEnrolKyc;
	}

	public String getWorkFlowQType() {
		return entity.getWorkFlowQType();
	}
	
	public void setWorkFlowQType(String workFlowQType) {
		entity.setWorkFlowQType(workFlowQType); 
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
	public Date getDob() {
		return entity.getDob();
	}
	public void setDob(Date dob) {
		entity.setDob(dob); 
	}
	public String getGender() {
		return entity.getGender();
	}
	public void setGender(String gender) {
		entity.setGender(gender); 
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
	public String getAddress3() {
		return entity.getAddress3();
	}
	public void setAddress3(String address3) {
		entity.setAddress3(address3); 
	}
	public String getAddress4() {
		return entity.getAddress4();
	}
	public void setAddress4(String address4) {
		entity.setAddress4(address4); 
	}
	public String getCity() {
		return entity.getCity();
	}
	public void setCity(String city) {
		entity.setCity(city);
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
	public String getCountry() {
		return entity.getCountry();
	}
	public void setCountry(String country) {
		entity.setCountry(country); 
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
	public String getAccountCategory() {
		return entity.getAccountCategory();
	}
	public void setAccountCategory(String accountCategory) {
		entity.setAccountCategory(accountCategory); 
	}
	public String getAccountType() {
		return entity.getAccountType();
	}
	public void setAccountType(String accountType) {
		entity.setAccountType(accountType); 
	}
	public String getCurrency() {
		return entity.getCurrency();
	}
	public void setCurrency(String currency) {
		entity.setCurrency(currency); 
	}
	public String getIsActive() {
		return entity.getIsActive();
	}
	public void setIsActive(String isActive) {
		entity.setIsActive(isActive); 
	}
	public String getModuleCode() {
		return entity.getModuleCode();
	}
	public void setModuleCode(String moduleCode) {
		entity.setModuleCode(moduleCode);
	}
	public String getTxnCode() {
		return entity.getTxnCode();
	}
	public void setTxnCode(String txnCode) {
		entity.setTxnCode(txnCode);
	}
	public Date getTxnInitTime() {
		return entity.getTxnInitTime();
	}
	public void setTxnInitTime(Date txnInitTime) {
		entity.setTxnInitTime(txnInitTime); 
	}
	public Date getTxnSyncTime() {
		return entity.getTxnSyncTime();
	}
	public void setTxnSyncTime(Date txnSyncTime) {
		entity.setTxnSyncTime(txnSyncTime);
	}
	public String getAgentId() {
		return entity.getAgentId();
	}
	public void setAgentId(String agentId) {
		entity.setAgentId(agentId);
	}
	public String getDeviceId() {
		return entity.getDeviceId();
	}
	public void setDeviceId(String deviceId) {
		entity.setDeviceId(deviceId);
	}
	public String getLocationCode() {
		return entity.getLocationCode();
	}
	public void setLocationCode(String locationCode) {
		entity.setLocationCode(locationCode); 
	}
	public Integer getTxnStatus() {
		return entity.getTxnStatus();
	}
	public void setTxnStatus(Integer txnStatus) {
		entity.setTxnStatus(txnStatus); 
	}
	public String getTxnErrCode() {
		return entity.getTxnErrCode();
	}
	public void setTxnErrCode(String txnErrCode) {
		entity.setTxnErrCode(txnErrCode); 
	}
	public String getTxnErrMessage() {
		return entity.getTxnErrMessage();
	}
	public void setTxnErrMessage(String txnErrMessage) {
		entity.setTxnErrMessage(txnErrMessage);
	}

	public String getAuthStatus() {
		return entity.getAuthStatus();
	}
	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus); 
	}
	
	/*public CustEnrolKyc getCustEnrolKyc() {
		return entity.getCustEnrolKyc();
	}
	public void setCustEnrolKyc(CustEnrolKyc custEnrolKyc) {
		entity.setCustEnrolKyc(custEnrolKyc); 
	}*/
	
	
	public String getGroupIndividualType() {
		return entity.getGroupIndividualType();
	}
	public void setGroupIndividualType(String groupIndividualType) {
		entity.setGroupIndividualType(groupIndividualType);
	}
	public String getTempGroupId() {
		return entity.getTempGroupId();
	}
	public void setTempGroupId(String tempGroupId) {
		entity.setTempGroupId(tempGroupId); 
	}
	public String getIsKycOnly() {
		return entity.getIsKycOnly();
	}
	public void setIsKycOnly(String isKycOnly) {
		entity.setIsKycOnly(isKycOnly);
	}
	public String getCustomerId() {
		return entity.getCustomerId();
	}
	public void setCustomerId(String customerId) {
		entity.setCustomerId(customerId);
	}
	public String getIsSentToCbs() {
		return entity.getIsSentToCbs();
	}
	public void setIsSentToCbs(String isSentToCbs) {
		entity.setIsSentToCbs(isSentToCbs); 
	}
	public String getCbsResponseStat() {
		return entity.getCbsResponseStat();
	}
	public void setCbsResponseStat(String cbsResponseStat) {
		entity.setCbsResponseStat(cbsResponseStat); 
	}
	public String getCbsResponseTxnRefNo() {
		return entity.getCbsResponseTxnRefNo();
	}
	public void setCbsResponseTxnRefNo(String cbsResponseTxnRefNo) {
		entity.setCbsResponseTxnRefNo(cbsResponseTxnRefNo); 
	}
	public String getPoc() {
		return entity.getPoc();
	}
	public void setPoc(String poc) {
		entity.setPoc(poc); 
	}
	

	public Object clone() {
		EnrollCustomerVO copyObj = new EnrollCustomerVO();
		
		copyObj.setId(getId());
		copyObj.setWorkFlowQType(getWorkFlowQType());
		copyObj.setFirstName(getFirstName());
		copyObj.setLastName(getLastName());
		copyObj.setMiddleName(getMiddleName());
		copyObj.setDob(getDob());
		copyObj.setGender(getGender());
		copyObj.setResidentialType(getResidentialType());
		copyObj.setNationality(getNationality());
		copyObj.setAddress1(getAddress1());
		copyObj.setAddress2(getAddress2());
		copyObj.setCity(getCity());
		copyObj.setState(getState());
		copyObj.setZipCode(getZipCode());
		copyObj.setCountry(getCountry());
		copyObj.setEmailId(getEmailId());
		copyObj.setContactNumber(getContactNumber());
		copyObj.setMartialStatus(getMartialStatus());
		copyObj.setProfession(getProfession());
		copyObj.setProfessionRemark(getProfessionRemark());
		copyObj.setAccountCategory(getAccountCategory());
		copyObj.setAccountType(getAccountType());
		copyObj.setCurrency(getCurrency());
		copyObj.setIsActive(getIsActive());
		copyObj.setModuleCode(getModuleCode());
		copyObj.setTxnCode(getTxnCode());
		copyObj.setTxnInitTime(getTxnInitTime());
		copyObj.setTxnSyncTime(getTxnSyncTime());
		copyObj.setAgentId(getAgentId());
		copyObj.setDeviceId(getDeviceId());
		copyObj.setLocationCode(getLocationCode());
		copyObj.setTxnStatus(getTxnStatus());
		copyObj.setTxnErrCode(getTxnErrCode());
		copyObj.setTxnErrMessage(getTxnErrMessage());
		copyObj.setAuthStatus(getAuthStatus());
		copyObj.setCustEnrolKyc((CustEnrolKycVO)this.custEnrolKyc.clone());
		
		//Newly added columns below...
		copyObj.setGroupIndividualType(getGroupIndividualType());
		copyObj.setTempGroupId(getTempGroupId());
		copyObj.setIsKycOnly(getIsKycOnly());
		copyObj.setCustomerId(getCustomerId());
		copyObj.setIsSentToCbs(getIsSentToCbs()); 
		copyObj.setCbsResponseStat(getCbsResponseStat());
		copyObj.setCbsResponseTxnRefNo(getCbsResponseTxnRefNo());
		copyObj.setPoc(getPoc());
		
		return copyObj;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((super.getId() == null) ? 0 : super.getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnrollCustomerVO other = (EnrollCustomerVO) obj;
		if (super.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!super.getId().equals(other.getId()))
			return false;
		return true;
	}
}
