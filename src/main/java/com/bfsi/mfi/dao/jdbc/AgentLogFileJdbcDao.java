package com.bfsi.mfi.dao.jdbc;

import java.io.Reader;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.AgentLogFileDao;
import com.bfsi.mfi.entity.File;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("agentLogFileJdbcDao")
public class AgentLogFileJdbcDao extends ReadOnlyMaintenanceJdbcDao<File>
		implements AgentLogFileDao {

	@Override
	public List<File> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public void insertFileToDb(File file) {
	 * 
	 * InputStream input = file.getIn(); MapSqlParameterSource paramSource = new
	 * MapSqlParameterSource(); try { String bytes = IOUtils.toString(input); }
	 * catch (IOException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } try { jdbcTemplate.update(
	 * "INSERT INTO trn_imgs (img_title, img_data) VALUES (?, ?)", paramSource);
	 * 
	 * } catch (DataAccessException e) {
	 * System.out.println("DataAccessException " + e.getMessage()); }
	 * 
	 * }
	 */

	@Override
	protected String getSelectAllQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected RowMapper<File> getRowMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBlob(final byte[] data, String agentId, String deviceId) {
		String sql = ApplicationQuery.LOG_INSERT;  
		jdbcTemplate.getJdbcOperations().update(
				new LobPreparedStatementCreator(sql, data, agentId, deviceId));
	}

	@Override
	public void insertClob(Reader reader, String agentId, String deviceId,
			String fileName, Date syncDate) {
		String sql = ApplicationQuery.QUERY_INSERT_CLOB;
		jdbcTemplate.getJdbcOperations().update(
				new LobGenericPreparedStatementCreator(sql, reader, agentId,
						deviceId, fileName, new java.sql.Date(syncDate
								.getTime())));
	}

	@Override
	public void readClob(Writer writer, String agentId, String deviceId) {
		String sql = ApplicationQuery.QUERY_READ_CLOB;
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("agentId", agentId);
		paramsMap.put("deviceId", deviceId);
		jdbcTemplate.query(sql, paramsMap, new ClobMapper(writer));
	}
}
