package com.bfsi.mfi.entity;

import java.util.Date;

public class DepositRequest extends MaintenanceEntity {
	private String requestType;
	private Date requestDate;
	private String moduleCode;
	private String productCode;
	private String agentId;
	private String customerId;
	private String depositCcy;
	private Double depInstallmentAmt;
	private int deposittenure;
	private int depositPayfreq;
	private String numOfInst;
	private String narrative;
	private Date depOpenDate;
	private String depositAccNum;
	private String requeststatus;
	private String requestRemark;
	private Double amountTillDate;
	private Date redempReqDate;
	private Double redemReqAmt;
	private Date maturityDate;
	private Double prepaymentAmt;
	private Date syncTime;
	private Double reqAmnt;
	private String branchCode;
	private String deviceId;
	private String authStatus;
	private Double rateofInst;
	private Date firstPaymentDate;
	private String redemptionType;
	
	private String tenureType;
	private String frequencyType;

	public Date getFirstPaymentDate() {
		return firstPaymentDate;
	}

	public void setFirstPaymentDate(Date firstPaymentDate) {
		this.firstPaymentDate = firstPaymentDate;
	}

	public String getRedemptionType() {
		return redemptionType;
	}

	public void setRedemptionType(String redemptionType) {
		this.redemptionType = redemptionType;
	}

	public Double getRateofInst() {
		return rateofInst;
	}

	public void setRateofInst(Double rateofInst) {
		this.rateofInst = rateofInst;
	}

	public Double getReqAmnt() {
		return reqAmnt;
	}

	public void setReqAmnt(Double reqAmnt) {
		this.reqAmnt = reqAmnt;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public DepositRequest() {

	}

	public String getRequestId() {
		return super.getId();
	}

	public void setRequestId(String requestId) {
		super.setId(requestId);
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getDepositCcy() {
		return depositCcy;
	}

	public void setDepositCcy(String depositCcy) {
		this.depositCcy = depositCcy;
	}

	public Double getDepInstallmentAmt() {
		return depInstallmentAmt;
	}

	public void setDepInstallmentAmt(Double depInstallmentAmt) {
		this.depInstallmentAmt = depInstallmentAmt;
	}

	public int getDeposittenure() {
		return deposittenure;
	}

	public void setDeposittenure(int deposittenure) {
		this.deposittenure = deposittenure;
	}

	public int getDepositPayfreq() {
		return depositPayfreq;
	}

	public void setDepositPayfreq(int depositPayfreq) {
		this.depositPayfreq = depositPayfreq;
	}

	public String getNumOfInst() {
		return numOfInst;
	}

	public void setNumOfInst(String numOfInst) {
		this.numOfInst = numOfInst;
	}

	public String getNarrative() {
		return narrative;
	}

	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	public Date getDepOpenDate() {
		return depOpenDate;
	}

	public void setDepOpenDate(Date depOpenDate) {
		this.depOpenDate = depOpenDate;
	}

	public String getDepositAccNum() {
		return depositAccNum;
	}

	public void setDepositAccNum(String depositAccNum) {
		this.depositAccNum = depositAccNum;
	}

	public String getRequeststatus() {
		return requeststatus;
	}

	public void setRequeststatus(String requeststatus) {
		this.requeststatus = requeststatus;
	}

	public String getRequestRemark() {
		return requestRemark;
	}

	public void setRequestRemark(String requestRemark) {
		this.requestRemark = requestRemark;
	}

	public Double getAmountTillDate() {
		return amountTillDate;
	}

	public void setAmountTillDate(Double amountTillDate) {
		this.amountTillDate = amountTillDate;
	}

	public Date getRedempReqDate() {
		return redempReqDate;
	}

	public void setRedempReqDate(Date redempReqDate) {
		this.redempReqDate = redempReqDate;
	}

	public Double getRedemReqAmt() {
		return redemReqAmt;
	}

	public void setRedemReqAmt(Double redemReqAmt) {
		this.redemReqAmt = redemReqAmt;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Double getPrepaymentAmt() {
		return prepaymentAmt;
	}

	public void setPrepaymentAmt(Double prepaymentAmt) {
		this.prepaymentAmt = prepaymentAmt;
	}

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	public String getTenureType() {
		return tenureType;
	}

	public void setTenureType(String tenureType) {
		this.tenureType = tenureType;
	}

	public String getFrequencyType() {
		return frequencyType;
	}

	public void setFrequencyType(String frequencyType) {
		this.frequencyType = frequencyType;
	}

	
	
	
}
