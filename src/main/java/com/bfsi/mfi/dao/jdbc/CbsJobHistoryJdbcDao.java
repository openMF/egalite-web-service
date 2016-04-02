package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CbsJobHistoryDao;
import com.bfsi.mfi.entity.CbsJobDetail;
import com.bfsi.mfi.entity.CbsJobHistory;
import com.bfsi.mfi.entity.CbsUploadStatus;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("cbsJobHistoryDao")
public class CbsJobHistoryJdbcDao extends
ReadOnlyMaintenanceJdbcDao<CbsJobHistory> implements CbsJobHistoryDao {

	private static final String CUSTOMER = "Customer";
	private static final String LOAN = "Loan";
	private static final String DEPOSIT = "Deposit";
	@Override
	protected RowMapper<CbsJobHistory> getRowMapper() {
		return new CbsJobHistoryMapper();
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.CBS_QUERY_SELECT_ALL;
	}

	private static final class CbsJobHistoryMapper implements
	RowMapper<CbsJobHistory> {
		public CbsJobHistory mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			CbsJobHistory cbsJobHistory = new CbsJobHistory();
			cbsJobHistory.setJobId(rs.getString("JOB_ID"));
			/*
			 * cbsJobHistory.setRecordType(rs.getString("RECORD_TYPE"));
			 * cbsJobHistory.setTimeStamp(BaseJdbcDao.getUtilDate(rs
			 * .getDate("TIMESTAMP")));
			 * cbsJobHistory.setRecordId(rs.getString("RECORD_ID"));
			 * cbsJobHistory.setOperation(rs.getString("OPERATION"));
			 */
			cbsJobHistory.setStartTime(rs.getTimestamp("START_TIME"));
			cbsJobHistory.setStartedBy(rs.getString("STARTED_BY"));
			cbsJobHistory.setEndTime(rs.getTimestamp("END_TIME"));
			cbsJobHistory.setNoOfCustomerFetched(rs.getInt("CUSTOMER"));
			cbsJobHistory.setNoOfLoanFetched(rs.getInt("LOAN"));
			cbsJobHistory.setNoOfDepositFetched(rs.getInt("DEPOSIT"));
			return cbsJobHistory;
		}
	}

	/*
	 * @Override public List<CbsJobHistory> getCbsJobHistoryForStartTime(String
	 * startTime) { // TODO Auto-generated method stub return null; }
	 */
	public String selectPk(String recordId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", recordId);
		jdbcTemplate.queryForObject(ApplicationQuery.CBS_QUERY_SELECT_BY_LOAN, params,
				new CbsJobHistoryMapper());
		jdbcTemplate.queryForObject(ApplicationQuery.CBS_QUERY_SELECT_BY_CUSTOMER, params,
				new CbsJobHistoryMapper());
		jdbcTemplate.queryForObject(ApplicationQuery.CBS_QUERY_SELECT_BY_DEPOSIT, params,
				new CbsJobHistoryMapper());
		return "success";
	}

	@Override
	public String getJobId() {
		/*Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.queryForObject(ApplicationQuery.CBS_QUERY_JOB_ID, params,
				new JobIDRowMapper());*/
		String autoGenid = getAutoGenFunCreateId(1); //Pass Your module code.
		return autoGenid;
	}

	private static final class JobIDRowMapper implements RowMapper<String> {
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			String autoID = rs.getString("JOB_ID");
			String setID = null;
			String value = "00001";
			String tag = "JOB";
			String codes = tag + todayDate();

			if (autoID == null || autoID.equals("")) {
				setID = codes + value;

			} else 
			{
				String tdate = autoID.substring(3, 11);
				String code = autoID.substring(0, 11);
				String actualId = autoID.substring(11, 16);
				int actualIdValue = Integer.parseInt(actualId);
				int one = 1;
				int incrementId = actualIdValue + one;
				String incrementIdValue = Integer.toString(incrementId);

				if (tdate.equals(todayDate())) 
				{
					if (incrementIdValue.length() == 1) {
						setID = code + "0000" + incrementIdValue;
					} else if (incrementIdValue.length() == 2) {
						setID = code + "000" + incrementIdValue;
					} else if (incrementIdValue.length() == 3) {
						setID = code + "00" + incrementIdValue;
					} else if (incrementIdValue.length() == 4) {
						setID = code + "0" + incrementIdValue;
					} else {
						setID = codes + "0000" + one;
					}
				} 
				else {
					setID = codes + "0000" + one;
				}
			}
			return setID;
		}
	}

	public static String todayDate() 
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		return dateFormat.format(date);
	}

	@Override
	public void insertJobId(String jobId, String userId, Date jobStartTime) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("jobId", jobId);
		params.put("userId", userId);
		params.put("jobStartTime", jobStartTime);
		jdbcTemplate.update(ApplicationQuery.CBS_QUERY_INSERT_JOBID, params);

	}

	@Override
	public void updateWithEndTime(String jobId, Date jobEndTime) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("jobId", jobId);
		params.put("jobEndTime", jobEndTime);
		jdbcTemplate.update(ApplicationQuery.CBS_QUERY_UPDATE_JOBID, params);

	}

	@Override
	public String getExistingJobId(String userId) {
		String todate = todayDate();
		todate = "%" + todate + "%";
		Map<String, String> params = new HashMap<String, String>();
		params.put("date", todate);
		params.put("userId", userId);
		try {
			return jdbcTemplate.queryForObject(ApplicationQuery.CBS_QUERY_SELECT_JOBID, params,
					String.class);
		} catch (DataAccessException e) {
			LoggerUtil.ibsJobError("DataAccessException : MFI10001", e);
			return null;
		}
	}

	@Override
	public void updateWithStartTime(String jobId, Date jobStartTime) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("jobId", jobId);
		params.put("jobStartTime", jobStartTime);
		jdbcTemplate.update(ApplicationQuery.CBS_QUERY_UPDATE_JOBTIME, params);

	}

	@Override
	public List<CbsJobDetail> getCbsDetailForLoan(String jobId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("jobId", jobId);
		return jdbcTemplate.query(ApplicationQuery.CBS_QUERY_CBS_LOAN, params,
				new CbsJobLoanMapper());

	}

	@Override
	public List<CbsJobDetail> getCbsDetailForCustomer(String jobId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("jobId", jobId);
		return jdbcTemplate.query(ApplicationQuery.CBS_QUERY_CBS_CUSTOMER, params,
				new CbsJobMapper());
	}

	@Override
	public List<CbsJobDetail> getCbsDetailForDeposit(String jobId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("jobId", jobId);
		return jdbcTemplate.query(ApplicationQuery.CBS_QUERY_CBS_DEPOSIT, params,
				new CbsJobDepositMapper());
	}

	private static final class CbsJobMapper implements RowMapper<CbsJobDetail> {

		public CbsJobDetail mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			CbsJobDetail cbsJobDetail = new CbsJobDetail();
			cbsJobDetail.setJobId(rs.getString("JOB_ID"));
			cbsJobDetail.setRecordId(rs.getString("CUSTOMER_ID"));
			cbsJobDetail.setRecordType(CUSTOMER);

			return cbsJobDetail;
		}
	}

	private static final class CbsJobLoanMapper implements
	RowMapper<CbsJobDetail> {

		public CbsJobDetail mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			CbsJobDetail cbsJobDetail = new CbsJobDetail();
			cbsJobDetail.setJobId(rs.getString("JOB_ID"));
			cbsJobDetail.setRecordId(rs.getString("LOAN_AC_NO"));
			cbsJobDetail.setRecordType(LOAN);

			return cbsJobDetail;
		}
	}

	private static final class CbsJobDepositMapper implements
	RowMapper<CbsJobDetail> {

		public CbsJobDetail mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			CbsJobDetail cbsJobDetail = new CbsJobDetail();
			cbsJobDetail.setJobId(rs.getString("JOB_ID"));
			cbsJobDetail.setRecordId(rs.getString("DEP_AC_NO"));
			cbsJobDetail.setRecordType(DEPOSIT);

			return cbsJobDetail;
		}
	}

	@Override
	public List<CbsUploadStatus> loadCbsUploadStatusHistory() { // FOR GROUP I
		Map<String, String> params = new HashMap<String, String>();		
		return jdbcTemplate.query(ApplicationQuery.CBS_UPLOAD_STATUS_HISTORY, params,
				new CbsUploadStausMapper());
	}
	
	
	@Override
	public List<CbsUploadStatus> loadCbsUploadStatusHistory2() {
		Map<String, String> params = new HashMap<String, String>();		
		return jdbcTemplate.query(ApplicationQuery.CBS_UPLOAD_STATUS_HISTORY2, params,
				new CbsUploadStausMapper());
	}
	
	@Override
	public List<CbsUploadStatus> loadCbsUploadStatusHistory3() {
		Map<String, String> params = new HashMap<String, String>();		
		return jdbcTemplate.query(ApplicationQuery.CBS_UPLOAD_STATUS_HISTORY3, params,
				new CbsUploadStausMapper());
	}
	
	@Override
	public List<CbsUploadStatus> loadCbsUploadStatusHistory5() {
		Map<String, String> params = new HashMap<String, String>();		
		return jdbcTemplate.query(ApplicationQuery.CBS_UPLOAD_STATUS_HISTORY5, params,
				new CbsUploadStausMapper());
	}
	
	
	@Override
	public List<CbsUploadStatus> loadCbsUploadStatusHistory6() {
		Map<String, String> params = new HashMap<String, String>();		
		return jdbcTemplate.query(ApplicationQuery.CBS_UPLOAD_STATUS_HISTORY6, params,
				new CbsUploadStausMapper());
	}
	
	
	@Override
	public List<CbsUploadStatus> loadCbsUploadStatusHistory7() {
		Map<String, String> params = new HashMap<String, String>();		
		return jdbcTemplate.query(ApplicationQuery.CBS_UPLOAD_STATUS_HISTORY7, params,
				new CbsUploadStausMapper());
	}
	
	
	
	/*@Override
	public List<CbsUploadStatus> loadDynaCbsUploadStatusHistory(String tabValue) {
		Map<String, String> params = new HashMap<String, String>();	
		String sql=null;
		
		 if(tabValue.equalsIgnoreCase("tab1"))
			 sql=ApplicationQuery.CBS_UPLOAD_STATUS_HISTORY1;
		  if(tabValue.equalsIgnoreCase("tab2"))
			 sql=ApplicationQuery.CBS_UPLOAD_STATUS_HISTORY2;
		 else if(tabValue.equalsIgnoreCase("tab3"))
			 sql=ApplicationQuery.CBS_UPLOAD_STATUS_HISTORY3;
		 else if(tabValue.equalsIgnoreCase("tab5"))
			 sql=ApplicationQuery.CBS_UPLOAD_STATUS_HISTORY5;
		 else if(tabValue.equalsIgnoreCase("tab6"))
			 sql=ApplicationQuery.CBS_UPLOAD_STATUS_HISTORY6;
		 else if(tabValue.equalsIgnoreCase("tab7"))
			 sql=ApplicationQuery.CBS_UPLOAD_STATUS_HISTORY7;
		 else
			 sql=ApplicationQuery.CBS_UPLOAD_STATUS_HISTORY;
		
		 else if(tabValue.equalsIgnoreCase("tab4"))
			 sql=ApplicationQuery.CBS_UPLOAD_STATUS_HISTORY4;
		//ApplicationQuery.CBS_UPLOAD_STATUS_HISTORY
		return jdbcTemplate.query(sql, params,new CbsUploadStausMapper());
	}*/
	
	
	
	private static final class CbsUploadStausMapper implements RowMapper<CbsUploadStatus> {

		public CbsUploadStatus mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			CbsUploadStatus cbsUploadStatus = new CbsUploadStatus();
			cbsUploadStatus.setErrorType(rs.getString("TYPE"));
			cbsUploadStatus.setErrorClass(rs.getString("CLASS"));
			cbsUploadStatus.setErrorKey(rs.getString("KEY"));
			cbsUploadStatus.setErrorCode(rs.getString("ERR_CODE"));
			cbsUploadStatus.setErrorDesc(rs.getString("ERR_DESC"));

			return cbsUploadStatus;
		}
	}
}
