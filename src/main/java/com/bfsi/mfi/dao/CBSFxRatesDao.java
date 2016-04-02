package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.CBSFxRates;

public interface CBSFxRatesDao extends MaintenanceDao<CBSFxRates>{

	//double getMidRate(String ccy1,String ccy2);

	CBSFxRates getRates(String ccy1,String ccy2);
	public List<CBSFxRates> getCcy2Rates();
	public List<CBSFxRates> getCcy1Rates();
	

}
