package com.bfsi.mfi.entity;

import java.util.Date;

public class DepositTransaction extends MaintenanceEntity {
	private Date txnTimestamp;
	private String txnType;
	private String agentId;
	private String loanAcNo;
	private Date syncTime;
	private String customerId;
	private String deviceId;
	private String authStatus;
	private String txnNarrative;
	private Double txnAmount;
	private String txnCcy;
	private String branchCode;
	private Date depOpenDate;
	private String depPayFreq;
	private Double totalInstPaid;
	private Date depMatDate;
	private String fullPartlFlag;
	private Double depInstAmt;
	private Double depIntRate;
	private Double depIntAccured;
	private Double depMatAmtPaid;
	private String redempFlag;
	private Date redemDate;
	private Double redemAmnt;
	private String txnStatus;

	public String getTxnStatus() {
		return txnStatus;
	}

	public void setTxnStatus(String txnStatus) {
		this.txnStatus = txnStatus;
	}

	public String getTxnId() {
		return super.getId();
	}

	public void setTxnId(String txnId) {
		super.setId(txnId);
		;
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

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	public String getCustomerId() {
		return customerId;
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

	public String getTxnCcy() {
		return txnCcy;
	}

	public void setTxnCcy(String txnCcy) {
		this.txnCcy = txnCcy;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public Date getDepOpenDate() {
		return depOpenDate;
	}

	public void setDepOpenDate(Date depOpenDate) {
		this.depOpenDate = depOpenDate;
	}

	public String getDepPayFreq() {
		return depPayFreq;
	}

	public void setDepPayFreq(String depPayFreq) {
		this.depPayFreq = depPayFreq;
	}

	public Double getTotalInstPaid() {
		return totalInstPaid;
	}

	public void setTotalInstPaid(Double totalInstPaid) {
		this.totalInstPaid = totalInstPaid;
	}

	public Date getDepMatDate() {
		return depMatDate;
	}

	public void setDepMatDate(Date depMatDate) {
		this.depMatDate = depMatDate;
	}

	public String getFullPartlFlag() {
		return fullPartlFlag;
	}

	public void setFullPartlFlag(String fullPartlFlag) {
		this.fullPartlFlag = fullPartlFlag;
	}

	public Double getDepInstAmt() {
		return depInstAmt;
	}

	public void setDepInstAmt(Double depInstAmt) {
		this.depInstAmt = depInstAmt;
	}

	public Double getDepIntRate() {
		return depIntRate;
	}

	public void setDepIntRate(Double depIntRate) {
		this.depIntRate = depIntRate;
	}

	public Double getDepIntAccured() {
		return depIntAccured;
	}

	public void setDepIntAccured(Double depIntAccured) {
		this.depIntAccured = depIntAccured;
	}

	public Double getDepMatAmtPaid() {
		return depMatAmtPaid;
	}

	public void setDepMatAmtPaid(Double depMatAmtPaid) {
		this.depMatAmtPaid = depMatAmtPaid;
	}

	public String getRedempFlag() {
		return redempFlag;
	}

	public void setRedempFlag(String redempFlag) {
		this.redempFlag = redempFlag;
	}

	public Date getRedemDate() {
		return redemDate;
	}

	public void setRedemDate(Date redemDate) {
		this.redemDate = redemDate;
	}

	public Double getRedemAmnt() {
		return redemAmnt;
	}

	public void setRedemAmnt(Double redemAmnt) {
		this.redemAmnt = redemAmnt;
	}

}
