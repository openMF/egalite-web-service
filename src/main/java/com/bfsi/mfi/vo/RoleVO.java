package com.bfsi.mfi.vo;

import java.util.List;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.Role;
import com.bfsi.mfi.util.MessageUtil;
/**
 * Role Value Object to be bound to the screen
 * 
 * @author Jyoti Ranjan
 * 
 */

public class RoleVO extends MaintenanceVO<Role> implements Cloneable {
	public RoleVO() {
		entity = new Role();
	}
	
	public RoleVO(Role entity) {
		super(entity);
	}
	
	private List<FunctionVO> functions;

	public String getRoleName() {
		return entity.getRoleName();
	}

	public void setRoleName(String roleName) {
		entity.setRoleName(roleName); 
	}

	public String getRoleDesc() {
		return entity.getRoleDesc();
	}

	public void setRoleDesc(String roleDesc) {
		entity.setRoleDesc(roleDesc); 
	}
	
	public String getRoleStatus() {
		return entity.getRoleStatus();
	}

	public void setRoleStatus(String roleStatus) {
		entity.setRoleStatus(roleStatus);
	}
	
	public String getRoleType() {
		return entity.getRoleType();
	}

	public void setRoleType(String roleType) {
		entity.setRoleType(roleType);
	}
	
	
	public List<FunctionVO> getFunctions() {
		return functions;
	}

	public void setFunctions(List<FunctionVO> functions) {
		this.functions = functions;
	}

	public Object clone() {

		RoleVO copyObj = new RoleVO();
		copyObj.setId(super.getId());
		copyObj.setRoleName(getRoleName());
		copyObj.setRoleDesc(getRoleDesc());
		copyObj.setAuthStatus(getAuthStatus());
		copyObj.setAuthStatusText(getAuthStatusText());
		copyObj.setFunctions(this.functions);
		copyObj.setRoleType(getRoleType());
		copyObj.setRoleStatus(getRoleStatus());
		copyObj.setRoleType(getRoleType());
		return copyObj;
		/*
		 * try{
		 * 
		 * return super.clone(); }catch(Exception e){ return null; }
		 */
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((super.getId() == null) ? 0 : super.getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleVO other = (RoleVO) obj;
		if (super.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!super.getId().equals(other.getId()))
			return false;
		return true;
	}
// for role status
	private String roleStatusText;
	

	public String getroleStatusText() {
		FacesContext context = FacesContext.getCurrentInstance();
		String devId=getRoleStatus().trim();
		if (getRoleStatus().equalsIgnoreCase("A")) {
			roleStatusText = MessageUtil.getMessage("role.active",context);
			return roleStatusText;
		} else if (devId.equalsIgnoreCase("I")) {
			roleStatusText = MessageUtil.getMessage("role.inActive",context);
			return roleStatusText;
		}
		else {
			roleStatusText = "";
			return roleStatusText;
		} 
	}

	public void setRoleStatusText(String roleStatusText) {
		this.roleStatusText = roleStatusText;
	}

}
