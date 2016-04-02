package com.bfsi.mfi.service;

import java.io.InputStream;

public interface AgentLogFile {

	public void uploadAgentLogFile(InputStream in, String agentId,
			String deviceId,String fileName);
}
