package com.bfsi.mfi.vo;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.CenterCodes;
import com.bfsi.mfi.util.MessageUtil;

/**
 * @author Bablu kumar
 * 
 */
public class CenterCodesVO extends MaintenanceVO<CenterCodes> {
	public CenterCodesVO() {
		entity = new CenterCodes();
	}

	public CenterCodesVO(CenterCodes entity) {
		super(entity);
	}

	public String getCenterCode() {
		return super.getId();
	}

	public void setCenterCode(String centerCode) {
		super.setId(centerCode);
	}

	public String getCbsCenterCode() {
		return entity.getCbsCenterCode();
	}

	public void setCbsCenterCode(String cbsCenterCode) {
		entity.setCbsCenterCode(cbsCenterCode);
	}

	public String getIbsLocationCode() {
		return entity.getIbsLocationCode();
	}

	public void setIbsLocationCode(String ibsLocationCode) {
		entity.setIbsLocationCode(ibsLocationCode);
	}

	public String getCenterCodeDesc() {
		return entity.getCenterCodeDesc();
	}

	public void setCenterCodeDesc(String centerCodeDesc) {
		entity.setCenterCodeDesc(centerCodeDesc);
	}

	public String getCbsBranchCode() {
		return entity.getCbsBranchCode();
	}

	public void setCbsBranchCode(String cbsBranchCode) {
		entity.setCbsBranchCode(cbsBranchCode);
	}

	public String getContactNumber() {
		return entity.getContactNumber();
	}

	public void setContactNumber(String contactNumber) {
		entity.setContactNumber(contactNumber);
	}

	public boolean getOnSunday() {
		return entity.getOnSunday();
	}

	public void setOnSunday(boolean onSunday) {
		entity.setOnSunday(onSunday);
	}

	public boolean getOnMonday() {
		return entity.getOnMonday();
	}

	public void setOnMonday(boolean onMonday) {
		entity.setOnMonday(onMonday);
	}

	public boolean getOnTuesday() {
		return entity.getOnTuesday();
	}

	public void setOnTuesday(boolean onTuesday) {
		entity.setOnTuesday(onTuesday);
	}
	public boolean getOnWednesday() {
		return entity.getOnWednesday();
	}

	public void setOnWednesday(boolean onWednesday) {
		entity.setOnWednesday(onWednesday);
	}
	public boolean getOnThursday() {
		return entity.getOnThursday();
	}

	public void setOnThursday(boolean onThursday) {
		entity.setOnThursday(onThursday);
	}
	public boolean getOnFriday() {
		return entity.getOnFriday();
	}
	public void setOnFriday(boolean onFriday) {
		entity.setOnFriday(onFriday);
	}
	public boolean getOnSaturday() {
		return entity.getOnSaturday();
	}
	public void setOnSaturday(boolean onSaturday) {
		entity.setOnSaturday(onSaturday);
	}
	public String getAddressLine1() {
		return entity.getAddressLine1();
	}
	public void setAddressLine1(String addressLine1) {
		entity.setAddressLine1(addressLine1);
	}
	public String getAddressLine2() {
		return entity.getAddressLine2();
	}
	public void setAddressLine2(String addressLine2) {
		entity.setAddressLine2(addressLine2);
	}
	public String getAddressLine3() {
		return entity.getAddressLine3();
	}
	public void setAddressLine3(String addressLine3) {
		entity.setAddressLine3(addressLine3);
	}
	public String getAddressLine4() {
		return entity.getAddressLine4();
	}
	public void setAddressLine4(String addressLine4) {
		entity.setAddressLine4(addressLine4);
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
	public String getIsActive() {
		return entity.getIsActive();
	}
	public void setIsActive(String isActive) {
		entity.setIsActive(isActive);
	}
	public String getAuthStatus() {
		return entity.getAuthStatus();
	}
	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus);
	}
	// for RouteCode status
		private String centerStatusText;

		public String getcenterStatusText() {
			FacesContext context = FacesContext.getCurrentInstance();
			String devId = getIsActive().trim();
			if (getIsActive().equalsIgnoreCase("A")) {
				centerStatusText = MessageUtil.getMessage("role.active", context);
				return centerStatusText;
			} else if (devId.equalsIgnoreCase("I")) {
				centerStatusText = MessageUtil.getMessage("role.inActive", context);
				return centerStatusText;
			} else {
				centerStatusText = "";
				return centerStatusText;
			}
		}
		
		public void setCenterStatusText(String centerStatusText) {
			this.centerStatusText = centerStatusText;
		}
		
		public Object clone() {
			CenterCodesVO copyObj = new CenterCodesVO();
			copyObj.setCenterCode(getCenterCode());
			copyObj.setCbsCenterCode(getCbsCenterCode());
			copyObj.setIbsLocationCode(getIbsLocationCode());
			copyObj.setCenterCodeDesc(getCenterCodeDesc());
			copyObj.setCbsBranchCode(getCbsBranchCode());
			copyObj.setContactNumber(getContactNumber());
			copyObj.setOnSunday(getOnSunday());
			copyObj.setOnMonday(getOnMonday());
			copyObj.setOnTuesday(getOnTuesday());
			copyObj.setOnWednesday(getOnWednesday());
			copyObj.setOnThursday(getOnThursday());
			copyObj.setOnFriday(getOnFriday());
			copyObj.setOnSaturday(getOnSaturday());
			copyObj.setAddressLine1(getAddressLine1());
			copyObj.setAddressLine2(getAddressLine2());
			copyObj.setAddressLine3(getAddressLine3());
			copyObj.setAddressLine4(getAddressLine4());
			copyObj.setZipCode(getZipCode());
			copyObj.setCity(getCity());
			copyObj.setState(getState());
			copyObj.setCountry(getCountry());
			copyObj.setIsActive(getIsActive());
			copyObj.setAuthStatusText(getAuthStatusText());
			return copyObj;
		}
		
		// for Week status
				private String sunText;

				public String getsunText() {
					FacesContext context = FacesContext.getCurrentInstance();
					if (getOnSunday() == true) {
						sunText = MessageUtil.getMessage("week.yes", context);
						return sunText;
					} else  {
						sunText = MessageUtil.getMessage("week.no", context);
						return sunText;
					}
				}
				
				public void setSunText(String sunText) {
					this.sunText = sunText;
				}

				private String monText;

				public String getmonText() {
					FacesContext context = FacesContext.getCurrentInstance();
					if (getOnMonday() == true) {
						monText = MessageUtil.getMessage("week.yes", context);
						return monText;
					} else  {
						monText = MessageUtil.getMessage("week.no", context);
						return monText;
					}
				}
				
				public void setMonText(String monText) {
					this.monText = monText;
				}
				
				private String tueText;

				public String gettueText() {
					FacesContext context = FacesContext.getCurrentInstance();
					if (getOnTuesday() == true) {
						tueText = MessageUtil.getMessage("week.yes", context);
						return tueText;
					} else  {
						tueText = MessageUtil.getMessage("week.no", context);
						return tueText;
					}
				}
				
				public void setTueText(String tueText) {
					this.tueText = tueText;
				}
				
				private String wedText;

				public String getwedText() {
					FacesContext context = FacesContext.getCurrentInstance();
					if (getOnWednesday() == true) {
						wedText = MessageUtil.getMessage("week.yes", context);
						return wedText;
					} else  {
						wedText = MessageUtil.getMessage("week.no", context);
						return wedText;
					}
				}
				
				public void setWedText(String wedText) {
					this.wedText = wedText;
				}
				
				private String thuText;

				public String getthuText() {
					FacesContext context = FacesContext.getCurrentInstance();
					if (getOnThursday() == true) {
						thuText = MessageUtil.getMessage("week.yes", context);
						return thuText;
					} else  {
						thuText = MessageUtil.getMessage("week.no", context);
						return thuText;
					}
				}
				
				public void setThuText(String thuText) {
					this.thuText = thuText;
				}
				
				private String friText;

				public String getfriText() {
					FacesContext context = FacesContext.getCurrentInstance();
					if (getOnFriday() == true) {
						friText = MessageUtil.getMessage("week.yes", context);
						return friText;
					} else  {
						friText = MessageUtil.getMessage("week.no", context);
						return friText;
					}
				}
				
				public void setFriText(String friText) {
					this.friText = friText;
				}
				
				private String satText;

				public String getsatText() {
					FacesContext context = FacesContext.getCurrentInstance();
					if (getOnSaturday() == true) {
						satText = MessageUtil.getMessage("week.yes", context);
						return satText;
					} else  {
						satText = MessageUtil.getMessage("week.no", context);
						return satText;
					}
				}
				
				public void setSatText(String satText) {
					this.satText = satText;
				}
				
				/*Tag No: EGA-MN15-000004 Starts*/
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
				
				public String getDescription() {
					return entity.getDescription();
				}
				public void setDescription(String description) {
					entity.setDescription(description);
				}
				
				public String getIsoEquivalentCode() {
					return entity.getIsoEquivalentCode();
				}
				public void setIsoEquivalentCode(String isoEquivalentCode) {
					entity.setIsoEquivalentCode(isoEquivalentCode);
				}
				/*Tag No: EGA-MN15-000004 Ends*/
}