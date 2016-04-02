package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.LoanDetailsListView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.LoanDetailsListViewVO;


public interface LoanDetailsListViewService extends ReadOnlyMaintenanceService<LoanDetailsListViewVO, LoanDetailsListView> {

	List<LoanDetailsListViewVO> getList()throws ServiceException;

	List<LoanDetailsListViewVO> getSearch(String loanAcNo, String brCode,
			                    String custId, String cfCode, String agtId, String locCode, String parentLoanAcNo, String parentCustID) throws ServiceException;
	
}
