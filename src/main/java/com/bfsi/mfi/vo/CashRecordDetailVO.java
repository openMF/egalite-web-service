package com.bfsi.mfi.vo;


import java.util.Date;

import com.bfsi.mfi.entity.CashRecordDetail;

public class CashRecordDetailVO extends MaintenanceVO<CashRecordDetail>{
	
	public CashRecordDetailVO() {
		entity = new CashRecordDetail();
	}

	public CashRecordDetailVO(CashRecordDetail entity) {
		super(entity);
	}
	
	
	
	public String getTxnId() {
		return entity.getTxnId();
	}
	public void setTxnId(String txnId) {
		entity.setTxnId(txnId);
	}
	public Date getTxnDate() {
		return entity.getTxnDate();
	}
	public void setTxnDate(Date txnDate) {
		entity.setTxnDate(txnDate);
	}
	public Date getSyncTime() {
		return entity.getSyncTime();
	}
	public void setSyncTime(Date syncTime) {
		entity.setSyncTime(syncTime);
	}
	public String getTxnDesc() {
		return entity.getTxnDesc();
	}
	public void setTxnDesc(String txnDesc) {
		entity.setTxnDesc(txnDesc);
	}
	public String getAgendaId() {
		return entity.getAgendaId();
	}
	public void setAgendaId(String agendaId) {
		entity.setAgendaId(agendaId);
	}
	public Integer getSeqNo() {
		return entity.getSeqNo();
	}
	public void setSeqNo(Integer seqNo) {
		entity.setSeqNo(seqNo);
	}
	public String getCurrency() {
		return entity.getCurrency();
	}
	public void setCurrency(String currency) {
		entity.setCurrency(currency);
	}
	public String getDrCr() {
		return entity.getDrCr();
	}
	public void setDrCr(String drCr) {
		entity.setDrCr( drCr);
	}
	public double getAmount() {
		return entity.getAmount();
	}
	public void setAmount(double amount) {
		entity.setAmount(amount);
	}
	public String getAuthStatus() {
		return entity.getAuthStatus();
	}
	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus);
	}
	public String getRevStatus() {
		return entity.getRevStatus();
	}
	public void setRevStatus(String revStatus) {
		entity.setRevStatus(revStatus);
	}
	public String getDeleteStatus() {
		return entity.getDeleteStatus();
	}
	public void setDeleteStatus(String deleteStatus) {
		entity.setDeleteStatus(deleteStatus);
	}
	public String getAgentId() {
		return entity.getAgentId();
	}
	public void setAgentId(String agentId) {
		entity.setAgentId(agentId);
	}

}
