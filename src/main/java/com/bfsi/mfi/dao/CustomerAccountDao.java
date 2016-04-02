package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.CustomerAccountDetails;
import com.bfsi.mfi.entity.CustomerAccountServiceRequest;


/**
 * 
 * @author Vishal
 *
 */
public interface CustomerAccountDao {
	public List<CustomerAccountDetails> getCustomerAccount(CustomerAccountServiceRequest p_request);

}
