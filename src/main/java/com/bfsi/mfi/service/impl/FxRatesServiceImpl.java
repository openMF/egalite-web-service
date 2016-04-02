package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.CBSFxRatesDao;
import com.bfsi.mfi.entity.CBSFxRates;
import com.bfsi.mfi.entity.Device;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.FxRatesService;
import com.bfsi.mfi.vo.CBSFxRatesVO;
import com.bfsi.mfi.vo.DeviceVO;


@Service(value = "fxRatesService")
public class FxRatesServiceImpl  extends MaintenanceServiceImpl<CBSFxRatesVO, CBSFxRates>
implements FxRatesService{

	@Autowired
	private CBSFxRatesDao cbsFxRatesDao;
	
	
	protected CBSFxRates getEntity(CBSFxRatesVO vo) {
		return vo.getEntity();
	}

	@Override
	protected CBSFxRatesVO getValueObject(CBSFxRates entity) {
		CBSFxRatesVO cbsFxRatesVO = new CBSFxRatesVO(entity);
		return cbsFxRatesVO;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected CBSFxRatesDao getMaintenanceDao() {
		return cbsFxRatesDao;
	}
	
	/*@Override
	public double	getMidRate(String ccy1,String ccy2) throws ServiceException {
		try{
			return cbsFxRatesDao.getMidRate(ccy1,ccy2);
		}catch(DataAccessException e){
			throw new ServiceException("Error while checking availability of Unique Id:", e);
		}
	}*/
	
	@Override
	public CBSFxRatesVO getRates(String ccy1,String ccy2) throws ServiceException {
		try{
			return getValueObject(cbsFxRatesDao.getRates(ccy1,ccy2));
		}catch(DataAccessException e){
			throw new ServiceException("Error while checking availability of Unique Id:", e);
		}
		
	}
	@Override
	public List<CBSFxRatesVO> getCcy1Rates() throws ServiceException
	{
		
		List<CBSFxRates> cbsFxRates = cbsFxRatesDao.getCcy1Rates();
		if(cbsFxRates != null){
			List<CBSFxRatesVO> cbsFxRatesvo = new ArrayList<CBSFxRatesVO>(cbsFxRates.size());
			for(CBSFxRates lov : cbsFxRates)
			   {
				CBSFxRatesVO cbsVO = new CBSFxRatesVO();
				BeanUtils.copyProperties(lov, cbsVO);
				cbsFxRatesvo.add(cbsVO);
			   }
			return cbsFxRatesvo;
		}
		 else {
				return new ArrayList<CBSFxRatesVO>();
			}
	}
	
	@Override
	public List<CBSFxRatesVO> getCcy2Rates() throws ServiceException
	{

		
		List<CBSFxRates> cbsFxRates = cbsFxRatesDao.getCcy2Rates();
		if(cbsFxRates != null){
			List<CBSFxRatesVO> cbsFxRatesvo = new ArrayList<CBSFxRatesVO>(cbsFxRates.size());
			for(CBSFxRates lov:cbsFxRates)
			   {
				CBSFxRatesVO cbsVO = new CBSFxRatesVO();
				BeanUtils.copyProperties(lov, cbsVO);
				cbsFxRatesvo.add(cbsVO);
			   }
			return cbsFxRatesvo;
		}
		 else {
				return new ArrayList<CBSFxRatesVO>();
			}
	
	}

	
}
