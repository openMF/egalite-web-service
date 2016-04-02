package com.bfsi.mfi.vo;

import java.util.Date;

public class AgentCashBalanceVO extends MaintenanceVO{
	private double systemPosition;
	private Date txnTime;
public double getSystemPosition() {
		return systemPosition;
	}
	public void setSystemPosition(double systemPosition) {
		this.systemPosition = systemPosition;
	}
	public Date getTxnTime() {
		return txnTime;
	}
	public void setTxnTime(Date txnTime) {
		this.txnTime = txnTime;
	}

}
