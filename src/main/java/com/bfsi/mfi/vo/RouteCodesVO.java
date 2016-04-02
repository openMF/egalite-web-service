package com.bfsi.mfi.vo;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.RouteCodes;
import com.bfsi.mfi.util.MessageUtil;

/**
 * @author Bablu kumar
 * 
 */
public class RouteCodesVO extends MaintenanceVO<RouteCodes> {
	public RouteCodesVO() {
		entity = new RouteCodes();
	}

	public RouteCodesVO(RouteCodes entity) {
		super(entity);
	}

	public String getRouteCode() {
		return super.getId();
	}

	public void setRouteCode(String routeCode) {
		super.setId(routeCode);
	}

	public String getCbsRouteCode() {
		return entity.getCbsRouteCode();
	}

	public void setCbsRouteCode(String cbsRouteCode) {
		entity.setCbsRouteCode(cbsRouteCode);
	}

	public String getIbsLocationCode() {
		return entity.getIbsLocationCode();
	}

	public void setIbsLocationCode(String ibsLocationCode) {
		entity.setIbsLocationCode(ibsLocationCode);
	}

	public String getRouteCodeDesc() {
		return entity.getRouteCodeDesc();
	}

	public void setRouteCodeDesc(String routeCodeDesc) {
		entity.setRouteCodeDesc(routeCodeDesc);
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
	public String getFrmAddressLine1() {
		return entity.getFrmAddressLine1();
	}
	public void setFrmAddressLine1(String frmAddressLine1) {
		entity.setFrmAddressLine1(frmAddressLine1);
	}
	public String getFrmAddressLine2() {
		return entity.getFrmAddressLine2();
	}
	public void setFrmAddressLine2(String frmAddressLine2) {
		entity.setFrmAddressLine2(frmAddressLine2);
	}
	public String getFrmAddressLine3() {
		return entity.getFrmAddressLine3();
	}
	public void setFrmAddressLine3(String frmAddressLine3) {
		entity.setFrmAddressLine3(frmAddressLine3);
	}
	public String getFrmAddressLine4() {
		return entity.getFrmAddressLine4();
	}
	public void setFrmAddressLine4(String frmAddressLine4) {
		entity.setFrmAddressLine4(frmAddressLine4);
	}
	public String getFrmZipCode() {
		return entity.getFrmZipCode();
	}
	public void setFrmZipCode(String frmZipCode) {
		entity.setFrmZipCode(frmZipCode);
	}
	public String getFrmCity()  {
		return entity.getFrmCity() ;
	}
	public void setFrmCity(String frmCity) {
		entity.setFrmCity(frmCity);
	}
	public String getFrmState() {
		return entity.getFrmState();
	}
	public void setFrmState(String frmState) {
		entity.setFrmState(frmState);
	}
	public String getFrmCountry() {
		return entity.getFrmCountry();
	}
	public void setFrmCountry(String frmCountry) {
		entity.setFrmCountry(frmCountry);
	}
	public String getToAddressLine1() {
		return entity.getToAddressLine1();
	}
	public void setToAddressLine1(String toAddressLine1) {
		entity.setToAddressLine1(toAddressLine1);
	}
	public String getToAddressLine2() {
		return entity.getToAddressLine2();
	}
	public void setToAddressLine2(String toAddressLine2) {
		entity.setToAddressLine2(toAddressLine2);
	}
	public String getToAddressLine3() {
		return entity.getToAddressLine3();
	}
	public void setToAddressLine3(String toAddressLine3) {
		entity.setToAddressLine3(toAddressLine3);
	}
	public String getToAddressLine4() {
		return entity.getToAddressLine4();
	}
	public void setToAddressLine4(String toAddressLine4) {
		entity.setToAddressLine4(toAddressLine4);
		
	}
	public String getToZipCode() {
		return entity.getToZipCode();
	}
	public void setToZipCode(String toZipCode) {
		entity.setToZipCode(toZipCode);
	}
	public String getToCity()  {
		return entity.getToCity() ;
	}
	public void setToCity(String toCity) {
		entity.setToCity(toCity);
	}
	public String getToState() {
		return entity.getToState();
	}
	public void setToState(String toState) {
		entity.setToState(toState);
	}
	public String getToCountry() {
		return entity.getToCountry();
	}
	public void setToCountry(String toCountry) {
		entity.setToCountry(toCountry);
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
	
	public Object clone() {
		RouteCodesVO copyObj = new RouteCodesVO();
		copyObj.setRouteCode(getRouteCode());
		copyObj.setCbsRouteCode(getCbsRouteCode());
		copyObj.setIbsLocationCode(getIbsLocationCode());
		copyObj.setRouteCodeDesc(getRouteCodeDesc());
		copyObj.setCbsBranchCode(getCbsBranchCode());
		copyObj.setContactNumber(getContactNumber());
		copyObj.setOnSunday(getOnSunday());
		copyObj.setOnMonday(getOnMonday());
		copyObj.setOnTuesday(getOnTuesday());
		copyObj.setOnWednesday(getOnWednesday());
		copyObj.setOnThursday(getOnThursday());
		copyObj.setOnFriday(getOnFriday());
		copyObj.setOnSaturday(getOnSaturday());
		copyObj.setFrmAddressLine1(getFrmAddressLine1());
		copyObj.setFrmAddressLine2(getFrmAddressLine2());
		copyObj.setFrmAddressLine3(getFrmAddressLine3());
		copyObj.setFrmAddressLine4(getFrmAddressLine4());
		copyObj.setFrmZipCode(getFrmZipCode());
		copyObj.setFrmCity(getFrmCity());
		copyObj.setFrmState(getFrmState());
		copyObj.setFrmCountry(getFrmCountry());
		copyObj.setToAddressLine1(getToAddressLine1());
		copyObj.setToAddressLine2(getToAddressLine2());
		copyObj.setToAddressLine3(getToAddressLine3());
		copyObj.setToAddressLine4(getToAddressLine4());
		copyObj.setToZipCode(getToZipCode());
		copyObj.setToCity(getToCity());
		copyObj.setToState(getToState());
		copyObj.setToCountry(getToCountry());
		copyObj.setIsActive(getIsActive());
		copyObj.setAuthStatusText(getAuthStatusText());
		return copyObj;
	}
	

	// for RouteCode status
	private String routeStatusText;

	public String getrouteStatusText() {
		FacesContext context = FacesContext.getCurrentInstance();
		String devId = getIsActive().trim();
		if (getIsActive().equalsIgnoreCase("A")) {
			routeStatusText = MessageUtil.getMessage("role.active", context);
			return routeStatusText;
		} else if (devId.equalsIgnoreCase("I")) {
			routeStatusText = MessageUtil.getMessage("role.inActive", context);
			return routeStatusText;
		} else {
			routeStatusText = "";
			return routeStatusText;
		}
	}
	
	public void setRouteStatusText(String routeStatusText) {
		this.routeStatusText = routeStatusText;
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
		
	/*Tag No: EGA-MN15-000002 Starts*/
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
		/*Tag No: EGA-MN15-000002 Ends*/
}