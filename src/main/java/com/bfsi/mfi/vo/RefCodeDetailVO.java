package com.bfsi.mfi.vo;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.RefCodeDetail;
import com.bfsi.mfi.util.MessageUtil;

/**
 * @author Bablu kumar
 *
 */
public class RefCodeDetailVO extends MaintenanceVO<RefCodeDetail> {

	public RefCodeDetailVO() {
		entity = new RefCodeDetail();
	}
	
	public RefCodeDetailVO(RefCodeDetail entity) {
		super(entity);
	}
	public String getRefMasterCode() {
		return super.getId();
	}

	public void setRefMasterCode(String refMasterCode) {
		super.setId(refMasterCode);
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
	public String getValidRefdetail() {
		return entity.getValidRefdetail();
	}

	public void setValidRefdetail(String validRefdetail) {
		entity.setValidRefdetail(validRefdetail);
	}
	public String isValidText;
	
	public String getIsValidText() {
		String refId=getValidRefdetail().trim();
		FacesContext context = FacesContext.getCurrentInstance();
	    if ((getValidRefdetail().trim()).equalsIgnoreCase("1")) {
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
	public String getValidRef() {
		return entity.getValidRef();
	}

	public void setValidRef(String validRef) {
		entity.setValidRef(validRef);
	}
	public int getCodeSrNo() {
		return entity.getCodeSrNo();
	}
	public void setCodeSrNo(int codeSrNo) {
		entity.setCodeSrNo(codeSrNo);
	}
}
