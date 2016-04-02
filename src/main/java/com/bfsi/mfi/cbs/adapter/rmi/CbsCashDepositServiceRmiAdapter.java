package com.bfsi.mfi.cbs.adapter.rmi;


import org.springframework.beans.BeanUtils;

import com.bfsi.mfi.cbs.adapter.CbsTransactionServiceAdapter;
import com.bfsi.mfi.cbs.request.CbsCashDepositRequest;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.exception.CbsServiceException;
import com.bfsi.mfi.util.LoggerUtil;
import com.cbs.bean.CbsBaseTransResponse;
import com.cbs.bean.CbsCashDepositTranRequest;
import com.cbs.rmi.impl.CbsTranInterfaceImpl;
import com.cbs.service.CbsTranInterface;

/**
 * 
 * @author Shabu
 *
 */

public class CbsCashDepositServiceRmiAdapter implements CbsTransactionServiceAdapter<CbsCashDepositRequest, CbsBaseResponse> {
	
	
	@Override
	public CbsBaseResponse performTransaction(CbsCashDepositRequest p_tranRequest)
			throws CbsServiceException {
		LoggerUtil.cbsJobDebug("Inside RMI for "+p_tranRequest.getClass().getName());
		CbsBaseResponse l_res = new CbsBaseResponse();
		CbsCashDepositTranRequest l_deposit = new CbsCashDepositTranRequest();
		/*
		l_res.setCbsResStat("P");
		l_res.setCbsResTxnRefNo("112323");
		l_res.setResponseCode("0");
		l_res.setResponseMessage("DEPOSIT SUCCCESS");
		l_res.setStatus(true);*/
		try{
			if(p_tranRequest != null){
				BeanUtils.copyProperties(p_tranRequest, l_deposit);
			}
			
			CbsTranInterface tranIntr = new CbsTranInterfaceImpl();
			CbsBaseTransResponse l_cbsRes = tranIntr.postCashDepositReq(l_deposit);
			
			if(l_cbsRes.getResponseCode().equals("0"))
				l_res.setStatus(true);
			else 
				l_res.setStatus(false);
			BeanUtils.copyProperties(l_cbsRes,l_res);
			
			LoggerUtil.cbsJobDebug("Rmi Response ::"+l_res.toString());
		
		} catch(Exception e){
			e.printStackTrace();
		}
		return l_res;
		
	}
	


}
