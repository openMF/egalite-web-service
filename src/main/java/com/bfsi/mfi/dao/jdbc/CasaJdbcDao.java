package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CasaDao;
import com.bfsi.mfi.entity.CustAcDetailListView;
import com.bfsi.mfi.entity.CustAcDetailView;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("casaDao")
public class CasaJdbcDao extends ReadOnlyMaintenanceJdbcDao<CustAcDetailListView> 
                                        implements CasaDao{

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.CASA_QUERY_SELECT_ALL;
	}

	protected String getSelectByPkQuery() {
		return null;//ApplicationQuery.CASA_QUERY_SELECT_BY_PK;
	}
	
	@Override
	protected RowMapper<CustAcDetailListView> getRowMapper() {
		return new CasaMapper();
	}

	
	public static final class CasaMapper implements RowMapper<CustAcDetailListView> {
		public CustAcDetailListView mapRow(ResultSet rs, int rowNum) throws SQLException {
			CustAcDetailListView casaAc = new CustAcDetailListView();
		
			casaAc.setId(rs.getString("CUST_AC_NO"));
			casaAc.setCustomerId(rs.getString("CUSTOMER_ID"));
			casaAc.setBranchCode(rs.getString("BRANCH_CODE"));
			casaAc.setAccountType(rs.getString("ACCOUNT_TYPE"));
			casaAc.setAcStatNoDr(rs.getString("AC_STAT_NO_DR"));
			casaAc.setAcStatNoCr(rs.getString("AC_STAT_NO_CR"));
			casaAc.setAgentId(rs.getString("AGENT_ID"));
			casaAc.setLocationCode(rs.getString("LOCATION_CODE"));
			casaAc.setCreditOfficerId(rs.getString("CREDIT_OFFICER_ID"));
			// 	EGALITE-353 start
			//Not Required => Changes for Asomi Nirmal kanna S
			//casaAc.setAcyAvailBal(rs.getString("ACY_CURR_BAL"));
			//casaAc.setAcyCurrBal(rs.getString("ACY_AVAIL_BAL"));
			
			// EGALITE-353 end
															 
		  return casaAc;
		}
	}


	@Override
	public CustAcDetailView getCustAc(String id) {
		String sql = ApplicationQuery.CASA_QUERY_SELECT_BY_PK;
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		return jdbcTemplate.queryForObject(sql, params, new ViewCustAcMapper());
	}
	
	
	public static final class ViewCustAcMapper implements RowMapper<CustAcDetailView> {
		public CustAcDetailView mapRow(ResultSet rs, int rowNum) throws SQLException {
			CustAcDetailView custAcDetailView = new CustAcDetailView();

			custAcDetailView.setId(rs.getString("cust_ac_no"));
			custAcDetailView.setCustomerId(rs.getString("customer_id"));
			custAcDetailView.setCustomerFullName(rs.getString("customer_full_name"));
			custAcDetailView.setBranchCode(rs.getString("branch_code"));
			custAcDetailView.setAccountType(rs.getString("account_type"));
			custAcDetailView.setAcDesc(rs.getString("ac_desc"));
			custAcDetailView.setAcCcy(rs.getString("ac_ccy"));
			
			custAcDetailView.setAcyCurrBal(rs.getDouble("acy_curr_bal"));
			custAcDetailView.setAcyAvailBal(rs.getDouble("acy_avail_bal"));
			
			custAcDetailView.setAcStatNoDr(rs.getString("ac_stat_no_dr"));
			custAcDetailView.setAcStatNoCr(rs.getString("ac_stat_no_cr"));
			custAcDetailView.setAcStatBlock(rs.getString("ac_stat_block"));
			custAcDetailView.setAcStatStopPay(rs.getString("ac_stat_stop_pay"));
			custAcDetailView.setAcStatDormant(rs.getString("ac_stat_dormant"));
			custAcDetailView.setAgentId(rs.getString("agent_id"));
			custAcDetailView.setLocationCode(rs.getString("location_code"));
			custAcDetailView.setCreditOfficerId(rs.getString("credit_officer_id"));
			custAcDetailView.setJointAcIndicator(rs.getString("joint_ac_indicator"));
			
			custAcDetailView.setRecordStat(rs.getString("record_stat"));
			custAcDetailView.setCbsUpldJobId(rs.getString("cbs_upld_job_id"));
			
			return custAcDetailView;
		}
	}
	
}
