package com.bfsi.mfi.entity;

import java.util.Date;

public class AgentTransaction extends MaintenanceEntity {
	public AgentTransaction() {
	}
	
	/*@Override
	public String toString(){
		
		return "TRANSACTION :::txnId: "+ 	txnId +"  moduleCode:  " + moduleCode +"  txnCode:  "+ txnCode +"  agendaId:  "+ agendaId +
				"  seqNo:  "+ seqNo +"  cbsAccRefNo:  "+ cbsAccRefNo
				
				+"  branchCode:  "+ branchCode +"  customerId:  "+ customerId +"  txnInitTime:  "+ txnInitTime +"  txnSyncTime:  "+ txnSyncTime
				+"  agentId:  "+ agentId+"  deviceId:  "+ deviceId+"  locCode:  "+ locCode+"  isLoanFutureSch:  "
				+ isLoanFutureSch+"  txnCcy:  "+ txnCcy+"  txnLocalCcy:  "+ txnLocalCcy+"  txnAmount:  "+ txnAmount+"  txnLocalCcyAmount:  "
				+ txnLocalCcyAmount+"  txnSettlementAmount:  "+ txnSettlementAmount+"  txnSettleLocalCcyAmount:  "
				+ txnSettleLocalCcyAmount+"  narrative:  "+ narrative+"  depNoOfInstalement:  "+ depNoOfInstalement+"  depoRedeemReqDate:  "+ depoRedeemReqDate
				+"  isFullRepoRedeem:  "+ isFullRepoRedeem+"  maturityDate:  "+ maturityDate+"  intrRate:  "+ intrRate
				+"  depoTenureType:  "+ depoTenureType+"  depoFreqType:  "+ depoFreqType+"  depoFreq:  "+ depoFreq
				+"  depoTenure:  "+ depoTenure+"  status:  "+ status+"  realtimeStatus:  "+ realtimeStatus +"  txnErrCode:  "+ txnErrCode +"  txnErrMsg:  "+ txnErrMsg
				+"  generatedSms:  "+ generatedSms+"  smsMobNo:  "+ smsMobNo+"  smsContent:  "+ smsContent+"  generateReversal:  "+ generateReversal
				+"  txnStatus:  "+ txnStatus+"  mbsSeqNo:  "+ mbsSeqNo+"  fullPartIndicator:  "+ fullPartIndicator+"  syncType:  "+ syncType;
		
		
	}*/
	
	
	private String txnId;
	private String moduleCode;
	private String txnCode;
	private String agendaId;
	private int seqNo;
	private String cbsAccRefNo;
	private String branchCode;
	private String customerId;
	private Date txnInitTime;
	private Date txnSyncTime;
	private String agentId;
	private String deviceId;
	private String locCode;
	private String isLoanFutureSch;
	private String txnCcy;
	private String txnLocalCcy;
	private Double txnAmount;
	private Double txnLocalCcyAmount;
	private Double txnSettlementAmount;
	private Double txnSettleLocalCcyAmount;
	private String narrative;
	private int depNoOfInstalement;
	private Date depoRedeemReqDate;
	private String isFullRepoRedeem;
	private Date maturityDate;
	private Double intrRate;
	private String depoTenureType;
	private String depoFreqType;
	private int depoFreq;
	private int depoTenure;
	private int status;
	private String realtimeStatus;
	
	private String txnErrCode;
	private String txnErrMsg;
	private String generatedSms;
	private String smsMobNo;
	private String smsContent;
	private String generateReversal;
	private int txnStatus;
	private Integer mbsSeqNo;
	private String fullPartIndicator;
	private String syncType;
	
	private String ibsTxnOutSeqNo;
	// newly added fields
	private Date busiDate;
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	
	public Date getBusiDate() {
		return busiDate;
	}
	public void setBusiDate(Date busiDate) {
		this.busiDate = busiDate;
	}
	public String getIbsTxnOutSeqNo() {
		return ibsTxnOutSeqNo;
	}
	public void setIbsTxnOutSeqNo(String ibsTxnOutSeqNo) {
		this.ibsTxnOutSeqNo = ibsTxnOutSeqNo;
	}


	//private String txnId;
	private Date txnTimestamp;
	private String txnType;
	//private String agentId;
	private String loanAcNo;
	private Date syncTime;
	//private String customerId;
//	private String deviceId;
	private String authStatus;
	private String sessionId;
	//private String txnStatus;
	private String txnNarrative;
//	private Double txnAmount;
	private String repaymentInst;
	private String syncStatus;
	//private String txnCcy;
	//private String branchCode;
	private String creditOfficer;
	
	
	/*NambiAK Vikas*/
	private String depAcNo;
	private String txnComponentName;
	private String txnSchStDate;
	private String txnSchDueDate;
	
	
	
	
	public Integer getMbsSeqNo() {
		return mbsSeqNo;
	}
	public void setMbsSeqNo(Integer mbsSeqNo) {
		this.mbsSeqNo = mbsSeqNo;
	}
	public String getFullPartIndicator() {
		return fullPartIndicator;
	}
	public void setFullPartIndicator(String fullPartIndicator) {
		this.fullPartIndicator = fullPartIndicator;
	}
	public String getSyncType() {
		return syncType;
	}
	public void setSyncType(String syncType) {
		this.syncType = syncType;
	}
	public String getTxnErrCode() {
		return txnErrCode;
	}
	public void setTxnErrCode(String txnErrCode) {
		this.txnErrCode = txnErrCode;
	}
	public String getTxnErrMsg() {
		return txnErrMsg;
	}
	public void setTxnErrMsg(String txnErrMsg) {
		this.txnErrMsg = txnErrMsg;
	}
	public String getGeneratedSms() {
		return generatedSms;
	}
	public void setGeneratedSms(String generatedSms) {
		this.generatedSms = generatedSms;
	}
	public String getSmsMobNo() {
		return smsMobNo;
	}
	public void setSmsMobNo(String smsMobNo) {
		this.smsMobNo = smsMobNo;
	}
	public String getSmsContent() {
		return smsContent;
	}
	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}
	public String getGenerateReversal() {
		return generateReversal;
	}
	public void setGenerateReversal(String generateReversal) {
		this.generateReversal = generateReversal;
	}
	public int getTxnStatus() {
		return txnStatus;
	}
	public void setTxnStatus(int txnStatus) {
		this.txnStatus = txnStatus;
	}
	public String getRealtimeStatus() {
		return realtimeStatus;
	}
	public void setRealtimeStatus(String realtimeStatus) {
		this.realtimeStatus = realtimeStatus;
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
	public Double getTxnLocalCcyAmount() {
		return txnLocalCcyAmount;
	}
	public void setTxnLocalCcyAmount(Double txnLocalCcyAmount) {
		this.txnLocalCcyAmount = txnLocalCcyAmount;
	}
	public Double getTxnSettleLocalCcyAmount() {
		return txnSettleLocalCcyAmount;
	}
	public void setTxnSettleLocalCcyAmount(Double txnSettleLocalCcyAmount) {
		this.txnSettleLocalCcyAmount = txnSettleLocalCcyAmount;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
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
	public String getAgendaId() {
		return agendaId;
	}
	public void setAgendaId(String agendaId) {
		this.agendaId = agendaId;
	}
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	public String getCbsAccRefNo() {
		return cbsAccRefNo;
	}
	public void setCbsAccRefNo(String cbsAccRefNo) {
		this.cbsAccRefNo = cbsAccRefNo;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Date getTxnInitTime() {
		return txnInitTime;
	}
	public void setTxnInitTime(Date txnInitTime) {
		this.txnInitTime = txnInitTime;
	}
	public Date getTxnSyncTime() {
		return txnSyncTime;
	}
	public void setTxnSyncTime(Date txnSyncTime) {
		this.txnSyncTime = txnSyncTime;
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
	public String getLocCode() {
		return locCode;
	}
	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}
	public String getIsLoanFutureSch() {
		return isLoanFutureSch;
	}
	public void setIsLoanFutureSch(String isLoanFutureSch) {
		this.isLoanFutureSch = isLoanFutureSch;
	}
	public Double getTxnAmount() {
		return txnAmount;
	}
	public void setTxnAmount(Double txnAmount) {
		this.txnAmount = txnAmount;
	}
	public Double getTxnSettlementAmount() {
		return txnSettlementAmount;
	}
	public void setTxnSettlementAmount(Double txnSettlementAmount) {
		this.txnSettlementAmount = txnSettlementAmount;
	}
	
	public String getNarrative() {
		return narrative;
	}
	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}
	public int getDepNoOfInstalement() {
		return depNoOfInstalement;
	}
	public void setDepNoOfInstalement(int depNoOfInstalement) {
		this.depNoOfInstalement = depNoOfInstalement;
	}
	public Date getDepoRedeemReqDate() {
		return depoRedeemReqDate;
	}
	public void setDepoRedeemReqDate(Date depoRedeemReqDate) {
		this.depoRedeemReqDate = depoRedeemReqDate;
	}
	public String getIsFullRepoRedeem() {
		return isFullRepoRedeem;
	}
	public void setIsFullRepoRedeem(String isFullRepoRedeem) {
		this.isFullRepoRedeem = isFullRepoRedeem;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Double getIntrRate() {
		return intrRate;
	}
	public void setIntrRate(Double intrRate) {
		this.intrRate = intrRate;
	}
	public String getDepoTenureType() {
		return depoTenureType;
	}
	public void setDepoTenureType(String depoTenureType) {
		this.depoTenureType = depoTenureType;
	}
	public String getDepoFreqType() {
		return depoFreqType;
	}
	public void setDepoFreqType(String depoFreqType) {
		this.depoFreqType = depoFreqType;
	}
	public int getDepoFreq() {
		return depoFreq;
	}
	public void setDepoFreq(int depoFreq) {
		this.depoFreq = depoFreq;
	}
	public int getDepoTenure() {
		return depoTenure;
	}
	public void setDepoTenure(int depoTenure) {
		this.depoTenure = depoTenure;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getTxnTimestamp() {
		return txnTimestamp;
	}
	public void setTxnTimestamp(Date txnTimestamp) {
		this.txnTimestamp = txnTimestamp;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public String getLoanAcNo() {
		return loanAcNo;
	}
	public void setLoanAcNo(String loanAcNo) {
		this.loanAcNo = loanAcNo;
	}
	public Date getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	public String getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public String getTxnNarrative() {
		return txnNarrative;
	}
	public void setTxnNarrative(String txnNarrative) {
		this.txnNarrative = txnNarrative;
	}
	public String getRepaymentInst() {
		return repaymentInst;
	}
	public void setRepaymentInst(String repaymentInst) {
		this.repaymentInst = repaymentInst;
	}
	public String getSyncStatus() {
		return syncStatus;
	}
	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}

	public String getCreditOfficer() {
		return creditOfficer;
	}
	public void setCreditOfficer(String creditOfficer) {
		this.creditOfficer = creditOfficer;
	}
	public String getDepAcNo() {
		return depAcNo;
	}
	public void setDepAcNo(String depAcNo) {
		this.depAcNo = depAcNo;
	}
	public String getTxnComponentName() {
		return txnComponentName;
	}
	public void setTxnComponentName(String txnComponentName) {
		this.txnComponentName = txnComponentName;
	}
	public String getTxnSchStDate() {
		return txnSchStDate;
	}
	public void setTxnSchStDate(String txnSchStDate) {
		this.txnSchStDate = txnSchStDate;
	}
	public String getTxnSchDueDate() {
		return txnSchDueDate;
	}
	public void setTxnSchDueDate(String txnSchDueDate) {
		this.txnSchDueDate = txnSchDueDate;
	}

	
}