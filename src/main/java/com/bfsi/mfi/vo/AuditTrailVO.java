package com.bfsi.mfi.vo;

import java.util.Date;

import javax.persistence.Entity;

/**
 * AuditTrailVO for display along with the entity
 * 
 * @author akrishna
 * 
 */
@Entity(name = "MFI_AUDIT_DETAIL")
public class AuditTrailVO {
	private String id;
	private String tableName;
	private String keyId;
	private String objectXml = "";
	private String maker;
	private Date makerTimestamp;
	private String checker;
	private Date checkerTimestamp;
	private Integer version;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public String getObjectXml() {
		return objectXml;
	}

	public void setObjectXml(String objectXml) {
		this.objectXml = objectXml;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public Date getMakerTimestamp() {
		return makerTimestamp;
	}

	public void setMakerTimestamp(Date makerTimestamp) {
		this.makerTimestamp = makerTimestamp;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public Date getCheckerTimestamp() {
		return checkerTimestamp;
	}

	public void setCheckerTimestamp(Date checkerTimestamp) {
		this.checkerTimestamp = checkerTimestamp;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getId() {
		return tableName + "~" + keyId + "~" + version;
	}

}
