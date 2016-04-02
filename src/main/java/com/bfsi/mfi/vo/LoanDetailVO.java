package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.LoanDetail;

public class LoanDetailVO extends MaintenanceVO<LoanDetail> {

	public LoanDetailVO() {
		entity = new LoanDetail();
	}

	public LoanDetailVO(LoanDetail entity) {
		super(entity);
	}

	public String getLoanAccNo() {
		return entity.getLoanAccNo();
	}

	public void setLoanAccNo(String loanAccNo) {
		this.entity.setLoanAccNo(loanAccNo);
	}

	public String getBranchCode() {
		return entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		this.entity.setBranchCode(branchCode);
	}

	public String getCustomerId() {
		return entity.getCustomerId();
	}

	public void setCustomerId(String customerId) {
		this.entity.setCustomerId(customerId);
	}

	public String getCreditOfficerCode() {
		return entity.getCreditOfficerCode();
	}

	public void setCreditOfficerCode(String creditOfficerCode) {
		this.entity.setCreditOfficerCode(creditOfficerCode);
	}

	/*public String getCreditOfficerName() {
		return entity.getCreditOfficerName();
	}

	public void setCreditOfficerName(String creditOfficerName) {
		this.entity.setCreditOfficerName(creditOfficerName);
	}

	public String getGroupName() {
		return entity.getGroupName();
	}

	public void setGroupName(String groupName) {
		this.entity.setGroupName(groupName);
	}*/

	public String getLocCode() {
		return entity.getLocCode();
	}

	public void setLocCode(String locCode) {
		this.entity.setLocCode(locCode);
	}

	/*public String getLocName() {
		return entity.getLocName();
	}

	public void setLocName(String locName) {
		this.entity.setLocName(locName);
	}*/

	public String getGroupId() {
		return entity.getGroupId();
	}

	public void setGroupId(String groupId) {
		this.entity.setGroupId(groupId);
	}

	/*public String getGroupCode() {
		return entity.getGroupCode();
	}

	public void setGroupCode(String groupCode) {
		this.entity.setGroupCode(groupCode);
	}

	public String getLoanStatus() {
		return entity.getLoanStatus();
	}

	public void setLoanStatus(String loanStatus) {
		this.entity.setLoanStatus(loanStatus);
	}*/

	public Date getSanctionedDate() {
		return entity.getSanctionedDate();
	}

	public void setSanctionedDate(Date sanctionedDate) {
		this.entity.setSanctionedDate(sanctionedDate);
	}

	public Date getLastDisbursedDate() {
		return entity.getLastDisbursedDate();
	}

	public void setLastDisbursedDate(Date lastDisbursedDate) {
		this.entity.setLastDisbursedDate(lastDisbursedDate);
	}

	public String getDisbrType() {
		return entity.getDisbrType();
	}

	public void setDisbrType(String disbrType) {
		this.entity.setDisbrType(disbrType);
	}

	public String getLoanAccCcy() {
		return entity.getLoanAccCcy();
	}

	public void setLoanAccCcy(String loanAccCcy) {
		this.entity.setLoanAccCcy(loanAccCcy);
	}

	public String getIsFullyDisbursed() {
		return entity.getIsFullyDisbursed();
	}

	public void setIsFullyDisbursed(String isFullyDisbursed) {
		this.entity.setIsFullyDisbursed(isFullyDisbursed);
	}

	public double getSanctPrincAmt() {
		return entity.getSanctPrincAmt();
	}

	public void setSanctPrincAmt(double sanctPrincAmt) {
		this.entity.setSanctPrincAmt(sanctPrincAmt);
	}

	public double getDisbPrincAmt() {
		return entity.getDisbPrincAmt();
	}

	public void setDisbPrincAmt(double disbPrincAmt) {
		this.entity.setDisbPrincAmt(disbPrincAmt);
	}

	public double getIntrRate() {
		return entity.getIntrRate();
	}

	public void setIntrRate(double intrRate) {
		this.entity.setIntrRate(intrRate);
	}

	public double getIntrAccured() {
		return entity.getIntrAccured();
	}

	public void setIntrAccured(double intrAccured) {
		this.entity.setIntrAccured(intrAccured);
	}

	public double getPrincRepaidAmt() {
		return entity.getPrincRepaidAmt();
	}

	public void setPrincRepaidAmt(double princRepaidAmt) {
		this.entity.setPrincRepaidAmt(princRepaidAmt);
	}

	public double getPrincOutstanding() {
		return entity.getPrincOutstanding();
	}

	public void setPrincOutstanding(double princOutstanding) {
		this.entity.setPrincOutstanding(princOutstanding);
	}

	public Date getLastRepayDate() {
		return entity.getLastRepayDate();
	}

	public void setLastRepayDate(Date lastRepayDate) {
		this.entity.setLastRepayDate(lastRepayDate);
	}
	public String getCustomerName() {
		return entity.getCustomerName();
	}
	public void setCustomerName(String customerName) {
		this.entity.setCustomerName(customerName);
	}

	public String getRecordStatus() {
		return entity.getRecordStatus();
	}

	public void setRecordStatus(String recordStatus) {
		this.entity.setRecordStatus(recordStatus);
	}

	public String getCbsUploadJobId() {
		return entity.getCbsUploadJobId();
	}

	public void setCbsUploadJobId(String cbsUploadJobId) {
		this.entity.setCbsUploadJobId(cbsUploadJobId);
	}

	public String getSyncStatus() {
		return entity.getSyncStatus();
	}

	public void setSyncStatus(String syncStatus) {
		this.entity.setSyncStatus(syncStatus);
	}

	public String getSyncTime() {
		return entity.getSyncTime();
	}

	public void setSyncTime(String syncTime) {
		this.entity.setSyncTime(syncTime);
	}

	public String getIsAllocated() {
		return entity.getIsAllocated();
	}

	public void setIsAllocated(String isAllocated) {
		this.entity.setIsAllocated(isAllocated);
	}
	

	
	
	public String getIsGrpLoan() {
		return entity.getIsGrpLoan();
	}
	public void setIsGrpLoan(String isGrpLoan) {
		this.entity.setIsGrpLoan(isGrpLoan);
	}
	public String getIsParentLoan() {
		return entity.getIsParentLoan();
	}
	public void setIsParentLoan(String isParentLoan) {
		this.entity.setIsParentLoan(isParentLoan);
	}
	public String getParentCustId() {
		return entity.getParentCustId();
	}
	public void setParentCustId(String parentCustId) {
		this.entity.setParentCustId(parentCustId);
	}
	public String getParentLoanAcNo() {
		return entity.getParentLoanAcNo();
	}
	public void setParentLoanAcNo(String parentLoanAcNo) {
		this.entity.setParentLoanAcNo(parentLoanAcNo);
	}
	public String getAgentId() {
		return entity.getAgentId();
	}
	public void setAgentId(String agentId) {
		this.entity.setAgentId(agentId);
	}
	

}
