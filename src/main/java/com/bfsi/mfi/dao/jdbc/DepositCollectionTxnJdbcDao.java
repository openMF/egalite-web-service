package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.DepositCollectionTxnDao;
import com.bfsi.mfi.entity.DepositCollectionTxnTracker;
import com.bfsi.mfi.query.ApplicationQuery;


@Repository("depositCollectionTxnDao")
public class DepositCollectionTxnJdbcDao extends MaintenanceJdbcDao<DepositCollectionTxnTracker> implements DepositCollectionTxnDao{
	
	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.DEPCTXN_QUERY_SELECT_ALL;
	}
	
	@Override
	protected RowMapper<DepositCollectionTxnTracker> getRowMapper() {
		return new DepositCollectionTxnMapper();
	}	
	
	protected RowMapper<DepositCollectionTxnTracker> getDepositCollectionMapper() {
		return new DepositCollectionTxnMapper();
	}	
	
	private static final class DepositCollectionTxnMapper implements RowMapper<DepositCollectionTxnTracker> 
	{
		public DepositCollectionTxnTracker mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			DepositCollectionTxnTracker depositCollection = new DepositCollectionTxnTracker();
			
			depositCollection.setId(rs.getString("MBS_TXN_ID"));
			depositCollection.setAgendaId(rs.getString("AGENDA_ID"));
			depositCollection.setSeqNo(rs.getLong("SEQ_NO"));
			depositCollection.setTxnCode(rs.getString("TXN_CODE"));
			depositCollection.setCbsAcRefNo(rs.getString("CBS_AC_REF_NO"));
			depositCollection.setBranchCode(rs.getString("BRANCH_CODE"));
			depositCollection.setCustomerId(rs.getString("CUSTOMER_ID"));
			depositCollection.setCustomerFullName(rs.getString("CUSTOMER_FULL_NAME"));
			depositCollection.setAgentId(rs.getString("AGENT_ID"));
			depositCollection.setAgentName(rs.getString("AGENT_NAME"));
			depositCollection.setLocationCode(rs.getString("LOCATION_CODE"));
			depositCollection.setLocationDesc(rs.getString("LOCATION_DESC"));
			depositCollection.setAmountDue(rs.getDouble("AMOUNT_DUE"));
			depositCollection.setAmountPaid(rs.getDouble("AMOUNT_PAID"));
			depositCollection.setTxnNarrative(rs.getString("TXN_NARRATIVE"));
			depositCollection.setTxnInitTime(rs.getDate("TXN_INIT_TIME"));
			depositCollection.setTxnSyncTime(rs.getDate("TXN_SYNC_TIME"));
			depositCollection.setTxnStatusDesc(rs.getString("TXN_STATUS_DESC"));
			depositCollection.setTxnErrCode(rs.getString("TXN_ERR_CODE"));
			depositCollection.setTxnErrMessage(rs.getString("TXN_ERR_MESSAGE"));
			/*For Tag No : EGA-MN15-000021 Starts*/
			depositCollection.setGeneratedSms(rs.getString("GENERATED_SMS"));
			depositCollection.setSmsMobileNo(rs.getString("SMS_MOBILE_NO"));
			depositCollection.setSmsContent(rs.getString("SMS_CONTENT"));
			depositCollection.setGeneratedRevr(rs.getString("GENERATED_REVR"));
			depositCollection.setFullPartInd(rs.getString("FULL_PART_IND"));
			depositCollection.setSyncType(rs.getString("SYNC_TYPE"));
			/*For Tag No : EGA-MN15-000021 End*/
			
			return depositCollection;
		}
	}
	
	
	@Override
	public DepositCollectionTxnTracker get(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		return jdbcTemplate.queryForObject(ApplicationQuery.DEPCTXN_QUERY_SELECT_ALL_DISB, params, getDepositCollectionMapper());
	}
	
	
	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
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
	
}
