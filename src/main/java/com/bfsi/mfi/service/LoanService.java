package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.Loan;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.LoanVO;

/**
 * @author arun
 * 
 */
public interface LoanService extends ReadOnlyMaintenanceService<LoanVO, Loan> {
	List<LoanVO> getLoanAccounts(String customerId);

	List<LoanVO> getLoans(String id,String batchSize)throws ServiceException;

	public Boolean updateLoanStaus(List<String> loanAccNoList) throws ServiceException;

	//List<LoanDetailsListViewVO> getList()throws ServiceException;


}