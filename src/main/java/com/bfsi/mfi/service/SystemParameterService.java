package com.bfsi.mfi.service;

import java.util.List;
import java.util.Map;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.SystemParameterVO;

public interface SystemParameterService

{
	public static final String PARAM_MAX_INVALID_LOGIN_ATTEMPTS = "NUMBERS OF INVALID LOGINS";
	public static final String NUMBER_OF_RETRY = "NUMBERS OF RETRY";

	Map<String, String> getParamsValue() throws ServiceException;

	void updateSystemParam(List<SystemParameterVO> systemParamVOs)
			throws ServiceException;

	public SystemParameterVO getSystemParamForValidation(String id)
			throws ServiceException;

	List<SystemParameterVO> get() throws ServiceException;
	public String getParamValue(String paramName);
	 public void updateSystemParameterFor(String p_name, String p_value);

	String getCheckedinUser() throws ServiceException;

}
