package com.bfsi.mfi.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.DepositRequestDao;
import com.bfsi.mfi.entity.DepositRequest;
import com.bfsi.mfi.entity.DepositTransaction;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

@Repository("depositRequestDao")
public class DepositRequestJdbcDao extends MaintenanceJdbcDao<DepositRequest>
		implements DepositRequestDao {
	
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	private static final String RECEIVED_STATUS = "RECEIVED";
	private static final String PENDING_STATUS = "PENDING";
	
	@Override
	public void insertAccOpenReq(List<DepositRequest> depositAccOpenReqList) {
		SqlParameterSource[] txnParams = SqlParameterSourceUtils
				.createBatch(depositAccOpenReqList.toArray());
		jdbcTemplate.batchUpdate(ApplicationQuery.DEPREQ_QUERY_INSERT_ACCREQ, txnParams);
	}

	@Override
	public void insertPreMatureReq(List<DepositRequest> preMatureDepReqList) {
		SqlParameterSource[] txnParams = SqlParameterSourceUtils
				.createBatch(preMatureDepReqList.toArray());
		jdbcTemplate.batchUpdate(ApplicationQuery.DEPREQ_QUERY_INSERT_DEPPREPAY, txnParams);

	}

	@Override
	public void insertPreWithdrwalReq(List<DepositRequest> preWithdrawlReqList) {
		SqlParameterSource[] txnParams = SqlParameterSourceUtils
				.createBatch(preWithdrawlReqList.toArray());
		jdbcTemplate.batchUpdate(ApplicationQuery.DEPREQ_QUERY_INSERT_DEPREDEM, txnParams);
	}

	@Override
	public void insertRequestList(List<DepositRequest> depositReqList) {
		SqlParameterSource[] txnParams = SqlParameterSourceUtils
				.createBatch(depositReqList.toArray());
		jdbcTemplate.batchUpdate(ApplicationQuery.DEPREQ_QUERY_INSERT_DEPREQ, txnParams);
	}

	@Override
	public void updateDepositStatus(List<String> reqIdList,
			String receivedStatus, String pendingStatus) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("penStatus", pendingStatus);
		params.put("recStatus", receivedStatus);
		StringBuilder sqlQuery = new StringBuilder(
				ApplicationQuery.DEPREQ_QUERY_UPDATE_STATUS); //"UPDATE IFTB_TRANSACTION_STATUS SET STATUS= :recStatus WHERE TXN_ID IN ("
		String delimiter = "";
		for (int i = 0; i < reqIdList.size(); i++) {
			params.put("param" + i, reqIdList.get(i));
			sqlQuery.append(delimiter + ":param" + i);
			if (i == 0) {
				delimiter = delimiter + ",";
			}
		}
		String query = sqlQuery.toString() + ApplicationQuery.DEPREQ_AND ; //" ) AND STATUS=:penStatus "
		//System.out.println("Query  " + query);
		jdbcTemplate.update(query, params);
	}

	@Override
	public String isReqIdAvailable(String reqId) {
		String sessionId = null;
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", reqId);
		params.put("status", RECEIVED_STATUS);
		try {
			sessionId = jdbcTemplate.queryForObject(ApplicationQuery.DEPREQ_QUERY_SELECT_SESSIONID,
					params, String.class);
		} catch (DataAccessException e) {
			LoggerUtil.ibsJobError("DataAccessException : MFI10001", e);
			return null;
		}
		return sessionId;
	}

	@Override
	public void deleteReqWithPen(List<String> pendingreqId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("status", PENDING_STATUS);
		StringBuilder sqlQuery = new StringBuilder(
				ApplicationQuery.DEPREQ_QUERY_DELETE); //"DELETE FROM IFTB_TRANSACTION_STATUS WHERE STATUS=:status AND TXN_ID  IN ("
		String delimiter = "";
		for (int i = 0; i < pendingreqId.size(); i++) {
			params.put("param" + i, pendingreqId.get(i));
			sqlQuery.append(delimiter + ":param" + i);
			if (i == 0) {
				delimiter = delimiter + ",";
			}
		}
		String query = sqlQuery.toString() + ")";
		jdbcTemplate.update(query, params);
	}

	@Override
	public void inserReqIDwithPen(String reqId, String syncSessionId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", reqId);
		params.put("syncsessionid", syncSessionId);
		jdbcTemplate.update(ApplicationQuery.DEPREQ_QUERY_INSERT_IDSTATUS, params);
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
	protected RowMapper<DepositRequest> getRowMapper() {
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

	@Override
	public void insertDepTxnList(List<DepositTransaction> depTxnIdList) {
		SqlParameterSource[] txnParams = SqlParameterSourceUtils
				.createBatch(depTxnIdList.toArray());
		jdbcTemplate.batchUpdate(ApplicationQuery.DEPREQ_QUERY_INSERT_DEPTXN, txnParams);
	}

	@Override
	public void insertDepCollTxn(List<DepositTransaction> depCollecList) {
		SqlParameterSource[] txnParams = SqlParameterSourceUtils
				.createBatch(depCollecList.toArray());
		jdbcTemplate.batchUpdate(ApplicationQuery.DEPREQ_QUERY_INSERT_DEPCOLL, txnParams);
	}

	@Override
	public void insertDepMatTxn(List<DepositTransaction> depMatList) {
		SqlParameterSource[] txnParams = SqlParameterSourceUtils
				.createBatch(depMatList.toArray());
		jdbcTemplate.batchUpdate(ApplicationQuery.DEPREQ_QUERY_INSERT_DEPMAT, txnParams);

	}

	@Override
	public void insertDepRedTxn(List<DepositTransaction> depRedemList) {
		SqlParameterSource[] txnParams = SqlParameterSourceUtils
				.createBatch(depRedemList.toArray());
		jdbcTemplate.batchUpdate(ApplicationQuery.DEPREQ_QUERY_INSERT_DEPRED, txnParams);

	}

}
