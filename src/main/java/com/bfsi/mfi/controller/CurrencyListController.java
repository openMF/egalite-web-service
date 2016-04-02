package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.Currency;
import com.bfsi.mfi.service.CurrencyService;
import com.bfsi.mfi.service.ReadOnlyMaintenanceService;
import com.bfsi.mfi.vo.CurrencyVO;

@ManagedBean(name = "currencyListController")
@ViewScoped
public class CurrencyListController extends
	ReadOnlyMaintenanceListController<CurrencyVO, Currency> {
	@ManagedProperty(value = "#{currencyService}")
	private CurrencyService currencyService;
	
	public CurrencyService getCurrencyService() {
		return currencyService;
	}

	public void setCurrencyService(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	@Override
	protected ReadOnlyMaintenanceService<CurrencyVO, Currency> getReadOnlyMaintenanceService() {
		return currencyService;
	}

}
