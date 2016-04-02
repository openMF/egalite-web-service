package com.bfsi.mfi.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CbsLoanSyncDao;
import com.bfsi.mfi.entity.StgLoanDetails;
import com.bfsi.mfi.entity.StgLoanDisbursements;
import com.bfsi.mfi.entity.StgLoanPaidSchedules;
import com.bfsi.mfi.entity.StgLoanSchedules;
import com.bfsi.mfi.query.ApplicationQuery;

/**
 * 
 * @author Vishal
 * 
 */

@Repository("cbsLoanSyncJdbcDao")
public class CbsLoanSyncJdbcDao extends CbsLoanSyncDao {

	@Override
	public void deleteLoanDetails() {
		Map<String, String> l_params = new HashMap<String, String>();
		jdbcTemplate.update(ApplicationQuery.STG_QUERY_DELETE_LOAN_DETAILS,
				l_params);

	}

	@Override
	public void insertLoanDetails(List<StgLoanDetails> p_loanList) {
		SqlParameterSource[] l_params = new SqlParameterSource[p_loanList
				.size()];
		for (int l_i = 0; l_i < p_loanList.size(); l_i++) {
			l_params[l_i] = new BeanPropertySqlParameterSource(
					p_loanList.get(l_i));
		}
		jdbcTemplate.batchUpdate(
				ApplicationQuery.STG_INSERT_QUERY_LOAN_DETAILS, l_params);

	}

	@Override
	public void deleteLoanDisbr() {

		Map<String, String> l_params = new HashMap<String, String>();
		jdbcTemplate.update(ApplicationQuery.STG_QUERY_DELETE_LOAN_DISBR,
				l_params);

	}

	@Override
	public void insertLoanDisbr(List<StgLoanDisbursements> p_loanDibrList) {
		// TODO Auto-generated method stub

		SqlParameterSource[] l_params = new SqlParameterSource[p_loanDibrList
				.size()];
		for (int l_i = 0; l_i < p_loanDibrList.size(); l_i++) {
			l_params[l_i] = new BeanPropertySqlParameterSource(
					p_loanDibrList.get(l_i));
		}
		jdbcTemplate.batchUpdate(
				ApplicationQuery.STG_INSERT_QUERY_LOAN_DISBURSEMENT, l_params);

	}

	@Override
	public void deleteLoanPaidSch() {
		// TODO Auto-generated method stub
		Map<String, String> l_params = new HashMap<String, String>();

		jdbcTemplate.update(ApplicationQuery.STG_QUERY_DELETE_LOAN_PAID_SCH,
				l_params);

	}

	@Override
	public void insertLoanPaidSch(List<StgLoanPaidSchedules> p_loanPaidSchList) {

		SqlParameterSource[] l_params = new SqlParameterSource[p_loanPaidSchList
				.size()];
		for (int l_i = 0; l_i < p_loanPaidSchList.size(); l_i++) {
			l_params[l_i] = new BeanPropertySqlParameterSource(
					p_loanPaidSchList.get(l_i));
		}
		jdbcTemplate.batchUpdate(
				ApplicationQuery.STG_INSERT_QUERY_LOAN_PAID_SCH, l_params);

	}

	@Override
	public void deleteLoanSch() {
		Map<String, String> l_params = new HashMap<String, String>();
		jdbcTemplate.update(ApplicationQuery.STG_QUERY_DELETE_LOAN_SCH,
				l_params);

	}

	@Override
	public void insertLoanSch(List<StgLoanSchedules> p_loanSchList) {

		SqlParameterSource[] l_params = new SqlParameterSource[p_loanSchList
				.size()];
		for (int l_i = 0; l_i < p_loanSchList.size(); l_i++) {
			l_params[l_i] = new BeanPropertySqlParameterSource(
					p_loanSchList.get(l_i));
		}
		jdbcTemplate.batchUpdate(ApplicationQuery.STG_INSERT_QUERY_LOAN_SCH,
				l_params);
	}

	@Override
	public void deleteLoansOnError(String p_jobId) {
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("jobId", p_jobId);
		 jdbcTemplate.update(ApplicationQuery.STG_QUERY_DELETE_LOAN_DETAILS_FOR_JOB, l_params);
		
	}

	@Override
	public void deleteLoanDisbrOnError(String p_jobId) {
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("jobId", p_jobId);
		 jdbcTemplate.update(ApplicationQuery.STG_QUERY_DELETE_LOAN_DISBR_FOR_JOB, l_params);
		
	}

	@Override
	public void deleteLoanPaidSchOnError(String p_jobId) {
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("jobId", p_jobId);
		 jdbcTemplate.update(ApplicationQuery.STG_QUERY_DELETE_LOAN_PAID_SCH_FOR_JOB, l_params);
		
	}

	@Override
	public void deleteLoanSchOnError(String p_jobId) {
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("jobId", p_jobId);
		 jdbcTemplate.update(ApplicationQuery.STG_QUERY_DELETE_LOAN_SCH_FOR_JOB, l_params);
		
	}

}
