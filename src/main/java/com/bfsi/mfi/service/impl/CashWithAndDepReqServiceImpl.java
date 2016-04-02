package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.CashWithAndDepreqDao;
import com.bfsi.mfi.entity.MbsReqReceiverView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CashWithAndDepReqService;
import com.bfsi.mfi.vo.MbsReqReceiverViewVO;

@Service(value = "cashWithAndDepReqService")
@Transactional(rollbackFor = { ServiceException.class })
public class CashWithAndDepReqServiceImpl extends
		MaintenanceServiceImpl<MbsReqReceiverViewVO, MbsReqReceiverView>
		implements CashWithAndDepReqService {

	@Autowired
	private CashWithAndDepreqDao cashWithAndDepreqDao;

	@SuppressWarnings("unchecked")
	@Override
	protected CashWithAndDepreqDao getMaintenanceDao() {
		// TODO Auto-generated method stub
		return cashWithAndDepreqDao;
	}

	public void setCashWithAndDepreqDao(
			CashWithAndDepreqDao cashWithAndDepreqDao) {
		this.cashWithAndDepreqDao = cashWithAndDepreqDao;
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
