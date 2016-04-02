package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CurrencyDao;
import com.bfsi.mfi.entity.Currency;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("currencyDao")
public class CurrencyJdbcDao extends MaintenanceJdbcDao<Currency> implements
		CurrencyDao {

	@Override
	protected String getInsertQuery() {
		return null;

	}

	@Override
	protected RowMapper<Currency> getRowMapper() {
		return new CurrencyMapper();
	}

	@Override
	protected String getSelectAllQuery() {

		return ApplicationQuery.CUR_QUERY_SELECT_ALL;
	}

	@Override
	protected String getUpdateQuery() {
		return null;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.CUR_QUERY_SELECT_PK;

	}

	@Override
	protected String getDeleteQuery() {

		return "DELETE FROM AMTB_CCY_EXRATE WHERE AGENT_ID=:id";
	}

	private static final class CurrencyMapper implements RowMapper<Currency> {

		public Currency mapRow(ResultSet rs, int rowNum) throws SQLException {
			Currency currency = new Currency();
			currency.setId(rs.getString("CCY_CODE"));
			currency.setCurrencyName(rs.getString("CCY_NAME"));
			currency.setIsoCcyCode(rs.getString("ISO_CCY_CODE"));
			currency.setIsoAltCcode(rs.getString("ISO_ALT_CCODE"));
			currency.setCountry(rs.getString("COUNTRY"));
			currency.setCcyRoundRule(rs.getString("CCY_ROUND_RULE"));
			currency.setCurrencyDecimals(rs.getDouble("CCY_DECIMAL"));
			if(rs.getString("RECORD_STAT")!=null && rs.getString("RECORD_STAT").equalsIgnoreCase("O")){
				currency.setRecordStatus("Open");
			} else {
				currency.setRecordStatus("Closed");
			}
		    currency.setCbsJobId(rs.getString("CBS_UPLD_JOB_ID")); 
		    currency.setSyncStatus(rs.getString("SYNC_STATUS"));
		    currency.setSyncTime(rs.getString("SYNC_TIME"));
		    currency.setCountryName(rs.getString("DESN"));
			return currency;
		}
	}

	private static final class CurrencyDetailMapper implements
			RowMapper<Currency> {

		public Currency mapRow(ResultSet rs, int rowNum) throws SQLException {
			Currency currency = new Currency();
			currency.setId(rs.getString("CCY_CODE"));
			currency.setCurrencyName(rs.getString("CCY_NAME"));
			currency.setIsoCcyCode(rs.getString("ISO_CCY_CODE"));
			currency.setIsoAltCcode(rs.getString("ISO_ALT_CCODE"));
			currency.setCountry(rs.getString("COUNTRY"));
			currency.setCurrencyDecimals(rs.getDouble("CCY_DECIMAL"));
			currency.setCcyRoundRule(rs.getString("CCY_ROUND_RULE"));
			return currency;
		}
	}

	@Override
	public List<Currency> getCurrencies() {
		List<Currency> currencyList = new ArrayList<Currency>();
		Map<String, String> params = new HashMap<String, String>();
		currencyList = jdbcTemplate.query(ApplicationQuery.CUR_QUERY_SELECT_CURRENCY, params,
				new CurrencyDetailMapper());
		return (currencyList != null) ? currencyList
				: new ArrayList<Currency>();
	}

	@Override
	public int getDecimal(String curencyCode){
		Map<String, String> params = new HashMap<String, String>();
		return jdbcTemplate.queryForInt(ApplicationQuery.CUR_QUERY_TOGET_DECIMAL, params);
		
		
	}
}
