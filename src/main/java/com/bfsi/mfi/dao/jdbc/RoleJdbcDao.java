package com.bfsi.mfi.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.FunctionDao;
import com.bfsi.mfi.dao.RoleDao;
import com.bfsi.mfi.entity.Function;
import com.bfsi.mfi.entity.Role;
import com.bfsi.mfi.query.ApplicationQuery;

/**
 * DAO for Role entity
 * 
 * @author Jyoti Ranjan
 */

@Repository("roleDao")
public class RoleJdbcDao extends MaintenanceJdbcDao<Role> implements RoleDao {
	@Autowired
	private FunctionDao functionDao;



	private static String version = null;
	private static int version_no = 0;
	private static String success = "success";

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
		return ApplicationQuery.ROLE_QUERY_INSERT;

	}

	@Override
	protected RowMapper<Role> getRowMapper() {
		return new RoleMapper();
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.ROLE_QUERY_SELECT_ALL;

	}

	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.ROLE_QUERY_UPDATE;
	}

	@Override
	protected String getDeleteQuery() {

		return ApplicationQuery.ROLE_QUERY_DELETE;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.ROLE_QUERY_SELECT_BY_PK;
	}

	@Override
	protected String getUpdateByAuthQuery() {
		return ApplicationQuery.ROLE_QUERY_UPDATE_BY_AUTH;
	}

	@Override
	public Role get(String id) {
		Role role = super.get(id);
		// load functionsget
		List<Function> functions = functionDao
				.getFunctionsForRole(role.getId());
		role.setFunctions(functions);
		return role;
	}

	private static final class RoleMapper implements RowMapper<Role> {

		public Role mapRow(ResultSet rs, int rowNum) throws SQLException {

			Role role = new Role();
			role.setId(rs.getString("ROLE_ID"));
			role.setRoleName(rs.getString("ROLE_NAME"));
			role.setRoleDesc(rs.getString("ROLE_DESC"));
			role.setAuthStatus(rs.getString("AUTH_STATUS"));
			role.setRoleStatus(rs.getString("ROLE_STATUS"));
			role.setRoleType(rs.getString("ROLE_IBS_MBS"));
			return role;
		}
	}

	@Override
	public void addRoleEntitlements(Role role) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("roleId", role.getId());
		for (Function function : role.getFunctions()) {
			params.put("functionId", function.getId());

			jdbcTemplate.execute(ApplicationQuery.ROLE_QUERY_INSERT_ROLE_ENTITLEMENTS, params,
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
	public void deleteRoleEntitlements(Role role) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("roleId", role.getId());

		jdbcTemplate.execute(ApplicationQuery.ROLE_QUERY_DELETE_ROLE_ENTITLEMENTS, params,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});
	}

	// autogenerate roleId.
	public RowMapper<String> getRoleBalanceRowMapper() {
		return new RoleIDRowMapper();
	}

	@Override
	public String getAutoRoleId() {
		/*Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.queryForObject(ApplicationQuery.ROLE_QUERY_ROLE_AUTO_ID, params,
				new RoleIDRowMapper());*/
		
		String autoGenid = getAutoGenFunCreateId(16); //Pass Your module code.
		return autoGenid;

	}

	@Override
	public List<Role> getModifyAllocatedRoles(String userId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", userId);
		return jdbcTemplate.query(ApplicationQuery.ROLE_QUERY_SELECT_USER_ROLES, params,
				getRowMapper());
	}
	
	// For MBS
	

	@Override
	public List<Role> getModifyAllocatedRolesForMbs(String userId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", userId);
		return jdbcTemplate.query(ApplicationQuery.ROLE_QUERY_SELECT_USER_ROLES_FOR_MBS, params,
				getRowMapper());
	}

	/*
	 * public RowMapper<Branch> getUserRolesRowMapper() { return new
	 * UserRolesRowMapper(); }
	 */

	private static final class RoleIDRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			Role role = new Role();
			String roleAutoID = rs.getString("ROLE_ID");
			String setID = null;
			String value = "00001";
			String codes = "ROL";

			if (roleAutoID == null || roleAutoID.equals("")) {
				setID = codes + value;
				role.setId(setID);

			} else {
				String code = roleAutoID.substring(0, 3);
				String ActualId = roleAutoID.substring(3, 8);
				int ActualIdValue = Integer.parseInt(ActualId);
				int one = 1;
				int incrementId = ActualIdValue + one;
				String incrementIdValue = Integer.toString(incrementId);

				if (incrementIdValue.length() == 1) {
					setID = code + "0000" + incrementIdValue;
					role.setId(setID);//
				} else if (incrementIdValue.length() == 2) {
					setID = code + "000" + incrementIdValue;
					role.setId(setID);
				} else if (incrementIdValue.length() == 3) {
					setID = code + "00" + incrementIdValue;
					role.setId(setID);
				} else if (incrementIdValue.length() == 4) {
					setID = code + "0" + incrementIdValue;
					role.setId(setID);
				} else {
					setID = code + incrementIdValue;
					role.setId(setID);
				}
			}
			return setID;
		}
	}

	@Override
	public boolean isRoleNameAvailable(String roleName) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("roleName", roleName);
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(
				ApplicationQuery.ROLE_QUERY_ROLE_NAME_AVAILABLE, params);
		return !rowset.next();// true if there is no next, false if there is
								// next => role with given roleName
	}

	@Override
	public int countRoleNameAvailable(String rname) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("rname", rname);
		return jdbcTemplate.queryForInt(ApplicationQuery.ROLE_QUERY_ROLE_NAME_COUNT, params);
	}

	@Override
	public List<Role> getAuthorizedRoles() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.ROLE_QUERY_AUTHORIZED_ROLES, params,
				getRowMapper());
	}
	
	// For MBS Role
	@Override
	public List<Role> getAuthorizedRolesForMbs() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.ROLE_QUERY_AUTHORIZED_ROLES_MBS, params,
				getRowMapper());
	}

	// For delete Operation

	@Override
	public String deleteRole(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		version = jdbcTemplate.queryForObject(ApplicationQuery.ROLE_QUERY_AUDIT_VERSION, params,
				new VersionNoRowMapper());

		if (version == null) {
			version_no = 0;
		}
		if (version != null) {
			version_no = Integer.parseInt(version + 0);
		}
		if (version_no <= 1) {
			jdbcTemplate.execute(ApplicationQuery.ROLE_QUERY_DELETE_ROLE_ENTITLEMENT, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
					});
			
			jdbcTemplate.execute(ApplicationQuery.ROLE_QUERY_HARD_DELETE, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
					});
			jdbcTemplate.execute(ApplicationQuery.ROLE_QUERY_DELETE_AUDIT, params,
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

	// For ModifyUniqueID
	@Override
	public boolean isRoleStatustoInactive(String roleId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("roleId", roleId);
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(
				ApplicationQuery.ROLE_QUERY_ROLE_STATUS_TO_INACTIVE, params);
		return !rowset.next();// true if there is no next, false if there is
								// next => role with given roleName
	}
	
	
	
	
}
