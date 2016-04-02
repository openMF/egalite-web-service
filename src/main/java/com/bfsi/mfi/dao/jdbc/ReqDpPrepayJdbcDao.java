package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.ReqDpPrepayDao;
import com.bfsi.mfi.entity.MbsReqDpPrepayView;
import com.bfsi.mfi.entity.MbsReqDpRedemptionView;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("reqDpPrepayDao")
public class ReqDpPrepayJdbcDao extends MaintenanceJdbcDao<MbsReqDpPrepayView> 
                   implements ReqDpPrepayDao {

	@Override
	protected String getInsertQuery() {
		return null;
	}

	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.DPPREPAYREQ_SELECT_QUEARY_ALL;
	}

	
	
	@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.DPPREPAYREQ_SELECT_QUEARY_ALL_PK;
	}

	@Override
	protected RedemptionReqMapper getRowMapper() {
		return new RedemptionReqMapper();
	}
	
	
 private static final class RedemptionReqMapper implements RowMapper<MbsReqDpPrepayView> {
   public MbsReqDpPrepayView mapRow(ResultSet rs, int rowNum)
		                                           throws SQLException {
	   
	   MbsReqDpPrepayView reqDpPrepay = new MbsReqDpPrepayView();
	   
	   /*a.mbs_txn_id,a.txn_code,a.cbs_ac_ref_no,a.branch_code,a.customer_id,b.customer_full_name,
		a.agent_id,agent_name,a.location_code,l.location_desc,
	    amount_paid,
		a.txn_narrative,a.txn_init_time,a.txn_sync_time,d.txn_status_desc,
		a.txn_err_code,a.txn_err_message*/
	   
	   reqDpPrepay.setId(rs.getString("mbs_txn_id"));
	   reqDpPrepay.setTxnCode(rs.getString("txn_code")); 
	   // EGALITE-353 start
	   // Changes for Asomi Nirmal kanna S
	   //reqDpPrepay.setTxnDesc(rs.getString("txn_desc"));
	   // EGALITE-353 end
	   reqDpPrepay.setCbsAcRefNo(rs.getString("cbs_ac_ref_no")); 
	   reqDpPrepay.setBranCode(rs.getString("branch_code"));
	   reqDpPrepay.setCustomerId(rs.getString("customer_id"));
	   reqDpPrepay.setCustomerFullName(rs.getString("customer_full_name")); 
	   reqDpPrepay.setAgentId(rs.getString("agent_id"));
	   reqDpPrepay.setAgentName(rs.getString("agent_name"));
	   reqDpPrepay.setLocationCode(rs.getString("location_code"));
	   reqDpPrepay.setLocationDesc(rs.getString("location_desc"));
	   
	   reqDpPrepay.setAmountPaid(rs.getDouble("amount_paid"));
	   
	  //reqDpPrepay.setRedemptionRequestDate(BaseJdbcDao.getUtilDate(rs.getDate("redemption_request_date")));//simple date
	   
	   reqDpPrepay.setTxnNarrative(rs.getString("txn_narrative"));
	   
	   reqDpPrepay.setTxnInitTime(rs.getTimestamp("txn_init_time")); //date time
	   reqDpPrepay.setTxnSyncTime(rs.getTimestamp("txn_sync_time")); //date time
	   
	   reqDpPrepay.setTxnStatusDesc(rs.getString("txn_status_desc"));
	   reqDpPrepay.setTxnErrCode(rs.getString("TXN_ERR_CODE"));
	   reqDpPrepay.setTxnErrMessage(rs.getString("TXN_ERR_MESSAGE"));
	   
		/*EGA-MN15-000022 start*/
	   reqDpPrepay.setGeneratedSms(rs.getString("generated_sms"));
	   reqDpPrepay.setSmsMobileNo(rs.getString("sms_mobile_no"));
	   reqDpPrepay.setSmsContent(rs.getString("sms_content"));
	   reqDpPrepay.setGeneratedRevr(rs.getString("generated_revr"));
	   reqDpPrepay.setFullPartInd(rs.getString("full_part_ind"));
	   reqDpPrepay.setSyncType(rs.getString("sync_type"));
		/*EGA-MN15-000022 end*/
	   
	   return reqDpPrepay;
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
