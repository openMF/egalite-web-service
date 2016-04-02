package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.AgendaDao;

import com.bfsi.mfi.entity.Agenda;
import com.bfsi.mfi.entity.AgendaServiceRequest;
import com.bfsi.mfi.entity.AgendaUpdate;

import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Repository
public class AgendaJdbcDao extends MaintenanceJdbcDao<Agenda> implements AgendaDao {	
	
	private static final String AGENDA_UPDATE_STATUS="1";
	private static final String AGENDA_SELECT_STATUS="0";
	@Autowired
	private DataSource dataSource;

	@Override
	public void updateAgendaStatus(AgendaUpdate p_agenda) {
		//SyncServiceProcHandler l_procHandler=new SyncServiceProcHandler(dataSource, PROC_UPDATE_STATUS);
		//l_procHandler.processUpdateAgendaStatus(p_agendaList);
		Map<String, Object> l_params=new HashMap<String, Object>();
		
			l_params.put("agendaStatus", Integer.valueOf(AGENDA_UPDATE_STATUS));	
			l_params.put("agendaId", p_agenda.getAgendaId());
			l_params.put("seqNo", Integer.valueOf(p_agenda.getSeqNo()));
			l_params.put("sysTime", getBusinessDateTime());
			jdbcTemplate.update(ApplicationQuery.QUERY_AGENDA_UPDATE, l_params);	
		
	}

	@Override
	public List<Agenda> getAgendaDetails(AgendaServiceRequest p_requeat) {
		Map<String, Object> l_params=new HashMap<String, Object>();
		try {
			l_params.put("agentId", p_requeat.getAgentId());
			l_params.put("deviceId", p_requeat.getDeviceId());
			l_params.put("locationCode", p_requeat.getLocationCode());
			l_params.put("agendaStatus", Integer.valueOf(AGENDA_SELECT_STATUS));
			l_params.put("batchSize",Integer.valueOf(p_requeat.getBatchSize()));
				
			List<Agenda> agenda = jdbcTemplate.query(ApplicationQuery.QUERY_AGENDA_LIST,
						l_params, getRowMapper());
			return agenda;
		} catch (DataAccessException e) {
			LoggerUtil.mbsJobError("DataAccessException while extracting Agenda Details :MFI10001 ", e);
			return null;
		} catch (Exception e) {
			LoggerUtil.mbsJobError("Unhandeld Exception while extracting Agenda Details :MFI10001 ", e);
			return null;
		}
		
	}

	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectAllQuery() {
		// TODO Auto-generated method stub
		return ApplicationQuery.QUERY_AGENDA_SELECT;
	}

	@Override
	protected RowMapper<Agenda> getRowMapper() {
		// TODO Auto-generated method stub
		return new AgendaMapper();
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
	
	private static final class AgendaMapper implements RowMapper<Agenda> {
		public Agenda mapRow(ResultSet rs, int rowNum) throws SQLException {
			Agenda agenda = new Agenda();
			agenda.setAgendaId(rs.getString("AGENDA_ID"));
			agenda.setSeqNo(rs.getInt("SEQ_NO"));
			agenda.setCbdAccRefNo(rs.getString("CBS_AC_REF_NO"));
			agenda.setModuleCode(rs.getString("MODULE_CODE"));
			agenda.setTxnCode(rs.getString("TXN_CODE"));
			agenda.setAgentId(rs.getString("AGENT_ID"));
			agenda.setLocCode(rs.getString("LOCATION_CODE"));
			agenda.setAgendaStatus(rs.getInt("AGENDA_STATUS"));
			agenda.setAgendaUploadTime(rs.getDate("AGN_UPLD_DATETIME"));
			agenda.setBranchCode(rs.getString("BRANCH_CODE"));
			agenda.setCustomerId(rs.getString("CUSTOMER_ID"));
			agenda.setCustomerName(rs.getString("CUSTOMER_NAME"));
			agenda.setAgendaCcyCode(rs.getString("AGN_CCY_CODE"));
			agenda.setAgendaLocCcyCode(rs.getString("AGN_LCY_CODE"));
			agenda.setAgendaCmpName(rs.getString("AGN_CMP_NAME"));
			agenda.setAgendaCmpStartDate(rs.getDate("AGN_CMP_ST_DATE"));
			agenda.setAgendaCmpEndDate(rs.getDate("AGN_CMP_END_DT"));
			agenda.setAgendaMbsDate(rs.getDate("AGN_MBS_DATE"));
			agenda.setAgendaAmount(rs.getDouble("AGN_AGENDA_AMT"));
			agenda.setAgendaAmountCcy(rs.getDouble("AGN_AGENDA_AMT_LCY"));
			agenda.setAgendaSettledAmount(rs.getDouble("AGN_AGENDA_SETTLED_AMT"));
			agenda.setAgendaSettledAmountCcy(rs.getDouble("AGN_AGENDA_SETTLED_AMT_LCY"));
			agenda.setIsFull(rs.getString("FULL_PART_IND"));
			agenda.setLoanDisbType(rs.getString("LN_DISBURSEMENT_TYPE"));
			agenda.setIsLoanFutureSch(rs.getString("LN_IS_FUTURE_SCH"));
			agenda.setIsLoanRedemption(rs.getString("DP_IS_REDEMPTION"));
			agenda.setDeviceId(rs.getString("DEVICE_ID"));
			agenda.setMbsSyncUploadTime(rs.getString("MBS_SYNC_UPLD_TIME"));
			agenda.setMbsTxnId(rs.getString("MBS_TXN_ID"));
			agenda.setCbsUploadJobId(rs.getString("CBS_UPLOAD_JOB_ID"));
			agenda.setIsValid(rs.getString("IS_VALID"));	
			
			//Newly Added on 09-10-14
			
			agenda.setSmsMMobile(rs.getString("SMS_M_MOBILE"));
			agenda.setIsGroupLoan(rs.getString("IS_GROUP_LOAN"));
			agenda.setIsParentLoan(rs.getString("IS_PARENT_LOAN"));
			agenda.setIsParentCust(rs.getString("IS_PARENT_CUSTOMER"));
			agenda.setParentCustId(rs.getString("PARENT_CUSTOMER_ID"));
			agenda.setParentCbsAcRefNo(rs.getString("PARENT_CBS_AC_REF_NO"));
			
			return agenda;
		}
	}


}
