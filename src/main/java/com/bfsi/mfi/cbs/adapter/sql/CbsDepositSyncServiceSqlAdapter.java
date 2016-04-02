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

import com.bfsi.mfi.cbs.adapter.CbsDepositSyncServiceAdapter;
import com.bfsi.mfi.cbs.model.CbsDeposit;
import com.bfsi.mfi.cbs.model.CbsDepositActivity;
import com.bfsi.mfi.cbs.request.DepositActivitySyncRequest;
import com.bfsi.mfi.cbs.request.DepositActivitySyncResponse;
import com.bfsi.mfi.cbs.request.DepositSyncRequest;
import com.bfsi.mfi.cbs.request.DepositSyncResponse;
import com.bfsi.mfi.query.InterfaceQuery;
/**
 * 
 * @author Shabu S Francis
 *
 */
public class CbsDepositSyncServiceSqlAdapter extends  
		CbsDepositSyncServiceAdapter {
	private ServletContext servletContext =null;
	
	

	@Override
	public DepositSyncResponse extractDeposists(DepositSyncRequest p_request) {
		DepositSyncResponse l_res=new DepositSyncResponse();
		l_res.setDepositList(getDepositsFromCbs(new Date()));
		return l_res;
	}

	@Override
	public DepositActivitySyncResponse extractDeposistActivities(
			DepositActivitySyncRequest p_request) {
		
		DepositActivitySyncResponse l_res=new DepositActivitySyncResponse();
		l_res.setDepositActivityList(getDepositsActivityFromCbs(null,new Date()));
		
		return l_res;
	}
	
	private List<CbsDeposit> getDepositsFromCbs(Date p_syncTime) {
		Map<String, String> l_params = new HashMap<String, String>();
		List<CbsDeposit> l_deposits=null;
		l_deposits=	getJdbcTemplate().query(InterfaceQuery.QUERY_DEPOST, l_params, new DepositMapper());
		return l_deposits==null?new ArrayList<CbsDeposit>():l_deposits;
	}
	private List<CbsDepositActivity> getDepositsActivityFromCbs(
			List<String> p_depoAccNos, Date p_syncTime) {
		Map<String, String> l_params = new HashMap<String, String>();
		List<CbsDepositActivity> l_depositAct=null;
		StringBuilder l_queryBuilder=new StringBuilder(InterfaceQuery.QUERY_DEPOST_ACTIVITY);
		/*String l_delimiter="";
		for(int l_i=0;l_i<p_depoAccNos.size();l_i++){
			l_params.put("param"+l_i, p_depoAccNos.get(l_i));
			l_queryBuilder.append(l_delimiter+":param"+l_i);
			l_delimiter=",";
		}
		l_queryBuilder.append(')');*/
		l_depositAct=getJdbcTemplate().query(l_queryBuilder.toString(), l_params,new DepositActivitytMapper());
		return l_depositAct==null?new ArrayList<CbsDepositActivity>():l_depositAct;
	}
	
	private static final class DepositMapper implements RowMapper<CbsDeposit> {

		@Override
		public CbsDeposit mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsDeposit l_deposit = new CbsDeposit();
			l_deposit.setDepoAccNo(rs.getString("DEP_AC_NO"));			
			l_deposit.setBranchCode(rs.getString("BRANCH_CODE"));
			l_deposit.setCustomerId(rs.getString("CUSTOMER_ID"));
			l_deposit.setCreditOfficerId(rs.getString("CREDIT_OFFICER_ID"));
			l_deposit.setDepoStatus(rs.getString("DEP_STATUS"));
			l_deposit.setCurrency(rs.getString("AC_CCY"));
			l_deposit.setOpeningDate(rs.getDate("OPEN_DATE"));
			l_deposit.setMaturityDate(rs.getDate("MATURITY_DATE"));
			l_deposit.setCbsLcrCode(rs.getString("CBS_LCR_CODE"));
			l_deposit.setCbsLcrType(rs.getString("CBS_LCR_TYPE"));
			l_deposit.setCbsAgentCode(rs.getString("CBS_AGENT_CODE"));
			l_deposit.setSchInstalAmt(rs.getDouble("SCH_INSTALLMENT_AMT"));
			l_deposit.setPayFrqType(rs.getString("PAY_FREQ_TYPE"));
			l_deposit.setPayFreq(rs.getInt("PAY_FREQ"));
			l_deposit.setTenureType(rs.getString("TENURE_TYPE"));
			l_deposit.setTenure(rs.getInt("TENURE"));
			l_deposit.setIntrRate(rs.getDouble("INT_RATE"));
			l_deposit.setPrincMaturityAmt(rs.getDouble("PRINCIPAL_MATURITY_AMOUNT"));
			l_deposit.setIntrAccuredTillDate(rs.getDouble("INTEREST_ACCRUED_TILL_DATE"));
			l_deposit.setInstalPaidTillDate(rs.getDouble("INSTALLMENT_PAID_TILL_DATE"));
			l_deposit.setTotInstAmtDue(rs.getDouble("TOTAL_INSTALLMENT_AMT_DUE"));
			l_deposit.setRedemptionFlag(rs.getString("REDEMPTION_FLAG"));
			l_deposit.setRedemptionPayoutDate(rs.getDate("REDEMPTION_PAYOUT_DATE"));
			l_deposit.setRedemptionAmt(rs.getDouble("REDEMPTION_AMOUNT"));
			l_deposit.setRecStatus(rs.getString("RECORD_STAT"));
				
			//l_deposit.setCbsUploadJobId(rs.getString("CBS_UPLD_JOB_ID"));
			return l_deposit;
		}

	}

	private static final class DepositActivitytMapper implements
			RowMapper<CbsDepositActivity> {

		@Override
		public CbsDepositActivity mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			CbsDepositActivity l_depoActivity = new CbsDepositActivity();
			l_depoActivity.setDepoAccNo(rs.getString("DEP_AC_NO"));
			l_depoActivity.setBranchCode(rs.getString("BRANCH_CODE"));
			l_depoActivity.setTxnType(rs.getString("TXN_TYPE"));
			l_depoActivity.setTxnTypeStartDate(rs.getDate("TXN_TYPE_ST_DATE"));
			l_depoActivity.setTxnTypeEndDate(rs.getDate("TXN_TYPE_END_DATE"));
			l_depoActivity.setTxnTypeDueDate(rs.getDate("TXN_TYPE_DUE_DATE"));
			l_depoActivity.setTxnCcyCode(rs.getString("TXN_CCY_CODE"));
			l_depoActivity.setTxnLocCcyCode(rs.getString("TXN_LCY_CODE"));
			l_depoActivity.setTxnAmtDue(rs.getDouble("TXN_AMT_DUE"));
			l_depoActivity.setTxnAmtDueLocCcy(rs.getDouble("TXN_AMT_DUE_LCY"));
			l_depoActivity.setTxnAmtSettled(rs.getDouble("TXN_AMT_SETTLED"));
			l_depoActivity.setTxnAmtSettledLocCcy(rs.getDouble("TXN_AMT_SETTLED_LCY"));
			//l_depoActivity.setCbsUploadJobId(rs.getString("CBS_UPLD_JOB_ID"));
			return l_depoActivity;
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
