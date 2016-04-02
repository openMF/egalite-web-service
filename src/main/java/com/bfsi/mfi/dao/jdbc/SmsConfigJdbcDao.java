package com.bfsi.mfi.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.SmsConfigDao;
import com.bfsi.mfi.entity.SmsConfig;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("smsConfigDao")
public class SmsConfigJdbcDao extends MaintenanceJdbcDao<SmsConfig> implements
		SmsConfigDao {
	private static String version = null;
	private static int version_no = 0;
	private static String success = "success";
	@Override
	protected String getInsertQuery() {

		return ApplicationQuery.SMSCONFIG_QUERY_INSERT;
	}

	@Override
	protected String getSelectAllQuery() {

		return ApplicationQuery.SMSCONFIG_QUERY_SELECT_ALL;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.SMSCONFIG_SELECT_BY_PK;
	}
	
	@Override
	protected String getUpdateByAuthQuery() {
		return ApplicationQuery.SMSCONFIG_QUERY_UPDATE_BY_AUTH;
	}
	
	@Override
	public List<SmsConfig> getAuthorized() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.SMSCONFIG_QUERY_AUTHORIZED, params, getRowMapper());
	}


	@Override
	protected RowMapper<SmsConfig> getRowMapper() {
		return new SmsConfigMapper();
	}

	private static final class SmsConfigMapper implements RowMapper<SmsConfig> {
		public SmsConfig mapRow(ResultSet rs, int rowNum) throws SQLException {
			SmsConfig smsConfig = new SmsConfig();
			smsConfig.setId(rs.getString("TXN_CODE"));
			smsConfig.setSendSmsFromMbsStr(rs.getString("SEND_SMS_FROM_MBS"));
			smsConfig.setSmsTemplateMbs(rs.getString("SMS_TEMPLATE_MBS"));
			smsConfig.setSendSmsFromIbsStr(rs.getString("SEND_SMS_FROM_IBS"));
			smsConfig.setSmsTemplateIbs(rs.getString("SMS_TEMPLATE_IBS"));
			smsConfig.setIsActive(rs.getString("IS_ACTIVE"));
			smsConfig.setAuthStatus(rs.getString("AUTH_STATUS"));
			return smsConfig;
		}
	}

	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.SMSCONFIG_QUERY_UPDATE;
	}

	@Override
	protected String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}


	
	public boolean isTxnCodeAvailable(String txnCode)
	{
		Map<String, String> params = new HashMap<String, String>();	
		params.put("txnCode", txnCode);
		
		
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(
				ApplicationQuery.TXNCODE_QUERY_TXNCODE_AVAILABLE, params);
		return !rowset.next();// true if there is no next, false if there is
								// next => txnDesc with given txnCode
	}
	private static final class VersionNoRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			String version_no = rs.getString(1);
			return version_no;
		}
	}
	@Override
	public String deleteSmsConfig(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		version = jdbcTemplate.queryForObject(ApplicationQuery.SMSCONFIG_QUERY_AUDIT_VERSION, params,
				new VersionNoRowMapper());
		//version_no = Integer.parseInt(version);
		if (version == null){
			version_no = 0;
		}
		if (version != null){
			version_no = Integer.parseInt(version + 0);
		}

		if (version_no <= 1) {
			jdbcTemplate.execute(ApplicationQuery.SMSCONFIG_QUERY_DELETE, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {

							return stmt.executeUpdate();
						}
					});
			jdbcTemplate.execute(ApplicationQuery.SMSCONFIG_QUERY_DELETE_AUDIT, params,
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

}
