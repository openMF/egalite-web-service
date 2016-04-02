package com.bfsi.mfi.cbs.adapter.rmi;

import org.springframework.beans.BeanUtils;

import com.bfsi.mfi.cbs.adapter.CbsTransactionServiceAdapter;
import com.bfsi.mfi.cbs.request.CbsGenericRequest;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.util.LoggerUtil;
import com.cbs.bean.CbsBaseTransRequest;
import com.cbs.bean.CbsBaseTransResponse;
import com.cbs.rmi.impl.CbsTranInterfaceImpl;
import com.cbs.service.CbsTranInterface;

public class CbsTrnasactionGenericAdapter implements
CbsTransactionServiceAdapter<CbsGenericRequest, CbsBaseResponse>{

	@Override
	public CbsBaseResponse performTransaction(CbsGenericRequest p_tranRequest)
			throws ServiceException {
		LoggerUtil.cbsJobDebug("Inside RMI for "+p_tranRequest.getClass().getName());
		CbsBaseResponse l_res = new CbsBaseResponse();
		CbsBaseTransRequest l_genricTrans = new CbsBaseTransRequest();
		
		try{
			if(p_tranRequest != null){
				BeanUtils.copyProperties(p_tranRequest, l_genricTrans);
			}
			
			
			
			CbsTranInterface tranIntr = new CbsTranInterfaceImpl();
			CbsBaseTransResponse l_cbsRes = tranIntr.postGenericTransReq(l_genricTrans);
			
			if(l_cbsRes.getResponseCode().equals("0"))
				l_res.setStatus(true);
			else 
				l_res.setStatus(false);
			BeanUtils.copyProperties(l_cbsRes,l_res);
			
			LoggerUtil.cbsJobDebug("Rmi Response ::"+l_res.toString());
		return l_res;
	} catch(Exception e){
		e.printStackTrace();
		l_res.setCbsResStat("X");
		l_res.setStatus(false);
		l_res.setResponseMessage("Failed while sending transaction to the host");
		l_res.setResponseCode("MFI10001");
	}
		return l_res;
	}

}
