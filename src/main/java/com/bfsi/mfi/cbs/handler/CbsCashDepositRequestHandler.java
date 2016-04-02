package com.bfsi.mfi.cbs.handler;

import com.bfsi.mfi.cbs.request.CbsBaseRequest;
import com.bfsi.mfi.cbs.request.CbsCashDepositRequest;
import com.bfsi.mfi.entity.CashTransaction;
import com.bfsi.mfi.entity.ServiceResponse;


public class CbsCashDepositRequestHandler extends CbsServiceHandler<CashTransaction,ServiceResponse,CbsBaseRequest> {

	@Override
	public ServiceResponse processRequest(CashTransaction p_request) {
		
		return null;
	}

	@Override
	public CbsCashDepositRequest buildRequest(CashTransaction p_request) {
		
		return null;
	}

}
