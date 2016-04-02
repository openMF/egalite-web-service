package com.bfsi.mfi.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.AuditTrailDao;
import com.bfsi.mfi.entity.AuditTrail;
import com.bfsi.mfi.entity.MaintenanceEntity;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("auditTrailDao")
public class AuditTrailJdbcDao<E extends MaintenanceEntity> extends BaseJdbcDao
		implements AuditTrailDao<E> {

	/**
	 * Maps individual row in Audit Detail table to AuditTrail entity
	 * 
	 * @author akrishna
	 * 
	 */
	class AuditTrailMapper implements RowMapper<AuditTrail<E>> {
		public AuditTrail<E> mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			AuditTrail<E> auditTrail = new AuditTrail<E>();
			auditTrail.setTableName(rs.getString("TABLE_NAME"));
			auditTrail.setKeyId(rs.getString("KEY_ID"));
			auditTrail.setVersion(rs.getInt("VERSION_NO"));
			auditTrail.setMaker(rs.getString("MAKER_ID"));
			auditTrail.setMakerTimestamp(rs.getTimestamp("MAKER_DT"));
			auditTrail.setChecker(rs.getString("CHECKER_ID"));
			auditTrail.setCheckerTimestamp(rs.getTimestamp("CHECKER_DT"));

			return auditTrail;
		}
	}

	@Override
	public void auditCreate(AuditTrail<E> auditTrailDetails) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				auditTrailDetails);
		LoggerUtil.ibsJobDebug("Query Insert-> "+ApplicationQuery.AUDTRL_QUERY_INSERT);
		jdbcTemplate.execute(ApplicationQuery.AUDTRL_QUERY_INSERT, namedParameters,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});
	}

	@Override
	public void auditUpdate(AuditTrail<E> auditTrailDetails) {
		// for now logic is same as create, so just reuse that logic
		auditCreate(auditTrailDetails);
	}

	@Override
	public void auditAuth(AuditTrail<E> auditTrailDetails) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				auditTrailDetails);
		LoggerUtil.ibsJobDebug("Query auth-> "+ApplicationQuery.AUDTRL_QUERY_UPDATE_AUTH);
		jdbcTemplate.execute(ApplicationQuery.AUDTRL_QUERY_UPDATE_AUTH, namedParameters,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});
	}

	@Override
	public List<AuditTrail<E>> getAllAuditTrails(E entity) {
		AuditTrail<E> auditTrail = new AuditTrail<E>();
		auditTrail.setTableName(AuditTrail.getTableNameFromMapping(entity));
		auditTrail.setKeyId(entity.getId());
		LoggerUtil.ibsJobDebug("Query list all-> "+ApplicationQuery.AUDTRL_QUERY_SELECT_ALL_VERSIONS+ " param: "+entity.getId());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				auditTrail);
		return jdbcTemplate.query(ApplicationQuery.AUDTRL_QUERY_SELECT_ALL_VERSIONS, namedParameters,
				new AuditTrailMapper());
	}

	@Override
	public void loadAuditXml(AuditTrail<E> auditTrail) {

		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				auditTrail);
		LoggerUtil.ibsJobDebug("Query load audit xml-> "+ApplicationQuery.AUDTRL_QUERY_SELECT_VERSION);
		try {
			AuditTrail<E> auditTrailDetails = jdbcTemplate.queryForObject(
					ApplicationQuery.AUDTRL_QUERY_SELECT_VERSION, namedParameters,
					new AuditTrailMapper());
			auditTrail.setObjectXml(auditTrailDetails.getObjectXml());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer getMaxVersion(E entity) {
		AuditTrail<E> auditTrail = new AuditTrail<E>();
		auditTrail.setTableName(AuditTrail.getTableNameFromMapping(entity));
		auditTrail.setKeyId(entity.getId());
		LoggerUtil.ibsJobDebug("Query max version-> "+ApplicationQuery.AUDTRL_QUERY_SELECT_MAX_VERSION+ " param: "+entity.getId());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				auditTrail);
		try {
			return jdbcTemplate.queryForInt(ApplicationQuery.AUDTRL_QUERY_SELECT_MAX_VERSION,
					namedParameters);
		} catch (DataAccessException e) {
			LoggerUtil.ibsJobError("DataAccessException : MFI10001", e);
			return 0;
		}
	}

	@Override
	public List<String> getMakerForMaxVersion(AuditTrail<E> auditTrail) {
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				auditTrail);
		final List<String> makerIds = new ArrayList<String>();
		LoggerUtil.ibsJobDebug("Query get maker for version-> "+ApplicationQuery.AUDTRL_QUERY_SELECT_MAX_VERSION_MAKER);
		try {
			 jdbcTemplate.query(ApplicationQuery.AUDTRL_QUERY_SELECT_MAX_VERSION_MAKER,
					namedParameters, new RowMapper<String>() {

				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					makerIds.add(rs.getString("MAKER_ID"));
					return rs.getString("MAKER_ID");
					
				}
			});
		} catch (DataAccessException e) {
			LoggerUtil.ibsJobError("DataAccessException : MFI10001", e);
			return null;
		}
		return makerIds;
	}
	@Override
	public int getMakerVersion(AuditTrail<E> auditTrail) 
	{
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(auditTrail);
		LoggerUtil.ibsJobDebug("Query get maker  version-> "+ApplicationQuery.AUDTRL_QUERY_AUTHORIZED_VERSION);
		int result = 0;
		try {
			result =  jdbcTemplate.queryForInt(ApplicationQuery.AUDTRL_QUERY_AUTHORIZED_VERSION, namedParameters);
		} catch (DataAccessException e) {
			LoggerUtil.ibsJobError("DataAccessException : MFI10001", e);
			return result;
		}
		return result;
	}
	
	
	@Override
	public boolean isRecordOnceAuthorized(AuditTrail<E> entity) {
		int authorizedVersion = getMakerVersion(entity);
		return (authorizedVersion > 0);
	}
}