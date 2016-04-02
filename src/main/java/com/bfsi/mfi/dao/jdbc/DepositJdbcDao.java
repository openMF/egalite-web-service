package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.DepositDao;
import com.bfsi.mfi.entity.Deposit;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("depositDao")
public class DepositJdbcDao extends MaintenanceJdbcDao<Deposit> implements DepositDao 
{
	
	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.DEP_QUERY_SELECT_ALL;
	}
	
	@Override
	protected RowMapper<Deposit> getRowMapper() {
		return new DisbursementTxnMapper();
	}	
	
	protected RowMapper<Deposit> getDisbursementMapper() {
		return new DisbursementTxnMapper();
	}	
	
	private static final class DisbursementTxnMapper implements RowMapper<Deposit> 
	{
		public Deposit mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			Deposit deposit = new Deposit();
			
			
			return deposit;
		}
	}

	@Override
	public Deposit get(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		return jdbcTemplate.queryForObject(ApplicationQuery.DEP_QUERY_SELECT_ALL_DISB, params, getDisbursementMapper());
	}

	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
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

}