package com.bfsi.mfi.dao.jdbc;

import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.AgentDao;
import com.bfsi.mfi.entity.Agent;
import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.entity.Role;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgentVO;

@Repository("agentDao")
public class AgentJdbcDao extends MaintenanceJdbcDao<Agent> implements AgentDao {

	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	private static final String REG_STATUS = "R";
	private static int version_no = 0;
	private static String version = null, result = null;
	private static final String AUTHORISED_STATUS="A";
	private static final String ACTIVE_STATUS="A";
	private static final String SUB_SYSTEM_TYPE="M";
	
	private static final String UNREG_STATUS = "U";
	private static final String UNAUTHORISED_STATUS="U";

	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.AGENT_QUERY_INSERT;
	}

	@Override
	protected AgentMapper getRowMapper() {
		return new AgentMapper();
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.AGENT_QUERY_SELECT_ALL;
	}

	@Override
	protected String getUpdateQuery() {

		return ApplicationQuery.AGENT_QUERY_UPDATE;
	}

	public RowMapper<String> getVersionNoRowMapper() {
		return new VersionNoRowMapper();
	}

	private static final class VersionNoRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			String version_no = rs.getString(1);
			return version_no;
		}
	}

	public class ListComparator<T> {

		public Boolean compare(List<List<T>> a, List<List<T>> b) {
			if (a.size() != b.size()) {
				return false;
			}
			for (int i = 0; i < a.size(); i++) {
				if (a.get(i).size() != b.get(i).size()) {
					return false;
				}
				for (int k = 0; k < a.get(i).size(); k++) {
					if (!a.get(i).get(k).equals(b.get(i).get(k))) {
						return false;
					}
				}
			}
			return true;
		}
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

	public RowMapper<String> getAgentIDRowMapper() {
		return new AgentIDRowMapper();
	}

	public RowMapper<String> getAgentKeyRowMapper() {
		return new AgentKeyRowMapper();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agent> getAgendIdForAllocation() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return (List<Agent>) jdbcTemplate.queryForObject(ApplicationQuery.AGENT_QUERY_SELECT_AGENTID,
				params, getRowMapper());
	}

	@Override
	public String getAutoAgentId() {
		/*Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.queryForObject(ApplicationQuery.AGENT_QUERY_AGENT_AUTO_ID, params,
				new AgentIDRowMapper());*/
		String autoAgentId = getAutoGenFunCreateId(2); //Receive Agent ID from Function.
		return autoAgentId;
	}

	private static final class AgentIDRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			Agent agent = new Agent();
			String agentAutoID = rs.getString("AGENT_ID");
			String setID = null;
			String value = "00001";
			String codes = "AGT";

			if (agentAutoID == null || agentAutoID.equals("")) {
				setID = codes + value;
				agent.setId(setID);

			} else {
				String code = agentAutoID.substring(0, 3);
				String ActualId = agentAutoID.substring(3, 8);
				int ActualIdValue = Integer.parseInt(ActualId);
				int one = 1;
				int incrementId = ActualIdValue + one;
				String incrementIdValue = Integer.toString(incrementId);

				if (incrementIdValue.length() == 1) {
					setID = code + "0000" + incrementIdValue;
					agent.setId(setID);
				} else if (incrementIdValue.length() == 2) {
					setID = code + "000" + incrementIdValue;
					agent.setId(setID);
				} else if (incrementIdValue.length() == 3) {
					setID = code + "00" + incrementIdValue;
					agent.setId(setID);
				} else if (incrementIdValue.length() == 4) {
					setID = code + "0" + incrementIdValue;
					agent.setId(setID);
				} else {
					setID = code + incrementIdValue;
					agent.setId(setID);
				}
			}
			return setID;
		}
	}

	protected static final class AgentMapper implements RowMapper<Agent> {
		public Agent mapRow(ResultSet rs, int rowNum) throws SQLException {
			Agent agent = new Agent();
			agent.setId(rs.getString("AGENT_ID"));
			agent.setFname(rs.getString("FIRST_NAME"));
			agent.setLname(rs.getString("LAST_NAME"));
			agent.setCreditOfficer(rs.getString("CREDIT_OFFICER_ID"));
			agent.setDeviceId(rs.getString("DEVICE_ID"));
			agent.setDob(BaseJdbcDao.getUtilDate(rs.getDate("DATE_OF_BIRTH")));
			agent.setGender(rs.getString("GENDER"));
			agent.setIsActive(rs.getString("IS_ACTIVE"));
			agent.setAgentType(rs.getString("AGENT_TYPE"));
			agent.setCashLimit(rs.getLong("CASH_LIMIT"));
			agent.setCommAddr1(rs.getString("ADDRESS1"));
			agent.setCommAddr2(rs.getString("ADDRESS2"));
			agent.setCommAddr3(rs.getString("ADDRESS3"));
			agent.setCommAddr4(rs.getString("ADDRESS4"));
			agent.setContactNumber(rs.getString("CONTACT_NUMBER"));
			agent.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
			agent.setStartDate(BaseJdbcDao.getUtilDate(rs
					.getDate("AGENT_START_DATE")));
			agent.setEndDate(BaseJdbcDao.getUtilDate(rs
					.getDate("AGENT_END_DATE")));
			agent.setAgentLang(rs.getString("AGENT_PREFERED_LANG"));
			agent.setAgencyCode(rs.getString("AGENCY_CODE"));
			agent.setAuthStatus(rs.getString("AUTH_STATUS"));
			agent.setUserName(rs.getString("USER_NAME"));
			agent.setRegStatus(rs.getString("REG_STATUS"));
			agent.setRegKey(rs.getString("REG_KEY"));
			agent.setRegKeyExpiryTime(rs.getTimestamp("REG_KEY_EXPIRY_TIME"));
			agent.setZipCode(rs.getString("ZIP_CODE"));
			agent.setCity(rs.getString("CITY"));
			agent.setState(rs.getString("STATE"));
			agent.setCountry(rs.getString("COUNTRY"));
			agent.setLocationCode(rs.getString("LOCATION_CODE"));
			agent.setCbsagentcode(rs.getString("CBS_AGENT_CODE"));
			agent.setAgentAccId(rs.getString("AGENT_ACC_ID"));
			agent.setExternalDeviceId(rs.getString("EXTERNAL_DEVICEID"));
			
			return agent;
		}
	}

	protected static final class AgentDetailMapper implements RowMapper<Agent> {
		public Agent mapRow(ResultSet rs, int rowNum) throws SQLException {
			Agent agent = new Agent();
			agent.setId(rs.getString("AGENT_ID"));
			agent.setFname(rs.getString("FIRST_NAME"));
			agent.setLname(rs.getString("LAST_NAME"));
			agent.setCreditOfficer(rs.getString("CREDIT_OFFICER_ID"));
			agent.setDeviceId(rs.getString("DEVICE_ID"));
			agent.setDob(BaseJdbcDao.getUtilDate(rs.getDate("DATE_OF_BIRTH")));
			agent.setGender(rs.getString("GENDER"));
			agent.setIsActive(rs.getString("IS_ACTIVE"));
			agent.setAgentType(rs.getString("AGENT_TYPE"));
			agent.setCashLimit(rs.getLong("CASH_LIMIT"));
			agent.setCommAddr1(rs.getString("ADDRESS1"));
			agent.setCommAddr2(rs.getString("ADDRESS2"));
			agent.setCommAddr3(rs.getString("ADDRESS3"));
			agent.setCommAddr4(rs.getString("ADDRESS4"));
			agent.setContactNumber(rs.getString("CONTACT_NUMBER"));
			agent.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
			agent.setStartDate(BaseJdbcDao.getUtilDate(rs
					.getDate("AGENT_START_DATE")));
			agent.setEndDate(BaseJdbcDao.getUtilDate(rs
					.getDate("AGENT_END_DATE")));
			agent.setAgentLang(rs.getString("AGENT_PREFERED_LANG"));
			agent.setAgencyCode(rs.getString("AGENCY_CODE"));
			agent.setAuthStatus(rs.getString("AUTH_STATUS"));
			agent.setUserName(rs.getString("USER_NAME"));
			agent.setRegStatus(rs.getString("REG_STATUS"));
			agent.setRegKey(rs.getString("REG_KEY"));
			agent.setRegKeyExpiryTime(rs.getTimestamp("REG_KEY_EXPIRY_TIME"));
			agent.setZipCode(rs.getString("ZIP_CODE"));
			agent.setCity(rs.getString("CITY"));
			agent.setState(rs.getString("STATE"));
			agent.setCountry(rs.getString("COUNTRY"));
			agent.setLocationCode(rs.getString("LOCATION_CODE"));
			agent.setCbsagentcode(rs.getString("CBS_AGENT_CODE"));
			agent.setAgentAccId(rs.getString("AGENT_ACC_ID"));
			agent.setExternalDeviceId(rs.getString("EXTERNAL_DEVICEID"));
			
			return agent;
		}
	}

	@Override
	public boolean validateDeviceId(String uniqueId, String deviceId) {
		Map<String, String> params = new HashMap<String, String>();
         params.put("uniqueKey", uniqueId);
		params.put("deviceId", deviceId);
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(ApplicationQuery.QUERY_DEVICEID_VALID,
				params);
		return rowset.next();

	}

	// Rest agent registration
	@Override
	public void updateAgentWithDataKey(String agentId, String dataKey) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("agentId", agentId);
		params.put("dataKey", dataKey);
		jdbcTemplate.update(ApplicationQuery.QUERY_UPDATE_DATAKEY, params);
	}

	// Rest agent registration
	@Override
	public void updateAgentRegistConfirm(String agentId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("agentId", agentId);
		params.put("status", REG_STATUS);
		params.put("registKey", null);
		params.put("expTime", null);
		jdbcTemplate.update(ApplicationQuery.UPDATE_AGENT_STATUS, params);
	}

	public AgentVO generateRegKey(String id) {
		String key = generateRandomKey();
		AgentVO agent = new AgentVO();
		Map<String, String> param = new HashMap<String, String>();
		param.put(null, null);
		Date parsedDate;
		String expiryTime = jdbcTemplate.queryForObject(ApplicationQuery.QUERY_REGKEY_TIME,
				param, new AgentKeyRowMapper());
		try {
			SimpleDateFormat formater = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			parsedDate = formater.parse(expiryTime);
			Timestamp regKeyTime = new Timestamp(parsedDate.getTime());
			agent.setRegKeyExpiryTime(regKeyTime);
			agent.setRegKey(key);

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("key", key);
			params.put("expiryTime", agent.getRegKeyExpiryTime());
			params.put("id", id);

			jdbcTemplate.execute(ApplicationQuery.QUERY_INSERT_REGKEY, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
					});
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return agent;
	}

	private static final class AgentKeyRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			//String keyTime = rs.getString("PARAM_VALUE");  //comment this line for Integer Key value
			
			int expTime = rs.getInt("PARAM_VALUE");
			int hours = expTime / 60; //since both are ints, you get an int
			int minutes = expTime % 60;
			
			String keyTime = String.format("%d:%02d", hours, minutes);
			//System.out.println(keyTime);

			String result = "";
			int year, mm, dd, hh, min, ss, hour, minute;
			String[] keyValue = keyTime.split(":");
			hour = Integer.parseInt(keyValue[0]);
			minute = Integer.parseInt(keyValue[1]);

			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
				java.util.Date date = new java.util.Date();
				String dateValue = dateFormat.format(date);
				String[] parts = dateValue.split("-");

				year = Integer.parseInt(parts[0]);
				mm = Integer.parseInt(parts[1]);
				dd = Integer.parseInt(parts[2]);
				hh = Integer.parseInt(parts[3]);
				min = Integer.parseInt(parts[4]);
				ss = Integer.parseInt(parts[5]);
				hh = hh + hour;
				min = min + minute;

				if (min >= 60) {
					min = min - 60;
					hh = hh + 1;
				}
				result = year + "-" + mm + "-" + dd + " " + hh + ":" + min
						+ ":" + ss;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
	}

	// to generate Randow key for Agents
	public static String generateRandomKey() {
		final Random RANDOM = new SecureRandom();
		final int PASSWORD_LENGTH = 6;

		// String letters =
		// "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final String password_Values = "0123456789";

		String pw = "";
		for (int i = 0; i < PASSWORD_LENGTH; i++) {
			int index = (int) (RANDOM.nextDouble() * password_Values.length());
			pw += password_Values.substring(index, index + 1);
		}
		return pw;
	}

	public String generateTimestamp() {
		String result;
		int year, mm, dd, hh, min, ss;

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd-HH-mm-ss");
		java.util.Date date = new java.util.Date();
		String dateValue = dateFormat.format(date);
		String[] parts = dateValue.split("-");

		year = Integer.parseInt(parts[0]);
		mm = Integer.parseInt(parts[1]);
		dd = Integer.parseInt(parts[2]);
		hh = Integer.parseInt(parts[3]);
		min = Integer.parseInt(parts[4]);
		ss = Integer.parseInt(parts[5]);
		hh = hh + 02;
		min = min + 30;

		if (min >= 60) {
			min = min - 60;
			hh = hh + 1;
		}
		result = year + "-" + mm + "-" + dd + " " + hh + ":" + min + ":" + ss;
		return result;
	}

	// Rest agent registration
	@Override
	public Agent checkDataKeyAvailable(String agentId) {

		Agent agent = null;
		Map<String, String> params = new HashMap<String, String>();
		params.put("agentId", agentId);
		params.put("status", REG_STATUS);
		agent = jdbcTemplate.queryForObject(ApplicationQuery.QUERY_DATAKEY_AVIAL, params,
				new RowMapper<Agent>() {
					public Agent mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Agent agentObj = new Agent();
						agentObj.setDataValue(rs.getString("DATA_KEY"));
						return agentObj;
					}
				});
		return agent;
	}

	@Override
	public boolean isUserIdAvailable(String userId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", userId);
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(ApplicationQuery.QUERY_USER_ID_AVAILABLE,
				params);
		return !rowset.next();// true if there is no next, false if there is
								// next => user with given id
	}

	@Override
	public Agent getAgentByUserName(String id) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		try{
		return jdbcTemplate.queryForObject(ApplicationQuery.QUERY_SELECT_BY_USER, params,
				new AgentMapper());
		}
		catch(DataAccessException e){
			LoggerUtil.ibsJobError("DataAccessException : MFI10001", e);
			return null;
		}
	}

	@Override
	public String deleteAgent(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		version = jdbcTemplate.queryForObject(ApplicationQuery.AGENT_QUERY_AUDIT_VERSION, params,
				new VersionNoRowMapper());

		if (version == null) {
			version_no = 0;
		}
		if (version != null) {
			version_no = Integer.parseInt(version + 0);
		}

		if (version_no <= 1) {
			jdbcTemplate.execute(ApplicationQuery.AGENT_QUERY_DELETE, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
					});
			jdbcTemplate.execute(ApplicationQuery.AGENT_QUERY_DELETE_AUDIT, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
					});
			result = "success";
		}
		return result;
	}

	/*
	 * For Getting Authorised Agents in the Drop down
	 */
	@Override
	public List<Agent> getAuthorized() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.AGENT_QUERY_AUTHORIZED, params, getRowMapper());
	}

	@Override
	public List<Agent> getAuthAgentHavCreditOfficer() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.QUERY_AUTHORIZED_HAVING_CREDIT_OFFICER,
				params, getRowMapper());
	}

	@Override
	public Agent getAgentIdByUserName(String userName) {
		Agent agent = null;
		Map<String, String> params = new HashMap<String, String>();
		params.put("userName", userName);
		agent = jdbcTemplate.queryForObject(ApplicationQuery.QUERY_SELECT_AGENT_ID, params,
				new RowMapper<Agent>() {
					public Agent mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Agent agentObj = new Agent();
						agentObj.setId(rs.getString("AGENT_ID"));
						return agentObj;
					}
				});
		return agent;
	}
	
	@Override
	public List<Agent> getcountryCodes() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate
				.query(ApplicationQuery.AGENT_QUERY_COUNTRY_CODES, params, new AgentCountryCodeMapper());
	}
	
	// for country code
		protected static final class AgentCountryCodeMapper implements RowMapper<Agent> {
			public Agent mapRow(ResultSet rs, int rowNum) throws SQLException {
				Agent agent = new Agent();
				agent.setCountryCode(rs.getString("COUNTRY_CODE"));
				agent.setDescription(rs.getString("DESCRIPTION"));
				agent.setIso(rs.getString("ISO_NUM_COUNTRY_CODE"));
				return agent;
			}
		}

		@Override
		public int validateAgentForTransaction(AgentTransaction p_tran) {
			Map< String, String> l_params=new HashMap<String, String>();
			l_params.put("agentId", p_tran.getAgentId());
			l_params.put("deviceId", p_tran.getDeviceId());
			l_params.put("locCode", p_tran.getLocCode());
			l_params.put("regStatus", REG_STATUS);
			l_params.put("authStatus", AUTHORISED_STATUS);
			l_params.put("activeStatus", ACTIVE_STATUS);
			return	jdbcTemplate.queryForInt(ApplicationQuery.QUERY_AGENT_FOR_TRANS, l_params);
			
		}

		
		@Override
		public void addRolesToAgent(Agent agent) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("agentId", agent.getId());
			for (Role role : agent.getListRoles()) {
				params.put("roleId", role.getId());
				jdbcTemplate.execute(ApplicationQuery.USER_QUERY_INSERT_ROLES_AGENT, params,
						new PreparedStatementCallback<Object>() {
							@Override
							public Object doInPreparedStatement(
									PreparedStatement stmt) throws SQLException,
									DataAccessException {
								return stmt.executeUpdate();
							}
						});
			}
		}
		private static final class EntitlementMapper implements RowMapper<String> {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("ENTITLEMENT");
			}
		}
		
		@Override
		public List<String> getEntitlements(Agent agent) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", agent.getId());
			return jdbcTemplate.query(ApplicationQuery.USER_QUERY_AGENT_ENTITLEMENTS, params,
					new EntitlementMapper());
		}	

		@Override
		public List<String> getAgentRoles(String agentId) {
			// TODO Auto-generated method stub
			Map< String, String> l_params=new HashMap<String, String>();
			l_params.put("agentId", agentId);
			l_params.put("subSystemType", SUB_SYSTEM_TYPE);
			return jdbcTemplate.query(ApplicationQuery.AGENT_QUERY_MBS_ROLES, l_params, new AgentRoleMapper());
		}
		
		
		private static final class AgentRoleMapper implements RowMapper<String> {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {				
				return rs.getString("FUNC_ID");
			}
		}
		
		@Override
		public void addRolesToUser(Agent agent) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("agentId", agent.getId());
			for (Role role : agent.getListRoles()) {
				params.put("roleId", role.getId());
				//System.out.println(role.getId());
				jdbcTemplate.execute(ApplicationQuery.AGENT_QUERY_INSERT_ROLES_USERS, params,
						new PreparedStatementCallback<Object>() {
							@Override
							public Object doInPreparedStatement(
									PreparedStatement stmt) throws SQLException,
									DataAccessException {
								return stmt.executeUpdate();
							}
						});
			}
		}

		@Override
		public void deleteRolesToUser(Agent agent) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("agentId", agent.getId());
			jdbcTemplate.execute(ApplicationQuery.AGENT_QUERY_DELETE_ROLES_USERS, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(PreparedStatement stmt)
								throws SQLException, DataAccessException {
							return stmt.executeUpdate();
						}
					});
		}
		
		public void unregisterAgent(String p_agentId){
			
			Map<String, String> l_params=new HashMap<String, String>();
			l_params.put("agentId", p_agentId);
			l_params.put("authStatus", UNAUTHORISED_STATUS);
			l_params.put("regStatus", UNREG_STATUS);
			l_params.put("nullValue", null);
			
			jdbcTemplate.update(ApplicationQuery.AGENT_QUERY_UNREGISTER, l_params);
			
		}

		@Override
		public String getMacId(String p_agentId) {
			Map< String, String> l_params=new HashMap<String, String>();
			l_params.put("agentId", p_agentId);
			String macId = null;
			try {
				SqlRowSet rs = jdbcTemplate.queryForRowSet(ApplicationQuery.EXT_DEV_QUERY_SELECT_MAC_ID, l_params);	
				while(rs.next()){
					macId = rs.getString("MAC_ID");
				}
			} catch(DataAccessException e){
				LoggerUtil.ibsJobDebug("DataAccessException while get MacId : MFI10001", e);
			}
			return macId;
		}
		
		@Override
		public List<CbsCodes> getCbsAgentCode() {
			Map<String, String> params = new HashMap<String, String>();
			params.put(null, null);
			return jdbcTemplate
					.query(ApplicationQuery.AGENT_QUERY_CBSAGENTCODE_LOV, params, new CbsAgentCodeRowMapper());
		}	
		

		private static final class CbsAgentCodeRowMapper implements RowMapper<CbsCodes> {
			public CbsCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
				CbsCodes cbsCodes = new CbsCodes();

				cbsCodes.setDlValue(rs.getString("DL_VALUE"));
				cbsCodes.setDlDesc(rs.getString("DL_DESC"));

				return cbsCodes;
			}
		}
		
		
		@Override
		public List<Agent> getAgentIds(){
			Map<String, String> params = new HashMap<String, String>();
			params.put(null, null);
			return jdbcTemplate
					.query(ApplicationQuery.SELECT_AGENT_IDS, params,
					new RowMapper<Agent>() {
						public Agent mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							Agent agentObj = new Agent();
							agentObj.setId(rs.getString("AGENT_ID"));
							return agentObj;
						}
					});
			
		}

		@Override
		public String agentDataKey(String agentId) {
			Map<String, String> params=new HashMap<String, String>();
			params.put("agentId", agentId);
			
			return jdbcTemplate.queryForObject(ApplicationQuery.QUERY_AGENT_DATA_KEY, params, String.class);
			
			
		}
		
		
		
		
}