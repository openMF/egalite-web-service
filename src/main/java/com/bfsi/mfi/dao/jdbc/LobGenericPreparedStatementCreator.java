package com.bfsi.mfi.dao.jdbc;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;

public class LobGenericPreparedStatementCreator implements
		PreparedStatementCreator {
	private final LobHandler lobHandler = new DefaultLobHandler() {
		public LobCreator getLobCreator() {
			return new DefaultLobHandler.DefaultLobCreator() {

				@Override
				public void setClobAsCharacterStream(PreparedStatement ps,
						int paramIndex, Reader characterStream,
						int contentLength) throws SQLException {
					ps.setClob(paramIndex, characterStream);
				}

			};
		}
	};
	private final String sql;
	private Object[] params;
	private byte[] data;
	private Reader content;

	public LobGenericPreparedStatementCreator(String sql, byte[] data,
			Object... params) {
		this.sql = sql;
		this.params = params;
		this.data = data;
	}

	public LobGenericPreparedStatementCreator(String sql, Reader content,
			Object... params) {
		this.sql = sql;
		this.params = params;
		this.content = content;
	}

	@Override
	public PreparedStatement createPreparedStatement(Connection con)
			throws SQLException {
		PreparedStatement ps = con.prepareStatement(sql);
		LobCreator lobCreator = this.lobHandler.getLobCreator();
		setValues(ps, lobCreator);

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 2, params[i]);
			}
		}
		return ps;
	}

	protected void setValues(PreparedStatement ps, LobCreator lobCreator)
			throws SQLException, DataAccessException {
		if (content == null) {
			lobCreator.setBlobAsBytes(ps, 1, data);
		} else {
			lobCreator.setClobAsCharacterStream(ps, 1, content, -1);
		}
	}
}
