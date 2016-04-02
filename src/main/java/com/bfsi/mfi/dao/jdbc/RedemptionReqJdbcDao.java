package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.RedemptionReqDao;
import com.bfsi.mfi.entity.MbsReqDpRedemptionView;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("redemptionReqDao")
public class RedemptionReqJdbcDao extends MaintenanceJdbcDao<MbsReqDpRedemptionView> implements RedemptionReqDao {

	
	@Override
	protected String getInsertQuery() {
		return null;
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.REDEMPTREQ_SELECT_QUEARY_ALL;
	}

	@Override
	protected RedemptionReqMapper getRowMapper() {
		return new RedemptionReqMapper();
	}
	
	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.REDEMPTREQ_SELECT_QUEARY_ALL_PK;
	}

	
 private static final class RedemptionReqMapper implements
	RowMapper<MbsReqDpRedemptionView> {
   public MbsReqDpRedemptionView mapRow(ResultSet rs, int rowNum)
		throws SQLException {
	   MbsReqDpRedemptionView redemptDepositeReq = new MbsReqDpRedemptionView();
	   
	   redemptDepositeReq.setId(rs.getString("mbs_txn_id"));
	   redemptDepositeReq.setTxnCode(rs.getString("txn_code")); 
	   // EGALITE-353 start
	   //Changes for Asomi Nirmal kanna S
	   //redemptDepositeReq.setTxnDesc(rs.getString("txn_desc"));
	   // EGALITE-353 end
	   redemptDepositeReq.setBranCode(rs.getString("branch_code"));
	   redemptDepositeReq.setCustomerId(rs.getString("customer_id"));
	   redemptDepositeReq.setCustomerFullName(rs.getString("customer_full_name")); 
	   redemptDepositeReq.setAgentId(rs.getString("agent_id"));
	   redemptDepositeReq.setAgentName(rs.getString("agent_name"));
	   redemptDepositeReq.setLocationCode(rs.getString("location_code"));
	   redemptDepositeReq.setLocationDesc(rs.getString("location_desc"));
	   
	   redemptDepositeReq.setRedemptionRequestDate(BaseJdbcDao.getUtilDate(rs.getDate("redemption_request_date")));//simple date
	   
	   redemptDepositeReq.setRedemptionType(rs.getString("redemption_type"));
	   redemptDepositeReq.setTxnNarrative(rs.getString("txn_narrative"));
	   
	   redemptDepositeReq.setTxnInitTime(rs.getTimestamp("txn_init_time")); //date time
	   redemptDepositeReq.setTxnSyncTime(rs.getTimestamp("txn_sync_time")); //date time
	   
	   redemptDepositeReq.setTxnStatusDesc(rs.getString("txn_status_desc"));
	   redemptDepositeReq.setTxnErrCode(rs.getString("TXN_ERR_CODE"));
	   redemptDepositeReq.setTxnErrMessage(rs.getString("TXN_ERR_MESSAGE"));
	   redemptDepositeReq.setCbsAcRefNo(rs.getString("CBS_AC_REF_NO"));
		/*EGA-MN15-000022 start*/
	   redemptDepositeReq.setGeneratedSms(rs.getString("generated_sms"));
	   redemptDepositeReq.setSmsMobileNo(rs.getString("sms_mobile_no"));
	   redemptDepositeReq.setSmsContent(rs.getString("sms_content"));
	   redemptDepositeReq.setGeneratedRevr(rs.getString("generated_revr"));
	   redemptDepositeReq.setFullPartInd(rs.getString("full_part_ind"));
	   redemptDepositeReq.setSyncType(rs.getString("sync_type"));
		/*EGA-MN15-000022 end*/
	   
	   return redemptDepositeReq;
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
