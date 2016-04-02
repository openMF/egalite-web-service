package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.CustomerAccountDetails;

public class CustomerAccountVO  extends MaintenanceVO<CustomerAccountDetails>{
	
	public CustomerAccountVO() {
		entity = new CustomerAccountDetails();
	}

	public CustomerAccountVO(CustomerAccountDetails entity) {
		super(entity);
	}
	
	public String getCustomerId() {
		return entity.getCustomerId();
	}

	public void setCustomerId(String customerId) {
		this.entity.setCustomerId(customerId);
	}

	public String getCustAcNo() {
		return entity.getCustAcNo();
	}

	public void setCustAcNo(String custAcNo) {
		this.entity.setCustAcNo(custAcNo);
	}

	public String getBranchCode() {
		return entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		this.entity.setBranchCode(branchCode);
	}

	public String getAccountType() {
		return entity.getAccountType();
	}

	public void setAccountType(String accountType) {
		this.entity.setAccountType(accountType);
	}

	public String getAcDesc() {
		return entity.getAcDesc();
	}

	public void setAcDesc(String acDesc) {
		this.entity.setAcDesc(acDesc);
	}

	public String getAcCcy() {
		return entity.getAcCcy();
	}

	public void setAcCcy(String acCcy) {
		this.entity.setAcCcy(acCcy);
	}

	public double getAcyCurrBal() {
		return  entity.getAcyCurrBal();
	}

	public void setAcyCurrBal(double acyCurrBal) {
		this.entity.setAcyCurrBal(acyCurrBal);
	}

	public double getAcyAvailBal() {
		return  entity.getAcyAvailBal();
	}

	public void setAcyAvailBal(double acyAvailBal) {
		this.entity.setAcyAvailBal(acyAvailBal);
	}

	public String getAcStatNoDr() {
		return entity.getAcStatNoDr();
	}

	public void setAcStatNoDr(String acStatNoDr) {
		this.entity.setAcStatNoDr(acStatNoDr);
	}

	public String getAcStatNoCr() {
		return entity.getAcStatNoCr();
	}

	public void setAcStatNoCr(String acStatNoCr) {
		this.entity.setAcStatNoCr(acStatNoCr);
	}

	public String getAcStatStopPay() {
		return entity.getAcStatStopPay();
	}

	public void setAcStatStopPay(String acStatStopPay) {
		this.entity.setAcStatStopPay(acStatStopPay);
	}

	public String getAcStatDorMant() {
		return entity.getAcStatDorMant();
	}

	public void setAcStatDorMant(String acStatDorMant) {
		this.entity.setAcStatDorMant(acStatDorMant);
	}

	public String getCreditOficerId() {
		return  entity.getCreditOficerId();
	}

	public void setCreditOficerId(String creditOficerId) {
		this.entity.setCreditOficerId(creditOficerId);
	}

	public String getJointAcIndiCator() {
		return entity.getJointAcIndiCator();
	}

	public void setJointAcIndiCator(String jointAcIndiCator) {
		this.entity.setJointAcIndiCator(jointAcIndiCator);
	}

	public String getCbsUploadJobId() {
		return entity.getCbsUploadJobId();
	}

	public void setCbsUploadJobId(String cbsUploadJobId) {
		this.entity.setCbsUploadJobId(cbsUploadJobId);
	}

	public String getIsAllocated() {
		return entity.getIsAllocated();
	}

	public void setIsAllocated(String isAllocated) {
		this.entity.setIsAllocated(isAllocated);
	}

	public String getAcStatBlock() {
		return entity.getAcStatBlock();
	}

	public void setAcStatBlock(String acStatBlock) {
		this.entity.setAcStatBlock(acStatBlock);
	}

	public String getRecordStat() {
		return entity.getRecordStat();
	}

	public void setRecordStat(String recordStat) {
		this.entity.setRecordStat(recordStat);
	}

	public String getAgentId() {
		return entity.getAgentId();
	}

	public void setAgentId(String agentId) {
		this.entity.setAgentId(agentId);
	}

	public String getLocCode() {
		return entity.getLocCode();
	}

	public void setLocCode(String locCode) {
		this.entity.setLocCode(locCode);
	}

	public String getCustFullName() {
		return entity.getCustFullName();
	}

	public void setCustFullName(String custFullName) {
		this.entity.setCustFullName(custFullName);
	}

}
