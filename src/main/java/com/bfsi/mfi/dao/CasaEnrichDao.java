package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.CustAcEnrichment;

public interface CasaEnrichDao {
    

	/**
	 * Get Customer A/C details with Agent First Name.
	 */
	public List<CustAcEnrichment> get();

	/**
	 * Update Customer A/C  Entity with selected Agent.
	 */
	public void insert(CustAcEnrichment custEnrichment);

	/**
	 * Get Unassinged Customer A/C  accounts
	 * 
	 * @return
	 */
	public List<CustAcEnrichment> getUnassigned();
}
