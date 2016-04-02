package com.bfsi.mfi.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

/**
 * 
 * @author Shabu S Francis Bug: User is able to do un-authorized pages when they
 *         do a copy-paste of the URL
 */
public final class UserFunctionViewMap {

	private static Map<String, Object> VIEWMAP = null;

	private static NamedParameterJdbcTemplate getJdbcTemplate() {
		WebApplicationContext springContext = WebApplicationContextUtils
				.getWebApplicationContext((ServletContext) FacesContext
						.getCurrentInstance().getExternalContext().getContext());
		return new NamedParameterJdbcTemplate(
				(DataSource) springContext.getBean("dataSource"));
	}

	private UserFunctionViewMap() {

	}

	private static Map<String, Object> getViewMap() {

		if (VIEWMAP == null)
			loadViewMap();

		return VIEWMAP;
	}

	public static String getCommandForView(String p_viewId) {
		if (getViewMap().containsKey(p_viewId))
			return getViewMap().get(p_viewId).toString();
		return null;
	}

	public static void loadViewMap() {
		LoggerUtil.ibsJobDebug("Starting loading view-funcion map");
		if (VIEWMAP == null) {
			synchronized (UserFunctionViewMap.class) {
				if (VIEWMAP == null) {
					try{
					loadViewMapFromDB();
				}
				catch (Exception e) {
					VIEWMAP = null;
					LoggerUtil.ibsJobError("Unhandled exception while loading view-funcion map",e);
					e.printStackTrace();
				}
				}

			}

		}
		LoggerUtil.ibsJobDebug("finished loading view-funcion map");
		//System.out.println("finished loading view-funcion map");

	}

	private static void loadViewMapFromDB() {
		List<Map<String, Object>> l_list = getJdbcTemplate()
				.queryForList(
						ApplicationQuery.Load_ViewMap_FromDB,
						new HashMap<String, String>());
		VIEWMAP = new HashMap<String, Object>();
		String l_viewMaps[];
		for (Map<String, Object> m : l_list) {
			if (m.get("VIEWID") != null
					&& m.get("VIEWID").toString().trim().length() > 0) {
				l_viewMaps = m.get("VIEWID").toString().trim().split(";");
				for (int l_i = 0; l_i < l_viewMaps.length; l_i++)
					if (l_viewMaps[l_i] != null
							&& l_viewMaps[l_i].trim().length() > 0)
						VIEWMAP.put(l_viewMaps[l_i].trim(), m.get("COMMANDID"));
			}
		}
	}
}
