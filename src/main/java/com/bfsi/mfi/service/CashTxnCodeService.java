package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.CashTxnCode;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.CashTxnCodeVO;

public interface CashTxnCodeService extends
MaintenanceService<CashTxnCodeVO, CashTxnCode>{
	public List<CashTxnCodeVO> getCashTxnCode() throws ServiceException;
}
