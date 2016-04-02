package com.bfsi.mfi.cbs.adapter;


import com.bfsi.mfi.cbs.request.BranchSyncRequest;
import com.bfsi.mfi.cbs.response.BranchSyncResponse;

/**
 * 
 * @author Vishal
 *
 */

public abstract class CbsBranchSyncServiceAdapter  extends ApplicationContextHolder  {
	
	public abstract  BranchSyncResponse extractBranch(BranchSyncRequest p_request);	

}
