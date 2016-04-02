package com.bfsi.mfi.dao.jdbc;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.query.InterfaceQuery;
import com.bfsi.mfi.util.LoggerUtil;

public abstract class BaseJdbcDao {
	protected NamedParameterJdbcTemplate jdbcTemplate;
	protected LobHandler lobHandler = null;
	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public static Date getUtilDate(java.sql.Date sqlDate) {
		return (sqlDate != null) ? new Date(sqlDate.getTime()) : null;
	}

	public byte[] getBinaryData(ResultSet rs, String blobColumnName) throws SQLException {
		if (lobHandler == null) {
			lobHandler = new DefaultLobHandler();
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BufferedInputStream reader = new BufferedInputStream(lobHandler.getBlobAsBinaryStream(rs, blobColumnName));
		if (reader != null) {
			byte[] bytes = new byte[1024];
			int length = -1;
			do {
				try {
					length = reader.read(bytes);
					if (length != -1) {
						baos.write(bytes, 0, length);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (length != -1);
		}
		return baos.toByteArray();
	}

	protected class ProcHandler extends StoredProcedure {
		private Map<String, Object> inParams = null;

		protected ProcHandler(String p_procName) {
			super(dataSource, p_procName);
			inParams = new HashMap<String, Object>();
			LoggerUtil.ibsJobDebug("Initializing stored proc: Proc Name-> " + p_procName);

		}

		protected void registerInputParam(String p_idParam, Object p_value, int p_sqlType) {
			declareParameter(new SqlParameter(p_idParam, p_sqlType));
			inParams.put(p_idParam, p_value);
		}

		protected void registerOutputParam(String p_idParam, int p_sqlType) {
			declareParameter(new SqlOutParameter(p_idParam, p_sqlType));
		}

		protected Map<String, Object> execute(boolean isFunction) {
			setFunction(isFunction);
			compile();
			return super.execute(inParams);
		}
	}

	protected String getAutoGenFunCreateId(int funId) {

		Map<String, Object> l_procRes = null;
		ProcHandler procHandler = new ProcHandler(ApplicationQuery.FN_ID_GENERATOR);

		procHandler.registerOutputParam("result", Types.VARCHAR);
		procHandler.registerInputParam("p_input_code", funId, Types.NUMERIC);
		procHandler.registerInputParam("p_brn_code", null, Types.VARCHAR);
		procHandler.registerInputParam("p_txn_code", null, Types.VARCHAR);

		l_procRes = procHandler.execute(true);
		// System.out.println("proc result:: "+l_procRes.get("result"));

		String response = (String) l_procRes.get("result");
		return response;
	}

	protected Date getBusinessDateTime() {

		Map<String, Object> l_procRes = null;
		ProcHandler procHandler = new ProcHandler(ApplicationQuery.FN_APP_DATETIME);

		procHandler.registerOutputParam("result", Types.TIMESTAMP);

		l_procRes = procHandler.execute(true);
		Date l_busDate = (Date) l_procRes.get("result");
		LoggerUtil.ibsJobDebug("IBS Business Date Proc:: Date:: " + l_busDate);
		return l_busDate;
	}

	protected Date getBusinessDate() {

		Map<String, Object> l_procRes = null;
		ProcHandler procHandler = new ProcHandler(InterfaceQuery.GET_APP_DATE_TODAY);

		procHandler.registerOutputParam("result", Types.DATE);

		l_procRes = procHandler.execute(true);
		Date l_busDate = (Date) l_procRes.get("result");
		LoggerUtil.ibsJobDebug("IBS Business Date Proc:: Date:: " + l_busDate);
		return l_busDate;
	}

	protected Date getAppDateTime() {

		return jdbcTemplate.queryForObject("SELECT SYSDATE FROM DUAL", new HashMap<String, String>(), Date.class);
	}

}
