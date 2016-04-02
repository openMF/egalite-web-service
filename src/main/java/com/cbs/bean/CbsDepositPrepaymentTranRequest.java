package com.cbs.bean;

import java.util.Date;

public class CbsDepositPrepaymentTranRequest {
	private String mfiOutSeqno;
	private String mbsTxnRefNo;
	private String mbsTxnSeqNo;
	private String cbsAcRefNo;
	private String customerId;
	private String cbsBranchCode;
	private String moduleCode;
	private String txnCode;
	private String txnIdentifier;	
	private Date logTime;	
	private double agnAmtDue;
	
	public String getMfiOutSeqno() {
		return mfiOutSeqno;
	}
	public void setMfiOutSeqno(String mfiOutSeqno) {
		this.mfiOutSeqno = mfiOutSeqno;
	}
	public String getMbsTxnRefNo() {
		return mbsTxnRefNo;
	}
	public void setMbsTxnRefNo(String mbsTxnRefNo) {
		this.mbsTxnRefNo = mbsTxnRefNo;
	}
	public String getMbsTxnSeqNo() {
		return mbsTxnSeqNo;
	}
	public void setMbsTxnSeqNo(String mbsTxnSeqNo) {
		this.mbsTxnSeqNo = mbsTxnSeqNo;
	}
	public String getCbsAcRefNo() {
		return cbsAcRefNo;
	}
	public void setCbsAcRefNo(String cbsAcRefNo) {
		this.cbsAcRefNo = cbsAcRefNo;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCbsBranchCode() {
		return cbsBranchCode;
	}
	public void setCbsBranchCode(String cbsBranchCode) {
		this.cbsBranchCode = cbsBranchCode;
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
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	public double getAgnAmtDue() {
		return agnAmtDue;
	}
	public void setAgnAmtDue(double agnAmtDue) {
		this.agnAmtDue = agnAmtDue;
	}
	public double getAgnAmtSettled() {
		return agnAmtSettled;
	}
	public void setAgnAmtSettled(double agnAmtSettled) {
		this.agnAmtSettled = agnAmtSettled;
	}
	public String getTxnCcy() {
		return txnCcy;
	}
	public void setTxnCcy(String txnCcy) {
		this.txnCcy = txnCcy;
	}
	private double agnAmtSettled;
	private String txnCcy;

}
