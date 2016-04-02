package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "MFI_AGENT_CASH_TILL")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Cash extends MaintenanceEntity {
	public Cash() {
	}

	@Column(name = "TILL_ID", nullable = false)
	private String tillId;
	
	@Column(name = "AGENT_ID", nullable = false)
	private String agentId;

	@Column(name = "CASH_TXN_TYPE", nullable = false)
	private String cashTxnType;

	@Column(name = "TXN_CODE", nullable = false)
	private String txnCode;

	@Column(name = "TXN_CCY_CODE", nullable = false)
	private String currencyCode;

	@Column(name = "cash_amount_calc", nullable = false)
	private Double cashAmount;

	@Column(name = "cash_amount_calc", nullable = false)
	private Double ctgAmount;

	@Column(name = "TXN_REMARKS", nullable = false)
	private String txnRemarks;

	@Column(name = "IS_ACTIVE", nullable = false)
	private String isActive;

	@Column(name = "AUTH_STATUS", nullable = false)
	private String authStatus;

	@Column(name = "INIT_BY_USER_ID", nullable = false)
	private String initByUserId;

	@Column(name = "VERIFY_BY_USER_ID", nullable = false)
	private String verifyByUserId;

	@Column(name = "TXN_INIT_DATETIME", nullable = false)
	private Date txnInitDatetime;

	@Column(name = "TXN_AUTH_DATETIME", nullable = false)
	private Date txnAuthDatetime;
	
	
	public String getTillId() {
		return tillId;
	}

	public void setTillId(String tillId) {
		this.tillId = tillId;
	}

	public Double getCtgAmount() {
		return ctgAmount;
	}

	public void setCtgAmount(Double ctgAmount) {
		this.ctgAmount = ctgAmount;
	}

	public String getCashTxnType() {
		return cashTxnType;
	}

	public void setCashTxnType(String cashTxnType) {
		this.cashTxnType = cashTxnType;
	}

	public String getTxnCode() {
		return txnCode;
	}

	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Double getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
	}

	public String getTxnRemarks() {
		return txnRemarks;
	}

	public void setTxnRemarks(String txnRemarks) {
		this.txnRemarks = txnRemarks;
	}

	public String getInitByUserId() {
		return initByUserId;
	}

	public void setInitByUserId(String initByUserId) {
		this.initByUserId = initByUserId;
	}

	public String getVerifyByUserId() {
		return verifyByUserId;
	}

	public void setVerifyByUserId(String verifyByUserId) {
		this.verifyByUserId = verifyByUserId;
	}

	public Date getTxnInitDatetime() {
		return txnInitDatetime;
	}

	public void setTxnInitDatetime(Date txnInitDatetime) {
		this.txnInitDatetime = txnInitDatetime;
	}

	public Date getTxnAuthDatetime() {
		return txnAuthDatetime;
	}

	public void setTxnAuthDatetime(Date txnAuthDatetime) {
		this.txnAuthDatetime = txnAuthDatetime;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
