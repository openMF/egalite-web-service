package com.bfsi.mfi.cbs.model;

import java.util.Date;

public class CbsDeposit {
	private String depoAccNo;
	private String creditOfficerId;//
	private String depoStatus;//
	private String cbsLcrCode;//
	private String cbsLcrType;//
	private String cbsAgentCode;//
	private String branchCode;
	private String customerId;
	private String currency;
	private Date openingDate;
	//private String locCode;
	private Date maturityDate;
	private Double schInstalAmt;
	private String payFrqType;
	private Integer payFreq;
	private String tenureType;
	private Integer tenure;
	private Double intrRate;
	private Double princMaturityAmt;
	private Double intrAccuredTillDate;
	private Double instalPaidTillDate;
	private Double totInstAmtDue;
	private String redemptionFlag;
	private Date redemptionPayoutDate;
	private Double redemptionAmt;
	private String recStatus;
	private String cbsUploadJobId;

	public Double getInstalPaidTillDate() {
		return instalPaidTillDate;
	}

	public void setInstalPaidTillDate(Double instalPaidTillDate) {
		this.instalPaidTillDate = instalPaidTillDate;
	}

	public String getCreditOfficerId() {
		return creditOfficerId;
	}

	public void setCreditOfficerId(String creditOfficerId) {
		this.creditOfficerId = creditOfficerId;
	}

	public String getDepoStatus() {
		return depoStatus;
	}

	public void setDepoStatus(String depoStatus) {
		this.depoStatus = depoStatus;
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

	public String getCbsAgentCode() {
		return cbsAgentCode;
	}

	public void setCbsAgentCode(String cbsAgentCode) {
		this.cbsAgentCode = cbsAgentCode;
	}

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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	
	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Double getSchInstalAmt() {
		return schInstalAmt;
	}

	public void setSchInstalAmt(Double schInstalAmt) {
		this.schInstalAmt = schInstalAmt;
	}

	public String getPayFrqType() {
		return payFrqType;
	}

	public void setPayFrqType(String payFrqType) {
		this.payFrqType = payFrqType;
	}

	public Integer getPayFreq() {
		return payFreq;
	}

	public void setPayFreq(Integer payFreq) {
		this.payFreq = payFreq;
	}

	public String getTenureType() {
		return tenureType;
	}

	public void setTenureType(String tenureType) {
		this.tenureType = tenureType;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public Double getIntrRate() {
		return intrRate;
	}

	public void setIntrRate(Double intrRate) {
		this.intrRate = intrRate;
	}

	public Double getPrincMaturityAmt() {
		return princMaturityAmt;
	}

	public void setPrincMaturityAmt(Double princMaturityAmt) {
		this.princMaturityAmt = princMaturityAmt;
	}

	public Double getIntrAccuredTillDate() {
		return intrAccuredTillDate;
	}

	public void setIntrAccuredTillDate(Double intrAccuredTillDate) {
		this.intrAccuredTillDate = intrAccuredTillDate;
	}

	
	public Double getTotInstAmtDue() {
		return totInstAmtDue;
	}

	public void setTotInstAmtDue(Double totInstAmtDue) {
		this.totInstAmtDue = totInstAmtDue;
	}

	public String getRedemptionFlag() {
		return redemptionFlag;
	}

	public void setRedemptionFlag(String redemptionFlag) {
		this.redemptionFlag = redemptionFlag;
	}

	public Date getRedemptionPayoutDate() {
		return redemptionPayoutDate;
	}

	public void setRedemptionPayoutDate(Date redemptionPayoutDate) {
		this.redemptionPayoutDate = redemptionPayoutDate;
	}

	public Double getRedemptionAmt() {
		return redemptionAmt;
	}

	public void setRedemptionAmt(Double redemptionAmt) {
		this.redemptionAmt = redemptionAmt;
	}

	public String getRecStatus() {
		return recStatus;
	}

	public void setRecStatus(String recStatus) {
		this.recStatus = recStatus;
	}

	public String getCbsUploadJobId() {
		return cbsUploadJobId;
	}

	public void setCbsUploadJobId(String cbsUploadJobId) {
		this.cbsUploadJobId = cbsUploadJobId;
	}
}
