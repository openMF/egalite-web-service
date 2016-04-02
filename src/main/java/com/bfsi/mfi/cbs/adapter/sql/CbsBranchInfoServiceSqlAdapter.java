package com.bfsi.mfi.cbs.adapter.sql;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletContext;

import com.bfsi.mfi.cbs.adapter.CbsBranchInfoServiceAdapter;
import com.bfsi.mfi.query.InterfaceQuery;

/**
 * 
 * @author Shabu S Francis
 *
 */
public  class  CbsBranchInfoServiceSqlAdapter extends  CbsBranchInfoServiceAdapter {
	private ServletContext servletContext =null;

	
	@Override
	public Date getBranchDate(){
		
		return	getJdbcTemplate().queryForObject(InterfaceQuery.QUERY_GET_BRANCH_DATE, new HashMap<String, String>(), Date.class);
		
	}

	@Override
	public ServletContext getServletContext() {
		
		return this.servletContext;
	}

	@Override
	public void setServletContext(ServletContext p_servletContext) {
		
		servletContext=p_servletContext;
	}

}
