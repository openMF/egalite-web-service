package com.cbs.bean;

import java.io.Serializable;

public class CbsBaseTransResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3465226123818489320L;
	private String responseCode;
	private String responseMessage;	
	private String cbsResStat;
	private String cbsResTxnRefNo;
	//EGA-MN15-000015 Start
	@Override
	public String toString() {
		return "responseCode: "+responseCode+" responseMessage:"+responseMessage+" cbsResStat:"+ cbsResStat;
	}
	//EGA-MN15-000015 End
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
