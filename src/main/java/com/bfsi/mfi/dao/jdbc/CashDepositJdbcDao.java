package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CashDepositDao;
import com.bfsi.mfi.entity.CashDeposit;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("cashDepositDao")
public class CashDepositJdbcDao extends MaintenanceJdbcDao<CashDeposit> implements CashDepositDao{


	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.CASHDEPOSIT_QUERY_SELECT_ALL;
	}
	
	@Override
	protected CashDepositMapper getRowMapper() {
		return new CashDepositMapper();
	}	
	
	protected CashDepositMapper getCashDepositMapper() {
		return new CashDepositMapper();
	}	
	
	private static final class CashDepositMapper implements RowMapper<CashDeposit> 
	{
		public CashDeposit mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			CashDeposit cashDeposit = new CashDeposit();
			
			   cashDeposit.setId(rs.getString("MBS_TXN_ID"));
			   cashDeposit.setTxnCode(rs.getString("txn_code"));
			   // EGALITE-353 start
			  // cashDeposit.setTxnDesc(rs.getString("txn_desc")); 
			   // EGALITE-353 end
			   cashDeposit.setCbsAcRefNo(rs.getString("cbs_ac_ref_no")); 
			   cashDeposit.setBranCode(rs.getString("branch_code"));
			   cashDeposit.setCustomerId(rs.getString("customer_id"));
			   cashDeposit.setCustomerFullName(rs.getString("customer_full_name")); 
			   cashDeposit.setAgentId(rs.getString("agent_id"));
			   cashDeposit.setAgentName(rs.getString("agent_name"));
			   cashDeposit.setLocationCode(rs.getString("location_code"));
			   cashDeposit.setLocationDesc(rs.getString("location_desc"));
			   
			   cashDeposit.setTxnAmount(rs.getDouble("txn_amount"));
			   
			   cashDeposit.setTxnNarrative(rs.getString("txn_narrative"));
			   
			   cashDeposit.setTxnInitTime(rs.getTimestamp("txn_init_time")); //date time
			   cashDeposit.setTxnSyncTime(rs.getTimestamp("txn_sync_time")); //date time
			   
			   cashDeposit.setTxnStatusDesc(rs.getString("txn_status_desc"));
			   cashDeposit.setTxnErrCode(rs.getString("TXN_ERR_CODE"));
			   cashDeposit.setTxnErrMessage(rs.getString("TXN_ERR_MESSAGE"));
			
			 return cashDeposit;
		}
	}
	
	@Override
	public CashDeposit get(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		return jdbcTemplate.queryForObject(ApplicationQuery.CASHDEPOSIT_QUERY_SELECT_ALL_DISB, params, getCashDepositMapper());
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
