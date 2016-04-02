package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.ReqDpPrepayDao;
import com.bfsi.mfi.entity.MbsReqDpPrepayView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ReqDpPrepayService;
import com.bfsi.mfi.vo.MbsReqDpPrepayViewVO;

@Service(value = "reqDpPrepayService")
@Transactional(rollbackFor = { ServiceException.class })
public class ReqDpPrepayServiceImpl extends MaintenanceServiceImpl<MbsReqDpPrepayViewVO, MbsReqDpPrepayView>
implements ReqDpPrepayService {
	
	
	@Autowired
	private ReqDpPrepayDao reqDpPrepayDao ;

	@SuppressWarnings("unchecked")
	@Override
	protected ReqDpPrepayDao getMaintenanceDao() {
		return reqDpPrepayDao;
	}
	
	public void setReqDpPrepayDao(ReqDpPrepayDao reqDpPrepayDao) {
		this.reqDpPrepayDao = reqDpPrepayDao;
	}

	@Override
	protected MbsReqDpPrepayView getEntity(MbsReqDpPrepayViewVO vo) {
		return vo.getEntity();
	}

	@Override
	protected MbsReqDpPrepayViewVO getValueObject(MbsReqDpPrepayView entity) {
		MbsReqDpPrepayViewVO reqDpPrepayViewVO = new MbsReqDpPrepayViewVO(entity);
		return reqDpPrepayViewVO;
	}

}
