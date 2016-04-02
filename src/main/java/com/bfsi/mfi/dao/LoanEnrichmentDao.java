package com.bfsi.mfi.dao;

/**
 * LoanEnrichment DAO
 * 
 * @author Jyoti Ranjan
 * 
 * @param <Loan>
 */

import java.util.List;

import com.bfsi.mfi.entity.LoanEnrichment;

public interface LoanEnrichmentDao {

	/**
	 * Get Loan details with Agent First Name.
	 */
	public List<LoanEnrichment> get();

	/**
	 * Update Loan Entity with selected Agent.
	 */
	public void insert(LoanEnrichment loanEnrichment);

	/**
	 * Get Unassinged loan accounts
	 * 
	 * @return
	 */
	public List<LoanEnrichment> getUnassigned();
}
