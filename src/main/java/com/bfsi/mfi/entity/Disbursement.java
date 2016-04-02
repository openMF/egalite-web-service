package com.bfsi.mfi.entity;

public class Disbursement /**nambiAK*/ extends MaintenanceEntity {

	private String txnId;
	private String txnNarrative;
	private Double txnAmount;
	private String txnCcy;
	
	/*nambiAK Vikash*/
	private String txnBranchCode;
	private String txnComponentName;
	private String txnSchStDate;
	private String txnSchDueDate;
	
	public String getTxnBranchCode() {
		return txnBranchCode;
	}
	public void setTxnBranchCode(String txnBranchCode) {
		this.txnBranchCode = txnBranchCode;
	}
	public String getTxnComponentName() {
		return txnComponentName;
	}
	public void setTxnComponentName(String txnComponentName) {
		this.txnComponentName = txnComponentName;
	}
	public String getTxnSchStDate() {
		return txnSchStDate;
	}
	public void setTxnSchStDate(String txnSchStDate) {
		this.txnSchStDate = txnSchStDate;
	}
	public String getTxnSchDueDate() {
		return txnSchDueDate;
	}
	public void setTxnSchDueDate(String txnSchDueDate) {
		this.txnSchDueDate = txnSchDueDate;
	}

	
	
	
	public String getTxnCcy() {
		return txnCcy;
	}
	public void setTxnCcy(String txnCcy) {
		this.txnCcy = txnCcy;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public String getTxnNarrative() {
		return txnNarrative;
	}
	public void setTxnNarrative(String txnNarrative) {
		this.txnNarrative = txnNarrative;
	}
	public Double getTxnAmount() {
		return txnAmount;
	}
	public void setTxnAmount(Double txnAmount) {
		this.txnAmount = txnAmount;
	}
	
}
