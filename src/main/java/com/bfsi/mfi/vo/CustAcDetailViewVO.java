package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.CustAcDetailView;

public class CustAcDetailViewVO extends MaintenanceVO<CustAcDetailView>{
	public CustAcDetailViewVO() {
		entity = new CustAcDetailView();
	}

	public CustAcDetailViewVO(CustAcDetailView entity) {
		super(entity);
	}
	
	
	public String getCustomerId() {
		return entity.getCustomerId();
	}
	public void setCustomerId(String customerId) {
		entity.setCustomerId(customerId);
	}
	public String getCustomerFullName() {
		return entity.getCustomerFullName();
	}
	public void setCustomerFullName(String customerFullName) {
		entity.setCustomerFullName(customerFullName);
	}
	public String getBranchCode() {
		return entity.getBranchCode();
	}
	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode); 
	}
	public String getAccountType() {
		return entity.getAccountType();
	}
	public void setAccountType(String accountType) {
		entity.setAccountType(accountType);
	}
	public String getAcDesc() {
		return entity.getAcDesc();
	}
	public void setAcDesc(String acDesc) {
		entity.setAcDesc(acDesc);
	}
	public String getAcCcy() {
		return entity.getAcCcy();
	}
	public void setAcCcy(String acCcy) {
		entity.setAcCcy(acCcy); 
	}
	public Double getAcyCurrBal() {
		return entity.getAcyCurrBal();
	}
	public void setAcyCurrBal(Double acyCurrBal) {
		entity.setAcyCurrBal(acyCurrBal);
	}
	public Double getAcyAvailBal() {
		return entity.getAcyAvailBal();
	}
	public void setAcyAvailBal(Double acyAvailBal) {
		entity.setAcyAvailBal(acyAvailBal);
	}
	public String getAcStatNoDr() {
		return entity.getAcStatNoDr();
	}
	public void setAcStatNoDr(String acStatNoDr) {
		entity.setAcStatNoDr(acStatNoDr); 
	}
	public String getAcStatNoCr() {
		return entity.getAcStatNoCr();
	}
	public void setAcStatNoCr(String acStatNoCr) {
		entity.setAcStatNoCr(acStatNoCr); 
	}
	public String getAcStatBlock() {
		return entity.getAcStatBlock();
	}
	public void setAcStatBlock(String acStatBlock) {
		entity.setAcStatBlock(acStatBlock); 
	}
	public String getAcStatStopPay() {
		return entity.getAcStatStopPay();
	}
	public void setAcStatStopPay(String acStatStopPay) {
		entity.setAcStatStopPay(acStatStopPay); 
	}
	public String getAcStatDormant() {
		return entity.getAcStatDormant();
	}
	public void setAcStatDormant(String acStatDormant) {
		entity.setAcStatDormant(acStatDormant); 
	}
	public String getAgentId() {
		return entity.getAgentId();
	}
	public void setAgentId(String agentId) {
		entity.setAgentId(agentId);
	}
	public String getLocationCode() {
		return entity.getLocationCode();
	}
	public void setLocationCode(String locationCode) {
		entity.setLocationCode(locationCode);
	}
	public String getCreditOfficerId() {
		return entity.getCreditOfficerId();
	}
	public void setCreditOfficerId(String creditOfficerId) {
		entity.setCreditOfficerId(creditOfficerId);
	}
	public String getJointAcIndicator() {
		return entity.getJointAcIndicator();
	}
	public void setJointAcIndicator(String jointAcIndicator) {
		entity.setJointAcIndicator(jointAcIndicator); 
	}
	public String getRecordStat() {
		return entity.getRecordStat();
	}
	public void setRecordStat(String recordStat) {
		entity.setRecordStat(recordStat);
	}
	public String getCbsUpldJobId() {
		return entity.getCbsUpldJobId();
	}
	public void setCbsUpldJobId(String cbsUpldJobId) {
		entity.setCbsUpldJobId(cbsUpldJobId);
	}
	
	
	
}
