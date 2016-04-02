package com.bfsi.mfi.auth;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.bfsi.mfi.controller.HttpSessionController;
import com.bfsi.mfi.dao.UserDao;
import com.bfsi.mfi.entity.User;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;

/**
 * Bug Id: BFSIMFI-268
 * 
 * @author Shabu S Francis
 * 
 */
public class UserAuthenticationSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {
	@Autowired
	private UserDao userDao;
	private User user = new User();
	ExternalContext externalContx;
	public static final Map<String,Map<String,HttpSession>> userTrackor = new ConcurrentHashMap<String,Map<String,HttpSession>>();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		LoggerUtil
				.ibsJobDebug("adding record to login tracker table for user: " + authentication.getName());
		try {
			user = userDao.forValidFirstTimeLogin(authentication.getName());
			if((user.getUserStatus()).equalsIgnoreCase("F"))
			{
				//super.onAuthenticationSuccess(request, response, authentication);
				redirectFirstLogIn(user.getId());
			}
			else
			{
				userDao.updateUserLogin(authentication.getName());
				super.onAuthenticationSuccess(request, response, authentication);
			}
			
		} catch (DataAccessException e) {
			MessageUtil.addMessage("MFI10001");
			LoggerUtil.ibsJobError(
					"Data Access Exception while updating logged in user detail for user: "
							+ authentication.getName(), e);
			redirectView();

		} catch (Exception e) {
			MessageUtil.addMessage("MFI10001");
			LoggerUtil.ibsJobError(
					"Unhandled Exception while updating logged in user detail for user: "
							+ authentication.getName(), e);
			redirectView();
		}
		
		/*
		 * Bud Id: BFSIMFI-244 Shabu Start
		 * Track the logged in users
		 */
		externalContx =FacesContext.getCurrentInstance().
				getExternalContext();
		HttpSessionController.putSessionInfo(((HttpSession) externalContx.getSession(false)).getId(), user.getId());
		
		/*
		 * Bud Id: BFSIMFI-244 Shabu End
		 */
		
		/*
		 * Bud Id: EGALITE-93 Vishal Start
		 */
		Map<String,HttpSession> userSessionMap = new HashMap<String,HttpSession>();
		userSessionMap.put(((HttpSession) externalContx.getSession(false)).getId(), (HttpSession) externalContx.getSession(false));
		userTrackor.put(user.getId(), userSessionMap);
		
		/*
		 * Bud Id: EGALITE-93 Vishal End
		 */
	}

	private void redirectView() {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			NavigationHandler navigationHandler = facesContext.getApplication()
					.getNavigationHandler();
			navigationHandler.handleNavigation(facesContext, null,
					"/login.xhtml");
			facesContext.renderResponse();
			((HttpSession) facesContext.getExternalContext().getSession(false))
					.invalidate();
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Exception while redircting page", e);
		}
	}

	private String redirectFirstLogIn(String id) {
		try {
			/*FacesContext facesContext = FacesContext.getCurrentInstance();
			NavigationHandler navigationHandler = facesContext.getApplication()
					.getNavigationHandler();
			navigationHandler.handleNavigation(facesContext, null,
					"/useradmin/addUser.xhtml");
			facesContext.renderResponse();
			((HttpSession) facesContext.getExternalContext().getSession(false))
					.invalidate();*/
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
			context.redirect("/useradmin/changePasswd.xhtml?id="+ id);
			
			
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Exception while redircting page", e);
		}
		return "success";
	}
	
	protected String getViewRecordUrl() {
		return "success";
	}

}
