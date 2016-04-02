package com.bfsi.mfi.vo;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.bfsi.mfi.entity.CustomerBiometricInfo;
import com.bfsi.mfi.entity.CustomerDocumentInfo;
import com.bfsi.mfi.entity.CustomerEnrolmentInfo;

/**
 * 
 * @author Shabu
 *
 */
public class CustomerEnrolmentInfoVO extends
		MaintenanceVO<CustomerEnrolmentInfo> {

	public CustomerEnrolmentInfoVO() {
		this.entity = new CustomerEnrolmentInfo();
	}

	public CustomerEnrolmentInfoVO(CustomerEnrolmentInfo entity) {
		super(entity);
	}
	public CustomerDocumentInfoVO getDocument() {
		CustomerDocumentInfoVO l_vo=new CustomerDocumentInfoVO();
		BeanUtils.copyProperties(entity.getDocument(), l_vo);
		return l_vo;
	}

	public void setDocument(CustomerDocumentInfoVO custDocInfo) {
		CustomerDocumentInfo l_entity=new CustomerDocumentInfo();
		BeanUtils.copyProperties(custDocInfo, l_entity);
		entity.setDocument(l_entity);
	}
	
	public CustomerBiometricInfoVO getBiometric() {
		CustomerBiometricInfoVO l_vo=new CustomerBiometricInfoVO();
		BeanUtils.copyProperties(entity.getBiometric(), l_vo);
		return l_vo;
	}
	public void setBiometric(CustomerBiometricInfoVO biometric) {
		CustomerBiometricInfo l_entity=new CustomerBiometricInfo();
		BeanUtils.copyProperties(biometric, l_entity);
		entity.setBiometric(l_entity);
	}
	
	public String getIsSentToCbs() {
		return entity.getIsSentToCbs();
	}
	public void setIsSentToCbs(String isSentToCbs) {
		entity.setIsSentToCbs(isSentToCbs);
	}
	
	public String getEnrolmentId() {
		return entity.getEnrolmentId();
	}

	public void setEnrolmentId(String enrolmentId) {
		entity.setEnrolmentId(enrolmentId);
	}

	public String getWorkFlowQueType() {
		return entity.getWorkFlowQueType();
	}

	public void setWorkFlowQueType(String workFlowQueType) {
		entity.setWorkFlowQueType(workFlowQueType);
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

	public String getResidenceType() {
		return entity.getResidenceType();
	}

	public void setResidenceType(String residenceType) {
		entity.setResidenceType(residenceType);
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

	public String getEmail() {
		return entity.getEmail();
	}

	public void setEmail(String email) {
		entity.setEmail(email);
	}

	public String getContactNo() {
		return entity.getContactNo();
	}

	public void setContactNo(String contactNo) {
		entity.setContactNo(contactNo);
	}

	public String getMaritalStatus() {
		return entity.getMaritalStatus();
	}

	public void setMaritalStatus(String maritalStatus) {
		entity.setMaritalStatus(maritalStatus);
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

	public String getAccType() {
		return entity.getAccType();
	}

	public void setAccType(String accType) {
		entity.setAccType(accType);
	}

	public String getAccCurrency() {
		return entity.getAccCurrency();
	}

	public void setAccCurrency(String accCurrency) {
		entity.setAccCurrency(accCurrency);
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

	public String getLocCode() {
		return entity.getLocCode();
	}

	public void setLocCode(String locCode) {
		entity.setLocCode(locCode);
	}

	public int getTxnStatus() {
		return entity.getTxnStatus();
	}

	public void setTxnStatus(int txnStatus) {
		entity.setTxnStatus(txnStatus);
	}

	public String getTxnErrorCode() {
		return entity.getTxnErrorCode();
	}

	public void setTxnErrorCode(String txnErrorCode) {
		entity.setTxnErrorCode(txnErrorCode);
	}

	public String getTxnErrorMsg() {
		return entity.getTxnErrorMsg();
	}

	public void setTxnErrorMsg(String txnErrorMsg) {
		entity.setTxnErrorMsg(txnErrorMsg);
	}

	public String getAuthStatus() {
		return entity.getAuthStatus();
	}

	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus);
	}

	public String getGroupIndlType() {
		return entity.getGroupIndlType();
	}

	public void setGroupIndlType(String groupIndlType) {
		entity.setGroupIndlType(groupIndlType);
	}

	public String getTmpGrpId() {
		return entity.getTmpGrpId();
	}

	public void setTmpGrpId(String tmpGrpId) {
		entity.setTmpGrpId(tmpGrpId);
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
	
	public String getPoc() {
		return entity.getPoc();
	}
	public void setPoc(String poc) {
		entity.setPoc(poc);
	}

}
