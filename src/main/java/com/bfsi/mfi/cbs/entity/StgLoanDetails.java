package com.bfsi.mfi.cbs.entity;

import java.util.Date;

public class StgLoanDetails {	
	private String loanAcNo;
	private String branchCode;
	private String customerId; 
	private String creditOfficeCode;
	private String groupId;
	private String groupCode;
	private String loanStatus;
	private String locationCode;
	private Date sanctionDate;
	private Date lastDisbursedDate;
	private String disbursType;
	private String loanAcCcy;
	private String isFullyDisbursed;
	private long sanctionedPrincipalAmt;
	private long disbursedPrincipalAmt;
	private long interestRate;
	private long interestAccured;
	private long principalAmtRepaid;
	private long principalOutStanding;
	private Date lastRepaymentDate;
	private String recordStat;
	private String cbsUpldJobId;
	
	public String getLoanAcNo() {
		return loanAcNo;
	}
	public void setLoanAcNo(String loanAcNo) {
		this.loanAcNo = loanAcNo;
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
	public String getCreditOfficeCode() {
		return creditOfficeCode;
	}
	public void setCreditOfficeCode(String creditOfficeCode) {
		this.creditOfficeCode = creditOfficeCode;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public Date getSanctionDate() {
		return sanctionDate;
	}
	public void setSanctionDate(Date sanctionDate) {
		this.sanctionDate = sanctionDate;
	}
	public Date getLastDisbursedDate() {
		return lastDisbursedDate;
	}
	public void setLastDisbursedDate(Date lastDisbursedDate) {
		this.lastDisbursedDate = lastDisbursedDate;
	}
	public String getDisbursType() {
		return disbursType;
	}
	public void setDisbursType(String disbursType) {
		this.disbursType = disbursType;
	}
	public String getLoanAcCcy() {
		return loanAcCcy;
	}
	public void setLoanAcCcy(String loanAcCcy) {
		this.loanAcCcy = loanAcCcy;
	}
	public String getIsFullyDisbursed() {
		return isFullyDisbursed;
	}
	public void setIsFullyDisbursed(String isFullyDisbursed) {
		this.isFullyDisbursed = isFullyDisbursed;
	}
	public long getSanctionedPrincipalAmt() {
		return sanctionedPrincipalAmt;
	}
	public void setSanctionedPrincipalAmt(long sanctionedPrincipalAmt) {
		this.sanctionedPrincipalAmt = sanctionedPrincipalAmt;
	}
	public long getDisbursedPrincipalAmt() {
		return disbursedPrincipalAmt;
	}
	public void setDisbursedPrincipalAmt(long disbursedPrincipalAmt) {
		this.disbursedPrincipalAmt = disbursedPrincipalAmt;
	}
	public long getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(long interestRate) {
		this.interestRate = interestRate;
	}
	public long getInterestAccured() {
		return interestAccured;
	}
	public void setInterestAccured(long interestAccured) {
		this.interestAccured = interestAccured;
	}
	public long getPrincipalAmtRepaid() {
		return principalAmtRepaid;
	}
	public void setPrincipalAmtRepaid(long principalAmtRepaid) {
		this.principalAmtRepaid = principalAmtRepaid;
	}
	public long getPrincipalOutStanding() {
		return principalOutStanding;
	}
	public void setPrincipalOutStanding(long principalOutStanding) {
		this.principalOutStanding = principalOutStanding;
	}
	public Date getLastRepaymentDate() {
		return lastRepaymentDate;
	}
	public void setLastRepaymentDate(Date lastRepaymentDate) {
		this.lastRepaymentDate = lastRepaymentDate;
	}
	public String getRecordStat() {
		return recordStat;
	}
	public void setRecordStat(String recordStat) {
		this.recordStat = recordStat;
	}
	public String getCbsUpldJobId() {
		return cbsUpldJobId;
	}
	public void setCbsUpldJobId(String cbsUpldJobId) {
		this.cbsUpldJobId = cbsUpldJobId;
	}
	
	

}
