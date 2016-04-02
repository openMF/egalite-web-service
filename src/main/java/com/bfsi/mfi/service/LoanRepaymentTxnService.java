package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.MfiMbsTxnLnrepayV;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.MfiMbsTxnLnrepayVO;

public interface LoanRepaymentTxnService  extends MaintenanceService<MfiMbsTxnLnrepayVO, MfiMbsTxnLnrepayV>{

	public List<MfiMbsTxnLnrepayVO> getchildLoan(String cbsAcRefNo)  throws ServiceException;

}
