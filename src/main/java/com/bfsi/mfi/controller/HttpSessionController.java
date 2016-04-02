package com.bfsi.mfi.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javassist.bytecode.Descriptor.Iterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bfsi.mfi.auth.UserAuthenticationSuccessHandler;
import com.bfsi.mfi.dao.UserDao;
import com.bfsi.mfi.dao.jdbc.UserJdbcDao;
import com.bfsi.mfi.service.impl.UserAuthenticationServiceImpl;

/**
 * Bug Id: BFSIMFI-244
 * @author Shabu S Francis
 */

@ManagedBean(name = "sessionCollector")
@ViewScoped
public class HttpSessionController implements HttpSessionListener {
	
	private static final Map<String, String> USERSESSIONS = new HashMap<String, String>();

	private UserDao userDao;
	private WebApplicationContext springContext;

	@Override
	public void sessionCreated(HttpSessionEvent event) {

	}
/*
 * (non-Javadoc)
 * delete the logged in user entry on session expire
 */
	@Override
	public void sessionDestroyed(HttpSessionEvent p_event) {
				
		String l_sessionId;
		String l_userId;
		try {
			l_sessionId = p_event.getSession().getId();
			springContext = WebApplicationContextUtils
					.getWebApplicationContext(p_event.getSession()
							.getServletContext());
			userDao = (UserJdbcDao) springContext.getBean("userDao");
			if (l_sessionId != null && USERSESSIONS.containsKey(l_sessionId)) {
				l_userId = USERSESSIONS.get(p_event.getSession().getId());
				USERSESSIONS.remove(p_event.getSession().getId());
				userDao.logoutUser(l_userId);
			}
			/*
			 * Bud Id: EGALITE-93 Vishal Start
			 */
			if(UserAuthenticationSuccessHandler.userTrackor != null){				
				
				java.util.Iterator<Entry<String, Map<String, HttpSession>>> entries = UserAuthenticationSuccessHandler.userTrackor.entrySet().iterator();
				while (entries != null && entries.hasNext()) {
					  Entry thisEntry = (Entry) entries.next();
					  String userId = (String) thisEntry.getKey();
					  Map<String, HttpSession> userSessionMap = (HashMap<String, HttpSession>) thisEntry.getValue();
					  if(userSessionMap!=null){
						  java.util.Iterator<Entry<String, HttpSession>> valueEntries = userSessionMap.entrySet().iterator();
						  while (valueEntries!=null && valueEntries.hasNext()) {
							  Entry childEntry = (Entry) valueEntries.next();
							  String sessionId = (String) childEntry.getKey();
							  HttpSession userSession = (HttpSession) childEntry.getValue();
							  if(sessionId!= null && sessionId.equals(p_event.getSession().getId())){
								  UserAuthenticationSuccessHandler.userTrackor.remove(userId);
								  userSession.invalidate();								 
							  }
						  }
					  }
					 
				}
			}
			/*
			 * Bud Id: EGALITE-93 Vishal End
			 */			

		} catch (Exception p_e) {
			p_e.printStackTrace();
		}

	}

	public static void putSessionInfo(String p_sessionId, String p_userId) {
		USERSESSIONS.put(p_sessionId, p_userId);
	}
	public void invalidateUserSession(ActionEvent event){
		
		try{
		FacesContext l_facesContext = FacesContext.getCurrentInstance();
		if(l_facesContext == null)
			return;
		HttpSession l_session = (HttpSession) l_facesContext.getExternalContext().getSession(false);
		if(l_session== null)
			return;
		
		l_session.invalidate();
		}
		catch(Exception l_e){
			l_e.printStackTrace();
		}
	}

}
