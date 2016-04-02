package com.bfsi.mfi.dao.jdbc;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CleanUpDao;
import com.bfsi.mfi.entity.CleanUp;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("cleanUpDao")
public class CleanUpJdbcDao extends MaintenanceJdbcDao<CleanUp> implements CleanUpDao {

	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.AGENT_QUERY_INSERT;
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.AGENT_QUERY_SELECT_ALL;
	}

	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.AGENT_QUERY_UPDATE;
	}

		@Override
	protected String getDeleteQuery() {
		return ApplicationQuery.AGENT_QUERY_DELETE;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.AGENT_QUERY_SELECT_BY_PK;
	}

	@Override
	protected String getUpdateByAuthQuery() {
		return ApplicationQuery.AGENT_QUERY_UPDATE_BY_AUTH;
	}


	@Override
	protected RowMapper<CleanUp> getRowMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}