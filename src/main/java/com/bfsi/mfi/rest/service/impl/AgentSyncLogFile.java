package com.bfsi.mfi.rest.service.impl;

import java.io.InputStream;
import java.util.List;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.service.AgentLogFile;
import com.bfsi.mfi.util.LoggerUtil;

@Component("agentSyncLogFile")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Path("/file")
public class AgentSyncLogFile {

	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	@Autowired
	private AgentLogFile agentLogFileImpl;

	public AgentLogFile getFileUploadService() {
		return agentLogFileImpl;
	}

	public void setFileUploadService(AgentLogFile agentLogFileImpl) {
		this.agentLogFileImpl = agentLogFileImpl;
	}

	@POST
	public Response uploadFile(List<Attachment> attachments,
			@Context HttpServletRequest request) {
		String agentId = null;
		String deviceId = null;
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest req = (HttpServletRequest) message
				.get(AbstractHTTPDestination.HTTP_REQUEST);
		HttpSession sess = req.getSession(false);
		for (Attachment attr : attachments) {
			DataHandler handler = attr.getDataHandler();
			try {
				MultivaluedMap map = attr.getHeaders();
				//System.out.println("Map" + map);
				InputStream stream = handler.getInputStream();

				try {
					agentId = sess.getAttribute("agentId").toString();
					deviceId = sess.getAttribute("uniqueId").toString();
				} catch (Exception ex) {
					LoggerUtil.mbsJobError("Unhandeled Exception while upload Log file : MFI10001", ex);
					return Response.ok("file uploaded").build();
				}

				getFileUploadService().uploadAgentLogFile(stream, agentId,
						deviceId, getFileName(map));

				// OutputStream out =new FileOutputStream(new //
				// File(getFileName(map)));
				/*
				 * OutputStream out = new FileOutputStream(new
				 * File("E:\\abc.jpg")); int read = 0; byte[] bytes = new
				 * byte[1024]; while ((read = stream.read(bytes)) != -1) {
				 * out.write(bytes, 0, read); }
				 */
				stream.close();
				// out.flush();
				// out.close();

			} catch (Exception e) {
				LoggerUtil.mbsJobError("Unhandeled Exception while upload Log file : MFI10001", e);
			}
		}

		return Response.ok("file uploaded").build();
	}

	private String getFileName(MultivaluedMap<String, String> header) {

		String[] contentDisposition = header.getFirst("Content-Disposition")
				.split(";");

		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {

				String[] name = filename.split("=");

				String finalFileName = name[1].trim().replaceAll("\"", "");
				return finalFileName;
			}
		}
		return "unknown";
	}

}
