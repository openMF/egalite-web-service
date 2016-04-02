package com.cbs.rmi.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Types;

import org.apache.cxf.common.util.Base64Utility;
import org.springframework.dao.DataAccessException;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.query.InterfaceQuery;
import com.bfsi.mfi.util.ApplicationUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.cbs.bean.CbsBaseTransRequest;
import com.cbs.bean.CbsBaseTransResponse;
import com.cbs.bean.CustomerDocument;
import com.cbs.bean.CustomerEnrolInfo;

public class CbsTransactionJdbcDao {


	public CbsBaseTransResponse postTransaction(CbsBaseTransRequest p_request)
			throws Exception {
		CbsBaseTransResponse l_res = new CbsBaseTransResponse();
		DBConnection conMangr = DBConnection.getInstance(); 
		Connection conn = null;
		PreparedStatement preStmt = null;
		int result = 0;
		try {
			conn = conMangr.getConnection();
			/*String insertSql = "INSERT INTO cbx_cbs_txn_out (MFI_OUT_SEQNO,MBS_TXN_REF_NO,MBS_TXN_SEQ_NO,CBS_AC_REF_NO,CUSTOMER_ID,CBS_BRANCH_CODE,MODULE_CODE,TXN_CODE,TXN_IDENTIFIER,SYNC_TYPE,IS_REQ_OR_TXN,"
						+"LOG_TIME,CBS_SENT_TIME,CBS_RESPONSE_STAT,CBS_RESPONSE_TXN_REF_NO,CBS_RESPOND_TIME,CBS_ERROR_CODE,CBS_ERROR_DESC,IBS_AGENDA_ID,"
						+"IBS_AGENDA_SEQ_NO,TXN_AMT_DUE_LCY,TXN_AMT_DUE,TXN_AMT_SETTLED_LCY,TXN_AMT_SETTLED,TXN_CCY_CODE,TXN_LCY_CODE,FULL_PARTIAL_IND,MBS_TXN_NARRATIVE,"
						+"REQ_DEP_NO_INST,REQ_RED_REQ_DT,REQ_RED_FULL_PART_IND,REQ_MATURITY_DATE,REQ_INT_RATE,REQ_DP_TENURE_TYPE,REQ_DP_FREQUENCY_TYPE,REQ_DP_FREQUENCY,"
						+"REQ_DP_TENURE,IS_GROUP_LOAN,IS_PARENT_LOAN,IS_PARENT_CUSTOMER,PARENT_CUSTOMER_ID,PARENT_CBS_AC_REF_NO, INTERNAL_PROCESS_FLAG, PROCESSED_DATE_TIME, BUSINESS_DATE)"
						+" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			preStmt = conn.prepareStatement(insertSql);*/			
			preStmt = conn.prepareStatement(InterfaceQuery.CBS_QUERY_TXNS_OUT);		
			
			preStmt.setString(1, p_request.getMfiOutSeqno());
			preStmt.setString(2, p_request.getMbsTxnRefNo());
			preStmt.setString(3, p_request.getMbsTxnSeqNo());
			preStmt.setString(4, p_request.getCbsAcRefNo());
			preStmt.setString(5, p_request.getCustomerId());
			preStmt.setString(6, p_request.getCbsBranchCode());
			preStmt.setString(7, p_request.getModuleCode());
			preStmt.setString(8, p_request.getTxnCode());
			preStmt.setString(9, p_request.getTxnIdentifier());
			preStmt.setString(10, p_request.getSyncType());
			preStmt.setString(11, p_request.getIsReqOrTxn());			
			if( p_request.getLogTime()!=null){
				preStmt.setDate(12,  new java.sql.Date(p_request.getLogTime().getTime()));//LOG_TIME
			} else {
				preStmt.setNull(12,Types.DATE);
			}
			if( p_request.getCbsSentTime()!=null){
				preStmt.setDate(13,  new java.sql.Date(p_request.getCbsSentTime().getTime()));//CBS_SENT_TIME
			} else {
				preStmt.setNull(13,Types.DATE);
			}			
			preStmt.setString(14, p_request.getCbsResStat());
			preStmt.setString(15, p_request.getCbsResTxnRefNo());
			if( p_request.getCbsResTime()!=null){
				preStmt.setDate(16,  new java.sql.Date(p_request.getCbsResTime().getTime()));//CBS_RESPOND_TIME
			} else {
				preStmt.setNull(16,Types.DATE);
			}			
			preStmt.setString(17, p_request.getCbsErrCode());
			preStmt.setString(18, p_request.getCbsErrDesc());
			preStmt.setString(19, p_request.getIbsAgnId());
			preStmt.setLong(20, p_request.getIbsAgnSeqNo());//IBS_AGENDA_SEQ_NO
			preStmt.setString(21, p_request.getAgnAmtDueCcy());			
			preStmt.setDouble(22, p_request.getAgnAmtDue());//TXN_AMT_DUE
			preStmt.setString(23, p_request.getAgnAmtSettledCcy());
			preStmt.setDouble(24, p_request.getAgnAmtSettled());//TXN_AMT_SETTLED
			preStmt.setString(25, p_request.getTxnCcy());
			preStmt.setString(26, p_request.getTxnLocalCcy());
			preStmt.setString(27, p_request.getFullPartialInd());
			preStmt.setString(28, p_request.getMbsTxnNarrative());
			preStmt.setLong(29, p_request.getReqDepNoInst());//REQ_DEP_NO_INST
			if( p_request.getReqRedReqDt()!=null){
				preStmt.setDate(30,  new java.sql.Date(p_request.getReqRedReqDt().getTime()));//REQ_RED_REQ_DT
			} else {
				preStmt.setNull(30,Types.DATE);
			}			
			preStmt.setString(31, p_request.getReqRedFullPartInd());
			if( p_request.getReqMaturityDate()!=null){
				preStmt.setDate(32,  new java.sql.Date(p_request.getReqMaturityDate().getTime()));//REQ_MATURITY_DATE
			} else {
				preStmt.setNull(32,Types.DATE);
			}			
			preStmt.setDouble(33, p_request.getReqIntRate());//REQ_INT_RATE
			preStmt.setString(34, p_request.getReqDpTenureType());
			preStmt.setString(35, p_request.getReqDpFrqType());
			preStmt.setLong(36, p_request.getReqDpFrq());//REQ_DP_FREQUENCY
			preStmt.setLong(37, p_request.getReqDpTenure());//REQ_DP_TENURE
			preStmt.setString(38, p_request.getIsGroupLoan());
			preStmt.setString(39, p_request.getIsParentLoan());
			preStmt.setString(40, p_request.getIsParentCust());
			preStmt.setString(41, p_request.getParentCustId());
			preStmt.setString(42, p_request.getParentCbsAccRefNo());
			preStmt.setString(43, "N");
			preStmt.setDate(44, null);
			LoggerUtil.ibsJobDebug("==================================================== Date ===========" + p_request.getBusiDate());
			
			if( p_request.getBusiDate()!=null){
				preStmt.setDate(45, (Date) p_request.getBusiDate());//BUSINESS_DATE
			} else {
				preStmt.setNull(45,Types.DATE);
			}
			result = preStmt.executeUpdate();
			if(result != 0){
				l_res.setCbsResStat("P");
				l_res.setResponseCode("0");
				l_res.setResponseMessage("Transaction processed successfuly.");
				l_res.setCbsResTxnRefNo(generateRandomId());
			} else {
				l_res.setCbsResStat("E");
				l_res.setResponseCode("1");
				l_res.setResponseMessage("Transaction Failed.");
			}
			
			if (preStmt != null) {
				preStmt.close();
			}
			
		} catch (DataAccessException e) {
			l_res.setCbsResStat("X");
			l_res.setResponseCode("1");
			l_res.setResponseMessage("Transaction Failed.");
        	throw new ServiceException("DataAccessException while insert CBX_CUST_ENROL_INFO = " + e);
        } catch (Exception e) {
        	l_res.setCbsResStat("X");
			l_res.setResponseCode("1");
			l_res.setResponseMessage("Transaction Failed.");
        	throw new ServiceException("Unhandled exception while insert CBX_CUST_ENROL_INFO = " + e);	
		} finally {
			if (preStmt != null) {
				preStmt = null;
			}
			conMangr.closeConnection(conn);
		}
		return l_res;
	}
	
	private String generateRandomId() {
		StringBuffer uniqueRandomId = new StringBuffer(50);
		char c[] = new char[12];
		java.util.Random r = new java.util.Random();
		String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < 12; i++) {
			int j = r.nextInt(62);
			if (s.length() > j) {
				c[i] = s.charAt(j);
				uniqueRandomId.append(c[i]);
				//uniqueRandomId += c[i];
			} else {
				i--;
			}
		}
		return uniqueRandomId.toString();
	}

	
	public int postCustPersonalEnrolInfo(CustomerEnrolInfo p_request)
			throws Exception {
		LoggerUtil.ibsJobDebug("CBX_CUST_ENROL_INFO ==================================================================");
		//CbsBaseTransResponse l_res = new CbsBaseTransResponse();
		DBConnection conMangr = DBConnection.getInstance(); 
		Connection conn = null;
		PreparedStatement preStmt = null;
		int result = 0;
		try {
			conn = conMangr.getConnection();	
			
			LoggerUtil.ibsJobDebug("Insert into CBX_CUST_ENROL_INFO ====================================================");
			
			/*String inserQuery ="INSERT INTO CBX_CUST_ENROL_INFO(ENROLMENT_ID,WORKFLOW_Q_TYPE,FIRST_NAME,"
					+ "LAST_NAME,MIDDLE_NAME,DOB,GENDER,RESIDENCE_TYPE,NATIONALITY,ADDRESS1,ADDRESS2,CITY,STATE,ZIP_CODE,COUNTRY,"
					+ "EMAIL_ID,CONTACT_NO,MARTIAL_STATUS,PROFESSION,PROFESSION_REMARK,ACCOUNT_CATEGORY,ACCOUNT_TYPE,CURRENCY,"
					+ "IS_ACTIVE,MODULE_CODE,TXN_CODE,TXN_INIT_TIME,TXN_SYNC_TIME,AGENT_ID,DEVICE_ID,LOCATION_CODE,TXN_STATUS,"
					+ "TXN_ERR_CODE,TXN_ERR_MESSAGE,TEMP_GROUP_ID,IS_KYC_ONLY,CUSTOMER_ID,GROUP_INDIVIDUAL_TYPE,POC,"
					+ "ADDRESS3,ADDRESS4,INTERNAL_PROCESS_FLAG, PROCESSED_DATE_TIME, BUSINESS_DATE) VALUES(?,?,?,?,?,"
					+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preStmt = conn.prepareStatement(inserQuery);*/			
			
			preStmt = conn.prepareStatement(InterfaceQuery.CBS_QUERY_CUST_ENROLL);		
			preStmt.setString(1, p_request.getEnrolmentId());
			preStmt.setString(2, p_request.getWorkFlowQueType());
			preStmt.setString(3, p_request.getFirstName());
			preStmt.setString(4, p_request.getLastName());
			preStmt.setString(5, p_request.getMiddleName());
			if(p_request.getDob()!= null){
				preStmt.setDate(6, 	 ApplicationUtil.longAsSqlDateFormat(p_request.getDob()));
			}
			else{
				preStmt.setNull(6,Types.DATE);
			}					
			preStmt.setString(7, p_request.getGender());
			preStmt.setString(8, p_request.getResidenceType());
			preStmt.setString(9, p_request.getNationality());
			preStmt.setString(10, p_request.getAddress1());
			preStmt.setString(11, p_request.getAddress2());
			preStmt.setString(12, p_request.getCity());
			preStmt.setString(13, p_request.getState());
			preStmt.setString(14, p_request.getZipCode());
			preStmt.setString(15, p_request.getCountry());
			preStmt.setString(16, p_request.getEmail());
			preStmt.setString(17, p_request.getContactNo());
			preStmt.setString(18, p_request.getMaritalStatus());
			preStmt.setString(19, p_request.getProfession());
			preStmt.setString(20, p_request.getProfessionRemark());
			preStmt.setString(21, p_request.getAccountCategory());
			preStmt.setString(22, p_request.getAccType());
			preStmt.setString(23, p_request.getAccCurrency());
			preStmt.setString(24, p_request.getIsActive());
			preStmt.setString(25, p_request.getModuleCode());
			preStmt.setString(26, p_request.getTxnCode());
			if(p_request.getTxnInitTime() !=null){
				preStmt.setDate(27, ApplicationUtil.longAsSqlDateFormat(p_request.getTxnInitTime()));
			}else {
				preStmt.setNull(27,Types.DATE);
			}
				
			if(p_request.getTxnSyncTime() !=null){
				preStmt.setDate(28, ApplicationUtil.longAsSqlDateFormat(p_request.getTxnSyncTime()));
			} else {
				preStmt.setNull(28,Types.DATE);
			}
			preStmt.setString(29, p_request.getAgentId());
			preStmt.setString(30, p_request.getDeviceId());
			preStmt.setString(31, p_request.getLocCode());				
			preStmt.setInt(32, p_request.getTxnStatus());
			preStmt.setString(33, p_request.getTxnErrorCode());
			preStmt.setString(34, p_request.getTxnErrorMsg());
			//preStmt.setString(35, p_request.getAuthStatus());
			preStmt.setString(35, p_request.getTmpGrpId());
			preStmt.setString(36, p_request.getIsKycOnly());
			preStmt.setString(37, p_request.getCustomerId());
			preStmt.setString(38, p_request.getGroupIndlType());
			preStmt.setString(39, p_request.getPoc());
			preStmt.setString(40, p_request.getAddress3());
			preStmt.setString(41, p_request.getAddress4());
			preStmt.setString(42, "N");
			preStmt.setDate(43, null);
			
			if( p_request.getBusiDate()!=null){
				preStmt.setDate(44,  (Date)p_request.getBusiDate());//BUSINESS_DATE
			} else {
				preStmt.setNull(44,Types.DATE);
			}
			LoggerUtil.ibsJobDebug("Insert into CBX_CUST_ENROL_INFO 1 ====================================================");
			result = preStmt.executeUpdate();
			LoggerUtil.ibsJobDebug("Insert into CBX_CUST_ENROL_INFO 2 ====================================================");
			
		} catch (DataAccessException e) {
			result = 0;
			throw new ServiceException("DataAccessException while insert CBX_CUST_ENROL_INFO = " + e);
        } catch (Exception e) {
        	result = 0;
        	throw new ServiceException("Unhandled exception while insert CBX_CUST_ENROL_INFO = " + e);	
		} finally{
			if (preStmt != null) {
				preStmt = null;
			}
			conMangr.closeConnection(conn);
		}
		return result ;
	}

	public int postCustDocInfo(CustomerDocument p_request)
			throws Exception {
		//CbsBaseTransResponse l_res = new CbsBaseTransResponse();
		DBConnection conMangr = DBConnection.getInstance(); 
		//LoggerUtil.cbsJobDebug("CustomerDocument CBS call=================");
		Connection conn = null;
		PreparedStatement preStmt = null;
		int result = 0;
		try {
			conn = conMangr.getConnection();		
			
			/*String inserQuery ="INSERT INTO CBX_CUST_ENROL_KYC(ENROLMENT_ID,KYC_IMAGE_CUSTOMER,"
					+ "KYC_ID_1_IMAGE,KYC_ID_1_TYPE,KYC_ID_1_NUMBER,KYC_ID_1_PROOF_TYPE,KYC_ID_2_IMAGE,KYC_ID_2_TYPE,KYC_ID_2_NUMBER,"
					+ "KYC_ID_2_PROOF_TYPE,KYC_ID_3_IMAGE,KYC_ID_3_TYPE,KYC_ID_3_NUMBER,KYC_ID_3_PROOF_TYPE) VALUES(?,?,?,?,?,"
					+ "?,?,?,?,?,?,?,?,?)";
			
			String insertBiometricInfo="INSERT INTO CBX_CUST_ENROL_BIOMETRIC(ENROLMENT_ID,RHLF_TMPLTDATA,RHRF_TMPLTDATA,RHMF_TMPLTDATA"
					+ ",RHIF_TMPLTDATA,RHTF_TMPLTDATA,LHLF_TMPLTDATA,LHRF_TMPLTDATA,LHMF_TMPLTDATA,LHIF_TMPLTDATA,LHTF_TMPLTDATA,"
					+ "RHLF_IMAGE_SCAN,RHRF_IMAGE_SCAN,RHMF_IMAGE_SCAN,RHIF_IMAGE_SCAN,RHTF_IMAGE_SCAN,LHLF_IMAGE_SCAN,"
					+ "LHRF_IMAGE_SCAN,LHMF_IMAGE_SCAN,LHIF_IMAGE_SCAN,LHTF_IMAGE_SCAN) VALUES"
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";*/
			
			//preStmt = conn.prepareStatement(inserQuery);			
			preStmt = conn.prepareStatement(InterfaceQuery.CBS_QUERY_CUST_KYC);		
			
			preStmt.setString(1, p_request.getEnrolmentId());		
			if (p_request.getKycCustImage() != null) {			
				preStmt.setBytes(2,Base64Utility.decode(p_request.getKycCustImage()));
			} else {
				preStmt.setBytes(2,null);
			}
			
			if (p_request.getKycIdImage1() != null) {			
				preStmt.setBytes(3,Base64Utility.decode(p_request.getKycIdImage1()));
			} else {
				preStmt.setBytes(3,null);
			}						
			preStmt.setString(4, p_request.getKycIdType1());
			preStmt.setString(5, p_request.getKycIdNo1());
			preStmt.setString(6, p_request.getKycIdProofType1());
			
			if (p_request.getKycIdImage2() != null) {			
				preStmt.setBytes(7,Base64Utility.decode(p_request.getKycIdImage2()));
			} else {
				preStmt.setBytes(7,null);
			}
			preStmt.setString(8, p_request.getKycIdType2());
			preStmt.setString(9, p_request.getKycIdNo2());
			preStmt.setString(10, p_request.getKycIdProofType2());
			
			if (p_request.getKycIdImage3() != null) {			
				preStmt.setBytes(11,Base64Utility.decode(p_request.getKycIdImage3()));
			} else {
				preStmt.setBytes(11,null);
			}
			preStmt.setString(12, p_request.getKycIdType3());
			
			preStmt.setString(13, p_request.getKycIdNo3());
			preStmt.setString(14, p_request.getKycIdProofType3());
			
			result = preStmt.executeUpdate();
			
			//preStmt = conn.prepareStatement(insertBiometricInfo);	
			preStmt = conn.prepareStatement(InterfaceQuery.CBS_QUERY_CUST_BIO_INFO);		
			
			preStmt.setString(1, p_request.getEnrolmentId());	
			if (p_request.getImageTemplateRHLF() != null) {			
				preStmt.setBytes(2,Base64Utility.decode(p_request.getImageTemplateRHLF()));
			} else {
				preStmt.setBytes(2,null);
			}
			if (p_request.getImageTemplateRHRF() != null) {			
				preStmt.setBytes(3,Base64Utility.decode(p_request.getImageTemplateRHRF()));
			} else {
				preStmt.setBytes(3,null);
			}
			if (p_request.getImageTemplateRHMF() != null) {			
				preStmt.setBytes(4,Base64Utility.decode(p_request.getImageTemplateRHMF()));
			} else {
				preStmt.setBytes(4,null);
			}
			if (p_request.getImageTemplateRHIF() != null) {			
				preStmt.setBytes(5,Base64Utility.decode(p_request.getImageTemplateRHIF()));
			} else {
				preStmt.setBytes(5,null);
			}
			if (p_request.getImageTemplateRHTF() != null) {			
				preStmt.setBytes(6,Base64Utility.decode(p_request.getImageTemplateRHTF()));
			} else {
				preStmt.setBytes(6,null);
			}
			if (p_request.getImageTemplateLHLF() != null) {			
				preStmt.setBytes(7,Base64Utility.decode(p_request.getImageTemplateLHLF()));
			} else {
				preStmt.setBytes(7,null);
			}
			if (p_request.getImageTemplateLHRF() != null) {			
				preStmt.setBytes(8,Base64Utility.decode(p_request.getImageTemplateLHRF()));
			} else {
				preStmt.setBytes(8,null);
			}
			if (p_request.getImageTemplateLHMF() != null) {			
				preStmt.setBytes(9,Base64Utility.decode(p_request.getImageTemplateLHMF()));
			} else {
				preStmt.setBytes(9,null);
			}
			if (p_request.getImageTemplateLHIF() != null) {			
				preStmt.setBytes(10,Base64Utility.decode(p_request.getImageTemplateLHIF()));
			} else {
				preStmt.setBytes(10,null);
			}
			if (p_request.getImageTemplateLHTF() != null) {			
				preStmt.setBytes(11,Base64Utility.decode(p_request.getImageTemplateLHTF()));
			} else {
				preStmt.setBytes(11,null);
			}		
			if (p_request.getImageScanRHLF() != null) {			
				preStmt.setBytes(12,Base64Utility.decode(p_request.getImageScanRHLF()));
			} else {
				preStmt.setBytes(12,null);
			}
			if (p_request.getImageScanRHRF() != null) {			
				preStmt.setBytes(13,Base64Utility.decode(p_request.getImageScanRHRF()));
			} else {
				preStmt.setBytes(13,null);
			}
			if (p_request.getImageScanRHMF() != null) {			
				preStmt.setBytes(14,Base64Utility.decode(p_request.getImageScanRHMF()));
			} else {
				preStmt.setBytes(14,null);
			}
			if (p_request.getImageScanRHIF() != null) {			
				preStmt.setBytes(15,Base64Utility.decode(p_request.getImageScanRHIF()));
			} else {
				preStmt.setBytes(15,null);
			}
			if (p_request.getImageScanRHTF() != null) {			
				preStmt.setBytes(16,Base64Utility.decode(p_request.getImageScanRHTF()));
			} else {
				preStmt.setBytes(16,null);
			}
			if (p_request.getImageScanLHLF() != null) {			
				preStmt.setBytes(17,Base64Utility.decode(p_request.getImageScanLHLF()));
			} else {
				preStmt.setBytes(17,null);
			}
			if (p_request.getImageScanLHRF() != null) {			
				preStmt.setBytes(18,Base64Utility.decode(p_request.getImageScanLHRF()));
			} else {
				preStmt.setBytes(18,null);
			}
			if (p_request.getImageScanLHMF() != null) {			
				preStmt.setBytes(19,Base64Utility.decode(p_request.getImageScanLHMF()));
			} else {
				preStmt.setBytes(19,null);
			}
			if (p_request.getImageScanLHIF() != null) {			
				preStmt.setBytes(20,Base64Utility.decode(p_request.getImageScanLHIF()));
			} else {
				preStmt.setBytes(20,null);
			}
			if (p_request.getImageScanLHTF() != null) {			
				preStmt.setBytes(21,Base64Utility.decode(p_request.getImageScanLHTF()));
			} else {
				preStmt.setBytes(21,null);
			}
			
			result = preStmt.executeUpdate();
			
		} catch (DataAccessException e) {
			result = 0;
			throw new ServiceException("DataAccessException while insert postCustDocInfo = " + e);
        } catch (Exception e) {
        	result = 0;
        	throw new ServiceException("Unhandled exception while insert postCustDocInfo = " + e);
        } finally {
			if (preStmt != null) {
				preStmt = null;
			}
			conMangr.closeConnection(conn);
		}
		return result;
	}	
// EGA-MN15-000015 Start
	public CbsBaseTransResponse validateCashTransaction(String p_custId, String p_accNo, String p_branch,String p_txnCode, double p_amt){
		CbsBaseTransResponse l_res=new CbsBaseTransResponse();
		DBConnection conMangr = DBConnection.getInstance();
		Connection l_con=null;
		CallableStatement l_st=null;
		try {
			
		
		 l_con = conMangr.getConnection();
		
		 l_st=l_con.prepareCall("{ ? = call  "+InterfaceQuery.FN_VALIDATE_CASH_TXN+"( ?,?,?,?,?, ?,?,? ) }");
		l_st.registerOutParameter(1, Types.NUMERIC);
		
		l_st.setString(2, p_custId);
		l_st.setString(3, p_accNo);
		l_st.setString(4, p_branch);
		l_st.setString(5, p_txnCode);
		l_st.setDouble(6, p_amt);
		
		
		l_st.registerOutParameter(7, Types.NUMERIC);
		l_st.registerOutParameter(8, Types.VARCHAR);
		l_st.registerOutParameter(9, Types.VARCHAR);
		
		l_st.executeUpdate();
		
		if(l_st.getInt(1)==0){
			l_res.setCbsResStat("P");
			l_res.setResponseCode("0");
		}
		else{
			l_res.setCbsResStat("E");
			l_res.setResponseCode(l_st.getString(8));
			l_res.setResponseMessage(l_st.getString(9));
		}
		} catch (Exception e) {
			e.printStackTrace();
			l_res.setCbsResStat("X");
			l_res.setResponseCode("1");
			l_res.setResponseMessage("Falied at host");
		}
		finally{
			if (l_st != null) {
				l_st = null;
			}
			conMangr.closeConnection(l_con);
		}
		
		LoggerUtil.cbsJobDebug("Mock fn res for cash txn: "+l_res);
		
		return l_res;
		
	}
	//EGA-MN15-000015 End
}