package com.bfsi.mfi.cbs.adapter.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.jdbc.core.RowMapper;

import com.bfsi.mfi.cbs.adapter.CbsCustomerAccSyncServiceAdapter;
import com.bfsi.mfi.cbs.model.CbsCustomerAccount;
import com.bfsi.mfi.cbs.request.CustomerAccSyncRequest;
import com.bfsi.mfi.cbs.response.CustomerAccSyncResponse;
import com.bfsi.mfi.query.InterfaceQuery;

/**
 * 
 * @author Vishal
 *
 */

public class CbsCustomerAccSyncServiceSqlAdapter extends 
		CbsCustomerAccSyncServiceAdapter {
	private ServletContext servletContext =null;
	
	@Override
	public CustomerAccSyncResponse extractCustomerAccounts(
			CustomerAccSyncRequest p_custAccSyncReq) {
		CustomerAccSyncResponse l_res = new CustomerAccSyncResponse();
		l_res.setCustAccList(getCustAccFromCbs(new Date()));
		return l_res;		
	}
	
	private List<CbsCustomerAccount> getCustAccFromCbs(Date p_syncTime) {
		Map<String, String> l_params = new HashMap<String, String>();
		List<CbsCustomerAccount> l_custAcc = null;
		l_custAcc = getJdbcTemplate().query(InterfaceQuery.CBS_QUERY_SELECT_CUST_ACC, l_params, new CustomerAccountMapper());
		return l_custAcc==null?new ArrayList<CbsCustomerAccount>():l_custAcc;
	}
	
	private static final class CustomerAccountMapper implements RowMapper<CbsCustomerAccount> {

		@Override
		public CbsCustomerAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsCustomerAccount l_custAcc = new CbsCustomerAccount();
			
			l_custAcc.setCustomerId(rs.getString("CUSTOMER_ID"));
			l_custAcc.setCustAcNo(rs.getString("CUST_AC_NO"));
			l_custAcc.setBranchCode(rs.getString("BRANCH_CODE"));
			l_custAcc.setAccountType(rs.getString("ACCOUNT_TYPE"));
			l_custAcc.setAcDesc(rs.getString("AC_DESC"));
			l_custAcc.setAcCcy(rs.getString("AC_CCY"));
			l_custAcc.setAcyCurrBal(rs.getDouble("ACY_CURR_BAL"));
			l_custAcc.setAcyAvailBal(rs.getDouble("ACY_AVAIL_BAL"));
			l_custAcc.setAcStatDorMant(rs.getString("AC_STAT_DORMANT"));
			l_custAcc.setCbsLcrCode(rs.getString("CBS_LCR_CODE"));
			l_custAcc.setCbsLcrType(rs.getString("CBS_LCR_TYPE"));
			l_custAcc.setCbsAgentCode(rs.getString("CBS_AGENT_CODE"));
			l_custAcc.setAcStatNoCr(rs.getString("AC_STAT_NO_CR"));
			l_custAcc.setAcStatNoDr(rs.getString("AC_STAT_NO_DR"));
			l_custAcc.setAcStatBlock(rs.getString("AC_STAT_BLOCK"));
			l_custAcc.setAcStatStopPay(rs.getString("AC_STAT_STOP_PAY"));

		    l_custAcc.setCreditOficer(rs.getString("CREDIT_OFFICER"));

			l_custAcc.setJointAcIndiCator(rs.getString("JOINT_AC_INDICATOR"));
			l_custAcc.setRecordStat(rs.getString("RECORD_STAT"));			
			return l_custAcc;
		}

	}

	@Override
	public ServletContext getServletContext() {
		
		return this.servletContext;
	}
	@Override
	public void setServletContext(ServletContext p_servletContext) {
		servletContext=p_servletContext;
		
	}

}
