package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.CashTxnCode;


public class CashTxnCodeVO extends MaintenanceVO<CashTxnCode> {
	public CashTxnCodeVO() {
		entity = new CashTxnCode();
	}
	
	public CashTxnCodeVO(CashTxnCode entity) {
		super(entity);
	}	
	
	public String getTxnCode() {
		return this.entity.getTxnCode();
	}

	public void setTxnCode(String txnCode) {
		this.entity.setTxnCode(txnCode);
	}

	public String getTxnDesc() {
		return this.entity.getTxnDesc();
	}

	public void setTxnDesc(String txnDesc) {
		this.entity.setTxnDesc(txnDesc);
	}
	

}
