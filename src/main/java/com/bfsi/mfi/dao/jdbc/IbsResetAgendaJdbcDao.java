package com.bfsi.mfi.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.IbsResetAgendaDao;
import com.bfsi.mfi.entity.IbsResetAgenda;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.query.InterfaceQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("ibsResetAgendaDao")
public class IbsResetAgendaJdbcDao extends MaintenanceJdbcDao<IbsResetAgenda> implements
  IbsResetAgendaDao {

	private static String version = null;
	private static int version_no = 0;
	private static String success = "success";
	
	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.IREAGD_QUERY_INSERT;
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.IREAGD_QUERY_SELECT_ALL;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.IREAGD_QUERY_SELECT_BY_PK;
	}
	
	@Override
	protected RowMapper<IbsResetAgenda> getRowMapper() {
		return new IbsResetAgendaMapper();
	}

	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.IREAGD_QUERY_UPDATE;
	}

	@Override
	protected String getDeleteQuery() {
		return null;
	}

	@Override
	protected String getUpdateByAuthQuery() {
		return ApplicationQuery.REAGD_QUERY_UPDATE_BY_AUTH;
	}
	
	private static final class IbsResetAgendaMapper implements RowMapper<IbsResetAgenda> {
		public IbsResetAgenda mapRow(ResultSet rs, int rowNum) throws SQLException {
			IbsResetAgenda ibsResetAgenda = new IbsResetAgenda();
			
			ibsResetAgenda.setId(rs.getString("RESET_GEN_ID"));
			ibsResetAgenda.setResetOption(rs.getString("reset_option"));  //int
			ibsResetAgenda.setAgentId(rs.getString("AGENT_ID"));
			ibsResetAgenda.setResetRemarks(rs.getString("RESET_REMARKS"));
			ibsResetAgenda.setIsActive(rs.getString("IS_ACTIVE"));
			ibsResetAgenda.setAuthStatus(rs.getString("AUTH_STAT"));
			ibsResetAgenda.setInitByUserId(rs.getString("INIT_BY_USER_ID"));
			ibsResetAgenda.setVerifyByUserId(rs.getString("VERIFY_BY_USER_ID"));
			ibsResetAgenda.setResetInitDateTime(rs.getTimestamp("RESET_INIT_DATETIME")); //getTimestamp
			ibsResetAgenda.setResetAuthDateTime(rs.getTimestamp("RESET_AUTH_DATETIME"));
			ibsResetAgenda.setProcessStatus(rs.getString("PROCESS_STAT"));
			
			return ibsResetAgenda;
		}
	}
	
	@Override
	public String getAutoGenId() {
		String autoId = getAutoGenFunCreateId(17); 
		return autoId;
	}
	
	@Override
	public IbsResetAgenda getModify(String id){
		String sql = ApplicationQuery.IREAGD_QUERY_SELECT_MODIFY_PK;
		Map<String, String> params = new HashMap<String, String>();
		LoggerUtil.ibsJobDebug("Query get by PK ->"+sql +" Params -> "+id);
		params.put("id", id);
		try {
			return jdbcTemplate.queryForObject(sql, params, new IbsResetAgendaMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	// For deletion Operation
		@Override
		public String deleteAgenda(String id) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", id);
			version = jdbcTemplate.queryForObject(ApplicationQuery.REAGD_QUERY_AUDIT_VERSION, params,
					new VersionNoRowMapper());
			//version_no = Integer.parseInt(version);
			if (version == null){
				version_no = 0;
			}
			if (version != null){
				version_no = Integer.parseInt(version + 0);
			}

			if (version_no <= 1) {
				jdbcTemplate.execute(ApplicationQuery.REAGD_QUERY_DELETE, params,
						new PreparedStatementCallback<Object>() {
							@Override
							public Object doInPreparedStatement(
									PreparedStatement stmt) throws SQLException,
									DataAccessException {

								return stmt.executeUpdate();
							}
						});
				jdbcTemplate.execute(ApplicationQuery.REAGD_QUERY_DELETE_AUDIT, params,
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
		public Date getBusinessDateForReset() {
			Map<String, Object> l_procRes = null;
			ProcHandler procHandler = new ProcHandler(InterfaceQuery.GET_APP_DATE_TODAYTIME);//

			procHandler.registerOutputParam("result", Types.TIMESTAMP);

			l_procRes = procHandler.execute(true);
			Date l_busDate = (Date) l_procRes.get("result");
			
			
			LoggerUtil.ibsJobDebug("IBS Business Date Proc:: Date:: " + l_busDate);
			System.out.println("BUSINESS DATE="+l_busDate);
			return l_busDate;
			
			
		}
}