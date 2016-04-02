package com.bfsi.mfi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "mfi_cash_rec_sumup_v")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CashRecSumupView extends MaintenanceEntity {
	public CashRecSumupView() {
	}

	// key_value used as super id..

	@Column(name = "AGENT_ID", nullable = false)
	private String agentId;

	@Column(name = "TXN_DATE", nullable = false)
	private String txnDate;

	@Column(name = "DR_SUM", nullable = false)
	private Double drSum;

	@Column(name = "CR_SUM", nullable = false)
	private Double crSum;

	@Column(name = "TO_BE_SETTLED", nullable = false)
	private Double toBeSettled;
	
	private List<CashRecordDetail> cashRecordDetail;
	

	public List<CashRecordDetail> getCashRecordDetail() {
		return cashRecordDetail ==null? new ArrayList<CashRecordDetail>():cashRecordDetail;
	}

	public void setCashRecordDetail(List<CashRecordDetail> cashRecordDetail) {
		this.cashRecordDetail = cashRecordDetail;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}

	public Double getDrSum() {
		return drSum;
	}

	public void setDrSum(Double drSum) {
		this.drSum = drSum;
	}

	public Double getCrSum() {
		return crSum;
	}

	public void setCrSum(Double crSum) {
		this.crSum = crSum;
	}

	public Double getToBeSettled() {
		return toBeSettled;
	}

	public void setToBeSettled(Double toBeSettled) {
		this.toBeSettled = toBeSettled;
	}

}
