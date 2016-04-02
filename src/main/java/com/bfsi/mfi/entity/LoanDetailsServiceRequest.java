package com.bfsi.mfi.entity;

import java.util.List;

public class LoanDetailsServiceRequest {

	private String agentId;
	private String locCode;
	private List<String> recvdLoans;
	private int batchSize;

	public int getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	public List<String> getRecvdLoans() {
		return recvdLoans;
	}

	public void setRecvdLoans(List<String> recvdLoans) {
		this.recvdLoans = recvdLoans;
	}

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


}
