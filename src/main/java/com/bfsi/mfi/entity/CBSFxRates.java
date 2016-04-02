package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "CBS_FX_RATES")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CBSFxRates extends MaintenanceEntity{

	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	public CBSFxRates() {
	}

	@Column(name = "BRN_CODE", nullable = false)
	private String brnCode;
	@Column(name = "CCY1", nullable = false)
	private String ccy1;
	@Column(name = "CCY2", nullable = false)
	private String ccy2;
	@Column(name = "RECORD_STAT", nullable = false)
	private String recordStat;
	
	@Column(name = "MID_RATE", nullable = false)
	private Double midRate;
	@Column(name = "BUY_RATE", nullable = false)
	private Double buyRate;
	@Column(name = "SALE_RATE", nullable = false)
	private Double saleRate;
	
	
	@Column(name = "CBS_UPLD_JOB_ID", nullable = false)
	private String cbsUpldJobId;
	@Column(name = "SYNC_STATUS", nullable = false)
	private String syncStatus;
	@Column(name = "SYNC_TIME", nullable = false)
	private String syncTime;
	
	
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
		//System.out.println("Inside setCcy1="+ccy1);
	}
	
	public String getCcy2() {
		return ccy2;
	}
	public void setCcy2(String ccy2) {
		this.ccy2 = ccy2;
		//System.out.println("Inside setCcy2="+ccy2);
	}
	
	public String getRecordStat() {
		return recordStat;
	}
	public void setRecordStat(String recordStat) {
		this.recordStat = recordStat;
	}
	
	public Double getMidRate() {
		return midRate;
	}
	public void setMidRate(Double midRate) {
		this.midRate = midRate;
	}
	
	public Double getBuyRate() {
		return buyRate;
	}
	public void setBuyRate(Double buyRate) {
		this.buyRate = buyRate;
	}
	
	public Double getSaleRate() {
		return saleRate;
	}
	public void setSaleRate(Double saleRate) {
		this.saleRate = saleRate;
	}
	
	public String getCbsUpldJobId() {
		return cbsUpldJobId;
	}
	public void setCbsUpldJobId(String cbsUpldJobId) {
		this.cbsUpldJobId = cbsUpldJobId;
	}
	
	public String getSyncStatus() {
		return syncStatus;
	}
	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}
	
	public String getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(String syncTime) {
		this.syncTime = syncTime;
	}
		
	
}
