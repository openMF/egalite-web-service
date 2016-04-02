package com.bfsi.mfi.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CbsCustAccountsSyncDao;
import com.bfsi.mfi.entity.StgCustomerAccount;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository
public class CbsCustAccountsSyncJdbcDao extends CbsCustAccountsSyncDao {	

	@Override
	public void insertCustomerAccounts(List<StgCustomerAccount> p_cstAccList) {
		SqlParameterSource[] l_params = new SqlParameterSource[p_cstAccList
				.size()];
		for (int l_i = 0; l_i < p_cstAccList.size(); l_i++) {
			l_params[l_i] = new BeanPropertySqlParameterSource(
					p_cstAccList.get(l_i));
		}
		jdbcTemplate.batchUpdate(ApplicationQuery.CBS_QUERY_INSERT_CUST_ACC, l_params);

	}

	@Override
	public void deleteCustomerAccounts() {
		Map<String, String> l_params = new HashMap<String, String>();
		jdbcTemplate.update(ApplicationQuery.CBS_QUERY_DELETE_CUST_ACC, l_params);

	}

	@Override
	public void deleteCustAccountsOnError(String p_jobId) {
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("jobId", p_jobId);
		 jdbcTemplate.update(ApplicationQuery.CBS_QUERY_DELETE_CUST_ACC_FOR_JOB, l_params);
		
	}

}
