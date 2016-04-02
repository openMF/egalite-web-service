package com.bfsi.mfi.entity;

import java.util.Date;

public class LoanPaidSchDetail extends MaintenanceEntity {
	
	private String loanAcNo;
	private String branchCode;
	private String parentLoanAcNo;
	private String customerId;
	private String parentCustomerId;
	private String isParentLoan;
	private String isGroupLoan;
	private String groupId;
	private String customerName;
	private Date schDueDate;
	private Date schPaidDate;
	private String stlmtCcyCode;
	private double amtSettled;
	private String fullPartialInd;
	private String agentId;
	private String locCode;
	private String deviceId;
	
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
	public String getParentLoanAcNo() {
		return parentLoanAcNo;
	}
	public void setParentLoanAcNo(String parentLoanAcNo) {
		this.parentLoanAcNo = parentLoanAcNo;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getParentCustomerId() {
		return parentCustomerId;
	}
	public void setParentCustomerId(String parentCustomerId) {
		this.parentCustomerId = parentCustomerId;
	}
	public String getIsParentLoan() {
		return isParentLoan;
	}
	public void setIsParentLoan(String isParentLoan) {
		this.isParentLoan = isParentLoan;
	}
	public String getIsGroupLoan() {
		return isGroupLoan;
	}
	public void setIsGroupLoan(String isGroupLoan) {
		this.isGroupLoan = isGroupLoan;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getSchDueDate() {
		return schDueDate;
	}
	public void setSchDueDate(Date schDueDate) {
		this.schDueDate = schDueDate;
	}
	public Date getSchPaidDate() {
		return schPaidDate;
	}
	public void setSchPaidDate(Date schPaidDate) {
		this.schPaidDate = schPaidDate;
	}
	public String getStlmtCcyCode() {
		return stlmtCcyCode;
	}
	public void setStlmtCcyCode(String stlmtCcyCode) {
		this.stlmtCcyCode = stlmtCcyCode;
	}
	public double getAmtSettled() {
		return amtSettled;
	}
	public void setAmtSettled(double amtSettled) {
		this.amtSettled = amtSettled;
	}
	public String getFullPartialInd() {
		return fullPartialInd;
	}
	public void setFullPartialInd(String fullPartialInd) {
		this.fullPartialInd = fullPartialInd;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getLocCode() {
		return locCode;
	}
	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
