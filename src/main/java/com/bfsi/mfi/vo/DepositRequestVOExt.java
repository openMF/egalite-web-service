package com.bfsi.mfi.vo;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.DepositRequestExt;
import com.bfsi.mfi.util.MessageUtil;

public class DepositRequestVOExt extends MaintenanceVO<DepositRequestExt> {
	
	private String requestTypeText;
	private String requeststatusText;
	private String authstatusText;
	//BFSIMFI-278 Guru Start -
	private String syncTimeText;

	public String getSyncTimeText() {
		if(getSyncTime()!= null)
		  {
		Date lastSyncTime =	getSyncTime();
		Format formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
		String formattedDate = formatter.format(lastSyncTime);
		syncTimeText = formattedDate.toString();
		return syncTimeText;
		  }
		else
		  {
			syncTimeText="";
			return syncTimeText;
			
		  }
	
	}

	public void setSyncTimeText(String syncTimeText) {
		this.syncTimeText = syncTimeText;
	}
	//BFSIMFI-278 Guru End

	public DepositRequestVOExt(DepositRequestExt entity) {
		super(entity);
	}

	public DepositRequestVOExt() {
		entity = new DepositRequestExt();
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
	
	public String getAuthstatusText()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		if (getAuthStatus() == null) {
			authstatusText = null;
			return authstatusText;
		}else if ((getAuthStatus().trim()).equalsIgnoreCase("A")) {
			authstatusText = MessageUtil.getMessage("deposit.Auth", context);
			return authstatusText;
		}else {
			authstatusText = MessageUtil.getMessage("deposit.UnAuth", context);
			return authstatusText;
		}
	}
	
	public void setAuthstatusText(String authstatusText)
	{
		this.authstatusText=authstatusText;
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
	
	public String getRequestTypeText() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (getRequestType() == null) {
			requestTypeText = null;
			return requestTypeText;
		}else if ((getRequestType().trim()).equalsIgnoreCase("N")) {
			requestTypeText = MessageUtil.getMessage("deposit.newRequest", context);
			return requestTypeText;
		}else if ((getRequestType().trim()).equalsIgnoreCase("R")) {
			requestTypeText = MessageUtil.getMessage("deposit.redDepositReq", context);
			return requestTypeText;
		}else {
			requestTypeText = MessageUtil.getMessage("deposit.preDeposit",
					context);
			return requestTypeText;
		}
	}

	public void setRequestTypeText(String requestTypeText) {
		this.requestTypeText = requestTypeText;
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
	
	public String getAgentName(){
		return entity.getAgentName();
	}
	
	public void setAgentName(String agentName) {
		entity.setAgentName(agentName);
	}
	
	public String getCustomerName(){
		return entity.getCustomerName();
	}
	
	public void setCustomerName(String customerName) {
		entity.setCustomerName(customerName);
	}
	
	public String getReqError(){
		return entity.getReqError();
	}
	
	public String getRedemptionType() {
		return entity.getRedemptionType();
	}

	public void setRedemptionType(String redemptionType) {
		entity.setRedemptionType(redemptionType);
	}
	
	public String getJobId() {
		return entity.getJobId();
	}

	public void setJobId(String jobId) {
		entity.setJobId(jobId);
	}
	
	public void setReqError(String reqError) {
		entity.setReqError(reqError);
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

	public String getDeposittenure() {
		return entity.getDeposittenure();
	}

	public void setDeposittenure(String deposittenure) {
		entity.setDeposittenure(deposittenure);
	}

	public String getDepositPayfreq() {
		return entity.getDepositPayfreq();
	}

	public void setDepositPayfreq(String depositPayfreq) {
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
	
	public String getRequeststatusText()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		if (getRequeststatus() == null) {
			requeststatusText = null;
			return requeststatusText;
		}else if ((getRequeststatus().trim()).equalsIgnoreCase("P")) {
			requeststatusText = MessageUtil.getMessage("deposit.RequestProcessing", context);
			return requeststatusText;
		}else if ((getRequeststatus().trim()).equalsIgnoreCase("R")) {
			requeststatusText = MessageUtil.getMessage("deposit.RequestReady", context);
			return requeststatusText;
		}else if ((getRequeststatus().trim()).equalsIgnoreCase("A")) {
			requeststatusText = MessageUtil.getMessage("deposit.RequestAcknowledge", context);
			return requeststatusText;
		}else{
			requeststatusText = MessageUtil.getMessage("deposit.RequestFail", context);
			return requeststatusText;
		}
		
	}
	
	public void setRequeststatusText(String requeststatusText)
	{
		this.requeststatusText=requeststatusText;
		
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

	public String getSyncStatus() {
		return entity.getSyncStatus();
	}

	public void setSyncStatus(String syncStatus) {
		entity.setSyncStatus(syncStatus);
	}
	
	//new field added.
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

	public Double getRateofInst() {
		return entity.getRateofInst();
	}

	public void setRateofInst(Double rateofInst) {
		entity.setRateofInst(rateofInst); 
	}

}
