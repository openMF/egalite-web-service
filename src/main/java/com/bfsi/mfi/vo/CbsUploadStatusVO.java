package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.CbsUploadStatus;


public class CbsUploadStatusVO extends MaintenanceVO<CbsUploadStatus>{
	public CbsUploadStatusVO() {
		entity = new CbsUploadStatus();
	}
	
	public CbsUploadStatusVO(CbsUploadStatus entity) {
		super(entity);
	}
	
	public String getErrorType() {
		return entity.getErrorType();
	}
	public void setErrorType(String errorType) {
		entity.setErrorType(errorType);
	}
	public String getErrorClass() {
		return entity.getErrorClass();
	}
	public void setErrorClass(String errorClass) {
		entity.setErrorClass(errorClass);
	}
	public String getErrorKey() {
		return entity.getErrorKey();
	}
	public void setErrorKey(String errorKey) {
		entity.setErrorKey(errorKey);
	}
	public String getErrorCode() {
		return entity.getErrorCode();
	}
	public void setErrorCode(String errorCode) {
		entity.setErrorCode(errorCode);
	}
	public String getErrorDesc() {
		return entity.getErrorDesc();
	}
	public void setErrorDesc(String errorDesc) {
		entity.setErrorDesc(errorDesc);
	}

}
