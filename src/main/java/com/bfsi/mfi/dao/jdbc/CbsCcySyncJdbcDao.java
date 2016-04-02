package com.bfsi.mfi.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.CbsCcySyncDao;
import com.bfsi.mfi.entity.StgCurrency;
import com.bfsi.mfi.query.ApplicationQuery;



/**
 * 
 * @author Vishal
 *
 */

@Repository("cbsCcySyncJdbcDao")
public class CbsCcySyncJdbcDao  extends CbsCcySyncDao  {

	@Override
	public void deleteCcy() {
		Map<String, String> l_params = new HashMap<String, String>();
			 jdbcTemplate.update(ApplicationQuery.STG_DELETE_CCY, l_params);
	}

	@Override
	public void insertCcy(List<StgCurrency> p_ccy) {
			SqlParameterSource []l_params=new SqlParameterSource[p_ccy.size()];
			for(int l_i=0;l_i<p_ccy.size();l_i++){
				l_params[l_i] = new BeanPropertySqlParameterSource(p_ccy.get(l_i));
			}
			 jdbcTemplate.batchUpdate(ApplicationQuery.STG_INSERT_CCY, l_params);		
	}

	@Override
	public void deleteCcyOnError(String p_jobId) {
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("jobId", p_jobId);
		 jdbcTemplate.update(ApplicationQuery.STG_DELETE_CCY_FOR_JOB, l_params);
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteCcy(List<StgCurrency> p_ccy) {
	
		MapSqlParameterSource []l_params=new MapSqlParameterSource[p_ccy.size()];
		for(int l_i=0;l_i<p_ccy.size();l_i++){
			l_params[l_i] = new MapSqlParameterSource();
			l_params[l_i].addValue("ccyCode", p_ccy.get(l_i).getCcyCode());
		}
		 jdbcTemplate.batchUpdate(ApplicationQuery.STG_DELETE_CCY_FOR_CODE, l_params);	
		
	}

}
