package com.bfsi.mfi.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.IbsResetAgendaDao;
import com.bfsi.mfi.entity.IbsResetAgenda;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.IbsResetAgendaService;
import com.bfsi.mfi.vo.IbsResetAgendaVO;

@Service(value = "ibsResetAgendaService")
public class IbsResetAgendaServiceImpl extends MaintenanceServiceImpl<IbsResetAgendaVO, IbsResetAgenda> implements
		IbsResetAgendaService {

	@Autowired
	private IbsResetAgendaDao ibsResetAgendaDao;

	@SuppressWarnings("unchecked")
	@Override
	protected IbsResetAgendaDao getMaintenanceDao() {
		return ibsResetAgendaDao;
	}

	@Override
	protected IbsResetAgenda getEntity(IbsResetAgendaVO vo) {
		return vo.getEntity();
	}

	@Override
	protected IbsResetAgendaVO getValueObject(IbsResetAgenda entity) {
		IbsResetAgendaVO ibsResetAgendaVO = new IbsResetAgendaVO(entity);
		return ibsResetAgendaVO;
	}

	@Override
	public String getAutoGenCode() throws ServiceException {
		String autoGenId;
		try {
			autoGenId = ibsResetAgendaDao.getAutoGenId();
			return autoGenId;

		} catch (DataAccessException e) {
			throw new ServiceException("Error while generating the Automatic IbsResetAgenda  Id: ", e);
		}
	}

	@Override
	public IbsResetAgendaVO create(IbsResetAgendaVO vo) throws ServiceException {
		vo.setInitByUserId(getLoggedInUserId());
		//Calendar cal = Calendar.getInstance();
		Date date = ibsResetAgendaDao.getBusinessDateForReset();
		
		
	
		vo.setResetInitDateTime(date);
	
		return super.create(vo);
	}

	@Override
	public IbsResetAgendaVO getModify(String id) throws ServiceException {
		try {
			IbsResetAgenda entity = ibsResetAgendaDao.getModify(id);
			return getValueObject(entity);
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while getting  object: " + this.getClass().getName()
					+ " with id: " + id, e);
		}
	}

	// For Delete Operation
	@Override
	public String deleteAgenda(String id) throws ServiceException {
		String success;
		try {
			success = ibsResetAgendaDao.deleteAgenda(id);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while deleting Agency: ", e);
		}
		return success;
	}

	@Override
	public IbsResetAgendaVO update(IbsResetAgendaVO vo) throws ServiceException {
		vo.setAuthStatus("U");
		vo.setInitByUserId(getLoggedInUserId());// modify by
		/*Calendar cal = Calendar.getInstance();
		vo.setResetInitDateTime(cal.getTime()); // at time.*/
		Date date = ibsResetAgendaDao.getBusinessDateForReset();
		vo.setResetInitDateTime(date);
		return super.update(vo);
	}

	@Override
	public IbsResetAgendaVO authorize(IbsResetAgendaVO vo) throws ServiceException {
		vo.setVerifyByUserId(getLoggedInUserId());// modify by
		/*Calendar cal = Calendar.getInstance();
		vo.setResetAuthDateTime(cal.getTime()); // at time.	*/
		Date date = ibsResetAgendaDao.getBusinessDateForReset();
		vo.setResetAuthDateTime(date);
		return super.authorize(vo);
	}

	@Override
	public Date getBusinessDateForReset() {
		Date date = new Date();
		try {
			date = ibsResetAgendaDao.getBusinessDateForReset();
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while getting  object: " + this.getClass().getName()
					+ " with id: " + date, e);
		}
		return date;
	}
}
