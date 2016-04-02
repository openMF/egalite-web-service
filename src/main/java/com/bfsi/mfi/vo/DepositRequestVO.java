package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.DepositRequest;

public class DepositRequestVO extends MaintenanceVO<DepositRequest> {
	public DepositRequestVO(DepositRequest entity) {
		super(entity);
	}

	public Double getRateofInst() {
		return entity.getRateofInst();
	}

	public void setRateofInst(Double rateofInst) {
		entity.setRateofInst(rateofInst);
	}

	public DepositRequestVO() {
		entity = new DepositRequest();
	}

	public Date getFirstPaymentDate() {
		return entity.getFirstPaymentDate();
	}

	public void setFirstPaymentDate(Date firstPaymentDate) {
		entity.setFirstPaymentDate(firstPaymentDate);
	}

	public String getRedemptionType() {
		return entity.getRedemptionType();
	}

	public void setRedemptionType(String redemptionType) {
		entity.setRedemptionType(redemptionType);
	}

	public Double getReqAmnt() {
		return entity.getReqAmnt();
	}

	public void setReqAmnt(Double reqAmnt) {
		entity.setReqAmnt(reqAmnt);
	}

	public String getDeviceId() {
		return entity.getDeviceId();
	}

	public void setDeviceId(String deviceId) {
		entity.setDeviceId(deviceId);
	}

	public String getAuthStatus() {
		return entity.getAuthStatus();
	}

	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus);
	}

	public String getBranchCode() {
		return entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode);
	}

	public String getRequestId() {
		return super.getId();
	}

	public void setRequestId(String requestId) {
		super.setId(requestId);
	}

	public String getRequestType() {
		return entity.getRequestType();
	}

	public void setRequestType(String requestType) {
		entity.setRequestType(requestType);
	}

	public Date getRequestDate() {
		return entity.getRequestDate();
	}

	public void setRequestDate(Date requestDate) {
		entity.setRequestDate(requestDate);
	}

	public String getModuleCode() {
		return entity.getModuleCode();
	}

	public void setModuleCode(String moduleCode) {
		entity.setModuleCode(moduleCode);
	}

	public String getProductCode() {
		return entity.getProductCode();
	}

	public void setProductCode(String productCode) {
		entity.setProductCode(productCode);
	}

	public String getAgentId() {
		return entity.getAgentId();
	}

	public void setAgentId(String agentId) {
		entity.setAgentId(agentId);
	}

	public String getCustomerId() {
		return entity.getCustomerId();
	}

	public void setCustomerId(String customerId) {
		entity.setCustomerId(customerId);
	}

	public String getDepositCcy() {
		return entity.getDepositCcy();
	}

	public void setDepositCcy(String depositCcy) {
		entity.setDepositCcy(depositCcy);
	}

	public Double getDepInstallmentAmt() {
		return entity.getDepInstallmentAmt();
	}

	public void setDepInstallmentAmt(Double depInstallmentAmt) {
		entity.setDepInstallmentAmt(depInstallmentAmt);
	}

	public int getDeposittenure() {
		return entity.getDeposittenure();
	}

	public void setDeposittenure(int deposittenure) {
		entity.setDeposittenure(deposittenure);
	}

	public int getDepositPayfreq() {
		return entity.getDepositPayfreq();
	}

	public void setDepositPayfreq(int depositPayfreq) {
		entity.setDepositPayfreq(depositPayfreq);
	}

	public String getNumOfInst() {
		return entity.getNumOfInst();
	}

	public void setNumOfInst(String numOfInst) {
		entity.setNumOfInst(numOfInst);
	}

	public String getNarrative() {
		return entity.getNarrative();
	}

	public void setNarrative(String narrative) {
		entity.setNarrative(narrative);
	}

	public Date getDepOpenDate() {
		return entity.getDepOpenDate();
	}

	public void setDepOpenDate(Date depOpenDate) {
		entity.setDepOpenDate(depOpenDate);
	}

	public String getDepositAccNum() {
		return entity.getDepositAccNum();
	}

	public void setDepositAccNum(String depositAccNum) {
		entity.setDepositAccNum(depositAccNum);
	}

	public String getRequeststatus() {
		return entity.getRequeststatus();
	}

	public void setRequeststatus(String requeststatus) {
		entity.setRequeststatus(requeststatus);
	}

	public String getRequestRemark() {
		return entity.getRequestRemark();
	}

	public void setRequestRemark(String requestRemark) {
		entity.setRequestRemark(requestRemark);
	}

	public Double getAmountTillDate() {
		return entity.getAmountTillDate();
	}

	public void setAmountTillDate(Double amountTillDate) {
		entity.setAmountTillDate(amountTillDate);
	}

	public Date getRedempReqDate() {
		return entity.getRedempReqDate();
	}

	public void setRedempReqDate(Date redempReqDate) {
		entity.setRedempReqDate(redempReqDate);
	}

	public Double getRedemReqAmt() {
		return entity.getRedemReqAmt();
	}

	public void setRedemReqAmt(Double redemReqAmt) {
		entity.setRedemReqAmt(redemReqAmt);
	}

	public Date getMaturityDate() {
		return entity.getMaturityDate();
	}

	public void setMaturityDate(Date maturityDate) {
		entity.setMaturityDate(maturityDate);
	}

	public Double getPrepaymentAmt() {
		return entity.getPrepaymentAmt();
	}

	public void setPrepaymentAmt(Double prepaymentAmt) {
		entity.setPrepaymentAmt(prepaymentAmt);
	}

	public Date getSyncTime() {
		return entity.getSyncTime();
	}

	public void setSyncTime(Date syncTime) {
		entity.setSyncTime(syncTime);
	}

	public String getTenureType() {
		return entity.getTenureType();
	}

	public void setTenureType(String tenureType) {
		entity.setTenureType(tenureType);
	}

	public String getFrequencyType() {
		return entity.getFrequencyType();
	}

	public void setFrequencyType(String frequencyType) {
		entity.setFrequencyType(frequencyType);
	}
	
}
