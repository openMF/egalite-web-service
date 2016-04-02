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

import com.bfsi.mfi.cbs.adapter.CbsCcySyncServiceAdapter;
import com.bfsi.mfi.cbs.model.CbsCurrency;
import com.bfsi.mfi.cbs.request.CcySyncRequest;
import com.bfsi.mfi.cbs.response.CcySyncResponse;
import com.bfsi.mfi.query.InterfaceQuery;


/**
 * 
 * @author Vishal
 *
 */
public class CbsCcySyncServiceSqlAdapter extends  
CbsCcySyncServiceAdapter {
	private ServletContext servletContext =null;
	
	@Override
	public CcySyncResponse extractCurrency(CcySyncRequest p_request) {
		CcySyncResponse l_res=new CcySyncResponse();
		l_res.setCcyList(getCcyFromCbs(new Date()));
		return l_res;
	}
	
	private List<CbsCurrency> getCcyFromCbs(Date p_syncTime){
		Map<String, String> l_params = new HashMap<String, String>();
		List<CbsCurrency> l_ccy = null;
		l_ccy = getJdbcTemplate().query(InterfaceQuery.CBS_QUERY_CCY, l_params, new CcyMapper());
		return l_ccy==null?new ArrayList<CbsCurrency>():l_ccy;
	}
	
	private static final class CcyMapper implements RowMapper<CbsCurrency> {

		@Override
		public CbsCurrency mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsCurrency l_ccy = new CbsCurrency();
			
			l_ccy.setCcyCode(rs.getString("CCY_CODE"));
			l_ccy.setCcyName(rs.getString("CCY_NAME"));
			l_ccy.setIsoCcyCode(rs.getString("ISO_CCY_CODE"));
			l_ccy.setIsoAltCcode(rs.getString("ISO_ALT_CCODE"));
			l_ccy.setCountry(rs.getString("COUNTRY"));
			l_ccy.setCcyRoundRule(rs.getString("CCY_ROUND_RULE"));
			l_ccy.setCcyDecimal(rs.getDouble("CCY_DECIMAL"));
			l_ccy.setRecordStat(rs.getString("RECORD_STAT"));
			
			return l_ccy;
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
