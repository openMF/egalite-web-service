package com.bfsi.mfi.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.LovBaseDao;
import com.bfsi.mfi.entity.LovBase;
import com.bfsi.mfi.query.ApplicationQuery;


@Repository("lovBaseDao")
public class LovBaseJdbcDao extends MaintenanceJdbcDao<LovBase> implements
                            LovBaseDao{

	private static String version = null;
	private static int version_no = 0;
	private static String success = "success";
	
	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.BASE_QUERY_SELECT_INSERT;
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.BASE_QUERY_SELECT_ALL;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.BASE_QUERY_SELECT_PK;
	}
	
	@Override
	protected RowMapper<LovBase> getRowMapper() {
		return new LovBaseMapper();
	}

	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.BASE_QUERY_UPDATE;
	}

	@Override
	protected String getDeleteQuery() {
		return ApplicationQuery.BASE_QUERY_DELETE;
	}

	private static final class LovBaseMapper implements RowMapper<LovBase> {
		public LovBase mapRow(ResultSet rs, int rowNum) throws SQLException {
			LovBase lov = new LovBase();
			
			lov.setId(rs.getString("LOV_ID"));
			lov.setLovDesc(rs.getString("LOV_DESC"));
			lov.setIsActive(rs.getString("IS_ACTIVE"));
			
			
			return lov;
		}
	}
	
	
	
	@Override
	public boolean isLovIdAvailable(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(
				ApplicationQuery.BASE_LOVID_AVAILABLE, params);
		return !rowset.next();// true if there is no next, false if there is
		// next => role with given roleName

	}
	
	//delete LOV from base and display.....
	@Override
	public String deleteBaseLov(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		version = jdbcTemplate.queryForObject(ApplicationQuery.BASE_QUERY_AUDIT_VERSION, params,
				new VersionNoRowMapper());

		if (version == null) {
			version_no = 0;
		}
		if (version != null) {
			version_no = Integer.parseInt(version + 0);
		}
		if (version_no <= 1) {
			jdbcTemplate.execute(ApplicationQuery.BASE_QUERY_DELETE_LOV_DISPLAY, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
					});
			
			jdbcTemplate.execute(ApplicationQuery.BASE_QUERY_HARD_DELETE, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
					});
			jdbcTemplate.execute(ApplicationQuery.BASE_QUERY_DELETE_AUDIT, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
					});
		}
		return success;
	}
	
	private static final class VersionNoRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			String version_no = rs.getString(1);
			return version_no;
		}
	}
	
	
	@Override
	public boolean isLovStatustoInactive(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		// SqlRowSet rowset = jdbcTemplate.queryForRowSet(
		// QUERY_AGENCY_STATUS_TO_INACTIVE, params);
		int r = jdbcTemplate.queryForInt(ApplicationQuery.QUERY_BASE_STATUS_TO_INACTIVE,
				params);
		// return !rowset.next();// true if there is no next, false if there is
		// next => role with given roleName
		return (r == 0) ? false : true;
	}
}
