package com.bfsi.mfi.vo;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.MaintenanceEntity;
import com.bfsi.mfi.util.MessageUtil;

/**
 * Base VO for all maintenance screens
 * 
 * @author arun
 * 
 * @param <T>
 */
public class MaintenanceVO<T extends MaintenanceEntity> 
{
	private static final String AUTH = "auth.Authorized";
	private static final String UNAUTH = "auth.UnAuthorized";

	protected T entity;
	protected String authStatusText;

	public MaintenanceVO() {
		// entity = Activator
	}

	public MaintenanceVO(T entity) {
		this.entity = entity;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public void setId(String id) {
		entity.setId(id);
	}

	public String getId() {
		return entity.getId();
	}

	public String getAuthStatus() {
		return entity.getAuthStatus();
	}

	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus);
	}

	public String getAuthStatusText() {
		authStatusText = getResourceStr(getAuthStatus().equalsIgnoreCase("A") ? AUTH
				: UNAUTH);
		return authStatusText;
	}

	public void setAuthStatusText(String authStatusText) {
		this.authStatusText = authStatusText;
	}

	public String getResourceStr(String key) {
		return MessageUtil.getMessage(key, FacesContext.getCurrentInstance());
	}
}
