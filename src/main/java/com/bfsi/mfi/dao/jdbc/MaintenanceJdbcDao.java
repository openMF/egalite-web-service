package com.bfsi.mfi.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.bfsi.mfi.dao.AuditTrailDao;
import com.bfsi.mfi.dao.MaintenanceDao;
import com.bfsi.mfi.entity.AuditTrail;
import com.bfsi.mfi.entity.MaintenanceEntity;
import com.bfsi.mfi.util.LoggerUtil;

/**
 * @author arun
 * @param <T>
 */

public abstract class MaintenanceJdbcDao<T extends MaintenanceEntity> extends
		BaseJdbcDao implements MaintenanceDao<T> {
	@Autowired
	private AuditTrailDao<T> auditTrailDao;

	@Override
	public T create(T entity) {
		AuditTrail<T> auditTrail = new AuditTrail<T>(entity);
		auditTrail.setVersion(1);

		/*
		 * OracleLobHandler lobHandler=new OracleLobHandler();
		 * lobHandler.setNativeJdbcExtractor(new SimpleNativeJdbcExtractor());
		 * if(auditTrail.getObjectXml()!=null) { SqlLobValue clob=new
		 * SqlLobValue(auditTrail.getObjectXml(), lobHandler);
		 * System.out.println("clob1 = "+clob.hashCode());
		 * System.out.println("clob1 = "+clob.toString());
		 * System.out.println("clob1 = "+clob.getClass()); }
		 * System.out.println("object XML = "+auditTrail.getObjectXml());
		 */

		auditTrailDao.auditCreate(auditTrail);
		String sql = getInsertQuery();
		//LoggerUtil.ibsJobDebug("Query create ->"+sql);
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				entity);
		jdbcTemplate.execute(sql, namedParameters,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});
		return entity;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<T> get() {
		String sql = getSelectAllQuery();
		//LoggerUtil.ibsJobDebug("Query get All ->"+sql );
		return jdbcTemplate.query(sql, (Map) null, getRowMapper());
	}

	@Override
	public T get(String id) {
		String sql = getSelectByPkQuery();
		Map<String, String> params = new HashMap<String, String>();
		//LoggerUtil.ibsJobDebug("Query get by PK ->"+sql +" Params -> "+id);
		params.put("id", id);
		try {
			return jdbcTemplate.queryForObject(sql, params, getRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected String getSelectByPkQuery() {
		return "";
	}

	@Override
	public T update(T entity) {
		AuditTrail<T> auditTrail = new AuditTrail<T>(entity);
		auditTrail.setVersion(auditTrailDao.getMaxVersion(entity) + 1);

		// retrieve the previous version currently existing in the maintenance
		// table to include in audit trail as XML

		T oldEntity = get(entity.getId());

		auditTrail.setObjectXml(AuditTrail.getObjectXmlFromEntity(oldEntity));

		auditTrailDao.auditUpdate(auditTrail);

		String sql = getUpdateQuery();
		//LoggerUtil.ibsJobDebug("Query update ->"+sql );
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				entity);
		jdbcTemplate.execute(sql, namedParameters,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});
		return entity;
	}

	@Override
	public T authorize(T entity) {
		AuditTrail<T> auditTrail = new AuditTrail<T>(entity);
		auditTrailDao.auditAuth(auditTrail);

		String sql = getUpdateByAuthQuery();
		//LoggerUtil.ibsJobDebug("Query authorize ->"+sql);
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				entity);
		jdbcTemplate.execute(sql, namedParameters,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});
		return entity;
	}

	@Override
	public T delete(T entity) {
		AuditTrail<T> auditTrail = new AuditTrail<T>(entity);
		auditTrail.setVersion(auditTrailDao.getMaxVersion(entity) + 1);
		auditTrail.setObjectXml(AuditTrail.getObjectXmlFromEntity(entity));
		auditTrailDao.auditUpdate(auditTrail);

		String sql = getDeleteQuery();
		//LoggerUtil.ibsJobDebug("Query delete ->"+sql);
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				entity);
		jdbcTemplate.execute(sql, namedParameters,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});
		return entity;
	}

	/**
	 * Insert statement for the underlying table parameterized with individual
	 * attribute names
	 * 
	 * @return
	 */
	protected abstract String getInsertQuery();

	/**
	 * @return
	 */
	protected abstract String getSelectAllQuery();

	/**
	 * @return
	 */

	protected abstract RowMapper<T> getRowMapper();

	protected abstract String getUpdateQuery();

	protected abstract String getDeleteQuery();

	protected String getUpdateByAuthQuery() {
		return getUpdateQuery();
	}

}
