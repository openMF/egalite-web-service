package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.LoanScheduleDao;
import com.bfsi.mfi.entity.LoanDetailSchView;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("loanScheduleDao")
public class LoanScheduleJdbcDao extends ReadOnlyMaintenanceJdbcDao<LoanDetailSchView> implements
		LoanScheduleDao {


	@Override
	protected RowMapper<LoanDetailSchView> getRowMapper() {
		return new LoanMapper();
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.LSCH_QUERY_SELECT_ALL;
	}

	protected String getSelectByPkQuery() {
		return ApplicationQuery.LSCH_QUERY_SELECT_BY_PK;
	}

	
	public static final class LoanMapper implements RowMapper<LoanDetailSchView> {
		public LoanDetailSchView mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			LoanDetailSchView loanDetailSchView = new LoanDetailSchView();
			loanDetailSchView.setId(rs.getString("LOAN_AC_NO"));
			loanDetailSchView.setBranchCode(rs.getString("branch_code"));
			loanDetailSchView.setComponentName(rs.getString("COMPONENT_NAME"));
			loanDetailSchView.setSchType(rs.getString("sch_type"));
			loanDetailSchView.setSchStDate(BaseJdbcDao.getUtilDate(rs.getDate("sch_st_date")));
			loanDetailSchView.setSchEndDate(BaseJdbcDao.getUtilDate(rs.getDate("sch_end_date")));
			loanDetailSchView.setIsFutureSch(rs.getString("is_future_sch"));
			loanDetailSchView.setAmtDue(rs.getDouble("amt_due"));
			/*New  Field for Added ==> changes for Asomi Nirmal kanna S*/
			loanDetailSchView.setAgendaId(rs.getString("agenda_id"));
			loanDetailSchView.setCcyCode(rs.getString("ccy_code"));
			loanDetailSchView.setAmtSettled(rs.getDouble("Amt_settled"));
			loanDetailSchView.setIsSettled(rs.getString("Is_settled"));
			
			return loanDetailSchView;
		}
	}
	
	@Override
	public List<LoanDetailSchView> getloanSchedule(String loanaccId){

			Map<String, String> params = new HashMap<String, String>();
			params.put("loanaccId", loanaccId);

			List<LoanDetailSchView> repaySchedule = jdbcTemplate.query(
					ApplicationQuery.LSCH_QUERY_SELECT_ALL, params, new LoanMapper());

			return ((repaySchedule != null) ? repaySchedule
					: new ArrayList<LoanDetailSchView>());
	}
	
	
}
