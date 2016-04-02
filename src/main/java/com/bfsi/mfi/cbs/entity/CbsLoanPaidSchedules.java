package com.bfsi.mfi.cbs.entity;

import java.util.Date;

public class CbsLoanPaidSchedules {
	
	private String loanAcNo;
	private String branchCode;
	private Date schDueDate;
	private Date schPaidDate;
	private String settlementCcyCode;
	private long amtSettled;
	private String fullPartialInd;
		
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
	public String getSettlementCcyCode() {
		return settlementCcyCode;
	}
	public void setSettlementCcyCode(String settlementCcyCode) {
		this.settlementCcyCode = settlementCcyCode;
	}
	public long getAmtSettled() {
		return amtSettled;
	}
	public void setAmtSettled(long amtSettled) {
		this.amtSettled = amtSettled;
	}
	public String getFullPartialInd() {
		return fullPartialInd;
	}
	public void setFullPartialInd(String fullPartialInd) {
		this.fullPartialInd = fullPartialInd;
	}
	
}
