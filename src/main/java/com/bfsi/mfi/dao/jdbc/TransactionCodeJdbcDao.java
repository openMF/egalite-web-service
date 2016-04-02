package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.TransactionCodeDao;
import com.bfsi.mfi.entity.MfiMbsTxnReceiverV;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.query.ApplicationQuery;
@Repository("transactionCodeDao")
public class TransactionCodeJdbcDao extends MaintenanceJdbcDao<MfiMbsTxnReceiverV> implements
TransactionCodeDao {

	@Override
	protected String getInsertQuery() {
	
		return null;
	}

	@Override
	protected String getSelectAllQuery() {
		
		return ApplicationQuery.TXNCODE_QUERY_SELECT_ALL;
	}

	@Override
	protected RowMapper<MfiMbsTxnReceiverV> getRowMapper() {
		// TODO Auto-generated method stub
		return new TxnCodeMapper();
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
	
	private static final class TxnCodeMapper implements RowMapper<MfiMbsTxnReceiverV> {

		public MfiMbsTxnReceiverV mapRow(ResultSet rs, int rowNum) throws SQLException {
			MfiMbsTxnReceiverV currency = new MfiMbsTxnReceiverV();
			currency.setTxnCode(rs.getString("TXN_CODE"));
			currency.setTxnDesc(rs.getString("TXN_DESC"));
			return currency;
		}
	}

	@Override
	public List<MfiMbsTxnReceiverV> getTransactionTypes()
			throws ServiceException {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.TXNCODE_QUERY_SELECT_TXNS,params, getRowMapper());
	}

}
