package com.bfsi.mfi.vo;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.Location;
import com.bfsi.mfi.util.MessageUtil;

/**
 * @author bablu
 * 
 */
public class LocationVO extends MaintenanceVO<Location> {
	public LocationVO() {
		entity = new Location();
	}

	public LocationVO(Location entity) {
		super(entity);
	}

	public String getLocationCode() {
		return super.getId();
	}

	public void setLocationCode(String locationCode) {
		super.setId(locationCode);
	}

	public String getLocationDesc() {
		return entity.getLocationDesc() ;
	}

	public void setLocationDesc(String locationDesc) {
		entity.setLocationDesc(locationDesc);
	}

	public String getCbsLocationCode() {
		return entity.getCbsLocationCode();
	}

	public void setCbsLocationCode(String cbsLocationCode) {
		entity.setCbsLocationCode(cbsLocationCode);
	}

	public String getCbsBranchCode() {
		return entity.getCbsBranchCode();
	}

	public void setCbsBranchCode(String cbsBranchCode) {
		entity.setCbsBranchCode(cbsBranchCode);
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
	
	public Object clone() {
		LocationVO copyObj = new LocationVO();
		copyObj.setLocationCode(getLocationCode());
		copyObj.setLocationDesc(getLocationDesc());
		copyObj.setCbsLocationCode(getCbsLocationCode());
		copyObj.setCbsBranchCode(getCbsBranchCode());
		copyObj.setAddress1(getAddress1());
		copyObj.setAddress2(getAddress2());
		copyObj.setAddress3(getAddress3());
		copyObj.setAddress4(getAddress4());
		copyObj.setContactNumber(getContactNumber());
		copyObj.setAuthStatusText(getAuthStatusText());
		copyObj.setIsActive(getIsActive());
		copyObj.setZipCode(getZipCode());
		copyObj.setCity(getCity());
		copyObj.setState(getState());
		copyObj.setCountry(getCountry());
		return copyObj;
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
		

		// for Agency status
		private String locationStatusText;

		public String getlocationStatusText() {
			FacesContext context = FacesContext.getCurrentInstance();
			String devId = getIsActive().trim();
			if (getIsActive().equalsIgnoreCase("A")) {
				locationStatusText = MessageUtil.getMessage("role.active", context);
				return locationStatusText;
			} else if (devId.equalsIgnoreCase("I")) {
				locationStatusText = MessageUtil.getMessage("role.inActive", context);
				return locationStatusText;
			} else {
				locationStatusText = "";
				return locationStatusText;
			}
		}

		public void setLocationStatusText(String locationStatusText) {
			this.locationStatusText = locationStatusText;
		}
		
		/*Tag No: EGA-MN15-000003 Starts*/
		public String getCodeType() {
			return entity.getCodeType();
		}
		public void setCodeType(String codeType) {
			entity.setCodeType(codeType);
		}
		
		public String getCodeValue() {
			return entity.getCodeValue();
		}
		public void setCodeValue(String codeValue) {
			entity.setCodeValue(codeValue);
		}
		
		/*public String getDescription() {
			return entity.getDescription();
		}
		public void setDescription(String description) {
			entity.setDescription(description);
		}*/
		
		public String getIsoEquivalentCode() {
			return entity.getIsoEquivalentCode();
		}
		public void setIsoEquivalentCode(String isoEquivalentCode) {
			entity.setIsoEquivalentCode(isoEquivalentCode);
		}
		/*Tag No: EGA-MN15-000003 Ends*/

}