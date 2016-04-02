package com.bfsi.mfi.cbs.adapter;

import com.bfsi.mfi.cbs.request.CbsBaseRequest;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.exception.ServiceException;

/**
 * 
 * @author Vishal
 *
 */
public interface CbsEnrollCustomerServiceAdapter<K extends CbsBaseRequest,V extends CbsBaseResponse> {
	public V processEnrollCustomer(K p_enrollCust) throws ServiceException;
	
}
