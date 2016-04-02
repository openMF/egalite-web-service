package com.bfsi.mfi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Role entity
 * 
 * @author Jyoti Ranjan
 * 
 */

@Entity(name = "MFI_ROLES")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Role extends MaintenanceEntity {

	public Role() {
	}

	private transient List<Function> functions;

	@Column(name = "ROLE_NAME", nullable = false)
	private String roleName;

	@Column(name = "ROLE_DESC", nullable = false)
	private String roleDesc;

	@Column(name = "AUTH_STATUS", nullable = false)
	private String authStatus;
	
	@Column(name = "ROLE_STATUS", nullable = false)
	private String roleStatus;
	
	@Column(name = "ROLE_IBS_MBS", nullable = false)
	private String roleType;


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public List<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}

	public String getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
}
