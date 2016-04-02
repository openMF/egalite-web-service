package com.bfsi.mfi.entity;

public class ServiceResponse {
	private boolean status;
	private String messageCode;
	private String hostMessage;
	private String hostRefNo;

	public ServiceResponse() {
		this.status = false;
	}

	public String getHostRefNo() {
		return hostRefNo;
	}

	public void setHostRefNo(String hostRefNo) {
		this.hostRefNo = hostRefNo;
	}

	public String getHostMessage() {
		return hostMessage;
	}

	public void setHostMessage(String hostMessage) {
		this.hostMessage = hostMessage;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

}
