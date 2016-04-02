package com.bfsi.mfi.entity;

import java.util.Date;

/**
 * 
 * @author Shabu
 *
 */
public class AgentCashRecord extends MaintenanceEntity {

	private String entrySeqNo;
	private String cashTxnId;
	private int cashTxnSeqNo;
	private String txnSource;
	private Date txnDateTime;
	private String txnCode;
	private String agentId;
	private String deviceId;
	private String agendaId;
	private int agendaSeqNo;
	private String txnCcy;
	private String drCrIndicator;
	private double amount;

	private String syncStatus;
	private Date syncTime;
	private String authStatus;

	private String isReversal;
	private String isDeleted;

	public String getEntrySeqNo() {
		return entrySeqNo;
	}

	public void setEntrySeqNo(String entrySeqNo) {
		this.entrySeqNo = entrySeqNo;
	}

	public String getCashTxnId() {
		return cashTxnId;
	}

	public void setCashTxnId(String cashTxnId) {
		this.cashTxnId = cashTxnId;
	}

	public int getCashTxnSeqNo() {
		return cashTxnSeqNo;
	}

	public void setCashTxnSeqNo(int cashTxnSeqNo) {
		this.cashTxnSeqNo = cashTxnSeqNo;
	}

	public String getTxnSource() {
		return txnSource;
	}

	public void setTxnSource(String txnSource) {
		this.txnSource = txnSource;
	}

	public Date getTxnDateTime() {
		return txnDateTime;
	}

	public void setTxnDateTime(Date txnDateTime) {
		this.txnDateTime = txnDateTime;
	}

	public String getTxnCode() {
		return txnCode;
	}

	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(String agendaId) {
		this.agendaId = agendaId;
	}

	public int getAgendaSeqNo() {
		return agendaSeqNo;
	}

	public void setAgendaSeqNo(int agendaSeqNo) {
		this.agendaSeqNo = agendaSeqNo;
	}

	public String getTxnCcy() {
		return txnCcy;
	}

	public void setTxnCcy(String txnCcy) {
		this.txnCcy = txnCcy;
	}

	public String getDrCrIndicator() {
		return drCrIndicator;
	}

	public void setDrCrIndicator(String drCrIndicator) {
		this.drCrIndicator = drCrIndicator;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public String getIsReversal() {
		return isReversal;
	}

	public void setIsReversal(String isReversal) {
		this.isReversal = isReversal;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

}
