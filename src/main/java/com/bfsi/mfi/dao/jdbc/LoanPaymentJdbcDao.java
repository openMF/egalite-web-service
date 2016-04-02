package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.LoanPaymentDao;
import com.bfsi.mfi.entity.LoanDetailPaidSchView;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("loanPaymentDao")
public class LoanPaymentJdbcDao extends ReadOnlyMaintenanceJdbcDao<LoanDetailPaidSchView> implements
		LoanPaymentDao {

	@Override
	protected RowMapper<LoanDetailPaidSchView> getRowMapper() {
		return new NewLoanMapper();
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.LPAY_QUERY_SELECT_ALL;
	}

	protected String getSelectByPkQuery() {
		return ApplicationQuery.LPAY_QUERY_SELECT_BY_PK;
	}


	public static final class NewLoanMapper implements RowMapper<LoanDetailPaidSchView> {
		public LoanDetailPaidSchView mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			/*a.loan_ac_no,// from super class
			 * a.branch_code, 
			 * 
			a.sch_due_date,a.sch_paid_date,
			a.settlement_ccy_code,a.amt_settled,
			a.full_partial_ind*/
			LoanDetailPaidSchView loanDetailPaidSchView = new LoanDetailPaidSchView();
			loanDetailPaidSchView.setId(rs.getString("LOAN_AC_NO"));
			loanDetailPaidSchView.setId(rs.getString("branch_code"));
			loanDetailPaidSchView.setSchDueDate(BaseJdbcDao.getUtilDate(rs.getDate("sch_due_date")));
			loanDetailPaidSchView.setSchPaidDate(BaseJdbcDao.getUtilDate(rs.getDate("sch_paid_date")));
			loanDetailPaidSchView.setSettlementCcyCode(rs.getString("settlement_ccy_code"));
			loanDetailPaidSchView.setAmtSettled(rs.getDouble("amt_settled"));
			loanDetailPaidSchView.setFullPartialInd(rs.getString("full_partial_ind"));
			return loanDetailPaidSchView;
		}
	}
	
	
	@Override
	public List<LoanDetailPaidSchView> getloanPayment(String loanpayId){

			Map<String, String> params = new HashMap<String, String>();
			params.put("loanpayId", loanpayId);
			List<LoanDetailPaidSchView> paymentLoan = jdbcTemplate.query(
					ApplicationQuery.LPAY_QUERY_SELECT_ALL, params, new NewLoanMapper());
			return ((paymentLoan != null) ? paymentLoan
					: new ArrayList<LoanDetailPaidSchView>());
	}
	
	
}
