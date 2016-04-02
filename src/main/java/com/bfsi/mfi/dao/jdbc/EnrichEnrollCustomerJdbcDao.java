package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.EnrichEnrollCustomerDao;
import com.bfsi.mfi.entity.EnrollCustomer;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("enrichEnrollCustomerDao")
public class EnrichEnrollCustomerJdbcDao extends MaintenanceJdbcDao<EnrollCustomer> 
implements EnrichEnrollCustomerDao {
	
	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.EEC_QUERY_SELECT_ALL;
	}

	@Override
	protected EnrichCustomerMapper getRowMapper() {
		return new EnrichCustomerMapper();
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.EEC_QUERY_SELECT_BY_PK;
	}
	
	private static final class EnrichCustomerMapper implements RowMapper<EnrollCustomer> {

		public EnrollCustomer mapRow(ResultSet rs, int rowNum) throws SQLException {
			EnrollCustomer customer = new EnrollCustomer();

			customer.setId(rs.getString("ENROLLMENT_ID"));
			customer.setFirstName(rs.getString("FIRST_NAME"));
			customer.setLastName(rs.getString("LAST_NAME"));
			customer.setMiddleName(rs.getString("MIDDLE_NAME"));
			customer.setDob(rs.getDate("DOB"));
			customer.setGender(rs.getString("GENDER"));
			customer.setAddress1(rs.getString("ADDRESS1"));
			customer.setAddress2(rs.getString("ADDRESS2"));
			customer.setContactNumber(rs.getString("CONTACT_NO"));
			customer.setEmailId(rs.getString("EMAIL_ID"));
			customer.setCountry(rs.getString("COUNTRY"));
			customer.setState(rs.getString("STATE"));
			customer.setZipCode(rs.getString("ZIP_CODE"));
			customer.setCurrency(rs.getString("CURRENCY"));
			customer.setResidentialType(rs.getString("RESIDENCE_TYPE"));
			customer.setNationality(rs.getString("NATIONALITY"));
			customer.setMartialStatus(rs.getString("MARTIAL_STATUS"));
			customer.setProfession(rs.getString("PROFESSION"));
			customer.setProfessionRemark(rs.getString("PROFESSION_REMARK"));
			//customer.setEnrollmentdate(rs.getDate("ENROLL_DATE"));
			//customer.setHomeBranch(rs.getString("CUST_ENRICH_HOMEBRANCH"));
			//customer.setCustCategory(rs.getString("CUST_ENRICH_CUSTCATEGORY"));
           // customer.setRelOfficer(rs.getString("CUST_ENRICH_REL_OFFICER"));

			return customer;
		}
	}
	@Override
	protected String getUpdateQuery() {
		// TODO Auto-generated method stub
		return ApplicationQuery.EEC_QUERY_UPDATE_ENRCHEDENROLL;
	}

	@Override
	protected String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyEnrichVals(String[] customerVals) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", customerVals[0]);
		params.put("homeBranch", customerVals[1]);
		params.put("custCategory", customerVals[2]);
		params.put("relOfficer", customerVals[3]);
		int rowset = jdbcTemplate.update(ApplicationQuery.EEC_QUERY_UPDATE_ENRCHEDENROLL,params);
		return rowset == 1;
	}

	@Override
	public boolean deleteEnrichedEnroll(String customerCode) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", customerCode);
		int rowset = jdbcTemplate.update(ApplicationQuery.EEC_QUERY_DELETE_ENRCHEDENROLL, params);
		int rowset2 = jdbcTemplate.update(ApplicationQuery.EEC_QUERY_DELETE_AUDIT_VAL, params);

		return (rowset == 1 || rowset2 >= 1);
	}

	@Override
	public boolean resetEnrichStat(String customerCode) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", customerCode);
		int rowset = jdbcTemplate.update(ApplicationQuery.EEC_QUERY_RESET_ENRCH_STAT, params);
		return rowset == 1;
	}

	

}
