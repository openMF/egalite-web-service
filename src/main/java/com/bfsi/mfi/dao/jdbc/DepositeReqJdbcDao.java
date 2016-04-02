package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.DepositeReqDao;
import com.bfsi.mfi.entity.MbsReqReceiverView;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("depositeReqDao")
public class DepositeReqJdbcDao extends MaintenanceJdbcDao<MbsReqReceiverView> implements DepositeReqDao{
	
	@Override
	protected String getInsertQuery() {
		return null;
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.DEPR_SELECT_QUEARY_ALL;
	}

	
	@Override
	protected String getUpdateQuery() {
		return null;
	}

	@Override
	protected String getDeleteQuery() {
		return null;
	}
	
	@Override
	protected DepositeReqMapper getRowMapper() {
		return new DepositeReqMapper();
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.DEPR_SELECT_QUEARY_ALL_PK;
	}
	
	private static final class DepositeReqMapper implements
	RowMapper<MbsReqReceiverView> {

public MbsReqReceiverView mapRow(ResultSet rs, int rowNum)
		throws SQLException {
	MbsReqReceiverView depositeReq = new MbsReqReceiverView();
	
	/*a.mbs_txn_id,b.txn_desc,a.txn_code,a.cbs_ac_ref_no,a.branch_code,a.customer_id,
	a.agent_id,a.device_id,a.location_code,
	a.txn_init_time,d.txn_status_desc*/
	
	depositeReq.setId(rs.getString("mbs_txn_id"));
	depositeReq.setTxnDesc(rs.getString("txn_desc"));
	depositeReq.setTxnCode(rs.getString("txn_code"));
	depositeReq.setCbsAcRefNo(rs.getString("cbs_ac_ref_no"));
	depositeReq.setBranchCode(rs.getString("branch_code"));
	depositeReq.setCustomerId(rs.getString("customer_id"));
	depositeReq.setAgentId(rs.getString("agent_id"));
	depositeReq.setDeviceId(rs.getString("device_id"));
	depositeReq.setLocationCode(rs.getString("location_code"));
	depositeReq.setTxnInitTime(rs.getTimestamp("txn_init_time"));
	depositeReq.setTxnStatusDesc(rs.getString("txn_status_desc"));
	
	return depositeReq;
}
}
}
