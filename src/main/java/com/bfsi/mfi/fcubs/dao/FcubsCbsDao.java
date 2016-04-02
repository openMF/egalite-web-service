package com.bfsi.mfi.fcubs.dao;

/**
 * Dao for FCUBS interaction
 * 
 * @author arun
 * 
 */
public interface FcubsCbsDao {
	/**
	 * Fetch branch details to local database
	 */
	void getBranchData(String jobId);
	
	/**
	  Fetch Deposit details to local database
	 */
	void getDepositData(String jobId);    // new for Deposit

	/**
	 * Fetch branch details to local database
	 */
	void getCustomerData(String jobId);

	/**
	 * Fetch loan details to local database
	 */
	void getLoanData(String jobId);

	/**
	 * Fetch FX Currency details to local database
	 */
	void getFxCurrencyData(String jobId);

	/**
	 * Post transactions to CBS
	 */

	void getCurrency(String jobId);
	/**
	 * 
	 * Fetch Payment details to local database
	 */
	void getPaymentData(String jobId);

}
