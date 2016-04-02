package com.bfsi.mfi.entity;

import java.util.List;

public class CustomerAccountServiceRequest {
	
	private String agentId;
	private String locCode;
	private int batchSize;
	private List<String> rcvCustAcc;
	
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getLocCode() {
		return locCode;
	}
	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}
	public int getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	public List<String> getRcvCustAcc() {
		return rcvCustAcc;
	}
	public void setRcvCustAcc(List<String> rcvCustAcc) {
		this.rcvCustAcc = rcvCustAcc;
	}
	
	
}
