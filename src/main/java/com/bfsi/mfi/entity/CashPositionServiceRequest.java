package com.bfsi.mfi.entity;

public class CashPositionServiceRequest extends BaseServiceRequest {
	private String[] recvdIds;
	private int batchSize;

	public String[] getRecvdIds() {
		return recvdIds;
	}

	public void setRecvdIds(String[] recvdIds) {
		this.recvdIds = recvdIds;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

}
