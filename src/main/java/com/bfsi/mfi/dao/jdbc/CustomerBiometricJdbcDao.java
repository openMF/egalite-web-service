package com.bfsi.mfi.dao.jdbc;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CustomerBiometricDao;
import com.bfsi.mfi.entity.CustomerBiometricInfo;
import com.bfsi.mfi.query.ApplicationQuery;

/**
 * 
 * @author Vishal
 *
 */
@Repository("customerBiometricDao")
public class CustomerBiometricJdbcDao extends BaseJdbcDao implements CustomerBiometricDao{

	@Override
	public void submitCustBiometricInfo(CustomerBiometricInfo p_custBioInfo) {
		// TODO Auto-generated method stub
		SqlParameterSource customerParams = new BeanPropertySqlParameterSource(
				p_custBioInfo);
		jdbcTemplate.update(ApplicationQuery.QUERY_INSERT_CUST_BIO_INFO, customerParams);		
	}

}
