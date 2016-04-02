package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class MaintenanceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private String id;

	private String maker;
	private Date makerTimestamp;
	private String checker;
	private Date checkerTimestamp;
	private String authStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}
}
