package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.dao.jdbc.CbsSyncStatusJdbcDao;
import com.bfsi.mfi.entity.StgBranch;

/**
 * 
 * @author Vishal
 *
 */

public abstract class CbsBranchSyncDao  extends CbsSyncStatusJdbcDao {
	public abstract void deleteBranch();
	public abstract void insertBranch(List<StgBranch> p_branch);
	public abstract void deleteBranchOnError(String p_jobId);
	public abstract void deleteBranch(List<StgBranch> p_branch);

	

}
