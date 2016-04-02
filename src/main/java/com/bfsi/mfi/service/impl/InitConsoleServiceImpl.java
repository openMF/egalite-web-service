package com.bfsi.mfi.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.InitConsoleDao;
import com.bfsi.mfi.entity.EgaCharter;
import com.bfsi.mfi.entity.InitConsole;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.InitConsoleService;
import com.bfsi.mfi.vo.EgaCharterVO;
import com.bfsi.mfi.vo.InitConsoleVO;

@Service(value = "initConsoleService")
public class InitConsoleServiceImpl extends MaintenanceServiceImpl<InitConsoleVO, InitConsole>
		implements InitConsoleService {

	@Autowired
	private InitConsoleDao initConsoleDao;

	@SuppressWarnings("unchecked")
	@Override
	protected InitConsoleDao getMaintenanceDao() {
		return initConsoleDao;
	}

	@Override
	protected InitConsole getEntity(InitConsoleVO vo) {
		return vo.getEntity();
	}

	@Override
	protected InitConsoleVO getValueObject(InitConsole entity) {
		InitConsoleVO consoleVO =new InitConsoleVO(entity);
		return consoleVO;
	}

	public InitConsoleDao getConsoleDao() {
		return initConsoleDao;
	}

	public void setConsoleDao(InitConsoleDao consoleDao) {
		this.initConsoleDao = consoleDao;
	}

	@Override
	public String cbcConsoleText(String id) {
		String text = null;
		try {
			text = initConsoleDao.cbcConsoleText(id);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while fetching MacId for Agent = "+ id , e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception  while fetching MacId for Agent = "+ id , e);
        }
		return text;
	}

	@Override
	public Map<String,String> refreshJobStatus() {
		Map<String,String> jobStatusMap = new HashMap<String,String>();
		try {
			jobStatusMap = initConsoleDao.getJobStatus();
			
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while refreshJobStatus" , e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception  while refreshJobStatus" , e);
        }
		return jobStatusMap;
	}
	
	@Override
	public EgaCharterVO getRunHasStatus(String charCode){
		EgaCharterVO runHash = new EgaCharterVO();
		EgaCharter entity = new EgaCharter();
		
		try {
			entity = initConsoleDao.getRunHasStatus(charCode);
			runHash=getValueObjectEga(entity);//converting entity to vo
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while refreshJobStatus" , e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception  while refreshJobStatus" , e);
        }
		return runHash;
	}
	
	protected EgaCharterVO getValueObjectEga(EgaCharter entity) {
		EgaCharterVO egaCharterVO =new EgaCharterVO(entity);
		return egaCharterVO;
	}
	
}
