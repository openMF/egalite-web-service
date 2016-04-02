package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.DisbursementTxnDao;
import com.bfsi.mfi.entity.DisbursementTxn;

@Repository("disbursementTxnDao")
public class DisbursementTxnJdbcDao extends ReadOnlyMaintenanceJdbcDao<DisbursementTxn> implements DisbursementTxnDao 
{
	
	private static final String QUERY_SELECT_ALL = " SELECT TXN_ID, TXN_NARRATIVE, TXN_AMOUNT FROM IFTB_DISBURSEMENTS";
	
	private static final String QUERY_SELECT_ALL_DISB = "SELECT D.TXN_ID, D.TXN_NARRATIVE, D.TXN_AMOUNT, T.TXN_TIMESTAMP," 
						+" T.TXN_TYPE, A.FIRST_NAME, A.LAST_NAME, T.LOAN_AC_NO, T.SYNC_TIME,C.CUSTOMER_NAME, T.DEVICE_ID, " 
						+" T.AUTH_STATUS, T.TXN_STATUS, T.TXN_CCY FROM IFTB_DISBURSEMENT D LEFT OUTER JOIN IFTB_TRANSACTIONS T ON " 
						+" T.TXN_ID=:id LEFT OUTER JOIN IFTB_CUST_DETAIL C ON C.CUSTOMER_ID=T.CUSTOMER_ID " 
						+" LEFT OUTER JOIN AMTB_AGENTS A ON A.AGENT_ID=T.AGENT_ID and D.TXN_ID=:id1 where D.TXN_ID=:id2";
			
	@Override
	protected String getSelectAllQuery() {
		return QUERY_SELECT_ALL;
	}
	
	@Override
	protected RowMapper<DisbursementTxn> getRowMapper() {
		return new DisbursementTxnMapper();
	}	
	
	protected RowMapper<DisbursementTxn> getDisbursementMapper() {
		return new DisbursementTxnMapper();
	}	
	
	private static final class DisbursementTxnMapper implements RowMapper<DisbursementTxn> 
	{
		public DisbursementTxn mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			DisbursementTxn disbursementTxn=new DisbursementTxn();
			disbursementTxn.setTxnId(rs.getString(1));
			disbursementTxn.setTxnNarrative(rs.getString(2));
			disbursementTxn.setAmount(rs.getDouble(3));
			disbursementTxn.setTxnTimestamp(rs.getDate(4));
			disbursementTxn.setTxnType(rs.getString(5));
			disbursementTxn.setAgentId(rs.getString(6)+" "+rs.getString(7));
			disbursementTxn.setLoanAcNo(rs.getString(8));
			disbursementTxn.setSyncTime(rs.getDate(9));
			disbursementTxn.setCustomerId(rs.getString(10));
			disbursementTxn.setDeviceId(rs.getString(11));
			disbursementTxn.setAuthStatus(rs.getString(12));
			disbursementTxn.setTxnStatus(rs.getString(13));
			disbursementTxn.setTxnCcy(rs.getString(14));
			return disbursementTxn;
		}
	}

	@Override
	public DisbursementTxn get(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("id1", id);
		params.put("id2", id);
		return jdbcTemplate.queryForObject(QUERY_SELECT_ALL_DISB, params, getDisbursementMapper());
	}

	@Override
	public DisbursementTxn create(DisbursementTxn entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DisbursementTxn update(DisbursementTxn entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DisbursementTxn delete(DisbursementTxn entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DisbursementTxn authorize(DisbursementTxn entity) {
		// TODO Auto-generated method stub
		return null;
	}

}