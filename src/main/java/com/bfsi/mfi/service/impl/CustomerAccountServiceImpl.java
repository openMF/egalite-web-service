package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.CustomerAccountDao;
import com.bfsi.mfi.entity.CustomerAccountDetails;
import com.bfsi.mfi.entity.CustomerAccountServiceRequest;
import com.bfsi.mfi.entity.CustomerAccountServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CustomerAccountService;
import com.bfsi.mfi.vo.CustomerAccountVO;

@Service(value = "customerAccountService")
public class CustomerAccountServiceImpl implements CustomerAccountService {
	
	@Autowired
	private CustomerAccountDao customerAccountDao;

	@Override
	public CustomerAccountServiceResponse getCustomerAccount(
			CustomerAccountServiceRequest p_request) {
		// TODO Auto-generated method stub
		CustomerAccountServiceResponse l_res = new CustomerAccountServiceResponse();	
		List<CustomerAccountDetails> l_custAccList= null;
		CustomerAccountVO l_custAccVo=null;
		List<CustomerAccountVO> l_custAccListVo=new ArrayList<CustomerAccountVO>();		
		if(p_request.getRcvCustAcc()==null)
			p_request.setRcvCustAcc(new ArrayList<String>());
		try{
			l_custAccList = customerAccountDao.getCustomerAccount(p_request);
			for(CustomerAccountDetails l_custAcc:l_custAccList){
				l_custAccVo=new CustomerAccountVO(l_custAcc);
				l_custAccListVo.add(l_custAccVo);
			}
			l_res.setCustomeAccList(l_custAccListVo);
			l_res.setStatus(true);
		}
		catch(DataAccessException e){
			throw new ServiceException("Data Access exception while getting customerAccount list",e);
		}
		return l_res;
	}		

}
