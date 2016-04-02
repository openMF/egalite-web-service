package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.ProcessCharterDao;
import com.bfsi.mfi.entity.ProcessCharter;
import com.bfsi.mfi.service.ProcessCharterService;
import com.bfsi.mfi.vo.ProcessCharterVO;

@Service(value = "processCharterService")
public class ProcessCharterServiceImpl extends MaintenanceServiceImpl<ProcessCharterVO, ProcessCharter>
		implements ProcessCharterService {

	@Autowired
	private ProcessCharterDao processCharterDao;

	@SuppressWarnings("unchecked")
	@Override
	protected ProcessCharterDao getMaintenanceDao() {
		return processCharterDao;
	}

	@Override
	protected ProcessCharter getEntity(ProcessCharterVO vo) {
		return vo.getEntity();
	}

	@Override
	protected ProcessCharterVO getValueObject(ProcessCharter entity) {
		ProcessCharterVO consoleVO =new ProcessCharterVO(entity);
		return consoleVO;
	}
		
	
}
