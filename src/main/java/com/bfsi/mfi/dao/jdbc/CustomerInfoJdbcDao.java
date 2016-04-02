package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CustomerInfoDao;
import com.bfsi.mfi.entity.CustomerDocumentInfo;
import com.bfsi.mfi.entity.CustomerEnrolmentInfo;
import com.bfsi.mfi.entity.CustomerInfo;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("customerInfoDao")
public class CustomerInfoJdbcDao extends MaintenanceJdbcDao<CustomerInfo>
		implements CustomerInfoDao {

	public static final String RECEIVED_STATUS = "RECEIVED";
	private static final String PENDING_STATUS = "PENDING";
	
	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectAllQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected RowMapper<CustomerInfo> getRowMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCustomerInfo(CustomerInfo customerInfo) {
		SqlParameterSource customerParams = new BeanPropertySqlParameterSource(
				customerInfo);
		jdbcTemplate.update(ApplicationQuery.CUSINFO_QUERY_INSERT, customerParams);
	}

	@Override
	public String checkReceivedId(String id) {
		String sessionId = null;
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("status", RECEIVED_STATUS);
		try {
			sessionId = jdbcTemplate.queryForObject(ApplicationQuery.CUSINFO_QUERY_SELECT_SESSIONID,
					params, String.class);
		} catch (DataAccessException e) {
			LoggerUtil.ibsJobError("DataAccessException : MFI10001", e);
			return null;
		}
		return sessionId;
	}

	@Override
	public void deleteIdRecord(List<String> pendingIdList) {
		Map<String, String> params = new HashMap<String, String>(
				pendingIdList.size());
		params.put("status", PENDING_STATUS);
		StringBuilder sqlQuery = new StringBuilder(ApplicationQuery.CUSINFO_QUERY_DELETE);//"DELETE FROM IFTB_TRANSACTION_STATUS WHERE STATUS=:status AND TXN_ID  IN ("
		String delimiter = "";
		for (int i = 0; i < pendingIdList.size(); i++) {
			params.put("param" + i, pendingIdList.get(i));
			sqlQuery.append(delimiter + ":param" + i);
			if (i == 0) {
				delimiter = delimiter + ",";
			}
		}
		String query = sqlQuery.toString() + ")";
		jdbcTemplate.update(query, params);
	}

	@Override
	public void insertIdStatus(String id, String syncsessionid) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("syncsessionid", syncsessionid);
		jdbcTemplate.update(ApplicationQuery.CUSINFO_QUERY_INSERT_IDSTATUS, params);

	}

	@Override
	public void updateEnrollmentIdStatus(List<String> enrollmentIdList) {
		Map<String, String> params = new HashMap<String, String>(
				enrollmentIdList.size());
		params.put("status", PENDING_STATUS);
		params.put("recvStatus", RECEIVED_STATUS);
		StringBuilder sqlQuery = new StringBuilder(ApplicationQuery.CUSINFO_QUERY_TXNSTATUS);//"UPDATE IFTB_TRANSACTION_STATUS SET STATUS=:recvStatus WHERE STATUS=:status AND TXN_ID  IN ("
		String delimiter = "";
		for (int i = 0; i < enrollmentIdList.size(); i++) {
			params.put("param" + i, enrollmentIdList.get(i));
			sqlQuery.append(delimiter + ":param" + i);
			if (i == 0) {
				delimiter = delimiter + ",";
			}
		}
		String query = sqlQuery.toString() + ")";
		jdbcTemplate.update(query, params);

	}

	@Override
	public void submitCustPersonalInfo(CustomerEnrolmentInfo p_custInfo) {
		SqlParameterSource customerParams = new BeanPropertySqlParameterSource(p_custInfo);
		jdbcTemplate.update(ApplicationQuery.QUERY_INSERT_CUST_INFO, customerParams);
		//jdbcTemplate.update(ApplicationQuery.ENRCUS_QUERY_UPDATE_BY_AUTH, customerParams);
		
	}

	@Override
	public void submitCustomerDocInfo(CustomerDocumentInfo p_custDocInfo) {
		
		SqlParameterSource customerParams = new BeanPropertySqlParameterSource(
				p_custDocInfo);
		jdbcTemplate.update(ApplicationQuery.QUERY_INSERT_CUST_DOC_INFO, customerParams);
		
	}
	@SuppressWarnings("unused")
	private static class CustPersonalInfoMapper implements RowMapper<CustomerEnrolmentInfo>{

		@Override
		public CustomerEnrolmentInfo mapRow(ResultSet rs,
				int rowNum) throws SQLException {
			
			
			return null;
		}
		
	}
}
