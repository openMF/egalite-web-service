package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.CbsTxnOut;

public class CbsTxnOutVO extends MaintenanceVO<CbsTxnOut> {
	
	public CbsTxnOutVO() {
		entity = new CbsTxnOut();
	}

	public CbsTxnOutVO(CbsTxnOut entity) {
		super(entity);
	}	
	
	public String getMfiOutSeqno() {
		return this.entity.getMfiOutSeqno();
	}
	public void setMfiOutSeqno(String mfiOutSeqno) {
		entity.mfiOutSeqno = mfiOutSeqno;
	}
	public String getMbsTxnRefNo() {
		return this.entity.getMbsTxnRefNo();
	}
	public void setMbsTxnRefNo(String mbsTxnRefNo) {
		entity.mbsTxnRefNo = mbsTxnRefNo;
	}
	public String getCbsAcRefNo() {
		return this.entity.getCbsAcRefNo();
	}
	public void setCbsAcRefNo(String cbsAcRefNo) {
		entity.cbsAcRefNo = cbsAcRefNo;
	}
	public String getCustomerId() {
		return this.entity.getCustomerId();
	}
	public void setCustomerId(String customerId) {
		entity.customerId = customerId;
	}
	public String getCbsBranchCode() {
		return this.entity.getCbsBranchCode();
	}
	public void setCbsBranchCode(String cbsBranchCode) {
		entity.cbsBranchCode = cbsBranchCode;
	}
	public String getModuleCode() {
		return this.entity.getModuleCode();
	}
	public void setModuleCode(String moduleCode) {
		entity.moduleCode = moduleCode;
	}
	public String getTxnCode() {
		return this.entity.getTxnCode();
	}
	public void setTxnCode(String txnCode) {
		entity.txnCode = txnCode;
	}
	public String getTxnIdentifier() {
		return this.entity.getTxnIdentifier();
	}
	public void setTxnIdentifier(String txnIdentifier) {
		entity.txnIdentifier = txnIdentifier;
	}
	public String getSyncType() {
		return this.entity.getSyncType();
	}
	public void setSyncType(String syncType) {
		entity.syncType = syncType;
	}
	public String getReqOrTxn() {
		return this.entity.getReqOrTxn();
	}
	public void setReqOrTxn(String reqOrTxn) {
		entity.reqOrTxn = reqOrTxn;
	}
	public String getSentToCbs() {
		return this.entity.getSentToCbs();
	}
	public void setSentToCbs(String sentToCbs) {
		entity.sentToCbs = sentToCbs;
	}
	public Date getLogTime() {
		return this.entity.getLogTime();
	}
	public void setLogTime(Date logTime) {
		entity.logTime = logTime;
	}
	public Date getCbsSentTime() {
		return this.entity.getCbsSentTime();
	}
	public void setCbsSentTime(Date cbsSentTime) {
		entity.cbsSentTime = cbsSentTime;
	}
	public String getCbsResponseStat() {
		return this.entity.getCbsResponseStat();
	}
	public void setCbsResponseStat(String cbsResponseStat) {
		entity.cbsResponseStat = cbsResponseStat;
	}
	public String getCbsResponseTxnRefNo() {
		return this.entity.getCbsResponseTxnRefNo();
	}
	public void setCbsResponseTxnRefNo(String cbsResponseTxnRefNo) {
		entity.cbsResponseTxnRefNo = cbsResponseTxnRefNo;
	}
	public Date getCbsRespondTime() {
		return this.entity.getCbsRespondTime();
	}
	public void setCbsRespondTime(Date cbsRespondTime) {
		entity.cbsRespondTime = cbsRespondTime;
	}
	public String getCbsErrorCode() {
		return this.entity.getCbsErrorCode();
	}
	public void setCbsErrorCode(String cbsErrorCode) {
		entity.cbsErrorCode = cbsErrorCode;
	}
	public String getCbsErrorDesc() {
		return this.entity.getCbsErrorDesc();
	}
	public void setCbsErrorDesc(String cbsErrorDesc) {
		entity.cbsErrorDesc = cbsErrorDesc;
	}
	public String getIbsAgendaId() {
		return this.entity.getIbsAgendaId();
	}
	public void setIbsAgendaId(String ibsAgendaId) {
		entity.ibsAgendaId = ibsAgendaId;
	}
	public int getIbsAgendaSeqNo() {
		return this.entity.getIbsAgendaSeqNo();
	}
	public void setIbsAgendaSeqNo(int ibsAgendaSeqNo) {
		entity.ibsAgendaSeqNo = ibsAgendaSeqNo;
	}
	public String getAgnAmtDueCcy() {
		return this.entity.getAgnAmtDueCcy();
	}
	public void setAgnAmtDueCcy(String agnAmtDueCcy) {
		entity.agnAmtDueCcy = agnAmtDueCcy;
	}
	public int getAgnAmtDue() {
		return this.entity.getAgnAmtDue();
	}
	public void setAgnAmtDue(int agnAmtDue) {
		entity.agnAmtDue = agnAmtDue;
	}
	public String getAgnAmtSettledCcy() {
		return this.entity.getAgnAmtSettledCcy();
	}
	public void setAgnAmtSettledCcy(String agnAmtSettledCcy) {
		entity.agnAmtSettledCcy = agnAmtSettledCcy;
	}
	public int getAgnAmtSettled() {
		return this.entity.getAgnAmtSettled();
	}
	public void setAgnAmtSettled(int agnAmtSettled) {
		entity.agnAmtSettled = agnAmtSettled;
	}
	public String getFullPartialInd() {
		return this.entity.getFullPartialInd();
	}
	public void setFullPartialInd(String fullPartialInd) {
		entity.fullPartialInd = fullPartialInd;
	}
	public String getCbsAgentId() {
		return this.entity.getCbsAgentId();
	}
	public void setCbsAgentId(String cbsAgentId) {
		entity.cbsAgentId = cbsAgentId;
	}
	public String getCbsLcrCode() {
		return this.entity.getCbsLcrCode();
	}
	public void setCbsLcrCode(String cbsLcrCode) {
		entity.cbsLcrCode = cbsLcrCode;
	}
	public String getCbsLcrType() {
		return this.entity.getCbsLcrType();
	}
	public void setCbsLcrType(String cbsLcrType) {
		entity.cbsLcrType = cbsLcrType;
	}
	public String getMbsTxnNarrative() {
		return this.entity.getMbsTxnNarrative();
	}
	public void setMbsTxnNarrative(String mbsTxnNarrative) {
		entity.mbsTxnNarrative = mbsTxnNarrative;
	}
	public int getReqDepNoInst() {
		return this.entity.getReqDepNoInst();
	}
	public void setReqDepNoInst(int reqDepNoInst) {
		entity.reqDepNoInst = reqDepNoInst;
	}
	public Date getReqRedReqDt() {
		return this.entity.getReqRedReqDt();
	}
	public void setReqRedReqDt(Date reqRedReqDt) {
		entity.reqRedReqDt = reqRedReqDt;
	}
	public String getReqRedFullPartInd() {
		return this.entity.getReqRedFullPartInd();
	}
	public void setReqRedFullPartInd(String reqRedFullPartInd) {
		entity.reqRedFullPartInd = reqRedFullPartInd;
	}
	public Date getReqMaturityDate() {
		return this.entity.getReqMaturityDate();
	}
	public void setReqMaturityDate(Date reqMaturityDate) {
		entity.reqMaturityDate = reqMaturityDate;
	}
	public int getReqIntRate() {
		return this.entity.getReqIntRate();
	}
	public void setReqIntRate(int reqIntRate) {
		entity.reqIntRate = reqIntRate;
	}
	public String getReqDpTenureType() {
		return this.entity.getReqDpTenureType();
	}
	public void setReqDpTenureType(String reqDpTenureType) {
		entity.reqDpTenureType = reqDpTenureType;
	}
	public String getReqDpFrequencyType() {
		return this.entity.getReqDpFrequencyType();
	}
	public void setReqDpFrequencyType(String reqDpFrequencyType) {
		entity.reqDpFrequencyType = reqDpFrequencyType;
	}
	public int getReqDpFrequency() {
		return this.entity.getReqDpFrequency();
	}
	public void setReqDpFrequency(int reqDpFrequency) {
		entity.reqDpFrequency = reqDpFrequency;
	}
	public int getReqDpTenure() {
		return this.entity.getReqDpTenure();
	}
	public void setReqDpTenure(int reqDpTenure) {
		entity.reqDpTenure = reqDpTenure;
	}
	
}
