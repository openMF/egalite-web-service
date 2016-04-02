package com.bfsi.mfi.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.ModifyManualAgendaSettleDao;
import com.bfsi.mfi.entity.ModifyManualAgendaSettle;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ModifyManualAgendaSettleService;
import com.bfsi.mfi.vo.IbsResetAgendaVO;
import com.bfsi.mfi.vo.ModifyManualAgendaSettleVO;


@Service(value = "modifyManualAgendaSettleService")
public class ModifyManualAgendaSettleServiceImpl extends MaintenanceServiceImpl<ModifyManualAgendaSettleVO, ModifyManualAgendaSettle>
implements ModifyManualAgendaSettleService{

	@Autowired
	private ModifyManualAgendaSettleDao modifyManualAgendaSettleDao;
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected ModifyManualAgendaSettleDao getMaintenanceDao() {
		return modifyManualAgendaSettleDao;
	}

	@Override
	protected ModifyManualAgendaSettle getEntity(ModifyManualAgendaSettleVO vo) {
		return vo.getEntity();
	}

	@Override
	protected ModifyManualAgendaSettleVO getValueObject(ModifyManualAgendaSettle entity) {
		ModifyManualAgendaSettleVO modifyManualAgendaSettleVO = new ModifyManualAgendaSettleVO(entity);
		return modifyManualAgendaSettleVO;
	}

	/*@Override
	public ModifyManualAgendaSettleVO create(ModifyManualAgendaSettleVO vo) throws ServiceException {
		//String tempId=vo.getRecId();//
		//String tempAgendaId=vo.getId();//
		
		//vo.setId(tempId);//id
		//vo.setAgendaId(tempAgendaId);// agendaId
		vo.setIsActive("A");
		vo.setInitByUserId(getLoggedInUserId());
		Calendar cal = Calendar.getInstance();
		vo.setInitDateTime(cal.getTime());
		return super.create(vo);
	}*/
	
	
	
	 @Override
	 public ModifyManualAgendaSettleVO update(ModifyManualAgendaSettleVO vo) throws ServiceException {
		vo.setInitByUserId(getLoggedInUserId());
		Calendar cal = Calendar.getInstance();
		vo.setInitDateTime(cal.getTime());
		return super.update(vo);
	 }
	 
	 @Override
		public ModifyManualAgendaSettleVO authorize(ModifyManualAgendaSettleVO vo) throws ServiceException {	
			vo.setVerifyByUserId(getLoggedInUserId());// modify by
			Calendar cal = Calendar.getInstance();
			vo.setAuthDateTime(cal.getTime()); //at time.
			
			return super.authorize(vo);
		}
	 
}
