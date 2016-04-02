package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CustomerAccountDao;
import com.bfsi.mfi.entity.CustomerAccountDetails;
import com.bfsi.mfi.entity.CustomerAccountServiceRequest;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("customerAccountDao")
public class CustomerAccountJdbcDao extends BaseJdbcDao implements CustomerAccountDao {

	@Override
	public List<CustomerAccountDetails> getCustomerAccount(
			CustomerAccountServiceRequest p_request) {
		// TODO Auto-generated method stub
		LoggerUtil.ibsJobDebug("Getting Customer Account for agent : "+p_request.getAgentId());
		Map<String, Object> l_params = new HashMap<String, Object>();
		l_params.put("agentId", p_request.getAgentId());		
		l_params.put("batchSize", Integer.valueOf(p_request.getBatchSize()));
		l_params.put("locCode", p_request.getLocCode());
		StringBuilder l_queryBuilder=new StringBuilder(ApplicationQuery.CUS_MBS_SYNC_CUS_ACC);
		//LoggerUtil.ibsJobDebug("Query for cust account params:~ "+p_request.getAgentId()+"~"+p_request.getBatchSize()+"~"+p_request.getLocCode());
		String l_delimiter="";
		if(!p_request.getRcvCustAcc().isEmpty()){
			l_queryBuilder.append(" AND CUST_AC_NO NOT IN(");
		}
		for(int l_i=0;l_i<p_request.getRcvCustAcc().size();l_i++){
			l_params.put("param"+l_i, p_request.getRcvCustAcc().get(l_i));
			l_queryBuilder.append(l_delimiter + ":param" + l_i);
			l_delimiter=",";
		}
		if(!p_request.getRcvCustAcc().isEmpty()){
			l_queryBuilder.append(')');
		}		
		l_queryBuilder.append(ApplicationQuery.QUERY_BATCH_STRING);
		//LoggerUtil.ibsJobDebug("Query for cust accounts: "+l_queryBuilder.toString());
		List<CustomerAccountDetails> l_CustAccList=jdbcTemplate.query(l_queryBuilder.toString(), l_params, new CustomerAcountMapper());
		return l_CustAccList == null?new ArrayList<CustomerAccountDetails>():l_CustAccList;		
	}
	
	private static final class CustomerAcountMapper implements RowMapper<CustomerAccountDetails> {

		public CustomerAccountDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			CustomerAccountDetails l_custAcc = new CustomerAccountDetails();	
			
			l_custAcc.setCustomerId(rs.getString("CUSTOMER_ID"));
			l_custAcc.setCustAcNo(rs.getString("CUST_AC_NO"));
			l_custAcc.setBranchCode(rs.getString("BRANCH_CODE"));
			l_custAcc.setAccountType(rs.getString("ACCOUNT_TYPE"));
			l_custAcc.setAcDesc(rs.getString("AC_DESC"));
			l_custAcc.setAcCcy(rs.getString("AC_CCY"));
			l_custAcc.setAcyCurrBal(rs.getDouble("ACY_CURR_BAL"));
			l_custAcc.setAcyAvailBal(rs.getDouble("ACY_AVAIL_BAL"));
			l_custAcc.setAcStatNoCr(rs.getString("AC_STAT_NO_CR"));
			l_custAcc.setAcStatNoDr(rs.getString("AC_STAT_NO_DR"));
			l_custAcc.setAcStatDorMant(rs.getString("AC_STAT_DORMANT"));
			l_custAcc.setAcStatBlock(rs.getString("AC_STAT_BLOCK"));
			l_custAcc.setAcStatStopPay(rs.getString("AC_STAT_STOP_PAY"));
			l_custAcc.setCreditOficerId(rs.getString("CREDIT_OFFICER_ID"));
			l_custAcc.setJointAcIndiCator(rs.getString("JOINT_AC_INDICATOR"));
			l_custAcc.setLocCode(rs.getString("LOCATION_CODE"));
			l_custAcc.setAgentId(rs.getString("AGENT_ID"));
			l_custAcc.setCustFullName(rs.getString("CUSTOMER_FULL_NAME"));
			//l_custAcc.setCustFullName("BFSI");
			
					
			
			return l_custAcc;
		}
	} 

}
