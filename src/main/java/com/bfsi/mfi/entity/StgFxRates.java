package com.bfsi.mfi.entity;

public class StgFxRates {
	
	private String brnCode;
	private String ccy1;
	private String ccy2;
	private String recordStat;
	private double midRate;
	private double buyRate;
	private double saleRate;
	private String cbsUploadJobId;
	private String ibsInternalErr;
	private String ibsErrDesc;
	
	public String getBrnCode() {
		return brnCode;
	}
	public void setBrnCode(String brnCode) {
		this.brnCode = brnCode;
	}
	public String getCcy1() {
		return ccy1;
	}
	public void setCcy1(String ccy1) {
		this.ccy1 = ccy1;
	}
	public String getCcy2() {
		return ccy2;
	}
	public void setCcy2(String ccy2) {
		this.ccy2 = ccy2;
	}
	public String getRecordStat() {
		return recordStat;
	}
	public void setRecordStat(String recordStat) {
		this.recordStat = recordStat;
	}
	public double getMidRate() {
		return midRate;
	}
	public void setMidRate(double midRate) {
		this.midRate = midRate;
	}
	public double getBuyRate() {
		return buyRate;
	}
	public void setBuyRate(double buyRate) {
		this.buyRate = buyRate;
	}
	public double getSaleRate() {
		return saleRate;
	}
	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
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
