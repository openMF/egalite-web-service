package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.RepaymentTxnDao;
import com.bfsi.mfi.entity.RepaymentTxn;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("repaymentTxnDao")
public class RepaymentTxnJdbcDao extends ReadOnlyMaintenanceJdbcDao<RepaymentTxn> implements RepaymentTxnDao 
{
	

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.REPTXN_QUERY_SELECT_ALL;
	}

	
	protected RowMapper<RepaymentTxn> getRepaymantMapper() {
		return new RepaymentMapper();
	}	
	
	protected RowMapper<RepaymentTxn> getRowMapper() {
		return new RepaymentMapper();
	}	
	
	private static final class RepaymentMapper implements RowMapper<RepaymentTxn> 
	{
		public RepaymentTxn mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			RepaymentTxn repaymentTxn=new RepaymentTxn();
			repaymentTxn.setTxnId(rs.getString(1));
			repaymentTxn.setTxnNarrative(rs.getString(2));
			repaymentTxn.setAmount(rs.getDouble(3));
			repaymentTxn.setRepaymentInst(rs.getString(4));
			repaymentTxn.setTxnTimestamp(rs.getDate(5));
			repaymentTxn.setTxnType(rs.getString(6));
			repaymentTxn.setAgentId(rs.getString(7)+" "+rs.getString(8));
			repaymentTxn.setLoanAcNo(rs.getString(9));
			repaymentTxn.setSyncTime(rs.getDate(10));
			repaymentTxn.setCustomerId(rs.getString(11));
			repaymentTxn.setDeviceId(rs.getString(12));
			repaymentTxn.setAuthStatus(rs.getString(13));
			repaymentTxn.setTxnStatus(rs.getString(14));
			repaymentTxn.setTxnCcy(rs.getString(15));
			return repaymentTxn;
		}
	}

	public RepaymentTxn get(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("id1", id);
		params.put("id2", id);
		return jdbcTemplate.queryForObject(ApplicationQuery.REPTXN_QUERY_SELECT_ALL_REPAY, params, getRepaymantMapper());
	}


	@Override
	public RepaymentTxn create(RepaymentTxn entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public RepaymentTxn update(RepaymentTxn entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public RepaymentTxn delete(RepaymentTxn entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public RepaymentTxn authorize(RepaymentTxn entity) {
		// TODO Auto-generated method stub
		return null;
	}


}