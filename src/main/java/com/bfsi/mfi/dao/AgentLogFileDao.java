package com.bfsi.mfi.dao;

import java.io.Reader;
import java.io.Writer;
import java.util.Date;

import com.bfsi.mfi.entity.File;

public interface AgentLogFileDao extends ReadOnlyMaintenanceDao<File> {

	public void insertBlob(byte[] data, String agentId, String deviceId);

	public void insertClob(Reader reader, String agentId, String deviceId,
			String fileName, Date syncDate);

	void readClob(Writer writer, String agentId, String deviceId);

}
