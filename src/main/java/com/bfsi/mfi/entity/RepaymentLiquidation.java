package com.bfsi.mfi.entity;

import java.util.Date;

public class RepaymentLiquidation extends MaintenanceEntity{
	private String branchCode;
	private Date valueDate;
	private Date executionDate;
	private String paymentStatus;
	private String settleMode;
	private String settleCurrency;
	private Double settleAmont;
	private Double eventSeqNum;
	
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
	public Date getValueDate() {
		return valueDate;
	}
	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}
	public Date getExecutionDate() {
		return executionDate;
	}
	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getSettleMode() {
		return settleMode;
	}
	public void setSettleMode(String settleMode) {
		this.settleMode = settleMode;
	}
	public String getSettleCurrency() {
		return settleCurrency;
	}
	public void setSettleCurrency(String settleCurrency) {
		this.settleCurrency = settleCurrency;
	}
	public Double getSettleAmont() {
		return settleAmont;
	}
	public void setSettleAmont(Double settleAmont) {
		this.settleAmont = settleAmont;
	}
	public Double getEventSeqNum() {
		return eventSeqNum;
	}
	public void setEventSeqNum(Double eventSeqNum) {
		this.eventSeqNum = eventSeqNum;
	}
	
}
