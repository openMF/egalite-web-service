package com.bfsi.mfi.controller;

/**
 * @className : NavigationController.java
 * @description : Class for Highlight menu item base on Navigation .
 * @author : Jyoti Ranjan Nayak
 */

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "navigationController")
@ViewScoped
public class NavigationController implements Serializable {

	private static final long serialVersionUID = -4648449308779551788L;
	private static final String INDEX = "/index.xhtml";
	
	/**
	 * Which menu item is click that menu item is highlighted. 
	 * 
	 * */
	public boolean checkHighLightMenu(String urlId){
		String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		
		if(! viewId.equalsIgnoreCase(INDEX)){
		String viewMatch = null;
		 
		    Pattern pattern = Pattern.compile("/(.*?)/");
		    Matcher matcher = pattern.matcher(viewId);
		    while (matcher.find()) {
		      viewMatch = matcher.group(1);
		    }
		    
		    return viewMatch.equalsIgnoreCase(urlId);
		    
		}else{
			return false;
		}
	}
}
