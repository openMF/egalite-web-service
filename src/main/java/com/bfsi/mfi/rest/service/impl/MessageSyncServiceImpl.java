package com.bfsi.mfi.rest.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.messages.ApplicationMessages;

import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.rest.model.Message;
import com.bfsi.mfi.rest.model.MessageDetailsRequest;
import com.bfsi.mfi.rest.model.MessageDetailsResponse;
import com.bfsi.mfi.rest.service.MessageSyncService;
import com.bfsi.mfi.util.EncryptDecryptUtil;
import com.bfsi.mfi.util.LoggerUtil;


/**
 * 
 * @author Shabu
 *
 */
@Component("messageSyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/messages")
public class MessageSyncServiceImpl implements MessageSyncService {

	private static final String SUBSYS_MOBILE = "M";
	//private static int batchCounter = 0;
	//private List<Message> l_msgSubList = null;
	List<Message> l_msg = null;
		

	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;

	@POST
	@Override
	public JsonResponseWrapper getMessageDetails(JsonRequestWrapper p_wrapRequest) {
		MessageDetailsRequest request=null;
		try {
			 request=(MessageDetailsRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, MessageDetailsRequest.class);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("exception", e);
			return new JsonResponseWrapper();
		}
		

		MessageDetailsResponse l_msgRes = new MessageDetailsResponse();
		//int batchSize = 0;		
		
		/*try {				
			//batchSize = request.getBatchSize();
		} catch (Exception e){			
			batchCounter = 0;
			l_msgRes.setMessageCode("MFI20000");
			LoggerUtil.mbsJobError("Unhandeled Exception while get Messages list : MFI10001", e);
			return l_msgRes;
		}	*/	
		try {
			
			//l_msgSubList = getBatchedMessageDetails(batchSize, batchCounter);
			 l_msg = ApplicationMessages
						.getAllMessagesForSubSystem(SUBSYS_MOBILE);
			l_msgRes.setMessages(l_msg);
			l_msgRes.setStatus(true);
			
		} catch (ServiceException e) {			
			l_msgRes.setMessageCode("MFI20000");
			//batchCounter = 0;
			LoggerUtil.mbsJobError("ServiceException while get Messages list : MFI10001", e);			
		} catch (Exception e) {			
			l_msgRes.setMessageCode("MFI20000");
			//batchCounter = 0;
			LoggerUtil.mbsJobError("Unhandeled Exception while get Messages list : MFI10001", e);
		}
		//batchCounter ++;				
		return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_msgRes);
	}
	
	private List<Message> getBatchedMessageDetails(int batchSize, int batchCounter) {
		List<Message> msgSubList = null;
		
		try{
			List<Message> l_msg = ApplicationMessages
					.getAllMessagesForSubSystem(SUBSYS_MOBILE);
			msgSubList = l_msg.subList((batchSize * batchCounter), (batchSize * batchCounter + batchSize));	
			if(msgSubList == null || (msgSubList!=null && msgSubList.size() <=0)) {
				batchCounter = 0;
			}
		}catch(Exception e){
			batchCounter = 0;
			msgSubList = null;
			LoggerUtil.mbsJobError("Unhandeled Exception while get Messages list : MFI10001", e);		
		}
		
		return msgSubList;
	}
	
	

}
