package com.bfsi.mfi.cbs.adapter;


import com.bfsi.mfi.cbs.request.CcySyncRequest;
import com.bfsi.mfi.cbs.response.CcySyncResponse;


/**
 * 
 * @author Vishal
 *
 */

public abstract class CbsCcySyncServiceAdapter  extends ApplicationContextHolder  {
	public abstract  CcySyncResponse extractCurrency(CcySyncRequest p_request);
}
