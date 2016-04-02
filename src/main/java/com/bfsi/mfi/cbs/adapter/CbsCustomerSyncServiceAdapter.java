package com.bfsi.mfi.cbs.adapter;


import com.bfsi.mfi.cbs.request.CustomerSyncRequest;
import com.bfsi.mfi.cbs.response.CustomerSyncResponse;

/**
 * 
 * @author Vishal
 *
 */

public abstract class CbsCustomerSyncServiceAdapter  extends ApplicationContextHolder  {
	
	public abstract CustomerSyncResponse extractCustomer(CustomerSyncRequest p_request);

}
