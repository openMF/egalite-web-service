package com.bfsi.mfi.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.DepositeReqDao;
import com.bfsi.mfi.entity.MbsReqReceiverView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DepositeReqService;
import com.bfsi.mfi.vo.MbsReqReceiverViewVO;

@Service(value = "depositeReqService")
@Transactional(rollbackFor = { ServiceException.class })
public class DepositeReqServiceImpl extends MaintenanceServiceImpl<MbsReqReceiverViewVO, MbsReqReceiverView> implements DepositeReqService{


	@Autowired
	private DepositeReqDao depositeReqDao;

	

	
	@SuppressWarnings("unchecked")
	@Override
	protected DepositeReqDao getMaintenanceDao() {
		// TODO Auto-generated method stub
		return depositeReqDao;
	}
	
	public void setDepositeReqDao(DepositeReqDao depositeReqDao) {
		this.depositeReqDao = depositeReqDao;
	}
	
	@Override
	protected MbsReqReceiverView getEntity(MbsReqReceiverViewVO vo) {
		return vo.getEntity();
	}

	@Override
	protected MbsReqReceiverViewVO getValueObject(MbsReqReceiverView entity) {
		MbsReqReceiverViewVO depositRequestVO = new MbsReqReceiverViewVO(entity);
		return depositRequestVO;
	}

	

}
