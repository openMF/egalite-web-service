package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "MFI_DEPOSIT_ENRICHMENT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DepositEnrichment {

	public DepositEnrichment(){		
	
	}
	private Agent agent;
	private PigmyDeposit deposit;
	
	private String allocateUser;
	private Date allocationTime;
	private String locationCode;
	
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public PigmyDeposit getDeposit() {
		return deposit;
	}
	public void setPigmyDeposit(PigmyDeposit deposit) {
		this.deposit = deposit;
	}
	public String getAllocateUser() {
		return allocateUser;
	}
	public void setAllocateUser(String allocateUser) {
		this.allocateUser = allocateUser;
	}
	public Date getAllocationTime() {
		return allocationTime;
	}
	public void setAllocationTime(Date allocationTime) {
		this.allocationTime = allocationTime;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
}
