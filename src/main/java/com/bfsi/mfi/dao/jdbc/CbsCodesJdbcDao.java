package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CbsCodesDao;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("cbsCodesDao")
public class CbsCodesJdbcDao extends MaintenanceJdbcDao<CbsCodes> implements
		CbsCodesDao {

	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.CBSCOCODES_QUERY_SELECT_ALL;
	}

	@Override
	protected RowMapper<CbsCodes> getRowMapper() {

		return new CbsCodesMapper();
	}

	private static final class CbsCodesMapper implements RowMapper<CbsCodes> {
		public CbsCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsCodes cbsCodes = new CbsCodes();

			cbsCodes.setDlValue(rs.getString("DL_VALUE"));
			cbsCodes.setDlDesc(rs.getString("DL_DESC"));

			return cbsCodes;
		}
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

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CbsCodes> getCbsLocationCodes() {
		String sql =ApplicationQuery.CBSlOCCODES_QUERY_SELECT_ALL;
		return jdbcTemplate.query(sql, (Map) null, new CbsCodesMapper());
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CbsCodes> getCbsBranchCodes() {
		String sql =ApplicationQuery.CBSBRNCODES_QUERY_SELECT_ALL;
		return jdbcTemplate.query(sql, (Map) null, new CbsCodesMapper());
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CbsCodes> getCbsRouteCodes() {
		String sql =ApplicationQuery.CBSROUTECODES_QUERY_SELECT_ALL;
		return jdbcTemplate.query(sql, (Map) null, new CbsCodesMapper());
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CbsCodes> getCbsCenterCodes() {
		String sql =ApplicationQuery.CBSCENTERCODES_QUERY_SELECT_ALL;
		return jdbcTemplate.query(sql, (Map) null, new CbsCodesMapper());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CbsCodes> getCbsAgentCodes() {
		String sql =ApplicationQuery.CBSAGENTCODES_QUERY_SELECT_ALL;
		return jdbcTemplate.query(sql, (Map) null, new CbsCodesMapper());
	}
	
	
	
	
}
