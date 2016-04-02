package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.DepositCollectionDao;
import com.bfsi.mfi.entity.DepositCollection;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("depositCollectionDao")
public class DepositCollectionJdbcDao extends MaintenanceJdbcDao<DepositCollection> implements DepositCollectionDao
{
	
	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.DEPCTXN_QUERY_SELECT_ALL;
	}
	
	@Override
	protected RowMapper<DepositCollection> getRowMapper() {
		return new DepositCollectionMapper();
	}	
	
	protected RowMapper<DepositCollection> getDepositCollectionMapper() {
		return new DepositCollectionMapper();
	}	
	
	private static final class DepositCollectionMapper implements RowMapper<DepositCollection> 
	{
		public DepositCollection mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			DepositCollection depositCollection=new DepositCollection();
			depositCollection.setTxnId(rs.getString("TXN_ID"));
			depositCollection.setDepOpenDate(rs.getDate("DEP_OPEN_DATE"));
			depositCollection.setDepPayFreq(rs.getString("DEP_PAY_FREQ"));
			depositCollection.setTotalInstPaid(rs.getDouble("TOTAL_INST_PAID"));
			depositCollection.setDepMaturityDate(rs.getDate("DEP_MATURITY_DATE"));
			depositCollection.setDepIntRate(rs.getDouble("DEP_INT_RATE"));
			depositCollection.setFullPartialFlag(rs.getString("COLL_FULL_PARTIAL_FLAG"));
			depositCollection.setDepInstAmtPaid(rs.getDouble("DEP_INST_AMT_PAID"));
			depositCollection.setTxnNarrative(rs.getString("TXN_NARRATIVE"));
			return depositCollection;
		}
	}

	@Override
	public DepositCollection get(String id) {
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