package com.bfsi.mfi.entity;

import java.util.List;

public class CustomerEnrolServiceResponse extends ServiceResponse {
	
	private List<String> recvdIds;

	public List<String> getRecvdIds() {
		return recvdIds;
	}

	public void setRecvdIds(List<String> recvdIds) {
		this.recvdIds = recvdIds;
	}

}
