package com.bfsi.mfi.dao.jdbc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.bean.CustomerBean;
import com.bfsi.mfi.dao.CustomerDao;
import com.bfsi.mfi.entity.Customer;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.ApplicationUtil;

@Repository("customerDao")
public class CustomerJdbcDao extends ReadOnlyMaintenanceJdbcDao<Customer>
		implements CustomerDao {
	
	private static final String SYNC_STATUS_PEN = "P";
	private static final String SYNC_STATUS_NA = "NA";
	/**NambiAK*/
	private static final String SYNC_STATUS_UPDATE = "U";	
	private String sql;
	
	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.CUS_QUERY_SELECT_ALL;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.CUS_QUERY_SELECT_BY_PK;
	}

	/*
	 * public RowMapper<Loan> getLoanDetailsRowMapper() { return new
	 * LoanMapper(); }
	 */
	@Override
	protected RowMapper<Customer> getRowMapper() {
		return new CustomerMapper();
	}

	/*
	 * @Override public String getAutoCustomerId() { Map<String, String> params
	 * = new HashMap<String, String>(); params.put(null, null); return
	 * jdbcTemplate.queryForObject(QUERY_CUSTOMER_AUTO_ID, params, new
	 * CustomerIDRowMapper()); }
	 */
	private static final class CustomerMapper implements RowMapper<Customer> {

		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			
			customer.setCustomerId(rs.getString("CUSTOMER_ID"));
			customer.setCustomerFullName(rs.getString("CUSTOMER_FULL_NAME"));
			customer.setCustomerShortName(rs.getString("CUSTOMER_SHORT_NAME"));
			customer.setCustomerCategory(rs.getString("CUSTOMER_CATEGORY"));
			customer.setGender(rs.getString("GENDER"));
			customer.setDob(BaseJdbcDao.getUtilDate(rs.getDate("DOB")));
			customer.setCustomerSince(rs.getDate("CUSTOMER_SINCE"));
			customer.setLocationCode(rs.getString("LOCATION_CODE"));
			customer.setAddressLine1(rs.getString("ADDRESS_LINE1"));
			customer.setAddressLine2(rs.getString("ADDRESS_LINE2"));
			customer.setAddressLine3(rs.getString("ADDRESS_LINE3"));
			customer.setAddressLine4(rs.getString("ADDRESS_LINE4"));
			customer.setZipcode(rs.getString("ZIP_CODE"));
			customer.setCity(rs.getString("CITY"));
			customer.setCountry(rs.getString("COUNTRY"));
			customer.setState(rs.getString("STATE"));
			customer.setNationality(rs.getString("NATIONALITY"));
			customer.setAllocatedAgentId(rs.getString("ALLOCATED_AGENT_ID"));
			customer.setLocalBranchCode(rs.getString("LOCAL_BRANCH_CODE"));
			customer.setPreferredLanguage(rs.getString("PREFERRED_LANGUAGE"));
			customer.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
			customer.setMobileNumber(rs.getString("MOBILE_NUMBER"));
			customer.setCreditOfficer(rs.getString("CREDIT_OFFICER"));
			customer.setViewFile(rs.getString("VIEW_FILE"));
			//customer.setCbsGroupCode(rs.getString("cbs_group_code"));
			customer.setSmsFromIbs(rs.getString("sms_from_ibs"));
			customer.setSmsFromMbs(rs.getString("sms_from_mbs"));
			customer.setCollectKyc(rs.getString("collect_kyc"));
			customer.setParentCustId(rs.getString("parent_cust_id"));
			customer.setIsParentCust(rs.getString("is_parent_cust"));
			customer.setGroupId(rs.getString("GROUP_ID"));
				
			try {
				customer.setImage(getImageFromBlob((rs.getBlob("IMAGE"))));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			customer.setRecordStat(rs.getString("RECORD_STAT"));
		    customer.setCbsUpldJobId(rs.getString("CBS_UPLD_JOB_ID"));
			/*customer.setSyncStatus(rs.getString("SYNC_STATUS"));
			customer.setSyncTime(rs.getString("SYNC_TIME"));*/
			return customer;
		}
	}

	private static final class CustomerDetailMapper implements
			RowMapper<Customer> {

		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();

			customer.setCustomerId(rs.getString("CUSTOMER_ID"));
			customer.setCustomerFullName(rs.getString("CUSTOMER_FULL_NAME"));
			customer.setCustomerShortName(rs.getString("CUSTOMER_SHORT_NAME"));
			customer.setCustomerCategory(rs.getString("CUSTOMER_CATEGORY"));
			customer.setGender(rs.getString("GENDER"));
			customer.setDob(BaseJdbcDao.getUtilDate(rs.getDate("DOB")));
			customer.setCustomerSince(rs.getDate("CUSTOMER_SINCE"));
			customer.setLocationCode(rs.getString("LOCATION_CODE"));
			customer.setAddressLine1(rs.getString("ADDRESS_LINE1"));
			customer.setAddressLine2(rs.getString("ADDRESS_LINE2"));
			customer.setAddressLine3(rs.getString("ADDRESS_LINE3"));
			customer.setAddressLine4(rs.getString("ADDRESS_LINE4"));
			customer.setZipcode(rs.getString("ZIP_CODE"));
			customer.setCity(rs.getString("CITY"));
			customer.setCountry(rs.getString("COUNTRY"));
			customer.setState(rs.getString("STATE"));
			customer.setNationality(rs.getString("NATIONALITY"));
			customer.setAllocatedAgentId(rs.getString("ALLOCATED_AGENT_ID"));
			customer.setLocalBranchCode(rs.getString("LOCAL_BRANCH_CODE"));
			customer.setPreferredLanguage(rs.getString("PREFERRED_LANGUAGE"));
			customer.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
			//customer.setSmsRequired(rs.getString("SMS_REQUIRED"));
			customer.setMobileNumber(rs.getString("MOBILE_NUMBER"));
			customer.setCreditOfficer(rs.getString("CREDIT_OFFICER"));
			customer.setViewFile(rs.getString("VIEW_FILE"));
			//customer.setCbsGroupCode(rs.getString("cbs_group_code"));
			customer.setSmsFromIbs(rs.getString("sms_from_ibs"));
			customer.setSmsFromMbs(rs.getString("sms_from_mbs"));
			customer.setCollectKyc(rs.getString("collect_kyc"));
			customer.setParentCustId(rs.getString("parent_cust_id"));
			customer.setIsParentCust(rs.getString("is_parent_cust"));
			customer.setGroupId(rs.getString("GROUP_ID"));
			try {
				customer.setImage(getImageFromBlob((rs.getBlob("IMAGE"))));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			customer.setRecordStat(rs.getString("RECORD_STAT"));
		    customer.setCbsUpldJobId(rs.getString("CBS_UPLD_JOB_ID"));
			/*customer.setSyncStatus(rs.getString("SYNC_STATUS"));
			customer.setSyncTime(rs.getString("SYNC_TIME"));*/
			return customer;
		}
	}

	@Override
	public List<Customer> getCustomersDetail(String agentId, String locCode, String batchSize,List<String> recvdIds) {
		Map<String, Object> l_params = new HashMap<String, Object>();
		l_params.put("agentId", agentId);
		l_params.put("locCode", locCode);
		//params.put("pendStatus", SYNC_STATUS_PEN);
		//params.put("naStatus", SYNC_STATUS_NA);
		l_params.put("batchSize", Integer.valueOf(batchSize));
		//params.put("updateStatus", SYNC_STATUS_UPDATE);/*NambiAK*/
		
		StringBuilder l_queryBuilder=new StringBuilder(ApplicationQuery.CUS_QUERY_CUSTOMER_DETAIL);
		String l_delimiter="";
		if(!recvdIds.isEmpty()){
			l_queryBuilder.append(" AND CUSTOMER_ID NOT IN(");
		}
		for(int l_i=0;l_i<recvdIds.size();l_i++){
			l_params.put("param"+l_i, recvdIds.get(l_i));
			l_queryBuilder.append(l_delimiter + ":param" + l_i);
			l_delimiter=",";
		}
		if(!recvdIds.isEmpty()){
			l_queryBuilder.append(')');
		}
		l_queryBuilder.append(ApplicationQuery.QUERY_BATCH_STRING);
		List<Customer> customers = jdbcTemplate.query(l_queryBuilder.toString(),
				l_params, new CustomerDetailMapper());
		return (customers != null) ? customers : new ArrayList<Customer>();
	}

	@Override
	public void updateCustomerStatus(List<String> customerIdList, String status) {
		Map<String, String> params = new HashMap<String, String>(
				customerIdList.size());
		params.put("status", status);
		StringBuilder sqlQuery = new StringBuilder(ApplicationQuery.CUS_QUERY_SYNC);//"UPDATE IFTB_CUST_DETAIL SET SYNC_STATUS= :status WHERE CUSTOMER_ID IN ("
		String delimiter = "";
		for (int i = 0; i < customerIdList.size(); i++) {
			params.put("param" + i, customerIdList.get(i));
			sqlQuery.append(delimiter + ":param" + i);
			if (i == 0) {
				delimiter = delimiter + ",";
			}
		}
		String query = sqlQuery.toString() + ")";
		jdbcTemplate.update(query, params);

	}

/*	@SuppressWarnings("unchecked")
	@Override
	public void readBlob(String customerId) {
		String sql = "SELECT IMAGE FROM IFTB_CUST_DETAIL WHERE CUSTOMER_ID = :id";
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("id", customerId);
		jdbcTemplate.query(sql, paramsMap, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getBlob("IMAGE");
			}
		});
	}
	*/

	public static byte[] getImageFromBlob(Blob blob) throws SQLException,
			IOException {
		if(blob != null){
		InputStream stream = new BufferedInputStream(blob.getBinaryStream());
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		OutputStream output = new BufferedOutputStream(byteArrayOutputStream);
		int i;
		while (-1 != (i = stream.read())) {
			output.write(i);
		}
		output.flush();
		return byteArrayOutputStream.toByteArray();
		}else{
			return null;
		}
	}
	
	
	//customize search for getting list............
	@Override
	public List<Customer> getSearch(String customerId, String locationCode, String localBranchCode){
		
		CustomerBean bean = new CustomerBean();
		bean.setCUSTOMER_ID(customerId);
		bean.setLOCATION_CODE(locationCode);
		bean.setLOCAL_BRANCH_CODE(localBranchCode);
		
		Class objClass= bean.getClass();
		
		String query = ApplicationQuery.CUS_QUERY_ALLWHERE;
		query = ApplicationUtil.getDynamicQuery(bean, objClass, query); 
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Customer> customers = jdbcTemplate.query(query,
				(Map) null, new CustomerDetailMapper());
		return (customers != null) ? customers : new ArrayList<Customer>();
	}

	
	
}
