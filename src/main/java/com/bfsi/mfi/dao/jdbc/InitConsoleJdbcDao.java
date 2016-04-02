package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.InitConsoleDao;
import com.bfsi.mfi.entity.EgaCharter;
import com.bfsi.mfi.entity.InitConsole;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("initConsoleDao")
public class InitConsoleJdbcDao extends MaintenanceJdbcDao<InitConsole> implements InitConsoleDao {

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
	protected RowMapper<InitConsole> getRowMapper() {
		return new InitConsoleMapper();
	}	
	
	protected RowMapper<InitConsole> getInitConsoleMapper() {
		return new InitConsoleMapper();
	}	
	
	private static final class InitConsoleMapper implements RowMapper<InitConsole> 
	{
		public InitConsole mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			InitConsole console = new InitConsole();
			
			return console;
		}
	}

	@Override
	public String cbcConsoleText(String id) {
		String text = "";
		try {
			Map<String, String> params = new HashMap<String, String>();	
			params.put("id", id);
			SqlRowSet rowset = jdbcTemplate.queryForRowSet(ApplicationQuery.CONSOLE_TEXT_VALUE,
					params);
			if(rowset!=null && rowset.next()){				
				text = rowset.getString("DL_DESC");
				//select DL_DESC from MFI_CONSOL_TEXT_BASE where TEXT_ID =:tdesc;
			}
		} catch(Exception e){
			LoggerUtil.cbsJobError("Unhandeled Exception while get App Date Today : MFI10001", e);
		}	
		return text;
	}

	@Override
	public Map<String,String> getJobStatus() {
		String status = "";
		String charterCode ="";		 
		Map<String,String> jobStatus = new HashMap<String, String>();
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			ResourceBundle msg = context.getApplication().evaluateExpressionGet(context, "#{msg}", ResourceBundle.class);	
			Map<String, String> params = new HashMap<String, String>();				
			SqlRowSet rowset = jdbcTemplate.queryForRowSet(ApplicationQuery.CONSOLE_TEXT_JOB_STATUS,
					params);
			while(rowset!=null && rowset.next()){	
				charterCode = rowset.getString("CHARTER_CODE");
				status = rowset.getString("RUN_STATUS");
				if(status.equalsIgnoreCase("C")){
					status = msg.getString("job.completed.status");
					
				} else if(status.equalsIgnoreCase("R")){
					status = msg.getString("job.running.status");
					
				} else if(status.equalsIgnoreCase("N")){
					status = msg.getString("job.pending.status");
					
				} else {
					status = "";
				}				
				jobStatus.put(charterCode, status);				
			}			
		} catch(Exception e){
			LoggerUtil.cbsJobError("Unhandeled Exception while get Job Status : MFI10001", e);
		}	
		return jobStatus;
	}
	
	
	
	public EgaCharter getRunHasStatus(String charCode){
		Map<String, String> params = new HashMap<String, String>();	
		params.put("charCode", charCode);
		String sql = ApplicationQuery.CONSOLE_RUN_HAS;
		try {
			return jdbcTemplate.queryForObject(sql, params,  new hasRunMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static final class hasRunMapper implements RowMapper<EgaCharter> {
		public EgaCharter mapRow(ResultSet rs, int rowNum) throws SQLException {
			EgaCharter egaCharter = new EgaCharter();
			
			egaCharter.setRunStatus(rs.getString("RUN_STATUS"));
			egaCharter.setHasError(rs.getString("HAS_ERROR"));
			
			return egaCharter;
		}
	}
	
}