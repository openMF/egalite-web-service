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

import com.bfsi.mfi.dao.AgencyDao;
import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("agencyDao")
public class AgencyJdbcDao extends MaintenanceJdbcDao<Agency> implements
		AgencyDao {
	
	private static String version = null;
	private static int version_no = 0;
	private static String success = "success";

	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.AGENCY_QUERY_INSERT;
	}

	@Override
	public List<Agency> getAuthorized() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.AGENCY_QUERY_AUTHORIZED, params, getRowMapper());
	}

	@Override
	protected AgencyMapper getRowMapper() {
		return new AgencyMapper();
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.AGENCY_QUERY_SELECT_ALL;
	}

	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.AGENCY_QUERY_UPDATE;
	}

	@Override
	protected String getDeleteQuery() {

		return ApplicationQuery.AGENCY_QUERY_DELETE;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.QUERY_SELECT_BY_PK;
	}

	@Override
	protected String getUpdateByAuthQuery() {
		return ApplicationQuery.AGENCY_QUERY_UPDATE_BY_AUTH;
	}

	@Override
	public List<Agency> getAgencyForAllocation() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.AGENCY_QUERY_Agency_Code_ALLOC, params,
				getRowMapper());
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

	private static final class AgencyMapper implements RowMapper<Agency> {
		public Agency mapRow(ResultSet rs, int rowNum) throws SQLException {
			Agency agency = new Agency();
			agency.setId(rs.getString("AGENCY_CODE"));
			agency.setAgencyDesc(rs.getString("AGENCY_DESC"));
			agency.setAddress1(rs.getString("ADDRESS1"));
			agency.setAddress2(rs.getString("ADDRESS2"));
			agency.setAddress3(rs.getString("ADDRESS3"));
			agency.setAddress4(rs.getString("ADDRESS4"));
			agency.setContactNumber(rs.getString("CONTACT_NUMBER"));
			agency.setAuthStatus(rs.getString("AUTH_STATUS"));
			agency.setIsActive(rs.getString("IS_ACTIVE"));
			agency.setCategory(rs.getString("CATEGORY"));
			agency.setAllocatedCo(rs.getString("ALLOCATED_CO"));
			agency.setZipCode(rs.getString("ZIP_CODE"));
			agency.setCity(rs.getString("CITY"));
			agency.setState(rs.getString("STATE"));
			agency.setCountry(rs.getString("COUNTRY"));
			agency.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
			
			return agency;
		}
	}

	@Override
	public boolean isAgencyCodeAvailable(String agencyCode) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", agencyCode);
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(
				ApplicationQuery.QUERY_AGENCY_CODE_AVAILABLE, params);
		return !rowset.next();// true if there is no next, false if there is
		// next => role with given roleName

	}

	// For deletion Operation
	@Override
	public String deleteAgency(String id) {
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
			jdbcTemplate.execute(ApplicationQuery.AGENCY_QUERY_DELETE, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {

							return stmt.executeUpdate();
						}
					});
			jdbcTemplate.execute(ApplicationQuery.AGENCY_QUERY_DELETE_AUDIT, params,
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
	public boolean isAgencyStatustoInactive(String agencyId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("agencyId", agencyId);
		// SqlRowSet rowset = jdbcTemplate.queryForRowSet(
		// QUERY_AGENCY_STATUS_TO_INACTIVE, params);
		int r = jdbcTemplate.queryForInt(ApplicationQuery.QUERY_AGENCY_STATUS_TO_INACTIVE,
				params);
		// return !rowset.next();// true if there is no next, false if there is
		// next => role with given roleName
		return (r == 0) ? false : true;
	}

	// For getting AutoAgencyCode
	
	//BFSIMFI-263 Guru Start -
	@Override
	public String getAutoAgencyCode() {
		/*Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.queryForObject(ApplicationQuery.AGENCY_QUERY_AUTO_AGENCY_CODE, params,
				new AgencyCodeRowMapper());*/
		String autoId = getAutoGenFunCreateId(4); //Receive Agent ID from Function.
		return autoId;
	}

	/*private static final class AgencyCodeRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {

			Agency agency = new Agency();
			String agencyAutoCode = rs.getString("AGENCY_CODE");
			String setID = null;
			String value = "00001";
			String codes = "AGY";

			if (agencyAutoCode == null || agencyAutoCode.equals("")) {
				setID = codes + value;
				agency.setId(setID);

			} else {
				String code = agencyAutoCode.substring(0, 3);
				String ActualId = agencyAutoCode.substring(3, 8);
				int ActualIdValue = Integer.parseInt(ActualId);
				int one = 1;
				int incrementId = ActualIdValue + one;
				String incrementIdValue = Integer.toString(incrementId);

				if (incrementIdValue.length() == 1) {
					setID = code + "0000" + incrementIdValue;
					agency.setId(setID);
				} else if (incrementIdValue.length() == 2) {
					setID = code + "000" + incrementIdValue;
					agency.setId(setID);
				} else if (incrementIdValue.length() == 3) {
					setID = code + "00" + incrementIdValue;
					agency.setId(setID);
				} else if (incrementIdValue.length() == 4) {
					setID = code + "0" + incrementIdValue;
					agency.setId(setID);
				} else {
					setID = code + incrementIdValue;
					agency.setId(setID);
				}
			}
			return setID;
		}
	}*/
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
	
	@Override
	public boolean isCbsCoCodeAvailable(String cbsCoCode) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", cbsCoCode);
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(ApplicationQuery.AGENCY_QUERY_CBSCOCODE_LOV,
				params);
		return !rowset.next();// true if there is no next, false if there is
								// next => user with given id
	}
	
	
	public List<CbsCodes> getAgencyCbsCode()
	{

		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate
				.query(ApplicationQuery.AGENCY_QUERY_CBSCOCODE_LOV, params, new AgencyCbsCodeRowMapper());
	
	}
	private static final class AgencyCbsCodeRowMapper implements RowMapper<CbsCodes> {
		public CbsCodes mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsCodes cbsCodes = new CbsCodes();

			cbsCodes.setDlValue(rs.getString("DL_VALUE"));
			cbsCodes.setDlDesc(rs.getString("DL_DESC"));

			return cbsCodes;
		}
	}
}
