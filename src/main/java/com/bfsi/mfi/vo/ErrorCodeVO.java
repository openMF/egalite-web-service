package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.ErrorCode;

public class ErrorCodeVO extends MaintenanceVO<ErrorCode> {
	public ErrorCodeVO() {
		entity = new ErrorCode();
	}

	public ErrorCodeVO(ErrorCode entity) {
		super(entity);
	}

	public String getMsgCode() {
		return entity.getId();
	}

	public void setMsgCode(String msgCode) {
		entity.setId(msgCode);
	}
	
	public String getLang() {
		return entity.getLang();
	}

	public void setLang(String lang) {
		entity.setLang(lang);
		
	}

	public String getMsgDesc() {
		return entity.getMsgDesc();
	}

	public void setMsgDesc(String msgDesc) {
	    entity.setMsgDesc(msgDesc);
	}

	public String getErrType() {
		return entity.getErrType();
	}

	public void setErrType(String errType) {
		entity.setErrType(errType);
		
	}

	public String getSubSys() {
		return entity.getSubSys();
	}

	public void setSubSys(String subSys) {
		entity.setSubSys(getSubSys());
		
	}

	public String getMsgType() {
		return entity.getMsgType();
	}

	public void setMsgType(String msgType) {
		entity.setMsgType(msgType);
		
	}
	
}
