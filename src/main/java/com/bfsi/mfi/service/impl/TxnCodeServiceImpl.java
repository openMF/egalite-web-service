package com.bfsi.mfi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.TransactionCodeDao;
import com.bfsi.mfi.entity.MfiMbsTxnReceiverV;
import com.bfsi.mfi.service.SmsConfigService;
import com.bfsi.mfi.service.TxnCodeService;
import com.bfsi.mfi.vo.MfiMbsTxnReceiverVO;

@Service(value = "txnCodeService")
public class TxnCodeServiceImpl extends MaintenanceServiceImpl<MfiMbsTxnReceiverVO , MfiMbsTxnReceiverV> implements TxnCodeService{
	@Autowired
	private TransactionCodeDao transactionCodeDao;


	@SuppressWarnings("unchecked")
	@Override
	protected TransactionCodeDao getMaintenanceDao() {
	
		return transactionCodeDao;
	}

	@Override
	protected MfiMbsTxnReceiverV getEntity(MfiMbsTxnReceiverVO vo) {
		MfiMbsTxnReceiverV userEntity = new MfiMbsTxnReceiverV();
		BeanUtils.copyProperties(vo, userEntity);
		return userEntity;
		
	}

	@Override
	protected MfiMbsTxnReceiverVO getValueObject(MfiMbsTxnReceiverV entity) {
		MfiMbsTxnReceiverVO currencyVO = new MfiMbsTxnReceiverVO();
		BeanUtils.copyProperties(entity, currencyVO);
		return currencyVO;
	}
}
