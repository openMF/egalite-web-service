package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.CleanUpDao;
import com.bfsi.mfi.entity.CleanUp;
import com.bfsi.mfi.service.CleanUpService;
import com.bfsi.mfi.vo.CleanUpVO;

@Service(value = "cleanUpService")
public class CleanUpServiceImpl extends MaintenanceServiceImpl<CleanUpVO, CleanUp>
		implements CleanUpService {

	@Autowired
	private CleanUpDao cleanUpConsoleDao;

	@SuppressWarnings("unchecked")
	@Override
	protected CleanUpDao getMaintenanceDao() {
		return cleanUpConsoleDao;
	}

	@Override
	protected CleanUp getEntity(CleanUpVO vo) {
		return vo.getEntity();
	}

	@Override
	protected CleanUpVO getValueObject(CleanUp entity) {
		CleanUpVO consoleVO =new CleanUpVO(entity);
		return consoleVO;
	}

	public CleanUpDao getCleanUpConsoleDao() {
		return cleanUpConsoleDao;
	}

	public void setCleanUpConsoleDao(CleanUpDao cleanUpConsoleDao) {
		this.cleanUpConsoleDao = cleanUpConsoleDao;
	}

	
		
	
}
