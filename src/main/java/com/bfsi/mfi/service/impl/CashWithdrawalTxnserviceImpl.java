package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.CashWithdrawalDao;
import com.bfsi.mfi.entity.CashWithdrawal;
import com.bfsi.mfi.service.CashWithdrawalTxnservice;
import com.bfsi.mfi.vo.CashWithdrawalVO;

@Service(value = "cashWithdrawalTxnservice")
public class CashWithdrawalTxnserviceImpl extends MaintenanceServiceImpl<CashWithdrawalVO, CashWithdrawal> implements CashWithdrawalTxnservice{

	@Autowired
	private CashWithdrawalDao dao;

	@SuppressWarnings("unchecked")
	@Override
	public CashWithdrawalDao  getMaintenanceDao() {
		return dao;
	}
	
	public void setDao(CashWithdrawalDao dao) {
		this.dao = dao;
	}

	@Override
	protected CashWithdrawal getEntity(CashWithdrawalVO vo) {
		return vo.getEntity();
	}

	@Override
	protected CashWithdrawalVO getValueObject(CashWithdrawal entity) {
		CashWithdrawalVO cashVO = new CashWithdrawalVO(entity);
		return cashVO;
	}

}
