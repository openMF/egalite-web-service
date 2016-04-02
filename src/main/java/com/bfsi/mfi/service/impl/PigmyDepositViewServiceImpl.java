package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.PigmyDepositDao;
import com.bfsi.mfi.entity.PigmyView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.PigmyDepositViewService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.PigmyViewVO;


@Service(value = "pigmyDepositViewService")
public class PigmyDepositViewServiceImpl extends MaintenanceServiceImpl<PigmyViewVO, PigmyView>
implements PigmyDepositViewService{
 
	@Autowired
	private PigmyDepositDao pigmyDepositDao;	
	
	public PigmyDepositDao getPigmyDepositDao() {
		return pigmyDepositDao;
	}

	public void setPigmyDepositDao(PigmyDepositDao pigmyDepositDao) {
		this.pigmyDepositDao = pigmyDepositDao;
	}
    
	@SuppressWarnings("unchecked")
	@Override
	protected PigmyDepositDao getMaintenanceDao() {
		return pigmyDepositDao;
	}

	@Override
	protected PigmyView getEntity(PigmyViewVO vo) {
		return vo.getEntity();
	}

	@Override
	protected PigmyViewVO getValueObject(PigmyView entity) {
		PigmyViewVO pigmyViewVO = new PigmyViewVO(entity);
		return pigmyViewVO;
	}

	
	@Override
	public PigmyViewVO getDepositView(String id) {
		PigmyView entities = null;
		PigmyViewVO vos = null;
		
		try {
		    entities = getMaintenanceDao().getDepositView(id);
			if (entities == null) {
				return new PigmyViewVO();
			}
            vos = getValueObject(entities);
			LoggerUtil.ibsJobDebug("Calling DAO  for getting loans details view:"+id );
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while get details view :  ", e);
		}
		return vos;
	}
	
}
