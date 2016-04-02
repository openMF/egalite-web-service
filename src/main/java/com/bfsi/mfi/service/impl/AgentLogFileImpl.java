package com.bfsi.mfi.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.AgentLogFileDao;
import com.bfsi.mfi.service.AgentLogFile;
import com.bfsi.mfi.util.LoggerUtil;

@Service(value = "agentLogFileImpl")
public class AgentLogFileImpl implements AgentLogFile {
	@Autowired
	private AgentLogFileDao agentLogFileJdbcDao;

	@Override
	public void uploadAgentLogFile(InputStream in, String agentId,
			String deviceId, String fileName) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date syncDate = null;
		try {
			syncDate = dateFormat.parse(dateFormat.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			LoggerUtil.mbsJobError("ParseException while upload Log file : MFI10001", e);
		}
		getFileUploadDao().insertClob(new InputStreamReader(in), agentId,
				deviceId, fileName, syncDate);

		// StringWriter strWriter = new StringWriter();
		// getFileUploadDao().readClob(strWriter, agentId, deviceId);
		// System.out.println("Content inserted" + strWriter.toString());
	}

	public AgentLogFileDao getFileUploadDao() {
		return agentLogFileJdbcDao;
	}

	public void setFileUploadDao(AgentLogFileDao agentLogFileJdbcDao) {
		this.agentLogFileJdbcDao = agentLogFileJdbcDao;
	}

	public void insertBlob(InputStream in, String agentId, String deviceId) {
		byte[] data = null;
		try {
			data = getBytes(in);
		} catch (IOException e) {
			LoggerUtil.mbsJobError("IOException while upload Log file : MFI10001", e);
		}
		getFileUploadDao().insertBlob(data, agentId, deviceId);
	}

	public static byte[] getBytes(InputStream is) throws IOException {

		int len;
		int size = 1024;
		byte[] buf;

		if (is instanceof ByteArrayInputStream) {
			size = is.available();
			buf = new byte[size];
			len = is.read(buf, 0, size);
		} else {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			buf = new byte[size];
			while ((len = is.read(buf, 0, size)) != -1)
				bos.write(buf, 0, len);
			buf = bos.toByteArray();
		}
		return buf;
	}

}
