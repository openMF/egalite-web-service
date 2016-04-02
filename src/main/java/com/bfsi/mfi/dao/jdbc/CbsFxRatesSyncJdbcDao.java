package com.bfsi.mfi.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CbsFxRatesSyncDao;
import com.bfsi.mfi.entity.StgFxRates;
import com.bfsi.mfi.query.ApplicationQuery;


/**
 * 
 * @author Vishal
 *
 */

@Repository("cbsFxRatesSyncJdbcDao")
public class CbsFxRatesSyncJdbcDao extends CbsFxRatesSyncDao {

	@Override
	public void insertFxRates(List<StgFxRates> p_fx) {
	
			SqlParameterSource []l_params=new SqlParameterSource[p_fx.size()];
			for(int l_i=0;l_i<p_fx.size();l_i++){
				l_params[l_i] = new BeanPropertySqlParameterSource(p_fx.get(l_i));
			}
			 jdbcTemplate.batchUpdate(ApplicationQuery.STG_INSERT_FX_RATES, l_params);
	}

	@Override
	public void deleteFxRates() {
		Map<String, String> l_params = new HashMap<String, String>();
			 jdbcTemplate.update(ApplicationQuery.STG_DELETE_FX_RATES, l_params);
			
	}

	@Override
	public void deleteFxRatesOnError(String p_jobId) {
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("jobId", p_jobId);
		 jdbcTemplate.update(ApplicationQuery.STG_DELETE_FX_RATES_FOR_JOB, l_params);
		
	}

}
