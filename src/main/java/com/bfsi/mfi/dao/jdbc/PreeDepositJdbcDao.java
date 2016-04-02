package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.PreeDepositDao;
import com.bfsi.mfi.entity.DepositRequestExt;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("preeDepositDao")
public class PreeDepositJdbcDao extends MaintenanceJdbcDao<DepositRequestExt> implements PreeDepositDao{


	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectAllQuery() {
		// TODO Auto-generated method stub
		return ApplicationQuery.PREDEP_SELECT_QUEARY_ALL;
	}

	@Override
	protected PreeDepositMapper getRowMapper() {
		return new PreeDepositMapper();
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.PREDEP_SELECT_QUEARY_ALL_PK;
	}

	
	private static final class PreeDepositMapper implements
	RowMapper<DepositRequestExt> {

public DepositRequestExt mapRow(ResultSet rs, int rowNum)
		throws SQLException {
	DepositRequestExt depositeReq = new DepositRequestExt();

	/*
	 a.REQ_ID,a.REQ_TYPE,a.REQ_STATUS,a.AUTH_STATUS,a.REQ_AC_NO,a.CUSTOMER_ID,a.CUSTOMER_NAME,
a.AGENT_NAME,a.REQ_CCY,b.DEP_PRE_PAY_NST_AMT,b.REC_NERRATIVE,a.REQ_TIMESTAMP,a.SYNC_TIME,a.TXN_ERROR
	 */
	depositeReq.setRequestId(rs.getString("REQ_ID"));
	depositeReq.setRequestType(rs.getString("REQ_TYPE")); // new
	depositeReq.setRequeststatus(rs.getString("REQ_STATUS"));//new
	depositeReq.setAuthStatus(rs.getString("AUTH_STATUS"));//new
	depositeReq.setDepositAccNum(rs.getString("REQ_AC_NO"));//new
	depositeReq.setCustomerId(rs.getString("CUSTOMER_ID")); //new
	depositeReq.setCustomerName(rs.getString("CUSTOMER_NAME"));//new
	depositeReq.setAgentName(rs.getString("AGENT_NAME"));//new
	depositeReq.setDepositCcy(rs.getString("REQ_CCY"));//new
	depositeReq.setPrepaymentAmt(rs.getDouble("DEP_PRE_PAY_NST_AMT"));
	depositeReq.setNarrative(rs.getString("REQ_NERRATIVE"));
	depositeReq.setRequestDate(rs.getDate("REQ_TIMESTAMP"));//new
	depositeReq.setSyncTime(rs.getDate("SYNC_TIME"));//new
	depositeReq.setReqError(rs.getString("TXN_ERROR"));//new
	depositeReq.setMaturityDate(rs.getDate("MATURITY_DATE"));//maturity_Date
	
	return depositeReq;
}
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
