package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.MfiMbsTxnLndisbrV;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.LoanVO;
import com.bfsi.mfi.vo.MfiMbsTxnLndisbrVO;

/*
 * @author arun
 *
 */

public interface LoanDisbursementTxnService extends MaintenanceService<MfiMbsTxnLndisbrVO, MfiMbsTxnLndisbrV>{
	
	public List<MfiMbsTxnLndisbrVO> getchildLoan(String cbsAcRefNo)  throws ServiceException;

}
