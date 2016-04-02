package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.CustAcEnrichment;

public class CustAcEnrichmentVO extends MaintenanceVO<CustAcEnrichment>{
	public CustAcEnrichmentVO() {
		entity = new CustAcEnrichment();
	}

	public CustAcEnrichmentVO(CustAcEnrichment entity) {
		super(entity);
	}

	
	private AgentVO agent = new AgentVO();
	
	
	public AgentVO getAgent() {
		return agent;
	}

	public void setAgent(AgentVO agent) {
		this.agent = agent;
	}

	/*public String getAgentID() {
		return entity.getAgentID();
	}
	public void setAgentID(String agentID) {
		entity.setAgentID(agentID);
	}*/
	public String getLocationCode() {
		return entity.getLocationCode();
	}
	public void setLocationCode(String locationCode) {
		entity.setLocationCode(locationCode); 
	}
	public String getAllocationBy() {
		return entity.getAllocationBy();
	}
	public void setAllocationBy(String allocationBy) {
		entity.setAllocationBy(allocationBy); 
	}
	public Date getAllocationTime() {
		return entity.getAllocationTime();
	}
	public void setAllocationTime(Date allocationTime) {
		entity.setAllocationTime(allocationTime);
	}
	
}
