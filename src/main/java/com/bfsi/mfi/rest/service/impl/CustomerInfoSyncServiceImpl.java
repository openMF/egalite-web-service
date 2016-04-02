package com.bfsi.mfi.rest.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.entity.CustomerEnrolServiceResponse;
import com.bfsi.mfi.entity.Document;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.constants.Constants;
import com.bfsi.mfi.rest.model.BeginSyncRequest;
import com.bfsi.mfi.rest.model.BeginSyncResponse;
import com.bfsi.mfi.rest.model.CustomerDetailInfo;
import com.bfsi.mfi.rest.model.CustomerInfoRequest;
import com.bfsi.mfi.rest.model.CustomerInfoResponse;
import com.bfsi.mfi.rest.model.DocumentsDetail;
import com.bfsi.mfi.rest.service.CustomerInfoSyncService;
import com.bfsi.mfi.service.CustomerInfoService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CustomerInfoVO;

@Component("customerInfoSyncServiceImpl")
//@Consumes("application/json")
//@Produces("application/json")
//@Path("/customer")
public class CustomerInfoSyncServiceImpl implements CustomerInfoSyncService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerInfoService customerInfoService;

	public CustomerInfoService getCustomerInfoService() {
		return customerInfoService;
	}

	public void setCustomerInfoService(CustomerInfoService customerInfoService) {
		this.customerInfoService = customerInfoService;
	}

	@Override
	//@Path("/enrollment")
	//@POST
	public CustomerInfoResponse submitCustomerInfo(CustomerInfoRequest request) {
		CustomerInfoResponse response = new CustomerInfoResponse();
		CustomerEnrolServiceResponse l_serRes=null;
		/*Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest req = (HttpServletRequest) message
				.get(AbstractHTTPDestination.HTTP_REQUEST);
		HttpSession sess = req.getSession(false);
		String deviceId;
		try {
			deviceId = sess.getAttribute("uniqueId").toString();

		} catch (Exception ex) {
			//response.setStatusText(Constants.SESSION_EXPIRED);
			//logger.error("Failed in Customer Enrollment = "+ex);
			response.setMessageCode("'MFI20003");
			LoggerUtil.mbsJobError("Session expired : MFI20003", ex);
			return response;
		}*/
		List<CustomerDetailInfo> customerDetailInfo = request.getCustomerInfo();
		List<CustomerInfoVO> customerInfoList = new ArrayList<CustomerInfoVO>();
		List<DocumentsDetail> documentsDetail = new ArrayList<DocumentsDetail>();
		// List<Document> documentList = new ArrayList<Document>();
		List<Document> documentList = null;

		if (request.getCustomerInfo() == null) {
			//response.setStatus(false);
			//response.setStatusText(Constants.NULL_REQUEST_DATA);
			response.setMessageCode("'MFI20004");
			return response;
		}
		try {
		for (int i = 0; i < customerDetailInfo.size(); i++) {

			customerInfoList.add(new CustomerInfoVO());
			BeanUtils.copyProperties(customerDetailInfo.get(i),
					customerInfoList.get(i), new String[] { "dob",
							"enrollmentdate" });
			documentsDetail = customerDetailInfo.get(i).getDocuments();
			documentList = new ArrayList<Document>();
			for (int j = 0; j < documentsDetail.size(); j++) {

				documentList.add(new Document());
				BeanUtils.copyProperties(documentsDetail.get(j),
						documentList.get(j));
			}
			customerInfoList.get(i).setDocuments(documentList);
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateformt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date syncTime = new Date();
		Date dob = new Date();
		Date enrollment = new Date();
		List<String> l_params=new ArrayList<String>();
		for (int i = 0; i < customerDetailInfo.size(); i++) {
			if (customerInfoList.get(i).getDocuments().isEmpty()) {
				//response.setStatus(false);
				
				
				response.setMessageCode("'MFI20005"); // Customer Document List is Empty for ID {0}
				l_params.add(customerInfoList.get(i).getId());
				response.setMessageParams(l_params);
				//response.setStatusText(Constants.CUSTOMER_DOCUMENT_LIST_EMPTY
						//+ customerInfoList.get(i).getId());
				return response;
			}
			//try {
				syncTime = dateformt.parse(dateformt.format(syncTime));
				enrollment = dateFormat.parse(customerDetailInfo.get(i)
						.getEnrollmentdate());
				dob = dateFormat.parse(customerDetailInfo.get(i).getDob());
			//} catch (ParseException e) {
				//logger.error("Failed in Customer details = "+e);
				//e.printStackTrace();
			//}
			customerInfoList.get(i).setSyncTime(syncTime);
			//customerInfoList.get(i).setDeviceId(deviceId);
			customerInfoList.get(i).setDeviceId(request.getDeviceId());
			customerInfoList.get(i).setDob(dob);
			customerInfoList.get(i).setEnrollmentdate(enrollment);
		}

		
		l_serRes=getCustomerInfoService().submitCustomerInfo(customerInfoList);
		BeanUtils.copyProperties(l_serRes, response);
			response.setStatus(true);
			//response.setStatusText(Constants.SUCCESS);
			//logger.error("Success in Customer Enrollment /begin ");
			
		} 
		catch (ParseException e) {
			LoggerUtil.mbsJobError("Parser exception while parsing dates: MFI20001", e);
			response.setMessageCode("'MFI20001");
			
		}
		catch (ServiceException e) {
			//response.setStatus(false);
			//response.setStatusText(e.getMessage());
			//logger.error("Failed in Customer Enrollment = "+e);
			LoggerUtil.mbsJobError("service exception while parsing dates: MFI20001", e);
			response.setMessageCode("'MFI20001");
			
		}
		catch (Exception e) {
			//response.setStatus(false);
			//response.setStatusText(e.getMessage());
			//logger.error("Failed in Customer Enrollment = "+e);
			LoggerUtil.mbsJobError("unhandled exception while parsing dates: MFI20001", e);
			response.setMessageCode("'MFI20001");
			
		}
		return response;

	}

	//@POST
	//@Consumes("multipart/form-data")
	//@Path("/uploaddocs/{id}/{docName}")
	// @Path("/uploaddocs/{id}")
	public Response uploadFile(List<Attachment> attachments,
			@Context HttpServletRequest request, @PathParam("id") String id,
			@PathParam("docName") String docName) {
		String enrollmentId = id;

		if (enrollmentId == null || attachments == null || docName == null) {
			Response.status(Status.BAD_REQUEST);
			return Response.ok("Request data is null").build();
		}

		for (Attachment attr : attachments) {
			DataHandler handler = attr.getDataHandler();
			try {

				InputStream stream = handler.getInputStream();

				try {
					getCustomerInfoService().insertDocumentData(stream,
							docName, enrollmentId);
				} catch (ServiceException e) {
					Response.status(Status.BAD_REQUEST);
					logger.error("Failed in Customer Enrollment = "+e);
					e.printStackTrace();
					return Response.ok(e.getMessage()).build();

				}
			} catch (IOException e) {
				Response.status(Status.BAD_REQUEST);
				return Response.ok(e.getMessage()).build();
			}

		}
		Response.status(Status.ACCEPTED);
		return Response.ok("file uploaded").build();
	}

	//@Override
	//@POST
	//@Path("/begin")
	//this service is not required..
	public BeginSyncResponse checkCustomerInfo(BeginSyncRequest request) {
		BeginSyncResponse response = new BeginSyncResponse();
		List<String> idList = request.getIdList();
		String syncsessionid = request.getSynsessionid();
		if (idList == null || syncsessionid == null) {
			response.setStatus(false);
			response.setStatusText(Constants.ID_LIST_EMPTY);
			//response.setMessageCode("'MFI20006");
		}

		try {
			response.setReceivedId(getCustomerInfoService()
					.uploadCustomerEnrollStatus(idList, syncsessionid));
			logger.error("Success in Customer Enrollment /begin ");
			response.setStatus(true);
		} catch (ServiceException ex) {
			response.setStatusText(ex.getMessage());
			logger.error("Failed in Customer Enrollment = "+ex);
			ex.printStackTrace();
		}

		return response;

	}
}
