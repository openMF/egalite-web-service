package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.DisburseSchedule;
import com.bfsi.mfi.entity.Loan;
import com.bfsi.mfi.entity.LoanDetailView;
import com.bfsi.mfi.entity.LoanDetailsListView;
import com.bfsi.mfi.entity.RepaymentLiquidation;
import com.bfsi.mfi.entity.RepaymentSchedule;

/**
 * ListValueDao
 * 
 * @author Bablu kumar
 * @param <ListValue>
 */

public interface LoanDao extends ReadOnlyMaintenanceDao<Loan> {
	List<Loan> getDetaisForLoan(String customerId);

	List<Loan> getLoanForCustomer(String customerId);

	List<Loan> getLoanDetails(String agentId, String batchSize);

	public void updateLoanStatus(List<String> loanAccNoList, String status);

	List<DisburseSchedule> getDisbrSchedules(String loanActNo);

	List<RepaymentSchedule> getRepaySchedules(String loanAcNo);

	List<RepaymentLiquidation> getRepayLiquidation(String loanAcNo);

	List<LoanDetailsListView> getList();

	LoanDetailView getLoanView(String id);

	List<LoanDetailsListView> getSearch(String loanAcNo, String brCode,
			String custId, String cfCode, String agtId, String locCode, String parentLoanAcNo, String parentCustID);
	
}
