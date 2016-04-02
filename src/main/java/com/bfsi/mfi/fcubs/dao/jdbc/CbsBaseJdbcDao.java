package com.bfsi.mfi.fcubs.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * 
 * @author Vishal
 *
 */
public abstract class CbsBaseJdbcDao {
	protected NamedParameterJdbcTemplate cbsJdbcTemplate;
	protected NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource cbsDataSource,DataSource dataSource){
		cbsJdbcTemplate=new NamedParameterJdbcTemplate(cbsDataSource);
		jdbcTemplate =new NamedParameterJdbcTemplate(dataSource);
	}
}
