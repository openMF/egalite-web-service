package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.SystemParameterDao;
import com.bfsi.mfi.entity.SystemParameter;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.SystemParameterService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.SystemParameterVO;

@Service(value = "systemParameterService")
@Transactional(rollbackFor = { ServiceException.class })
public class SystemParameterServiceImpl

implements SystemParameterService {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SystemParameterDao systemParameterDao;

	public SystemParameterDao getSystemParameterDao() {

		return systemParameterDao;
	}

	@Override
	public Map<String, String> getParamsValue() throws ServiceException {
		Map<String, String> paramsValue = new HashMap<String, String>();
		try {
			LoggerUtil
					.ibsJobDebug("Calling DAO  for getting system Parameter Values: ");
			List<SystemParameter> sysParameter = getSystemParameterDao()
					.getAllParams();
			if (!sysParameter.isEmpty()) {
				for (int i = 0; i < sysParameter.size(); i++) {
					paramsValue.put(sysParameter.get(i).getParamName(),
							sysParameter.get(i).getParamValue());
				}
			}
		} catch (DataAccessException e) {

			throw new ServiceException(
					"DataAccessException while getting system parameter values: ",
					e);
		}

		return paramsValue;
	}

	public void updateSystemParam(List<SystemParameterVO> systemParameterlist)
			throws ServiceException {

		if (systemParameterlist != null) {
			try {
				LoggerUtil
						.ibsJobDebug("Calling DAO  for updating system Parameter Values: ");
				systemParameterDao.updateSystemParameter(systemParameterlist);
			} catch (DataAccessException e) {

				throw new ServiceException(
						"DataAccessException while updating system parameter values: ",
						e);
			}

		}

	}

	@Override
	public SystemParameterVO getSystemParamForValidation(String id)
			throws ServiceException {
		SystemParameterVO systemVO = new SystemParameterVO();
		try {
			LoggerUtil
					.ibsJobDebug("Calling DAO  for validating system Parameter Values: "
							+ id);
			SystemParameter systemParam = systemParameterDao
					.getParameterTypeForValidation(id);
			BeanUtils.copyProperties(systemParam, systemVO);
			return systemVO;
		} catch (DataAccessException e) {

			throw new ServiceException(
					"DataAccessException while getting SystemPosition: " + id,
					e);
		}
	}

	public SystemParameterVO getValueObject(SystemParameter entity) {

		SystemParameterVO systemvo = new SystemParameterVO();
		BeanUtils.copyProperties(entity, systemvo);
		return systemvo;
	}

	public List<SystemParameterVO> get() throws ServiceException {
		List<SystemParameter> entities = null;
		try {
			LoggerUtil
					.ibsJobDebug("Calling DAO  for getting list of SystemParameter: ");
			entities = getSystemParameterDao().get();
		} catch (DataAccessException e) {

			throw new ServiceException(
					"DataAccessException while getting list of SystemParameter: ",
					e);

		}

		if (entities == null) {
			return new ArrayList<SystemParameterVO>();
		}

		List<SystemParameterVO> vos = new ArrayList<SystemParameterVO>(
				entities.size());
		for (SystemParameter entity : entities) {
			SystemParameterVO vo = getValueObject(entity);
			vos.add(vo);
		}

		return vos;
	}

	@Override
	public String getParamValue(String paramName) {

		try {
			return systemParameterDao.getParamValue(paramName);
		} catch (DataAccessException e) {
			throw new ServiceException(
					"Data Acccess exception while gettinf sys param:: "
							+ paramName, e);
		}

	}

	@Override
	public void updateSystemParameterFor(String p_name, String p_value) {
		
		try {
			systemParameterDao.updateSystemParameterFor(p_name, p_value);
		} catch (DataAccessException e) {
			throw new ServiceException("Data Access exception while updating system param: "+p_name +" value: "+p_value);
		}
		
	}
	
	@Override
	public String getCheckedinUser() throws ServiceException{
		try {
			return systemParameterDao.getCheckedinUser();
		} catch (DataAccessException e) {
			throw new ServiceException("Data Access exception while getting system param for checkedin user: ");
		}
		
	}

}
