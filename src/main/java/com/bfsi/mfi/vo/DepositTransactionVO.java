package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.DepositTransaction;

public class DepositTransactionVO extends MaintenanceVO<DepositTransaction> {
	public DepositTransactionVO(DepositTransaction entity) {
		super(entity);
	}

	public DepositTransactionVO() {
		entity = new DepositTransaction();
	}

	public String getTxnId() {
		return super.getId();
	}

	public void setTxnId(String txnId) {
		super.setId(txnId);
	}

	public Date getTxnTimestamp() {
		return entity.getTxnTimestamp();
	}

	public void setTxnTimestamp(Date txnTimestamp) {
		entity.setTxnTimestamp(txnTimestamp);
	}

	public String getTxnType() {
		return entity.getTxnType();
	}

	public void setTxnType(String txnType) {
		entity.setTxnType(txnType);
	}

	public String getAgentId() {
		return entity.getAgentId();
	}

	public void setAgentId(String agentId) {
		entity.setAgentId(agentId);
	}

	public String getLoanAcNo() {
		return entity.getLoanAcNo();
	}

	public void setLoanAcNo(String loanAcNo) {
		entity.setLoanAcNo(loanAcNo);
	}

	public Date getSyncTime() {
		return entity.getSyncTime();
	}

	public void setSyncTime(Date syncTime) {
		entity.setSyncTime(syncTime);
	}

	public String getCustomerId() {
		return entity.getCustomerId();
	}

	public void setCustomerId(String customerId) {
		entity.setCustomerId(customerId);
	}

	public String getDeviceId() {
		return entity.getDeviceId();
	}

	public void setDeviceId(String deviceId) {
		entity.setDeviceId(deviceId);
	}

	public String getAuthStatus() {
		return entity.getAuthStatus();
	}

	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus);
	}

	public String getTxnNarrative() {
		return entity.getTxnNarrative();
	}

	public void setTxnNarrative(String txnNarrative) {
		entity.setTxnNarrative(txnNarrative);
	}

	public Double getTxnAmount() {
		return entity.getTxnAmount();
	}

	public void setTxnAmount(Double txnAmount) {
		entity.setTxnAmount(txnAmount);
	}

	public String getTxnCcy() {
		return entity.getTxnCcy();
	}

	public void setTxnCcy(String txnCcy) {
		entity.setTxnCcy(txnCcy);
	}

	public String getBranchCode() {
		return entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode);
	}

	public Date getDepOpenDate() {
		return entity.getDepOpenDate();
	}

	public void setDepOpenDate(Date depOpenDate) {
		entity.setDepOpenDate(depOpenDate);
	}

	public String getDepPayFreq() {
		return entity.getDepPayFreq();
	}

	public void setDepPayFreq(String depPayFreq) {
		entity.setDepPayFreq(depPayFreq);
	}

	public Double getTotalInstPaid() {
		return entity.getTotalInstPaid();
	}

	public void setTotalInstPaid(Double totalInstPaid) {
		entity.setTotalInstPaid(totalInstPaid);
	}

	public Date getDepMatDate() {
		return entity.getDepMatDate();
	}

	public void setDepMatDate(Date depMatDate) {
		entity.setDepMatDate(depMatDate);
	}

	public String getFullPartlFlag() {
		return entity.getFullPartlFlag();
	}

	public void setFullPartlFlag(String fullPartlFlag) {
		entity.setFullPartlFlag(fullPartlFlag);
	}

	public Double getDepInstAmt() {
		return entity.getDepInstAmt();
	}

	public void setDepInstAmt(Double depInstAmt) {
		entity.setDepInstAmt(depInstAmt);
	}

	public Double getDepIntRate() {
		return entity.getDepIntRate();
	}

	public void setDepIntRate(Double depIntRate) {
		entity.setDepIntRate(depIntRate);
	}

	public Double getDepIntAccured() {
		return entity.getDepIntAccured();
	}

	public void setDepIntAccured(Double depIntAccured) {
		entity.setDepIntAccured(depIntAccured);
	}

	public Double getDepMatAmtPaid() {
		return entity.getDepMatAmtPaid();
	}

	public void setDepMatAmtPaid(Double depMatAmtPaid) {
		entity.setDepMatAmtPaid(depMatAmtPaid);
	}

	public String getRedempFlag() {
		return entity.getRedempFlag();
	}

	public void setRedempFlag(String redempFlag) {
		entity.setRedempFlag(redempFlag);
	}

	public Date getRedemDate() {
		return entity.getRedemDate();
	}

	public void setRedemDate(Date redemDate) {
		entity.setRedemDate(redemDate);
	}

	public Double getRedemAmnt() {
		return entity.getRedemAmnt();
	}

	public void setRedemAmnt(Double redemAmnt) {
		entity.setRedemAmnt(redemAmnt);
	}
	public String getTxnStatus() {
		return entity.getTxnStatus();
	}

	public void setTxnStatus(String txnStatus) {
		entity.setTxnStatus(txnStatus);
	}

}
