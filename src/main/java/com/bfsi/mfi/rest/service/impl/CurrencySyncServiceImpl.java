package com.bfsi.mfi.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.model.CurrencyDetail;
import com.bfsi.mfi.rest.model.CurrencyResponse;
import com.bfsi.mfi.rest.service.CurrencySyncService;
import com.bfsi.mfi.service.CurrencyService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CurrencyVO;

@Component("currencySyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/currency")
public class CurrencySyncServiceImpl implements CurrencySyncService {
	@Autowired
	private CurrencyService currencyService;

	public CurrencyService getCurrencyService() {
		return currencyService;
	}

	public void setCurrencyService(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	@Override
	@GET
	public CurrencyResponse getCurrencyList() {
		CurrencyResponse response = new CurrencyResponse();
		List<CurrencyVO> currencyList = new ArrayList<CurrencyVO>();
		List<CurrencyDetail> currencyDetails = new ArrayList<CurrencyDetail>();
		try {
			currencyList = currencyService.getCurrency();

		} catch (ServiceException e) {
			response.setMessageCode("MFI10001");						
			LoggerUtil.mbsJobError("ServiceException while get currency Details : MFI10001", e);
			return response;			
		}
		if(currencyList != null) {
			for (int i = 0; i < currencyList.size(); i++) {
				currencyDetails.add(new CurrencyDetail());
				BeanUtils.copyProperties(currencyList.get(i),
						currencyDetails.get(i));
			}
			if (!currencyDetails.isEmpty()) {
				response.setCurrencyDetail(currencyDetails);
				response.setStatus(true);
			} else {
				response.setStatus(true);
				response.setMessageCode("MFI00258");
				//response.setStatusText(Constants.CURRENCY_LIST_EMPTY);
			}
		} else {
			response.setMessageCode("MFI00255");	
			response.setStatus(false);
			LoggerUtil.mbsJobError("Currency Details is null : MFI00255");
			return response;
		}
		return response;
	}
}
