package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.LovDetailDao;
import com.bfsi.mfi.entity.LovDetail;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LovDetailService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.LovVO;
import com.bfsi.mfi.vo.RoleVO;


@Service(value = "lovDetailService")
public class LovDetailServiceImpl extends MaintenanceServiceImpl<LovVO, LovDetail>
implements LovDetailService {
	
    @Autowired
	private LovDetailDao lovDetailDao;

	@SuppressWarnings("unchecked")
	@Override
	protected LovDetailDao getMaintenanceDao() {
		return lovDetailDao;
	}

	@Override
	protected LovDetail getEntity(LovVO vo) {
		return vo.getEntity();
	}

	@Override
	protected LovVO getValueObject(LovDetail entity) {
		LovVO vo = new LovVO(entity);
		return vo;
	}

	
	public int getInterValue(String lovId){
		try{
			return lovDetailDao.getInterValue(lovId);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while generating the Automatic agency Code: ", e);
		}
		
	}
	
	// For ModifyLov Status
		@Override
		public boolean isLovStatustoInactive(String idd) throws ServiceException {
			try {
				return lovDetailDao.isLovStatustoInactive(idd);
			} catch (DataAccessException e) {
				throw new ServiceException("Error while checking availability of Lov Record Status:", e);
			}
		}
		
		
		
		
		public LovVO createInfo(LovVO lov) throws ServiceException {
			// generate id
			String autoLovId = getAutoLovId();
			lov.setId(autoLovId);

			// mark it as unauthorized
			lov.setAuthStatus("U");

			super.create(lov);

			return lov;
		}
		
	
		@Override
		public String getAutoLovId() throws ServiceException {

			String lov = null;
			try {
				lov = lovDetailDao.getAutoLovId();
				LoggerUtil.ibsJobDebug("Calling DAO for geting system generated roleId  :");
			} catch (DataAccessException e) {
				throw new ServiceException("Error while auto generated roleId :", e);
			}
			return lov;
		}
		
		
		// For Delete Operation
		@Override
		public String deleteUnAuthorized(String id) throws ServiceException {
			String success;
			try {
				success= lovDetailDao.deleteUnAuthorized(id);
			} catch (DataAccessException e) {
				throw new ServiceException("Error while deleting Lov Record: ", e);
			}
			return success;
		}
		
		
		
		public List<LovVO> getDispValue(String lovId) throws ServiceException {
			LoggerUtil.ibsJobDebug("Calling abstart get to get list of LOV records: "+this.getClass().getName());
			List<LovDetail> entities = null;
			try {
				entities = lovDetailDao.getDispValue(lovId);
			} catch (DataAccessException e) {
				throw new ServiceException("DataAccessException while getting list of records: "+this.getClass().getName(), e);
			}

			if (entities == null) {
				return new ArrayList<LovVO>();
			}

			List<LovVO> vos = new ArrayList<LovVO>(entities.size());
			for (LovDetail entity : entities) {
				LovVO vo = getValueObject(entity);
				vos.add(vo);
			}

			return vos;
		}
		
		
		
		
}
