package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CbsDropListDao;
import com.bfsi.mfi.entity.CbsDropList;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("cbsDropListDao")
public class CbsDropListJdbcDao extends MaintenanceJdbcDao<CbsDropList> implements CbsDropListDao {

	private static String success ="SUCCESS";
	private static String failure ="FAILURE";
	
	@Override
	protected RowMapper<CbsDropList> getRowMapper() {
		// TODO Auto-generated method stub
		return new AgendaMapper();
	}
	
	@Override
	public String getCbsDropListValues(List<CbsDropList> cbsDropList) {
		String resp = null;
		try {
			SqlParameterSource[] l_params = new SqlParameterSource[cbsDropList.size()];
			for (int l_i = 0; l_i < cbsDropList.size(); l_i++) {
				l_params[l_i] = new BeanPropertySqlParameterSource(cbsDropList.get(l_i));
			}
			jdbcTemplate.batchUpdate(ApplicationQuery.QUERY_INSERT_CBS_DROP_LIST, l_params);
					
			Map<String, Object> l_procRes=null;
			ProcHandler procHandler= new ProcHandler(ApplicationQuery.INSERT_STG_TO_CBS_DROPLIST);
			procHandler.registerOutputParam("return", Types.NUMERIC);
			l_procRes = procHandler.execute(true);
			int response =  (Integer) l_procRes.get("result");
			
			if(response == 0) {
				resp = success;
			}
			else {
				resp = failure;
			}
		} catch (Exception e) {
			resp = failure;
		}
		return resp;		
	}

	private static final class AgendaMapper implements RowMapper<CbsDropList> {
		public CbsDropList mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsDropList agenda = new CbsDropList();
			
			return agenda;
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