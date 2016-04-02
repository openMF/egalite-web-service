package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.bfsi.mfi.cbs.adapter.CbsActionType;
/**
 * 
 * @author Shabu S Francis
 *
 */
public abstract class CbsSyncStatusJdbcDao extends BaseJdbcDao {
	private static Map<CbsActionType, Map<String, String>> COLMAP = null;
	private static final String SYNC_TIME = "SYNCTIME";
	private static final String FLAG_SYNCD = "FLAGSYNCD";
	private static final String QUERY_LAST_SYNC_TIME = "select {0} from mfi_cbs_sync";
	private static final String QUERY_UPDATE_TIME_FLAG = "update mfi_cbs_sync set {0}=:syncTime, {1}=:syncFlag";
	private static final String QUERY_UPDATE_FLAG = "update mfi_cbs_sync set  {0}=:syncFlag";

	public Date getLastSyncDateFor(CbsActionType p_action) {
		String l_query = MessageFormat.format(QUERY_LAST_SYNC_TIME,
				COLMAP.get(p_action).get(SYNC_TIME));
		return jdbcTemplate.queryForObject(l_query,
				new HashMap<String, String>(), new RowMapper<Date>() {

					@Override
					public Date mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						return rs.getDate(1);
					}
				});
	}

	public void updateSyncFlagFor(CbsActionType p_action) {

		Map<String, Object> l_params = new HashMap<String, Object>();
		l_params.put("syncFlag", "N");
		String l_query = MessageFormat.format(QUERY_UPDATE_FLAG,
				COLMAP.get(p_action).get(FLAG_SYNCD));
		jdbcTemplate.update(l_query, l_params);
	}

	public void updateLastSyncDateAndFlagFor(Date p_date,
			CbsActionType p_action) {

		Map<String, Object> l_params = new HashMap<String, Object>();
		l_params.put("syncTime", p_date);
		l_params.put("syncFlag", "Y");
		String l_query = MessageFormat.format(QUERY_UPDATE_TIME_FLAG, COLMAP
				.get(p_action).get(SYNC_TIME),
				COLMAP.get(p_action).get(FLAG_SYNCD));
		jdbcTemplate.update(l_query, l_params);
	}

	public CbsSyncStatusJdbcDao() {
		
		if (COLMAP == null) {
			synchronized (CbsSyncStatusJdbcDao.class) {
				if (COLMAP == null) {
					COLMAP = new HashMap<CbsActionType, Map<String, String>>();
					Map<String, String> l_depoMap = new HashMap<String, String>();
					Map<String, String> l_loanMap = new HashMap<String, String>();
					Map<String, String> l_customerMap = new HashMap<String, String>();
					Map<String, String> l_branchMap = new HashMap<String, String>();
					Map<String, String> l_currencyMap = new HashMap<String, String>();
					Map<String, String> l_fxRatesMap = new HashMap<String, String>();
					l_depoMap.put(SYNC_TIME, "DEPOSIT_SYNC_TIME");
					l_depoMap.put(FLAG_SYNCD, "DEPOSIT_SYNC");
					COLMAP.put(CbsActionType.SYNCDEPOSITS, l_depoMap);
					l_loanMap.put(SYNC_TIME, "LOAN_SYNC_TIME");
					l_loanMap.put(FLAG_SYNCD, "LOAN_SYNC");
					COLMAP.put(CbsActionType.SYNCLOANS, l_loanMap);
					l_customerMap.put(SYNC_TIME, "CUST_SYNC_TIME");
					l_customerMap.put(FLAG_SYNCD, "CUST_SYNC");
					COLMAP.put(CbsActionType.SYNCCUSTOMERS, l_customerMap);
					l_branchMap.put(SYNC_TIME, "BRN_SYNC_TIME");
					l_branchMap.put(FLAG_SYNCD, "BRN_SYNC");
					COLMAP.put(CbsActionType.SYNCBRANCHES, l_branchMap);
					l_currencyMap.put(SYNC_TIME, "CCY_SYNC_TIME");
					l_currencyMap.put(FLAG_SYNCD, "CCY_SYNC");
					COLMAP.put(CbsActionType.SYNCCURRENCY, l_currencyMap);
					l_fxRatesMap.put(SYNC_TIME, "FX_SYNC_TIME");
					l_fxRatesMap.put(FLAG_SYNCD, "FX_SYNC");
					COLMAP.put(CbsActionType.SYNCFXRATES, l_fxRatesMap);
				}
			}
		}
	}

}
