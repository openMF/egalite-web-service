package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "MFI_MSG_CODE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorCode extends MaintenanceEntity{
	public ErrorCode()
	{
		
	}
/*	@Column(name = "MSG_CODE", nullable = false)
	private String msgCode;
	*/
	@Column(name = "LANG", nullable = false)
	private String lang;
	
	@Column(name = "MSG_DESC", nullable = false)
	private String msgDesc;
	
	@Column(name = "ERR_TYPE", nullable = false)
	private String errType;
	
	@Column(name = "SUB_SYS", nullable = false)
	private String subSys;
	
	@Column(name = "MSG_TYPE", nullable = false)
	private String msgType;
	
/*	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}*/

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getMsgDesc() {
		return msgDesc;
	}

	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}

	public String getErrType() {
		return errType;
	}

	public void setErrType(String errType) {
		this.errType = errType;
	}

	public String getSubSys() {
		return subSys;
	}

	public void setSubSys(String subSys) {
		this.subSys = subSys;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	
	
	

}
