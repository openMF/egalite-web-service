package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.ErrorCodeDao;
import com.bfsi.mfi.entity.ErrorCode;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("errorCodeDao")
public class ErrorCodeJdbcDao extends MaintenanceJdbcDao<ErrorCode> implements
		ErrorCodeDao {

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.ERRORCODE_QUERY_SELECT_ALL;
	}

	@Override
	protected String getSelectByPkQuery() {

		return ApplicationQuery.ERRORCODE_QUERY_SELECT_BY_PK;

	}
	
	@Override
	protected RowMapper<ErrorCode> getRowMapper() {
		return new ErrorCodeMapper();
	}


	private static final class ErrorCodeMapper implements RowMapper<ErrorCode> {

		public ErrorCode mapRow(ResultSet rs, int rowNum) throws SQLException {
			ErrorCode errCode = new ErrorCode();
			errCode.setId(rs.getString("MSG_CODE"));
			errCode.setLang(rs.getString("LANG"));
			errCode.setMsgDesc(rs.getString("MSG_DESC"));
			errCode.setErrType(rs.getString("ERR_TYPE"));
			errCode.setSubSys(rs.getString("SUB_SYS"));
			errCode.setMsgType(rs.getString("MSG_TYPE"));
			return errCode;
		}
	}


	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
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

}
