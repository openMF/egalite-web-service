package com.bfsi.mfi.entity;

import java.util.Date;

public class RepaymentSchedule extends MaintenanceEntity{
	private String branchCode;
	private String componentName;
	private String scheduleType;
	private Date scheduleStDate;
	private Date scheduleDueDate;
	private Double amountDue;
	private Double adjAmount;
	private Double amountSettled;
	private Double amountOverDue;
	private Double accruedAmount;
	private String settlementCcy;
	private Double lcyEquivalent;
	
	public String getLoanAcNo() {
		return super.getId();
	}

	public void setLoanAcNo(String loanAcNo) {
		super.setId(loanAcNo);
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getScheduleType() {
		return scheduleType;
	}
	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}
	public Date getScheduleStDate() {
		return scheduleStDate;
	}
	public void setScheduleStDate(Date scheduleStDate) {
		this.scheduleStDate = scheduleStDate;
	}
	public Date getScheduleDueDate() {
		return scheduleDueDate;
	}
	public void setScheduleDueDate(Date scheduleDueDate) {
		this.scheduleDueDate = scheduleDueDate;
	}
	public Double getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(Double amountDue) {
		this.amountDue = amountDue;
	}
	public Double getAdjAmount() {
		return adjAmount;
	}
	public void setAdjAmount(Double adjAmount) {
		this.adjAmount = adjAmount;
	}
	public Double getAmountSettled() {
		return amountSettled;
	}
	public void setAmountSettled(Double amountSettled) {
		this.amountSettled = amountSettled;
	}
	public Double getAmountOverDue() {
		return amountOverDue;
	}
	public void setAmountOverDue(Double amountOverDue) {
		this.amountOverDue = amountOverDue;
	}
	public Double getAccruedAmount() {
		return accruedAmount;
	}
	public void setAccruedAmount(Double accruedAmount) {
		this.accruedAmount = accruedAmount;
	}
	public String getSettlementCcy() {
		return settlementCcy;
	}
	public void setSettlementCcy(String settlementCcy) {
		this.settlementCcy = settlementCcy;
	}
	public Double getLcyEquivalent() {
		return lcyEquivalent;
	}
	public void setLcyEquivalent(Double lcyEquivalent) {
		this.lcyEquivalent = lcyEquivalent;
	}
}
