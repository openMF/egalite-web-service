package com.bfsi.mfi.cbs.model;

import java.util.Date;

public class CbsDepositActivity {

	private String depoAccNo;
	private String branchCode;
	private String txnType;
	private Date txnTypeStartDate;
	private Date txnTypeEndDate;
	private Date txnTypeDueDate;
	private String txnCcyCode;
	private String txnLocCcyCode;
	private Double txnAmtDue;
	private Double txnAmtDueLocCcy;
	private Double txnAmtSettled;
	private Double txnAmtSettledLocCcy;
	private String cbsUploadJobId;

	public String getDepoAccNo() {
		return depoAccNo;
	}

	public void setDepoAccNo(String depoAccNo) {
		this.depoAccNo = depoAccNo;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Date getTxnTypeStartDate() {
		return txnTypeStartDate;
	}

	public void setTxnTypeStartDate(Date txnTypeStartDate) {
		this.txnTypeStartDate = txnTypeStartDate;
	}

	public Date getTxnTypeEndDate() {
		return txnTypeEndDate;
	}

	public void setTxnTypeEndDate(Date txnTypeEndDate) {
		this.txnTypeEndDate = txnTypeEndDate;
	}

	

	public Date getTxnTypeDueDate() {
		return txnTypeDueDate;
	}

	public void setTxnTypeDueDate(Date txnTypeDueDate) {
		this.txnTypeDueDate = txnTypeDueDate;
	}

	public String getTxnCcyCode() {
		return txnCcyCode;
	}

	public void setTxnCcyCode(String txnCcyCode) {
		this.txnCcyCode = txnCcyCode;
	}

	public String getTxnLocCcyCode() {
		return txnLocCcyCode;
	}

	public void setTxnLocCcyCode(String txnLocCcyCode) {
		this.txnLocCcyCode = txnLocCcyCode;
	}

	public Double getTxnAmtDue() {
		return txnAmtDue;
	}

	public void setTxnAmtDue(Double txnAmtDue) {
		this.txnAmtDue = txnAmtDue;
	}

	public Double getTxnAmtDueLocCcy() {
		return txnAmtDueLocCcy;
	}

	public void setTxnAmtDueLocCcy(Double txnAmtDueLocCcy) {
		this.txnAmtDueLocCcy = txnAmtDueLocCcy;
	}

	public Double getTxnAmtSettled() {
		return txnAmtSettled;
	}

	public void setTxnAmtSettled(Double txnAmtSettled) {
		this.txnAmtSettled = txnAmtSettled;
	}

	public Double getTxnAmtSettledLocCcy() {
		return txnAmtSettledLocCcy;
	}

	public void setTxnAmtSettledLocCcy(Double txnAmtSettledLocCcy) {
		this.txnAmtSettledLocCcy = txnAmtSettledLocCcy;
	}

	public String getCbsUploadJobId() {
		return cbsUploadJobId;
	}

	public void setCbsUploadJobId(String cbsUploadJobId) {
		this.cbsUploadJobId = cbsUploadJobId;
	}

}
