package com.bfsi.mfi.vo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.springframework.beans.BeanUtils;

import com.bfsi.mfi.entity.FunctionMbs;
import com.bfsi.mfi.entity.RoleMbs;
import com.bfsi.mfi.util.MessageUtil;
/**
 * RoleMbs Value Object to be bound to the screen
 * 
 * @author Jyoti Ranjan
 * 
 */

public class RoleMbsVO extends MaintenanceVO<RoleMbs> implements Cloneable {
	public RoleMbsVO() {
		entity = new RoleMbs();
	}
	
	public RoleMbsVO(RoleMbs entity) {
		super(entity);
	}
	
	//private List<FunctionMbsVO> functionsmbs;
	//private List<RoleMbsVO> rolesmbsVo;

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
	
	 public List<String> getMbsFns(){
			
			List<String> fns=new ArrayList<String>();
			for(FunctionMbsVO vo:getFunctionsmbs())
				fns.add(vo.getId());
			return fns;
		}
	public void setMbsFns(List<String> p_fns){
		List<FunctionMbsVO> fns=new ArrayList<FunctionMbsVO>();
		
		if(p_fns!=null)
			for(String fo:p_fns){
				FunctionMbsVO	l_vo=new FunctionMbsVO();
				l_vo.setId(fo);
				fns.add(l_vo);
			}
			setFunctionsmbs(fns);
			
		}

	
	public List<FunctionMbsVO> getFunctionsmbs() {
		List<FunctionMbsVO> 	functionsmbs =new ArrayList<FunctionMbsVO>();
		if(entity.getFunctionsmbs()!=null)
		for(FunctionMbs e:entity.getFunctionsmbs()){
			FunctionMbsVO vo=new FunctionMbsVO(e);
			functionsmbs.add(vo);
		}
		return functionsmbs;
	}

	public void setFunctionsmbs(List<FunctionMbsVO> functionsmbs) {
		if(functionsmbs==null)
			return;
		List<FunctionMbs> 	functionsmbsEntity =new ArrayList<FunctionMbs>();
		for(FunctionMbsVO vo:functionsmbs){
			FunctionMbs e=new FunctionMbs();
			BeanUtils.copyProperties(vo, e);
			functionsmbsEntity.add(e);
		}
		entity.setFunctionsmbs(functionsmbsEntity);
	}
	public Object clone() {

		RoleMbsVO copyObj = new RoleMbsVO();
		copyObj.setId(super.getId());
		copyObj.setRoleName(getRoleName());
		copyObj.setRoleDesc(getRoleDesc());
		copyObj.setAuthStatus(getAuthStatus());
		copyObj.setAuthStatusText(getAuthStatusText());
		
		copyObj.setRoleType(getRoleType());
		copyObj.setRoleStatus(getRoleStatus());
		copyObj.setRoleType(getRoleType());
		List<FunctionMbsVO> copyFnVoList=new ArrayList<FunctionMbsVO>();
		if(getFunctionsmbs()!=null)
			for(FunctionMbsVO fnVo:getFunctionsmbs()){
				FunctionMbsVO fnVoCopy=(FunctionMbsVO)fnVo.clone();
				copyFnVoList.add(fnVoCopy);
			}
						
		copyObj.setFunctionsmbs(copyFnVoList);
		return copyObj;
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
		RoleMbsVO other = (RoleMbsVO) obj;
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
