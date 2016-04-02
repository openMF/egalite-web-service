package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "mfi_cust_ac_enrichment")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustAcEnrichment extends MaintenanceEntity{
	public CustAcEnrichment() {
	}
	
	/* CUST_AC_NO      VARCHAR2(25) not null,//super
	  AGENT_ID        VARCHAR2(25),
	  LOCATION_CODE   VARCHAR2(25),
	  ALLOCATION_BY   VARCHAR2(25),
	  ALLOCATION_TIME DATE*/
	
	private Agent agent;
	/*@Column(name = "AGENT_ID", nullable = false)
	private String agentID;*/
	
	@Column(name = "LOCATION_CODE", nullable = false)
	private String locationCode;
	@Column(name = "ALLOCATION_BY", nullable = false)
	private String allocationBy;
	@Column(name = "ALLOCATION_TIME", nullable = false)
	private Date allocationTime;
	
	
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getAllocationBy() {
		return allocationBy;
	}
	public void setAllocationBy(String allocationBy) {
		this.allocationBy = allocationBy;
	}
	public Date getAllocationTime() {
		return allocationTime;
	}
	public void setAllocationTime(Date allocationTime) {
		this.allocationTime = allocationTime;
	}
	
	

}
