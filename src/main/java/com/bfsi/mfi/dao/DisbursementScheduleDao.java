package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.LoanDetailDisbrView;

/**
 * @author Jyoti Ranjan
 *
 */

public interface DisbursementScheduleDao extends MaintenanceDao<LoanDetailDisbrView>{
	
	public List<LoanDetailDisbrView> getDisbursementSchedule(String loanaccId);
	

	
}
