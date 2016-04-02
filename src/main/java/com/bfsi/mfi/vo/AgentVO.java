package com.bfsi.mfi.vo;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.Agent;
import com.bfsi.mfi.util.MessageUtil;

public class AgentVO extends MaintenanceVO<Agent>
{
	private Date minDate;
    private Date maxDate;
    private Date date;
    private String regStatusText;
    private String authStatusText;
    private String agentStatusText;
    private String agentTypeText;
    private String keyExpiryText;
    
    public AgentVO() {
		entity = new Agent();
	}

	public AgentVO(Agent entity) {
		super(entity);
	}
	
	private List<RoleVO> allocatedRoles = new ArrayList<RoleVO>();
	
	
	
	public List<RoleVO> getAllocatedRoles() {
		return allocatedRoles;
	}

	public void setAllocatedRoles(List<RoleVO> allocatedRoles) {
		this.allocatedRoles = allocatedRoles;
	}

	
    
	public String getKeyExpiryText() {
		if (getRegKeyExpiryTime() != null) {
			Date LastSync = getRegKeyExpiryTime();
			Format formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
			String formattedDate = formatter.format(LastSync);
			keyExpiryText = formattedDate.toString();
			return keyExpiryText;
		} else {
			keyExpiryText = "";
			return keyExpiryText;
		}
	}

	public void setKeyExpiryText(String keyExpiryText) {
		this.keyExpiryText = keyExpiryText;
	}
	public String getRegStatus() {
		return entity.getRegStatus();
	}

	public void setRegStatus(String regStatus) {
		entity.setRegStatus(regStatus);
	}

	public String getDataValue() {
		return entity.getDataValue();
	}

	public void setDataValue(String dataValue) {
		entity.setDataValue(dataValue);
	}

	public String getRegKey() {
		return entity.getRegKey();
	}

	public void setRegKey(String regkey) {
		entity.setRegKey(regkey);
	}

	public Date getRegKeyExpiryTime() {
		return entity.getRegKeyExpiryTime();
	}

	public void setRegKeyExpiryTime(Date regKeyExpiryTime) {
		entity.setRegKeyExpiryTime(regKeyExpiryTime);
	}

	public String getUserName() {
		return entity.getUserName();
	}

	public void setUserName(String userName) {
		entity.setUserName(userName);
	}

	@PostConstruct
    public void prepareServices()	{
        this.minDate = new Date();
    }
	
	public String getAuthStatus() {
		return entity.getAuthStatus();
	}

	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus);
	}

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAgentId() {
		return super.getId();
	}
	public void setAgentId(String agentId) {
		super.setId(agentId);
	}
	public String getAgentType() {
		return entity.getAgentType();
	}
	public void setAgentType(String agentType) {
		entity.setAgentType(agentType);
	}
	public String getCreditOfficer() {
		return entity.getCreditOfficer();
	}
	public void setCreditOfficer(String creditOfficer) {
		entity.setCreditOfficer(creditOfficer);
	}
	
	public long getCashLimit() {
		return entity.getCashLimit();
	}

	public void setCashLimit(long cashLimit) {
		entity.setCashLimit(cashLimit);
	}

	public String getDeviceId() {
		return entity.getDeviceId();
	}
	public void setDeviceId(String deviceId) {
		entity.setDeviceId(deviceId);
	}
	public String getIsActive() {
		return entity.getIsActive();
	}
	public void setIsActive(String isActive) {
		entity.setIsActive(isActive);
	}
	public String getFname() {
		return entity.getFname();
	}
	public void setFname(String fname) {
		entity.setFname(fname);
	}
	public String getLname() {
		return entity.getLname();
	}
	public void setLname(String lname) {
		entity.setLname(lname);
	}
	public Date getDob() {
		return entity.getDob();
	}
	public void setDob(Date dob) {
		entity.setDob(dob);
	}
	
	public String getGender() {
		if(entity.getGender() == null){
		  	entity.setGender("1");
		  	return entity.getGender();
		}
		else
			return	entity.getGender();
	}
	
	public void setGender(String gender) {
		entity.setGender(gender);
	}
	
	public String getCommAddr1() {
		return ("".equals(entity.getCommAddr1())) ? "" : entity.getCommAddr1();
	}

	public void setCommAddr1(String commAddr1) {
		entity.setCommAddr1(commAddr1);
	}

	public String getCommAddr2() {
		return ("".equals(entity.getCommAddr2())) ? "" : entity.getCommAddr2();
	}

	public void setCommAddr2(String commAddr2) {
		entity.setCommAddr2(commAddr2);
	}

	public String getCommAddr3() {
		return ("".equals(entity.getCommAddr3())) ? "" : entity.getCommAddr3();
	}

	public void setCommAddr3(String commAddr3) {
		entity.setCommAddr3(commAddr3);
	}

	public String getCommAddr4() {
		return ("".equals(entity.getCommAddr4())) ? "" : entity.getCommAddr4();
	}

	public void setCommAddr4(String commAddr4) {
		entity.setCommAddr4(commAddr4);
	}
	
	
	public String getContactNumber() {
		return entity.getContactNumber();
	}
	public void setContactNumber(String contactNumber) {
		entity.setContactNumber(contactNumber);
	}
	public String getEmailAddress() {
		return entity.getEmailAddress();
	}
	public void setEmailAddress(String emailAddress) {
		entity.setEmailAddress(emailAddress);
	}
	
	public Date getStartDate() {
		return entity.getStartDate();
	}

	public void setStartDate(Date startDate) {
		entity.setStartDate(startDate);
	}

	public Date getEndDate() {
		return entity.getEndDate();
	}

	public void setEndDate(Date endDate) {
		entity.setEndDate(endDate);
	}

	public String getAgentLang() {
		return entity.getAgentLang();
	}
	public void setAgentLang(String agentLang) {
		entity.setAgentLang(agentLang);
	}
	public String getRoleId() {
		return entity.getRoleId();
	}
	public void setRoleId(String roleId) {
		entity.setRoleId(roleId);
	}
	public String getAgencyCode() {
		return entity.getAgencyCode();
	}
	public void setAgencyCode(String agencyCode) {
		entity.setAgencyCode(agencyCode);
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
	public String getLocationCode() {
		return entity.getLocationCode();
	}
	public void setLocationCode(String locationCode){
		entity.setLocationCode(locationCode);
	}
	
	
	public String getRegStatusText() {
		FacesContext context = FacesContext.getCurrentInstance();
	    if ((getRegStatus().trim()).equalsIgnoreCase("R")) {
			regStatusText  = MessageUtil.getMessage("agent.Registered",context);
			return regStatusText;
		} else {
			regStatusText = MessageUtil.getMessage("agent.UnRegistered",context);
			return regStatusText;
		}
	}

	public void setRegStatusText(String regStatusText) {
		this.regStatusText = regStatusText;
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

	public String getAgentStatusText() {
		FacesContext context = FacesContext.getCurrentInstance();
	    if ((getIsActive().trim()).equalsIgnoreCase("A")) {
			agentStatusText  = MessageUtil.getMessage("agent.active",context);
			return agentStatusText;
		} else {
			agentStatusText  = MessageUtil.getMessage("agent.inActive",context);
			return agentStatusText;
		}
	}

	public void setAgentStatusText(String agentStatusText) {
		this.agentStatusText = agentStatusText;
	}

	public String getAgentTypeText() {
		FacesContext context = FacesContext.getCurrentInstance();
	    if ((getAgentType().trim()).equalsIgnoreCase("1")) {
			agentTypeText  = MessageUtil.getMessage("agent.creditOfficer",context);
			return agentTypeText;
		} else {
			agentTypeText  = MessageUtil.getMessage("agent.fieldOfficer",context);
			return agentTypeText;
		}
	}

	public void setAgentTypeText(String agentTypeText) {
		this.agentTypeText = agentTypeText;
	}
	
	public String getExternalDeviceId() {
		return entity.getExternalDeviceId();
	}

	public void setExternalDeviceId(String externalDeviceId) {
		entity.setExternalDeviceId(externalDeviceId); 
	}
	
	
	public Object clone(){  
		
		AgentVO copyObj = new AgentVO();
		copyObj.setDeviceId(this.getDeviceId());
		copyObj.setAgentId(this.getAgentId());
		copyObj.setFname(this.getFname());
		copyObj.setLname(this.getLname());
		copyObj.setCreditOfficer(this.getCreditOfficer());
		copyObj.setDeviceId(this.getDeviceId());
		copyObj.setDob(this.getDob());
		copyObj.setGender(this.getGender());
		copyObj.setIsActive(this.getIsActive());
		copyObj.setAgentType(this.getAgentType());
		copyObj.setCashLimit(this.getCashLimit());
		copyObj.setCommAddr1(this.getCommAddr1());
		copyObj.setCommAddr2(this.getCommAddr2());
		copyObj.setCommAddr3(this.getCommAddr3());
		copyObj.setCommAddr4(this.getCommAddr4());
		copyObj.setContactNumber(this.getContactNumber());
		copyObj.setEmailAddress(this.getEmailAddress());
		copyObj.setStartDate(this.getStartDate());
		copyObj.setEndDate(this.getEndDate());
		copyObj.setAgentLang(this.getAgentLang());
		copyObj.setAgencyCode(this.getAgencyCode());
		copyObj.setAuthStatus(this.getAuthStatus());
		copyObj.setUserName(this.getUserName());
		copyObj.setZipCode(this.getZipCode());
		copyObj.setCity(this.getCity());
		copyObj.setState(this.getState());
		copyObj.setCountry(this.getCountry());
		copyObj.setLocationCode(this.getLocationCode());
		copyObj.setExternalDeviceId(this.getExternalDeviceId());
		
		copyObj.setCbsagentcode(this.getCbsagentcode());
		copyObj.setAgentAccId(this.getAgentAccId());
		
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
		AgentVO other = (AgentVO) obj;
		if (super.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!super.getId().equals(other.getId()))
			return false;
		return true;
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
		
		
		public String getCbsagentcode() {
			return entity.getCbsagentcode();
		}

		public void setCbsagentcode(String cbsagentcode) {
			entity.setCbsagentcode(cbsagentcode);
		}

		public String getAgentAccId() {
			return entity.getAgentAccId();
		}

		public void setAgentAccId(String agentAccId) {
			entity.setAgentAccId(agentAccId);
		}
	
}
