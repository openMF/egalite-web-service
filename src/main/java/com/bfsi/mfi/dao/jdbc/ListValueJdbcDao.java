package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.ListValueDao;
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("listValueDao")
public class ListValueJdbcDao extends BaseJdbcDao implements ListValueDao {

	@Override
	public List<ListValue> get(String listName) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("listName", listName);
		return jdbcTemplate.query(ApplicationQuery.LOV_QUERY_SELECT_BY_PK, params, getRowMapper());
	}

	protected ListMapper getRowMapper() {
		return new ListMapper();
	}

	private static final class ListMapper implements RowMapper<ListValue> {
		public ListValue mapRow(ResultSet rs, int rowNum) throws SQLException {
			ListValue lov = new ListValue();
			lov.setListName(rs.getString("LIST_NAME"));
			lov.setListValue(rs.getString("LIST_VALUE"));
			lov.setDesn(rs.getString("DESN"));
			return lov;
		}
	}

	@Override
	public String getValue(String id, String listName) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("value", id);
		params.put("listName", listName);
		return jdbcTemplate.queryForObject(ApplicationQuery.LOV_QUERY_SELECT_BY_ID, params, new EntitlementMapper());
	}
	
	private static final class EntitlementMapper implements RowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString(1);
		}
	}
}