package com.bfsi.mfi.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.SmsTemplateDao;
import com.bfsi.mfi.entity.SmsTemplate;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("smsTemplateDao")
public class SmsTemplateJdbcDao extends MaintenanceJdbcDao<SmsTemplate>
		implements SmsTemplateDao {
	private static String version = null;
	private static int version_no = 0;
	private static String success = "success";
	@Override
	protected String getSelectAllQuery() {

		return ApplicationQuery.SMSTEMPLATE_QUERY_SELECT_ALL;
	}
	@Override
	protected String getSelectByPkQuery() {
		
		return ApplicationQuery.SMSTEMPLATE_SELECT_BY_PK;
	}
	@Override
	protected RowMapper<SmsTemplate> getRowMapper() {
		return new SmsTemplateMapper();
	}

	private static final class SmsTemplateMapper implements
			RowMapper<SmsTemplate> {
		public SmsTemplate mapRow(ResultSet rs, int rowNum) throws SQLException {
			SmsTemplate smsTemplate = new SmsTemplate();
			
			smsTemplate.setId(rs.getString("TEMPLATE_ID"));
			smsTemplate.setTxtSms(rs.getString("TXT_SMS"));
			smsTemplate.setDynaFields(rs.getString("DYNAMIC_FIELDS"));
			smsTemplate.setDescription(rs.getString("DESCRIPTION"));
			
			return smsTemplate;
		}
	}
	
	@Override
	public String getAutoTemplateId() {
		/*Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.queryForObject(ApplicationQuery.SMSTEMPLATE__AUTO_ID, params,
				new TemplateIDRowMapper());*/
		String autoGenid = getAutoGenFunCreateId(14); //Pass Your module code.
		return autoGenid;

	}

	private static final class TemplateIDRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			SmsTemplate smstemp = new SmsTemplate();
			String templateAutoID = rs.getString("TEMPLATE_ID");
			String setID = null;
			String value = "00001";
			String codes = "MSG";

			if (templateAutoID == null || templateAutoID.equals("")) {
				setID = codes + value;
				smstemp.setId(setID);

			} else {
				String code = templateAutoID.substring(0, 3);
				String ActualId = templateAutoID.substring(3, 8);
				int ActualIdValue = Integer.parseInt(ActualId);
				int one = 1;
				int incrementId = ActualIdValue + one;
				String incrementIdValue = Integer.toString(incrementId);

				if (incrementIdValue.length() == 1) {
					setID = code + "0000" + incrementIdValue;
					smstemp.setId(setID);
				} else if (incrementIdValue.length() == 2) {
					setID = code + "000" + incrementIdValue;
					smstemp.setId(setID);
				} else if (incrementIdValue.length() == 3) {
					setID = code + "00" + incrementIdValue;
					smstemp.setId(setID);
				} else if (incrementIdValue.length() == 4) {
					setID = code + "0" + incrementIdValue;
					smstemp.setId(setID);
				} else {
					setID = code + incrementIdValue;
					smstemp.setId(setID);
				}
			}
			return setID;
		}
	}
	private static final class VersionNoRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			String version_no = rs.getString(1);
			return version_no;
		}
	}
	@Override
	public String deleteSmsTemplate(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		version = jdbcTemplate.queryForObject(ApplicationQuery.SMSTEMPLATE_QUERY_AUDIT_VERSION, params,
				new VersionNoRowMapper());
		//version_no = Integer.parseInt(version);
		if (version == null){
			version_no = 0;
		}
		if (version != null){
			version_no = Integer.parseInt(version + 0);
		}

		if (version_no <= 1) {
			jdbcTemplate.execute(ApplicationQuery.SMSTEMPLATE_QUERY_DELETE, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {

							return stmt.executeUpdate();
						}
					});
			jdbcTemplate.execute(ApplicationQuery.SMSTEMPLATE_QUERY_DELETE_AUDIT, params,
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
	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return ApplicationQuery.SMSTEMPLATE_QUERY_INSERT;
	}



	@Override
	protected String getUpdateQuery() {
		// TODO Auto-generated method stub
		return ApplicationQuery.SMSTEMPLATE_QUERY_UPDATE;
	}

	@Override
	protected String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}
}
