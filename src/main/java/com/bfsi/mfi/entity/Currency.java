package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "CBS_CCY_CODES")
public class Currency extends MaintenanceEntity {
	public Currency() {
	}
	
	@Column(name = "CCY_NAME", nullable = false)
	private String currencyName;
	
	@Column(name = "ISO_CCY_CODE", nullable = false)
	private String isoCcyCode;

	@Column(name = "ISO_ALT_CCODE", nullable = false)
	private String isoAltCcode;
	
	@Column(name = "COUNTRY", nullable = false)
	private String country;
	
	@Column(name = "CCY_ROUND_RULE", nullable = false)
	private String ccyRoundRule;
	
	@Column(name = "CCY_DECIMALS", nullable = false)
	private Double currencyDecimals;
	
	
	@Column(name = "RECORD_STAT", nullable = false)
	private String recordStatus;
	
	@Column(name = "CBS_UPLD_JOB_ID", nullable = false)
	private String cbsJobId;
	
	@Column(name = "SYNC_TIME", nullable = false)	
	private String syncTime;
	
	@Column(name = "SYNC_STATUS", nullable = false)	
	private String syncStatus;
	
	@Column(name = "DESN", nullable = false)	
	private String countryName;

	
	public String getSyncStatus() {
		return syncStatus;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getIsoCcyCode() {
		return isoCcyCode;
	}

	public void setIsoCcyCode(String isoCcyCode) {
		this.isoCcyCode = isoCcyCode;
	}

	public String getIsoAltCcode() {
		return isoAltCcode;
	}

	public void setIsoAltCcode(String isoAltCcode) {
		this.isoAltCcode = isoAltCcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCcyRoundRule() {
		return ccyRoundRule;
	}

	public void setCcyRoundRule(String ccyRoundRule) {
		this.ccyRoundRule = ccyRoundRule;
	}

	public Double getCurrencyDecimals() {
		return currencyDecimals;
	}

	public void setCurrencyDecimals(Double currencyDecimals) {
		this.currencyDecimals = currencyDecimals;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getCbsJobId() {
		return cbsJobId;
	}

	public void setCbsJobId(String cbsJobId) {
		this.cbsJobId = cbsJobId;
	}

	public String getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(String syncTime) {
		this.syncTime = syncTime;
	}	
}
