package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "mfi_cash_rec_detail_v")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CashRecDetailView extends MaintenanceEntity {
	public CashRecDetailView() {
	}

	// key_value used as super id..
	
	@Column(name = "TXN_ID", nullable = false)
	private String txnId;
	
	@Column(name = "TXN_DATETIME", nullable = false)
	private Date txnDatetime;
	
	@Column(name = "sync_time", nullable = false)
	private Date syncTime;
	
	@Column(name = "txn_desc", nullable = false)
	private String txnDesc;
	
	@Column(name = "agn_id", nullable = false)
	private String agnId;
	
	@Column(name = "seq_no", nullable = false)
	private Integer seqNo;
	
	@Column(name = "CCY", nullable = false)
	private String ccy;
	
	@Column(name = "DR_CR", nullable = false)
	private String drCr;
	
	@Column(name = "AMT", nullable = false)
	private Double amt;
	
	@Column(name = "auth_stat", nullable = false)
	private String authStat;
	
	@Column(name = "revr_stat", nullable = false)
	private String revrStat;
	
	@Column(name = "del_stat", nullable = false)
	private String delStat;

	
	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public Date getTxnDatetime() {
		return txnDatetime;
	}

	public void setTxnDatetime(Date txnDatetime) {
		this.txnDatetime = txnDatetime;
	}

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	public String getTxnDesc() {
		return txnDesc;
	}

	public void setTxnDesc(String txnDesc) {
		this.txnDesc = txnDesc;
	}

	public String getAgnId() {
		return agnId;
	}

	public void setAgnId(String agnId) {
		this.agnId = agnId;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public String getDrCr() {
		return drCr;
	}

	public void setDrCr(String drCr) {
		this.drCr = drCr;
	}

	public Double getAmt() {
		return amt;
	}

	public void setAmt(Double amt) {
		this.amt = amt;
	}

	public String getAuthStat() {
		return authStat;
	}

	public void setAuthStat(String authStat) {
		this.authStat = authStat;
	}

	public String getRevrStat() {
		return revrStat;
	}

	public void setRevrStat(String revrStat) {
		this.revrStat = revrStat;
	}

	public String getDelStat() {
		return delStat;
	}

	public void setDelStat(String delStat) {
		this.delStat = delStat;
	}
	
	
	
	
	
	
	
}
