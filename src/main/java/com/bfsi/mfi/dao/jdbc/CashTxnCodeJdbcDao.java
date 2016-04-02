package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CashTxnCodeDao;
import com.bfsi.mfi.entity.CashTxnCode;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("cashTxnCodeDao")
public class CashTxnCodeJdbcDao extends MaintenanceJdbcDao<CashTxnCode> implements
CashTxnCodeDao {
	private static String CASH_MODULE_CODE="TI";
	@Override
	public List<CashTxnCode> getCashTxnCode() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("moduleCode", CASH_MODULE_CODE);
		return jdbcTemplate.query(ApplicationQuery.CASHSETTLE_QUERY_TXN_CODE, params,
				getRowMapper());
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
	protected RowMapper<CashTxnCode> getRowMapper() {
		// TODO Auto-generated method stub
		return new CashTxnCodeMapper();
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
	
	private static final class CashTxnCodeMapper implements RowMapper<CashTxnCode> {
		public CashTxnCode mapRow(ResultSet rs, int rowNum) throws SQLException {
			CashTxnCode cashTxnCode = new CashTxnCode();
			cashTxnCode.setTxnCode(rs.getString("TXN_CODE"));
			cashTxnCode.setTxnDesc(rs.getString("TXN_DESC"));			
			return cashTxnCode;
		}
	}

}
