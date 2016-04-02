package com.bfsi.mfi.entity;

public class CashTxnCode extends MaintenanceEntity {
	private String txnCode;
	private String txnDesc;
	
	public CashTxnCode() {
	}
	public String getTxnCode() {
		return txnCode;
	}
	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}
	public String getTxnDesc() {
		return txnDesc;
	}
	public void setTxnDesc(String txnDesc) {
		this.txnDesc = txnDesc;
	}
	

}
