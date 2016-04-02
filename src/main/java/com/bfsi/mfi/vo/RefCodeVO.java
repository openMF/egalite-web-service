package com.bfsi.mfi.vo;


import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.RefCode;
import com.bfsi.mfi.util.MessageUtil;

/**
 * @author Bablu kumar
 *
 */
public class RefCodeVO extends MaintenanceVO<RefCode> {

	public RefCodeVO() {
		entity = new RefCode();
	}

	public String authStatusText;
	public String isValidText;
	
	public RefCodeVO(RefCode entity) {
		super(entity);
	}
	public String getRefMasterCode() {
		return super.getId();
	}

	public void setRefMasterCode(String refMasterCode) {
		super.setId(refMasterCode);
	}
	public String getCodeDesc() {
		return entity.getCodeDesc();
	}

	public void setCodeDesc(String codeDesc) {
		entity.setCodeDesc(codeDesc);
	}
	
	public String getValidRef() {
		return entity.getValidRef();
	}

	public void setValidRef(String validRef) {
		entity.setValidRef(validRef);
	}
	
	public String getPurpose() {
		return entity.getPurpose();
	}
	public void setPurpose(String purpose) {
		entity.setPurpose(purpose);
	}
	public String getRecordStat() {
		return entity.getRecordStat();
	}
	public void setRecordStat(String recordStat) {
		entity.setRecordStat(recordStat);
	}
	public String getRefDetailCode() {
		return entity.getRefDetailCode();
	}
	public void setRefDetailCode(String refDetailCode){
		entity.setRefDetailCode(refDetailCode);
	}
	public String getDetailCodeDesc() {
		return entity.getDetailCodeDesc();
	}
	public void setDetailCodeDesc(String detailCodeDesc) {
		entity.setDetailCodeDesc(detailCodeDesc);
	}
	public String getTransValueEga() {
		return entity.getTransValueEga();
	}
	public void setTransValueEga(String transValueEga) {
		entity.setTransValueEga(transValueEga);
	}
	public int getTransValueInt() {
		return entity.getTransValueInt();
	}
	public void setTransValueInt(int transValueInt) {
		entity.setTransValueInt(transValueInt);
	}
	public String getIsValid() {
		return entity.getIsValid();
	}
	public void IsValid(String isValid) {
		entity.setIsValid(isValid);
	}
	
	public String getAuthStatusText() {
		FacesContext context = FacesContext.getCurrentInstance();
	    if ((getAuthStatus().trim()).equalsIgnoreCase("A")) {
			authStatusText  =  MessageUtil.getMessage("agent.Authorise",context);
			return authStatusText;
		} else {
			authStatusText  =  MessageUtil.getMessage("agent.UnAuthorise",context);
			return authStatusText;
		}
	}

	public void setAuthStatusText(String authStatusText) {
		this.authStatusText = authStatusText;
	}
	public String getIsValidText() {
		String refId=getValidRef().trim();
		FacesContext context = FacesContext.getCurrentInstance();
	    if ((getValidRef().trim()).equalsIgnoreCase("1")) {
	    	isValidText  =  MessageUtil.getMessage("reference.valid",context);
			return isValidText;
		}  else if (refId.equalsIgnoreCase("2")) {
			isValidText = MessageUtil.getMessage("reference.invalid",context);
			return isValidText;
		}
		else {
			isValidText = "";
			return isValidText;
		} 
	}

	public void setIsValidText(String isValidText) {
		this.isValidText = isValidText;
	}
	

	public Object clone() {
		RefCodeVO copyObj = new RefCodeVO();
		copyObj.setRefMasterCode(getRefMasterCode());
		copyObj.setCodeDesc(getCodeDesc());
		copyObj.setPurpose(getPurpose());
		copyObj.setValidRef(getValidRef());

		return copyObj;
	}
	public int getCodeSrNo() {
		return entity.getCodeSrNo();
	}
	public void setCodeSrNo(int codeSrNo) {
		entity.setCodeSrNo(codeSrNo);
	}
	
	public String getValidRefdetail() {
		return entity.getValidRefdetail();
	}
	public void setValidRefdetail(String validRefdetail) {
		entity.setValidRefdetail(validRefdetail);
	}
}
