package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.DepositEnrichment;

public class AgentAllocationsForDepositVO {
	private LoanVO loan = new LoanVO();
	private AgentVO agent = new AgentVO();
	private PigmyDepositVO deposit = new PigmyDepositVO();
	private DepositEnrichment entity =new DepositEnrichment();
	
	public PigmyDepositVO getDeposit() {
		return deposit;
	}

	public void setDeposit(PigmyDepositVO deposit) {
		this.deposit = deposit;
	}

	public String getId() {
		return deposit.getId();
	}
	
	public void setId(String id) {
		deposit.setId(id);
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
		this.entity.setAllocationTime(allocationTime);
	}
	public String getLocationCode() {
		return entity.getLocationCode();
	}

	public void setLocationCode(String locationCode) {
		this.entity.setLocationCode(locationCode);
	}
}