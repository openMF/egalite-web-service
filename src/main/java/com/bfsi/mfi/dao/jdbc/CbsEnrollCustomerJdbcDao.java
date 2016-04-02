package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.bfsi.mfi.cbs.model.CbsEnrollCustomer;
import com.bfsi.mfi.cbs.model.CbsEnrollCustomerDocument;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;

import com.bfsi.mfi.dao.CbsEnrollCustomerDao;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.query.ApplicationQuery;

/**
 * 
 * @author Vishal
 *
 */
@Repository("cbsEnrollCustomerJdbcDao")
public class CbsEnrollCustomerJdbcDao extends BaseJdbcDao implements CbsEnrollCustomerDao {
	//private static final String IS_ACTIVE="Y";
	private static final String AUTH_STATUS="A";	
	private static final String QUE_APRVD="A";
	//private static final String NOT_SENT_STATUS="N";

	@Override
	public List<CbsEnrollCustomer> getUnprsdEnrollCustomer(String rowNum) throws ServiceException {
		// TODO Auto-generated method stub
		Map<String, Object> l_params = new HashMap<String, Object>();
		l_params.put("queType", QUE_APRVD);
		l_params.put("authStatus", AUTH_STATUS);	
		//l_params.put("isSent", NOT_SENT_STATUS);	
		l_params.put("batchSize", Integer.valueOf(rowNum));		
		return jdbcTemplate.query(ApplicationQuery.CBS_UNPROCESSED_ENROLL_CUST, l_params,
				new CbsEnrollCustomerRowMapper());		
	}
	
	private static final class CbsEnrollCustomerRowMapper implements RowMapper<CbsEnrollCustomer> {
		public CbsEnrollCustomer mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsEnrollCustomer l_enrollCust = new CbsEnrollCustomer();
			CbsEnrollCustomerDocument l_enrollCustDoc = new CbsEnrollCustomerDocument();
			
			l_enrollCust.setEnrolmentId(rs.getString("ENROLMENT_ID"));
			l_enrollCust.setWorkFlowQueType(rs.getString("WORKFLOW_Q_TYPE"));
			l_enrollCust.setFirstName(rs.getString("FIRST_NAME"));
			l_enrollCust.setLastName(rs.getString("LAST_NAME"));
			l_enrollCust.setMiddleName(rs.getString("MIDDLE_NAME"));
			l_enrollCust.setDob(rs.getDate("DOB"));
			l_enrollCust.setGender(rs.getString("GENDER"));
			l_enrollCust.setResidenceType(rs.getString("RESIDENCE_TYPE"));
			l_enrollCust.setNationality(rs.getString("NATIONALITY"));
			l_enrollCust.setAddress1(rs.getString("ADDRESS1"));
			l_enrollCust.setAddress2(rs.getString("ADDRESS2"));
			l_enrollCust.setAddress3(rs.getString("ADDRESS3"));
			l_enrollCust.setAddress4(rs.getString("ADDRESS4"));
			l_enrollCust.setCity(rs.getString("CITY"));
			l_enrollCust.setState(rs.getString("STATE"));
			l_enrollCust.setZipCode(rs.getString("ZIP_CODE"));
			l_enrollCust.setCountry(rs.getString("COUNTRY"));
			l_enrollCust.setContactNo(rs.getString("CONTACT_NO"));
			l_enrollCust.setEmail(rs.getString("EMAIL_ID"));			
			l_enrollCust.setMaritalStatus(rs.getString("MARTIAL_STATUS"));
			l_enrollCust.setProfession(rs.getString("PROFESSION"));
			l_enrollCust.setProfessionRemark(rs.getString("PROFESSION_REMARK"));
			l_enrollCust.setAccountCategory(rs.getString("ACCOUNT_CATEGORY"));
			l_enrollCust.setAccType(rs.getString("ACCOUNT_TYPE"));
			l_enrollCust.setAccCurrency(rs.getString("CURRENCY"));
			l_enrollCust.setIsActive(rs.getString("IS_ACTIVE"));
			l_enrollCust.setModuleCode(rs.getString("MODULE_CODE"));
			l_enrollCust.setTxnCode(rs.getString("TXN_CODE"));
			l_enrollCust.setTxnInitTime(rs.getDate("TXN_INIT_TIME"));
			//EGA-MN15-000025 Start
			//l_enrollCust.setTxnSyncTime(rs.getDate("TXN_SYNC_TIME"));
			//EGA-MN15-000025 End
			l_enrollCust.setAgentId(rs.getString("AGENT_ID"));
			l_enrollCust.setDeviceId(rs.getString("DEVICE_ID"));
			l_enrollCust.setLocCode(rs.getString("LOCATION_CODE"));
			l_enrollCust.setTxnStatus(rs.getInt("TXN_STATUS"));
			//EGA-MN15-000025 Start
			//l_enrollCust.setTxnErrorCode(rs.getString("TXN_ERR_CODE"));
			//l_enrollCust.setTxnErrorMsg(rs.getString("TXN_ERR_MESSAGE"));
			//EGA-MN15-000025 End
			l_enrollCust.setAuthStatus(rs.getString("AUTH_STATUS"));
			l_enrollCust.setTmpGrpId(rs.getString("TEMP_GROUP_ID"));
			l_enrollCust.setIsKycOnly(rs.getString("IS_KYC_ONLY"));
			l_enrollCust.setCustomerId(rs.getString("CUSTOMER_ID"));
			l_enrollCust.setGroupIndlType(rs.getString("GROUP_INDIVIDUAL_TYPE"));
			l_enrollCust.setPoc(rs.getString("POC"));
			
			l_enrollCustDoc.setEnrolmentId(rs.getString("ENROLMENT_ID"));
			l_enrollCustDoc.setKycCustImage(rs.getBytes("KYC_IMAGE_CUSTOMER"));			
			l_enrollCustDoc.setKycIdImage1(rs.getBytes("KYC_ID_1_IMAGE"));
			l_enrollCustDoc.setKycIdType1(rs.getString("KYC_ID_1_TYPE"));
			l_enrollCustDoc.setKycIdNo1(rs.getString("KYC_ID_1_NUMBER"));
			l_enrollCustDoc.setKycIdProofType1(rs.getString("KYC_ID_1_PROOF_TYPE"));			
			l_enrollCustDoc.setKycIdImage2(rs.getBytes("KYC_ID_2_IMAGE"));
			l_enrollCustDoc.setKycIdType2(rs.getString("KYC_ID_2_TYPE"));
			l_enrollCustDoc.setKycIdNo2(rs.getString("KYC_ID_2_NUMBER"));
			l_enrollCustDoc.setKycIdProofType2(rs.getString("KYC_ID_2_PROOF_TYPE"));			
			l_enrollCustDoc.setKycIdImage3(rs.getBytes("KYC_ID_3_IMAGE"));
			l_enrollCustDoc.setKycIdType3(rs.getString("KYC_ID_3_TYPE"));
			l_enrollCustDoc.setKycIdNo3(rs.getString("KYC_ID_3_NUMBER"));
			l_enrollCustDoc.setKycIdProofType3(rs.getString("KYC_ID_3_PROOF_TYPE"));
			
			l_enrollCustDoc.setImageTemplateRHLF(rs.getBytes("RHLF_TMPLTDATA"));	
			l_enrollCustDoc.setImageTemplateRHRF(rs.getBytes("RHRF_TMPLTDATA"));	
			l_enrollCustDoc.setImageTemplateRHMF(rs.getBytes("RHMF_TMPLTDATA"));	
			l_enrollCustDoc.setImageTemplateRHIF(rs.getBytes("RHIF_TMPLTDATA"));	
			l_enrollCustDoc.setImageTemplateRHTF(rs.getBytes("RHTF_TMPLTDATA"));	
			l_enrollCustDoc.setImageTemplateLHLF(rs.getBytes("LHLF_TMPLTDATA"));	
			l_enrollCustDoc.setImageTemplateLHRF(rs.getBytes("LHRF_TMPLTDATA"));	
			l_enrollCustDoc.setImageTemplateLHMF(rs.getBytes("LHMF_TMPLTDATA"));	
			l_enrollCustDoc.setImageTemplateLHIF(rs.getBytes("LHIF_TMPLTDATA"));	
			l_enrollCustDoc.setImageTemplateLHTF(rs.getBytes("LHTF_TMPLTDATA"));	
			
			l_enrollCustDoc.setImageScanRHLF(rs.getBytes("RHLF_IMAGE_SCAN"));	
			l_enrollCustDoc.setImageScanRHRF(rs.getBytes("RHRF_IMAGE_SCAN"));	
			l_enrollCustDoc.setImageScanRHMF(rs.getBytes("RHMF_IMAGE_SCAN"));	
			l_enrollCustDoc.setImageScanRHIF(rs.getBytes("RHIF_IMAGE_SCAN"));	
			l_enrollCustDoc.setImageScanRHTF(rs.getBytes("RHTF_IMAGE_SCAN"));	
			l_enrollCustDoc.setImageScanLHLF(rs.getBytes("LHLF_IMAGE_SCAN"));	
			l_enrollCustDoc.setImageScanLHRF(rs.getBytes("LHRF_IMAGE_SCAN"));	
			l_enrollCustDoc.setImageScanLHMF(rs.getBytes("LHMF_IMAGE_SCAN"));	
			l_enrollCustDoc.setImageScanLHIF(rs.getBytes("LHIF_IMAGE_SCAN"));	
			l_enrollCustDoc.setImageScanLHTF(rs.getBytes("LHTF_IMAGE_SCAN"));	
			
			l_enrollCust.setDocument(l_enrollCustDoc);
			
	
			return l_enrollCust;
	}
	
	}

	@Override
	public void updateReqEnrolCustStatus(List<CbsEnrollCustomer> p_custList)
			throws ServiceException {		
		try{
			Map<String, String> []l_params=(Map<String, String>[]) new HashMap<?,?>[p_custList.size()];
			for(int l_i=0;l_i<p_custList.size();l_i++){
				l_params[l_i]=new HashMap<String, String>();
				l_params[l_i].put("enrolmentId", p_custList.get(l_i).getEnrolmentId());
				l_params[l_i].put("isSentToCbs", "Y");
			}
			
			jdbcTemplate.batchUpdate(ApplicationQuery.CBS_UPDATE_ENROLL_CUST_REQ, l_params);
		} catch(DataAccessException e){
			
		}
		
		
	}

	@Override
	public void updateResEnrolCustStatus(String enrolId,
			CbsBaseResponse p_res) throws ServiceException {
		// TODO Auto-generated method stub
		Map<String, String> l_params = new HashMap<String, String>();		
		l_params.put("enrolId", enrolId);
		l_params.put("cbsResStat", p_res.getCbsResStat());
		l_params.put("cbsResTxnRefNo", p_res.getCbsResTxnRefNo());
		l_params.put("cbsTxnErrorCode", p_res.getResponseCode());
		l_params.put("cbsTxnErrorDesc", p_res.getResponseMessage());
		if(p_res.getCbsResStat().equalsIgnoreCase("X")){
			l_params.put("isSentToCbs", "N");
		} else {
			l_params.put("isSentToCbs", "Y");
		}
		jdbcTemplate.update(ApplicationQuery.CBS_UPDATE_ENROLL_CUST_RES, l_params);
		
	}

	@Override
	public Date getCurrentBusinessDate() {
		try {
			return super.getBusinessDate();
		} catch (Exception e) {
			return null;
		}

	}

	

}
