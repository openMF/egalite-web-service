package com.bfsi.mfi.cbs.adapter;

import com.bfsi.mfi.cbs.request.FxRatesSyncRequest;
import com.bfsi.mfi.cbs.response.FxRatesSyncResponse;

/**
 * 
 * @author Vishal
 *
 */

public abstract class  CbsFxRatesSyncServiceAdapter  extends ApplicationContextHolder {
	
	public abstract  FxRatesSyncResponse extractFxRates(FxRatesSyncRequest p_request);

}
