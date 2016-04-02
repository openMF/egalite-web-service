package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.DepositDetailsDao;
import com.bfsi.mfi.entity.DepositDetail;
import com.bfsi.mfi.entity.DepositDetailsServiceRequest;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;


/**
 * 
 * @author Shabu
 *
 */
@Repository
public class DepositDetailsJdbcDao extends BaseJdbcDao implements DepositDetailsDao {
	
	
	@Override
	public List<DepositDetail> getDeposits(DepositDetailsServiceRequest p_request) {
		LoggerUtil.ibsJobDebug("Getting deposit details for agent : "+p_request.getAgentId());
		Map<String, Object> l_params = new HashMap<String, Object>();
		l_params.put("agentId", p_request.getAgentId());
		l_params.put("batchSize", Integer.valueOf(p_request.getBatchSize()));
		l_params.put("locCode", p_request.getLocCode());
		
		StringBuilder l_queryBuilder=new StringBuilder(ApplicationQuery.QUERY_GET_ALL_FOR_AGENT);
		String l_delimiter="";
		if(!p_request.getRecvdDeposits().isEmpty()){
			l_queryBuilder.append(" AND DEP_AC_NO NOT IN(");
		}
		for(int l_i=0;l_i<p_request.getRecvdDeposits().size();l_i++){
			l_params.put("param"+l_i, p_request.getRecvdDeposits().get(l_i));
			l_queryBuilder.append(l_delimiter + ":param" + l_i);
			l_delimiter=",";
		}
		if(!p_request.getRecvdDeposits().isEmpty()){
			l_queryBuilder.append(')');
		}
		l_queryBuilder.append(ApplicationQuery.QUERY_BATCH_STRING);
		List<DepositDetail> l_loansList=jdbcTemplate.query(l_queryBuilder.toString(), l_params, new DepositDetailMapper());
		return l_loansList == null?new ArrayList<DepositDetail>():l_loansList;
	}
	private static final class DepositDetailMapper implements RowMapper<DepositDetail>{

		@Override
		public DepositDetail mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			DepositDetail l_deposit= new DepositDetail();
			l_deposit.setDepositAccNo(rs.getString("DEP_AC_NO"));
			l_deposit.setBranchCode(rs.getString("BRANCH_CODE"));
			l_deposit.setCustomerId(rs.getString("CUSTOMER_ID"));
			l_deposit.setCustomerName(rs.getString("CUSTOMER_FULL_NAME"));
			l_deposit.setAccCcy(rs.getString("AC_CCY"));
			l_deposit.setOpenDate(rs.getDate("OPEN_DATE"));
			l_deposit.setMaturityDate(rs.getDate("MATURITY_DATE"));
			l_deposit.setSchInstAmt(rs.getDouble("SCH_INSTALLMENT_AMT"));
			l_deposit.setPayFreqType(rs.getString("PAY_FREQ_TYPE"));
			l_deposit.setPayFreq(rs.getInt("PAY_FREQ"));
			l_deposit.setTenureType(rs.getString("TENURE_TYPE"));
			l_deposit.setTenure(rs.getInt("TENURE"));
			l_deposit.setIntRate(rs.getDouble("INT_RATE"));
			l_deposit.setPrincMaturityAmt(rs.getDouble("PRINCIPAL_MATURITY_AMOUNT"));
			l_deposit.setIntAccuredTillDate(rs.getDouble("INTEREST_ACCRUED_TILL_DATE"));
			l_deposit.setInstPaidTillDate(rs.getDouble("INSTALLMENT_PAID_TILL_DATE"));
			l_deposit.setTotAmtDue(rs.getDouble("TOTAL_INSTALLMENT_AMT_DUE"));
			l_deposit.setRedemptionFlag(rs.getString("REDEMPTION_FLAG"));
			l_deposit.setRedemptionPayoutDate(rs.getDate("REDEMPTION_PAYOUT_DATE"));
			l_deposit.setRedemptionAmt(rs.getDouble("REDEMPTION_AMOUNT"));
			//l_deposit.setRecordStatus(rs.getString("RECORD_STAT"));
			//l_deposit.setCbsUploadJobId(rs.getString("CBS_UPLD_JOB_ID"));
			//l_deposit.setSyncStatus(rs.getString("SYNC_STATUS"));
			//l_deposit.setSyncTime(rs.getString("SYNC_TIME"));
			//l_deposit.setIsAllocated(rs.getString("IS_ALLOCATED"));
			
			l_deposit.setLocCode(rs.getString("LOCATION_CODE"));
			l_deposit.setAgentId(rs.getString("AGENT_ID"));
			l_deposit.setCreditOfficeCode(rs.getString("CREDIT_OFFICER_CODE"));
			
			return l_deposit;
		}
		
	}

}
