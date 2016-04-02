package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;

public class DepositCollection extends MaintenanceEntity 
{
	
	public DepositCollection() {
	}

	@Column(name = "TXN_ID", nullable = false)
	public String txnId;
	@Column(name = "DEP_OPEN_DATE", nullable = false)
	public Date depOpenDate;
	@Column(name = "DEP_PAY_FREQ", nullable = false)
	public String depPayFreq;
	@Column(name = "TOTAL_INST_PAID", nullable = false)
	public Double totalInstPaid;
	@Column(name = "DEP_MATURITY_DATE", nullable = false)
	public Date depMaturityDate;
	@Column(name = "DEP_INT_RATE", nullable = false)
	public Double depIntRate;
	@Column(name = "FULL_PARTIAL_FLAG", nullable = false)
	public String fullPartialFlag;
	@Column(name = "DEP_INST_AMT_PAID", nullable = false)
	public Double depInstAmtPaid;
	@Column(name = "TXN_NARRATIVE", nullable = false)
	public String txnNarrative;
	
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public Date getDepOpenDate() {
		return depOpenDate;
	}
	public void setDepOpenDate(Date depOpenDate) {
		this.depOpenDate = depOpenDate;
	}
	public String getDepPayFreq() {
		return depPayFreq;
	}
	public void setDepPayFreq(String depPayFreq) {
		this.depPayFreq = depPayFreq;
	}
	public Double getTotalInstPaid() {
		return totalInstPaid;
	}
	public void setTotalInstPaid(Double totalInstPaid) {
		this.totalInstPaid = totalInstPaid;
	}
	public Date getDepMaturityDate() {
		return depMaturityDate;
	}
	public void setDepMaturityDate(Date depMaturityDate) {
		this.depMaturityDate = depMaturityDate;
	}
	public Double getDepIntRate() {
		return depIntRate;
	}
	public void setDepIntRate(Double depIntRate) {
		this.depIntRate = depIntRate;
	}
	public String getFullPartialFlag() {
		return fullPartialFlag;
	}
	public void setFullPartialFlag(String fullPartialFlag) {
		this.fullPartialFlag = fullPartialFlag;
	}
	public Double getDepInstAmtPaid() {
		return depInstAmtPaid;
	}
	public void setDepInstAmtPaid(Double depInstAmtPaid) {
		this.depInstAmtPaid = depInstAmtPaid;
	}
	public String getTxnNarrative() {
		return txnNarrative;
	}
	public void setTxnNarrative(String txnNarrative) {
		this.txnNarrative = txnNarrative;
	}
		
}