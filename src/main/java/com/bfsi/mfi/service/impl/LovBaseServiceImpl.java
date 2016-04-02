package com.bfsi.mfi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.LovBaseDao;
import com.bfsi.mfi.entity.LovBase;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LovBaseService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.LovBaseVO;

@Service(value = "lovBaseService")
public class LovBaseServiceImpl extends MaintenanceServiceImpl<LovBaseVO, LovBase>
         implements LovBaseService  {

	  @Autowired
      private LovBaseDao lovBaseDao;
	
	@Override
	public List<LovBase> getLovIds() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected LovBaseDao getMaintenanceDao() {
		return lovBaseDao;
	}

	@Override
	protected LovBase getEntity(LovBaseVO vo) {
		return vo.getEntity();
	}

	@Override
	protected LovBaseVO getValueObject(LovBase entity) {
		LovBaseVO vo = new LovBaseVO(entity);
		return vo;
	}

	
	@Override
	public boolean isLovIdAvailable(String id) throws ServiceException {
		try {
			return lovBaseDao.isLovIdAvailable(id);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while checking availability of Unique Id:", e);
		}
	}
	
	@Override
	public String deleteBaseLov(String id) throws ServiceException{
		String success;
		try {
			success= lovBaseDao.deleteBaseLov(id);
			LoggerUtil.ibsJobDebug("Calling DAO for delete lov : "+id);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while deleting lov: "+id, e);
		}
		return success;
		
	}
	
	
	@Override
	public boolean isLovStatustoInactive(String id) throws ServiceException {
		try {
			return lovBaseDao.isLovStatustoInactive(id);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while checking availability of Agency Status:", e);
		}
	}
}
