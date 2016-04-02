package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bfsi.mfi.dao.RepaymentTxnDao;
import com.bfsi.mfi.entity.RepaymentTxn;
import com.bfsi.mfi.service.RepaymentTxnService;
import com.bfsi.mfi.vo.RepaymentTxnVO;

@Service(value = "repaymentService")
public class RepaymentTxnServiceImpl extends MaintenanceServiceImpl<RepaymentTxnVO,RepaymentTxn> implements RepaymentTxnService {

	@Autowired
	private RepaymentTxnDao repaymentTxnDao;


	@SuppressWarnings("unchecked")
	public RepaymentTxnDao getMaintenanceDao() {
		return repaymentTxnDao;
	}

	public void setRepaymentTxnDao(RepaymentTxnDao repaymentTxnDao) {
		this.repaymentTxnDao = repaymentTxnDao;
	}

	@Override
	protected RepaymentTxn getEntity(RepaymentTxnVO vo) {
		return vo.getEntity();
	}

	@Override
	protected RepaymentTxnVO getValueObject(RepaymentTxn entity) {
		RepaymentTxnVO vo = new RepaymentTxnVO(entity);
		return vo;
	}
}
