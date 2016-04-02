package com.bfsi.mfi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.SystemParameterService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.SystemParameterVO;

@ManagedBean(name = "systemParameterListController")
@ViewScoped
public class SystemParameterListController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@ManagedProperty(value = "#{systemParameterService}")
	private SystemParameterService systemParameterService;
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	private SystemParameterVO systemParameter = new SystemParameterVO();
	private List<SystemParameterVO> systemParamVOs = new ArrayList<SystemParameterVO>();
	private List<SystemParameterVO> existingParamVOs = new ArrayList<SystemParameterVO>();

	public SystemParameterVO getSystemParameter() {
		return systemParameter;
	}

	public void setSystemParameter(SystemParameterVO systemParameter) {
		this.systemParameter = systemParameter;
	}

	public SystemParameterService getSystemParameterService() {
		return systemParameterService;
	}

	public void setSystemParameterService(
			SystemParameterService systemParameterService) {
		this.systemParameterService = systemParameterService;
	}

	public SystemParameterService getService() {
		return systemParameterService;
	}

	@PostConstruct
	public void loadSystemParameter() {
		try {
			systemParamVOs = getService().get();
			// existingParamVOs = getService().get();

		} catch (ServiceException e) {

			LoggerUtil.ibsJobError(
					"ServiceException while loading SystemParameter: MFI10001",
					e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {

			LoggerUtil.ibsJobError(
					"Unexpected error while loading SystemParameter: MFI10001",
					e);
			MessageUtil.addMessage("MFI10001");
		}
		for (SystemParameterVO systemParam : systemParamVOs) {
			existingParamVOs.add((SystemParameterVO) systemParam.clone());
		}
	}

	public List<SystemParameterVO> getExistingParamVOs() {
		return existingParamVOs;
	}

	public void setExistingParamVOs(List<SystemParameterVO> existingParamVOs) {
		this.existingParamVOs = existingParamVOs;
	}

	public String navigateToModifyPage() {
		return "modifySystemParameter";
	}

	public boolean getParameterStatus(SystemParameterVO systemParameter) {

		if (systemParameter.getEditable().equalsIgnoreCase("N"))
			return true;

		return false;
	}

	public List<SystemParameterVO> getSystemParamVOs() {
		return systemParamVOs;
	}

	public void setSystemParamVOs(List<SystemParameterVO> systemParamVOs) {
		this.systemParamVOs = systemParamVOs;
	}

	public String checkModifyForUpdate() {
		int flag = 0;
		if (validateParameterTypes(systemParamVOs) != null) {
			for (int i = 0; i < systemParamVOs.size(); i++) {
				if (systemParamVOs.get(i).getParamValue()
						.equals(existingParamVOs.get(i).getParamValue())) {
					flag = 0;
				} else {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {

				MessageUtil.addMessage("MFI01203");
				return null;
			}
			if (flag == 1) {
				return update(systemParamVOs);
			}
		}
		return null;
	}

	public String update(List<SystemParameterVO> systemParamVOs) {
		if (validateParameterTypes(systemParamVOs) != null) {
			try {
				systemParameterService.updateSystemParam(systemParamVOs);

				LoggerUtil
						.ibsJobDebug("Record for SystemParameter modified successfully: MFI10009");
				MessageUtil.addMessage("MFI10009", "");

				return "success";
			} catch (ServiceException e) {

				LoggerUtil
						.ibsJobError(
								"ServiceException while updating the SystemParameter: MFI10001",
								e);
				MessageUtil.addMessage("MFI10001");
			} catch (Exception e) {

				LoggerUtil
						.ibsJobError(
								"Unexpected error while updating the SystemParameter values: MFI10001",
								e);
				MessageUtil.addMessage("MFI10001");
			}
			return "success";
		}

		return null;
	}

	public String validateParameterTypes(List<SystemParameterVO> systemParamVOs) {
		int paramValue = 0;
		int flagVal = 1;
		for (SystemParameterVO sysvo : systemParamVOs) {

			if (sysvo.getParamType().equalsIgnoreCase("INTEGER"))
				paramValue = 1;
			if (sysvo.getParamType().equalsIgnoreCase("STRING"))
				paramValue = 2;
			if (sysvo.getParamType().equalsIgnoreCase("BOOLEAN"))
				paramValue = 3;
			if (sysvo.getParamType().equalsIgnoreCase("DATE"))
				paramValue = 4;
			if (sysvo.getParamType().equalsIgnoreCase("TIME"))
				paramValue = 5;

			switch (paramValue) {
			case 1:
				try {
					Integer.parseInt(sysvo.getParamValue());
				} catch (NumberFormatException e) {
					MessageUtil.addMessage("MFI00900");
					flagVal = 0;
					LoggerUtil.ibsJobError("NumberFormatException while validating: MFI10001", e);
				}
				break;
			case 2:
				String StrValue = sysvo.getParamValue();
				if (StrValue.length() <= 0) {

					MessageUtil.addMessage("MFI00901");
					flagVal = 0;
				}
				break;
			case 3:
				if (!(sysvo.getParamValue().equalsIgnoreCase("True") | sysvo
						.getParamValue().equalsIgnoreCase("False"))) {

					MessageUtil.addMessage("MFI00902");
					flagVal = 0;
				}
				break;
			case 4:
				String datePattern = "MM/dd/yyyy";
				SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
				sdf.setLenient(false);
				try {
					@SuppressWarnings("unused")
					Date date = sdf.parse(sysvo.getParamValue());
				} catch (ParseException e) {

					MessageUtil.addMessage("MFI00903");
					flagVal = 0;
					LoggerUtil.ibsJobError("ParseException : MFI10001", e);
				}
				break;
			case 5:
				Pattern pattern = Pattern
						.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
				if (!(pattern.matcher(sysvo.getParamValue()).matches())) {

					MessageUtil.addMessage("MFI00904");
					flagVal = 0;
				}
				break;
			default:
				return "success";
			}

		}
		if (flagVal == 0)
			return null;
		else
			return "success";
	}
}
