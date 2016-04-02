package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.DepositCollection;

public class DepositCollectionVO extends MaintenanceVO<DepositCollection>
{
	public DepositCollectionVO() {
		entity = new DepositCollection();
	}

	public DepositCollectionVO(DepositCollection entity) {
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

	public Double getTotalInstPaid() {
		return entity.totalInstPaid;
	}

	public void setTotalInstPaid(Double totalInstPaid) {
		entity.totalInstPaid = totalInstPaid;
	}

	public Date getDepMaturityDate() {
		return entity.depMaturityDate;
	}

	public void setDepMaturityDate(Date depMaturityDate) {
		entity.depMaturityDate = depMaturityDate;
	}

	public Double getDepIntRate() {
		return entity.depIntRate;
	}

	public void setDepIntRate(Double depIntRate) {
		entity.depIntRate = depIntRate;
	}

	public String getFullPartialFlag() {
		return entity.fullPartialFlag;
	}

	public void setFullPartialFlag(String fullPartialFlag) {
		entity.fullPartialFlag = fullPartialFlag;
	}

	public Double getDepInstAmtPaid() {
		return entity.depInstAmtPaid;
	}

	public void setDepInstAmtPaid(Double depInstAmtPaid) {
		entity.depInstAmtPaid = depInstAmtPaid;
	}

	public String getTxnNarrative() {
		return entity.txnNarrative;
	}

	public void setTxnNarrative(String txnNarrative) {
		entity.txnNarrative = txnNarrative;
	}
	
	
}
