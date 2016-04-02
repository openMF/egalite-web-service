package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.ModifyManualAgendaSettleDao;
import com.bfsi.mfi.entity.ModifyManualAgendaSettle;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("modifyManualAgendaSettleDao")
public class ModifyManualAgendaSettleJdbcDao extends MaintenanceJdbcDao<ModifyManualAgendaSettle> implements
         ModifyManualAgendaSettleDao {
   
	
	
	private static String version = null;
	private static int version_no = 0;
	private static String success = "success";
	
	@Override
	protected String getInsertQuery() {
		return null;
	}
	
	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.MMAS_QUERY_SELECT_ALL;
	}
	
	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.MMAS_QUERY_SELECT_BY_PK;
	}
	
	@Override
	protected RowMapper<ModifyManualAgendaSettle> getRowMapper() {
		return new ModifyManualAgendaSettleRowMapper();
	}
	
	@Override
	protected String getUpdateQuery() {
		return ApplicationQuery.MMAS_QUERY_UPDATE;
	}
	
	
	@Override
	protected String getUpdateByAuthQuery() {
		return ApplicationQuery.MMAS_QUERY_UPDATE_BY_AUTH;
	}
	
	
	@Override
	protected String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static final class ModifyManualAgendaSettleRowMapper implements RowMapper<ModifyManualAgendaSettle> {
		public ModifyManualAgendaSettle mapRow(ResultSet rs, int rowNum) throws SQLException {
			ModifyManualAgendaSettle modifyManualAgendaSettle = new ModifyManualAgendaSettle();
			
			modifyManualAgendaSettle.setId(rs.getString("REC_ID"));
			modifyManualAgendaSettle.setAgendaId(rs.getString("AGENDA_ID"));
			modifyManualAgendaSettle.setSeqNo(rs.getInt("SEQ_NO"));
			modifyManualAgendaSettle.setCbsAcRefNo(rs.getString("CBS_AC_REF_NO"));
			modifyManualAgendaSettle.setCustomerId(rs.getString("customer_id"));
			modifyManualAgendaSettle.setAgentId(rs.getString("agent_id"));
			modifyManualAgendaSettle.setDeviceId(rs.getString("DEVICE_ID"));
			modifyManualAgendaSettle.setLocationCode(rs.getString("LOCATION_CODE"));
			modifyManualAgendaSettle.setAgnCmpName(rs.getString("AGN_CMP_NAME"));
			modifyManualAgendaSettle.setAgnCmpStDate(rs.getDate("AGN_CMP_ST_DATE"));
			modifyManualAgendaSettle.setAgnCmpEndDate(rs.getDate("AGN_CMP_END_DT"));
			modifyManualAgendaSettle.setAgnCcyCode(rs.getString("AGN_CCY_CODE"));
			modifyManualAgendaSettle.setAgnAgendaAmt(rs.getDouble("AGN_AGENDA_AMT"));
			modifyManualAgendaSettle.setTxnCode(rs.getString("TXN_CODE"));
			modifyManualAgendaSettle.setAgnAgendaSettledAmt(rs.getDouble("AGN_AGENDA_SETTLED_AMT"));
			modifyManualAgendaSettle.setFullPartInd(rs.getString("FULL_PART_IND"));
			modifyManualAgendaSettle.setSettleRemarks(rs.getString("SETTLE_REMARKS"));
			modifyManualAgendaSettle.setIsActive(rs.getString("IS_ACTIVE"));
			modifyManualAgendaSettle.setAuthStatus(rs.getString("AUTH_STAT"));
			modifyManualAgendaSettle.setInitByUserId(rs.getString("INIT_BY_USER_ID"));
			modifyManualAgendaSettle.setVerifyByUserId(rs.getString("VERIFY_BY_USER_ID"));
			modifyManualAgendaSettle.setInitDateTime(rs.getTimestamp("INIT_DATETIME"));
			modifyManualAgendaSettle.setAuthDateTime(rs.getTimestamp("AUTH_DATETIME"));
			modifyManualAgendaSettle.setProcessStat(rs.getString("PROCESS_STAT"));
			modifyManualAgendaSettle.setErrCode(rs.getString("ERR_CODE"));
			modifyManualAgendaSettle.setErrDesc(rs.getString("ERR_DESC"));
		
			
			return modifyManualAgendaSettle;
		}
	}
	
	
	
	
}
