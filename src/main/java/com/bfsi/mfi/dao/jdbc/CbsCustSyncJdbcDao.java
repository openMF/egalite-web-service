package com.bfsi.mfi.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CbsCustSyncDao;
import com.bfsi.mfi.entity.StgCustomer;
import com.bfsi.mfi.query.ApplicationQuery;


/**
 * 
 * @author Vishal
 *
 */
@Repository("cbsCustSyncJdbcDao")
public class CbsCustSyncJdbcDao   extends CbsCustSyncDao {

	@Override
	public void deleteCustomer() {
		Map<String, String> l_params = new HashMap<String, String>();
			 jdbcTemplate.update(ApplicationQuery.STG_DELETE_CUSTOMER, l_params);
		
	}

	@Override
	public void insertCustomer(List<StgCustomer> p_Cust) {
		
		SqlParameterSource []l_params=new SqlParameterSource[p_Cust.size()];
		
			for(int l_i=0;l_i<p_Cust.size();l_i++){
				l_params[l_i] = new BeanPropertySqlParameterSource(p_Cust.get(l_i));
			}				
			 jdbcTemplate.batchUpdate(ApplicationQuery.STG_INSERT_CUSTOMER, l_params);			 
		
	}

	@Override
	public void deleteCustomerOnError(String p_jobId) {
		
		
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("jobId", p_jobId);
		 jdbcTemplate.update(ApplicationQuery.STG_DELETE_CUSTOMER_FOR_JOB, l_params);
		
	}

}
