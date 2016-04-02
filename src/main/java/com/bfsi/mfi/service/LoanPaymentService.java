package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.LoanDetailPaidSchView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.LoanDetailPaidSchViewVO;

/**
 * @author bablu
 * 
 */
public interface LoanPaymentService extends ReadOnlyMaintenanceService<LoanDetailPaidSchViewVO, LoanDetailPaidSchView> {

	

	public List<LoanDetailPaidSchViewVO> getloanPayment(String loanpayId)  throws ServiceException;

}