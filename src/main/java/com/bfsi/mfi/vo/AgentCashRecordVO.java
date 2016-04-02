package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.AgentCashRecord;

/**
 * 
 * @author Shabu
 * 
 */
public class AgentCashRecordVO extends MaintenanceVO<AgentCashRecord> {
	public AgentCashRecordVO() {
		entity = new AgentCashRecord();
	}

	public AgentCashRecordVO(AgentCashRecord entity) {
		super(entity);
	}

	public String getEntrySeqNo() {
		return this.entity.getEntrySeqNo();
	}

	public void setEntrySeqNo(String entrySeqNo) {
		entity.setEntrySeqNo(entrySeqNo);
	}

	public String getCashTxnId() {
		return this.entity.getCashTxnId();
	}

	public void setCashTxnId(String cashTxnId) {
		entity.setCashTxnId(cashTxnId);
	}

	public int getCashTxnSeqNo() {
		return this.entity.getCashTxnSeqNo();
	}

	public void setCashTxnSeqNo(int cashTxnSeqNo) {
		entity.setCashTxnSeqNo(cashTxnSeqNo);
	}

	public String getTxnSource() {
		return this.entity.getTxnSource();
	}

	public void setTxnSource(String txnSource) {
		entity.setTxnSource(txnSource);
	}

	public Date getTxnDateTime() {
		return this.entity.getTxnDateTime();
	}

	public void setTxnDateTime(Date txnDateTime) {
		entity.setTxnDateTime(txnDateTime);
	}

	public String getTxnCode() {
		return this.entity.getTxnCode();
	}

	public void setTxnCode(String txnCode) {
		entity.setTxnCode(txnCode);
	}

	public String getAgentId() {
		return this.entity.getAgentId();
	}

	public void setAgentId(String agentId) {
		entity.setAgentId(agentId);
	}

	public String getDeviceId() {
		return this.entity.getDeviceId();
	}

	public void setDeviceId(String deviceId) {
		entity.setDeviceId(deviceId);
	}

	public String getAgendaId() {
		return this.entity.getAgendaId();
	}

	public void setAgendaId(String agendaId) {
		entity.setAgendaId(agendaId);
	}

	public int getAgendaSeqNo() {
		return this.entity.getAgendaSeqNo();
	}

	public void setAgendaSeqNo(int agendaSeqNo) {
		entity.setAgendaSeqNo(agendaSeqNo);
	}

	public String getTxnCcy() {
		return this.entity.getTxnCcy();
	}

	public void setTxnCcy(String txnCcy) {
		entity.setTxnCcy(txnCcy);
	}

	public String getDrCrIndicator() {
		return this.entity.getDrCrIndicator();
	}

	public void setDrCrIndicator(String drCrIndicator) {
		entity.setDrCrIndicator(drCrIndicator);
	}

	public double getAmount() {
		return this.entity.getAmount();
	}

	public void setAmount(double amount) {
		entity.setAmount(amount);
	}

	public String getSyncStatus() {
		return this.entity.getSyncStatus();
	}

	public void setSyncStatus(String syncStatus) {
		entity.setSyncStatus(syncStatus);
	}

	public Date getSyncTime() {
		return this.entity.getSyncTime();
	}

	public void setSyncTime(Date syncTime) {
		entity.setSyncTime(syncTime);
	}

	public String getAuthStatus() {
		return this.entity.getAuthStatus();
	}

	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus);
	}

	public String getIsReversal() {
		return this.entity.getIsReversal();
	}

	public void setIsReversal(String isReversal) {
		entity.setIsReversal(isReversal);
	}

	public String getIsDeleted() {
		return this.entity.getIsDeleted();
	}

	public void setIsDeleted(String isDeleted) {
		entity.setIsDeleted(isDeleted);
	}
}
