package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.LoanDetailView;

public class LoanDetailViewVO extends MaintenanceVO<LoanDetailView>{

	public LoanDetailViewVO() {
		entity = new LoanDetailView();
	}
	
	public LoanDetailViewVO(LoanDetailView entity) {
		super(entity);
	}
	
	public String getBranchCode() {
		return entity.getBranchCode();
	}
	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode); 
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
	public String getCreditOfficerCode() {
		return entity.getCreditOfficerCode();
	}
	public void setCreditOfficerCode(String creditOfficerCode) {
		entity.setCreditOfficerCode(creditOfficerCode);
	}
	public String getCreditOfficerName() {
		return entity.getCreditOfficerName();
	}
	public void setCreditOfficerName(String creditOfficerName) {
		entity.setCreditOfficerName(creditOfficerName); 
	}
	public String getAgentId() {
		return entity.getAgentId();
	}
	public void setAgentId(String agentId) {
		entity.setAgentId(agentId); 
	}
	public String getAgentName() {
		return entity.getAgentName();
	}
	public void setAgentName(String agentName) {
		entity.setAgentName(agentName);
	}
	public String getLocationCode() {
		return entity.getLocationCode();
	}
	public void setLocationCode(String locationCode) {
		entity.setLocationCode(locationCode); 
	}
	public String getLocationDesc() {
		return entity.getLocationDesc();
	}
	public void setLocationDesc(String locationDesc) {
		entity.setLocationDesc(locationDesc); 
	}
	public String getAllocationByCode() {
		return entity.getAllocationByCode();
	}
	public void setAllocationByCode(String allocationByCode) {
		entity.setAllocationByCode(allocationByCode); 
	}
	public String getAllocationByName() {
		return entity.getAllocationByName();
	}
	public void setAllocationByName(String allocationByName) {
		entity.setAllocationByName(allocationByName); 
	}
	public String getGroupId() {
		return entity.getGroupId();
	}
	public void setGroupId(String groupId) {
		entity.setGroupId(groupId); 
	}
	public String getGroupCode() {
		return entity.getGroupCode();
	}
	public void setGroupCode(String groupCode) {
		entity.setGroupCode(groupCode); 
	}
	public Date getSanctionedDate() {
		return entity.getSanctionedDate();
	}
	public void setSanctionedDate(Date sanctionedDate) {
		entity.setSanctionedDate(sanctionedDate); 
	}
	public Date getLastDisbursedDate() {
		return entity.getLastDisbursedDate();
	}
	public void setLastDisbursedDate(Date lastDisbursedDate) {
		entity.setLastDisbursedDate(lastDisbursedDate); 
	}
	public String getDisbrType() {
		return entity.getDisbrType();
	}
	public void setDisbrType(String disbrType) {
		entity.setDisbrType(disbrType); 
	}
	public String getLoanAcCcy() {
		return entity.getLoanAcCcy();
	}
	public void setLoanAcCcy(String loanAcCcy) {
		entity.setLoanAcCcy(loanAcCcy); 
	}
	public String getIsFullyDisbursed() {
		return entity.getIsFullyDisbursed();
	}
	public void setIsFullyDisbursed(String isFullyDisbursed) {
		entity.setIsFullyDisbursed(isFullyDisbursed); 
	}
	public Double getInterestRate() {
		return entity.getInterestRate();
	}
	public void setInterestRate(Double interestRate) {
		entity.setInterestRate(interestRate);
	}
	public Double getInterestAccured() {
		return entity.getInterestAccured();
	}
	public void setInterestAccured(Double interestAccured) {
		entity.setInterestAccured(interestAccured); 
	}
	public Double getPrincipalAmount() {
		return entity.getPrincipalAmount();
	}
	public void setPrincipalAmount(Double principalAmount) {
		entity.setPrincipalAmount(principalAmount); 
	}
	public Double getPrincipalPaid() {
		return entity.getPrincipalPaid();
	}
	public void setPrincipalPaid(Double principalPaid) {
		entity.setPrincipalPaid(principalPaid); 
	}
	public Double getPrincipalOutstanding() {
		return entity.getPrincipalOutstanding();
	}
	public void setPrincipalOutstanding(Double principalOutstanding) {
		entity.setPrincipalOutstanding(principalOutstanding); 
	}
	public String getLoanStatus() {
		return entity.getLoanStatus();
	}
	public void setLoanStatus(String loanStatus) {
		entity.setLoanStatus(loanStatus); 
	}
	public Date getLastRepaymentDate() {
		return entity.getLastRepaymentDate();
	}
	public void setLastRepaymentDate(Date lastRepaymentDate) {
		entity.setLastRepaymentDate(lastRepaymentDate); 
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
	public String getSyncStatus() {
		return entity.getSyncStatus();
	}
	public void setSyncStatus(String syncStatus) {
		entity.setSyncStatus(syncStatus); 
	}
	public String getSyncTime() {
		return entity.getSyncTime();
	}
	public void setSyncTime(String syncTime) {
		entity.setSyncTime(syncTime); 
	}
	public String getAllocationStatus() {
		return entity.getAllocationStatus();
	}
	public void setAllocationStatus(String allocationStatus) {
		entity.setAllocationStatus(allocationStatus); 
	}
	
	
	
	public String getParentLoanAcNo() {
		return entity.getParentLoanAcNo();
	}
	public void setParentLoanAcNo(String parentLoanAcNo) {
		entity.setParentLoanAcNo(parentLoanAcNo);
	}
	public String getParentCustId() {
		return entity.getParentCustId();
	}
	public void setParentCustId(String parentCustId) {
		entity.setParentCustId(parentCustId);
	}
	public String getIsParentLoan() {
		return entity.getIsParentLoan();
	}
	public void setIsParentLoan(String isParentLoan) {
		entity.setIsParentLoan(isParentLoan);
	}
	public String getIsGroupLoan() {
		return entity.getIsGroupLoan();
	}
	public void setIsGroupLoan(String isGroupLoan) {
		entity.setIsGroupLoan(isGroupLoan);
	}
	public String getLoanType() {
		return entity.getLoanType();
	}
	public void setLoanType(String loanType) {
		entity.setLoanType(loanType); 
	}
	public String getGroupType() {
		return entity.getGroupType();
	}
	public void setGroupType(String groupType) {
		entity.setGroupType(groupType);
	}
	
	
	
}
