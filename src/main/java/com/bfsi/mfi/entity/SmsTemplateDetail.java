package com.bfsi.mfi.entity;

public class SmsTemplateDetail extends MaintenanceEntity{
	private String txnCode;
	private String txnSms;
	private String dynFields;
	
	public String getTxnCode() {
		return txnCode;
	}
	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}
	public String getTxnSms() {
		return txnSms;
	}
	public void setTxnSms(String txnSms) {
		this.txnSms = txnSms;
	}
	public String getDynFields() {
		return dynFields;
	}
	public void setDynFields(String dynFields) {
		this.dynFields = dynFields;
	}

}
