package com.bfsi.mfi.vo;

import java.util.Date;




import com.bfsi.mfi.entity.AgentTransaction;
/**
 * 
 * @author Shabu
 *
 */
public class AgentTransactionVO extends MaintenanceVO<AgentTransaction> {

	public AgentTransactionVO() {
		entity = new AgentTransaction();
	}

	public AgentTransactionVO(AgentTransaction entity) {
		super(entity);
	}
	
	
	/*
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
	private Double txnAmount;
	private String txnCurrency;
	private Double txnSettlementAmount;
	private String txnSettlementCurrency;
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
	*/
	
	///////////////////////////////////////////////////////////////////////////////////////////////////

	// private String txnId;
	public Integer getMbsSeqNo() {
		return entity.getMbsSeqNo();
	}
	public void setMbsSeqNo(Integer mbsSeqNo) {
		entity.setMbsSeqNo(mbsSeqNo);
	}
	public String getFullPartIndicator() {
		return entity.getFullPartIndicator();
	}
	public void setFullPartIndicator(String fullPartIndicator) {
		entity.setFullPartIndicator(fullPartIndicator);
	}
	public String getSyncType() {
		return entity.getSyncType();
	}
	public void setSyncType(String syncType) {
		entity.setSyncType( syncType);
	}
	
	public String getTxnErrCode() {
		return entity.getTxnErrCode();
	}
	public void setTxnErrCode(String txnErrCode) {
		entity.setTxnErrCode(txnErrCode);
	}
	public String getTxnErrMsg() {
		return entity.getTxnErrMsg();
	}
	public void setTxnErrMsg(String txnErrMsg) {
		entity.setTxnErrMsg(txnErrMsg);
	}
	public String getGeneratedSms() {
		return entity.getGeneratedSms();
	}
	public void setGeneratedSms(String generatedSms) {
		entity.setGeneratedSms(generatedSms);
	}
	public String getSmsMobNo() {
		return entity.getSmsMobNo();
	}
	public void setSmsMobNo(String smsMobNo) {
		entity.setSmsMobNo(smsMobNo);
	}
	public String getSmsContent() {
		return entity.getSmsContent();
	}
	public void setSmsContent(String smsContent) {
		entity.setSmsContent(smsContent);
	}
	public String getGenerateReversal() {
		return entity.getGenerateReversal();
	}
	public void setGenerateReversal(String generateReversal) {
		entity.setGenerateReversal(generateReversal);
	}
	public int getTxnStatus() {
		return entity.getTxnStatus();
	}
	public void setTxnStatus(int txnStatus) {
		entity.setTxnStatus(txnStatus);
	}

	public String getTxnCcy() {
		return this.entity.getTxnCcy();
	}
	public void setTxnCcy(String txnCcy) {
		this.entity.setTxnCcy(txnCcy);
	}
	public String getTxnLocalCcy() {
		return this.entity.getTxnLocalCcy();
	}
	public void setTxnLocalCcy(String txnLocalCcy) {
		this.entity.setTxnLocalCcy(txnLocalCcy);
	}
	
	public String getTxnId() {
		return this.entity.getTxnId();
	}

	public void setTxnId(String txnId) {
		this.entity.setTxnId(txnId);
	}

	public String getModuleCode() {
		return this.entity.getModuleCode();
	}

	public void setModuleCode(String moduleCode) {
		this.entity.setModuleCode( moduleCode) ;
	}

	public String getTxnCode() {
		return this.entity.getTxnCode();
	}

	public void setTxnCode(String txnCode) {
		this.entity.setTxnCode(txnCode);
	}

	public String getAgendaId() {
		return this.entity.getAgendaId();
	}

	public void setAgendaId(String agendaId) {
		this.entity.setAgendaId(agendaId);
	}

	public int getSeqNo() {
		return this.entity.getSeqNo();
	}

	public void setSeqNo(int seqNo) {
		this.entity.setSeqNo(seqNo);
	}

	public String getCbsAccRefNo() {
		return this.entity.getCbsAccRefNo();
	}

	public void setCbsAccRefNo(String cbsAccRefNo) {
		this.entity.setCbsAccRefNo(cbsAccRefNo);
	}

	public String getBranchCode() {
		return this.entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		this.entity.setBranchCode(branchCode);
	}

	public String getCustomerId() {
		return this.entity.getCustomerId();
	}

	public void setCustomerId(String customerId) {
		this.entity.setCustomerId(customerId);
	}

	public Date getTxnInitTime() {
		return this.entity.getTxnInitTime();
	}

	public void setTxnInitTime(Date txnInitTime) {
		this.entity.setTxnInitTime(txnInitTime);
	}

	public Date getTxnSyncTime() {
		return this.entity.getTxnSyncTime();
	}

	public void setTxnSyncTime(Date txnSyncTime) {
		this.entity.setTxnSyncTime(txnSyncTime);
	}

	public String getAgentId() {
		return this.entity.getAgentId();
	}

	public void setAgentId(String agentId) {
		this.entity.setAgentId(agentId);
	}

	public String getDeviceId() {
		return this.entity.getDeviceId();
	}

	public void setDeviceId(String deviceId) {
		this.entity.setDeviceId(deviceId);
	}

	public String getLocCode() {
		return this.entity.getLocCode();
	}

	public void setLocCode(String locCode) {
		this.entity.setLocCode(locCode);
	}

	public String getIsLoanFutureSch() {
		return this.entity.getIsLoanFutureSch();
	}

	public void setIsLoanFutureSch(String isLoanFutureSch) {
		this.entity.setIsLoanFutureSch(isLoanFutureSch);
	}

	public Double getTxnAmount() {
		return this.entity.getTxnAmount();
	}

	public void setTxnAmount(Double txnAmount) {
		this.entity.setTxnAmount(txnAmount);
	}

	public Double getTxnLocalCcyAmount() {
		return this.entity.getTxnLocalCcyAmount();
	}

	public void setTxnLocalCcyAmount(Double txnCurrency) {
		this.entity.setTxnLocalCcyAmount(txnCurrency);
	}

	public Double getTxnSettlementAmount() {
		return this.entity.getTxnSettlementAmount();
	}

	public void setTxnSettlementAmount(Double txnSettlementAmount) {
		this.entity.setTxnSettlementAmount(txnSettlementAmount);
	}

	public Double getTxnSettleLocalCcyAmount() {
		return this.entity.getTxnSettleLocalCcyAmount();
	}

	public void setTxnSettleLocalCcyAmount(Double txnSettlementCurrency) {
		this.entity.setTxnSettleLocalCcyAmount(txnSettlementCurrency);
	}

	public String getNarrative() {
		return this.entity.getNarrative();
	}

	public void setNarrative(String narrative) {
		this.entity.setNarrative(narrative);
	}

	public int getDepNoOfInstalement() {
		return this.entity.getDepNoOfInstalement();
	}

	public void setDepNoOfInstalement(int depNoOfInstalement) {
		this.entity.setDepNoOfInstalement(depNoOfInstalement);
	}

	public Date getDepoRedeemReqDate() {
		return this.entity.getDepoRedeemReqDate();
	}

	public void setDepoRedeemReqDate(Date depoRedeemReqDate) {
		this.entity.setDepoRedeemReqDate(depoRedeemReqDate);
	}

	public String getIsFullRepoRedeem() {
		return this.entity.getIsFullRepoRedeem();
	}

	public void setIsFullRepoRedeem(String isFullRepoRedeem) {
		this.entity.setIsFullRepoRedeem(isFullRepoRedeem);
	}

	public Date getMaturityDate() {
		return this.entity.getMaturityDate();
	}

	public void setMaturityDate(Date maturityDate) {
		this.entity.setMaturityDate(maturityDate);
	}

	public Double getIntrRate() {
		return this.entity.getIntrRate();
	}

	public void setIntrRate(Double intrRate) {
		this.entity.setIntrRate(intrRate);
	}

	public String getDepoTenureType() {
		return this.entity.getDepoTenureType();
	}

	public void setDepoTenureType(String depoTenureType) {
		this.entity.setDepoTenureType(depoTenureType);
	}

	public String getDepoFreqType() {
		return this.entity.getDepoFreqType();
	}

	public void setDepoFreqType(String depoFreqType) {
		this.entity.setDepoFreqType(depoFreqType);
	}

	public int getDepoFreq() {
		return this.entity.getDepoFreq();
	}

	public void setDepoFreq(int depoFreq) {
		this.entity.setDepoFreq(depoFreq);
	}

	public int getDepoTenure() {
		return this.entity.getDepoTenure();
	}

	public void setDepoTenure(int depoTenure) {
		this.entity.setDepoTenure(depoTenure);
	}

	public int getStatus() {
		return this.entity.getStatus();
	}

	public void setStatus(int status) {
		this.entity.setStatus(status);
	}

	
	
	
	/////////////////////
	public String getAuthStatusText() {
		return authStatusText;
	}

	public void setAuthStatusText(String authStatusText) {
		this.authStatusText = authStatusText;
	}

	public String getTxnStatusText() {
		return txnStatusText;
	}

	public void setTxnStatusText(String txnStatusText) {
		this.txnStatusText = txnStatusText;
	}

	public String getTxnTypeText() {
		return txnTypeText;
	}

	public void setTxnTypeText(String txnTypeText) {
		this.txnTypeText = txnTypeText;
	}

	public String getTxnTimeText() {
		return txnTimeText;
	}

	public void setTxnTimeText(String txnTimeText) {
		this.txnTimeText = txnTimeText;
	}

	public String getSynTimeText() {
		return synTimeText;
	}

	public void setSynTimeText(String synTimeText) {
		this.synTimeText = synTimeText;
	}
	
	public Date getBusiDate() {
		return this.entity.getBusiDate();
	}
	public void setBusiDate(Date busiDate) {
		this.entity.setBusiDate(busiDate);
	}



	private String authStatusText;
	private String txnStatusText;
	private String txnTypeText;
	private String txnTimeText;
	private String synTimeText;
	
	/**Vishal start */
	/*public String getTxnComponentName() {
		return entity.getTxnComponentName();
	}

	public void setTxnComponentName(String txnComponentName) {
		entity.setTxnComponentName(txnComponentName);
	}

	public String getTxnSchStDate() {
		return entity.getTxnSchStDate();
	}

	public void setTxnSchStDate(String txnSchStDate) {
		entity.setTxnSchStDate(txnSchStDate);
	}

	public String getTxnSchDueDate() {
		return entity.getTxnSchDueDate();
	}

	public void setTxnSchDueDate(String txnSchDueDate) {
		entity.setTxnSchDueDate(txnSchDueDate);
	}
	*//**Vishal end *//*

	public String getCreditOfficer() {
		return entity.getCreditOfficer();
	}

	public void setCreditOfficer(String creditOfficer) {
		entity.setCreditOfficer(creditOfficer);
	}
	
	public String getBranchCode() {
		return entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode);
	}

	public String getTxnCcy() {
		return entity.getTxnCcy();
	}

	public void setTxnCcy(String txnCcy) {
		entity.setTxnCcy(txnCcy);
	}

	public String getTxnNarrative() {
		return entity.getTxnNarrative();
	}

	public void setTxnNarrative(String txnNarrative) {
		entity.setTxnNarrative(txnNarrative);
	}

	public Double getTxnAmount() {
		return entity.getTxnAmount();
	}

	public void setTxnAmount(Double txnAmount) {
		entity.setTxnAmount(txnAmount);
	}

	public String getRepaymentInst() {
		return entity.getRepaymentInst();
	}

	public void setRepaymentInst(String repaymentInst) {
		entity.setRepaymentInst(repaymentInst);
	}

	public String getSyncStatus() {
		return entity.getSyncStatus();
	}

	public void setSyncStatus(String syncStatus) {
		entity.setSyncStatus(syncStatus);
	}

	public String getTxnStatus() {
		return entity.getTxnStatus();
	}

	public void setTxnStatus(String txnStatus) {
		entity.setTxnStatus(txnStatus);
	}

	public String getSessionId() {
		return entity.getSessionId();
	}

	public void setSessionId(String sessionId) {
		entity.setSessionId(sessionId);
	}

	public String getTxnId() {
		return super.getId();
	}

	public void setTxnId(String txnId) {
		super.setId(txnId);
	}

	public String getAuthStatus() {
		return entity.getAuthStatus();
	}

	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus);
	}

	public Date getTxnTimestamp() {
		return entity.getTxnTimestamp();
	}

	public void setTxnTimestamp(Date txnTimestamp) {
		entity.setTxnTimestamp(txnTimestamp);
	}

	public String getTxnType() {
		return entity.getTxnType();
	}

	public void setTxnType(String txnType) {
		entity.setTxnType(txnType);
	}

	public String getAgentId() {
		return entity.getAgentId();
	}

	public void setAgentId(String agentId) {
		entity.setAgentId(agentId);
	}

	public String getLoanAcNo() {
		return entity.getLoanAcNo();
	}

	public void setLoanAcNo(String loanAcNo) {
		entity.setLoanAcNo(loanAcNo);
	}

	public String getCustomerId() {
		return entity.getCustomerId();
	}

	public Date getSyncTime() {
		return entity.getSyncTime();
	}

	public void setSyncTime(Date syncTime) {
		entity.setSyncTime(syncTime);
	}

	public void setCustomerId(String customerId) {
		entity.setCustomerId(customerId);
	}

	public String getDeviceId() {
		return entity.getDeviceId();
	}

	public void setDeviceId(String deviceId) {
		entity.setDeviceId(deviceId);
	}

	public String getAuthStatusText() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (getAuthStatus() == null) {
			authStatusText = null;
			return authStatusText;
		}else if ((getAuthStatus().trim()).equalsIgnoreCase("A")) {
			authStatusText = MessageUtil.getMessage("agent.Authorise", context);
			return authStatusText;
		} else {
			authStatusText = MessageUtil.getMessage("agent.UnAuthorise",
					context);
			return authStatusText;
		}
	}

	public void setAuthStatusText(String authStatusText) {
		this.authStatusText = authStatusText;
	}

	public String getTxnStatusText() {
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println("getTxnStatus() = "+getTxnStatus());
		if (getTxnStatus() == null) {
			txnStatusText = null;
			return txnStatusText;
		}else if ((getTxnStatus().trim()).equalsIgnoreCase("R")) {
			txnStatusText = MessageUtil.getMessage(
					"txntracker.txnStatus.received", context);
			return txnStatusText;
		} else if ((getTxnStatus().trim()).equalsIgnoreCase("P")) {
			txnStatusText = MessageUtil.getMessage(
					"txntracker.txnStatus.under", context);
			return txnStatusText;
		} else if ((getTxnStatus().trim()).equalsIgnoreCase("A")) {
			txnStatusText = MessageUtil.getMessage("txntracker.txnStatus.ack",
					context);
			return txnStatusText;
		} else {
			txnStatusText = MessageUtil.getMessage(
					"txntracker.txnStatus.processing", context);
			return txnStatusText;
		}
	}

	public void setAgentStatusText(String agentStatusText) {
		this.txnStatusText = agentStatusText;
	}

	public String getTxnTypeText() {
		FacesContext context = FacesContext.getCurrentInstance();
		if ((getTxnType().trim()).equalsIgnoreCase("R")) {
			txnTypeText = MessageUtil.getMessage("txntracker.txnType.repay",
					context);
			return txnTypeText;
		}
		else if ((getTxnType().trim()).equalsIgnoreCase("C")) {
			txnTypeText = MessageUtil.getMessage("txntracker.txnType.inst",
					context);
			return txnTypeText;
		}
		else if ((getTxnType().trim()).equalsIgnoreCase("M")) {
			txnTypeText = MessageUtil.getMessage("txntracker.txnType.matu",
					context);
			return txnTypeText;
		}
		else if ((getTxnType().trim()).equalsIgnoreCase("T")) {
			txnTypeText = MessageUtil.getMessage("txntracker.txnType.redem",
					context);
			return txnTypeText;
		}
		else {
			txnTypeText = MessageUtil.getMessage("txntracker.txnType.disb",
					context);
			return txnTypeText;
		}
	}

	public void setAgentTypeText(String agentTypeText) {
		this.txnTypeText = agentTypeText;
	}

	
	public String getTxnTimeText() {
		if (getTxnTimestamp() != null) {
			Date IssueDate = getTxnTimestamp();
			Format formatter = new SimpleDateFormat("dd-MMM-yyyy");
			String formattedDate = formatter.format(IssueDate);
			txnTimeText = formattedDate.toString();
			return txnTimeText;
		} else {
			txnTimeText = "";
			return txnTimeText;
		}
		
	}

	public void setTxnTimeText(String txnTimeText) {
		this.txnTimeText = txnTimeText;
	}

	public String getSynTimeText() {
		if (getSyncTime() != null) {
			Date IssueDate = getSyncTime();
			Format formatter = new SimpleDateFormat("dd-MMM-yyyy");
			String formattedDate = formatter.format(IssueDate);
			synTimeText = formattedDate.toString();
			return synTimeText;
		} else {
			synTimeText = "";
			return synTimeText;
		}
	}

	public void setSynTimeText(String synTimeText) {
		this.synTimeText = synTimeText;
	}*/
	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((super.getId() == null) ? 0 :
	 * super.getId().hashCode()); return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return
	 * true; if (obj == null) return false; if (getClass() != obj.getClass())
	 * return false; AgentTransactionVO other = (AgentTransactionVO) obj; if
	 * (super.getId() == null) { if (other.getId() != null) return false; } else
	 * if (!super.getId().equals(other.getId())) return false; return true; }
	 */

}
