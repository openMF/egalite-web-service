package com.cbs.bean;

import java.io.Serializable;
import java.util.Date;


public class CbsBaseTransRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3026737701262928787L;
	 private String mfiOutSeqno;
	 private String mbsTxnRefNo;
	 private String cbsAcRefNo;
	 private String customerId;
	 private String cbsBranchCode;
	 private String moduleCode;
	 private String txnCode;
	 private String txnIdentifier;
	 private String syncType;
	 private String isReqOrTxn;
	 private String isSentToCbs;
	 private Date logTime;
	 private Date cbsSentTime;
	 private String cbsResStat;
	 private String cbsResTxnRefNo;
	 private Date cbsResTime;
	 private String cbsErrCode;
	 private String cbsErrDesc;	 
	 private String ibsAgnId;
	 private long ibsAgnSeqNo;
	 private String agnAmtDueCcy;
	 private double agnAmtDue;
	 private String agnAmtSettledCcy;
	 private double agnAmtSettled;
	 private String txnCcy;
	 private String txnLocalCcy;
	
	 private String fullPartialInd;
	 private String cbsAgentId;
	 private String cbsLcrCode;
	 private String cbsLcrType;
	 private String mbsTxnNarrative;
	 private long reqDepNoInst;
	 private Date reqRedReqDt;
	 private String reqRedFullPartInd;
	 private Date reqMaturityDate;
	 private double reqIntRate;
	 private String reqDpTenureType;
	 private String reqDpFrqType;
	 private long reqDpFrq;
	 private long reqDpTenure;
	 
	 private String mbsTxnSeqNo;
	 	private String isGroupLoan;
		private String isParentLoan;
		private String isParentCust;
		private String parentCustId;
		private String parentCbsAccRefNo;
		// newly added fields
		private Date busiDate;	
		public Date getBusiDate() {
			return busiDate;
		}
		public void setBusiDate(Date busiDate) {
			this.busiDate = busiDate;
		}
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
		public String getSyncType() {
			return syncType;
		}
		public void setSyncType(String syncType) {
			this.syncType = syncType;
		}
		public String getIsReqOrTxn() {
			return isReqOrTxn;
		}
		public void setIsReqOrTxn(String isReqOrTxn) {
			this.isReqOrTxn = isReqOrTxn;
		}
		public String getIsSentToCbs() {
			return isSentToCbs;
		}
		public void setIsSentToCbs(String isSentToCbs) {
			this.isSentToCbs = isSentToCbs;
		}
		public Date getLogTime() {
			return logTime;
		}
		public void setLogTime(Date logTime) {
			this.logTime = logTime;
		}
		public Date getCbsSentTime() {
			return cbsSentTime;
		}
		public void setCbsSentTime(Date cbsSentTime) {
			this.cbsSentTime = cbsSentTime;
		}
		public String getCbsResStat() {
			return cbsResStat;
		}
		public void setCbsResStat(String cbsResStat) {
			this.cbsResStat = cbsResStat;
		}
		public String getCbsResTxnRefNo() {
			return cbsResTxnRefNo;
		}
		public void setCbsResTxnRefNo(String cbsResTxnRefNo) {
			this.cbsResTxnRefNo = cbsResTxnRefNo;
		}
		public Date getCbsResTime() {
			return cbsResTime;
		}
		public void setCbsResTime(Date cbsResTime) {
			this.cbsResTime = cbsResTime;
		}
		public String getCbsErrCode() {
			return cbsErrCode;
		}
		public void setCbsErrCode(String cbsErrCode) {
			this.cbsErrCode = cbsErrCode;
		}
		public String getCbsErrDesc() {
			return cbsErrDesc;
		}
		public void setCbsErrDesc(String cbsErrDesc) {
			this.cbsErrDesc = cbsErrDesc;
		}
		public String getIbsAgnId() {
			return ibsAgnId;
		}
		public void setIbsAgnId(String ibsAgnId) {
			this.ibsAgnId = ibsAgnId;
		}
		public long getIbsAgnSeqNo() {
			return ibsAgnSeqNo;
		}
		public void setIbsAgnSeqNo(long ibsAgnSeqNo) {
			this.ibsAgnSeqNo = ibsAgnSeqNo;
		}
		public String getAgnAmtDueCcy() {
			return agnAmtDueCcy;
		}
		public void setAgnAmtDueCcy(String agnAmtDueCcy) {
			this.agnAmtDueCcy = agnAmtDueCcy;
		}
		public double getAgnAmtDue() {
			return agnAmtDue;
		}
		public void setAgnAmtDue(double agnAmtDue) {
			this.agnAmtDue = agnAmtDue;
		}
		public String getAgnAmtSettledCcy() {
			return agnAmtSettledCcy;
		}
		public void setAgnAmtSettledCcy(String agnAmtSettledCcy) {
			this.agnAmtSettledCcy = agnAmtSettledCcy;
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
		public String getTxnLocalCcy() {
			return txnLocalCcy;
		}
		public void setTxnLocalCcy(String txnLocalCcy) {
			this.txnLocalCcy = txnLocalCcy;
		}
		public String getFullPartialInd() {
			return fullPartialInd;
		}
		public void setFullPartialInd(String fullPartialInd) {
			this.fullPartialInd = fullPartialInd;
		}
		public String getCbsAgentId() {
			return cbsAgentId;
		}
		public void setCbsAgentId(String cbsAgentId) {
			this.cbsAgentId = cbsAgentId;
		}
		public String getCbsLcrCode() {
			return cbsLcrCode;
		}
		public void setCbsLcrCode(String cbsLcrCode) {
			this.cbsLcrCode = cbsLcrCode;
		}
		public String getCbsLcrType() {
			return cbsLcrType;
		}
		public void setCbsLcrType(String cbsLcrType) {
			this.cbsLcrType = cbsLcrType;
		}
		public String getMbsTxnNarrative() {
			return mbsTxnNarrative;
		}
		public void setMbsTxnNarrative(String mbsTxnNarrative) {
			this.mbsTxnNarrative = mbsTxnNarrative;
		}
		public long getReqDepNoInst() {
			return reqDepNoInst;
		}
		public void setReqDepNoInst(long reqDepNoInst) {
			this.reqDepNoInst = reqDepNoInst;
		}
		public Date getReqRedReqDt() {
			return reqRedReqDt;
		}
		public void setReqRedReqDt(Date reqRedReqDt) {
			this.reqRedReqDt = reqRedReqDt;
		}
		public String getReqRedFullPartInd() {
			return reqRedFullPartInd;
		}
		public void setReqRedFullPartInd(String reqRedFullPartInd) {
			this.reqRedFullPartInd = reqRedFullPartInd;
		}
		public Date getReqMaturityDate() {
			return reqMaturityDate;
		}
		public void setReqMaturityDate(Date reqMaturityDate) {
			this.reqMaturityDate = reqMaturityDate;
		}
		public double getReqIntRate() {
			return reqIntRate;
		}
		public void setReqIntRate(double reqIntRate) {
			this.reqIntRate = reqIntRate;
		}
		public String getReqDpTenureType() {
			return reqDpTenureType;
		}
		public void setReqDpTenureType(String reqDpTenureType) {
			this.reqDpTenureType = reqDpTenureType;
		}
		public String getReqDpFrqType() {
			return reqDpFrqType;
		}
		public void setReqDpFrqType(String reqDpFrqType) {
			this.reqDpFrqType = reqDpFrqType;
		}
		public long getReqDpFrq() {
			return reqDpFrq;
		}
		public void setReqDpFrq(long reqDpFrq) {
			this.reqDpFrq = reqDpFrq;
		}
		public long getReqDpTenure() {
			return reqDpTenure;
		}
		public void setReqDpTenure(long reqDpTenure) {
			this.reqDpTenure = reqDpTenure;
		}
		public String getMbsTxnSeqNo() {
			return mbsTxnSeqNo;
		}
		public void setMbsTxnSeqNo(String mbsTxnSeqNo) {
			this.mbsTxnSeqNo = mbsTxnSeqNo;
		}
		public String getIsGroupLoan() {
			return isGroupLoan;
		}
		public void setIsGroupLoan(String isGroupLoan) {
			this.isGroupLoan = isGroupLoan;
		}
		public String getIsParentLoan() {
			return isParentLoan;
		}
		public void setIsParentLoan(String isParentLoan) {
			this.isParentLoan = isParentLoan;
		}
		public String getIsParentCust() {
			return isParentCust;
		}
		public void setIsParentCust(String isParentCust) {
			this.isParentCust = isParentCust;
		}
		public String getParentCustId() {
			return parentCustId;
		}
		public void setParentCustId(String parentCustId) {
			this.parentCustId = parentCustId;
		}
		public String getParentCbsAccRefNo() {
			return parentCbsAccRefNo;
		}
		public void setParentCbsAccRefNo(String parentCbsAccRefNo) {
			this.parentCbsAccRefNo = parentCbsAccRefNo;
		}
}
