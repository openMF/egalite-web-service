package com.bfsi.mfi.entity;

import java.util.List;

public class TransactionServiceResponse extends ServiceResponse {

	private List<String> receivedTransactions;

	public List<String> getReceivedTransactions() {
		return receivedTransactions;
	}

	public void setReceivedTransactions(List<String> receivedTransactions) {
		this.receivedTransactions = receivedTransactions;
	}

}
