package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.CashDepositDao;
import com.bfsi.mfi.dao.RedemptionReqDao;
import com.bfsi.mfi.dao.jdbc.CashDepositJdbcDao;
import com.bfsi.mfi.entity.CashDeposit;
import com.bfsi.mfi.service.CashDepositTxnService;
import com.bfsi.mfi.vo.CashDepositVO;

@Service(value = "cashDepositTxnService")
public class CashDepositTxnserviceImpl extends MaintenanceServiceImpl<CashDepositVO, CashDeposit> implements CashDepositTxnService{
	
	@Autowired
	private CashDepositDao dao;
	
	@SuppressWarnings("unchecked")
	@Override
	public CashDepositDao  getMaintenanceDao() {
		return dao;
	}
	
	public void setDao(CashDepositDao dao) {
		this.dao = dao;
	}

	@Override
	protected CashDeposit getEntity(CashDepositVO vo) {
		return vo.getEntity();
	}

	@Override
	protected CashDepositVO getValueObject(CashDeposit entity) {
		CashDepositVO cashVO = new CashDepositVO(entity);
		return cashVO;
	}
}
