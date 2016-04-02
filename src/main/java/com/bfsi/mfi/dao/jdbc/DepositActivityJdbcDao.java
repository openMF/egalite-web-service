package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.DepositActivityDao;
import com.bfsi.mfi.entity.DepositActivity;
import com.bfsi.mfi.query.ApplicationQuery;

/**
 * @author Bablu kumar
 *
 */

@Repository("depositActivityDao")
public class DepositActivityJdbcDao extends MaintenanceJdbcDao<DepositActivity> implements
DepositActivityDao {

	@Override
	protected String getSelectAllQuery() {
		//return ApplicationQuery.DEPOSIT_ACTIVITY_BSCH_QUERY_SELECT_ALL;
		return null;
	}

	
	@Override
	protected RowMapper<DepositActivity> getRowMapper() {
		return new DepositActivityMapper();
	}

	public static final class DepositActivityMapper implements RowMapper<DepositActivity> {
		public DepositActivity mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			DepositActivity disburSchedule = new DepositActivity();
			disburSchedule.setId(rs.getString("DEP_AC_NO"));
			disburSchedule.setTxnTypeStDate(BaseJdbcDao.getUtilDate(rs
					.getDate("txn_type_st_date")));
			disburSchedule.setTxnTypeEndDate(BaseJdbcDao.getUtilDate(rs
					.getDate("txn_type_end_date")));
			disburSchedule.setTxnTypeDueDate(BaseJdbcDao.getUtilDate(rs
					.getDate("txn_type_due_date")));
			disburSchedule.setTxnTypeDesc(rs.getString("txn_type_desc"));
			disburSchedule.setTxnCcyCode(rs.getString("txn_ccy_code"));
			disburSchedule.setTxnAmtDue(rs.getInt("txn_amt_due"));
			disburSchedule.setTxnAmtSettled(rs.getInt("txn_amt_settled"));
			disburSchedule.setIsSettled(rs.getString("is_settled"));
			disburSchedule.setBranchCode(rs.getString("branch_code"));
			//disburSchedule.setAgendaId(rs.getString("AGENDA_ID"));
			//Agenda ID added ==> changes for Asomi Nirmal kanna S
			//agendaId
			return disburSchedule;
		}
	}
	
	@Override
	public List<DepositActivity> getDepositActivityView(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		List<DepositActivity> depositac = jdbcTemplate.query(
				ApplicationQuery.DEPOSIT_ACTIVITY_BSCH_QUERY_SELECT_ALL, params, new DepositActivityMapper());

		return (depositac != null) ? depositac
				: new ArrayList<DepositActivity>();
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
