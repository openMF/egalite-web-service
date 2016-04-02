package com.bfsi.mfi.entity;

import java.util.List;


public class AgendaServiceRequest {
	private String agentId;
	private String deviceId;
	private int batchSize;
	private String locationCode;
	private List<AgendaUpdate> agendaUpdate;
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
	public int getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public List<AgendaUpdate> getAgendaUpdate() {
		return agendaUpdate;
	}
	public void setAgendaUpdate(List<AgendaUpdate> agendaUpdate) {
		this.agendaUpdate = agendaUpdate;
	}
	
}
