package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CbsDataSyncDao;
import com.bfsi.mfi.entity.CbsJobHistory;
import com.bfsi.mfi.query.ApplicationQuery;

/**
 * 
 * @author Vishal
 *
 */

@Repository("cbsDataSyncDao")
public class CbsDataSyncJdbcDao extends
ReadOnlyMaintenanceJdbcDao<CbsJobHistory> implements CbsDataSyncDao {

	@Override
	public String getJobId() {
		/*Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.queryForObject(ApplicationQuery.CBS_QUERY_JOB_ID, params,
				new JobIDRowMapper());*/
		String autoId = getAutoGenFunCreateId(1); //Receive Agent ID from Function.
		return autoId;
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
		// TODO Auto-generated method stub		
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("jobId", jobId);
			params.put("userId", userId);
			params.put("jobStartTime", jobStartTime);
			jdbcTemplate.update(ApplicationQuery.CBS_QUERY_INSERT_JOBID, params);

	}

	@Override
	public void updateWithEndTime(String jobId, Date jobEndTime) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("jobId", jobId);
		params.put("jobEndTime", jobEndTime);
		jdbcTemplate.update(ApplicationQuery.CBS_QUERY_UPDATE_JOBID, params);
		
	}


	@Override
	protected String getSelectAllQuery() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected RowMapper<CbsJobHistory> getRowMapper() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insertSyncJobDetails(String p_modCode, String p_txnCode,
			Date p_syncTime,java.sql.Date p_busDate, String p_jobId, int p_countFetch) {
		
		Map<String, Object> l_params=new HashMap<String, Object>();
		l_params.put("modCode", p_modCode);
		l_params.put("txnCode", p_txnCode);
		l_params.put("syncTime", p_syncTime);
		l_params.put("businessDate", p_busDate);
		l_params.put("jobId", p_jobId);
		l_params.put("countFetch", p_countFetch);
		jdbcTemplate.update(ApplicationQuery.CBS_QUERY_INSERT_SYNC_DETAILS, l_params);
		
	}


	@Override
	public Date getSysDate() {
		
		return	jdbcTemplate.queryForObject(ApplicationQuery.QUERY_SYSDATE, new HashMap<String, String>(),Date.class);
	}


	@Override
	public void resetSyncDetails() {		
		jdbcTemplate.update(ApplicationQuery.QUERY_DELETE_SYNC_DETAILS, new HashMap<String, String>());
	}
}
