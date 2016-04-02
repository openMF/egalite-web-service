package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.DepositEnrichment;

public interface DepositEnrichmentDao {
	/**
	 * Get Deposit details with Agent First Name.
	 */
//	public List<DepositEnrichment> get();

	/**
	 * Update Deposit Entity with selected Agent.
	 */
	public void insert(DepositEnrichment depositEnrichment);

	/**
	 * Get Unassinged Deposit accounts
	 * 
	 * @return
	 */
	public List<DepositEnrichment> getUnassigned();
	/**
	 * Get Unassinged loan accounts
	 * 
	 * @return
	 */
	public void updateDeposit(DepositEnrichment depositEnrichment);
}
