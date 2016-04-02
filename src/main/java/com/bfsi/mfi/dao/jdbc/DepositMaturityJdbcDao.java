package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.DepositMaturityDao;
import com.bfsi.mfi.entity.DepositMaturity;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("depositMaturityDao")
public class DepositMaturityJdbcDao extends MaintenanceJdbcDao<DepositMaturity> implements DepositMaturityDao
{
	
	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.DEPM_QUERY_SELECT_ALL;
	}
	
	@Override
	protected RowMapper<DepositMaturity> getRowMapper() {
		return new DepositMaturityMapper();
	}	
	
	protected RowMapper<DepositMaturity> getDepositMaturityMapper() {
		return new DepositMaturityMapper();
	}	
	
	private static final class DepositMaturityMapper implements RowMapper<DepositMaturity> 
	{
		public DepositMaturity mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			DepositMaturity depositMaturity=new DepositMaturity();
			
			depositMaturity.setTxnId(rs.getString("TXN_ID"));
			depositMaturity.setDepOpenDate(rs.getDate("DEP_OPEN_DATE"));
			depositMaturity.setDepPayFreq(rs.getString("DEP_PAY_FREQ"));
			depositMaturity.setDepInstAmt(rs.getDouble("DEP_INST_AMT"));
			depositMaturity.setDepIntRate(rs.getDouble("DEP_INT_RATE"));
			depositMaturity.setDepInstAmtPaid(rs.getDouble("DEP_INST_AMT_PAID"));
			depositMaturity.setDepIntAccured(rs.getDouble("DEP_INT_ACCRUED"));
			depositMaturity.setDepMaturityAmtPaid(rs.getDouble("DEP_MATURITY_AMT_PAID"));
			depositMaturity.setDepMaturityDate(rs.getDate("DEP_MATURITY_DATE"));
			depositMaturity.setRedemptionFlag(rs.getString("REDEMPTION_FLAG"));
			depositMaturity.setRedemptionPayoutDate(rs.getDate("REDEMPTION_PAYOUT_DATE"));
			depositMaturity.setRedemptionAmount(rs.getDouble("REDEMPTION_AMOUNT"));
			depositMaturity.setTxnNarrative(rs.getString("TXN_NARRATIVE"));
			
			return depositMaturity;
		}
	}

	@Override
	public DepositMaturity get(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		return jdbcTemplate.queryForObject(ApplicationQuery.DEPM_QUERY_SELECT_ALL_DISB, params, getDepositMaturityMapper());
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