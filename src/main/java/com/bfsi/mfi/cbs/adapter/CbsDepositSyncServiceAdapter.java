package com.bfsi.mfi.cbs.adapter;


import com.bfsi.mfi.cbs.request.DepositActivitySyncRequest;
import com.bfsi.mfi.cbs.request.DepositActivitySyncResponse;
import com.bfsi.mfi.cbs.request.DepositSyncRequest;
import com.bfsi.mfi.cbs.request.DepositSyncResponse;


public abstract class CbsDepositSyncServiceAdapter  extends ApplicationContextHolder{
	/**
	 * 
	 * @author Shabu S Francis
	 *
	 */
	public abstract  DepositSyncResponse extractDeposists(DepositSyncRequest p_request);
	public abstract  DepositActivitySyncResponse extractDeposistActivities(DepositActivitySyncRequest p_request);
}
