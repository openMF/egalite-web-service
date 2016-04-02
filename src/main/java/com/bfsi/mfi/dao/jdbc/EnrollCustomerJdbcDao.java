package com.bfsi.mfi.dao.jdbc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
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
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.AuditTrailDao;
import com.bfsi.mfi.dao.EnrollCustomerDao;
import com.bfsi.mfi.entity.AuditTrail;
import com.bfsi.mfi.entity.CustEnrolBiometric;
import com.bfsi.mfi.entity.EnrollCustomer;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("enrollCustomerDao")
public class EnrollCustomerJdbcDao extends MaintenanceJdbcDao<EnrollCustomer>
		implements EnrollCustomerDao {
	
	@Autowired
	private AuditTrailDao<EnrollCustomer> auditTrailDao;

	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.ENRCUS_QUERY_INSERT;
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.ENRCUS_QUERY_SELECT_ALL;
	}

	@Override
	protected CustomerMapper getRowMapper() {
		return new CustomerMapper();
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.ENRCUS_QUERY_SELECT_BY_PK;
	}

	// not static final
	private static final class CustomerMapper implements    
			RowMapper<EnrollCustomer> {
		
		public EnrollCustomer mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			EnrollCustomer customer = new EnrollCustomer();

			customer.setId(rs.getString("ENROLMENT_ID"));
			customer.setWorkFlowQType(rs.getString("WORKFLOW_Q_TYPE"));
			customer.setFirstName(rs.getString("FIRST_NAME"));
			customer.setLastName(rs.getString("LAST_NAME"));
			customer.setMiddleName(rs.getString("MIDDLE_NAME"));
			customer.setDob(BaseJdbcDao.getUtilDate(rs.getDate("DOB"))); //DATE
			customer.setGender(rs.getString("GENDER"));
			customer.setResidentialType(rs.getString("RESIDENCE_TYPE"));
			customer.setNationality(rs.getString("NATIONALITY"));
			customer.setAddress1(rs.getString("ADDRESS1"));
			customer.setAddress2(rs.getString("ADDRESS2"));
			//Newly added columns address3 & address4
			customer.setAddress3(rs.getString("ADDRESS3"));
			customer.setAddress4(rs.getString("ADDRESS4"));
			customer.setCity(rs.getString("CITY"));
			customer.setState(rs.getString("STATE"));
			customer.setZipCode(rs.getString("ZIP_CODE"));
			customer.setCountry(rs.getString("COUNTRY"));
			customer.setEmailId(rs.getString("EMAIL_ID"));
			customer.setContactNumber(rs.getString("CONTACT_NO"));
			customer.setMartialStatus(rs.getString("MARTIAL_STATUS"));
			customer.setProfession(rs.getString("PROFESSION"));
			customer.setProfessionRemark(rs.getString("PROFESSION_REMARK"));
			customer.setAccountCategory(rs.getString("ACCOUNT_CATEGORY"));
			customer.setAccountType(rs.getString("ACCOUNT_TYPE"));
			customer.setCurrency(rs.getString("CURRENCY"));
			customer.setIsActive(rs.getString("IS_ACTIVE"));
			customer.setModuleCode(rs.getString("MODULE_CODE"));
			customer.setTxnCode(rs.getString("TXN_CODE"));
			customer.setTxnInitTime(rs.getTimestamp("TXN_INIT_TIME")); //data and time
			customer.setTxnSyncTime(rs.getTimestamp("TXN_SYNC_TIME")); //data and time
			customer.setAgentId(rs.getString("AGENT_ID"));
			customer.setDeviceId(rs.getString("DEVICE_ID"));
			customer.setLocationCode(rs.getString("LOCATION_CODE"));
			customer.setTxnStatus(rs.getInt("TXN_STATUS"));
			customer.setTxnErrCode(rs.getString("TXN_ERR_CODE"));
			customer.setTxnErrMessage(rs.getString("TXN_ERR_MESSAGE"));
			customer.setAuthStatus(rs.getString("AUTH_STATUS"));
			
			//******* Newly added columns start from here..........
			customer.setGroupIndividualType(rs.getString("GROUP_INDIVIDUAL_TYPE"));
			customer.setTempGroupId(rs.getString("TEMP_GROUP_ID"));
			customer.setIsKycOnly(rs.getString("IS_KYC_ONLY"));
			customer.setCustomerId(rs.getString("CUSTOMER_ID"));
			customer.setIsSentToCbs(rs.getString("IS_SENT_TO_CBS")); //not in view "ibs_cust_enrol_all_info"
			customer.setCbsResponseStat(rs.getString("CBS_RESPONSE_STAT")); // not in view "ibs_cust_enrol_all_info"
			customer.setCbsResponseTxnRefNo(rs.getString("CBS_RESPONSE_TXN_REF_NO"));// not in "view ibs_cust_enrol_all_info"
			customer.setPoc(rs.getString("POC"));
			
			//******* Newly added columns end here..........
			
			//Customer enrollment KYC info seting.***********
			customer.getCustEnrolKyc().setId(rs.getString("KYC_ENROLMENT_ID"));  
			//customer.getCustEnrolKyc().setKycImageCustomer(getBinaryData(rs,"KYC_IMAGE_CUSTOMER")); 1
			
			//customer.getCustEnrolKyc().setKycId1Image(getBinaryData(rs,"KYC_ID_1_IMAGE")); //FOR IMAGE  ....non static class 2
			customer.getCustEnrolKyc().setKycId1Type(rs.getString("KYC_ID_1_TYPE"));      
			customer.getCustEnrolKyc().setKycId1Number(rs.getString("KYC_ID_1_NUMBER")); 
			customer.getCustEnrolKyc().setKycId1ProofType(rs.getString("KYC_ID_1_PROOF_TYPE"));
			
			//customer.getCustEnrolKyc().setKycId2Image(getBinaryData(rs,"KYC_ID_2_IMAGE")); //FOR IMAGE   3
			customer.getCustEnrolKyc().setKycId2Type(rs.getString("KYC_ID_2_TYPE"));      
			customer.getCustEnrolKyc().setKycId2Number(rs.getString("KYC_ID_2_NUMBER")); 
			customer.getCustEnrolKyc().setKycId2ProofType(rs.getString("KYC_ID_2_PROOF_TYPE"));
			
			//customer.getCustEnrolKyc().setKycId3Image(getBinaryData(rs,"KYC_ID_3_IMAGE")); //FOR IMAGE   4
			customer.getCustEnrolKyc().setKycId3Type(rs.getString("KYC_ID_3_TYPE"));      
			customer.getCustEnrolKyc().setKycId3Number(rs.getString("KYC_ID_3_NUMBER")); 
			customer.getCustEnrolKyc().setKycId3ProofType(rs.getString("KYC_ID_3_PROOF_TYPE"));
			
			try{
				customer.getCustEnrolKyc().setKycImageCustomer(rs.getBytes("KYC_IMAGE_CUSTOMER"));
				customer.getCustEnrolKyc().setKycId1Image(rs.getBytes("KYC_ID_1_IMAGE"));
				customer.getCustEnrolKyc().setKycId2Image(rs.getBytes("KYC_ID_2_IMAGE"));
				customer.getCustEnrolKyc().setKycId3Image(rs.getBytes("KYC_ID_3_IMAGE"));
			}
			catch(Exception e){	
				e.printStackTrace();
			}
			
			return customer;
		}
	}

	@Override
	protected String getUpdateQuery() {
		return null;//ApplicationQuery.ENRCUS_QUERY_UPDATE_ENRCHEDENROLL;
	}

	@Override
	protected String getDeleteQuery() {
		return ApplicationQuery.ENRCUS_QUERY_DELETE_ENRCHEDENROLL;
	}

	@Override
	public List<EnrollCustomer> getEnrollCustomerForAllocation() {
		return null;
	}

	@Override
	public List<EnrollCustomer> getAuthorized() {
		return null;
	}

	@Override
	public boolean isEnrollCustomerCodeAvailable(String enrollCustomerCode) {
		Map<String, String> params = new HashMap<String, String>();
		LoggerUtil.ibsJobDebug("Query isEnrollCustomerCodeAvailable ->"
		+ApplicationQuery.ENRCUS_QUERY_ENROLL_CUST_CODE_AVAILABLE +" Params -> "+enrollCustomerCode);
		params.put("id", enrollCustomerCode);
		SqlRowSet rowset = jdbcTemplate.queryForRowSet(
				ApplicationQuery.ENRCUS_QUERY_ENROLL_CUST_CODE_AVAILABLE, params);
		return !rowset.next();
	}

	@Override
	public boolean updateEnrichStat(String enrollCustomerCode) {
		Map<String, String> params = new HashMap<String, String>();
		
		LoggerUtil.ibsJobDebug("Query updateEnrichStat ->"
				+ApplicationQuery.ENRCUS_QUERY_UPDATE_ENRCH_STAT +" Params -> "+enrollCustomerCode);
		
		params.put("id", enrollCustomerCode);

		int rowset = jdbcTemplate.update(ApplicationQuery.ENRCUS_QUERY_UPDATE_ENRCH_STAT, params);
		return rowset == 1;
	}

	//update 
	@Override
	public EnrollCustomer update(EnrollCustomer entity) {
		AuditTrail<EnrollCustomer> auditTrail = new AuditTrail<EnrollCustomer>(entity);
		auditTrail.setVersion(auditTrailDao.getMaxVersion(entity) + 1);

		EnrollCustomer oldEntity = get(entity.getId());
		auditTrail.setObjectXml(AuditTrail.getObjectXmlFromEntity(oldEntity));
		auditTrailDao.auditUpdate(auditTrail);

		String sql1 = ApplicationQuery.ENRCUS_QUERY_UPDATE_CUSTINFO;
		Map<String, Object> params1 = new HashMap<String, Object>();
		
		params1.put("id", entity.getId());
		params1.put("workFlowQType", entity.getWorkFlowQType());//RECODE STATUS CHANGE
		params1.put("firstName", entity.getFirstName());
		params1.put("lastName", entity.getLastName());
		params1.put("middleName", entity.getMiddleName());
		params1.put("dob", entity.getDob());
		params1.put("gender", entity.getGender());
		params1.put("residentialType", entity.getResidentialType());
		params1.put("nationality", entity.getNationality());
		params1.put("address1", entity.getAddress1());
		params1.put("address2", entity.getAddress2());
		//Newly added columns address3 & address4
		params1.put("address3", entity.getAddress3());
		params1.put("address4", entity.getAddress4());
		//params1.put("city", entity.getCity());
		params1.put("state", entity.getState());
		params1.put("zipCode", entity.getZipCode());
		params1.put("country", entity.getCountry());
		params1.put("emailId", entity.getEmailId());
		params1.put("contactNumber", entity.getContactNumber());
		params1.put("martialStatus", entity.getMartialStatus());
		params1.put("profession", entity.getProfession());
		params1.put("professionRemark", entity.getProfessionRemark());
		//params1.put("accountCategory", entity.getAccountCategory());
		//params1.put("accountType", entity.getAccountType());
		//params1.put("currency", entity.getCurrency());
		//params1.put("isActive", entity.getIsActive());
		//params1.put("moduleCode", entity.getModuleCode());
		//params1.put("txnCode", entity.getTxnCode());
		//params1.put("txnInitTime", entity.getTxnInitTime());
		//params1.put("txnSyncTime", entity.getTxnSyncTime());
		//params1.put("agentId", entity.getAgentId());
		//params1.put("deviceId", entity.getDeviceId());
		//params1.put("locationCode", entity.getLocationCode());
		//params1.put("txnStatus", entity.getTxnStatus());
		//params1.put("txnErrCode", entity.getTxnErrCode());
		//params1.put("txnErrMessage", entity.getTxnErrMessage());
		params1.put("authStatus", entity.getAuthStatus());
		
		LoggerUtil.ibsJobDebug("Query update ->"+sql1 );
		
		jdbcTemplate.execute(sql1, params1,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});
		
		String sql2 = ApplicationQuery.ENRCUS_QUERY_UPDATE_ENRCHEDENROLL;
		
		Map<String, String> params2 = new HashMap<String, String>();
		params2.put("kycId", entity.getCustEnrolKyc().getId());
		params2.put("kycId1Type", entity.getCustEnrolKyc().getKycId1Type());
		params2.put("kycId1Number", entity.getCustEnrolKyc().getKycId1Number());
		params2.put("kycId1ProofType", entity.getCustEnrolKyc().getKycId1ProofType());
		params2.put("kycId2Type", entity.getCustEnrolKyc().getKycId2Type());
		params2.put("kycId2Number", entity.getCustEnrolKyc().getKycId2Number());
		params2.put("kycId2ProofType", entity.getCustEnrolKyc().getKycId2ProofType());
		params2.put("kycId3Type", entity.getCustEnrolKyc().getKycId3Type());
		params2.put("kycId3Number", entity.getCustEnrolKyc().getKycId3Number());
		params2.put("kycId3ProofType", entity.getCustEnrolKyc().getKycId3ProofType());
		
		
		jdbcTemplate.execute(sql2, params2,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});
		
		return entity;
	}

	@Override
	protected String getUpdateByAuthQuery() {
		return ApplicationQuery.ENRCUS_QUERY_UPDATE_BY_AUTH;
	}
	
	  
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
	
	
	
	public EnrollCustomer rejected(EnrollCustomer entity){
		AuditTrail<EnrollCustomer> auditTrail = new AuditTrail<EnrollCustomer>(entity);
		auditTrailDao.auditAuth(auditTrail);
	
		String sql = getUpdateRejectQuery();
		LoggerUtil.ibsJobDebug("Query authorize ->"+sql);
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				entity);
	jdbcTemplate.execute(sql, namedParameters,
			new PreparedStatementCallback<Object>() {
				@Override
				public Object doInPreparedStatement(PreparedStatement stmt)
						throws SQLException, DataAccessException {
					return stmt.executeUpdate();
				}
			});
	   return entity;
	}
	
	protected String getUpdateRejectQuery(){
		return ApplicationQuery.ENRCUS_QUERY_UPDATE_BY_REJECT;
	}
	
	
	public EnrollCustomer getModifyRecord(String id){
		String sql = ApplicationQuery.ENRCUS_MODIFY_GET_ALL_PK; //query
		Map<String, String> params = new HashMap<String, String>();
		LoggerUtil.ibsJobDebug("Query get by PK ->"+sql +" Params -> "+id);
		params.put("id", id);
		try {
			return jdbcTemplate.queryForObject(sql, params, new CustomerMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public CustEnrolBiometric getBiomatric(String id){
		String sql = ApplicationQuery.GET_BIOMATRIC_SELECT_PK; //query
		Map<String, String> params = new HashMap<String, String>();
		LoggerUtil.ibsJobDebug("Query get by PK ->"+sql +" Params -> "+id);
		params.put("id", id);
		try {
			return jdbcTemplate.queryForObject(sql, params, new BiomatricMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	private static final class BiomatricMapper implements  RowMapper<CustEnrolBiometric> {
     public CustEnrolBiometric mapRow(ResultSet rs, int rowNum)
		throws SQLException {
    	 CustEnrolBiometric customer = new CustEnrolBiometric();
    	 
    	       // customer.setId(rs.getString("ENROLMENT_ID"));
	      try{
				customer.setRhlfTepltdata(rs.getBytes("RHLF_TMPLTDATA"));
				customer.setRhrfTemltdata(rs.getBytes("RHRF_TMPLTDATA"));
				customer.setRhmfTemltdata(rs.getBytes("RHMF_TMPLTDATA"));
				customer.setRhifTmpltdata(rs.getBytes("RHIF_TMPLTDATA"));
				customer.setRhtfTmpltdata(rs.getBytes("RHTF_TMPLTDATA"));
				
				customer.setLhlfTmpldata(rs.getBytes("LHLF_TMPLTDATA"));
				customer.setLhrfTmpltdata(rs.getBytes("LHRF_TMPLTDATA"));
				customer.setLhmfTmpltdata(rs.getBytes("LHMF_TMPLTDATA"));
				customer.setLhifTmpltdata(rs.getBytes("LHIF_TMPLTDATA"));
				customer.setLhtfTmpltdata(rs.getBytes("LHTF_TMPLTDATA"));
				
				customer.setRhlfImageScan(rs.getBytes("RHLF_IMAGE_SCAN"));
				customer.setRhrfImageScan(rs.getBytes("RHRF_IMAGE_SCAN"));
				customer.setRhmfImageScan(rs.getBytes("RHMF_IMAGE_SCAN"));
				customer.setRhifImageScan(rs.getBytes("RHIF_IMAGE_SCAN"));
				customer.setRhtfImageScan(rs.getBytes("RHTF_IMAGE_SCAN"));
				
				customer.setLhlfImaageScan(rs.getBytes("LHLF_IMAGE_SCAN"));
				customer.setLhrfImageScan(rs.getBytes("LHRF_IMAGE_SCAN"));
				customer.setLhmfImageScan(rs.getBytes("LHMF_IMAGE_SCAN"));
				customer.setLhifImageScan(rs.getBytes("LHIF_IMAGE_SCAN"));
				customer.setLhtfImageScan(rs.getBytes("LHTF_IMAGE_SCAN"));
				
			}
			catch(Exception e){	
				e.printStackTrace();
			}
			
			return customer;
		}
	}
	
	
	
	@Override
	public List<EnrollCustomer> getDatatList(String tempGroupId){
		     String sql = ApplicationQuery.ENRCUS_GET_CHILD_GROUP;
		     Map<String, String> params = new HashMap<String, String>();
			LoggerUtil.ibsJobDebug("Query get by PK ->"+sql +" Params -> "+tempGroupId);
			params.put("tempGroupId", tempGroupId);
	        
	return jdbcTemplate.query(sql, params, getRowMapper());
		
		
	}
	/*Tag no : EGA-MN15-000018 Start*/
	@Override
	public String getValueKyc(String id, String listName) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("value", id);
		params.put("listName", listName);
		return jdbcTemplate.queryForObject(ApplicationQuery.LOV_QUERY_SELECT_BY_KYCID, params, new KycMapper());
	}
	
	private static final class KycMapper implements RowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString(1);
		}
	}
	/*Tag no : EGA-MN15-000018 End*/
	
}
