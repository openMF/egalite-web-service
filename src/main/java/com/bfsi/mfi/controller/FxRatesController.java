package com.bfsi.mfi.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.CBSFxRates;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.FxRatesService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.CBSFxRatesVO;

@ManagedBean(name = "fxRatesController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.LIST, name = "fxRates") })
public class FxRatesController extends MaintenanceController<CBSFxRatesVO, CBSFxRates> {

	@ManagedProperty(value = "#{fxRatesService}")
	private FxRatesService fxRatesService;
	
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	
	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}
	
	private CBSFxRatesVO existing = new CBSFxRatesVO();
	private CBSFxRatesVO cbsFxRates = new CBSFxRatesVO();
	private List<CBSFxRatesVO> CBSFxRatesVOs;
	private List<CBSFxRatesVO> CBSFxRatesCcy1VOs;
	public List<CBSFxRatesVO> getCBSFxRatesCcy1VOs() {
		return CBSFxRatesCcy1VOs;
	}

	public void setCBSFxRatesCcy1VOs(List<CBSFxRatesVO> cBSFxRatesCcy1VOs) {
		CBSFxRatesCcy1VOs = cBSFxRatesCcy1VOs;
	}

	public List<CBSFxRatesVO> getCBSFxRatesCcy2VOs() {
		return CBSFxRatesCcy2VOs;
	}

	public void setCBSFxRatesCcy2VOs(List<CBSFxRatesVO> cBSFxRatesCcy2VOs) {
		CBSFxRatesCcy2VOs = cBSFxRatesCcy2VOs;
	}

	private List<CBSFxRatesVO> CBSFxRatesCcy2VOs;
	
	private double ccy2Amount;
	private double ccy1Amount;
	private double midRate;
	private double sellRate;
	private double buyRate;
	private CBSFxRatesVO obj;
	
	public double getCcy2Amount() {
			//LoggerUtil.cbsJobDebug("ccy2========="+this.cbsFxRates.getCcy2());
		     
		    obj= getRates(this.cbsFxRates.getCcy1(),this.cbsFxRates.getCcy2());
		    LoggerUtil.cbsJobDebug("obj========="+obj);
		    if(obj==null){
		    	midRate = 1.0;
		        sellRate = 1.0;
		        buyRate = 1.0;
		       }
		    else{
			    midRate = obj.getMidRate();
			    sellRate = obj.getSaleRate();
			    buyRate = obj.getBuyRate();
		      }
		    
			//midRate= getMidRate(this.cbsFxRates.getCcy1(),this.cbsFxRates.getCcy2());
			//sellRate = getRates(this.cbsFxRates.getCcy1(),this.cbsFxRates.getCcy2());
			//buyRate =  getBuyRates(this.cbsFxRates.getCcy1(),this.cbsFxRates.getCcy2());
			
			ccy2Amount = (this.ccy1Amount)*(midRate);
			if(Double.isNaN(ccy2Amount))
			  return 0.0;
			else
			   return ccy2Amount;
	 }

	public void setCcy2Amount(double ccy2Amount) {
		this.ccy2Amount = ccy2Amount;
	}

	public double getCcy1Amount() {
		    ccy1Amount = (this.ccy2Amount)/(midRate);
		    
		   if(Double.isNaN(ccy1Amount))
				  return 0.0;
				else
				  return ccy1Amount;
		   
	}

	public void setCcy1Amount(double ccy1Amount) {
		this.ccy1Amount = ccy1Amount;
	}

	@Override
	protected  FxRatesService getMaintenanceService() {
		return fxRatesService;
	}
	
	@Override
	public CBSFxRatesVO getMaintenanceVO() {
		return cbsFxRates;
	}

	public FxRatesService getFxRatesService() {
		return fxRatesService;
	}

	public void setFxRatesService(FxRatesService fxRatesService) {
		this.fxRatesService = fxRatesService;
	}

	public CBSFxRatesVO getCbsFxRates() {
		return cbsFxRates;
	}

	public void setCbsFxRates(CBSFxRatesVO cbsFxRates) {
		this.cbsFxRates = cbsFxRates;
	}

	public List<CBSFxRatesVO> getCBSFxRatesVOs() {
		return CBSFxRatesVOs;
	}

	public void setCBSFxRatesVOs(List<CBSFxRatesVO> cBSFxRatesVOs) {
		CBSFxRatesVOs = cBSFxRatesVOs;
	}

	@PostConstruct
	public void load() {
		try {
			this.CBSFxRatesVOs = fxRatesService.get();
			this.CBSFxRatesCcy1VOs = fxRatesService.getCcy1Rates();
			this.CBSFxRatesCcy2VOs = fxRatesService.getCcy2Rates();
			LoggerUtil.ibsJobDebug("FxRates not  Available: MFI00602****");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while loading FxRates: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {

			LoggerUtil.ibsJobError(
					"Unhandled exception while loading FxRates: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		loadAndShowAuditTrail(cbsFxRates);
		existing = (CBSFxRatesVO) cbsFxRates.clone();
	}

	/*public double getMidRate(String ccy1,String ccy2){
		try{
			if(ccy2== null || ccy1==null)
				return 1.0;
			else
			    return fxRatesService.getMidRate(ccy1,ccy2);
		}catch(ServiceException e){
			LoggerUtil.ibsJobError(
					"ServiceException while loading FxRates: MFI10001", e);
			MessageUtil.addMessage("MFI10001");	
		} catch (Exception e) {

			LoggerUtil.ibsJobError(
					"Unhandled exception while loading FxRates: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		return 0.00;
	}*/
	
	
	public CBSFxRatesVO getRates(String ccy1,String ccy2){
		try{
			if(ccy2== null || ccy1==null)
				return null;
			else
			  return fxRatesService.getRates(ccy1,ccy2);
		}catch(ServiceException e){
			LoggerUtil.ibsJobError(
					"ServiceException while loading FxRates: MFI10001", e);
			MessageUtil.addMessage("MFI10001");	
		} catch (Exception e) {

			LoggerUtil.ibsJobError(
					"Unhandled exception while loading FxRates: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		return null;
	}
	
	/*public double getBuyRates(String ccy1,String ccy2){
		try{
			if(ccy2== null || ccy1==null)
				return 1.0;
			else
			  return fxRatesService.getRates(ccy1,ccy2).getBuyRate();
		}catch(ServiceException e){
			LoggerUtil.ibsJobError(
					"ServiceException while loading FxRates: MFI10001", e);
			MessageUtil.addMessage("MFI10001");	
		} catch (Exception e) {

			LoggerUtil.ibsJobError(
					"Unhandled exception while loading FxRates: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		return 0.0;
	}
	*/
	/*public double youGot(){
		  return getCcy1Amount()* sellRate;
		}*/
	
	/* public double youPay(){
		return getCcy1Amount()* buyRate;
	}
	*/

	public String bigCcy1Amount(){
		return bigAmtConverter(getCcy1Amount());
	}

	
	public String youGot(){
		return bigAmtConverter(getCcy1Amount()* sellRate);
	}
	
	 public String youPay(){
		 return bigAmtConverter(getCcy1Amount()* buyRate);
		}
	
	
	private String bigAmtConverter(double amt) {
		BigDecimal d1= new BigDecimal(amt);
		 DecimalFormat df = new DecimalFormat("#");
		 df.setMaximumFractionDigits(5);
		return df.format(d1);
	}
	 
	 
}
