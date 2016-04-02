package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "MFI_LOAN_ENRICHMENT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LoanEnrichment {
	public LoanEnrichment() {
	}

	private Agent agent;
	private Loan loan;

	@Column(name = "ALLOCATION_BY", nullable = false)
	private String allocateUser;
	@Column(name = "ALLOCATION_TIME", nullable = false)
	private Date allocationTime;
	
	@Column(name = "LOCATION_CODE", nullable = false)
	private String locationCode;
	
	
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
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
