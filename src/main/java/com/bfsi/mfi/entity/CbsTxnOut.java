package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "MFI_CBS_TXN_OUT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CbsTxnOut extends MaintenanceEntity {
	
	public CbsTxnOut() {
		
	}
	
	public String mfiOutSeqno;
	public String mbsTxnRefNo;
	public String cbsAcRefNo;
	public String customerId;
	public String cbsBranchCode;
	public String moduleCode;
	public String txnCode;
	public String txnIdentifier;
	public String syncType;
	public String reqOrTxn;
	public String sentToCbs;
	public Date	logTime;
	public Date	cbsSentTime;
	public String cbsResponseStat;
	public String cbsResponseTxnRefNo;
	public Date cbsRespondTime;
	public String cbsErrorCode;
	public String cbsErrorDesc;
	public String ibsAgendaId;
	public int ibsAgendaSeqNo;
	public String agnAmtDueCcy;
	public int agnAmtDue;
	public String agnAmtSettledCcy;
	public int agnAmtSettled;
	public String fullPartialInd;;
	public String cbsAgentId;
	public String cbsLcrCode;
	public String cbsLcrType;
	public String mbsTxnNarrative;
	public int reqDepNoInst;
	public Date reqRedReqDt;
	public String reqRedFullPartInd;
	public Date reqMaturityDate;
	public int reqIntRate;
	public String reqDpTenureType;
	public String reqDpFrequencyType;
	public int reqDpFrequency;
	public int reqDpTenure;
	
	public String getMfiOutSeqno() {
		return super.getId();
	}
	public void setMfiOutSeqno(String mfiOutSeqno) {
		super.setId(mfiOutSeqno);
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
	public String getReqOrTxn() {
		return reqOrTxn;
	}
	public void setReqOrTxn(String reqOrTxn) {
		this.reqOrTxn = reqOrTxn;
	}
	public String getSentToCbs() {
		return sentToCbs;
	}
	public void setSentToCbs(String sentToCbs) {
		this.sentToCbs = sentToCbs;
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
	public String getCbsResponseStat() {
		return cbsResponseStat;
	}
	public void setCbsResponseStat(String cbsResponseStat) {
		this.cbsResponseStat = cbsResponseStat;
	}
	public String getCbsResponseTxnRefNo() {
		return cbsResponseTxnRefNo;
	}
	public void setCbsResponseTxnRefNo(String cbsResponseTxnRefNo) {
		this.cbsResponseTxnRefNo = cbsResponseTxnRefNo;
	}
	public Date getCbsRespondTime() {
		return cbsRespondTime;
	}
	public void setCbsRespondTime(Date cbsRespondTime) {
		this.cbsRespondTime = cbsRespondTime;
	}
	public String getCbsErrorCode() {
		return cbsErrorCode;
	}
	public void setCbsErrorCode(String cbsErrorCode) {
		this.cbsErrorCode = cbsErrorCode;
	}
	public String getCbsErrorDesc() {
		return cbsErrorDesc;
	}
	public void setCbsErrorDesc(String cbsErrorDesc) {
		this.cbsErrorDesc = cbsErrorDesc;
	}
	public String getIbsAgendaId() {
		return ibsAgendaId;
	}
	public void setIbsAgendaId(String ibsAgendaId) {
		this.ibsAgendaId = ibsAgendaId;
	}
	public int getIbsAgendaSeqNo() {
		return ibsAgendaSeqNo;
	}
	public void setIbsAgendaSeqNo(int ibsAgendaSeqNo) {
		this.ibsAgendaSeqNo = ibsAgendaSeqNo;
	}
	public String getAgnAmtDueCcy() {
		return agnAmtDueCcy;
	}
	public void setAgnAmtDueCcy(String agnAmtDueCcy) {
		this.agnAmtDueCcy = agnAmtDueCcy;
	}
	public int getAgnAmtDue() {
		return agnAmtDue;
	}
	public void setAgnAmtDue(int agnAmtDue) {
		this.agnAmtDue = agnAmtDue;
	}
	public String getAgnAmtSettledCcy() {
		return agnAmtSettledCcy;
	}
	public void setAgnAmtSettledCcy(String agnAmtSettledCcy) {
		this.agnAmtSettledCcy = agnAmtSettledCcy;
	}
	public int getAgnAmtSettled() {
		return agnAmtSettled;
	}
	public void setAgnAmtSettled(int agnAmtSettled) {
		this.agnAmtSettled = agnAmtSettled;
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
	public int getReqDepNoInst() {
		return reqDepNoInst;
	}
	public void setReqDepNoInst(int reqDepNoInst) {
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
	public int getReqIntRate() {
		return reqIntRate;
	}
	public void setReqIntRate(int reqIntRate) {
		this.reqIntRate = reqIntRate;
	}
	public String getReqDpTenureType() {
		return reqDpTenureType;
	}
	public void setReqDpTenureType(String reqDpTenureType) {
		this.reqDpTenureType = reqDpTenureType;
	}
	public String getReqDpFrequencyType() {
		return reqDpFrequencyType;
	}
	public void setReqDpFrequencyType(String reqDpFrequencyType) {
		this.reqDpFrequencyType = reqDpFrequencyType;
	}
	public int getReqDpFrequency() {
		return reqDpFrequency;
	}
	public void setReqDpFrequency(int reqDpFrequency) {
		this.reqDpFrequency = reqDpFrequency;
	}
	public int getReqDpTenure() {
		return reqDpTenure;
	}
	public void setReqDpTenure(int reqDpTenure) {
		this.reqDpTenure = reqDpTenure;
	}
	
	
	}
