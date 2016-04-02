package com.bfsi.mfi.service;


import com.bfsi.mfi.entity.CustomerAccountServiceRequest;
import com.bfsi.mfi.entity.CustomerAccountServiceResponse;

/**
 * 
 * @author Vishal
 *
 */
public interface CustomerAccountService {
	public CustomerAccountServiceResponse getCustomerAccount(
			CustomerAccountServiceRequest p_request);

}
