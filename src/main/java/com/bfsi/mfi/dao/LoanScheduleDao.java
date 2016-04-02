package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.LoanDetailSchView;

/**
 * ListScheduleValueDao
 * 
 * @author Jyoti Ranjan
 * @param <ListValue>
 */

public interface LoanScheduleDao extends ReadOnlyMaintenanceDao<LoanDetailSchView> {
	public List<LoanDetailSchView> getloanSchedule(String loanaccId);

}
