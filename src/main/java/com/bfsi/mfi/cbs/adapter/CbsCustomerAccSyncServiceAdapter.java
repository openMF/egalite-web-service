package com.bfsi.mfi.cbs.adapter;


import com.bfsi.mfi.cbs.request.CustomerAccSyncRequest;
import com.bfsi.mfi.cbs.response.CustomerAccSyncResponse;

public abstract class CbsCustomerAccSyncServiceAdapter  extends ApplicationContextHolder {
	public abstract CustomerAccSyncResponse extractCustomerAccounts(
			CustomerAccSyncRequest p_custAccSyncReq);

}
