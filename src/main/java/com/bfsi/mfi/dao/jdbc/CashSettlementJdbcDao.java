package com.bfsi.mfi.dao.jdbc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CashSettlementDao;
import com.bfsi.mfi.dao.jdbc.BaseJdbcDao.ProcHandler;
import com.bfsi.mfi.entity.Agent;
import com.bfsi.mfi.entity.Cash;
import com.bfsi.mfi.entity.Till;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("cashSettlementDao")
public class CashSettlementJdbcDao extends MaintenanceJdbcDao<Cash> implements
		CashSettlementDao {

	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	private static String version = null;
	private static int version_no = 0;
	private static String SUCCESS = "success", FAILURE = "failure", response;
	
	private static final class VersionNoRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			String version_no = rs.getString(1);
			return version_no;
		}
	}

	public RowMapper<String> getVersionNoRowMapper() {
		return new VersionNoRowMapper();
	}

	@Override
	protected String getInsertQuery() { 
		return ApplicationQuery.CASHSETTLE_QUERY_INSERT;
	}

	@Override
	protected RowMapper<Cash> getRowMapper() {
		return new CashMapper();
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.CASHSETTLE_QUERY_SELECT_ALL;
	}

	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.CASHSETTLE_QUERY_UPDATE;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.CASHSETTLE_QUERY_SELECT_BY_PK;
	}

	@Override
	protected String getDeleteQuery() {
		return ApplicationQuery.CASHSETTLE_QUERY_DELETE; 
	}

	@Override
	protected String getUpdateByAuthQuery() {
		return ApplicationQuery.CASHSETTLE_QUERY_UPDATE_BY_AUTH;
	}


	private static final class CashMapper implements RowMapper<Cash> {

		public Cash mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			Cash cash = new Cash();
		
			cash.setId(rs.getString("TILL_ID"));
			cash.setAgentId(rs.getString("AGENT_ID"));
			cash.setTxnCode(rs.getString("TXN_CODE"));
		    cash.setCurrencyCode(rs.getString("TXN_CCY_CODE"));
		    cash.setCashAmount(rs.getDouble("CASH_AMOUNT"));
		    cash.setTxnRemarks(rs.getString("TXN_REMARKS"));
		    cash.setIsActive(rs.getString("IS_ACTIVE"));
		    cash.setAuthStatus(rs.getString("AUTH_STAT"));
		    cash.setInitByUserId(rs.getString("INIT_BY_USER_ID"));
		    cash.setVerifyByUserId(rs.getString("VERIFY_BY_USER_ID"));
		    cash.setTxnInitDatetime(rs.getDate("TXN_INTI_DATETIME"));
		    cash.setTxnAuthDatetime(rs.getDate("TXN_AUTH_DATETIME"));
		    
			return cash;
		}
	}

	private static final class TillIdMapper implements RowMapper<Till> {

		public Till mapRow(ResultSet rs, int rowNum) throws SQLException {
			Till till = new Till();
			till.setTillId(rs.getString("TILL_ID"));
			till.setCcyCode(rs.getString("CCYCODE"));
			return till;
		}
	}
	

	private static final class AgentValidationRowMapper implements
			RowMapper<Agent> {
		@Override
		public Agent mapRow(ResultSet rs, int rowNum) throws SQLException {
			Agent agent = new Agent();
			agent.setIsActive(rs.getString("IS_ACTIVE"));
			agent.setStartDate(rs.getDate("AGENT_START_DATE"));
			agent.setEndDate(rs.getDate("AGENT_END_DATE"));
			return agent;
		}
	}

	@Override
	public Agent getAgentForValidation(String agentId) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("agentId", agentId);
		try {
			return jdbcTemplate.queryForObject(ApplicationQuery.CASHSETTLE_QUERY_SELECT_AGENT_DETAILS,
					params, new AgentValidationRowMapper());

		} catch (DataAccessException e) {
			LoggerUtil.ibsJobError("DataAccessException : MFI10001", e);
			return null;
		}
	}

	
	@Override
	public boolean isRecordAuthorised(String tillId) {

		String sql = ApplicationQuery.CASHSETTLE_QUERY_RECORD_STATUS;
		Map<String, String> params = new HashMap<String, String>();
		params.put("tillId", tillId);
		
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(sql, params);
			//System.out.println("***********"+!rowset.next());
			return !rowset.next();// true if there is no next, false if there is
									// next => role with given roleName
	}
	
	//delete cash settlement base on id.
	@Override
	public String deleteCashSettlement(String id){
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		version = jdbcTemplate.queryForObject(ApplicationQuery.CASHSETTLE_QUERY_AUDIT_VERSION, params,
				new VersionNoRowMapper());

		if (version == null) {
			version_no = 0;
		}
		if (version != null) {
			version_no = Integer.parseInt(version + 0);
		}
		if (version_no <= 1) {
			jdbcTemplate.execute(ApplicationQuery.CASHSETTLE_QUERY_DELETE_CASHSETTLEMENT, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
					});
			jdbcTemplate.execute(ApplicationQuery.CASHSETTLE_QUERY_DELETE_AUDIT, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
					});
		}
		return SUCCESS;
	}
	
	
	@Override
	public List<Till> getTillIds()  throws ServiceException
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.CASHSETTLE_QUERY_SELECT_TILLID, params, new TillIdMapper());
		
	}
	
	public RowMapper<String> getTillIDRowMapper() {
		return new TillIDRowMapper();
	}

	@Override
	public String getAutoTillId() {
		/*Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.queryForObject(ApplicationQuery.CASHSETTLE_QUERY_TILL_ID, params,
				new TillIDRowMapper());*/
		String autoId = getAutoGenFunCreateId(3); //Receive Cash Till ID from Function.
		return autoId;
		
	}

	private static final class TillIDRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			//Agent agent = new Agent();
			String cashAutoID = rs.getString("TILL_ID");
			String setID = null;
			String value = "00001";
			String codes = "CASH";

			if (cashAutoID == null || cashAutoID.equals("")) {
				setID = codes + value;
				//agent.setId(setID);

			} else {
				String code = cashAutoID.substring(0, 4);
				//System.out.println(code);
				String actualId = cashAutoID.substring(4, 9);
				//System.out.println(actualId);
				int ActualIdValue = Integer.parseInt(actualId);
				int one = 1;
				int incrementId = ActualIdValue + one;
				String incrementIdValue = Integer.toString(incrementId);

				if (incrementIdValue.length() == 1) {
					setID = code + "0000" + incrementIdValue;
					//agent.setId(setID);
				} else if (incrementIdValue.length() == 2) {
					setID = code + "000" + incrementIdValue;
					//agent.setId(setID);
				} else if (incrementIdValue.length() == 3) {
					setID = code + "00" + incrementIdValue;
					//agent.setId(setID);
				} else if (incrementIdValue.length() == 4) {
					setID = code + "0" + incrementIdValue;
					//agent.setId(setID);
				} else {
					setID = code + incrementIdValue;
					//agent.setId(setID);
				}
			}
			return setID;
		}
	}

	@Override
	public String addRecordtoCustomer(String id) {
		Map<String, Object> l_procRes=null;
		ProcHandler procHandler= new ProcHandler(ApplicationQuery.FN_APP_ADD_RECORD);
		String type="M";
		procHandler.registerOutputParam("result", Types.NUMERIC);
		procHandler.registerInputParam("p_till_id", id, Types.VARCHAR); 
		procHandler.registerInputParam("p_till_type", type, Types.VARCHAR); 
		
		l_procRes = procHandler.execute(true);
		
		BigDecimal result =  (BigDecimal) l_procRes.get("result");
		//System.out.println("resp ================================================ " + result);
		int value = result.intValue();
		if(value == 0)
		{
			response = SUCCESS;
		}
		else
		{
			response = FAILURE;
		}
		return response;
	}

}


