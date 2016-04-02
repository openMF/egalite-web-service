package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;

public class DepositMaturity extends MaintenanceEntity 
{
	
	public DepositMaturity() {
	}

	@Column(name = "TXN_ID", nullable = false)
	public String txnId;
	@Column(name = "DEP_OPEN_DATE", nullable = false)
	public Date depOpenDate;
	@Column(name = "DEP_PAY_FREQ", nullable = false)
	public String depPayFreq;
	@Column(name = "DEP_INST_AMT", nullable = false)
	public Double depInstAmt;
	@Column(name = "DEP_INT_RATE", nullable = false)
	public Double depIntRate;
	@Column(name = "DEP_INST_AMT_PAID", nullable = false)
	public Double depInstAmtPaid;
	@Column(name = "DEP_INT_ACCRUED", nullable = false)
	public Double depIntAccured;
	@Column(name = "DEP_MATURITY_AMT_PAID", nullable = false)
	public Double depMaturityAmtPaid;
	@Column(name = "DEP_MATURITY_DATE", nullable = false)
	public Date depMaturityDate;
	@Column(name = "REDEMPTION_FLAG", nullable = false)
	public String redemptionFlag;
	@Column(name = "REDEMPTION_PAYOUT_DATE", nullable = false)
	public Date redemptionPayoutDate;
	@Column(name = "REDEMPTION_AMOUNT", nullable = false)
	public Double redemptionAmount;
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
	public Double getDepInstAmt() {
		return depInstAmt;
	}
	public void setDepInstAmt(Double depInstAmt) {
		this.depInstAmt = depInstAmt;
	}
	public Double getDepIntRate() {
		return depIntRate;
	}
	public void setDepIntRate(Double depIntRate) {
		this.depIntRate = depIntRate;
	}
	public Double getDepInstAmtPaid() {
		return depInstAmtPaid;
	}
	public void setDepInstAmtPaid(Double depInstAmtPaid) {
		this.depInstAmtPaid = depInstAmtPaid;
	}
	public Double getDepIntAccured() {
		return depIntAccured;
	}
	public void setDepIntAccured(Double depIntAccured) {
		this.depIntAccured = depIntAccured;
	}
	public Double getDepMaturityAmtPaid() {
		return depMaturityAmtPaid;
	}
	public void setDepMaturityAmtPaid(Double depMaturityAmtPaid) {
		this.depMaturityAmtPaid = depMaturityAmtPaid;
	}
	public Date getDepMaturityDate() {
		return depMaturityDate;
	}
	public void setDepMaturityDate(Date depMaturityDate) {
		this.depMaturityDate = depMaturityDate;
	}
	public String getRedemptionFlag() {
		return redemptionFlag;
	}
	public void setRedemptionFlag(String redemptionFlag) {
		this.redemptionFlag = redemptionFlag;
	}
	public Date getRedemptionPayoutDate() {
		return redemptionPayoutDate;
	}
	public void setRedemptionPayoutDate(Date redemptionPayoutDate) {
		this.redemptionPayoutDate = redemptionPayoutDate;
	}
	public Double getRedemptionAmount() {
		return redemptionAmount;
	}
	public void setRedemptionAmount(Double redemptionAmount) {
		this.redemptionAmount = redemptionAmount;
	}
	public String getTxnNarrative() {
		return txnNarrative;
	}
	public void setTxnNarrative(String txnNarrative) {
		this.txnNarrative = txnNarrative;
	}
	
}