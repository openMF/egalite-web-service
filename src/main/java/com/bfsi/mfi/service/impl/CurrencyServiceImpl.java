package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.CurrencyDao;
import com.bfsi.mfi.entity.Currency;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CurrencyService;
import com.bfsi.mfi.vo.CurrencyVO;

@Service(value = "currencyService")
public class CurrencyServiceImpl extends
		MaintenanceServiceImpl<CurrencyVO, Currency> implements CurrencyService {

	//private static final String NEW_STATUS = "N";
	//private static final String MODIFIED_STATUS = "M";
	@Autowired
	private CurrencyDao currencyDao;

	@Override
	public CurrencyVO update(CurrencyVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Currency getEntity(CurrencyVO vo) {
		return vo.getEntity();
	}

	@Override
	protected CurrencyVO getValueObject(Currency entity) {
		CurrencyVO currencyVO = new CurrencyVO(entity);
		return currencyVO;

	}

	@Override
	public List<CurrencyVO> getCurrency() throws ServiceException {
		List<Currency> currencyies = new ArrayList<Currency>();
		List<CurrencyVO> currencyList = new ArrayList<CurrencyVO>();
		try {
			currencyies = currencyDao
					.getCurrencies();
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while getting list of Currencies: MFI10001", e);
		}
		if (!currencyies.isEmpty()) {
			for (Currency currency : currencyies) {
				CurrencyVO currencyVo = getValueObject(currency);
				currencyList.add(currencyVo);
			}
		}
		return currencyList;
	}

	
	public int getDecimal(String curencyCode) throws ServiceException{
		
		try{
			return  currencyDao.getDecimal(curencyCode);
		} catch (DataAccessException e) {
				throw new ServiceException("Error while getting no of decimal for this Currency: MFI10001", e);
		}
	
	}
	
/*	@Override
	protected <T extends MaintenanceDao<Currency>> T getMaintenanceDao() {
		// TODO Auto-generated method stub
		return null;
	}
*/
	
	@SuppressWarnings("unchecked")
	@Override
	protected CurrencyDao getMaintenanceDao() {
	return currencyDao;
	}

}
