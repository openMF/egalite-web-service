package com.cbs.bean;

import java.util.Date;

public class CbsCashDepositTranRequest {
	private String ibsOutSeqNo;
	private String txnRefNo;
	private Integer seqNo;
	private String accNo;
	private String custId;
	private String branchCode;
	private String moduleCode;
	private String txnCode;
	private String txnIdentifier;
	private Double amountDue;
	private Double amountSettled;
	private String ccyCode;
	private Date txnInitTime;
	// newly added fields
	private Date busiDate;
	
	public Date getBusiDate() {
		return busiDate;
	}
	public void setBusiDate(Date busiDate) {
		this.busiDate = busiDate;
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
	public Integer getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
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
	public Date getTxnInitTime() {
		return txnInitTime;
	}
	public void setTxnInitTime(Date txnInitTime) {
		this.txnInitTime = txnInitTime;
	}

}
