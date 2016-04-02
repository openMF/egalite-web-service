package com.bfsi.mfi.entity;

public class CbsUploadStatus  extends MaintenanceEntity {
	public CbsUploadStatus() {

	}
	
	private String errorType;
	private String errorClass;
	private String errorKey;
	private String errorCode;
	private String errorDesc;
	
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public String getErrorClass() {
		return errorClass;
	}
	public void setErrorClass(String errorClass) {
		this.errorClass = errorClass;
	}
	public String getErrorKey() {
		return errorKey;
	}
	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

}
