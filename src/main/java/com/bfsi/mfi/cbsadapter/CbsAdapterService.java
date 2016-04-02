package com.bfsi.mfi.cbsadapter;

/**
 * Root interface for CBS adapter
 * 
 * @author arun
 * 
 */
public interface CbsAdapterService {

	void fetchCbsBranches(String jobId);

	void fetchCbsCustomers(String jobId);

	void fetchCbsMfiLoans(String jobId);
	
	void fetchCbsMfiDeposit(String jobId);

	void fetchCbsFx(String jobId);

	void postTxn();

	void prepareForPostTxn();

	void fetchCbsCcy(String jobId);
}