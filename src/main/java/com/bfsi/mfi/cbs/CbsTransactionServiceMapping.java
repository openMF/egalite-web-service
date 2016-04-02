package com.bfsi.mfi.cbs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.bfsi.mfi.cbs.adapter.CbsTransactionServiceAdapter;


public final class CbsTransactionServiceMapping {
	
	private static  Map<String, Map<String, String>> SERVICEMAPPING =null;
	private static  Map<String, String> ADAPTERMAPPING =null;
	
	
	private CbsTransactionServiceMapping(){
		ADAPTERMAPPING=new HashMap<String, String>();
		ADAPTERMAPPING.put("WIT", "com.bfsi.mfi.cbs.adapter.soap.CbsCashWithdrawServiceSoapAdapter");
		ADAPTERMAPPING.put("DEP", "com.bfsi.mfi.cbs.adapter.soap.CbsCashDepositServiceSoapAdapter");
		
	}
	public static CbsTransactionServiceAdapter getAdapterForTransaction(String p_txnCode){
		CbsTransactionServiceAdapter l_adapter=null;
		try {
			l_adapter=	(CbsTransactionServiceAdapter)Class.forName(ADAPTERMAPPING.get(p_txnCode)).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l_adapter;
	}
	public static Map<String, String> getMappingForTransaction(String p_txnCode){
		if(SERVICEMAPPING==null)
			loadServiceMap();
		return SERVICEMAPPING.get(p_txnCode);
	}
	
	public static void loadServiceMap(){
		if(SERVICEMAPPING==null){
			synchronized (CbsTransactionServiceMapping.class) {
				if(SERVICEMAPPING==null){
					loadServiceMapFromDB();
				}
			}
		}
	}
	private static void loadServiceMapFromDB(){
		List<Map<String, Object>> l_list = getJdbcTemplate()
				.queryForList(
						"select TXN_CODE TXNCODE, TXN_HANDLER  TXNHANDLER,TXN_VALIDATOR  TXNVALIDATOR  FROM MFI_TXN_SERVICE_MAPPER",
						new HashMap<String, String>());
		SERVICEMAPPING =new HashMap<String, Map<String,String>>();
		Map<String, String> l_serviceMap=null;
		for (Map<String, Object> m : l_list) {
			l_serviceMap=new HashMap<String, String>();
			l_serviceMap.put("HANDLER", m.get("TXNHANDLER").toString());
			l_serviceMap.put("VALIDATOR", m.get("TXNVALIDATOR").toString());
			SERVICEMAPPING.put(m.get("TXNCODE").toString(), l_serviceMap);
		}
	}
	private static NamedParameterJdbcTemplate getJdbcTemplate() {
		WebApplicationContext springContext = WebApplicationContextUtils
				.getWebApplicationContext((ServletContext) FacesContext
						.getCurrentInstance().getExternalContext().getContext());
		return new NamedParameterJdbcTemplate(
				(DataSource) springContext.getBean("dataSource"));
	}

}
