package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.LoanDetailSchView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.LoanDetailSchViewVO;


/**
 * @author Jyoti Ranjan
 * 
 */
public interface LoanScheduleService extends ReadOnlyMaintenanceService<LoanDetailSchViewVO, LoanDetailSchView> {

	

	public List<LoanDetailSchViewVO> getloanSchedule(String loanaccId)  throws ServiceException;

}