package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.CustomerBiometricDao;
import com.bfsi.mfi.entity.CustomerBiometricServiceRequest;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CustomerBiometricService;
import com.bfsi.mfi.vo.CustomerBiometricInfoVO;

/**
 * 
 * @author Vishal
 *
 */
@Service(value = "customerBiometricService")
public class CustomerBiometricServiceImpl implements CustomerBiometricService {
	
	@Autowired
	private CustomerBiometricDao customerBiometricDao;

	@Override
	public ServiceResponse uploadCustomerBiometricDetails(
			CustomerBiometricServiceRequest p_custBioReq) {
		try{
			for(CustomerBiometricInfoVO l_custBioVo:p_custBioReq.getCustBioVo()){
				customerBiometricDao.submitCustBiometricInfo(l_custBioVo.getEntity());			
			}
		}
		catch(DataAccessException e){
			throw new ServiceException("Data Access exception while uploading biometric details",e);
		}
		ServiceResponse l_res=new ServiceResponse();
		l_res.setStatus(true);
		return l_res;		
	}

}
