package com.bfsi.mfi.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.InitConsole;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ConsoleAdminService;
import com.bfsi.mfi.service.InitConsoleService;
import com.bfsi.mfi.service.SystemParameterService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.EgaCharterVO;
import com.bfsi.mfi.vo.InitConsoleStatusVO;
import com.bfsi.mfi.vo.InitConsoleVO;


/**
 * @className : InitConsoleController.java
 * @description : Controller class for InitConsoleController
 * @author : Nirmal kanna S
 */

@ManagedBean(name = "initConsoleController")
@ViewScoped
public class InitConsoleController extends MaintenanceController<InitConsoleVO, InitConsole>
			implements Serializable
	{
	private static final long serialVersionUID = -8144614324632010903L;

	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	@ManagedProperty(value = "#{initConsoleService}")
	private InitConsoleService initConsoleService;
	

	@ManagedProperty(value = "#{systemParameterService}")
	private SystemParameterService systemParameterService;
	
	public SystemParameterService getSystemParameterService() {
		return systemParameterService;
	}

	public void setSystemParameterService(
			SystemParameterService systemParameterService) {
		this.systemParameterService = systemParameterService;
	}

	public ConsoleAdminService getConsoleAdminService() {
		return consoleAdminService;
	}

	public void setConsoleAdminService(ConsoleAdminService consoleAdminService) {
		this.consoleAdminService = consoleAdminService;
	}

	@ManagedProperty(value = "#{consoleAdminService}")
	private ConsoleAdminService consoleAdminService;
	
	private InitConsoleVO initConsoleVO =new InitConsoleVO();
	private InitConsoleStatusVO initConsoleStatusVO = new InitConsoleStatusVO();
	private String grptext1 = null;	
	public  String checkinUser;
	EgaCharterVO runHas = new EgaCharterVO();
	EgaCharterVO runHasRed =  new EgaCharterVO();
	EgaCharterVO runHasYellow =  new EgaCharterVO();
	
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	
	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}
	 
	public EgaCharterVO getRunHasRed() {
		return runHasRed;
	}

	public void setRunHasRed(EgaCharterVO runHasRed) {
		this.runHasRed = runHasRed;
	}

	public EgaCharterVO getRunHasYellow() {
		return runHasYellow;
	}

	public void setRunHasYellow(EgaCharterVO runHasYellow) {
		this.runHasYellow = runHasYellow;
	}

	public EgaCharterVO getRunHas() {
		return runHas;
	}

	public void setRunHas(EgaCharterVO runHas) {
		this.runHas = runHas;
	}

	public String getCheckinUser() {
		loadCheckinUser();
		return checkinUser;
	}

	public void setCheckinUser(String checkinUser) {
		this.checkinUser = checkinUser;
	}

	public String performAction(String p_charterCode){		
		try {
			ServiceResponse l_res=consoleAdminService.startSubTask(p_charterCode);
			MessageUtil.addMessage(l_res.getMessageCode());
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception", e);
			MessageUtil.addMessage("MFI10001");
		}
		
		return null;
	}
	public String performCheckin(){
		
		try {
			ServiceResponse l_res=consoleAdminService.doConsoleCheckin();
			MessageUtil.addMessage(l_res.getMessageCode());
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception", e);
			MessageUtil.addMessage("MFI10001");
		}
		return null;
	}
	public String performCheckout(){
		
		try {
			ServiceResponse l_res=consoleAdminService.doConsoleCheckout();
			MessageUtil.addMessage(l_res.getMessageCode());
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception", e);
			MessageUtil.addMessage("MFI10001");
		}
		return null;
	}
	
	@PostConstruct
	public void onLoad()
	{
		initConsoleVO.setTgrp1txt1(initConsoleService.cbcConsoleText("TGRP1TXT1"));
		initConsoleVO.setTgrp1txt2(initConsoleService.cbcConsoleText("TGRP1TXT2"));
		initConsoleVO.setTgrp1txt3(initConsoleService.cbcConsoleText("TGRP1TXT3"));
		initConsoleVO.setTgrp1txt4(initConsoleService.cbcConsoleText("TGRP1TXT4"));
		initConsoleVO.setTgrp1txt5(initConsoleService.cbcConsoleText("TGRP1TXT5"));
		initConsoleVO.setTgrp1txt6(initConsoleService.cbcConsoleText("TGRP1TXT6"));
		
		initConsoleVO.setTgrp2txt1(initConsoleService.cbcConsoleText("TGRP2TXT1"));
		initConsoleVO.setTgrp2txt2(initConsoleService.cbcConsoleText("TGRP2TXT2"));
		initConsoleVO.setTgrp2txt3(initConsoleService.cbcConsoleText("TGRP2TXT3"));
		initConsoleVO.setTgrp2txt4(initConsoleService.cbcConsoleText("TGRP2TXT4"));
		
		initConsoleVO.setTgrp3txt1(initConsoleService.cbcConsoleText("TGRP3TXT1"));
		initConsoleVO.setTgrp3txt2(initConsoleService.cbcConsoleText("TGRP3TXT2"));
		initConsoleVO.setTgrp3txt3(initConsoleService.cbcConsoleText("TGRP3TXT3"));
		initConsoleVO.setTgrp3txt4(initConsoleService.cbcConsoleText("TGRP3TXT4"));
		
		initConsoleVO.setTgrp4txt1(initConsoleService.cbcConsoleText("TGRP4TXT1"));
		initConsoleVO.setTgrp4txt2(initConsoleService.cbcConsoleText("TGRP4TXT2"));
		initConsoleVO.setTgrp4txt3(initConsoleService.cbcConsoleText("TGRP4TXT3"));
		initConsoleVO.setTgrp4txt4(initConsoleService.cbcConsoleText("TGRP4TXT4"));
		
		initConsoleVO.setTgrp5txt1(initConsoleService.cbcConsoleText("TGRP5TXT1"));
		initConsoleVO.setTgrp5txt2(initConsoleService.cbcConsoleText("TGRP5TXT2"));
		initConsoleVO.setTgrp5txt3(initConsoleService.cbcConsoleText("TGRP5TXT3"));
		initConsoleVO.setTgrp5txt4(initConsoleService.cbcConsoleText("TGRP5TXT4"));
		
		initConsoleVO.setTgrp6txt1(initConsoleService.cbcConsoleText("TGRP6TXT1"));
		initConsoleVO.setTgrp6txt2(initConsoleService.cbcConsoleText("TGRP6TXT2"));
		initConsoleVO.setTgrp6txt3(initConsoleService.cbcConsoleText("TGRP6TXT3"));
		initConsoleVO.setTgrp6txt4(initConsoleService.cbcConsoleText("TGRP6TXT4"));
		
		initConsoleVO.setTgrp7txt1(initConsoleService.cbcConsoleText("TGRP7TXT1"));
		initConsoleVO.setTgrp7txt2(initConsoleService.cbcConsoleText("TGRP7TXT2"));
		initConsoleVO.setTgrp7txt3(initConsoleService.cbcConsoleText("TGRP7TXT3"));
		initConsoleVO.setTgrp7txt4(initConsoleService.cbcConsoleText("TGRP7TXT4"));
		
		refreshJobStatus();
		
	}
	
	public String btn1Clicked()
	{
		//System.out.println("Button 1 Clicked");
		return null;
	}
	public String btn2Clicked()
	{
		//System.out.println("Button 2 Clicked");
		return null;
	}
	public String btn3Clicked()
	{
		//System.out.println("Button 3 Clicked");
		return null;
	}
	public String btn4Clicked()
	{
		//System.out.println("Button 4 Clicked");
		return null;
	}
	
	public String getGrptext1() {
		return grptext1;
	}

	public void setGrptext1(String grptext1) {
		this.grptext1 = grptext1;
	}

	@Override
	protected InitConsoleService getMaintenanceService() {
		return initConsoleService;
	}

	@Override
	public InitConsoleVO getMaintenanceVO() {
		return initConsoleVO;
	}

	public InitConsoleService getInitConsoleService() {
		return initConsoleService;
	}

	public void setInitConsoleService(InitConsoleService initConsoleService) {
		this.initConsoleService = initConsoleService;
	}

	public InitConsoleVO getInitConsoleVO() {
		return initConsoleVO;
	}

	public void setInitConsoleVO(InitConsoleVO initConsoleVO) {
		this.initConsoleVO = initConsoleVO;
	}
	
	public InitConsoleStatusVO getInitConsoleStatusVO() {
		return initConsoleStatusVO;
	}

	public void setInitConsoleStatusVO(InitConsoleStatusVO initConsoleStatusVO) {
		this.initConsoleStatusVO = initConsoleStatusVO;
	}
	
	public void refreshJobStatus(){
		Map<String,String> jobStatusMap = new HashMap<String,String>();
		try {
			jobStatusMap = initConsoleService.refreshJobStatus();
			if(jobStatusMap!=null){
				java.util.Iterator<Entry<String, String>> entries = jobStatusMap.entrySet().iterator();
				while (entries != null && entries.hasNext()) {
				  Entry thisEntry = (Entry) entries.next();
				  String charterCode = (String) thisEntry.getKey();
				  String  status = (String)thisEntry.getValue();					
				  if(charterCode != null && charterCode.equalsIgnoreCase("MARK_BUSINESS_DATE_UPLOAD")){
					  initConsoleStatusVO.setGrp1Status1(status);
				  } else if(charterCode != null && charterCode.equalsIgnoreCase("MARK_IBS_CLEANUP")){
					  initConsoleStatusVO.setGrp1Status2(status);
				  } else if(charterCode != null && charterCode.equalsIgnoreCase("MARK_STAGE_DATA_UPLOAD")){
					  initConsoleStatusVO.setGrp1Status3(status);
				  } else if(charterCode != null && charterCode.equalsIgnoreCase("MARK_GROUP_1_RESET")){
					  initConsoleStatusVO.setGrp1Status4(status);
				  } else if(charterCode != null && charterCode.equalsIgnoreCase("MARK_IBS_UPLOAD")){
					  initConsoleStatusVO.setGrp2Status1(status);
				  } else if(charterCode != null && charterCode.equalsIgnoreCase("MARK_GROUP_2_RESET")){
					  initConsoleStatusVO.setGrp2Status2(status);
				  } else if(charterCode != null && charterCode.equalsIgnoreCase("MARK_TXN_INPUT")){
					  initConsoleStatusVO.setGrp3Status1(status);
				  } else if(charterCode != null && charterCode.equalsIgnoreCase("MARK_GROUP_3_RESET")){
					  initConsoleStatusVO.setGrp3Status2(status);
				  } else if(charterCode != null && charterCode.equalsIgnoreCase("MARK_START_SERVICES")){
					  initConsoleStatusVO.setGrp4Status1(status);
				  } else if(charterCode != null && charterCode.equalsIgnoreCase("MARK_STOP_SERVICES")){
					  initConsoleStatusVO.setGrp4Status2(status);
				  } else if(charterCode != null && charterCode.equalsIgnoreCase("MARK_STOP_TXN_INPUT")){
					  initConsoleStatusVO.setGrp5Status1(status);
				  } else if(charterCode != null && charterCode.equalsIgnoreCase("MARK_GROUP_5_RESET")){
					  initConsoleStatusVO.setGrp5Status2(status);
				  } else if(charterCode != null && charterCode.equalsIgnoreCase("MARK_STOP_FIN_INPUT")){
					  initConsoleStatusVO.setGrp6Status1(status); 
				  } else if(charterCode != null && charterCode.equalsIgnoreCase("MARK_GROUP_6_RESET")){
					  initConsoleStatusVO.setGrp6Status2(status); 
				  } else if(charterCode != null && charterCode.equalsIgnoreCase("MARK_END_OF_BUSINESS_DAY")){
					  initConsoleStatusVO.setGrp7Status1(status);
				  }  else if(charterCode != null && charterCode.equalsIgnoreCase("MARK_GROUP_7_RESET")){
					  initConsoleStatusVO.setGrp7Status2(status);
				  } 
				} 
			}
		} catch(Exception e){
			LoggerUtil.ibsJobError("ServiceException while Loading refreshJobStatus Method: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		}
		
	
	}
	
	 public void loadCheckinUser(){
		 try {
			 checkinUser = systemParameterService.getCheckedinUser();
			 if(checkinUser != null){				 
				 checkinUser = msg.getString("job.console.checkedin.user") + " :" + checkinUser;
			 } 
			} catch (ServiceException e) {
				LoggerUtil.ibsJobError("ServiceException while getting checkedin user from system parameter : MFI10001",e);
				MessageUtil.addMessage("MFI10001");
			} catch (Exception e) {
				LoggerUtil.ibsJobError("unhandled exception while getting checkedin user from system parameter: MFI10001", e);
				MessageUtil.addMessage("MFI10001");
			}
			
		} 
	 
	 public String checkStatus(String charCode){
			 
			 try {
				 runHas = initConsoleService.getRunHasStatus(charCode);
				} catch (ServiceException e) {
					LoggerUtil.ibsJobError("ServiceException while getting GREEN right : MFI10001",e);
					MessageUtil.addMessage("MFI10001");
				} catch (Exception e) {
					LoggerUtil.ibsJobError("unhandled exception while getting GREEN right : MFI10001", e);
					MessageUtil.addMessage("MFI10001");
				}
			
				if(runHas.getRunStatus().equalsIgnoreCase("C") && runHas.getHasError().equalsIgnoreCase("N")){
				    return "imggreen";
				} else if(runHas.getRunStatus().equalsIgnoreCase("C") && runHas.getHasError().equalsIgnoreCase("Y")){
					return "imgred";
				} else if(runHas.getRunStatus().equalsIgnoreCase("N")){
					return "imgyellow";
				} else if(runHas.getRunStatus().equalsIgnoreCase("R")){
					return "imgprogress";
				} else {
					return "blank";
				}
			}		 	
	 
}