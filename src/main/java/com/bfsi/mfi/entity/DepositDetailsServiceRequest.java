package com.bfsi.mfi.entity;

import java.util.List;

public class DepositDetailsServiceRequest {
	private String agentId;
	private String locCode;
	private List<String> recvdDeposits;
	private int batchSize;

	public int getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
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

	public List<String> getRecvdDeposits() {
		return recvdDeposits;
	}

	public void setRecvdDeposits(List<String> recvdDeposits) {
		this.recvdDeposits = recvdDeposits;
	}

}
