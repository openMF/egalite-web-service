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

import com.bfsi.mfi.dao.RouteCodeDao;
import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.entity.Location;
import com.bfsi.mfi.entity.RouteCodes;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("routeCodeDao")
public class RouteCodeJdbcDao extends MaintenanceJdbcDao<RouteCodes> implements
	RouteCodeDao {
	
	private static String version = null;
	private static int version_no = 0;
	private static String success = "success";

	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.ROUTE_QUERY_INSERT;
	}

	@Override
	public List<RouteCodes> getAuthorized() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.ROUTE_QUERY_AUTHORIZED, params, getRowMapper());
	}

	@Override
	protected RouteCodeMapper getRowMapper() {
		return new RouteCodeMapper();
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.ROUTE_QUERY_SELECT_ALL;
	}

	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.ROUTE_QUERY_UPDATE;
	}

	@Override
	protected String getDeleteQuery() {

		return ApplicationQuery.ROUTE_QUERY_DELETE;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.ROUTE_SELECT_BY_PK;
	}

	@Override
	protected String getUpdateByAuthQuery() {
		return ApplicationQuery.ROUTE_QUERY_UPDATE_BY_AUTH;
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

	private static final class RouteCodeMapper implements RowMapper<RouteCodes> {
		public RouteCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
			RouteCodes routeCodes = new RouteCodes();
			routeCodes.setId(rs.getString("route_code"));
			routeCodes.setCbsRouteCode(rs.getString("cbs_route_code"));
			routeCodes.setIbsLocationCode(rs.getString("ibs_location_code"));
			routeCodes.setRouteCodeDesc(rs.getString("route_code_desc"));
			routeCodes.setCbsBranchCode(rs.getString("cbs_branch_code"));
			routeCodes.setContactNumber(rs.getString("contact_number"));
			routeCodes.setOnSundayStr(rs.getString("on_sunday"));
			routeCodes.setOnMondayStr(rs.getString("on_monday"));
			routeCodes.setOnTuesdayStr(rs.getString("on_tuesday"));
			routeCodes.setOnWednesdayStr(rs.getString("on_wednesday"));
			routeCodes.setOnThursdayStr(rs.getString("on_thursday"));
			routeCodes.setOnFridayStr(rs.getString("on_friday"));
			routeCodes.setOnSaturdayStr(rs.getString("on_saturday"));
			routeCodes.setFrmAddressLine1(rs.getString("frm_address_line_1"));
			routeCodes.setFrmAddressLine2(rs.getString("frm_address_line_2"));
			routeCodes.setFrmAddressLine3(rs.getString("frm_address_line_3"));
			routeCodes.setFrmAddressLine4(rs.getString("frm_address_line_4"));
			routeCodes.setFrmZipCode(rs.getString("frm_zip_code")); 	
			routeCodes.setFrmCity(rs.getString("frm_city"));
			routeCodes.setFrmState(rs.getString("frm_state"));
			routeCodes.setFrmCountry(rs.getString("frm_country"));
			routeCodes.setToAddressLine1(rs.getString("to_address_line_1"));
			routeCodes.setToAddressLine2(rs.getString("to_address_line_2"));
			routeCodes.setToAddressLine3(rs.getString("to_address_line_3"));
			routeCodes.setToAddressLine4(rs.getString("to_address_line_4"));
			routeCodes.setToZipCode(rs.getString("to_zip_code"));
			routeCodes.setToCity(rs.getString("to_city"));
			routeCodes.setToState(rs.getString("to_state"));
			routeCodes.setToCountry(rs.getString("to_country"));
			routeCodes.setIsActive(rs.getString("is_active"));
			routeCodes.setAuthStatus(rs.getString("auth_status"));
			return routeCodes;
		}
	}
	
	// For deletion Operation
	@Override
	public String deleteRoute(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		version = jdbcTemplate.queryForObject(ApplicationQuery.ROUTE_QUERY_AUDIT_VERSION, params,
				new VersionNoRowMapper());
		//version_no = Integer.parseInt(version);
		if (version == null){
			version_no = 0;
		}
		if (version != null){
			version_no = Integer.parseInt(version + 0);
		}

		if (version_no <= 1) {
			jdbcTemplate.execute(ApplicationQuery.ROUTE_QUERY_DELETE, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {

							return stmt.executeUpdate();
						}
					});
			jdbcTemplate.execute(ApplicationQuery.ROUTE_QUERY_DELETE_AUDIT, params,
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
	
	//BFSIMFI-263 Guru End
		@Override
		public List<Agency> getcountryCodes() {
			Map<String, String> params = new HashMap<String, String>();
			params.put(null, null);
			return jdbcTemplate
					.query(ApplicationQuery.AGENCY_QUERY_COUNTRY_CODES, params, new AgencyCountryCodeMapper());
		}
		
		// for country code
		protected static final class AgencyCountryCodeMapper implements RowMapper<Agency> {
			public Agency mapRow(ResultSet rs, int rowNum) throws SQLException {
				Agency agency = new Agency();
				agency.setCountryCode(rs.getString("COUNTRY_CODE"));
				agency.setDescription(rs.getString("DESCRIPTION"));
				agency.setIso(rs.getString("ISO_NUM_COUNTRY_CODE"));
				return agency;
			}
		}
		
		/* EGALITE-38 start*/

		@Override
		public String getAutoRouteCode() throws ServiceException {
			/*Map<String, String> params = new HashMap<String, String>();
			params.put(null, null);
			return jdbcTemplate.queryForObject(ApplicationQuery.LOCATION_QUERY_AUTO_ROUTE_CODE, params,
					new RouteCodeRowMapper());*/
			String autoGenid = getAutoGenFunCreateId(11); //Pass Your module code.
			return autoGenid;
		}
		
		private static final class RouteCodeRowMapper implements RowMapper<String> {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				RouteCodes routeCodes = new RouteCodes();
				String autoRouteCode = rs.getString("ROUTE_CODE");
				String setID = null;
				String value = "00001";
				String codes = "LRC";

				if (autoRouteCode == null || autoRouteCode.equals("")) {
					setID = codes + value;
					routeCodes.setId(setID);

				} else {
					String code = autoRouteCode.substring(0, 3);
					String ActualId = autoRouteCode.substring(3, 8);
					int ActualIdValue = Integer.parseInt(ActualId);
					int one = 1;
					int incrementId = ActualIdValue + one;
					String incrementIdValue = Integer.toString(incrementId);

					if (incrementIdValue.length() == 1) {
						setID = code + "0000" + incrementIdValue;
						routeCodes.setId(setID);
					} else if (incrementIdValue.length() == 2) {
						setID = code + "000" + incrementIdValue;
						routeCodes.setId(setID);
					} else if (incrementIdValue.length() == 3) {
						setID = code + "00" + incrementIdValue;
						routeCodes.setId(setID);
					} else if (incrementIdValue.length() == 4) {
						setID = code + "0" + incrementIdValue;
						routeCodes.setId(setID);
					} else {
						setID = code + incrementIdValue;
						routeCodes.setId(setID);
					}
				}
				return setID;
			}
		}
		
		
		@Override
		public List<CbsCodes> getCbsRouteCode() {
			Map<String, String> params = new HashMap<String, String>();
			params.put(null, null);
			return jdbcTemplate
					.query(ApplicationQuery.CENTER_QUERY_CBS_ROUTE_CODE_LOV, params, new RouteCbsCodeRowMapper());
		}	
		
		private static final class RouteCbsCodeRowMapper implements RowMapper<CbsCodes> {
			public CbsCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
				CbsCodes cbsCodes = new CbsCodes();
				cbsCodes.setDlValue(rs.getString("DL_VALUE"));
				cbsCodes.setDlDesc(rs.getString("DL_DESC"));
				return cbsCodes;
			}
		}
		@Override
		public List<Location> getlocationCodes() {
			Map<String, String> params = new HashMap<String, String>();
			params.put(null, null);
			return jdbcTemplate
					.query(ApplicationQuery.IBS_LOCATION_DROP_DOWN, params, new LocationMapper());
		}
		
		private static final class LocationMapper implements RowMapper<Location> {
			public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
				Location location = new Location();
				location.setId(rs.getString("LOCATION_CODE"));
				location.setLocationDesc(rs.getString("LOCATION_DESC"));
				//location.setCbsLocationCode(rs.getString("CBS_LOCATION_CODE"));
				//location.setCbsBranchCode(rs.getString("CBS_BRANCH_CODE"));
				//location.setAddress1(rs.getString("ADDRESS1"));
				//location.setAddress2(rs.getString("ADDRESS2"));
				//location.setAddress3(rs.getString("ADDRESS3"));
				//location.setAddress4(rs.getString("ADDRESS4"));
				//location.setZipCode(rs.getString("ZIP_CODE"));
				//location.setCity(rs.getString("CITY"));
				//location.setState(rs.getString("STATE"));
				//location.setCountry(rs.getString("COUNTRY"));
				//location.setContactNumber(rs.getString("CONTACT_NUMBER"));
				//location.setIsActive(rs.getString("IS_ACTIVE"));
				//location.setAuthStatus(rs.getString("AUTH_STATUS"));
				
				return location;
			}
		}
		
		/* EGALITE-38 end*/
	
	/*Tag No: EGA-MN15-000002 Starts*/	
		@Override
		public List<RouteCodes> getdistricts() {
			Map<String, String> params = new HashMap<String, String>();
			params.put(null, null);
			return jdbcTemplate
					.query(ApplicationQuery.ROUTE_QUERY_DISTRICT_CODES, params, new RouteCountryCodeMapper());
		}
		
		protected static final class RouteCountryCodeMapper implements RowMapper<RouteCodes> {
			public RouteCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
				RouteCodes route = new RouteCodes();
				route.setCodeType(rs.getString("CODE_TYPE"));
				route.setCodeValue(rs.getString("CODE_VALUE"));
				route.setDescription(rs.getString("DESCRIPTION"));
				route.setIsoEquivalentCode(rs.getString("ISO_EQUIVALENT_CODE"));
				return route;
			}
		}
		
		@Override
		public List<RouteCodes> getcitys() {
			Map<String, String> params = new HashMap<String, String>();
			params.put(null, null);
			return jdbcTemplate
					.query(ApplicationQuery.ROUTE_QUERY_CITY_CODES, params, new RouteCountryCodeMapper());
		}
		
		@Override
		public List<RouteCodes> getstates() {
			Map<String, String> params = new HashMap<String, String>();
			params.put(null, null);
			return jdbcTemplate
					.query(ApplicationQuery.ROUTE_QUERY_STATE_CODES, params, new RouteCountryCodeMapper());
		}
		
		@Override
		public boolean isRouteCodeAvailable(String routeCode) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("routeCode", routeCode);
			SqlRowSet rowset = jdbcTemplate.queryForRowSet(ApplicationQuery.QUERY_ROUTE_CODE_AVAILABLE,
					params);
			return !rowset.next();
		}
		/*Tag No: EGA-MN15-000002 End*/
}
