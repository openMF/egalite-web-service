package com.bfsi.mfi.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.DepositEnrichmentDao;
import com.bfsi.mfi.entity.Agent;
import com.bfsi.mfi.entity.DepositEnrichment;
import com.bfsi.mfi.entity.PigmyDeposit;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("depositEnrichmentDao")
public class DepositEnrichmentJdbcDao extends BaseJdbcDao implements DepositEnrichmentDao {
	
	/**
	 * assign agent to loan
	 */
	public void insert(DepositEnrichment depositEnrichment) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("agentId", depositEnrichment.getAgent().getId());
		params.put("depositAccountNumber", depositEnrichment.getDeposit().getId());
		params.put("allocateUser", depositEnrichment.getAllocateUser());
		params.put("allocationTime", depositEnrichment.getAllocationTime());
		params.put("locationCode", depositEnrichment.getLocationCode());
		jdbcTemplate.execute(ApplicationQuery.DEPE_QUERY_INSERT_AGENTID, params,
				new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement stmt)
					throws SQLException, DataAccessException {
				return stmt.executeUpdate();
			}
		});
		
		
		jdbcTemplate.execute(ApplicationQuery.DEPE_QUERY_INSERT_ISALLOCATED, params,
				new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement stmt)
					throws SQLException, DataAccessException {
				return stmt.executeUpdate();
			}
		});
		

	}

	protected RowMapper<DepositEnrichment> getRowMapper(boolean unassigned) {
		return new DepositEnrichmentMapper(new OnlyDepositDetailsMapper(), unassigned);//
	}

	private static final class DepositEnrichmentMapper implements
	RowMapper<DepositEnrichment> {
		private OnlyDepositDetailsMapper depositMapper;//
		private boolean onlyUnassigned;

		public DepositEnrichmentMapper(OnlyDepositDetailsMapper onlyDepositMapper, //
				boolean onlyUnassigned) {
			this.depositMapper = onlyDepositMapper;
			this.onlyUnassigned = onlyUnassigned;
		}

		public DepositEnrichment mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			DepositEnrichment depositEnrichment = new DepositEnrichment();
			Agent agent = new Agent();
			PigmyDeposit pigmyDeposit =new PigmyDeposit();

			if (!onlyUnassigned) {
				agent.setId(rs.getString("AGENT_ID"));
			}
			
			     agent.setId(rs.getString("AGENT_ID"));
			
				pigmyDeposit.setDepositAccountNumber(rs.getString("DEP_AC_NO"));
				depositEnrichment.setLocationCode(rs.getString("LOCATION_CODE"));
				depositEnrichment.setAllocateUser(rs.getString("ALLOCATION_BY"));
				depositEnrichment.setAllocationTime((rs.getTimestamp("ALLOCATION_TIME")));
				
			
			depositEnrichment.setAgent(agent);

			PigmyDeposit deposit = depositMapper.mapRow(rs, rowNum);
			depositEnrichment.setPigmyDeposit(deposit);
			return depositEnrichment;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DepositEnrichment> getUnassigned() {
		return jdbcTemplate.query(ApplicationQuery.DEPE_QUERY_SELECT_UNASSIGNED, (Map) null, getRowMapper(false));
	}
	
	

	private static final class OnlyDepositDetailsMapper implements
	RowMapper<PigmyDeposit> {
		// Please rewrite the following code
		@Override
		public PigmyDeposit mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			PigmyDeposit pigmyDeposit = new PigmyDeposit();
			pigmyDeposit.setId(rs.getString("dep_ac_no"));
			pigmyDeposit.setDepositAccountNumber(rs.getString("dep_ac_no"));
			return pigmyDeposit;
		}
	}

	@Override
	public void updateDeposit(DepositEnrichment depositEnrichment) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("agentId", depositEnrichment.getAgent().getId());
		params.put("depositAccountNumber", depositEnrichment.getDeposit().getId());
		params.put("locationCode", depositEnrichment.getLocationCode());
		jdbcTemplate.execute(ApplicationQuery.DEPE_QUERY_UPDATE_AGENTID, params,
				new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement stmt)
					throws SQLException, DataAccessException {
				return stmt.executeUpdate();
			}
		});

	}
}
