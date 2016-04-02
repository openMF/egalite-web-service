package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.FunctionMbs;
import com.bfsi.mfi.vo.FunctionMbsVO;

public interface FunctionMbsDao  {

	/**
	 * Fetch functions for given role
	 * 
	 * @param roleId
	 * @return list of functions. Empty list if no function exist
	 */
	List<FunctionMbs> getFunctionsForRole(String roleId);
	List<FunctionMbs> getMbsFunction();


}
