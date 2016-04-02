package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.CashTxnCodeDao;
import com.bfsi.mfi.dao.MaintenanceDao;
import com.bfsi.mfi.entity.CashTxnCode;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CashTxnCodeService;
import com.bfsi.mfi.vo.CashTxnCodeVO;


@Service(value = "cashTxnCodeService")
public class CashTxnCodeServiceImpl extends
MaintenanceServiceImpl<CashTxnCodeVO, CashTxnCode> implements CashTxnCodeService {
	@Autowired
	private CashTxnCodeDao cashTxnCodeDao;

	@Override
	public List<CashTxnCodeVO> getCashTxnCode() throws ServiceException {
		List<CashTxnCode> cashTxnCodeList = new ArrayList<CashTxnCode>();
		List<CashTxnCodeVO> cashTxnCodeVoList = new ArrayList<CashTxnCodeVO>();
		try {
			cashTxnCodeList = cashTxnCodeDao.getCashTxnCode();
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while getting list of cashTxnCode: MFI10001", e);
		}
		if (!cashTxnCodeList.isEmpty()) {
			for (CashTxnCode cbsTxnCode : cashTxnCodeList) {
				CashTxnCodeVO cbsTxnCodeVo = getValueObject(cbsTxnCode);
				cashTxnCodeVoList.add(cbsTxnCodeVo);
			}
		}
		return cashTxnCodeVoList;
	}

	@Override
	protected <T extends MaintenanceDao<CashTxnCode>> T getMaintenanceDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected CashTxnCode getEntity(CashTxnCodeVO vo) {
		// TODO Auto-generated method stub
		return vo.getEntity();
	}

	@Override
	protected CashTxnCodeVO getValueObject(CashTxnCode entity) {
		// TODO Auto-generated method stub
		CashTxnCodeVO cashTxnCodeVO = new CashTxnCodeVO(entity);
		return cashTxnCodeVO;
	}

	
}
