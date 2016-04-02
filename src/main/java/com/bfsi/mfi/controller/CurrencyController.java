package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.bfsi.mfi.entity.Currency;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CurrencyService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.CurrencyVO;

@ManagedBean(name = "currencyController")

public class CurrencyController extends MaintenanceController<CurrencyVO, Currency> {

	@ManagedProperty(value = "#{currencyService}")
	private CurrencyService currencyService;
	private CurrencyVO currency = new CurrencyVO();
	
	

	public CurrencyService getCurrencyService() {
		return currencyService;
	}


	public void setCurrencyService(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}


	public CurrencyVO getCurrency() {
		return currency;
	}


	public void setCurrency(CurrencyVO currency) {
		this.currency = currency;
	}


	public void loadCurrency() {
		CurrencyVO currencyVO = new CurrencyVO();
		currencyVO.setCurrencyCode(currency.getCurrencyCode());
		try {
			this.currency = currencyService.get(currency.getCurrencyCode());
			LoggerUtil.ibsJobDebug("Currency Code not Available: MFI00602");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while loading Currency: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {

			LoggerUtil.ibsJobError(
					"Unhandled exception while loading Currency: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
	}

	@Override
	protected CurrencyService getMaintenanceService() {

		return currencyService;
	}

	@Override
	public CurrencyVO getMaintenanceVO() {
		return currency;
	}
	
	
}