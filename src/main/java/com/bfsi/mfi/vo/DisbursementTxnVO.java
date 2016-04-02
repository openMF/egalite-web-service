package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.DisbursementTxn;

public class DisbursementTxnVO extends MaintenanceVO<DisbursementTxn>
{
	public DisbursementTxnVO() {
		entity = new DisbursementTxn();
	}
	
	public DisbursementTxnVO(DisbursementTxn entity) {
		super(entity);
	}
	
	public String getTxnCcy() {
		return entity.getTxnCcy();
	}
	public void setTxnCcy(String txnCcy) {
		entity.setTxnCcy(txnCcy);
	}
	public String getTxnStatus() {
		return entity.getTxnStatus();
	}
	public void setTxnStatus(String txnStatus) {
		entity.setTxnStatus(txnStatus);
	}
	public String getTxnId() {
		return entity.getTxnId();
	}
	public void setTxnId(String txnId) {
		entity.setTxnId(txnId);
	}
	public String getTxnNarrative() {
		return entity.getTxnNarrative();
	}
	public void setTxnNarrative(String txnNarrative) {
		entity.setTxnNarrative(txnNarrative);
	}
	public Double getAmount() {
		return entity.getAmount();
	}
	public void setAmount(Double amount) {
		entity.setAmount(amount);
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
	public String getCustomerId() {
		return entity.getCustomerId();
	}
	public Date getSyncTime() {
		return entity.getSyncTime();
	}
	public void setSyncTime(Date syncTime) {
		entity.setSyncTime(syncTime);
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((super.getId() == null) ? 0 : super.getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisbursementTxnVO other = (DisbursementTxnVO) obj;
		if (super.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!super.getId().equals(other.getId()))
			return false;
		return true;
	}
}
