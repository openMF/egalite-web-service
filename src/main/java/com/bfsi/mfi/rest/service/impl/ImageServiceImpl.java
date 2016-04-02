package com.bfsi.mfi.rest.service.impl;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.stereotype.Component;

@Component("imageServiceImpl")
@Produces("image/png")
@Path("/image")
public class ImageServiceImpl {

	private static final String FILE_PATH = "E:\\download.jpg";

	@GET
	public Response getFile() {
		File file = new File(FILE_PATH);

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=test.png");
		return response.build();
	}

}
