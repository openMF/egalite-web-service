package com.bfsi.mfi.cbs.response;

public class CbsBaseResponse {
	
	private boolean status;
	private String responseCode;
	private String responseMessage;	
	private String cbsResStat;
	private String cbsResTxnRefNo;
	
	@Override
	public String toString() {
		
		return " status: " + status+ " responseCode: " + responseCode+" responseMessage: " + responseMessage+
				" cbsResStat: " + cbsResStat+" cbsResTxnRefNo: " + cbsResTxnRefNo;
			
		
	}
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public String getCbsResStat() {
		return cbsResStat;
	}
	public void setCbsResStat(String cbsResStat) {
		this.cbsResStat = cbsResStat;
	}
	public String getCbsResTxnRefNo() {
		return cbsResTxnRefNo;
	}
	public void setCbsResTxnRefNo(String cbsResTxnRefNo) {
		this.cbsResTxnRefNo = cbsResTxnRefNo;
	}
	
}
