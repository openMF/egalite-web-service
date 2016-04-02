package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.FunctionDao;
import com.bfsi.mfi.dao.jdbc.FunctionJdbcDao;
import com.bfsi.mfi.entity.Function;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.FunctionService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.FunctionVO;

@Service(value = "functionService")
@Transactional(rollbackFor = { ServiceException.class })
public class FunctionServiceImpl extends MaintenanceServiceImpl<FunctionVO, Function>
		implements FunctionService {

	@Autowired
	private FunctionDao functionDao;
	
	private FunctionJdbcDao funJdbcDao;
	protected FunctionJdbcDao getFunJdbcDao() {
		return funJdbcDao;
	}
	@Override
	protected FunctionDao getMaintenanceDao() {
		return functionDao;
	}

	@Override
	protected Function getEntity(FunctionVO vo) {
		return vo.getEntity();
	}

	@Override
	protected FunctionVO getValueObject(Function entity) {
		FunctionVO roleVO = new FunctionVO(entity);
		return roleVO;
	}

	@Override
	public FunctionVO update(FunctionVO vo) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<String> getDrop() throws ServiceException{
		
		List<String> entities = null;
		try{
	       entities =(List<String>) getFunJdbcDao().getDrop();
	       LoggerUtil.ibsJobDebug("Calling DAO  for drop functions : ");
		}
		catch(DataAccessException e){
			throw new ServiceException("DataAccessException while droping functions :", e);
		}
		if (entities == null) {
			return new ArrayList<String>();
		}

		List<String> vos = new ArrayList<String>(entities.size());
		for (String entity : entities) {
			String vo = entity;
			vos.add(vo);
		}

		return vos;
	}
}
