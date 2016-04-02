package com.cbs.service;

import com.cbs.bean.CbsBaseTransRequest;
import com.cbs.bean.CbsBaseTransResponse;
import com.cbs.bean.CbsCashDepositTranRequest;
import com.cbs.bean.CbsCashWithdrawTranRequest;
import com.cbs.bean.CustomerEnrolInfo;

public interface CbsTranInterface {
	
	CbsBaseTransResponse postGenericTransReq(CbsBaseTransRequest p_req) throws Exception;
	CbsBaseTransResponse postCustEnrol(CustomerEnrolInfo p_req) throws Exception;
	
	CbsBaseTransResponse postCashWithdrawReq(CbsCashWithdrawTranRequest p_req) throws Exception;
	CbsBaseTransResponse postCashDepositReq(CbsCashDepositTranRequest p_req) throws Exception;

}
