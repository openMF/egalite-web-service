package com.bfsi.mfi.cbs.adapter.sql;


import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
/**
 * 
 * @author Shabu S Francis
 *
 */
public abstract class CbsDbProperties {
	
	protected NamedParameterJdbcTemplate getJdbcTemplate() {
	/*	WebApplicationContext springContext = WebApplicationContextUtils
				.getWebApplicationContext((ServletContext) FacesContext
						.getCurrentInstance().getExternalContext().getContext());*/
		
		WebApplicationContext springContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		return new NamedParameterJdbcTemplate(
				(DataSource) springContext.getBean("cbsDataSource"));
	}
	
	public abstract ServletContext getServletContext();

}
