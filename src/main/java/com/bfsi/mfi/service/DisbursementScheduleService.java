package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.LoanDetailDisbrView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.LoanDetailDisbrViewVO;

/**
 * @author Jyoti Ranjan
 * 
 */
public interface DisbursementScheduleService extends
		MaintenanceService<LoanDetailDisbrViewVO, LoanDetailDisbrView> {

	public List<LoanDetailDisbrViewVO> getDisbursementSchedule(String loanpayId)
			throws ServiceException;
	
}