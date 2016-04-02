package com.bfsi.mfi.cbs.adapter.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.jdbc.core.RowMapper;

import com.bfsi.mfi.cbs.adapter.CbsCustomerSyncServiceAdapter;
import com.bfsi.mfi.cbs.model.CbsCustomer;
import com.bfsi.mfi.cbs.request.CustomerSyncRequest;
import com.bfsi.mfi.cbs.response.CustomerSyncResponse;
import com.bfsi.mfi.query.InterfaceQuery;

/**
 * 
 * @author Vishal
 *
 */

public class CbsCustomerSyncServiceSqlAdapter extends  
CbsCustomerSyncServiceAdapter {
	
	private ServletContext servletContext =null;
	
	
	@Override
	public CustomerSyncResponse extractCustomer(CustomerSyncRequest p_request) {
		CustomerSyncResponse l_res=new CustomerSyncResponse();
		l_res.setCustList((getCustomerFromCbs(new Date())));
		return l_res;
	}
	
	private List<CbsCustomer> getCustomerFromCbs(Date p_syncTime) {
		Map<String, String> l_params = new HashMap<String, String>();
		List<CbsCustomer> l_cust = null;		
		l_cust = getJdbcTemplate().query(InterfaceQuery.CBS_QUERY_CUSTOMER, l_params, new CustomerMapper());		
		return l_cust==null?new ArrayList<CbsCustomer>():l_cust;
	}
	
	private static final class CustomerMapper implements RowMapper<CbsCustomer> {

		@Override
		public CbsCustomer mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsCustomer l_cust = new CbsCustomer();
			
			l_cust.setCustId(rs.getString("CUSTOMER_ID"));
						
			l_cust.setParentCustId(rs.getString("PARENT_CUST_ID"));//
			l_cust.setIsParentCust(rs.getString("IS_PARENT_CUST"));//
			l_cust.setCbsLcrCode(rs.getString("CBS_LCR_CODE"));//
			l_cust.setCbsLcrType(rs.getString("CBS_LCR_TYPE"));//
			l_cust.setSmsFromIbs(rs.getString("SMS_FROM_IBS"));//
			l_cust.setSmsFromMbs(rs.getString("SMS_FROM_MBS"));//
			l_cust.setCollectKyc(rs.getString("COLLECT_KYC"));//
			l_cust.setCbsAgentCode(rs.getString("CBS_AGENT_CODE"));//  
			l_cust.setCbsGroupCode(rs.getString("CBS_GROUP_CODE"));
			
			l_cust.setCustFullName(rs.getString("CUSTOMER_FULL_NAME"));
			l_cust.setCustShortName(rs.getString("CUSTOMER_SHORT_NAME"));			
			l_cust.setCustCatgr(rs.getString("CUSTOMER_CATEGORY"));
			l_cust.setGender(rs.getString("GENDER"));
			l_cust.setDob(rs.getDate("DOB"));
			l_cust.setCustSince(rs.getDate("CUSTOMER_SINCE"));
			//l_cust.setCustCode(rs.getString("LOCATION_CODE"));			
			l_cust.setAdd1(rs.getString("ADDRESS_LINE1"));
			l_cust.setAdd2(rs.getString("ADDRESS_LINE2"));
			l_cust.setAdd3(rs.getString("ADDRESS_LINE3"));
			l_cust.setAdd4(rs.getString("ADDRESS_LINE4"));
			l_cust.setZipCode(rs.getString("ZIP_CODE"));
			l_cust.setCity(rs.getString("CITY"));
			l_cust.setState(rs.getString("STATE"));			
			l_cust.setCountry(rs.getString("COUNTRY"));
			l_cust.setNationality(rs.getString("NATIONALITY"));
			//l_cust.setAlocAgentId(rs.getString("ALLOCATED_AGENT_ID"));
			l_cust.setLocBranchCode(rs.getString("LOCAL_BRANCH_CODE"));
			l_cust.setPrefLang(rs.getString("PREFERRED_LANGUAGE"));
			l_cust.setEmailAdd(rs.getString("EMAIL_ADDRESS"));
			//l_cust.setSmsReq(rs.getString("SMS_REQUIRED"));
			l_cust.setMobNum(rs.getString("MOBILE_NUMBER"));
			l_cust.setCredOfficer(rs.getString("CREDIT_OFFICER"));
			l_cust.setRecordStat(rs.getString("RECORD_STAT"));
			return l_cust;
		}

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
