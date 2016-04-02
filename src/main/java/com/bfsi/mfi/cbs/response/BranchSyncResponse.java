package com.bfsi.mfi.cbs.response;

import java.util.List;

import com.bfsi.mfi.cbs.model.CbsBranch;

/**
 * 
 * @author Vishal
 *
 */

public class BranchSyncResponse {
	
	private List<CbsBranch> branchList;

	public List<CbsBranch> getBranchList() {
		return branchList;
	}

	public void setBranchList(List<CbsBranch> branchList) {
		this.branchList = branchList;
	}

}
