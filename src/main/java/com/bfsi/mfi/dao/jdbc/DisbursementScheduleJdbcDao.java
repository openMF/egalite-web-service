package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.DisbursementScheduleDao;
import com.bfsi.mfi.entity.LoanDetailDisbrView;
import com.bfsi.mfi.query.ApplicationQuery;

/**
 * @author Jyoti Ranjan
 *
 */

@Repository("disbursementScheduleDao")
public class DisbursementScheduleJdbcDao extends MaintenanceJdbcDao<LoanDetailDisbrView> implements
DisbursementScheduleDao {

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.DISBSCH_QUERY_SELECT_ALL; 
	}
	
/*	@Override
	protected String getInsertQuery() {
		return QUERY_INSERT;
	}
	*/
	
	@Override
	protected RowMapper<LoanDetailDisbrView> getRowMapper() {
		return new DisburseScheduleMapper();
	}

	public static final class DisburseScheduleMapper implements RowMapper<LoanDetailDisbrView> {
		public LoanDetailDisbrView mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			/*a.loan_ac_no,a.branch_code,a.component_name,a.disbr_type,
		       *******   a.sch_st_date,a.sch_end_date,
			              ****           a.amt_to_disbr*/
			LoanDetailDisbrView loanDetailDisbrView = new LoanDetailDisbrView();
			loanDetailDisbrView.setId(rs.getString("LOAN_AC_NO"));
			loanDetailDisbrView.setBranchCode(rs.getString("branch_code"));
			loanDetailDisbrView.setComponentName(rs.getString("component_name"));
			loanDetailDisbrView.setDisbrType(rs.getString("disbr_type"));
			loanDetailDisbrView.setSchStDate(BaseJdbcDao.getUtilDate(rs.getDate("sch_st_date")));
			loanDetailDisbrView.setSchEndDate(BaseJdbcDao.getUtilDate(rs.getDate("sch_end_date")));
			loanDetailDisbrView.setAmtToDisbr(rs.getDouble("amt_to_disbr"));
			// New Columns Added ==> Changes for Asomi Nirmal kanna S
			loanDetailDisbrView.setAgendaId(rs.getString("agenda_id"));
			loanDetailDisbrView.setCcyCode(rs.getString("ccy_code"));
			loanDetailDisbrView.setAmtDisbursed(rs.getDouble("amt_disbursed"));
			loanDetailDisbrView.setIsSettled(rs.getString("is_Settled"));
			return loanDetailDisbrView;
		}
	}
	
	@Override
	public List<LoanDetailDisbrView> getDisbursementSchedule(String loanaccId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("loanaccId", loanaccId);
		List<LoanDetailDisbrView> disbrSchdls = jdbcTemplate.query(
				ApplicationQuery.DISBSCH_QUERY_SELECT_ALL, params, new DisburseScheduleMapper());

		return (disbrSchdls != null) ? disbrSchdls
				: new ArrayList<LoanDetailDisbrView>();
	}
	@Override
	protected String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

}
