package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.ReferenceCodeDao;
import com.bfsi.mfi.entity.RefCode;
import com.bfsi.mfi.query.ApplicationQuery;

/**
 * @author Bablu kumar
 *
 */
@Repository("referenceCodeDao")
public class ReferenceCodeJdbcDao extends MaintenanceJdbcDao<RefCode> implements
		ReferenceCodeDao {



	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.REFCODE_QUERY_SELECT_ALL;
	}


	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.REFCODE_QUERY_SELECT_BY_PK;
	}

	@Override
	protected String getUpdateByAuthQuery() {
		return ApplicationQuery.REFCODE_QUERY_UPDATE_BY_AUTH;
	}
	
	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.REFCODE_QUERY_INSERT;
	}
	
	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.REFCODE_QUERY_UPDATE;
	}
	
	private static final class VersionNoRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			String version_no=rs.getString(1);
			return version_no;
		}
	}
	public RowMapper<String> getVersionNoRowMapper() {
		return new VersionNoRowMapper();
	}
	
	@Override
	protected RowMapper<RefCode> getRowMapper() {
		return new ReferenceCodeMapper();
	}

	private static final class ReferenceCodeMapper implements RowMapper<RefCode> {
		public RefCode mapRow(ResultSet rs, int rowNum) throws SQLException {
			RefCode refCode = new RefCode();
			refCode.setId(rs.getString("REF_MASTER_CODE"));
			refCode.setCodeDesc(rs.getString("CODE_DESC"));
			refCode.setPurpose(rs.getString("PURPOSE"));
			refCode.setValidRef(rs.getString("IS_VALID"));
			refCode.setAuthStatus(rs.getString("AUTH_STATUS"));
			return refCode;
		}
	}
	
	@Override
	public List<RefCode> getAuthorized() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}
	
}