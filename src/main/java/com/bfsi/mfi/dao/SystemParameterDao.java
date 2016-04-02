package com.bfsi.mfi.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.bfsi.mfi.entity.SystemParameter;
import com.bfsi.mfi.vo.SystemParameterVO;

public interface SystemParameterDao

{

	List<SystemParameter> getAllParams();

	void updateSystemParameter(List<SystemParameterVO> systemParameterlist);

	SystemParameter getParameterTypeForValidation(String id);

	List<SystemParameter> get();

	String getSelectAllQuery();

	RowMapper<SystemParameter> getRowMapper();

	String getUpdateQuery();

	String getSelectByPkQuery();

	int getIntParamValue(String paramMaxInvalidLoginAttempts);
	public void updateSystemParameterFor(String p_name,String p_value);
	
	public String getParamValue(String paramName);

	String getCheckedinUser();

	

}