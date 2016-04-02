package com.bfsi.mfi.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.bfsi.mfi.dao.ReadOnlyMaintenanceDao;
import com.bfsi.mfi.entity.MaintenanceEntity;

/**
 * 
 * @author Nirmal kanna S
 * 
 * @param <T>
 */
public abstract class ReadOnlyMaintenanceJdbcDao<T extends MaintenanceEntity>
		extends BaseJdbcDao implements ReadOnlyMaintenanceDao<T> {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> get() {
		String sql = getSelectAllQuery();
		return jdbcTemplate.query(sql, (Map) null, getRowMapper());
	}

	protected abstract String getSelectAllQuery();

	/* protected abstract String getSelectByPkQuery(); */
	/**
	 * @return
	 */

	protected abstract RowMapper<T> getRowMapper();

	public T get(String id) {
		String sql = getSelectByPkQuery();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		return jdbcTemplate.queryForObject(sql, params, getRowMapper());
	}

	protected String getSelectByPkQuery() {
		return "";
	}

}
