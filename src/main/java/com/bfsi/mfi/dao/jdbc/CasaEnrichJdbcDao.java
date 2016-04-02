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

import com.bfsi.mfi.dao.CasaEnrichDao;
import com.bfsi.mfi.entity.Agent;
import com.bfsi.mfi.entity.CustAcEnrichment;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("casaEnrichJdbcDao")
public class CasaEnrichJdbcDao extends BaseJdbcDao implements CasaEnrichDao {

	@SuppressWarnings("unchecked")
	public List<CustAcEnrichment> get() {
		return jdbcTemplate.query(
				ApplicationQuery.CASA_ENRICH_QUERY_SELECT_ALL, (Map) null,
				getRowMapper(false));
	}

	/**
	 * assign agent to Customer A/C
	 */
	public void insert(CustAcEnrichment custAcEnrichment) {
		Map<String, Object> params = new HashMap<String, Object>();
		// DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		params.put("custAcNo", custAcEnrichment.getId());
		params.put("agentId", custAcEnrichment.getAgent().getId());
		params.put("allocateUser", custAcEnrichment.getAllocationBy());
		params.put("allocationTime", custAcEnrichment.getAllocationTime());
		params.put("locationCode", custAcEnrichment.getLocationCode());

		jdbcTemplate.execute(ApplicationQuery.CASA_ENRICH_QUERY_INSERT_AGENTID,
				params, new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});

		jdbcTemplate.execute(
				ApplicationQuery.CASA_ENRICH_QUERY_INSERT_ISALLOCATED, params,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});

	}

	protected RowMapper<CustAcEnrichment> getRowMapper(boolean unassigned) {
		return new CustAcEnrichmentMapper(unassigned);//
	}

	private static final class CustAcEnrichmentMapper implements
			RowMapper<CustAcEnrichment> {
		private boolean onlyUnassigned;

		public CustAcEnrichmentMapper(boolean onlyUnassigned) {
			this.onlyUnassigned = onlyUnassigned;
		}

		public CustAcEnrichment mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			CustAcEnrichment custAcEnrichment = new CustAcEnrichment();
			 Agent agent = new Agent();
			// Loan loan =new Loan();

			if (!onlyUnassigned) {
				agent.setId(rs.getString("AGENT_ID"));

			}

			agent.setId(rs.getString("AGENT_ID"));//FOR SHOW AGENTID WHICH ARE ALREDY ENRICH
			custAcEnrichment.setId(rs.getString("CUST_AC_NO"));

			custAcEnrichment.setLocationCode(rs.getString("LOCATION_CODE"));
			custAcEnrichment.setAllocationBy(rs.getString("ALLOCATION_BY"));
			custAcEnrichment.setAllocationTime((rs
					.getTimestamp("ALLOCATION_TIME")));

			 custAcEnrichment.setAgent(agent);
			// custAcEnrichment.setLoan(loan);

			return custAcEnrichment;
		}
	}

	@Override
	public List<CustAcEnrichment> getUnassigned() {
		return jdbcTemplate.query(
				ApplicationQuery.CASA_ENRICH_QUERY_SELECT_UNASSIGNED,
				(Map) null, getRowMapper(true));
	}

	
}
