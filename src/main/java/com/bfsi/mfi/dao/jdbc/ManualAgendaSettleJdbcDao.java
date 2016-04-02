package com.bfsi.mfi.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.AuditTrailDao;
import com.bfsi.mfi.dao.ManualAgendaSettleDao;
import com.bfsi.mfi.entity.AuditTrail;
import com.bfsi.mfi.entity.ManualAgendaSettle;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.query.InterfaceQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("manualAgendaSettleDao")
public class ManualAgendaSettleJdbcDao extends MaintenanceJdbcDao<ManualAgendaSettle> implements
                                                          ManualAgendaSettleDao {
   
	@Autowired
	private AuditTrailDao<ManualAgendaSettle> auditTrailDao;
	
	private static String version = null;
	private static int version_no = 0;
	private static String success = "success";
	
	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.MAS_QUERY_INSERT_TO_MAINTENCE;
	}
	
	@Override
	public ManualAgendaSettle create(ManualAgendaSettle entity) {
		AuditTrail<ManualAgendaSettle> auditTrail = new AuditTrail<ManualAgendaSettle>(entity);
		auditTrail.setVersion(1);
	    auditTrail.setKeyId(entity.getRecId());
		auditTrailDao.auditCreate(auditTrail);
		String sql = ApplicationQuery.MAS_QUERY_INSERT_TO_MAINTENCE;
		LoggerUtil.ibsJobDebug("Query create ->"+sql);
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(entity);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", entity.getRecId());
		params.put("agendaId", entity.getId());
		params.put("seqNo", entity.getSeqNo());//int
		params.put("cbsAcRefNo", entity.getCbsAcRefNo());
		params.put("customerId", entity.getCustomerId());
		params.put("agentId", entity.getAgentId());
		params.put("deviceId", entity.getDeviceId());
		params.put("locationCode", entity.getLocationCode());
		params.put("agnCmpName", entity.getAgnCmpName());
		params.put("agnCmpStDate", entity.getAgnCmpStDate());
		params.put("agnCmpEndDate", entity.getAgnCmpEndDate());
		params.put("agnCcyCode", entity.getAgnCcyCode());
		params.put("agnAgendaAmt", entity.getAgnAgendaAmt());
		params.put("agnAgendaSettledAmt", entity.getAgnAgendaSettledAmt());
		params.put("fullPartInd", entity.getFullPartInd());
		params.put("settleRemarks", entity.getSettleRemarks());
		params.put("initByUserId", entity.getInitByUserId());
		params.put("initDateTime", entity.getInitDateTime());
		params.put("txnCode", entity.getTxnCode());
		//params.put("id", entity.getRecId());
	    //params.put("id", entity.getRecId());
		jdbcTemplate.execute(sql, params,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});
		return entity;
	}
	
	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.MAS_QUERY_SELECT_ALL_FROM_MASTER;
	}
	
	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.MAS_QUERY_SELECT_BY_PK_FROM_MASTER;
	}
	
	@Override
	protected RowMapper<ManualAgendaSettle> getRowMapper() {
		return new ManualAgendaSettleRowMapper();
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
	
	private static final class ManualAgendaSettleRowMapper implements RowMapper<ManualAgendaSettle> {
		public ManualAgendaSettle mapRow(ResultSet rs, int rowNum) throws SQLException {
			ManualAgendaSettle manualAgendaSettle = new ManualAgendaSettle();
			
			//manualAgendaSettle.setId(rs.getString("REC_ID"));//super id not come
			manualAgendaSettle.setAgendaId(rs.getString("AGENDA_ID"));
			manualAgendaSettle.setSeqNo(rs.getInt("SEQ_NO"));
			manualAgendaSettle.setCbsAcRefNo(rs.getString("CBS_AC_REF_NO"));
			manualAgendaSettle.setCustomerId(rs.getString("customer_id"));
			manualAgendaSettle.setAgentId(rs.getString("agent_id"));
			manualAgendaSettle.setDeviceId(rs.getString("DEVICE_ID"));
			manualAgendaSettle.setLocationCode(rs.getString("LOCATION_CODE"));
			manualAgendaSettle.setAgnCmpName(rs.getString("AGN_CMP_NAME"));
			manualAgendaSettle.setAgnCmpStDate(rs.getDate("AGN_CMP_ST_DATE"));
			manualAgendaSettle.setAgnCmpEndDate(rs.getDate("AGN_CMP_END_DT"));
			manualAgendaSettle.setAgnCcyCode(rs.getString("AGN_CCY_CODE"));
			manualAgendaSettle.setAgnAgendaAmt(rs.getDouble("AGN_AGENDA_AMT"));
			manualAgendaSettle.setTxnCode(rs.getString("TXN_CODE"));
			//manualAgendaSettle.setProcessStat(rs.getString("PROCESS_STAT"));
			return manualAgendaSettle;
		}
	}
	
	@Override
	public String getAutoAgedaId() {
		String autoId = getAutoGenFunCreateId(17); //17 use for reset agenda also....
		return autoId;
	}
	
	/*EGA-MN15-000008 For Business Date Start*/
	@Override
	public Date getBusinessDateForManualAgendaSettle() {
		Map<String, Object> l_procRes = null;
		ProcHandler procHandler = new ProcHandler(InterfaceQuery.GET_APP_DATE_TODAYTIME);//
		procHandler.registerOutputParam("result", Types.TIMESTAMP);
		l_procRes = procHandler.execute(true);
		Date l_busDate = (Date) l_procRes.get("result");
		LoggerUtil.ibsJobDebug("IBS Business Date Proc:: Date:: " + l_busDate);
		System.out.println("BUSINESS DATE="+l_busDate);
		return l_busDate;
	}
	/*EGA-MN15-000008 For Business Date End*/
	
}