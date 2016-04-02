package com.bfsi.mfi.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.ManualAgendaSettleDao;
import com.bfsi.mfi.entity.ManualAgendaSettle;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ManualAgendaSettleService;
import com.bfsi.mfi.vo.ManualAgendaSettleVO;


@Service(value = "manualAgendaSettleService")
public class ManualAgendaSettleServiceImpl extends MaintenanceServiceImpl<ManualAgendaSettleVO, ManualAgendaSettle>
implements ManualAgendaSettleService{

	@Autowired
	private ManualAgendaSettleDao manualAgendaSettleDao;
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected ManualAgendaSettleDao getMaintenanceDao() {
		return manualAgendaSettleDao;
	}

	@Override
	protected ManualAgendaSettle getEntity(ManualAgendaSettleVO vo) {
		return vo.getEntity();
	}

	@Override
	protected ManualAgendaSettleVO getValueObject(ManualAgendaSettle entity) {
		ManualAgendaSettleVO manualAgendaSettleVO = new ManualAgendaSettleVO(entity);
		return manualAgendaSettleVO;
	}

	@Override
	public String getAutoAgedaId() throws ServiceException{
		String agendaid;
		try {
			
			agendaid = manualAgendaSettleDao.getAutoAgedaId();
			return agendaid;
			
		} catch (DataAccessException e) {
			throw new ServiceException("Error while generating the Automatic Agenda Id: ", e);
		}
	}
	
	@Override
	public ManualAgendaSettleVO create(ManualAgendaSettleVO vo) throws ServiceException {
		//String tempId=vo.getRecId();//
		//String tempAgendaId=vo.getId();//
		
		//vo.setId(tempId);//id
		//vo.setAgendaId(tempAgendaId);// agendaId
		vo.setIsActive("A");
		
	
		vo.setInitByUserId(getLoggedInUserId());
	    /*EGA-MN15-000008 For Business Date Start*/
		Date date = manualAgendaSettleDao.getBusinessDateForManualAgendaSettle();
		System.out.println("Manual Agenda Settled Date="+date);
		
		vo.setInitDateTime(date);
		/*EGA-MN15-000008 For Business Date End*/
		
		/*Calendar cal = Calendar.getInstance();
		vo.setInitDateTime(cal.getTime());*/
		return super.create(vo);
	}
	
}
