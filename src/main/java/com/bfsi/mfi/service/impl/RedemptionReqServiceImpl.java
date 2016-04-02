package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.RedemptionReqDao;
import com.bfsi.mfi.entity.MbsReqDpRedemptionView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.RedemptionReqService;
import com.bfsi.mfi.vo.MbsReqDpRedemptionViewVO;

@Service(value = "redemptionReqService")
@Transactional(rollbackFor = { ServiceException.class })
public class RedemptionReqServiceImpl extends MaintenanceServiceImpl<MbsReqDpRedemptionViewVO, MbsReqDpRedemptionView>
                       implements RedemptionReqService {

	
	@Autowired
	private RedemptionReqDao redemptionReqDao ;
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected RedemptionReqDao getMaintenanceDao() {
		return redemptionReqDao;
	}
	
	public void setRedemptionReqDao(RedemptionReqDao redemptionReqDao) {
		this.redemptionReqDao = redemptionReqDao;
	}

	@Override
	protected MbsReqDpRedemptionView getEntity(MbsReqDpRedemptionViewVO vo) {
		return vo.getEntity();
	}

	@Override
	protected MbsReqDpRedemptionViewVO getValueObject(MbsReqDpRedemptionView entity) {
		MbsReqDpRedemptionViewVO depositRequestVO = new MbsReqDpRedemptionViewVO(entity);
		return depositRequestVO;
	}

}
