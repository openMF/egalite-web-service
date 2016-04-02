package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.LoanPrePaymentDao;
import com.bfsi.mfi.entity.MfiMbsTxnLnprepayV;
import com.bfsi.mfi.service.LoanPrePaymentService;
import com.bfsi.mfi.vo.MfiMbsTxnLnprepayVO;



@Service(value = "loanPrePaymentService")
public class LoanPrePaymentServiceImpl extends MaintenanceServiceImpl<MfiMbsTxnLnprepayVO,MfiMbsTxnLnprepayV> implements LoanPrePaymentService{
	
	@Autowired
	private LoanPrePaymentDao loanPrePaymentDao;
	
	@Override
	@SuppressWarnings("unchecked")
	public LoanPrePaymentDao getMaintenanceDao() {
		return loanPrePaymentDao;
	}
	
	public void setLoanPrePaymentDao(LoanPrePaymentDao loanPrePaymentDao) {
		this.loanPrePaymentDao = loanPrePaymentDao;
	}
	
	@Override
	protected MfiMbsTxnLnprepayV getEntity(MfiMbsTxnLnprepayVO vo) {
		return vo.getEntity();
	}

	@Override
	protected MfiMbsTxnLnprepayVO getValueObject(MfiMbsTxnLnprepayV entity) {
		MfiMbsTxnLnprepayVO vo = new MfiMbsTxnLnprepayVO(entity);
		return vo;
	}
}
