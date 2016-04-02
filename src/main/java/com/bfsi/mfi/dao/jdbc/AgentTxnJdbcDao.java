package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.AgentTxnDao;
import com.bfsi.mfi.entity.AgentTransaction;

@Repository("agentTxnDao")
public class AgentTxnJdbcDao extends ReadOnlyMaintenanceJdbcDao<AgentTransaction> implements AgentTxnDao 
{
	
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	private static final String QUERY_SELECT_ALL = "SELECT T.TXN_ID, T.TXN_TIMESTAMP, T.TXN_TYPE, T.LOAN_AC_NO, T.SYNC_TIME," 
			+ " T.DEVICE_ID, T.AUTH_STATUS, T.TXN_STATUS, A.FIRST_NAME, A.LAST_NAME, C.CUSTOMER_NAME, T.TXN_AMOUNT," 
			+ " T.TXN_CCY , C.CREDIT_OFFICER FROM IFTB_TRANSACTIONS T LEFT OUTER JOIN AMTB_AGENTS A on A.AGENT_ID=T.AGENT_ID " 
			+ " LEFT OUTER JOIN IFTB_CUST_DETAIL C on C.CUSTOMER_ID=T.CUSTOMER_ID " 
			+ " ORDER BY LOAN_AC_NO, TXN_TIMESTAMP";

	private static final String QUERY_SELECT_TXNS = " SELECT TXN_ID, TXN_TIMESTAMP, TXN_TYPE, AGENT_ID, LOAN_AC_NO," 
			+ " SYNC_TIME, CUSTOMER_ID, DEVICE_ID, AUTH_STATUS,TXN_STATUS,TXN_CCY FROM IFTB_TRANSACTIONS WHERE TXN_ID=:id"
			+ " ORDER BY LOAN_AC_NO, TXN_TIMESTAMP";
	
	@Override
	protected String getSelectAllQuery() {
		return QUERY_SELECT_ALL;
	}

	@Override
	protected RowMapper<AgentTransaction> getRowMapper() {
		return new AgentMapper();
	}
	
	protected RowMapper<AgentTransaction> getTransactionMapper() {
		return new TransactionMapper();
	}
	@Override
	public AgentTransaction get(String id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		return jdbcTemplate.queryForObject(QUERY_SELECT_TXNS, params, getRowMapper());
	}
	
	private static final class AgentMapper implements RowMapper<AgentTransaction> 
	{
		public AgentTransaction mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			AgentTransaction agentTransaction=new AgentTransaction();
			agentTransaction.setTxnId(rs.getString(1));
			//System.out.println("rs.getString(1) = " +rs.getString(1));
			agentTransaction.setTxnTimestamp(rs.getDate(2));
			agentTransaction.setTxnType(rs.getString(3));
			agentTransaction.setLoanAcNo(rs.getString(4));
			agentTransaction.setSyncTime(rs.getDate(5));
			agentTransaction.setDeviceId(rs.getString(6));
			agentTransaction.setAuthStatus(rs.getString(7));
			agentTransaction.setTxnStatus(Integer.valueOf(rs.getString(8)));
			agentTransaction.setAgentId(rs.getString(9)+" "+rs.getString(10));
			agentTransaction.setCustomerId(rs.getString(11));
			agentTransaction.setTxnAmount(rs.getDouble(12));
			agentTransaction.setTxnCcy(rs.getString(13));
			agentTransaction.setCreditOfficer(rs.getString(14));
			return agentTransaction;
		}
	}

	private static final class TransactionMapper implements RowMapper<AgentTransaction> 
	{
		public AgentTransaction mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			AgentTransaction agentTransaction=new AgentTransaction();
			agentTransaction.setTxnId(rs.getString("TXN_ID"));
			agentTransaction.setTxnTimestamp(rs.getDate("TXN_TIMESTAMP"));
			agentTransaction.setTxnType(rs.getString("TXN_TYPE"));
			agentTransaction.setAgentId(rs.getString("AGENT_ID"));
			agentTransaction.setLoanAcNo(rs.getString("LOAN_AC_NO"));
			agentTransaction.setSyncTime(rs.getDate("SYNC_TIME"));
			agentTransaction.setCustomerId(rs.getString("CUSTOMER_ID"));
			agentTransaction.setDeviceId(rs.getString("DEVICE_ID"));
			agentTransaction.setAuthStatus(rs.getString("AUTH_STATUS"));
			agentTransaction.setTxnStatus(Integer.valueOf(rs.getString("TXN_STATUS")));
			agentTransaction.setTxnCcy(rs.getString("TXN_CCY"));
			return agentTransaction;
		}
	}
}