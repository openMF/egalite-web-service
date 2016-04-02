package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.PigmyDepositDao;
import com.bfsi.mfi.entity.PigmyDeposit;
import com.bfsi.mfi.entity.PigmyView;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("pigmyDepositDao")
public class PigmyDepositJdbcDao extends MaintenanceJdbcDao<PigmyDeposit>
		implements PigmyDepositDao {

	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	private static final String SYNC_STATUS_PEN = "P";

	private static final String SYNC_STATUS_NA = "NA";
	
	/**NambiAK*/
	private static final String SYNC_STATUS_UPDATE = "U";
	
	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.PIMYGDEP_SELECT_VIEW_BY_PK;
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.PIMYGDEP_SELECT_VIEW_ALL;
	}

	@Override
	protected RowMapper<PigmyDeposit> getRowMapper() {
		return new PigmyDepositMapper();
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

	private static final class pigmyDepositDetailsMapper implements
			RowMapper<PigmyDeposit> {
		// Please rewrite the following code
		@Override
		public PigmyDeposit mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			PigmyDeposit pigmyDeposit = new PigmyDeposit();
			pigmyDeposit.setId(rs.getString("dep_ac_no"));
			pigmyDeposit.setCustomerID(rs.getString("customer_id"));
			pigmyDeposit.setLocationID(rs.getString("location_id"));
			pigmyDeposit.setBranchCode(rs.getString("branch_code"));
			pigmyDeposit.setDepositOpenedDate(BaseJdbcDao.getUtilDate(rs
					.getDate("dep_open_date")));
			pigmyDeposit.setAgentID(rs.getString("agent_id"));
			pigmyDeposit.setDepositAccCcy(rs.getString("dep_ccy"));
			pigmyDeposit.setDepositFrequency(rs.getString("dep_pay_freq"));
			pigmyDeposit.setInterestRate(rs.getFloat("dep_int_rate"));
			pigmyDeposit.setPerinstallmentAmt(rs.getDouble("dep_inst_amt"));
			pigmyDeposit.setInstallmentAmtDue(rs.getDouble("dep_inst_amt_due"));
			pigmyDeposit.setMaturityAmount(rs.getDouble("dep_maturity_amt"));
			pigmyDeposit.setMaturityDate(BaseJdbcDao.getUtilDate(rs
					.getDate("dep_maturity_date")));
			pigmyDeposit.setTotalInstPaid(rs.getDouble("total_inst_paid"));
			pigmyDeposit.setTotalIntAccured(rs.getDouble("total_int_accured"));
			pigmyDeposit.setLastInstallmentDate(BaseJdbcDao.getUtilDate(rs
					.getDate("dep_last_inst_date")));
			pigmyDeposit.setOverdueStat(rs.getString("dep_overdue_status"));
			pigmyDeposit.setOverdueDate(BaseJdbcDao.getUtilDate(rs
					.getDate("dep_over_due_date")));
			pigmyDeposit.setOverdueAmt(rs.getDouble("dep_over_due_amt"));
			pigmyDeposit.setRedemptionFlag(rs.getString("redemption_flag"));
			pigmyDeposit.setRedemptionPayoutDate(BaseJdbcDao.getUtilDate(rs
					.getDate("redemption_payout_date")));
			pigmyDeposit.setRedemptionAmount(rs.getDouble("redemption_amount"));
			pigmyDeposit.setNextInstDate(BaseJdbcDao.getUtilDate(rs
					.getDate("next_inst_date")));
			pigmyDeposit.setDepTenure(rs.getString("DEP_TENURE"));
			pigmyDeposit.setNumOfInstDue(rs.getString("NO_OF_INST_DUE"));
			pigmyDeposit.setTxnType(rs.getString("TXN_TYPE"));
			return pigmyDeposit;

		}

	}

	private static final class PigmyDepositMapper implements
			RowMapper<PigmyDeposit> {
		public PigmyDeposit mapRow(ResultSet rs, int rowNum)
				throws SQLException {
	// Start of List Deposit Screen
			PigmyDeposit pigmyDeposit = new PigmyDeposit();
			pigmyDeposit.setDepositAccountNumber(rs.getString("dep_ac_no"));
			pigmyDeposit.setId(rs.getString("dep_ac_no"));
			pigmyDeposit.setCustomerID(rs.getString("customer_id"));
			pigmyDeposit.setCustomerFullName(rs.getString("customer_full_name"));
			pigmyDeposit.setAllocationStatus(rs.getString("allocation_status"));
			pigmyDeposit.setBranchCode(rs.getString("branch_code"));
			pigmyDeposit.setDepositOpenedDate(BaseJdbcDao.getUtilDate(rs.getDate("open_date")));
			pigmyDeposit.setRedemptionFlag(rs.getString("redemption_flag"));
			pigmyDeposit.setRedemptionPayoutDate(BaseJdbcDao.getUtilDate(rs.getDate("redemption_payout_date")));
			pigmyDeposit.setRedemptionAmount(rs.getDouble("redemption_amount"));
			pigmyDeposit.setCurrency(rs.getString("Currency"));
			pigmyDeposit.setLocationCode(rs.getString("location_code"));
			pigmyDeposit.setAllocationBy(rs.getString("allocation_by_code"));
			pigmyDeposit.setMaturityDate(BaseJdbcDao.getUtilDate(rs.getDate("maturity_date")));
			pigmyDeposit.setAgentID(rs.getString("agent_id"));
	//End of List Deposit Screen.
			pigmyDeposit.setDepositAccCcy(rs.getString("Currency"));
			//pigmyDeposit.setSchInstallmentAmt(rs.getDouble("sch_installment_amt"));
			
			
			return pigmyDeposit;
		}
	}
	
	// Add RowMapper for loan details and agent_id from loan_enrich.//
		public static final class ViewDepositMapper implements RowMapper<PigmyView> {
			public PigmyView mapRow(ResultSet rs, int rowNum) throws SQLException {
				PigmyView depositView = new PigmyView();
				depositView.setId(rs.getString("dep_ac_no"));
				depositView.setBranchCode(rs.getString("branch_code"));
				depositView.setCustomerID(rs.getString("customer_id"));
				depositView.setCustomerFullName(rs.getString("customer_full_name"));
				depositView.setAgentId(rs.getString("agent_id"));
				depositView.setLocationCode(rs.getString("location_code"));
				depositView.setAllocationByCode(rs.getString("allocation_by_code"));
				depositView.setOpenDate(BaseJdbcDao.getUtilDate(rs.getDate("open_date")));
				depositView.setMaturityDate(BaseJdbcDao.getUtilDate(rs.getDate("maturity_date")));
				depositView.setSchInstallmentAmt(rs.getDouble("sch_installment_amt"));
				depositView.setPayFreqType(rs.getString("pay_freq_type"));
				depositView.setPayFreq(rs.getString("pay_freq"));
				depositView.setTenureType(rs.getString("tenure_type"));
				depositView.setTenure(rs.getString("tenure"));
				depositView.setCurrency(rs.getString("Currency"));
				depositView.setInterestRate(rs.getFloat("int_rate"));
				depositView.setPrincipalMaturityAmount(rs.getDouble("principal_maturity_amount"));
				depositView.setInterestAccuredTillDate(rs.getDouble("interest_accrued_till_date"));
				depositView.setInstallmentPaidTillDate(rs.getDouble("installment_paid_till_date"));
				depositView.setTotalInstallmentAmtDue(rs.getDouble("total_installment_amt_due"));
				depositView.setRedemptionFlag(rs.getString("redemption_flag"));
				depositView.setRedemptionPayoutDate(BaseJdbcDao.getUtilDate(rs.getDate("redemption_payout_date")));
				depositView.setRedemptionAmount(rs.getDouble("redemption_amount"));
				depositView.setCbsUplJobId(rs.getString("cbs_upld_job_id"));
				depositView.setRecordStat(rs.getString("record_stat"));
				depositView.setAllocationStatus(rs.getString("allocation_status"));
				depositView.setCreditOfficerCode(rs.getString("CREDIT_OFFICER_CODE"));
				depositView.setCreditOfficerName(rs.getString("CREDIT_OFFICER_NAME"));
				return depositView;
			}
		}

	@Override
	public List<PigmyDeposit> getPigmyDepositForAllocation() {
		return null;
	}

	@Override
	public List<PigmyDeposit> getPigmyDepositDetails(String agentId,
			String batchSize) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("agentId", agentId);
		params.put("batchSize", Integer.valueOf(batchSize));
		params.put("status", SYNC_STATUS_PEN);
		params.put("status2", SYNC_STATUS_NA);		
		params.put("status3", SYNC_STATUS_UPDATE);
		//System.out.println("DEPO PARAMS");
		/*for(Object o: params.values())
		System.out.println(o.toString());
		*/List<PigmyDeposit> pigmyDeposits = jdbcTemplate.query(
				ApplicationQuery.PIMYGDEP_QUERY_PIGMY_DETAIL, params, new pigmyDepositDetailsMapper());
		return (pigmyDeposits != null) ? pigmyDeposits
				: new ArrayList<PigmyDeposit>();

	}

	@Override
	public void updatePigmyDepositStatus(List<String> depositAccNoList,
			String status) {
		Map<String, String> params = new HashMap<String, String>(
				depositAccNoList.size());
		params.put("status", status);
		StringBuilder sqlQuery = new StringBuilder(
				"UPDATE IFTB_DEPOSIT_DETAILS SET SYNC_STATUS= :status WHERE DEP_AC_NO IN (");
		String delimiter = "";
		for (int i = 0; i < depositAccNoList.size(); i++) {
			params.put("param" + i, depositAccNoList.get(i));
			sqlQuery.append(delimiter + ":param" + i);
			if (i == 0) {
				delimiter = delimiter + ",";
			}
		}
		String query = sqlQuery.toString() + ")";
		System.out.println("Query  " + query);
		jdbcTemplate.update(query, params);

	}
	//view
		public PigmyView getDepositView(String id) {
			String sql = ApplicationQuery.DEPOSIT_QUERY_SELECT_BY_PK;
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", id);
			return jdbcTemplate.queryForObject(sql, params, new ViewDepositMapper());
		}
}
