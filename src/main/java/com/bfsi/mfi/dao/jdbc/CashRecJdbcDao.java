package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.bean.CashRecBean;
import com.bfsi.mfi.dao.CashRecDao;
import com.bfsi.mfi.entity.CashRecSumupView;
import com.bfsi.mfi.entity.CashRecordDetail;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.ApplicationUtil;

@Repository("cashRecDao")
public class CashRecJdbcDao extends MaintenanceJdbcDao<CashRecSumupView> implements
CashRecDao{

	@Override
	public List<CashRecSumupView> getSearch(String agtid, String tdate) {
		
		CashRecBean bean = new CashRecBean();
		bean.setAgent_id(agtid);
		bean.setTxn_date(tdate);
		
		Class objClass= bean.getClass();
		
		String query = ApplicationQuery.CUST_SELECT_CASH_RECORD;
		query = ApplicationUtil.getDynamicQuery(bean, objClass, query); 
		System.out.println("generated query: "+query);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<CashRecSumupView> cashRecds = jdbcTemplate.query(query,
				(Map) null, new CashRecMapper());
		return (cashRecds != null) ? cashRecds : new ArrayList<CashRecSumupView>();
	}

	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectAllQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected RowMapper<CashRecSumupView> getRowMapper() {
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

	
	private static final class CashRecMapper implements RowMapper<CashRecSumupView> {
		public CashRecSumupView mapRow(ResultSet rs, int rowNum) throws SQLException {
			CashRecSumupView cashRecView = new CashRecSumupView();
			cashRecView.setId(rs.getString("key_value"));
			cashRecView.setAgentId(rs.getString("agent_id"));
			cashRecView.setTxnDate(rs.getString("txn_date"));
			cashRecView.setDrSum(rs.getDouble("dr_sum"));
			cashRecView.setCrSum(rs.getDouble("cr_sum"));
			cashRecView.setToBeSettled(rs.getDouble("to_be_settled"));
			
			return cashRecView;
		}
	}


	@Override
	public List<CashRecordDetail> cashRecordDetail(String agentId) {
		Map<String, String> params=new HashMap<String, String>();
		params.put("agentId", agentId);
		List<CashRecordDetail> l_list=jdbcTemplate.query(ApplicationQuery.QUERY_CASH_RECORD_DETAIL, params, new CashRecordDetailMapper());;
		return l_list==null?new ArrayList<CashRecordDetail>():l_list;
	}
	
	private static final class CashRecordDetailMapper implements RowMapper<CashRecordDetail> {
		public CashRecordDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
			CashRecordDetail cashRecView = new CashRecordDetail();
			cashRecView.setTxnId(rs.getString("txn_id"));
			cashRecView.setTxnDate(rs.getTimestamp("txn_datetime"));
			cashRecView.setSyncTime(rs.getTimestamp("sync_time"));
			cashRecView.setTxnDesc(rs.getString("txn_desc"));
			cashRecView.setAgendaId(rs.getString("agn_id"));
			cashRecView.setSeqNo(rs.getInt("seq_no"));
			cashRecView.setCurrency(rs.getString("ccy"));
			cashRecView.setDrCr(rs.getString("dr_cr"));
			cashRecView.setAmount(rs.getDouble("amt"));
			cashRecView.setAuthStatus(rs.getString("auth_stat"));
			cashRecView.setRevStatus(rs.getString("revr_stat"));
			cashRecView.setDeleteStatus(rs.getString("del_stat"));
			cashRecView.setAgentId(rs.getString("key_value"));

			
			return cashRecView;
		}
	}
	
}
