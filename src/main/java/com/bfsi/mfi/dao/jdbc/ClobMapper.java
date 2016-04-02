package com.bfsi.mfi.dao.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

public class ClobMapper implements RowMapper<Object> {
	private Writer writer;
	private LobHandler lobHandler = new DefaultLobHandler();

	public ClobMapper(Writer writer) {
		this.writer = writer;
	}

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		BufferedReader reader = new BufferedReader(
				lobHandler.getClobAsCharacterStream(rs, 1));
		if (reader != null) {
			String src = null;
			do {
				try {
					src = reader.readLine();
					if (src != null) {
						writer.write(src);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (src != null);
		}
		return null;
	}

}
