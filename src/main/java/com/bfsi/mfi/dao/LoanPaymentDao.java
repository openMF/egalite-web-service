package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.LoanDetailPaidSchView;

/**
 * ListValueDao
 * 
 * @author Jyoti Ranjan
 * @param <ListValue>
 */

public interface LoanPaymentDao extends ReadOnlyMaintenanceDao<LoanDetailPaidSchView> {
	
	public List<LoanDetailPaidSchView> getloanPayment(String loanpayId);

}
