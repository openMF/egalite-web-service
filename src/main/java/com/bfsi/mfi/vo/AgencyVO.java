package com.bfsi.mfi.vo;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.util.MessageUtil;

/**
 * @author bablu
 * 
 */
public class AgencyVO extends MaintenanceVO<Agency> {
	public AgencyVO() {
		entity = new Agency();
	}

	public AgencyVO(Agency entity) {
		super(entity);
	}

	public String getAgencyCode() {
		return super.getId();
	}

	public void setAgencyCode(String agencyCode) {
		super.setId(agencyCode);
	}

	public String getAgencyDesc() {
		return entity.getAgencyDesc();
	}

	public void setAgencyDesc(String agencyDesc) {
		entity.setAgencyDesc(agencyDesc);
	}

	public String getAddress1() {
		return entity.getAddress1();
	}

	public void setAddress1(String address1) {
		entity.setAddress1(address1);
	}

	public String getAddress2() {
		return entity.getAddress2();
	}

	public void setAddress2(String address2) {
		entity.setAddress2(address2);
	}

	public String getAddress3() {
		return entity.getAddress3();
	}

	public void setAddress3(String address3) {
		entity.setAddress3(address3);
	}

	public String getAddress4() {
		return entity.getAddress4();
	}

	public void setAddress4(String address4) {
		entity.setAddress4(address4);
	}

	public String getContactNumber() {
		return entity.getContactNumber();
	}

	public void setContactNumber(String contactNumber) {
		entity.setContactNumber(contactNumber);
	}

	public String getIsActive() {
		return entity.getIsActive();
	}

	public void setIsActive(String isActive) {
		entity.setIsActive(isActive);
	}

	public String getCategory() {
		return entity.getCategory();
	}

	public void setCategory(String category) {
		entity.setCategory(category);
	}
	
	public String getAllocatedCo() {
		return entity.getAllocatedCo();
	}

	public void setAllocatedCo(String allocatedCo) {
		entity.setAllocatedCo(allocatedCo);
	}

	public String getZipCode() {
		return entity.getZipCode();
	}

	public void setZipCode(String zipCode) {
		entity.setZipCode(zipCode);
	}
	
	public String getCity() {
		return entity.getCity();
	}
	public void setCity(String city) {
		entity.setCity(city);
	}
	public String getState() {
		return entity.getState();
	}
	public void setState(String state) {
		entity.setState(state);
	}
	public String getCountry() {
		return entity.getCountry();
	}
	public void setCountry(String country) {
		entity.setCountry(country);
	}
	public String getEmailAddress() {
		return entity.getEmailAddress();
	}
	public void setEmailAddress(String emailAddress) {
		entity.setEmailAddress(emailAddress);
	}
	
	
	public Object clone() {
		AgencyVO copyObj = new AgencyVO();
		copyObj.setAgencyCode(getAgencyCode());
		copyObj.setAgencyDesc(getAgencyDesc());
		copyObj.setAddress1(getAddress1());
		copyObj.setAddress2(getAddress2());
		copyObj.setAddress3(getAddress3());
		copyObj.setAddress4(getAddress4());
		copyObj.setContactNumber(getContactNumber());
		copyObj.setAuthStatusText(getAuthStatusText());
		copyObj.setIsActive(getIsActive());
		copyObj.setCategory(getCategory());
		copyObj.setAllocatedCo(getAllocatedCo());
		copyObj.setZipCode(getZipCode());
		copyObj.setCity(getCity());
		copyObj.setState(getState());
		copyObj.setCountry(getCountry());
		copyObj.setEmailAddress(getEmailAddress());
		return copyObj;
	}

	// for Agency status
	private String agencyStatusText;

	public String getagencyStatusText() {
		FacesContext context = FacesContext.getCurrentInstance();
		String devId = getIsActive().trim();
		if (getIsActive().equalsIgnoreCase("A")) {
			agencyStatusText = MessageUtil.getMessage("role.active", context);
			return agencyStatusText;
		} else if (devId.equalsIgnoreCase("I")) {
			agencyStatusText = MessageUtil.getMessage("role.inActive", context);
			return agencyStatusText;
		} else {
			agencyStatusText = "";
			return agencyStatusText;
		}
	}

	public void setAgencyStatusText(String agencyStatusText) {
		this.agencyStatusText = agencyStatusText;
	}

	// For Agency Category
	private String agencyCategoryText;

	public String getagencyCategoryText() {
		FacesContext context = FacesContext.getCurrentInstance();
		String agnId = getCategory().trim();
		if (getCategory().equalsIgnoreCase("I")) {
			agencyCategoryText = MessageUtil.getMessage("agency.internal", context);
			return agencyCategoryText;
		} else if (agnId.equalsIgnoreCase("E")) {
			agencyCategoryText = MessageUtil.getMessage("agency.external", context);
			return agencyCategoryText;
		} else {
			agencyCategoryText = "";
			return agencyCategoryText;
		}
	}
	public void setAgencyCategoryText(String agencyCategoryText) {
		this.agencyCategoryText = agencyCategoryText;
	}
// for Country codes
	public String getCountryCode() {
		return entity.getCountryCode();
	}
	public void setCountryCode(String countryCode) {
		entity.setCountryCode(countryCode);
	}
	public String getDescription() {
		return entity.getDescription();
	}
	public void setDescription(String description) {
		entity.setDescription(description);
	}
	public String getIso() {
		return entity.getIso();
	}
	public void setIso(String iso) {
		entity.setIso(iso);
	}

}