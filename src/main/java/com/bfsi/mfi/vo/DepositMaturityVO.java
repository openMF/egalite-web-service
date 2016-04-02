package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.DepositMaturity;

public class DepositMaturityVO extends MaintenanceVO<DepositMaturity>
{
	public DepositMaturityVO() {
		entity = new DepositMaturity();
	}

	public DepositMaturityVO(DepositMaturity entity) {
		super(entity);
	}
	
	
	public String getTxnId() {
		return entity.txnId;
	}

	public void setTxnId(String txnId) {
		entity.txnId = txnId;
	}

	public Date getDepOpenDate() {
		return entity.depOpenDate;
	}

	public void setDepOpenDate(Date depOpenDate) {
		entity.depOpenDate = depOpenDate;
	}

	public String getDepPayFreq() {
		return entity.depPayFreq;
	}

	public void setDepPayFreq(String depPayFreq) {
		entity.depPayFreq = depPayFreq;
	}

	public Double getDepInstAmt() {
		return entity.depInstAmt;
	}

	public void setDepInstAmt(Double depInstAmt) {
		entity.depInstAmt = depInstAmt;
	}

	public Double getDepIntRate() {
		return entity.depIntRate;
	}

	public void setDepIntRate(Double depIntRate) {
		entity.depIntRate = depIntRate;
	}

	public Double getDepInstAmtPaid() {
		return entity.depInstAmtPaid;
	}

	public void setDepInstAmtPaid(Double depInstAmtPaid) {
		entity.depInstAmtPaid = depInstAmtPaid;
	}

	public Double getDepIntAccured() {
		return entity.depIntAccured;
	}

	public void setDepIntAccured(Double depIntAccured) {
		entity.depIntAccured = depIntAccured;
	}

	public Double getDepMaturityAmtPaid() {
		return entity.depMaturityAmtPaid;
	}

	public void setDepMaturityAmtPaid(Double depMaturityAmtPaid) {
		entity.depMaturityAmtPaid = depMaturityAmtPaid;
	}

	public Date getDepMaturityDate() {
		return entity.depMaturityDate;
	}

	public void setDepMaturityDate(Date depMaturityDate) {
		entity.depMaturityDate = depMaturityDate;
	}

	public String getRedemptionFlag() {
		return entity.redemptionFlag;
	}

	public void setRedemptionFlag(String redemptionFlag) {
		entity.redemptionFlag = redemptionFlag;
	}

	public Date getRedemptionPayoutDate() {
		return entity.redemptionPayoutDate;
	}

	public void setRedemptionPayoutDate(Date redemptionPayoutDate) {
		entity.redemptionPayoutDate = redemptionPayoutDate;
	}

	public Double getRedemptionAmount() {
		return entity.redemptionAmount;
	}

	public void setRedemptionAmount(Double redemptionAmount) {
		entity.redemptionAmount = redemptionAmount;
	}

	public String getTxnNarrative() {
		return entity.txnNarrative;
	}

	public void setTxnNarrative(String txnNarrative) {
		entity.txnNarrative = txnNarrative;
	}
	
}
