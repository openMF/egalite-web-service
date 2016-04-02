package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.Currency;

public interface CurrencyDao extends MaintenanceDao<Currency> {

	List<Currency> getCurrencies();

	int getDecimal(String curencyCode);

}
