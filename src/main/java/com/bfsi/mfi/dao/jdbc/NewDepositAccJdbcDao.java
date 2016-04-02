package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.NewDepositAccDao;
import com.bfsi.mfi.entity.MbsReqDpNewAcView;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("newDepositAccDao")
public class NewDepositAccJdbcDao extends MaintenanceJdbcDao<MbsReqDpNewAcView>
		implements NewDepositAccDao {

	@Override
	protected String getInsertQuery() {
		return null;
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.NEWDEP_SELECT_QUEARY_ALL;
	}

	@Override
	protected NewDepositAccMapper getRowMapper() {
		return new NewDepositAccMapper();
	}

	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.NEWDEP_SELECT_QUEARY_ALL_PK;
	}

	private static final class NewDepositAccMapper implements
			RowMapper<MbsReqDpNewAcView> {
		public MbsReqDpNewAcView mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			MbsReqDpNewAcView newdepositeReq = new MbsReqDpNewAcView();

			/*
			 * a.mbs_txn_id, //get from super class id.........*
			 * a.txn_code,a.branch_code
			 * ,a.customer_id,b.customer_full_name,a.agent_id, (c.first_name
			 * ||' '||c.last_name) as agent_name,
			 * a.location_code,l.location_desc, a.req_red_req_dt
			 * deposit_request_date,............... a.txn_amt
			 * agreed_installment_amount,a.req_dep_no_inst
			 * proposed_installment_number,** a.req_maturity_date
			 * expected_maturity_date,........... a.req_int_rate
			 * proposed_interest_rate, a.req_dp_tenure_type
			 * proposed_tenure_type,a.req_dp_tenure proposed_tenure,
			 * a.req_dp_frequency_type
			 * proposed_frequency_type,a.req_dp_frequency proposed_frequency,
			 * a.txn_narrative,a.txn_init_time,a.txn_sync_time,d.txn_status_desc
			 */

			newdepositeReq.setId(rs.getString("mbs_txn_id"));
			newdepositeReq.setTxnCode(rs.getString("txn_code"));
			// EGALITE-353 start
			// Commented changes for Asomi Nirmal kanna S
			// newdepositeReq.setTxnDesc(rs.getString("txn_desc"));
			// EGALITE-353 end
			newdepositeReq.setBranchCode(rs.getString("branch_code"));
			newdepositeReq.setCustomerId(rs.getString("customer_id"));
			newdepositeReq.setCustomerFullName(rs
					.getString("customer_full_name"));
			newdepositeReq.setAgentId(rs.getString("agent_id"));
			newdepositeReq.setAgentName(rs.getString("agent_name"));
			newdepositeReq.setLocationCode(rs.getString("location_code"));
			newdepositeReq.setLocationDesc(rs.getString("location_desc"));

			newdepositeReq.setDepositRequestDate(BaseJdbcDao.getUtilDate(rs
					.getDate("deposit_request_date"))); // simple date format
			newdepositeReq.setAgreedInstallmentAmount(rs
					.getDouble("agreed_installment_amount"));
			newdepositeReq.setProposedInstallmentNumber(rs
					.getInt("proposed_installment_number"));

			newdepositeReq.setExpectedMaturityDate(BaseJdbcDao.getUtilDate(rs
					.getDate("expected_maturity_date"))); // simple date format

			newdepositeReq.setProposedInterestRate(rs
					.getDouble("proposed_interest_rate"));
			newdepositeReq.setProposedTenureType(rs
					.getString("proposed_tenure_type"));

			newdepositeReq.setProposedTenure(rs.getInt("proposed_tenure"));

			newdepositeReq.setProposedFrequencyType(rs
					.getString("proposed_frequency_type"));
			newdepositeReq
					.setProposedFrequency(rs.getInt("proposed_frequency"));

			newdepositeReq.setTxnNarrative(rs.getString("txn_narrative"));

			newdepositeReq.setTxnInitTime(rs.getTimestamp("txn_init_time"));
			newdepositeReq.setTxnSyncTime(rs.getTimestamp("txn_sync_time"));

			newdepositeReq.setTxnStatusDesc(rs.getString("txn_status_desc"));
			newdepositeReq.setTxnErrCode(rs.getString("TXN_ERR_CODE"));
			newdepositeReq.setTxnErrMessage(rs.getString("TXN_ERR_MESSAGE"));
			/*EGA-MN15-000022 start*/
			newdepositeReq.setGeneratedSms(rs.getString("generated_sms"));
			newdepositeReq.setSmsMobileNo(rs.getString("sms_mobile_no"));
			newdepositeReq.setSmsContent(rs.getString("sms_content"));
			newdepositeReq.setGeneratedRevr(rs.getString("generated_revr"));
			newdepositeReq.setFullPartInd(rs.getString("full_part_ind"));
			newdepositeReq.setSyncType(rs.getString("sync_type"));
			/*EGA-MN15-000022 end*/

			return newdepositeReq;
		}
	}

	@Override
	protected String getUpdateQuery() {
		return null;
	}

	@Override
	protected String getDeleteQuery() {
		return null;
	}

}
