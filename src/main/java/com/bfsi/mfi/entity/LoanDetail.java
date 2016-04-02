package com.bfsi.mfi.entity;

import java.util.Date;



public class LoanDetail extends MaintenanceEntity {

	private String loanAccNo;
	private String branchCode;
	private String customerId;
	private String customerName; //
	private String creditOfficerCode;
	//private String creditOfficerName;/////
	//private String groupName;  ////
	private String locCode;  ///
	//private String locName;  ////
	private String groupId;
	//private String groupCode;
	//private String loanStatus;
	private Date sanctionedDate;
	private Date lastDisbursedDate;
	private String disbrType;
	private String loanAccCcy;
	private String isFullyDisbursed;
	private double sanctPrincAmt;
	private double disbPrincAmt;
	private double intrRate;
	private double intrAccured;
	private double princRepaidAmt;
	private double princOutstanding;
	private Date lastRepayDate;
	
	
	////////////////////////////////////
	private String recordStatus;
	private String cbsUploadJobId;
	private String syncStatus;
	private String syncTime;
	private String isAllocated;
	
	////////////
	private String isGrpLoan;
	private String isParentLoan;
	private String parentCustId;
	private String parentLoanAcNo;
	private String agentId;
	
	
	
	
	public String getIsGrpLoan() {
		return isGrpLoan;
	}
	public void setIsGrpLoan(String isGrpLoan) {
		this.isGrpLoan = isGrpLoan;
	}
	public String getIsParentLoan() {
		return isParentLoan;
	}
	public void setIsParentLoan(String isParentLoan) {
		this.isParentLoan = isParentLoan;
	}
	public String getParentCustId() {
		return parentCustId;
	}
	public void setParentCustId(String parentCustId) {
		this.parentCustId = parentCustId;
	}
	public String getParentLoanAcNo() {
		return parentLoanAcNo;
	}
	public void setParentLoanAcNo(String parentLoanAcNo) {
		this.parentLoanAcNo = parentLoanAcNo;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getLoanAccNo() {
		return loanAccNo;
	}
	public void setLoanAccNo(String loanAccNo) {
		this.loanAccNo = loanAccNo;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCreditOfficerCode() {
		return creditOfficerCode;
	}
	public void setCreditOfficerCode(String creditOfficerCode) {
		this.creditOfficerCode = creditOfficerCode;
	}
	
	public String getLocCode() {
		return locCode;
	}
	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	public Date getSanctionedDate() {
		return sanctionedDate;
	}
	public void setSanctionedDate(Date sanctionedDate) {
		this.sanctionedDate = sanctionedDate;
	}
	public Date getLastDisbursedDate() {
		return lastDisbursedDate;
	}
	public void setLastDisbursedDate(Date lastDisbursedDate) {
		this.lastDisbursedDate = lastDisbursedDate;
	}
	public String getDisbrType() {
		return disbrType;
	}
	public void setDisbrType(String disbrType) {
		this.disbrType = disbrType;
	}
	public String getLoanAccCcy() {
		return loanAccCcy;
	}
	public void setLoanAccCcy(String loanAccCcy) {
		this.loanAccCcy = loanAccCcy;
	}
	public String getIsFullyDisbursed() {
		return isFullyDisbursed;
	}
	public void setIsFullyDisbursed(String isFullyDisbursed) {
		this.isFullyDisbursed = isFullyDisbursed;
	}
	public double getSanctPrincAmt() {
		return sanctPrincAmt;
	}
	public void setSanctPrincAmt(double sanctPrincAmt) {
		this.sanctPrincAmt = sanctPrincAmt;
	}
	public double getDisbPrincAmt() {
		return disbPrincAmt;
	}
	public void setDisbPrincAmt(double disbPrincAmt) {
		this.disbPrincAmt = disbPrincAmt;
	}
	public double getIntrRate() {
		return intrRate;
	}
	public void setIntrRate(double intrRate) {
		this.intrRate = intrRate;
	}
	public double getIntrAccured() {
		return intrAccured;
	}
	public void setIntrAccured(double intrAccured) {
		this.intrAccured = intrAccured;
	}
	public double getPrincRepaidAmt() {
		return princRepaidAmt;
	}
	public void setPrincRepaidAmt(double princRepaidAmt) {
		this.princRepaidAmt = princRepaidAmt;
	}
	public double getPrincOutstanding() {
		return princOutstanding;
	}
	public void setPrincOutstanding(double princOutstanding) {
		this.princOutstanding = princOutstanding;
	}
	public Date getLastRepayDate() {
		return lastRepayDate;
	}
	public void setLastRepayDate(Date lastRepayDate) {
		this.lastRepayDate = lastRepayDate;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public String getCbsUploadJobId() {
		return cbsUploadJobId;
	}
	public void setCbsUploadJobId(String cbsUploadJobId) {
		this.cbsUploadJobId = cbsUploadJobId;
	}
	public String getSyncStatus() {
		return syncStatus;
	}
	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}
	public String getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(String syncTime) {
		this.syncTime = syncTime;
	}
	public String getIsAllocated() {
		return isAllocated;
	}
	public void setIsAllocated(String isAllocated) {
		this.isAllocated = isAllocated;
	}
	
	
	
	
}
