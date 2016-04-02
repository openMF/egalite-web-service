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

import com.bfsi.mfi.dao.CenterCodeDao;
import com.bfsi.mfi.dao.jdbc.LocationJdbcDao.LocationCodeMapper;
import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.entity.CenterCodes;
import com.bfsi.mfi.entity.Location;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("centerCodeDao")
public class CenterCodeJdbcDao extends MaintenanceJdbcDao<CenterCodes> implements
	CenterCodeDao {
	
	private static String version = null;
	private static int version_no = 0;
	private static String success = "success";

	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.CENTER_QUERY_INSERT;
	}

	@Override
	public List<CenterCodes> getAuthorized() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.CENTER_QUERY_AUTHORIZED, params, getRowMapper());
	}

	@Override
	protected CenterCodeMapper getRowMapper() {
		return new CenterCodeMapper();
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.CENTER_QUERY_SELECT_ALL;
	}

	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.CENTER_QUERY_UPDATE;
	}

	@Override
	protected String getDeleteQuery() {

		return ApplicationQuery.CENTER_QUERY_DELETE;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.CENTER_SELECT_BY_PK;
	}

	@Override
	protected String getUpdateByAuthQuery() {
		return ApplicationQuery.CENTER_QUERY_UPDATE_BY_AUTH;
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

	private static final class CenterCodeMapper implements RowMapper<CenterCodes> {
		public CenterCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
			CenterCodes centerCodes = new CenterCodes();
			centerCodes.setId(rs.getString("center_code"));
			centerCodes.setCbsCenterCode(rs.getString("cbs_center_code"));
			centerCodes.setIbsLocationCode(rs.getString("ibs_location_code"));
			centerCodes.setCenterCodeDesc(rs.getString("center_code_desc"));
			centerCodes.setCbsBranchCode(rs.getString("cbs_branch_code"));
			centerCodes.setContactNumber(rs.getString("contact_number"));
			centerCodes.setOnSundayStr(rs.getString("on_sunday"));
			centerCodes.setOnMondayStr(rs.getString("on_monday"));
			centerCodes.setOnTuesdayStr(rs.getString("on_tuesday"));
			centerCodes.setOnWednesdayStr(rs.getString("on_wednesday"));
			centerCodes.setOnThursdayStr(rs.getString("on_thursday"));
			centerCodes.setOnFridayStr(rs.getString("on_friday"));
			centerCodes.setOnSaturday(rs.getBoolean("on_saturday"));
			centerCodes.setAddressLine1(rs.getString("address_line_1"));
			centerCodes.setAddressLine2(rs.getString("address_line_2"));
			centerCodes.setAddressLine3(rs.getString("address_line_3"));
			centerCodes.setAddressLine4(rs.getString("address_line_4"));
			centerCodes.setZipCode(rs.getString("zip_code")); 	
			centerCodes.setCity(rs.getString("city"));
			centerCodes.setState(rs.getString("state"));
			centerCodes.setCountry(rs.getString("country"));
			centerCodes.setIsActive(rs.getString("is_active"));
			centerCodes.setAuthStatus(rs.getString("auth_status"));
			return centerCodes;
		}
	}

	
	// For deletion Operation
	@Override
	public String deleteCenter(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		version = jdbcTemplate.queryForObject(ApplicationQuery.CENTER_QUERY_AUDIT_VERSION, params,
				new VersionNoRowMapper());
		//version_no = Integer.parseInt(version);
		if (version == null){
			version_no = 0;
		}
		if (version != null){
			version_no = Integer.parseInt(version + 0);
		}

		if (version_no <= 1) {
			jdbcTemplate.execute(ApplicationQuery.CENTER_QUERY_DELETE, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {

							return stmt.executeUpdate();
						}
					});
			jdbcTemplate.execute(ApplicationQuery.CENTER_QUERY_DELETE_AUDIT, params,
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
		
		/* EGALITE-45 start*/
		@Override
		public String getAutoCenterCode() throws ServiceException {
			/*Map<String, String> params = new HashMap<String, String>();
			params.put(null, null);
			return jdbcTemplate.queryForObject(ApplicationQuery.LOCATION_QUERY_AUTO_CENTER_CODE, params,
					new CenterCodeRowMapper());*/
			
			String autoGenid = getAutoGenFunCreateId(10); //Pass Your module code.
			return autoGenid;
		}
		
		private static final class CenterCodeRowMapper implements RowMapper<String> {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				CenterCodes centerCodes = new CenterCodes();
				String autoCenterCode = rs.getString("CENTER_CODE");
				String setID = null;
				String value = "00001";
				String codes = "LCC";

				if (autoCenterCode == null || autoCenterCode.equals("")) {
					setID = codes + value;
					centerCodes.setId(setID);

				} else {
					String code = autoCenterCode.substring(0, 3);
					String ActualId = autoCenterCode.substring(3, 8);
					int ActualIdValue = Integer.parseInt(ActualId);
					int one = 1;
					int incrementId = ActualIdValue + one;
					String incrementIdValue = Integer.toString(incrementId);

					if (incrementIdValue.length() == 1) {
						setID = code + "0000" + incrementIdValue;
						centerCodes.setId(setID);
					} else if (incrementIdValue.length() == 2) {
						setID = code + "000" + incrementIdValue;
						centerCodes.setId(setID);
					} else if (incrementIdValue.length() == 3) {
						setID = code + "00" + incrementIdValue;
						centerCodes.setId(setID);
					} else if (incrementIdValue.length() == 4) {
						setID = code + "0" + incrementIdValue;
						centerCodes.setId(setID);
					} else {
						setID = code + incrementIdValue;
						centerCodes.setId(setID);
					}
				}
				return setID;
			}
		}
		
		@Override
		public List<CbsCodes> getCbsCenterCode() {
			Map<String, String> params = new HashMap<String, String>();
			params.put(null, null);
			return jdbcTemplate
					.query(ApplicationQuery.CENTER_QUERY_CBSROUTECODE_LOV, params, new CenterCbsCodeRowMapper());
		}	
		

		private static final class CenterCbsCodeRowMapper implements RowMapper<CbsCodes> {
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
					.query(ApplicationQuery.CENTERIBS_LOCATION_DROP_DOWN, params, new LocationMapper());
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

		
		/* EGALITE-45 end*/
		
		/*Tag No: EGA-MN15-000004 Starts*/	
		@Override
		public List<CenterCodes> getdistricts() {
			Map<String, String> params = new HashMap<String, String>();
			params.put(null, null);
			return jdbcTemplate
					.query(ApplicationQuery.CENTER_DISTRICT_CODES, params, new CenterCodMapper());
		}
		
		protected static final class CenterCodMapper implements RowMapper<CenterCodes> {
			public CenterCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
				CenterCodes route = new CenterCodes();
				route.setCodeType(rs.getString("CODE_TYPE"));
				route.setCodeValue(rs.getString("CODE_VALUE"));
				route.setDescription(rs.getString("DESCRIPTION"));
				route.setIsoEquivalentCode(rs.getString("ISO_EQUIVALENT_CODE"));
				return route;
			}
		}
		
		@Override
		public List<CenterCodes> getcitys() {
			Map<String, String> params = new HashMap<String, String>();
			params.put(null, null);
			return jdbcTemplate
					.query(ApplicationQuery.CENTER_QUERY_CITY_CODES, params, new CenterCodMapper());
		}
		
		@Override
		public List<CenterCodes> getstates() {
			Map<String, String> params = new HashMap<String, String>();
			params.put(null, null);
			return jdbcTemplate
					.query(ApplicationQuery.CENTER_QUERY_STATE_CODES, params, new CenterCodMapper());
		}
			
		@Override
		public boolean isCenterCodeAvailable(String centerCode) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("centerCode", centerCode);
			SqlRowSet rowset = jdbcTemplate.queryForRowSet(ApplicationQuery.CENTER_CODE_AVAILABLE,
					params);
			return !rowset.next();
		}
		/*Tag No: EGA-MN15-000004 End*/
		
}
