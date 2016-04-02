package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.CBSFxRates;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.CBSFxRatesVO;

public interface FxRatesService extends MaintenanceService<CBSFxRatesVO, CBSFxRates>{

//double	getMidRate(String ccy1,String ccy2) throws ServiceException;

CBSFxRatesVO getRates(String ccy1,String ccy2) throws ServiceException;
List<CBSFxRatesVO> getCcy1Rates() throws ServiceException;
List<CBSFxRatesVO> getCcy2Rates() throws ServiceException;

}
