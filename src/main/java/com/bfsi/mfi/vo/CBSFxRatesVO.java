package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.CBSFxRates;

public class CBSFxRatesVO extends MaintenanceVO<CBSFxRates>{
	
	public CBSFxRatesVO() {
		entity = new CBSFxRates();
	}

	public CBSFxRatesVO(CBSFxRates entity) {
		super(entity);
	}
	
	private Double ccy1Amount=1.00;
	private Double ccy2Amount=1.00;
	
	public Double getCcy1Amount() {
		return ccy1Amount;
	}
	
	public void setCcy1Amount(Double ccy1Amount) {
		this.ccy1Amount = ccy1Amount;
	}

	public Double getCcy2Amount() {
		return ccy2Amount;
	}

	public void setCcy2Amount(Double ccy2Amount) {
		this.ccy2Amount = ccy2Amount;
	}

	public String getBrnCode() {
		return  entity.getBrnCode();
	}
	public void setBrnCode(String brnCode) {
		entity.setBrnCode(brnCode); 
	}
	
	public String getCcy1() {
		return  entity.getCcy1();
	}
	public void setCcy1(String ccy1) {
		entity.setCcy1(ccy1); 
	}
	
	public String getCcy2() {
		return  entity.getCcy2();
	}
	public void setCcy2(String ccy2) {
		entity.setCcy2(ccy2); 
	}
	
	public String getRecordStat() {
		return  entity.getRecordStat();
	}
	public void setRecordStat(String recordStat) {
		entity.setRecordStat(recordStat);
	}
	
	public Double getMidRate() {
		return  entity.getMidRate();
	}
	public void setMidRate(Double midRate) {
		entity.setMidRate(midRate); 
	}
	
	public Double getBuyRate() {
		return  entity.getBuyRate();
	}
	public void setBuyRate(Double buyRate) {
		entity.setBuyRate(buyRate); 
	}
	
	public Double getSaleRate() {
		return  entity.getSaleRate();
	}
	public void setSaleRate(Double saleRate) {
		entity.setSaleRate(saleRate); 
	}
	
	public String getCbsUpldJobId() {
		return  entity.getCbsUpldJobId();
	}
	public void setCbsUpldJobId(String cbsUpldJobId) {
		entity.setCbsUpldJobId(cbsUpldJobId); 
	}
	
	public String getSyncStatus() {
		return  entity.getSyncStatus();
	}
	public void setSyncStatus(String syncStatus) {
		entity.setSyncStatus(syncStatus); 
	}
	
	public String getSyncTime() {
		return  entity.getSyncTime();
	}
	public void setSyncTime(String syncTime) {
		entity.setSyncTime(syncTime);
	}
	
	
	public Object clone() {
		CBSFxRatesVO copyObj = new CBSFxRatesVO();
		copyObj.setBrnCode(getBrnCode());
		copyObj.setCcy1(getCcy1());
		copyObj.setCcy2(getCcy2());
		copyObj.setRecordStat(getRecordStat());
		copyObj.setMidRate(getMidRate());
		copyObj.setBuyRate(getBuyRate());
		copyObj.setSaleRate(getSaleRate());
		copyObj.setCbsUpldJobId(getCbsUpldJobId());
		copyObj.setSyncStatus(getSyncStatus());
		copyObj.setSyncTime(getSyncTime());
		
		copyObj.setCcy1Amount(this.ccy1Amount);
		copyObj.setCcy2Amount(this.ccy2Amount);
		return copyObj;
	}
}
