package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.DepositActivity;

/**
 * @author Bablu kumar
 *
 */

public interface DepositActivityDao extends MaintenanceDao<DepositActivity>{
	
	public List<DepositActivity> getDepositActivityView(String id);

	
}
