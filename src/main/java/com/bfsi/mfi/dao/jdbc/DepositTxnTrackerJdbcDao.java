package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.DepositTxnTrackerDao;
import com.bfsi.mfi.entity.MfiMbsTxnReceiverV;
import com.bfsi.mfi.query.ApplicationQuery;
@Repository("depositTxnTrackerDao")
public class DepositTxnTrackerJdbcDao extends ReadOnlyMaintenanceJdbcDao<MfiMbsTxnReceiverV> implements DepositTxnTrackerDao {

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.DEPTXNS_QUERY_SELECT_ALL;
	}

/*	@Override
	protected RowMapper<AgentTransaction> getRowMapper() {
		return new AgentMapper();
	}
	
	protected RowMapper<AgentTransaction> getTransactionMapper() {
		return new TransactionMapper();
	}*/
	@Override
	protected RowMapper<MfiMbsTxnReceiverV> getRowMapper() {
		return new AgentMapper();
	}
	
	protected RowMapper<MfiMbsTxnReceiverV> getTransactionMapper() {
		return new TransactionMapper();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MfiMbsTxnReceiverV>  getView() {
		String sql = getSelectAllQuery();
		return jdbcTemplate.query(sql, (Map) null, getRowMapper());
		
	}
	/*@Override
	public MfiMbsTxnReceiverV get(String id) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		return jdbcTemplate.queryForObject(ApplicationQuery.QUERY_SELECT_TXNS, params, getTransactionMapper());
	}*/
	
/*	private static final class AgentMapper implements RowMapper<AgentTransaction> 
	{
		public AgentTransaction mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			AgentTransaction agentTransaction=new AgentTransaction();
			agentTransaction.setTxnId(rs.getString(1));
			System.out.println("rs.getString(1) = " +rs.getString(1));
			agentTransaction.setTxnTimestamp(rs.getDate(2));
			agentTransaction.setTxnType(rs.getString(3));
			agentTransaction.setLoanAcNo(rs.getString(4));
			agentTransaction.setSyncTime(rs.getDate(5));
			agentTransaction.setDeviceId(rs.getString(6));
			agentTransaction.setAuthStatus(rs.getString(7));
			agentTransaction.setTxnStatus(rs.getString(8));
			agentTransaction.setAgentId(rs.getString(9)+" "+rs.getString(10));
			agentTransaction.setCustomerId(rs.getString(11));
			agentTransaction.setTxnAmount(rs.getDouble(12));
			agentTransaction.setTxnCcy(rs.getString(13));
			agentTransaction.setCreditOfficer(rs.getString(14));
			return agentTransaction;
		}
	}*/
	private static final class AgentMapper implements RowMapper<MfiMbsTxnReceiverV> 
	{
		public MfiMbsTxnReceiverV mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			
			MfiMbsTxnReceiverV mfiMbsTxnReceiver = new MfiMbsTxnReceiverV();
		
			mfiMbsTxnReceiver.setId(rs.getString("MBS_TXN_ID"));
			mfiMbsTxnReceiver.setTxnDesc(rs.getString("TXN_DESC"));
			mfiMbsTxnReceiver.setTxnCode(rs.getString("TXN_CODE"));
			mfiMbsTxnReceiver.setAgendaId(rs.getString("AGENDA_ID"));
			mfiMbsTxnReceiver.setSeqNo(rs.getLong("SEQ_NO"));
			mfiMbsTxnReceiver.setCbsAcRefNo(rs.getString("CBS_AC_REF_NO"));
			mfiMbsTxnReceiver.setBranchCode(rs.getString("BRANCH_CODE"));
			mfiMbsTxnReceiver.setCustomerId(rs.getString("CUSTOMER_ID"));
			mfiMbsTxnReceiver.setAgentId(rs.getString("AGENT_ID"));
			mfiMbsTxnReceiver.setDeviceId(rs.getString("DEVICE_ID"));
			mfiMbsTxnReceiver.setLocationCode(rs.getString("LOCATION_CODE"));
			mfiMbsTxnReceiver.setTxnInitTime(BaseJdbcDao.getUtilDate(rs.getDate("TXN_INIT_TIME")));
			mfiMbsTxnReceiver.setTxnStatusDesc(rs.getString("TXN_STATUS_DESC"));
			return mfiMbsTxnReceiver;

		}
	}

/*	private static final class TransactionMapper implements RowMapper<AgentTransaction> 
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
			agentTransaction.setTxnStatus(rs.getString("TXN_STATUS"));
			agentTransaction.setTxnCcy(rs.getString("TXN_CCY"));
			return agentTransaction;
		}
	}*/
	private static final class TransactionMapper implements RowMapper<MfiMbsTxnReceiverV> 
	{
		public MfiMbsTxnReceiverV mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			MfiMbsTxnReceiverV mfiMbsTxnReceiver = new MfiMbsTxnReceiverV();
			/*mfiMbsTxnReceiver.setMbsTxnId(rs.getString(1));
			mfiMbsTxnReceiver.setTxnDesc(rs.getString(2));
			mfiMbsTxnReceiver.setAgendaId(rs.getString(3));
			mfiMbsTxnReceiver.setSeqNo(rs.getLong(4));
			mfiMbsTxnReceiver.setCbsAcRefNo(rs.getString(5));
			mfiMbsTxnReceiver.setBranchCode(rs.getString(6));
			mfiMbsTxnReceiver.setCustomerId(rs.getString(7));
			mfiMbsTxnReceiver.setAgentId(rs.getString(8));
			mfiMbsTxnReceiver.setDeviceId(rs.getString(9));
			mfiMbsTxnReceiver.setLocationCode(rs.getString(10));
			mfiMbsTxnReceiver.setTxnInitTime(BaseJdbcDao.getUtilDate(rs.getDate(11)));
			mfiMbsTxnReceiver.setTxnStatusDesc(rs.getString(12));*/
			//mfiMbsTxnReceiver.setMbsTxnId(rs.getString("MBS_TXN_ID"));
			mfiMbsTxnReceiver.setId(rs.getString("MBS_TXN_ID"));
			mfiMbsTxnReceiver.setTxnDesc(rs.getString("TXN_DESC"));
			mfiMbsTxnReceiver.setTxnCode(rs.getString("TXN_CODE"));
			mfiMbsTxnReceiver.setAgendaId(rs.getString("AGENDA_ID"));
			mfiMbsTxnReceiver.setSeqNo(rs.getLong("SEQ_NO"));
			mfiMbsTxnReceiver.setCbsAcRefNo(rs.getString("CBS_AC_REF_NO"));
			mfiMbsTxnReceiver.setBranchCode(rs.getString("BRANCH_CODE"));
			mfiMbsTxnReceiver.setCustomerId(rs.getString("CUSTOMER_ID"));
			mfiMbsTxnReceiver.setAgentId(rs.getString("AGENT_ID"));
			mfiMbsTxnReceiver.setDeviceId(rs.getString("DEVICE_ID"));
			mfiMbsTxnReceiver.setLocationCode(rs.getString("LOCATION_CODE"));
			mfiMbsTxnReceiver.setTxnInitTime(BaseJdbcDao.getUtilDate(rs.getDate("TXN_INIT_TIME")));
			mfiMbsTxnReceiver.setTxnStatusDesc(rs.getString("TXN_STATUS_DESC"));
			return mfiMbsTxnReceiver;
		}
	}

}
