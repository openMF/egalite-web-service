package com.bfsi.mfi.controller;

import java.io.IOException;

import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bfsi.mfi.auth.UserFunctionViewMap;
import com.bfsi.mfi.exception.AccountExpiredException;
import com.bfsi.mfi.exception.AccountInactiveException;
import com.bfsi.mfi.exception.AccountLockedException;
import com.bfsi.mfi.exception.UserRoleActiveException;
import com.bfsi.mfi.exception.UserRoleAuthorizeException;
import com.bfsi.mfi.exception.UserSessionException;
import com.bfsi.mfi.exception.UserUnauthorizedException;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;

@ManagedBean(name = "loginController")
@RequestScoped
@RequestMapping(method = RequestMethod.POST)
public class LoginController implements PhaseListener {
	private static final long serialVersionUID = 4225874104579322603L;
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * 
	 * Redirects the login request directly to spring security check. Leave this
	 * method as it is to properly support spring security.
	 * 
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String doLogin() throws ServletException, IOException {

		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();

		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
				.getRequestDispatcher("j_spring_security_check");

		dispatcher.forward((ServletRequest) context.getRequest(),
				(ServletResponse) context.getResponse());

		FacesContext.getCurrentInstance().responseComplete();

		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void afterPhase(PhaseEvent event) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.event.PhaseListener#beforePhase(javax.faces.event.PhaseEvent)
	 * 
	 * Do something before rendering phase.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void beforePhase(PhaseEvent event) {
		/*
		 * Shabu changes Starts
		 * 
		 * User is able to do un-authorized pages when they do a copy-paste of the URL
		 */
		authenticateView();
		
		/*
		 * Shabu changes ends
		 * 
		 
		 */

		// logger.info("Validation in beforePhase at LoginController class");
		Exception e = (Exception) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap()
				.get(WebAttributes.AUTHENTICATION_EXCEPTION);
		// Bug EGALITE-185 start * vishal
		try {
			FacesContext.getCurrentInstance()
			.getExternalContext().getSessionMap()
			.remove(WebAttributes.AUTHENTICATION_EXCEPTION);
		} catch (Exception ex) {
			LoggerUtil.ibsJobDebug("FacesContext Exception : "+ex.getMessage());
		}
		// Bug EGALITE-185 end * vishal
		
		if (e instanceof BadCredentialsException) {
			LoggerUtil.ibsJobDebug("Obtained BadCredentialsException. Invalid login: MFI10003 "
					+ e.getMessage());
			MessageUtil.addMessage("MFI10003");
		} else if (e instanceof LockedException) {
			LoggerUtil.ibsJobDebug("Obtained AccountLockedException. Account is locked: MFI10004 "
					+ e.getMessage());
			MessageUtil.addMessage("MFI10004");
		} else if (e instanceof CredentialsExpiredException) {
			LoggerUtil.ibsJobDebug("Obtained AccountExpiredException. Account is expired: MFI10005 "
					+ e.getMessage());
			MessageUtil.addMessage("MFI10005");
		} else if (e instanceof AuthenticationServiceException) {
			// handle custom Inactive exceptions here
			if (e.getCause() instanceof AccountInactiveException) {
				LoggerUtil.ibsJobDebug("Obtained AccountInactiveException. Account is Inactive: MFI10006 "
						+ e.getMessage());
				MessageUtil.addMessage("MFI10006");
			}

			// handle custom Inactive exceptions here
			if (e.getCause() instanceof AccountLockedException) {
				LoggerUtil.ibsJobDebug("Obtained AccountLockedException. Account is Locked: MFI10004 "
						+ e.getMessage());
				MessageUtil.addMessage("MFI10004");
			}

			// handle custom authentication exceptions here
			if (e.getCause() instanceof UserUnauthorizedException) {
				LoggerUtil.ibsJobDebug("Obtained AccountUnauthorizedException. Account is unauthorized: MFI10007 "
						+ e.getMessage());
				MessageUtil.addMessage("MFI10007");
			}
			// handle custom Role Unauthorized exceptions here
			if (e.getCause() instanceof UserRoleAuthorizeException) {
				LoggerUtil.ibsJobDebug("Obtained RoleUnauthorizedException. Role is unauthorized: MFI10018 "
						+ e.getMessage());
				MessageUtil.addMessage("MFI10018");
			}

			// handle custom role Active / Inactive exceptions here
			if (e.getCause() instanceof UserRoleActiveException) {
				LoggerUtil.ibsJobDebug("Obtained AccountRoleInactive Exception. Role is Inactive: MFI10007 "
						+ e.getMessage());
				MessageUtil.addMessage("MFI10007");
			}

			// handle custom User Session exceptions here
			if (e.getCause() instanceof UserSessionException) {
				LoggerUtil.ibsJobDebug("Obtained UserSessionException. User session expired: MFI10017"
						+ e.getMessage());
				MessageUtil.addMessage("MFI10017");
			}
			
			if (e.getCause() instanceof AccountExpiredException) {
				LoggerUtil.ibsJobDebug("Obtained AccountExpiredException. Account is Expired: MFI10005"
						+ e.getMessage());
				MessageUtil.addMessage("MFI10005");
			}

		} else if (e instanceof ViewExpiredException) {
			LoggerUtil.ibsJobDebug("Found exception in session map ViewExpiredException: "
					+ e.getMessage());

			FacesContext facesContext = FacesContext.getCurrentInstance();
			NavigationHandler navigationHandler = facesContext.getApplication()
					.getNavigationHandler();
			navigationHandler.handleNavigation(facesContext, null,
					"/index.xhtml");
			facesContext.renderResponse();
		}
		/*
		 * Shabu changes starts
		 * 
		 * BFSIMFI-87
		 */
		try {
			FacesContext facesContext = event.getFacesContext();
			HttpServletResponse response = (HttpServletResponse) facesContext
					.getExternalContext().getResponse();
			response.addHeader("Pragma", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
			response.addHeader("Cache-Control", "no-store");
			response.addHeader("Cache-Control", "must-revalidate");
		} catch (Exception ex) {
			LoggerUtil.ibsJobError("Unhandled exception while setting response header values",e);
		}
		/*
		 * Shabu changes ends
		 * 
		 * BFSIMFI-87
		 */

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.event.PhaseListener#getPhaseId()
	 * 
	 * In which phase you want to interfere?
	 */
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}
	
	/*
	 * Shabu changes Starts
	 * 
	 * User is able to do un-authorized pages when they do a copy-paste of the URL
	 */

	private void authenticateView() {
		//LoggerUtil.ibsJobDebug("authenticating page view");

		String l_path = FacesContext.getCurrentInstance().getViewRoot()
				.getViewId();
		if (l_path == null)
			return;

		String l_fileName = l_path.substring(l_path.lastIndexOf("/") + 1);
		//LoggerUtil.ibsJobDebug("authenticating page view for view: "+l_fileName);
		String l_command = UserFunctionViewMap.getCommandForView(l_fileName);
		//LoggerUtil.ibsJobDebug("function command: "+l_command+" view: "+l_fileName);

		if (l_command == null){
			//LoggerUtil.ibsJobDebug("No function command mapped for view: "+l_fileName);
			return;
		}
		if (!checkAuthority(l_command)) {
			LoggerUtil.ibsJobDebug("MFI10019: user does not have authority to view page:" +l_fileName);
			MessageUtil.addMessage("MFI10019");
			FacesContext facesContext = FacesContext.getCurrentInstance();
			NavigationHandler navigationHandler = facesContext.getApplication()
					.getNavigationHandler();
			navigationHandler.handleNavigation(facesContext, null,
					"/login.xhtml");
			facesContext.renderResponse();
			((HttpSession) facesContext.getExternalContext().getSession(false))
					.invalidate();
		}
		//LoggerUtil.ibsJobDebug(" user has authority to view page:" +l_fileName);
	}

	private boolean checkAuthority(String command) {
		UserDetails userDetails = getUserDetails();
		if (userDetails != null) {
			for (GrantedAuthority auth : userDetails.getAuthorities()) {
				if (auth.getAuthority().equals(command)) {
					return true;
				}
			}
		}
		return false;
	}

	private UserDetails getUserDetails() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal);
		} else {
			return null;
		}
	}
	/*
	 * Shabu changes ends
	 * 
	 
	 */
	public void timeout() throws IOException {
	    FacesContext.getCurrentInstance().getExternalContext()
	            .invalidateSession();
	    FacesContext.getCurrentInstance().getExternalContext()
	            .redirect("...login.xhtml");

	}
}