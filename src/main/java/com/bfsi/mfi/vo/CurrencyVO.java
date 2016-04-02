package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.Currency;

public class CurrencyVO extends MaintenanceVO<Currency> {

	public CurrencyVO() {
		entity = new Currency();
	}

	public CurrencyVO(Currency entity) {
		super(entity);
	}
	
	public String getCurrencyCode() {
		return super.getId();
	}

	public void setCurrencyCode(String currencyCode) {
		super.setId(currencyCode);
	}
	
	
	public String getCurrencyName() {
		return entity.getCurrencyName();
	}

	public void setCurrencyName(String currencyName) {
		entity.setCurrencyName(currencyName);
	}

	public String getIsoCcyCode() {
		return entity.getIsoCcyCode();
	}

	public void setIsoCcyCode(String isoCcyCode) {
		entity.setIsoCcyCode(isoCcyCode);
	}

	public String getIsoAltCcode() {
		return entity.getIsoAltCcode();
	}

	public void setIsoAltCcode(String isoAltCcode) {
		entity.setIsoAltCcode(isoAltCcode);
	}

	public String getCountry() {
		return entity.getCountry();
	}

	public void setCountry(String country) {
		entity.setCountry(country);
	}

	public String getCcyRoundRule() {
		return entity.getCcyRoundRule();
	}

	public void setCcyRoundRule(String ccyRoundRule) {
		entity.setCcyRoundRule(ccyRoundRule);
	}

	public Double getCurrencyDecimals() {
		return entity.getCurrencyDecimals();
	}

	public void setCurrencyDecimals(Double currencyDecimals) {
		entity.setCurrencyDecimals(currencyDecimals);
	}

	public String getRecordStatus() {
		return entity.getRecordStatus();
	}

	public void setRecordStatus(String recordStatus) {
		entity.setRecordStatus(recordStatus);
	}

	public String getCbsJobId() {
		return entity.getCbsJobId();
	}

	public void setCbsJobId(String cbsJobId) {
		entity.setCbsJobId(cbsJobId);
	}

	public String getSyncTime() {
		return entity.getSyncTime();
	}

	public void setSyncTime(String syncTime) {
		entity.setSyncTime(syncTime);
	}
	
	public String getSyncStatus() {
		return entity.getSyncStatus();
	}

	public void setSyncStatus(String syncStatus) {
		entity.setSyncStatus(syncStatus);
	}
	
	public String getCountryName() {
		return entity.getCountryName();
	}

	public void setCountryName(String countryName) {
		entity.setCountryName(countryName);
		
	}
}
