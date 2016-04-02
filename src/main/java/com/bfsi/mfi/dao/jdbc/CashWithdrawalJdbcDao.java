package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CashWithdrawalDao;
import com.bfsi.mfi.entity.CashWithdrawal;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("cashWithdrawalDao")
public class CashWithdrawalJdbcDao extends MaintenanceJdbcDao<CashWithdrawal> implements CashWithdrawalDao{

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.CASHWITHDRAW_QUERY_SELECT_ALL;
	}
	
	@Override
	protected CashWithdrawalMapper getRowMapper() {
		return new CashWithdrawalMapper();
	}	
	
	protected CashWithdrawalMapper getCashWithdrawalMapper() {
		return new CashWithdrawalMapper();
	}	
	
	private static final class CashWithdrawalMapper implements RowMapper<CashWithdrawal> 
	{
		public CashWithdrawal mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			CashWithdrawal cashWithdrawal = new CashWithdrawal();
			
			   cashWithdrawal.setId(rs.getString("MBS_TXN_ID"));
			   cashWithdrawal.setTxnCode(rs.getString("txn_code"));
			   //EGALITE-353 start
			  // cashWithdrawal.setTxnDesc(rs.getString("txn_desc"));
			   //EGALITE-353 end
			   cashWithdrawal.setCbsAcRefNo(rs.getString("cbs_ac_ref_no")); 
			   cashWithdrawal.setBranCode(rs.getString("branch_code"));
			   cashWithdrawal.setCustomerId(rs.getString("customer_id"));
			   cashWithdrawal.setCustomerFullName(rs.getString("customer_full_name")); 
			   cashWithdrawal.setAgentId(rs.getString("agent_id"));
			   cashWithdrawal.setAgentName(rs.getString("agent_name"));
			   cashWithdrawal.setLocationCode(rs.getString("location_code"));
			   cashWithdrawal.setLocationDesc(rs.getString("location_desc"));
			   cashWithdrawal.setTxnAmount(rs.getDouble("txn_amount"));
			   cashWithdrawal.setTxnNarrative(rs.getString("txn_narrative"));
			   cashWithdrawal.setTxnInitTime(rs.getTimestamp("txn_init_time")); //date time
			   cashWithdrawal.setTxnSyncTime(rs.getTimestamp("txn_sync_time")); //date time
			   cashWithdrawal.setTxnStatusDesc(rs.getString("txn_status_desc"));
			   cashWithdrawal.setTxnErrCode(rs.getString("TXN_ERR_CODE"));
			   cashWithdrawal.setTxnErrMessage(rs.getString("TXN_ERR_MESSAGE"));
			   return cashWithdrawal;
		}
	}
	@Override
	public CashWithdrawal get(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		return jdbcTemplate.queryForObject(ApplicationQuery.CASHWITHDRAW_QUERY_SELECT_ALL_DISB, params, getCashWithdrawalMapper());
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
