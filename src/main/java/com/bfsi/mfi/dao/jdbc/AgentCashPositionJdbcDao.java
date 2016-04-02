package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.AgentCashPositionDao;
import com.bfsi.mfi.entity.AgentCashRecord;
import com.bfsi.mfi.entity.CashPositionServiceRequest;
import com.bfsi.mfi.query.ApplicationQuery;

/**
 * 
 * @author Shabu
 * 
 */
@Repository
public class AgentCashPositionJdbcDao extends BaseJdbcDao implements
		AgentCashPositionDao {

	private static final String STATUS_NOT_SYNCED = "P";
	private static final String STATUS_SYNCED = "S";
	private static final String STATUS_AUTHORISED = "A";

	@Override
	public List<AgentCashRecord> getAgentCashRecords(
			CashPositionServiceRequest p_req) {

		Map<String, Object> l_params = new HashMap<String, Object>();
		//System.out.println(p_req.getAgentId() +" : "+ p_req.getDeviceId() + " : "+p_req.getBatchSize());
		l_params.put("agentId", p_req.getAgentId());
		l_params.put("batchSize",Integer.valueOf(p_req.getBatchSize()));
		l_params.put("deviceId", p_req.getDeviceId());
		l_params.put("syncStatus", STATUS_NOT_SYNCED);
		l_params.put("authStatus", STATUS_AUTHORISED);

		return jdbcTemplate.query(ApplicationQuery.QUERY_GET_AGENT_CASH_RECORDS, l_params,
				new AgentCashRecordMapper());
	}

	@Override
	public void updateAgentCashRecordStatus(String[] p_recvdIds) {

		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("syncStatus", STATUS_SYNCED);

		StringBuilder l_queryBuilder = new StringBuilder(
				ApplicationQuery.QUERY_UPDATE_AGENT_CASH_RECORD);
		String l_delimiter = "";

		for (int l_i = 0; l_i < p_recvdIds.length; l_i++) {
			l_params.put("param" + l_i, p_recvdIds[l_i]);
			l_queryBuilder.append(l_delimiter + ":param" + l_i);
			l_delimiter = ",";
		}

		l_queryBuilder.append(')');
		jdbcTemplate.update(l_queryBuilder.toString(), l_params);

	}

	private static final class AgentCashRecordMapper implements
			RowMapper<AgentCashRecord> {

		@Override
		public AgentCashRecord mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			AgentCashRecord l_record = new AgentCashRecord();

			l_record.setEntrySeqNo(rs.getString("ENTRY_SEQ_NO"));
			l_record.setCashTxnId(rs.getString("CASH_TXN_ID"));
			l_record.setCashTxnSeqNo(rs.getInt("CASH_TXN_SEQ_NO"));
			l_record.setTxnSource(rs.getString("TXN_SOURCE"));
			l_record.setTxnDateTime(rs.getDate("TXN_DATETIME"));
			l_record.setTxnCode(rs.getString("TXN_CODE"));
			l_record.setAgentId(rs.getString("AGENT_ID"));
			l_record.setDeviceId(rs.getString("DEVICE_ID"));
			l_record.setAgendaId(rs.getString("AGENDA_ID"));
			l_record.setAgendaSeqNo(rs.getInt("AGN_SEQ_NO"));
			l_record.setTxnCcy(rs.getString("TXN_CCY_CODE"));
			l_record.setDrCrIndicator(rs.getString("DR_CR_IND"));
			l_record.setAmount(rs.getDouble("CASH_AMOUNT"));
			l_record.setSyncStatus(rs.getString("SYNC_STATUS"));
			// l_record.setSyncTime(rs.getString("SYNC_TIME"));
			l_record.setAuthStatus(rs.getString("AUTH_STAT"));
			l_record.setIsReversal(rs.getString("IS_REVERSAL"));
			l_record.setIsDeleted(rs.getString("IS_DELETED"));

			return l_record;
		}

	}
}
