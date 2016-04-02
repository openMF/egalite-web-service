package com.bfsi.mfi.dao.jdbc;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

public class BlobMapper implements RowMapper<Object> {
	private OutputStream writer;
	private LobHandler lobHandler = new DefaultLobHandler();

	public BlobMapper(OutputStream writer) {
		this.writer = writer;
	}

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		BufferedInputStream reader = new BufferedInputStream(
				lobHandler.getBlobAsBinaryStream(rs, 1));
		if (reader != null) {
			byte[] bytes = new byte[1024];
			int length = -1;
			do {
				try {
					length = reader.read(bytes);
					if (length != -1) {
						writer.write(bytes, 0, length);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (length != -1);
		}
		return null;
	}

}
