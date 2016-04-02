package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "MFI_SYS_PARAMETERS")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SystemParameter {
	public SystemParameter() {
	}
	
	@Column(name = "PARAM_NAME", nullable = false)
	@Id
	private String paramName;
	
	@Column(name = "PARAM_TEXT", nullable = false)
	private String paramText;

	@Column(name = "PARAM_TYPE", nullable = false)
	private String paramType;

	@Column(name = "PARAM_VALUE", nullable = false)
	private String paramValue;

	@Column(name = "EDITABLE", nullable = false)
	private String editable;

	@Column(name = "COMPONENTS", nullable = false)
	private String components;

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamText() {
		return paramText;
	}

	public void setParamText(String paramText) {
		this.paramText = paramText;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getEditable() {
		return editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	public String getComponents() {
		return components;
	}

	public void setComponents(String components) {
		this.components = components;
	}

}
