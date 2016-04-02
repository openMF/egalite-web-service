package com.bfsi.mfi.entity;

import java.util.Date;

public class DisbursementTxn extends MaintenanceEntity 
{
	public DisbursementTxn() {
	}

	private String txnId;
	private String txnNarrative;
	private Double amount;
	private Date txnTimestamp;
	private String txnType;
	private String agentId;
	private String loanAcNo;
	private Date syncTime;
	private String customerId;
	private String deviceId;
	private String authStatus;
	private String txnStatus;
	private String txnCcy;
	 
	public String getTxnCcy() {
		return txnCcy;
	}
	public void setTxnCcy(String txnCcy) {
		this.txnCcy = txnCcy;
	}
	public String getTxnStatus() {
		return txnStatus;
	}
	public void setTxnStatus(String txnStatus) {
		this.txnStatus = txnStatus;
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
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getTxnTimestamp() {
		return txnTimestamp;
	}
	public void setTxnTimestamp(Date txnTimestamp) {
		this.txnTimestamp = txnTimestamp;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getLoanAcNo() {
		return loanAcNo;
	}
	public void setLoanAcNo(String loanAcNo) {
		this.loanAcNo = loanAcNo;
	}
	public String getCustomerId() {
		return customerId;
	}
	public Date getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	
}
