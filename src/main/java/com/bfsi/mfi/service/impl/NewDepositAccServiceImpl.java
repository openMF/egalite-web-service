package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.NewDepositAccDao;
import com.bfsi.mfi.entity.MbsReqDpNewAcView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.NewDepositAccService;
import com.bfsi.mfi.vo.MbsReqDpNewAcViewVO;


@Service(value = "newDepositAccService")
@Transactional(rollbackFor = { ServiceException.class })
public class NewDepositAccServiceImpl extends MaintenanceServiceImpl<MbsReqDpNewAcViewVO, MbsReqDpNewAcView>implements NewDepositAccService {

	@Autowired
	private NewDepositAccDao newDepositAccDao;
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected NewDepositAccDao getMaintenanceDao() {
		return newDepositAccDao;
	}
	
	public void setNewDepositAccDao(NewDepositAccDao newDepositAccDao) {
		this.newDepositAccDao = newDepositAccDao;
	}
	
	@Override
	protected MbsReqDpNewAcView getEntity(MbsReqDpNewAcViewVO vo) {
		return vo.getEntity();
	}

	@Override
	protected MbsReqDpNewAcViewVO getValueObject(MbsReqDpNewAcView entity) {
		MbsReqDpNewAcViewVO newdepositRequestVO = new MbsReqDpNewAcViewVO(entity);
		return newdepositRequestVO;
	}

}
