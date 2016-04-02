package com.bfsi.mfi.cbs.request;

import java.util.Date;

public class CbsDepositCollectionRequest extends CbsBaseRequest {

	private String ibsOutSeqNo;
	private String txnRefNo;
	private String seqNo;
	private String depositAccNo;
	private String custId;
	private String branchCode;
	private String moduleCode;
	private String txnCode;
	private String txnIdentifier;
	private Double amountDue;
	private Double amountSettled;
	private String ccyCode;
	private String fullPartIndicator;
	
private Date txnInitTime;
	
	

	public Date getTxnInitTime() {
		return txnInitTime;
	}

	public void setTxnInitTime(Date txnInitTime) {
		this.txnInitTime = txnInitTime;
	}

	public String getIbsOutSeqNo() {
		return ibsOutSeqNo;
	}

	public void setIbsOutSeqNo(String ibsOutSeqNo) {
		this.ibsOutSeqNo = ibsOutSeqNo;
	}

	public String getTxnRefNo() {
		return txnRefNo;
	}

	public void setTxnRefNo(String txnRefNo) {
		this.txnRefNo = txnRefNo;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}



	public String getDepositAccNo() {
		return depositAccNo;
	}

	public void setDepositAccNo(String depositAccNo) {
		this.depositAccNo = depositAccNo;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getTxnCode() {
		return txnCode;
	}

	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}

	public String getTxnIdentifier() {
		return txnIdentifier;
	}

	public void setTxnIdentifier(String txnIdentifier) {
		this.txnIdentifier = txnIdentifier;
	}

	public Double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(Double amountDue) {
		this.amountDue = amountDue;
	}

	public Double getAmountSettled() {
		return amountSettled;
	}

	public void setAmountSettled(Double amountSettled) {
		this.amountSettled = amountSettled;
	}

	public String getCcyCode() {
		return ccyCode;
	}

	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}

	public String getFullPartIndicator() {
		return fullPartIndicator;
	}

	public void setFullPartIndicator(String fullPartIndicator) {
		this.fullPartIndicator = fullPartIndicator;
	}

}
