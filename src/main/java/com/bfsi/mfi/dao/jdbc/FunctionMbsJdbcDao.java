package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.FunctionMbsDao;
import com.bfsi.mfi.entity.FunctionMbs;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("functionMbsDao")
public class FunctionMbsJdbcDao extends MaintenanceJdbcDao<FunctionMbs> implements
		FunctionMbsDao {

	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.FUN_MBS_QUERY_INSERT;
	}

	@Override
	public RowMapper<FunctionMbs> getRowMapper() {
		return new FunctionMapper();
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.FUN_MBS_QUERY_SELECT_ALL; //
	}

	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.FUN_MBS_QUERY_UPDATE;
	}

	@Override
	protected String getDeleteQuery() {
		return null;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.FUN_MBS_QUERY_SELECT_BY_PK;
	}

	@Override
	public List<FunctionMbs> getFunctionsForRole(String roleId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("roleId", roleId);
		List<FunctionMbs> functions = jdbcTemplate.query(ApplicationQuery.FUN_MBS_QUERY_SELECT_FUNCTION, params,
				new FunctionMapper());
		return (functions != null) ? functions : new ArrayList<FunctionMbs>();
	}

	static final class FunctionMapper implements RowMapper<FunctionMbs> {

		public FunctionMbs mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			FunctionMbs func = new FunctionMbs();
			func.setId(rs.getString("FUNC_ID"));
			func.setBaseFunc(rs.getString("BASE_FUNC"));
			//func.setFuncDesc(rs.getString("FUNC_DESC"));
			//func.setFuncCommand(rs.getString("FUNC_COMMAND"));
			return func;
		}
	}

	public RowMapper<String> getDrop() {
		return new DropMapper();
	}

	private static final class DropMapper implements RowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			//FunctionMbs func = new FunctionMbs();
			String dropValue = rs.getString("FUNC_ID");
			return dropValue;
		}
	}
	
	@Override
	public List<FunctionMbs> getMbsFunction() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.FUN_LIST_MBS_QUERY_SELECT_ALL, params, getRowMapper());
	}
}