package com.bfsi.mfi.exception;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import com.bfsi.mfi.util.MessageUtil;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {

	/* SOP are Commented ==> Changes for Asomi Nirmal kanna S */

	private final ExceptionHandler wrapped;

	public CustomExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;

	}

	public void handle() throws FacesException {
		final Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator();
		// System.out.println("exception handler");
		while (i.hasNext()) {
			ExceptionQueuedEvent event = i.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			// get the exception from context
			Throwable t = context.getException();
			final FacesContext fc = FacesContext.getCurrentInstance();
			final ExternalContext externalContext = fc.getExternalContext();
			final Map<String, Object> requestMap = fc.getExternalContext().getRequestMap();
			final NavigationHandler nh = fc.getApplication().getNavigationHandler();
			// here you do what ever you want with exception
			try {
				// log error ?
				// System.out.println("excpeion caught");
				// log.log(Level.SEVERE, "Critical Exception!", t);
				// redirect error page
				requestMap.put("exceptionMessage", t.getMessage());
				// nh.handleNavigation(fc, null, "error");
				ExternalContext exC = FacesContext.getCurrentInstance().getExternalContext();
				try {
					exC.redirect("/index.xhtml");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println("navigation done");
				MessageUtil.addErrorMessageWithoutKey("Error Page", "Error", null);
				// fc.renderResponse();
				// remove the comment below if you want to report the error in a
				// jsf error message
				// JsfUtil.addErrorMessage(t.getMessage());
			} finally {
				// remove it from queue
				i.remove();
			}
			break;
		}
		// parent hanle
		// getWrapped().handle();
	}

}