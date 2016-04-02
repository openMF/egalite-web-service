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
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.SystemParameterDao;
import com.bfsi.mfi.entity.SystemParameter;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.SystemParameterVO;

@Repository("systemParameterDao")
public class SystemParameterJdbcDao extends BaseJdbcDao implements
		SystemParameterDao {
	

	
	@Override
	public String getSelectAllQuery() {
	
		return ApplicationQuery.SYSPARAM_QUERY_SELECT_ALL;
	}

	
	@Override
	public RowMapper<SystemParameter> getRowMapper() {
		
		return new SystemParameterMapper();
	}

	
	@Override
	public String getUpdateQuery() {
		
		return ApplicationQuery.SYSPARAM_QUERY_UPDATE;
	}

	
	@Override
	public String getSelectByPkQuery() {
		return ApplicationQuery.SYSPARAM_QUERY_SELECT_BY_PK;
	}

	private static final class SystemParameterMapper implements
			RowMapper<SystemParameter> {

		public SystemParameter mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			SystemParameter sysparam = new SystemParameter();
			sysparam.setParamName(rs.getString("PARAM_NAME"));
			

			sysparam.setParamText(rs.getString("PARAM_TEXT"));
	
			sysparam.setParamType(rs.getString("PARAM_TYPE"));
			

			sysparam.setParamValue(rs.getString("PARAM_VALUE"));
			
			sysparam.setEditable(rs.getString("EDITABLE"));
		
			sysparam.setComponents(rs.getString("COMPONENTS"));
		
			return sysparam;
		}
	}

	@Override
	public List<SystemParameter> getAllParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return (List<SystemParameter>) jdbcTemplate.query(ApplicationQuery.SYSPARAM_QUERY_SELECT_ALL,
				params, getRowMapper());
	}

	@Override
	public void updateSystemParameter(
			List<SystemParameterVO> systemParameterlist) {
	

		for (SystemParameterVO sysvo : systemParameterlist) {
			SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
					sysvo);
			jdbcTemplate.execute(ApplicationQuery.SYSPARAM_QUERY_UPDATE, namedParameters,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
					});

		}
	}

	@Override
	public SystemParameter getParameterTypeForValidation(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		try {
			return jdbcTemplate.queryForObject(ApplicationQuery.SYSPARAM_QUERY_SELECT_PARAM_TYPE, params,
					new SystemParameterMapper());

		} catch (DataAccessException e) {
			LoggerUtil.ibsJobError("DataAccessException : MFI10001", e);
			return null;
		}
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SystemParameter> get() {
	
		String sql = getSelectAllQuery();
		return jdbcTemplate.query(sql, (Map) null, getRowMapper());
	}


	@Override
	public int getIntParamValue(String paramName) {
		String paramValue = getParamValue(paramName);
		return (paramValue != null) ? new Integer(paramValue) : -1;
	}
	
	@Override
	public String getParamValue(String paramName) {
		Map<String, String> params = new HashMap<String, String>();
		String paramValue = null;
		params.put("paramName", paramName);
		try {
			paramValue = jdbcTemplate.queryForObject(ApplicationQuery.SYSPARAM_QUERY_SELECT_PARAMVALUE,
					params, String.class);
		} catch (DataAccessException e) {
			LoggerUtil.ibsJobError("DataAccessException : MFI10001", e);
			return null;
		}
		return paramValue;

	}


	@Override
	public void updateSystemParameterFor(String p_name, String p_value) {
		Map<String, String> l_params=new HashMap<String, String>();
		l_params.put("paramName", p_name);
		l_params.put("paramValue", p_value);
		jdbcTemplate.update(ApplicationQuery.SYSPARAM_QUERY_UPDATE, l_params);
		
	}
	
	@Override
	public String getCheckedinUser(){
		Map<String, String> params = new HashMap<String, String>();
		String checkinUser = null;
		params.put("paramName", null);
		try {
			checkinUser = jdbcTemplate.queryForObject(ApplicationQuery.SYSPARAM_QUERY_SELECT_CHECKINUSER,
					params, String.class);
		} catch (DataAccessException e) {
			LoggerUtil.ibsJobError("DataAccessException : MFI10001", e);
			return null;
		}
		return checkinUser;
		
	}
	
	
}
