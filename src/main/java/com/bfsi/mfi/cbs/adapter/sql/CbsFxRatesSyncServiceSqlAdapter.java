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

import com.bfsi.mfi.cbs.adapter.CbsFxRatesSyncServiceAdapter;
import com.bfsi.mfi.cbs.model.CbsFxRates;
import com.bfsi.mfi.cbs.request.FxRatesSyncRequest;
import com.bfsi.mfi.cbs.response.FxRatesSyncResponse;
import com.bfsi.mfi.query.InterfaceQuery;

/**
 * 
 * @author Vishal
 *
 */

public class CbsFxRatesSyncServiceSqlAdapter extends CbsFxRatesSyncServiceAdapter {
	private ServletContext servletContext =null;
	
	@Override
	public FxRatesSyncResponse extractFxRates(FxRatesSyncRequest p_request) {
		// TODO Auto-generated method stub
		FxRatesSyncResponse l_res=new FxRatesSyncResponse();
		l_res.setFxRatesList(getFxRatesFromCbs(new Date()));
		return l_res;		
	}
	
	private List<CbsFxRates> getFxRatesFromCbs(Date p_syncTime) {
		Map<String, String> l_params = new HashMap<String, String>();
		List<CbsFxRates> l_fxRate = null;
		l_fxRate = getJdbcTemplate().query(InterfaceQuery.CBS_QUERY_FX_RATES, l_params, new FxRatesMapper());
		return l_fxRate==null?new ArrayList<CbsFxRates>():l_fxRate;
	}
	
	private static final class FxRatesMapper implements RowMapper<CbsFxRates> {

		@Override
		public CbsFxRates mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsFxRates l_fxRate = new CbsFxRates();			
			
			l_fxRate.setBrnCode(rs.getString("BRN_CODE"));
			l_fxRate.setCcy1(rs.getString("CCY1"));
			l_fxRate.setCcy2(rs.getString("CCY2"));
			l_fxRate.setRecordStat(rs.getString("RECORD_STAT"));
			l_fxRate.setMidRate(rs.getDouble("MID_RATE"));
			l_fxRate.setBuyRate(rs.getDouble("BUY_RATE"));
			l_fxRate.setSaleRate(rs.getDouble("SALE_RATE"));
			
			return l_fxRate;
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
