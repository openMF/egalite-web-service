package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.LovDao;
import com.bfsi.mfi.entity.LovDetail;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

/**
 * 
 * @author Vishal
 *
 */
@Repository
public class LovJdbcDao  extends MaintenanceJdbcDao<LovDetail> implements LovDao {
	private static final String IS_ACTIVE = "A";
	private static final String AUTH_STATUS = "A";
	@Override
	public List<LovDetail> getLovDetails() {
		Map<String, String> l_params=new HashMap<String, String>();
		try {		
			l_params.put("isActive", IS_ACTIVE);
			l_params.put("authStatus", AUTH_STATUS);
			List<LovDetail> l_lovList = jdbcTemplate.query(ApplicationQuery.QUERY_LOV_LIST,
						l_params, getRowMapper());
			return l_lovList == null?new ArrayList<LovDetail>():l_lovList;
		} catch (DataAccessException e) {
			LoggerUtil.mbsJobError("DataAccessException while extracting lov Details :MFI10001 ", e);
			return null;
		} catch (Exception e) {
			LoggerUtil.mbsJobError("Unhandeld Exception while extracting lov Details :MFI10001 ", e);
			return null;
		}
		
	}

	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectAllQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected RowMapper<LovDetail> getRowMapper() {
		// TODO Auto-generated method stub
		return new LovMapper();
	}

	@Override
	protected String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}


	private static final class LovMapper implements RowMapper<LovDetail> {
		public LovDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
			LovDetail lov = new LovDetail();			
			lov.setLovId(rs.getString("LOV_ID"));
			lov.setIntrValue(rs.getString("INTERNAL_VALUE"));
			lov.setDisplayValue(rs.getString("DISPLAY_VALUE"));
			lov.setOrderBy(rs.getInt("ORDER_BY"));
			return lov;
		}
	}

}

