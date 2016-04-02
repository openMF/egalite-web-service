package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.FunctionMbsDao;
import com.bfsi.mfi.dao.jdbc.FunctionJdbcDao;
import com.bfsi.mfi.entity.FunctionMbs;
import com.bfsi.mfi.entity.User;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.FunctionMbsService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.FunctionMbsVO;
import com.bfsi.mfi.vo.UserVO;

@Service(value = "functionMbsService")
@Transactional(rollbackFor = { ServiceException.class })
public class FunctionMbsServiceImpl implements FunctionMbsService {

	@Autowired
	private FunctionMbsDao functionMbsDao;
	
	private FunctionJdbcDao funJdbcDao;
	protected FunctionJdbcDao getFunJdbcDao() {
		return funJdbcDao;
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
	
	@Override
	public List<FunctionMbsVO> getMbsFunction() {
		List<FunctionMbs> user = functionMbsDao.getMbsFunction();
		if (user != null) {
			List<FunctionMbsVO> userVOs = new ArrayList<FunctionMbsVO>(user.size());
			for (FunctionMbs lov : user) {
				FunctionMbsVO userVO = new FunctionMbsVO();
				BeanUtils.copyProperties(lov, userVO);
				userVOs.add(userVO);
			}
			return userVOs;
		} else {
			return new ArrayList<FunctionMbsVO>();
		}
	}
}
