package com.bfsi.mfi.entity;

public class StgCurrency {
	private String ccyCode;
	private String ccyName;
	private String isoCcyCode;
	private String isoAltCcode;
	private String country;
	private String ccyRoundRule;
	private double ccyDecimal;
	private String recordStat;
	private String cbsUploadJobId;
	private String ibsInternalErr;
	private String ibsErrDesc;
	
	public String getCcyCode() {
		return ccyCode;
	}
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}
	public String getCcyName() {
		return ccyName;
	}
	public void setCcyName(String ccyName) {
		this.ccyName = ccyName;
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
	public double getCcyDecimal() {
		return ccyDecimal;
	}
	public void setCcyDecimal(double ccyDecimal) {
		this.ccyDecimal = ccyDecimal;
	}
	public String getRecordStat() {
		return recordStat;
	}
	public void setRecordStat(String recordStat) {
		this.recordStat = recordStat;
	}
	public String getCbsUploadJobId() {
		return cbsUploadJobId;
	}
	public void setCbsUploadJobId(String cbsUploadJobId) {
		this.cbsUploadJobId = cbsUploadJobId;
	}
	public String getIbsInternalErr() {
		return ibsInternalErr;
	}
	public void setIbsInternalErr(String ibsInternalErr) {
		this.ibsInternalErr = ibsInternalErr;
	}
	public String getIbsErrDesc() {
		return ibsErrDesc;
	}
	public void setIbsErrDesc(String ibsErrDesc) {
		this.ibsErrDesc = ibsErrDesc;
	}
}
