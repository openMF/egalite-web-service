package com.bfsi.mfi.dao.jdbc;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CbsDepositSyncDao;
import com.bfsi.mfi.entity.StgDeposit;
import com.bfsi.mfi.entity.StgDepositActivity;
import com.bfsi.mfi.query.ApplicationQuery;

/**
 * 
 * @author Shabu S Francis
 *
 */
@Repository("cbsDataSyncJdbcDao")
public class CbsDepositSyncJdbcDao extends CbsDepositSyncDao {
	
	
	
	@Override
	public void insertDeposits(List<StgDeposit> p_deposits) {
		SqlParameterSource []l_params=new SqlParameterSource[p_deposits.size()];
		for(int l_i=0;l_i<p_deposits.size();l_i++){
			l_params[l_i] = new BeanPropertySqlParameterSource(p_deposits.get(l_i));
		}
		 jdbcTemplate.batchUpdate(ApplicationQuery.QUERY_INSERT_DEPOST, l_params);

	}

	@Override
	public void insertDepositActivities(
			List<StgDepositActivity> p_depoActivities) {
		SqlParameterSource []l_params=new SqlParameterSource[p_depoActivities.size()];
		for(int l_i=0;l_i<p_depoActivities.size();l_i++){
			l_params[l_i] = new BeanPropertySqlParameterSource(p_depoActivities.get(l_i));
		}
		 jdbcTemplate.batchUpdate(ApplicationQuery.QUERY_INSERT_DEPOST_ACTIVITY, l_params);
	}

	
	@Override
	public void deleteDeposits() {
		Map<String, String> l_params = new HashMap<String, String>();
		jdbcTemplate.update(ApplicationQuery.QUERY_DELETE_DEPOSIT, l_params);
		
		
	}

	@Override
	public void deleteDepositActivities() {
		
		Map<String, String> l_params = new HashMap<String, String>();
		jdbcTemplate.update(ApplicationQuery.QUERY_DELETE_DEPOSIT_ACTIVITY, l_params);
		
	}

	@Override
	public void deleteDepositsOnError(String p_jobId) {
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("jobId", p_jobId);
		 jdbcTemplate.update(ApplicationQuery.QUERY_DELETE_DEPOSIT_FOR_JOB, l_params);
		
	}

	@Override
	public void deleteDepositActivitiesOnError(String p_jobId) {
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("jobId", p_jobId);
		 jdbcTemplate.update(ApplicationQuery.QUERY_DELETE_DEPOSIT_ACTIVITY_FOR_JOB, l_params);
		
	}

}
