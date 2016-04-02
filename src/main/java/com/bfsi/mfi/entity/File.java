package com.bfsi.mfi.entity;

import java.io.InputStream;

public class File extends MaintenanceEntity {
	private String agentId;
	private String deviceId;
	private InputStream in;
	
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public InputStream getIn() {
		return in;
	}
	public void setIn(InputStream in) {
		this.in = in;
	}
}
