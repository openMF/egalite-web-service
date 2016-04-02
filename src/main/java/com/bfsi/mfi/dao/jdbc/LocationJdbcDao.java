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
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.LocationDao;
import com.bfsi.mfi.dao.jdbc.RouteCodeJdbcDao.RouteCountryCodeMapper;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.entity.Location;
import com.bfsi.mfi.entity.RouteCodes;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("locationDao")
public class LocationJdbcDao extends MaintenanceJdbcDao<Location> implements
		LocationDao {
	
	private static String version = null;
	private static int version_no = 0;
	private static String success = "success";

	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.LOCATION_INSERT_QUERY_INSERT;
	}

	@Override
	public List<Location> getAuthorized() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.LOCATION_QUERY_AUTHORIZED, params, getRowMapper());
	}

	@Override
	protected LocationMapper getRowMapper() {
		return new LocationMapper();
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.LOCATION_QUERY_SELECT_ALL;
	}

	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.LOCATION_QUERY_UPDATE;
	}

	@Override
	protected String getDeleteQuery() {

		return ApplicationQuery.LOCATION_QUERY_DELETE;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.LOCATION_QUERY_SELECT_BY_PK;
	}

	@Override
	protected String getUpdateByAuthQuery() {
		return ApplicationQuery.LOCATION_QUERY_UPDATE_BY_AUTH;
	}

	
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

	private static final class LocationMapper implements RowMapper<Location> {
		public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
			Location location = new Location();
			location.setId(rs.getString("LOCATION_CODE"));
			location.setLocationDesc(rs.getString("LOCATION_DESC"));
			location.setCbsLocationCode(rs.getString("CBS_LOCATION_CODE"));
			location.setCbsBranchCode(rs.getString("CBS_BRANCH_CODE"));
			location.setAddress1(rs.getString("ADDRESS1"));
			location.setAddress2(rs.getString("ADDRESS2"));
			location.setAddress3(rs.getString("ADDRESS3"));
			location.setAddress4(rs.getString("ADDRESS4"));
			location.setZipCode(rs.getString("ZIP_CODE"));
			location.setCity(rs.getString("CITY"));
			location.setState(rs.getString("STATE"));
			location.setCountry(rs.getString("COUNTRY"));
			location.setContactNumber(rs.getString("CONTACT_NUMBER"));
			location.setIsActive(rs.getString("IS_ACTIVE"));
			location.setAuthStatus(rs.getString("AUTH_STATUS"));
			
			return location;
		}
	}

	
	// For deletion Operation
	@Override
	public String deleteLocation(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		version = jdbcTemplate.queryForObject(ApplicationQuery.AGENCY_QUERY_AUDIT_VERSION, params,
				new VersionNoRowMapper());
		//version_no = Integer.parseInt(version);
		if (version == null){
			version_no = 0;
		}
		if (version != null){
			version_no = Integer.parseInt(version + 0);
		}

		if (version_no <= 1) {
			jdbcTemplate.execute(ApplicationQuery.LOCATION_QUERY_DELETE, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {

							return stmt.executeUpdate();
						}
					});
			jdbcTemplate.execute(ApplicationQuery.LOCATION_QUERY_DELETE_AUDIT, params,
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
	public List<Location> getcountryCodes() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate
				.query(ApplicationQuery.LOCATION_QUERY_COUNTRY_CODES, params, new LocationCountryCodeMapper());
	}
	
	protected static final class LocationCountryCodeMapper implements RowMapper<Location> {
		public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
			Location location = new Location();
			location.setCountryCode(rs.getString("COUNTRY_CODE"));
			location.setDescription(rs.getString("DESCRIPTION"));
			location.setIso(rs.getString("ISO_NUM_COUNTRY_CODE"));
			return location;
		}
	}
	
	
	@Override
	public String getAutoLocationCode() {
		/*Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.queryForObject(ApplicationQuery.LOCATION_QUERY_AUTO_AGENCY_CODE, params,
				new LocationCodeRowMapper());*/
		String autoGenid = getAutoGenFunCreateId(6); //Pass Your module code.
		return autoGenid;

	}
	
	private static final class LocationCodeRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {

			Location location = new Location();
			String locationAutoCode = rs.getString("LOCATION_CODE");
			String setID = null;
			String value = "00001";
			String codes = "LCN";

			if (locationAutoCode == null || locationAutoCode.equals("")) {
				setID = codes + value;
				location.setId(setID);

			} else {
				String code = locationAutoCode.substring(0, 3);
				String ActualId = locationAutoCode.substring(3, 8);
				int ActualIdValue = Integer.parseInt(ActualId);
				int one = 1;
				int incrementId = ActualIdValue + one;
				String incrementIdValue = Integer.toString(incrementId);

				if (incrementIdValue.length() == 1) {
					setID = code + "0000" + incrementIdValue;
					location.setId(setID);
				} else if (incrementIdValue.length() == 2) {
					setID = code + "000" + incrementIdValue;
					location.setId(setID);
				} else if (incrementIdValue.length() == 3) {
					setID = code + "00" + incrementIdValue;
					location.setId(setID);
				} else if (incrementIdValue.length() == 4) {
					setID = code + "0" + incrementIdValue;
					location.setId(setID);
				} else {
					setID = code + incrementIdValue;
					location.setId(setID);
				}
			}
			return setID;
		}
	}
	
	@Override
	public boolean isLocationStatustoInactive(String locationId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("locationId", locationId);
		int r = jdbcTemplate.queryForInt(ApplicationQuery.QUERY_LOCATION_STATUS_TO_INACTIVE,
				params);
		return (r == 0) ? false : true;
	}
	
// For Location Code
	@Override
	public List<Location> getlocationCodes() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate
				.query(ApplicationQuery.LOCATION_QUERY_AUTHORIZED, params, getRowMapper());
	}
	
	// EGALITE-289 START
	@Override
	public List<Location> getAgentlocationCodes() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate
				.query(ApplicationQuery.AGENT_LOCATION_QUERY_AUTHORIZED, params, getRowMapper());
	}
	// EGALITE-289 END
	
	
	@Override
	public boolean isCbsLocCodeAvailable(String cbsLocCode) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", cbsLocCode);
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(ApplicationQuery.LOC_QUERY_CBSCOCODE_AVAILABLE,
				params);
		return !rowset.next();// true if there is no next, false if there is
								// next => user with given id
	}
	
	@Override
	public List<CbsCodes> getLocCbsCode() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate
				.query(ApplicationQuery.LOC_QUERY_CBSLCN_CODE, params, new LocationCbsCodeRowMapper());
		
		// LC added ==> Changes for Asomi Nirmal kanna S
	}	
	

	private static final class LocationCbsCodeRowMapper implements RowMapper<CbsCodes> {
		public CbsCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsCodes cbsCodes = new CbsCodes();

			cbsCodes.setDlValue(rs.getString("DL_VALUE"));
			cbsCodes.setDlDesc(rs.getString("DL_DESC"));

			return cbsCodes;
		}
	}
	
	/*Tag No: EGA-MN15-000003 Starts*/	
	@Override
	public List<Location> getdistricts() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate
				.query(ApplicationQuery.LOCATION_DISTRICT_CODES, params, new LocationCodeMapper());
	}
	
	protected static final class LocationCodeMapper implements RowMapper<Location> {
		public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
			Location route = new Location();
			route.setCodeType(rs.getString("CODE_TYPE"));
			route.setCodeValue(rs.getString("CODE_VALUE"));
			route.setDescription(rs.getString("DESCRIPTION"));
			route.setIsoEquivalentCode(rs.getString("ISO_EQUIVALENT_CODE"));
			return route;
		}
	}
	
	@Override
	public List<Location> getcitys() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate
				.query(ApplicationQuery.LOCATION_QUERY_CITY_CODES, params, new LocationCodeMapper());
	}
	
	@Override
	public List<Location> getstates() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate
				.query(ApplicationQuery.LOCATION_QUERY_STATE_CODES, params, new LocationCodeMapper());
	}
		
	@Override
	public boolean isLocationCodeAvailable(String locationCode) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("locationCode", locationCode);
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(ApplicationQuery.LOCATION_CODE_AVAILABLE,
				params);
		return !rowset.next();
	}
	/*Tag No: EGA-MN15-000003 End*/
}
