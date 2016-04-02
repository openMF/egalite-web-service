package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.MfiMbsTxnLndisbrV;
import com.bfsi.mfi.vo.MfiMbsTxnLndisbrVO;

/**
 * User DAO
 * @author akrishna
 * @param <User>
 */

public interface LoanDisbursementTxnDao extends MaintenanceDao<MfiMbsTxnLndisbrV> {

	List<MfiMbsTxnLndisbrV> getchildLoan(String cbsAcRefNo);

	
}
