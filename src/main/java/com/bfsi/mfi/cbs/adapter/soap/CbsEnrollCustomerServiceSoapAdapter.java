package com.bfsi.mfi.cbs.adapter.soap;

import com.bfsi.mfi.cbs.adapter.CbsEnrollCustomerServiceAdapter;
import com.bfsi.mfi.cbs.request.CbsBaseRequest;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.exception.ServiceException;

/**
 * 
 * @author Vishal
 * 
 */
public class CbsEnrollCustomerServiceSoapAdapter implements
CbsEnrollCustomerServiceAdapter<CbsBaseRequest, CbsBaseResponse> {
	
	@Override
	public CbsBaseResponse processEnrollCustomer(CbsBaseRequest p_enrollCust)
			throws ServiceException {
		CbsBaseResponse l_res = new CbsBaseResponse();
		l_res.setStatus(true);
		l_res.setCbsResTxnRefNo("000");
		l_res.setResponseCode("SUCCESS");
		l_res.setResponseMessage("SUCCESS");
		
		return l_res;
	}


}
