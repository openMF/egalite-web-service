package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.FunctionDao;
import com.bfsi.mfi.entity.Function;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("functionDao")
public class FunctionJdbcDao extends MaintenanceJdbcDao<Function> implements
		FunctionDao {

	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.FUN_QUERY_INSERT;

	}

	@Override
	public RowMapper<Function> getRowMapper() {
		return new FunctionMapper();
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.FUN_QUERY_SELECT_ALL; //

	}

	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.FUN_QUERY_UPDATE;
	}

	@Override
	protected String getDeleteQuery() {

		return null;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.FUN_QUERY_SELECT_BY_PK;
	}

	@Override
	public List<Function> getFunctionsForRole(String roleId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("roleId", roleId);
		List<Function> functions = jdbcTemplate.query(ApplicationQuery.FUN_QUERY_SELECT_FUNCTION, params,
				new FunctionMapper());
		return (functions != null) ? functions : new ArrayList<Function>();
	}

	static final class FunctionMapper implements RowMapper<Function> {

		public Function mapRow(ResultSet rs, int rowNum) throws SQLException {
			Function func = new Function();

			func.setId(rs.getString("FUNC_ID"));
			func.setBaseFunc(rs.getString("BASE_FUNC"));
			func.setFuncDesc(rs.getString("FUNC_DESC"));
			func.setFuncCommand(rs.getString("FUNC_COMMAND"));
			return func;
		}
	}

	public RowMapper<String> getDrop() {
		return new DropMapper();
	}

	private static final class DropMapper implements RowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			//Function func = new Function();

			String dropValue = rs.getString("FUNC_ID");
			return dropValue;
		}
	}
}
