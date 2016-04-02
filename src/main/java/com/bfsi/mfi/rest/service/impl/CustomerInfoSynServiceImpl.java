package com.bfsi.mfi.rest.service.impl;

import java.util.List;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

//@Component("customerInfoImpl")
@Consumes("multipart/form-data")
@Path("/customerInfo")
public class CustomerInfoSynServiceImpl {

	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	/*
	 * @GET
	 * 
	 * @Path("/query") public Response uploadFile(List<Attachment> attachments,
	 * 
	 * @QueryParam("id") List<Integer> enrollmentId) {
	 * //System.out.println("request data" + enrollmentId); Message message =
	 * PhaseInterceptorChain.getCurrentMessage(); HttpServletRequest req =
	 * (HttpServletRequest) message .get(AbstractHTTPDestination.HTTP_REQUEST);
	 * HttpSession sess = req.getSession(false); for (Attachment attr :
	 * attachments) { DataHandler handler = attr.getDataHandler(); try {
	 * MultivaluedMap map = attr.getHeaders(); //System.out.println("Map" + map);
	 * InputStream stream = handler.getInputStream(); stream.close(); //
	 * out.flush(); // out.close();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * return Response.ok("file uploaded").build(); }
	 */

	@POST
	@Path("{id}")
	public Response uploadFile(List<Attachment> attachments,
			@PathParam("id") String id,
			@FormParam("docName") List<String> documentNames) {
		//System.out.println("request data" + id);
		//System.out.println("request data" + documentNames);
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest req = (HttpServletRequest) message
				.get(AbstractHTTPDestination.HTTP_REQUEST);
		HttpSession sess = req.getSession(false);
		for (Attachment attr : attachments) {
			DataHandler handler = attr.getDataHandler();
			try {
				MultivaluedMap map = attr.getHeaders();
				//System.out.println("Map" + map);

			} catch (Exception e) {
				e.printStackTrace();
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
