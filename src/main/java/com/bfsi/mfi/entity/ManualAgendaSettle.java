package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;



@Entity(name = "MFI_MANUAL_AGENDA_SETTLE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ManualAgendaSettle extends MaintenanceEntity {
	public ManualAgendaSettle() {
	}
	
	@Column(name = "REC_ID", nullable = false)
	private String recId; 
	
	
	@Column(name = "AGENDA_ID", nullable = false)
	private String agendaId;
	
	@Column(name = "SEQ_NO", nullable = false)
	private Integer seqNo;
	
	@Column(name = "CBS_AC_REF_NO", nullable = false)
	private String cbsAcRefNo;
	@Column(name = "CUSTOMER_ID", nullable = false)
	private String customerId;
	@Column(name = "AGENT_ID", nullable = false)
	private String agentId;
	@Column(name = "DEVICE_ID", nullable = false)
	private String deviceId;
	@Column(name = "LOCATION_CODE", nullable = false)
	private String locationCode;
	@Column(name = "AGN_CMP_NAME", nullable = false)
	private String agnCmpName;
	
	@Column(name = "AGN_CMP_ST_DATE", nullable = false)
	private Date agnCmpStDate;
	@Column(name = "AGN_CMP_END_DT", nullable = false)
	private Date agnCmpEndDate;
	
	@Column(name = "AGN_CCY_CODE", nullable = false)
	private String agnCcyCode;
	
	@Column(name = "AGN_AGENDA_AMT", nullable = false)
	private Double agnAgendaAmt;
	@Column(name = "AGN_AGENDA_SETTLED_AMT", nullable = false)
	private Double  agnAgendaSettledAmt;
	
	@Column(name = "FULL_PART_IND", nullable = false)
	private String fullPartInd;
	@Column(name = "SETTLE_REMARKS", nullable = false)
	private String settleRemarks;
	@Column(name = "IS_ACTIVE", nullable = false)
	private String isActive;
	@Column(name = "AUTH_STAT", nullable = false)
	private String authStatus;
	@Column(name = "INIT_BY_USER_ID", nullable = false)
	private String initByUserId;
	@Column(name = "VERIFY_BY_USER_ID", nullable = false)
	private String verifyByUserId;
	
	@Column(name = "INIT_DATETIME", nullable = false)
	private Date initDateTime;
	@Column(name = "AUTH_DATETIME", nullable = false)
	private Date authDateTime;
	
	@Column(name = "PROCESS_STAT", nullable = false)
	private String processStat;
	
	
	@Column(name = "ERR_CODE", nullable = false)
	private String errCode;
	
	@Column(name = "ERR_DESC", nullable = false)
	private String errDesc;


	@Column(name = "TXN_CODE", nullable = false)
	private String txnCode;
	
	
	public String getRecId() {
		return recId;
	}

	public void setRecId(String recId) {
		this.recId = recId;
	}
	
	
	
	public String getAgendaId() {
		return super.getId();
		//return agendaId;
	}

	public void setAgendaId(String agendaId) {
		super.setId(agendaId);
		//this.agendaId = agendaId;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
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

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getAgnCmpName() {
		return agnCmpName;
	}

	public void setAgnCmpName(String agnCmpName) {
		this.agnCmpName = agnCmpName;
	}

	public Date getAgnCmpStDate() {
		return agnCmpStDate;
	}

	public void setAgnCmpStDate(Date agnCmpStDate) {
		this.agnCmpStDate = agnCmpStDate;
	}

	public Date getAgnCmpEndDate() {
		return agnCmpEndDate;
	}

	public void setAgnCmpEndDate(Date agnCmpEndDate) {
		this.agnCmpEndDate = agnCmpEndDate;
	}

	public String getAgnCcyCode() {
		return agnCcyCode;
	}

	public void setAgnCcyCode(String agnCcyCode) {
		this.agnCcyCode = agnCcyCode;
	}

	public Double getAgnAgendaAmt() {
		return agnAgendaAmt;
	}

	public void setAgnAgendaAmt(Double agnAgendaAmt) {
		this.agnAgendaAmt = agnAgendaAmt;
	}

	public Double getAgnAgendaSettledAmt() {
		return agnAgendaSettledAmt;
	}

	public void setAgnAgendaSettledAmt(Double agnAgendaSettledAmt) {
		this.agnAgendaSettledAmt = agnAgendaSettledAmt;
	}

	public String getFullPartInd() {
		return fullPartInd;
	}

	public void setFullPartInd(String fullPartInd) {
		this.fullPartInd = fullPartInd;
	}

	public String getSettleRemarks() {
		return settleRemarks;
	}

	public void setSettleRemarks(String settleRemarks) {
		this.settleRemarks = settleRemarks;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public String getInitByUserId() {
		return initByUserId;
	}

	public void setInitByUserId(String initByUserId) {
		this.initByUserId = initByUserId;
	}

	public String getVerifyByUserId() {
		return verifyByUserId;
	}

	public void setVerifyByUserId(String verifyByUserId) {
		this.verifyByUserId = verifyByUserId;
	}

	public Date getInitDateTime() {
		return initDateTime;
	}

	public void setInitDateTime(Date initDateTime) {
		this.initDateTime = initDateTime;
	}

	public Date getAuthDateTime() {
		return authDateTime;
	}

	public void setAuthDateTime(Date authDateTime) {
		this.authDateTime = authDateTime;
	}

	public String getProcessStat() {
		return processStat;
	}

	public void setProcessStat(String processStat) {
		this.processStat = processStat;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrDesc() {
		return errDesc;
	}

	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}

	

	public String getTxnCode() {
		return txnCode;
	}

	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}
	
	
	
}
