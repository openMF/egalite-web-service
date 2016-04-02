package com.bfsi.mfi.vo;

import java.util.Date;


import com.bfsi.mfi.entity.LoanEnrichment;

/**
 * AgentAllocationsVO Value Object to be bound to the screen, which extends
 * LoanVO For LoanEnrichment activity.
 * 
 * @author Jyoti Ranjan
 * 
 */
public class AgentAllocationsVO {
	private LoanVO loan = new LoanVO();
	private AgentVO agent = new AgentVO();
	
	private LoanEnrichment entity=new LoanEnrichment();
	
	public String getId() {
		return loan.getId();
	}
	
	public void setId(String id) {
		loan.setId(id);
	}
	public AgentVO getAgent() {
		return agent;
	}

	public void setAgent(AgentVO agent) {
		this.agent = agent;
	}

	public LoanVO getLoan() {
		return loan;
	}

	public void setLoan(LoanVO loan) {
		this.loan = loan;
	}

	public String getAllocateUser() {
		return entity.getAllocateUser();
	}

	public void setAllocateUser(String allocateUser) {
		this.entity.setAllocateUser(allocateUser);
	}

	public Date getAllocationTime() {
		return entity.getAllocationTime();
	}

	public void setAllocationTime(Date allocationTime) {
		entity.setAllocationTime(allocationTime);
	}
	
	
	public String getLocationCode() {
		return entity.getLocationCode();
	}

	public void setLocationCode(String locationCode) {
		this.entity.setLocationCode(locationCode);
	}

	
}
