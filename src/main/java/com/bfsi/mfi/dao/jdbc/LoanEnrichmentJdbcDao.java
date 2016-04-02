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

import com.bfsi.mfi.dao.LoanEnrichmentDao;
import com.bfsi.mfi.entity.Agent;
import com.bfsi.mfi.entity.Loan;
import com.bfsi.mfi.entity.LoanEnrichment;
import com.bfsi.mfi.query.ApplicationQuery;

/**
 * DAO for LoanEnrichment.
 * 
 * @author Jyoti Ranjan
 */

@Repository("loanEnrichmentDao")
public class LoanEnrichmentJdbcDao extends BaseJdbcDao implements
		LoanEnrichmentDao {

	@SuppressWarnings("unchecked")
	public List<LoanEnrichment> get() {
		return jdbcTemplate.query(ApplicationQuery.LENC_QUERY_SELECT_ALL, (Map) null, getRowMapper(false));
	}

	/**
	 * assign agent to loan
	 */
	public void insert(LoanEnrichment loanEnrichment) {
		Map<String, Object> params = new HashMap<String, Object>();
		//DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		params.put("agentId", loanEnrichment.getAgent().getId());
		params.put("loanAcNo", loanEnrichment.getLoan().getId());
		params.put("allocateUser", loanEnrichment.getAllocateUser());
		params.put("allocationTime", loanEnrichment.getAllocationTime());
		params.put("locationCode", loanEnrichment.getLocationCode());
		
		jdbcTemplate.execute(ApplicationQuery.LENC_QUERY_INSERT_AGENTID, params,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});
		
		jdbcTemplate.execute(ApplicationQuery.LENC_QUERY_INSERT_ISALLOCATED, params,
				new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement stmt)
					throws SQLException, DataAccessException {
				return stmt.executeUpdate();
			}
		});

	}
	protected RowMapper<LoanEnrichment> getRowMapper(boolean unassigned) {
		return new LoanEnrichmentMapper(unassigned);//
	}
	
	
	private static final class LoanEnrichmentMapper implements
	RowMapper<LoanEnrichment> {
private boolean onlyUnassigned;
public LoanEnrichmentMapper(
		boolean onlyUnassigned) {
	this.onlyUnassigned = onlyUnassigned;
}

public LoanEnrichment mapRow(ResultSet rs, int rowNum)
		throws SQLException {
	LoanEnrichment loanEnrichment = new LoanEnrichment();
	Agent agent = new Agent();
	Loan loan =new Loan();

	if (!onlyUnassigned) {
		agent.setId(rs.getString("AGENT_ID"));
		
	}
	
	agent.setId(rs.getString("AGENT_ID"));//FOR SHOW AGENTID WHICH ARE ALREDY ENRICH
	loan.setLoanAcNo(rs.getString("LOAN_AC_NO"));
	
	loanEnrichment.setLocationCode(rs.getString("LOCATION_CODE"));
	loanEnrichment.setAllocateUser(rs.getString("ALLOCATION_BY"));
	loanEnrichment.setAllocationTime((rs.getTimestamp("ALLOCATION_TIME")));
	
	loanEnrichment.setAgent(agent);
	loanEnrichment.setLoan(loan);
	
	return loanEnrichment;
 }
}

	@Override
	public List<LoanEnrichment> getUnassigned() {
		return jdbcTemplate.query(ApplicationQuery.LENC_QUERY_SELECT_UNASSIGNED, (Map) null, getRowMapper(true));
	}
	
}
