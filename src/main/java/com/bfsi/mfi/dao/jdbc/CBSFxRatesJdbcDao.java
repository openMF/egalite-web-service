package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CBSFxRatesDao;
import com.bfsi.mfi.entity.CBSFxRates;
import com.bfsi.mfi.query.ApplicationQuery;


@Repository("cbsFxRatesDao")
public class CBSFxRatesJdbcDao extends MaintenanceJdbcDao<CBSFxRates> implements
CBSFxRatesDao {

	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectAllQuery() {
		return   ApplicationQuery.FXRATE_QUERY_ALL; //null;
	}

	@Override
	protected RowMapper<CBSFxRates> getRowMapper() {
		return new FXRatesMapper();
	}

	@Override
	protected String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}
  
	private static final class FXRatesMapper implements RowMapper<CBSFxRates> {
		public CBSFxRates mapRow(ResultSet rs, int rowNum) throws SQLException {
			CBSFxRates fxRates = new CBSFxRates();
			
			fxRates.setBrnCode(rs.getString("BRN_CODE"));
			fxRates.setCcy1(rs.getString("CCY1"));
			fxRates.setCcy2(rs.getString("CCY2"));
			fxRates.setRecordStat(rs.getString("RECORD_STAT"));
			fxRates.setMidRate(rs.getDouble("MID_RATE"));
			fxRates.setBuyRate(rs.getDouble("BUY_RATE"));
			fxRates.setSaleRate(rs.getDouble("SALE_RATE"));
			fxRates.setCbsUpldJobId(rs.getString("CBS_UPLD_JOB_ID"));
			fxRates.setSyncStatus(rs.getString("SYNC_STATUS"));
			fxRates.setSyncTime(rs.getString("SYNC_TIME"));
			
			return fxRates;
		}
	}
	
	private static final class FXRatesCcy1Mapper implements RowMapper<CBSFxRates> {
		public CBSFxRates mapRow(ResultSet rs, int rowNum) throws SQLException {
			CBSFxRates fxRates = new CBSFxRates();
			fxRates.setCcy1(rs.getString("CCY1"));
			return fxRates;
		}
	}
	
	private static final class FXRatesCcy2Mapper implements RowMapper<CBSFxRates> {
		public CBSFxRates mapRow(ResultSet rs, int rowNum) throws SQLException {
			CBSFxRates fxRates = new CBSFxRates();
			fxRates.setCcy2(rs.getString("CCY2"));
			return fxRates;
		}
	}
	
	
	/*@Override
	public double getMidRate(String ccy1,String ccy2){
		Map<String, String> params = new HashMap<String, String>();
		params.put("ccy1", ccy1);
		params.put("ccy2", ccy2);
		return jdbcTemplate.queryForObject(ApplicationQuery.FXRATE_QUERY_MIDRATE, params , new MidRateRowMapper());
	}*/
	
	
	/*private static final class MidRateRowMapper implements RowMapper<Double> {
     @Override
     public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
	    return rs.getDouble("mid_rate");
       }
     }*/
	
	@Override
	public CBSFxRates getRates(String ccy1,String ccy2){
		Map<String, String> params = new HashMap<String, String>();
		params.put("ccy1", ccy1);
		params.put("ccy2", ccy2);//cc1 take as USD
		return jdbcTemplate.queryForObject(ApplicationQuery.FXRATE_QUERY_RATES, 
				                             params ,  new FXRatesMapper());
	}

	@Override
	public List<CBSFxRates> getCcy1Rates(){
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);//cc1 take as USD
		return jdbcTemplate.query(ApplicationQuery.FXRATE_QUERY_CCY1RATES, 
				                             params ,  new FXRatesCcy1Mapper());
	}
	
	@Override
	public	List<CBSFxRates> getCcy2Rates()
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);//cc1 take as USD
		return jdbcTemplate.query(ApplicationQuery.FXRATE_QUERY_CCY2RATES, 
				                             params ,  new FXRatesCcy2Mapper());
	}
	
	

	
}
