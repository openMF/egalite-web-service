package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.Currency;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.CurrencyVO;

public interface CurrencyService extends
		MaintenanceService<CurrencyVO, Currency> {
	public List<CurrencyVO> getCurrency() throws ServiceException;

	public int getDecimal(String curencyCode) throws ServiceException;
}
