package com.bfsi.mfi.util;




import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.exception.ServiceException;

import com.bfsi.mfi.rest.model.BaseRequest;
import com.bfsi.mfi.rest.model.BaseResponse;
import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.service.AgentService;

@Component
public class EncryptDecryptUtil {

	@Autowired
	private AgentService agentService;
	
	private static final ObjectMapper MAPPER = new ObjectMapper();

	public  BaseRequest unmarshalFromJson(String p_json,
			Class<? extends BaseRequest> p_class) {

		try {
			return MAPPER.readValue(p_json, p_class);
		} catch (Exception e) {
			throw new ServiceException("exception while unmarshalFromJson", e);
		}
	}
	
	public  BaseResponse unmarshalResponseFromJson(String p_json,
			Class<? extends BaseResponse> p_class) {

		try {
			return MAPPER.readValue(p_json, p_class);
		} catch (Exception e) {
			throw new ServiceException("exception while unmarshalFromJson", e);
		}
	}

	public  String marshalToJson(BaseResponse p_res) {

		try {
			return MAPPER.writeValueAsString(p_res);
		} catch (Exception e) {
			throw new ServiceException("exception while marshalToJson", e);
		}
	}

	public  String encryptJson(String p_json, String p_key) {
		try {
			return EncryptionUtils.encrypt(p_key, p_json);
		} catch (Exception e) {
			throw new ServiceException("exception while encryptJson", e);
		}
	}

	public  String decryptJson(String p_json, String p_key) {
		try {
			
			return EncryptionUtils.decrypt(p_key,p_json);
		} catch (Exception e) {
			throw new ServiceException("exception while decryptJson", e);
		}

	}
	
	public  BaseRequest getRequestObject(JsonRequestWrapper p_req, Class<? extends BaseRequest> p_class){
		String l_json=p_req.getJsonString();
		
		p_req.setDataKey(agentService.getDataKey(p_req.getAgentId()));
		
		LoggerUtil.mbsJobDebug("Internal Key for Decryption: "+p_req.getDataKey());
				
		l_json = decryptJson(l_json,p_req.getDataKey());
		LoggerUtil.mbsJobDebug("Decrypted request payload: "+l_json);
		return unmarshalFromJson(l_json, p_class);
		
	}
	
	public  BaseRequest getRequestObjectWithExternalKey(JsonRequestWrapper p_req, Class<? extends BaseRequest> p_class){
		String l_json=p_req.getJsonString();
		
		LoggerUtil.mbsJobDebug("External Key for Decryption: "+p_req.getDataKey());
		
		
		l_json = decryptJson(l_json,p_req.getDataKey());
		LoggerUtil.mbsJobDebug("Decrypted request payload: "+l_json);
		return unmarshalFromJson(l_json, p_class);
		
	}
	
	
	
	public  JsonResponseWrapper getResponseObject(JsonRequestWrapper p_req,BaseResponse p_res){
		JsonResponseWrapper l_res=new JsonResponseWrapper();
		try {
			String l_json=marshalToJson(p_res);
						
			if(p_req.getDataKey()==null || p_req.getDataKey().trim().length()<1)
				 p_req.setDataKey(agentService.getDataKey(p_req.getAgentId()));
			
			LoggerUtil.mbsJobDebug("Object Marshalled for encryption: "+l_json);
			
			l_json=encryptJson(l_json,p_req.getDataKey());
			LoggerUtil.mbsJobDebug("key for encryption: "+p_req.getDataKey());
			l_res.setJsonString(l_json);
			l_res.setStatus(true);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("exception",e);
		}
		
		return l_res;
	}
	
	public   BaseResponse getResponseObject(JsonResponseWrapper p_res, Class<? extends BaseResponse> p_class){
		BaseResponse l_res=null;
		try {
			String l_json=p_res.getJsonString();
			
			LoggerUtil.mbsJobDebug("Key for Decryption: "+p_res.getDataKey());
			
			l_json=decryptJson(l_json,p_res.getDataKey());
			
			LoggerUtil.mbsJobDebug("Decrypted response: "+l_json);
			
			l_res=unmarshalResponseFromJson(l_json, p_class);
		} catch (Exception e) {
			LoggerUtil.ibsJobError("exception",e);
		}
		
		return l_res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		//System.out.println(EncryptionUtils.encrypt("rYrQ0T45OV979qdCzo36f9uWUJEf3mgnDRdoJNNpouM=", "Shabu"));
		//System.out.println(EncryptionUtils.decrypt("rYrQ0T45OV979qdCzo36f9uWUJEf3mgnDRdoJNNpouM=asas", EncryptionUtils.encrypt("rYrQ0T45OV979qdCzo36f9uWUJEf3mgnDRdoJNNpouM=asas", "Shabu")));
	//	String req="{\"imeiNo\":\"355383054270898\",\"locCode\":\"LOC00000001\",\"simNo\":\"99999900000\",\"agentId\":\"AGT0011100001\",\"deviceId\":\"DEV00001\",\"batchSize\":0}";
		//System.out.println(encryptJson(req));
		//String res="rYrQ0T45OV979qdCzo36f9uWUJEf3mgnDRdoJNNpouM=";
		//System.out.println(decryptJson("KWhJsSqA7x/hc1dkyJAoDwKlXAEoCnoiF5/9bbRgrs94wq+5Pmg6b57fvztYY8wqgOaiKww8LlHRBm/oLoiPsQ5YAyh5G9q/w5BF5a/Vf4LSFSosvYOfGwyporRjAO5j6SKFSi/ITIghjYtxh3PSn7KWP0RNI8xdmcfI7Bn08FplaL+xhdOKoJ2Hnh4wszikTQlZw727mvmNy9a79A4CnvFScWsAjoAtt7plAIQyIBCThiRcVgq+82BGgIK19to+2MrCxu0BqYlpcYBSckyarY5FpX89/fd6v9FzDSIP06rJaEYfi4vePTE59NJpQ91UranvBpW2imruB0OedMk34MgGB1Kevk/IA1BnPyZQtsWzlaxdF4NDJjIM+jZKa5cOBMpchrsv2+KOEeeMCzzF4WYbP3taI5fz64a3CZV6ldnTDYj0pzuw4Kz0GEZDX78QA9DIstKRRFBz+GxafXN4er8UeF9LQSD60kntIJk8jMSN8qGop7EZimV7XTBKu3w1azz5Jrmv3tOBkCbplUDRLXo04mI7iQIgMunWItpGdEA/2bX7Nq1xsEKtZSU6LwTxDTEdUha2q/3mgp+HIBU9NfMSoIS983e6oz9X0nWBKbFWFvTOOEU/KgYirQZpjXpyucqyMgvEKQMfjjnO+ePadtb3M6ZTZHXzzClGH5DZ4d5K/NfSMG42uaWomT6DKAT4oU13Oh7Q+uDRb1Q7H5u6yAwY8+YI+f/MgKkTGTrxUXc8BLhivKwteqYNV2huLpHEuzOXTVlL5fI3IWQTuFCm5gdoMtakSYol5zN8tIWVtNyWj5Yoq8I3rgsnwB/rNd1+K0fyzOfFSxFOAQXGBMiY8H7lIR5tNzoebPqHMesnXxprPtdIdWOfj+K1JpNy5jfvwz+C6PdslUATOsilDFDRZGUhGsA+WfSStKTyD42bqsARehngMuqebitxbRQa59KhNwTpPRHkpDM2grcTDh3bFvOR5AcKsaZdXHx346zR5sbPhh8kYlq7+Yj6F/XPNGucvkCl0AztWdJNiD5t5m2H9MruPmNX1QQnfgdtS3IlHKoqXGKAG+RttPsgGYphuYm+XJYkLm8/90A729nnOS47kqFHvKIPTQFEnrfXxIr/T8QDf7FQoVck5WNZxO7QMQy4xdxk0xQ1gocCQk8QOXu9vW7/adgiJY2H9mWLnFBQTRoh70cZViMhODaiLUsV/RIJLWKYUWmV7WsJWPMHLgeUDmHfVH2p+7ciIcEKlVp0q2CIK4UELJlj3r5wkqPP+Zpbku3uUIXqVIhOfiLYHY4uPnp2RvpmnYVt4VRqEcq9GItJ0h31dkr77WLLeyuayohC8wV3IASbAJ4qchB3R0LrUMBdF34BerMr+PRWP+/NcfUoxTqlhz82gfS+szqFE/rjDn0IORMLaykx5ktBTTRKd4jVv6JbDa8EvNKq4WuWWbzPWdd1K32GSYnOuZFT1UjDJYirw4BSdG8wL0JhosKlrm7SkjGvi8McnGGJ4lp8VhW+QKXQDO1Z0gLEbjz0/SXWuMTitYjVL3KfjGjKEIEoLJShYu/wtr+Rt6Tp7tfWLFko53a2NgrvRp6X9fCADVmOdIjKfvy6oRHaHrqxWAWdggRr1Js4l3p5prp8bM0pkKI8REyIQuWWGYkC9d4/OLoUdMZLv9PUMF2mOju8TcQWRaIjk9h/K3JV8xTvQo4Elv2QS+Vupfxclp84tUnQHBP4bynIf1+Y0UigCfdX7iZ6c1STWJW+SsUet/qPlN29trpx0mj9pSRVPhuyF4zDCftRRR11Jm4kaUvHTdClEEYfmIUJujDc1u4otSbDL9pcRpe9cjLc7SavK+DVbn5oedJVr3aU68Rk53qYTFjk3r6ZA9vN+0+Vm2APizexgM2xQ3U4aqj7ERsl46QpdoCe3gE1K97A9VxhJ71i7WLVfVM1u7PDnjKaMAZHtNKpjsNSbmk=",res));
		/*
		
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(256);
		SecretKey skey = kgen.generateKey();
		byte[] raw = skey.getEncoded();
		System.out.println(new String(raw));
		System.out.println(org.primefaces.util.Base64.encodeToString(raw,true));*/
	}
	

}
