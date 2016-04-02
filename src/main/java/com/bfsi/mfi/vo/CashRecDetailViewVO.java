package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.CashRecDetailView;

public class CashRecDetailViewVO extends MaintenanceVO<CashRecDetailView>{
	
	public CashRecDetailViewVO() {
		entity = new CashRecDetailView();
	}

	public CashRecDetailViewVO(CashRecDetailView entity) {
		super(entity);
	}
	

	public String getTxnId() {
		return entity.getTxnId();
	}

	public void setTxnId(String txnId) {
		entity.setTxnId(txnId);
	}

	public Date getTxnDatetime() {
		return entity.getTxnDatetime();
	}

	public void setTxnDatetime(Date txnDatetime) {
		entity.setTxnDatetime(txnDatetime); 
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

	public String getAgnId() {
		return entity.getAgnId();
	}

	public void setAgnId(String agnId) {
		entity.setAgnId(agnId);
	}

	public Integer getSeqNo() {
		return entity.getSeqNo();
	}

	public void setSeqNo(Integer seqNo) {
		entity.setSeqNo(seqNo);
	}

	public String getCcy() {
		return entity.getCcy();
	}

	public void setCcy(String ccy) {
		entity.setCcy(ccy); 
	}

	public String getDrCr() {
		return entity.getDrCr();
	}

	public void setDrCr(String drCr) {
		entity.setDrCr(drCr);
	}

	public Double getAmt() {
		return entity.getAmt();
	}

	public void setAmt(Double amt) {
		entity.setAmt(amt);
	}

	public String getAuthStat() {
		return entity.getAuthStat();
	}

	public void setAuthStat(String authStat) {
		entity.setAuthStat(authStat);
	}

	public String getRevrStat() {
		return entity.getRevrStat();
	}

	public void setRevrStat(String revrStat) {
		entity.setRevrStat(revrStat); 
	}

	public String getDelStat() {
		return entity.getDelStat();
	}

	public void setDelStat(String delStat) {
		entity.setDelStat(delStat);
	}
	
	
   /*public Object clone() {
		
	CashRecDetailViewVO copyObj = new CashRecDetailViewVO();
		copyObj.setId(super.getId());
		copyObj.setAgentId(getAgentId());
		copyObj.setTxnDate(getTxnDate());
		copyObj.setDrSum(getDrSum());
		copyObj.setCrSum(getCrSum());
		copyObj.setToBeSettled(getToBeSettled());
		
		return copyObj;
	}*/
	
	
	
	
}
