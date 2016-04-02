package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.Function;

public interface FunctionDao extends MaintenanceDao<Function> {

	/**
	 * Fetch functions for given role
	 * 
	 * @param roleId
	 * @return list of functions. Empty list if no function exist
	 */
	List<Function> getFunctionsForRole(String roleId);


}
