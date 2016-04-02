package com.bfsi.mfi.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.UserDao;
import com.bfsi.mfi.entity.AuditTrail;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.entity.Role;
import com.bfsi.mfi.entity.User;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

/**
 * DAO for user entity
 * 
 * @author Nirmal kanna S
 */

@Repository("userDao")
public class UserJdbcDao extends MaintenanceJdbcDao<User> implements UserDao 
{
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	private static String version = null, success = "success";
	private static int version_no = 0 , resp = 0; ;
	private User user = new User();
	
	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.USER_QUERY_INSERT;
	}

	@Override
	protected RowMapper<User> getRowMapper() {
		return new UserMapper();
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.USER_QUERY_SELECT_ALL;
	}

	@Override
	protected String getUpdateByAuthQuery() {
		return ApplicationQuery.USER_QUERY_UPDATE_BY_AUTH;
	}

	@Override
	protected String getDeleteQuery() {
		return ApplicationQuery.USER_QUERY_DELETE;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.USER_QUERY_SELECT_BY_PK;
	}

	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.USER_QUERY_UPDATE;
	}

	public RowMapper<String> getVersionNoRowMapper() {
		return new CommonSingleValueRowMapper();
	}

	/**
	 * Maps User record from result set to user entity object
	 * 
	 * @author arun
	 */
	private static final class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getString("USER_ID"));
			user.setFirstName(rs.getString("FIRST_NAME"));
			user.setLastName(rs.getString("LAST_NAME"));
			user.setBranchCode(rs.getString("BRANCH_CODE"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setUserType(rs.getString("USER_TYPE"));
			user.setUserStatus(rs.getString("USER_STATUS"));
			user.setStartDate(rs.getDate("START_DATE"));
			user.setEndDate(rs.getDate("END_DATE"));
			user.setAuthStatus(rs.getString("AUTH_STATUS"));
			user.setLastLoginDate(rs.getTimestamp("LAST_LOGIN_DATE"));
			user.setCbsCoCode(rs.getString("CBS_CO_CODE"));
			return user;
		}
	}

	@Override
	public List<String> getEntitlements(User user) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", user.getId());
		return jdbcTemplate.query(ApplicationQuery.USER_QUERY_USER_ENTITLEMENTS, params, new EntitlementMapper());
	}

	/**
	 * Fetches list of entitlements from resultset
	 * 
	 * @author arun
	 */

	private static final class EntitlementMapper implements RowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("ENTITLEMENT");
		}
	}

	@Override
	public boolean isUserIdAvailable(String userId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", userId);
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(ApplicationQuery.USER_QUERY_USER_ID_AVAILABLE, params);
		return !rowset.next();// true if there is no next, false if there is
								// next => user with given id
	}

	@Override
	public boolean isPasswordValid(String id, String password) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		String existPaswd = jdbcTemplate.queryForObject(ApplicationQuery.USER_QUERY_PASSWORD_USER,
				params, new CommonSingleValueRowMapper());
		boolean bresponse;

		if (password.equals(existPaswd)) {
			bresponse = true;
		} else {
			bresponse = false;
		}
		return bresponse;
	}

	private static final class CommonSingleValueRowMapper implements
			RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			String value = rs.getString(1);
			return value;
		}
	}

	private static final class CommonSingleRowMapper implements RowMapper<Integer> 
	{
		@Override
		public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
			int value = rs.getInt(1);
			return value;
		}
	}
	
	@Override
	public void addRolesToUser(User user) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", user.getId());
		for (Role role : user.getListRoles()) {
			params.put("roleId", role.getId());
			jdbcTemplate.execute(ApplicationQuery.USER_QUERY_INSERT_ROLES_USERS, params,
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
	public void deleteRolesToUser(User user) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", user.getId());
		jdbcTemplate.execute(ApplicationQuery.USER_QUERY_DELETE_ROLES_USERS, params,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});
	}

	@Override
	public String deleteUser(String id) {
		Map<String, String> params = new HashMap<String, String>();		
		params.put("id", id);
		version = jdbcTemplate.queryForObject(ApplicationQuery.USER_QUERY_AUDIT_VERSION, params,
				new CommonSingleValueRowMapper());

		if (version == null) {
			version_no = 0;
		}

		if (version != null) {
			version_no = Integer.parseInt(version);
		}

		if (version_no >= 1) {
			jdbcTemplate.execute(ApplicationQuery.USER_QUERY_DELETE_USER_ROLES, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
					});

			jdbcTemplate.execute(ApplicationQuery.USER_QUERY_DELETE_USER, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
					});

			jdbcTemplate.execute(ApplicationQuery.USER_QUERY_DELETE_AUDIT, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
					});
		}
		return success;
	}

	@Override
	public void updateInvalidLoginAttempt(String id) throws DataAccessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		if(!id.equalsIgnoreCase("SU"))
		{
			jdbcTemplate.execute(ApplicationQuery.USER_QUERY_UPDATE_INVALID_LOGIN_COUNT, params,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});
		}
	}

	@Override
	public Integer lockUser(String id, int maxFailedLoginCount)
			throws DataAccessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("maxFailedLoginCount", maxFailedLoginCount);
		if(!id.equalsIgnoreCase("SU"))
		{
			
			resp = jdbcTemplate.execute(ApplicationQuery.USER_QUERY_LOCK_USER, params,
				new PreparedStatementCallback<Integer>() {
					@Override
					public Integer doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});
		}
		return resp;
	}

	@Override
	public List<User> getCreditOfficers() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate
				.query(ApplicationQuery.USER_QUERY_CREDIT_OFFICERS, params, getRowMapper());
	}

	@Override
	public void updateLastLoggedIn(String userName, Date lastloggedTime) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		params.put("lastloggedTime", lastloggedTime);
		jdbcTemplate.update(ApplicationQuery.USER_QUERY_UPDATE_LOGIN_TIME, params);
	}

	@Override
	public void resetPassword(String id, String pswd)
			throws DataAccessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("pswd", pswd);
		jdbcTemplate.update(ApplicationQuery.USER_QUERY_RESET_USER, params);
		
	}

	@Override
	public void changePassword(String id, String pswd)
			throws DataAccessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("pswd", pswd);
		jdbcTemplate.update(ApplicationQuery.USER_QUERY_PSWDCHG_USER, params);
		
	}
	
	@Override
	public String unLockUser(String id) throws ServiceException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		jdbcTemplate.update(ApplicationQuery.USER_QUERY_UNLOCK_USER, params);
		return success;
	}

	@Override
	public Integer noOfFailedLogins(String id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		int value = jdbcTemplate.queryForObject(ApplicationQuery.USER_QUERY_NOOFFAILED_LOGINS, params,new CommonSingleRowMapper());
		return value;
	}
	
	public RowMapper<String> getRolesRowMapper() {
		return new RolesRowMapper();
	}

	private static final class RolesRowMapper implements RowMapper<String> 
	{
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			String user_role = rs.getString(1);
			return user_role;
		}
	}
	
	@Override
	public boolean isRoleAuthorized(String id) 
	{
		boolean response = false;
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		List<String> userRoles = new ArrayList<String>();  
		List<String> listAuthRole = new ArrayList<String>();
		
		userRoles = jdbcTemplate.query(ApplicationQuery.USER_QUERY_USERROLE, params, new RolesRowMapper());
		listAuthRole = jdbcTemplate.query(ApplicationQuery.USER_QUERY_AUTH_USERROLE, Collections.singletonMap("roleId", userRoles), new RolesRowMapper());
			
		if(!listAuthRole.contains("U"))
		{
			response = true;
		}
		return response;
	}

	@Override
	public void updateAuditTrail(String id, String loggedInUser) 
	{
		User user =new User();
				
		Map<String, String> param = new HashMap<String, String>();
		param.put("tableName", ApplicationQuery.USER_tableName);
		param.put("keyId", id);
		int version = jdbcTemplate.queryForInt(ApplicationQuery.USER_QUERY_SELECT_MAX_VERSION, param);
		version = version +1;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tableName", ApplicationQuery.USER_tableName);
		params.put("keyId", id);
		params.put("versionNo", version);
		params.put("makerId", loggedInUser);
		params.put("objectXML", AuditTrail.getObjectXmlFromEntity(user));
		
		jdbcTemplate.execute(ApplicationQuery.USER_QUERY_INSERT_AUTH, params,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});
	}
	
	public RowMapper<Integer> getSingleRowMapper() {
		return new SingleRowMapper();
	}

	private static final class SingleRowMapper implements RowMapper<Integer> 
	{
		@Override
		public Integer mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			int count = rs.getInt(1);
			return count;
		}
	}

	@Override
	public boolean isUserLogined(String id) 
	{
		//boolean response = false;
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		int count = jdbcTemplate.queryForInt(ApplicationQuery.USER_QUERY_USERSESSION_COUNT, params);
		Map<String, String> namedparams = new HashMap<String, String>();
		namedparams.put("id", id);
		namedparams.put("active", "A");
		//System.out.println(count);
		return count ==0?true:false;
		/*if(count == 0)
		{
			jdbcTemplate.execute(QUERY_INSERT_USERSESSION, namedparams,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(PreparedStatement stmt)
								throws SQLException, DataAccessException {
							return stmt.executeUpdate();
						}
					});
			response = true;
		}
		return response;*/
	}

	@Override
	public boolean logoutUser(String id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		jdbcTemplate.update(ApplicationQuery.USER_QUERY_DELETE_USERSESSION, params);
		return true;
	}

	@Override
	public void userSessionExpired(String id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		jdbcTemplate.update(ApplicationQuery.USER_QUERY_UPDATE_USERSESSION, params);
	}

	@Override
	public boolean isUserAuthorized(String id) 
	{
		boolean response = false;
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		String authStatus = jdbcTemplate.queryForObject(ApplicationQuery.USER_QUERY_USER_AUTHORIZE, params,
				new CommonSingleValueRowMapper());
		if(authStatus.equalsIgnoreCase("A"))
		{
			response = true;
		}
		return response;
	}
	
	@Override
	public boolean isRoleActive(String id) 
	{
		boolean response = false;
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		List<String> userRoles = new ArrayList<String>();  
		List<String> listActiveRole = new ArrayList<String>();
		
		userRoles = jdbcTemplate.query(ApplicationQuery.USER_QUERY_USERROLE, params, new RolesRowMapper());
		listActiveRole = jdbcTemplate.query(ApplicationQuery.USER_QUERY_ROLE_ACTIVE, Collections.singletonMap("roleId", userRoles), new RolesRowMapper());
		if(!listActiveRole.contains("I"))
		{
			response = true;
		}
		return response;
	}

	@Override
	public int isUserLoggedIn(String id) 
	{
		int count = 0;
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		count = jdbcTemplate.queryForInt(ApplicationQuery.USER_QUERY_USERSESSION_COUNT, params);
		return count;
	}

	@Override
	public void deleteUserLoginHistory() {
		Map<String, String> params = new HashMap<String, String>();
		jdbcTemplate.update(ApplicationQuery.USER_QUERY_DELETE_ALL_USERSESSION, params);
	}

	@Override
	public void updateUserLogin(String p_userId) {
		Map<String, String> namedparams = new HashMap<String, String>();
		namedparams.put("id", p_userId);
		namedparams.put("active", "A");
			jdbcTemplate.execute(ApplicationQuery.USER_QUERY_INSERT_USERSESSION, namedparams,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(PreparedStatement stmt)
								throws SQLException, DataAccessException {
							return stmt.executeUpdate();
						}
					});
		
	}

	@Override
	public User forValidFirstTimeLogin(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		user = jdbcTemplate.queryForObject(ApplicationQuery.USER_QUERY_SELECT_BY_PK, params, new UserMapper());
		return user;
	}

	
	@Override
	public void firstTimetPaswdReset(String id, String pswd)
			throws DataAccessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("pswd", pswd);
		jdbcTemplate.update(ApplicationQuery.USER_QUERY_FTIME_USER_RESET, params);
		
	}
	
	@Override
	public boolean isCbsCoCodeAvailable(String cbsCoCode) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", cbsCoCode);
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(ApplicationQuery.USER_QUERY_CBSCOCODE_AVAILABLE,	params);
		return !rowset.next();// true if there is no next, false if there is
								// next => user with given id
	}

	@Override
	public String getAppDateToday() {
		String appDateToday = "";
		try {
			Map<String, String> params = new HashMap<String, String>();	
			params.put("paramName", "APP_DATE_TODAY");
			SqlRowSet rowset = jdbcTemplate.queryForRowSet(ApplicationQuery.SYSTEM_PARAM_VALUE,	params);
			if(rowset!=null && rowset.next()){				
				appDateToday = rowset.getString("PARAM_VALUE");
			}
		} catch(Exception e){
			LoggerUtil.cbsJobError("Unhandeled Exception while get App Date Today : MFI10001", e);
		}	
		return appDateToday;		
	}

	@Override
	public String getSystemMode() {
		String systemMode = "";
		try {
			Map<String, String> params = new HashMap<String, String>();	
			params.put("paramName", "EGA_SYSTEM_MODE");
			SqlRowSet rowset = jdbcTemplate.queryForRowSet(ApplicationQuery.SYSTEM_PARAM_VALUE,	params);
			if(rowset!=null && rowset.next()){				
				systemMode = rowset.getString("PARAM_VALUE");
			}
		} catch(Exception e){
			LoggerUtil.cbsJobError("Unhandeled Exception while get System Mode : MFI10001", e);
		}	
		return systemMode;
	}

	@Override
	public List<CbsCodes> getUserCbsCode() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.QRY_CBS_CREDIT_OFFICER, params, new UserCbsCodeRowMapper());
	}	
	
	private static final class UserCbsCodeRowMapper implements RowMapper<CbsCodes> {
		public CbsCodes mapRow(ResultSet rs, int rowNum) throws SQLException 
		{	
			CbsCodes cbsCodes = new CbsCodes();
			cbsCodes.setDlValue(rs.getString("DL_VALUE"));
			cbsCodes.setDlDesc(rs.getString("DL_DESC"));
			return cbsCodes;
		}
	}
}