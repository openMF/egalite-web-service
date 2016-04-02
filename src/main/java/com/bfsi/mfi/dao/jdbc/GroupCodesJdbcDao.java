package com.bfsi.mfi.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.GroupCodesDao;
import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.entity.GroupCodes;
import com.bfsi.mfi.query.ApplicationQuery;


@Repository("groupCodesDao")
public class GroupCodesJdbcDao extends MaintenanceJdbcDao<GroupCodes> implements
GroupCodesDao {

	private static String version = null;
	private static int version_no = 0;
	private static String success = "success";
	

	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.GRCODE_QUERY_INSERT;
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.GRCODE_QUERY_SELECT_ALL;
	}
	@Override
	protected RowMapper<GroupCodes> getRowMapper() {
		return new GroupCodesMapper();
	}
	
	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.GRCODE_QUERY_UPDATE;
	}
	
	@Override
	protected String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.GRCODE_SELECT_BY_PK;
	}
	
	@Override
	protected String getUpdateByAuthQuery() {
		return ApplicationQuery.GRCODE_QUERY_UPDATE_BY_AUTH;
	}
	
	@Override
	public List<GroupCodes> getAuthorized() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.GRCODE_QUERY_AUTHORIZED, params, getRowMapper());
	}

	
	private static final class GroupCodesMapper implements RowMapper<GroupCodes> {
		public GroupCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
			GroupCodes groupCodes = new GroupCodes();
			
/*group_id varchar2(25), //super id used
 * cbs_branch_code varchar2(5),cbs_group_id	varchar2(25),	
group_name	varchar2(50),cbs_co_id 		varchar2(25),ibs_co_id 		varchar2(25),	
contact_number		varchar2(20),is_active		varchar2(1),auth_status		varchar2(1)*/
			
			groupCodes.setId(rs.getString("GROUP_ID"));
			groupCodes.setCbsBranchCode(rs.getString("CBS_BRANCH_CODE"));
			groupCodes.setCbsGroupId(rs.getString("CBS_GROUP_ID"));
			groupCodes.setGroupName(rs.getString("GROUP_NAME"));
			groupCodes.setCbsCoId(rs.getString("CBS_CO_ID"));
			groupCodes.setIbsCoId(rs.getString("IBS_CO_ID"));
			groupCodes.setContactNumber(rs.getString("CONTACT_NUMBER"));
			groupCodes.setIsActive(rs.getString("IS_ACTIVE"));
			groupCodes.setAuthStatus(rs.getString("AUTH_STATUS"));
			
			return groupCodes;
		}
	}
	
	
	@Override
	public String getAutoGroupCode() {
		/*Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.queryForObject(ApplicationQuery.GRCODE_QUERY_AUTO_GROUP_CODE, params,
				new GroupCodeRowMapper());*/
		String autoGenid = getAutoGenFunCreateId(7); //Pass Your module code.
		return autoGenid;

	}
	private static final class GroupCodeRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {

			GroupCodes group = new GroupCodes();
			String groupAutoCode = rs.getString("GROUP_ID");
			String setID = null;
			String value = "00001";
			String codes = "GRP";

			if (groupAutoCode == null || groupAutoCode.equals("")) {
				setID = codes + value;
				group.setId(setID);

			} else {
				String code = groupAutoCode.substring(0, 3);
				String ActualId = groupAutoCode.substring(3, 8);
				int ActualIdValue = Integer.parseInt(ActualId);
				int one = 1;
				int incrementId = ActualIdValue + one;
				String incrementIdValue = Integer.toString(incrementId);

				if (incrementIdValue.length() == 1) {
					setID = code + "0000" + incrementIdValue;
					group.setId(setID);
				} else if (incrementIdValue.length() == 2) {
					setID = code + "000" + incrementIdValue;
					group.setId(setID);
				} else if (incrementIdValue.length() == 3) {
					setID = code + "00" + incrementIdValue;
					group.setId(setID);
				} else if (incrementIdValue.length() == 4) {
					setID = code + "0" + incrementIdValue;
					group.setId(setID);
				} else {
					setID = code + incrementIdValue;
					group.setId(setID);
				}
			}
			return setID;
		}
	}
	
	private static final class VersionNoRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			String version_no = rs.getString(1);
			return version_no;
		}
	}
	
	// For deletion Operation
	@Override
	public String deleteGroupCode(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		version = jdbcTemplate.queryForObject(ApplicationQuery.GRCODE_QUERY_AUDIT_VERSION, params,
				new VersionNoRowMapper());
		//version_no = Integer.parseInt(version);
		if (version == null){
			version_no = 0;
		}
		if (version != null){
			version_no = Integer.parseInt(version + 0);
		}

		if (version_no <= 1) {
			jdbcTemplate.execute(ApplicationQuery.GRCODE_QUERY_DELETE, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {

							return stmt.executeUpdate();
						}
					});
			jdbcTemplate.execute(ApplicationQuery.GRCODE_QUERY_DELETE_AUDIT, params,
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

	
}
