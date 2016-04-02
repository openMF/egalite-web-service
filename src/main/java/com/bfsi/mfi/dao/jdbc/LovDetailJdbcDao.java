package com.bfsi.mfi.dao.jdbc;

/**
 * User DAO
 * 
 * @author Jyoti Ranjan
 * 
 * @param <LovDetail>
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.dao.LovDetailDao;
import com.bfsi.mfi.entity.LovDetail;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Component("lovDetailDao")
public class LovDetailJdbcDao extends MaintenanceJdbcDao<LovDetail> implements
       LovDetailDao{

	
	private static String version = null;
	private static int version_no = 0;
	private static String success = "success";
	
	
	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.LOV_QUERY_INSERT;
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.LOV_QUERY_SELECT_ALL;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.LOV_QUERY_SELECT_PK;
	}
	
	@Override
	protected RowMapper<LovDetail> getRowMapper() {
		return new LovMapper();
	}

	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.LOV_QUERY_UPDATE;
	}

	@Override
	protected String getDeleteQuery() {
		return null;
	}

	
	
	private static final class LovMapper implements RowMapper<LovDetail> {
		public LovDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
			LovDetail lov = new LovDetail();
			
			lov.setId(rs.getString("DISP_ID"));  
			lov.setLovId(rs.getString("LOV_ID"));
			lov.setLovDesc(rs.getString("LOV_DESC"));
			lov.setIntrValue(rs.getString("INTERNAL_VALUE"));
			lov.setDisplayValue(rs.getString("DISPLAY_VALUE"));
			lov.setOrderBy(rs.getInt("ORDER_BY"));
			lov.setIsActive(rs.getString("IS_ACTIVE"));
			lov.setAuthStatus(rs.getString("AUTH_STATUS"));
			
			return lov;
		}
	}
	
	
	public int getInterValue(String lovId){
		Map<String, String> params = new HashMap<String, String>();
		params.put("lovId", lovId);
		return jdbcTemplate.queryForInt(ApplicationQuery.MAX_INTERMNAL_VALUE, params);
	}
	
	
	
	// For ModifyUniqueID
		@Override
		public boolean isLovStatustoInactive(String idd) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", idd);
			// SqlRowSet rowset = jdbcTemplate.queryForRowSet(
			// QUERY_AGENCY_STATUS_TO_INACTIVE, params);
			int r = jdbcTemplate.queryForInt(ApplicationQuery.DISPLAY_QUERY_STATUS_TO_INACTIVE,
					params);
			// return !rowset.next();// true if there is no next, false if there is
			// next => role with given roleName
			return (r == 0) ? false : true;
		}
	
		/* Auto generateId using function....  */
		@Override
		public String getAutoLovId() {
				String autoGenid = getAutoGenFunCreateId(13); //Pass Your module code.
				return autoGenid;
		}
		
		
		// For deletion Operation
		@Override
		public String deleteUnAuthorized(String id) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", id);
			version = jdbcTemplate.queryForObject(ApplicationQuery.LOV_DISPLAY_QUERY_AUDIT_VERSION, params,
					new VersionNoRowMapper());
			//version_no = Integer.parseInt(version);
			if (version == null)	{
				version_no = 0;
			}
			if (version != null)	{
				version_no = Integer.parseInt(version + 0);
			}

			if (version_no <= 1) 	{
				jdbcTemplate.execute(ApplicationQuery.LOV_DISPLAY_QUERY_DELETE, params,
						new PreparedStatementCallback<Object>() 	{
							@Override
							public Object doInPreparedStatement(
									PreparedStatement stmt) throws SQLException,
									DataAccessException 	{
										return stmt.executeUpdate();
							}
					});
				
				jdbcTemplate.execute(ApplicationQuery.LOV_DISPLAY_QUERY_DELETE_AUDIT, params,
						new PreparedStatementCallback<Object>()	{
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
		
		
		public List<LovDetail> getDispValue(String lovId){
			String sql = ApplicationQuery.GET_LOV_DISPLAY;
			Map<String, String> params = new HashMap<String, String>();
			params.put("lovId", lovId);
			return jdbcTemplate.query(sql, params,getRowMapper());
					                      
		}
		
}
