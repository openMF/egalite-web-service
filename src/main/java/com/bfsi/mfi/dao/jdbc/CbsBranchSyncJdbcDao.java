package com.bfsi.mfi.dao.jdbc;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.CbsBranchSyncDao;
import com.bfsi.mfi.entity.StgBranch;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;


/**
 * 
 * @author Vishal
 *
 */
@Repository("cbsBranchSyncJdbcDao")
public class CbsBranchSyncJdbcDao  extends CbsBranchSyncDao {
	
	@Override
	public void deleteBranch() {
		
		Map<String, String> l_params = new HashMap<String, String>();
			 jdbcTemplate.update(ApplicationQuery.STG_DELETE_BRANCH, l_params);
	}

	@Override
	public void insertBranch(List<StgBranch> p_branch) {
		
		SqlParameterSource []l_params=new SqlParameterSource[p_branch.size()];
		for(int l_i=0;l_i<p_branch.size();l_i++){
			l_params[l_i] = new BeanPropertySqlParameterSource(p_branch.get(l_i));
		} 
		jdbcTemplate.batchUpdate(ApplicationQuery.STG_INSERT_BRANCH, l_params);		
	}

	@Override
	public void deleteBranchOnError(String p_jobId) {
		
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("jobId", p_jobId);
		jdbcTemplate.update(ApplicationQuery.STG_DELETE_BRANCH_FOR_JOB, l_params);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteBranch(List<StgBranch> p_branch) {
		
		MapSqlParameterSource []l_params=new MapSqlParameterSource[p_branch.size()];
		for(int l_i=0;l_i<p_branch.size();l_i++){
			l_params[l_i] = new MapSqlParameterSource();
			l_params[l_i].addValue("branchCode", p_branch.get(l_i).getBranchCode());
		}
		jdbcTemplate.batchUpdate(ApplicationQuery.STG_DELETE_BRANCH_FOR_ID, l_params);	
	}
}