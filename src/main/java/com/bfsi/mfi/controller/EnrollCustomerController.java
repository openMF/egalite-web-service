package com.bfsi.mfi.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;
import org.springframework.security.core.userdetails.UserDetails;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.EnrollCustomer;
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.EnrollCustomerService;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.LovDetailService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.CustEnrolBiometricVO;
import com.bfsi.mfi.vo.EnrollCustomerVO;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.LovVO;

@ManagedBean(name = "enrollCustomerController")
@SessionScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "enrichEnrollCustomerDetail"),
		@Permission(type = PermissionType.MODIFY, name = "modifyEnrollmentCustomer"),
		@Permission(type = PermissionType.DELETE, name = "deleteEnrollmentCustomer"),
		@Permission(type = PermissionType.REJECT, name = "rejectEnrollmentCustomer"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authEnrollmentCustomer"),
		@Permission(type = PermissionType.LIST, name = "listEnrollCustomer") })
public class EnrollCustomerController extends
		MaintenanceController<EnrollCustomerVO, EnrollCustomer> implements
		Serializable {
	
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	private static final long serialVersionUID = 700815830664394870L;
	@ManagedProperty(value = "#{enrollCustomerService}")
	private EnrollCustomerService enrollCustomerService;
	private EnrollCustomerVO existing = new EnrollCustomerVO();
	private EnrollCustomerVO enrollCustomer = new EnrollCustomerVO();
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	@ManagedProperty(value = "#{lovDetailService}")
	private LovDetailService lovDetailService;
	//private static String PHOTO = "Photo";
	private CustEnrolBiometricVO custEnrolBiometricVO = new CustEnrolBiometricVO();
	//private List<EnrollCustomerVO> datatList = new ArrayList<EnrollCustomerVO>();
	
	
	
	/*public List<EnrollCustomerVO> getDatatList() {
		return datatList;
	}

	public void setDatatList(List<EnrollCustomerVO> datatList) {
		this.datatList = datatList;
	}*/

	public CustEnrolBiometricVO getCustEnrolBiometricVO() {
		return custEnrolBiometricVO;
	}

	public void setCustEnrolBiometricVO(CustEnrolBiometricVO custEnrolBiometricVO) {
		this.custEnrolBiometricVO = custEnrolBiometricVO;
	}

	public LovDetailService getLovDetailService() {
		return lovDetailService;
	}

	public void setLovDetailService(LovDetailService lovDetailService) {
		this.lovDetailService = lovDetailService;
	}

	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}

	/*public boolean isEnriched() {
		//return (enrollCustomer.getEnrichmentStatus() != null);
		return true;
	}*/
	
	/*Tag no : EGA-MN15-000018 Starts */
	private String kycTypeDesc1, kycTypeDesc2, kycTypeDesc3, kycTypeDesc4, kycTypeDesc5, kycTypeDesc6;
	
	public String getKycTypeDesc1() {
		return kycTypeDesc1;
	}

	public void setKycTypeDesc1(String kycTypeDesc1) {
		this.kycTypeDesc1 = kycTypeDesc1;
	}
	
	public String getKycTypeDesc2() {
		return kycTypeDesc2;
	}

	public void setKycTypeDesc2(String kycTypeDesc2) {
		this.kycTypeDesc2 = kycTypeDesc2;
	}

	public String getKycTypeDesc3() {
		return kycTypeDesc3;
	}

	public void setKycTypeDesc3(String kycTypeDesc3) {
		this.kycTypeDesc3 = kycTypeDesc3;
	}

	public String getKycTypeDesc4() {
		return kycTypeDesc4;
	}

	public void setKycTypeDesc4(String kycTypeDesc4) {
		this.kycTypeDesc4 = kycTypeDesc4;
	}

	public String getKycTypeDesc5() {
		return kycTypeDesc5;
	}

	public void setKycTypeDesc5(String kycTypeDesc5) {
		this.kycTypeDesc5 = kycTypeDesc5;
	}

	public String getKycTypeDesc6() {
		return kycTypeDesc6;
	}

	public void setKycTypeDesc6(String kycTypeDesc6) {
		this.kycTypeDesc6 = kycTypeDesc6;
	}
	
	
	/*Tag no : EGA-MN15-000018 End */

	public boolean isEnriched() {
		LoggerUtil.ibsJobDebug("checking isAddAllowed to enrich");
		boolean value = true;
		try {
			if (!checkAuthority(getAddPermissionString())) {
				value = false;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while isEnriched controller: "
							+ this.getClass().getName() + " : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			value = false;
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"unhandled exception while isEnrich controller: "
							+ this.getClass().getName() + " : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			value = false;
		}
		return value;
	}
	
	
	public boolean isNotEnriched() {
		return !isEnriched();
	}

	public boolean isEnrichedAuthorizedRecord(){
		if(enrollCustomer.getWorkFlowQType().equalsIgnoreCase("In Verify Q"))
		{ //Bug-320 part-2 ** if record in verifyQ not allow to enrich....
			return true;
		}else{
			  EnrollCustomerVO vo = getMaintenanceVO();
			if (("A".equals(vo.getAuthStatus()))) {
				// record already Authorized, so dont allow
				return true;
			}
			return false;
		}
	}
	
	/*
	 * public String deleteEnrichment() { super.delete();// For updating the
	 * Ref_stat in view table result = "success"; return result; }
	 */

	private static String result;
	private List<ListValueVO> languages;
	private List<ListValueVO> genders;
	private List<ListValueVO> usertypes;
	/*private List<ListValueVO> homeBranch;
	private List<ListValueVO> custCategory;
	private List<ListValueVO> relOfficer;*/
	//private List<ListValueVO> idType;
	//private List<ListValueVO> prooofType;
	
	private UploadedFile file;
	private List<LovVO> gendersDisp;
	private List<LovVO> residentType;
	private List<LovVO> nationalities;
	private List<LovVO> martialStatuses;
	private List<LovVO> professions;
	private List<LovVO> countries;
	private List<LovVO> idType;
	private List<LovVO> prooofType;
	
	
	public List<LovVO> getIdType() {
		return idType;
	}

	public void setIdType(List<LovVO> idType) {
		this.idType = idType;
	}

	public List<LovVO> getProoofType() {
		return prooofType;
	}

	public void setProoofType(List<LovVO> prooofType) {
		this.prooofType = prooofType;
	}

	public List<LovVO> getCountries() {
		return countries;
	}

	public void setCountries(List<LovVO> countries) {
		this.countries = countries;
	}

	public List<LovVO> getNationalities() {
		return nationalities;
	}

	public void setNationalities(List<LovVO> nationalities) {
		this.nationalities = nationalities;
	}

	public List<LovVO> getMartialStatuses() {
		return martialStatuses;
	}

	public void setMartialStatuses(List<LovVO> martialStatuses) {
		this.martialStatuses = martialStatuses;
	}

	public List<LovVO> getProfessions() {
		return professions;
	}

	public void setProfessions(List<LovVO> professions) {
		this.professions = professions;
	}

	public List<LovVO> getResidentType() {
		return residentType;
	}

	public void setResidentType(List<LovVO> residentType) {
		this.residentType = residentType;
	}

	public List<LovVO> getGendersDisp() {
		return gendersDisp;
	}

	public void setGendersDisp(List<LovVO> gendersDisp) {
		this.gendersDisp = gendersDisp;
	}

	

	/*public List<ListValueVO> getHomeBranch() {
		return homeBranch;
	}

	public void setHomeBranch(List<ListValueVO> homeBranch) {
		this.homeBranch = homeBranch;
	}

	public List<ListValueVO> getCustCategory() {
		return custCategory;
	}

	public void setCustCategory(List<ListValueVO> custCategory) {
		this.custCategory = custCategory;
	}

	public List<ListValueVO> getRelOfficer() {
		return relOfficer;
	}

	public void setRelOfficer(List<ListValueVO> relOfficer) {
		this.relOfficer = relOfficer;
	}*/

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public List<ListValueVO> getLanguages() {
		return languages;
	}

	public void setLanguages(List<ListValueVO> languages) {
		this.languages = languages;
	}

	public List<ListValueVO> getGenders() {
		return genders;
	}

	public void setGenders(List<ListValueVO> genders) {
		this.genders = genders;
	}

	@PostConstruct
	public void init() {
		try {
			LoggerUtil
					.ibsJobDebug("Post Initializing EnrolCustomer Controller");
			
			/*idType = listservice
					.get(ListValue.LIST_NAME_KYCID_TYPES);
			ListOfValuesUtil.addLocaleDescription(idType);
			
			prooofType = listservice
					.get(ListValue.LIST_NAME_KYCPROOF_TYPES);
			ListOfValuesUtil.addLocaleDescription(prooofType);*/
			
			
			/*homeBranch = listservice.get(ListValue.LIST_NAME_AGENT_HOMEBRANCH);
			ListOfValuesUtil.addLocaleDescription(homeBranch);

			custCategory = listservice
					.get(ListValue.LIST_NAME_AGENT_CUST_CATEGORY);
			ListOfValuesUtil.addLocaleDescription(custCategory);

			relOfficer = listservice
					.get(ListValue.LIST_NAME_AGENT_RELATION_OFFICER);
			ListOfValuesUtil.addLocaleDescription(relOfficer);*/
			
			gendersDisp = lovDetailService.getDispValue("GDR01"); //Send ur LovId 
			residentType = lovDetailService.getDispValue("RED01");
			nationalities = lovDetailService.getDispValue("NAT01");
			martialStatuses = lovDetailService.getDispValue("MTS01");
			professions = lovDetailService.getDispValue("PRO01");
			countries = lovDetailService.getDispValue("CN001");
			idType = lovDetailService.getDispValue("KYC01");
			prooofType = lovDetailService.getDispValue("PRT01");
			
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while initializing controller: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		}

	}

	public EnrollCustomerService getEnrollCustomerService() {
		return enrollCustomerService;
	}

	public void setEnrollCustomerService(
			EnrollCustomerService enrollCustomerService) {
		this.enrollCustomerService = enrollCustomerService;
	}

	public EnrollCustomerVO getEnrollCustomer() {
		return enrollCustomer;
	}

	public void setEnrollCustomer(EnrollCustomerVO enrollCustomer) {
		this.enrollCustomer = enrollCustomer;
	}

	public boolean validateEnrollCustomerCode() {
		String enrollCustomerCode = enrollCustomer.getId();
		LoggerUtil.ibsJobDebug("Validating enrol customer code for id: "
				+ enrollCustomerCode);
		try {
			if (!enrollCustomerService
					.isEnrollCustomerCodeAvailable(enrollCustomerCode)) {
				MessageUtil.addMessage("MFI01200");
				return false;
			}
			return true;

		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"ServiceException while validateEnrollCustomerCode: MFI01202 ",
							e);
			MessageUtil.addMessage("MFI01202");
			return false;
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled Exception while validateEnrollCustomerCode: MFI01202 ",
							e);
			MessageUtil.addMessage("MFI01202");
			return false;
		}
	}

	
	public void loadEnrollCustomer() {
		EnrollCustomerVO enrollCustomerVO = new EnrollCustomerVO();
		enrollCustomerVO.setId(enrollCustomer.getId());
		LoggerUtil.ibsJobDebug("Loading enrol customer code for id: "
				+ enrollCustomer.getId());
		try {
			this.enrollCustomer = enrollCustomerService.get(enrollCustomer
					.getId());
			/*Tag no : EGA-MN15-000018 Starts */
			kycTypeDesc1 = enrollCustomerService.getValueKyc(enrollCustomer.getCustEnrolKyc().getKycId1Type(),
					ListValue.LIST_NAME_KYC_TYPE);
			kycTypeDesc2 = enrollCustomerService.getValueKyc(enrollCustomer.getCustEnrolKyc().getKycId1ProofType(),
					ListValue.LIST_NAME_KYC_TYPE_PRT);
			kycTypeDesc3 = enrollCustomerService.getValueKyc(enrollCustomer.getCustEnrolKyc().getKycId2Type(),
					ListValue.LIST_NAME_KYC_TYPE);
			kycTypeDesc4 = enrollCustomerService.getValueKyc(enrollCustomer.getCustEnrolKyc().getKycId2ProofType(),
					ListValue.LIST_NAME_KYC_TYPE_PRT);
			kycTypeDesc5 = enrollCustomerService.getValueKyc(enrollCustomer.getCustEnrolKyc().getKycId3Type(),
					ListValue.LIST_NAME_KYC_TYPE);
			kycTypeDesc6 = enrollCustomerService.getValueKyc(enrollCustomer.getCustEnrolKyc().getKycId3ProofType(),
					ListValue.LIST_NAME_KYC_TYPE_PRT);
			
			/*Tag no : EGA-MN15-000018 Starts */
			
			/*if(enrollCustomer.getGroupIndividualType().equalsIgnoreCase("G")){
			    datatList = enrollCustomerService.getDatatList(enrollCustomer.getTempGroupId());
			}else{
				datatList= null; 
			}*/
			
			loadAndShowAuditTrail(enrollCustomer);
			existing = (EnrollCustomerVO) enrollCustomer.clone();
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while loadEnrollCustomer: MFI10001 ", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled Exception while loadEnrollCustomer: MFI10001 ",
					e);
			MessageUtil.addMessage("MFI10001");
		}
	}
	
	
	
	public void modifyEnrollCustomer() {
		EnrollCustomerVO enrollCustomerVO = new EnrollCustomerVO();
		enrollCustomerVO.setId(enrollCustomer.getId());
		LoggerUtil.ibsJobDebug("Loading enrol customer code for id: "
				+ enrollCustomer.getId());
		try {
			this.enrollCustomer = enrollCustomerService.getModifyRecord(enrollCustomer
					.getId());
			
			/*if(enrollCustomer.getGroupIndividualType().equalsIgnoreCase("G")){
			    datatList = enrollCustomerService.getDatatList(enrollCustomer.getTempGroupId());
			}else{
				datatList= null; 
			}*/
			
			loadAndShowAuditTrail(enrollCustomer);
			existing = (EnrollCustomerVO) enrollCustomer.clone();
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while loadEnrollCustomer: MFI10001 ", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled Exception while loadEnrollCustomer: MFI10001 ",
					e);
			MessageUtil.addMessage("MFI10001");
		}
	}

	/**
	 * For enriching of default values in IBS table.
	 * 
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	public String enrichCustomer() throws ServiceException, IOException {
		LoggerUtil.ibsJobDebug("Starting Erich customer");
		try {
			if (validateEnrollCustomerCode()) {
				super.create();
				result = "success";
			} else {
				result = null;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while enrichCustomer: MFI10001 ", e);
			MessageUtil.addMessage("MFI10001");
			result = null;
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled Exception while enrichCustomer: MFI10001 ", e);
			MessageUtil.addMessage("MFI10001");
			result = null;
		}
		return result;
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	@Override
	protected EnrollCustomerService getMaintenanceService() {
		return enrollCustomerService;
	}

	public List<ListValueVO> getUsertypes() {
		return usertypes;
	}

	public void setUsertypes(List<ListValueVO> usertypes) {
		this.usertypes = usertypes;
	}

	public void upload() {
		if (file != null) {
			try {
				//System.out.println(file.getInputstream());
				if(file.getInputstream() == null)
				{
					LoggerUtil.ibsJobDebug("File is empty.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			FacesMessage msg = new FacesMessage("Succesful", file.getFileName()
					+ " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	@Override
	public EnrollCustomerVO getMaintenanceVO() {
		return enrollCustomer;
	}

	/*public StreamedContent getDocumentContent() {
		LoggerUtil.ibsJobDebug("Starting getDocumentContent");
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest myRequest = (HttpServletRequest) context
					.getExternalContext().getRequest();
			String documentName = (String) myRequest
					.getParameter("documentName");

			if ((documentName == null) || ("".equals(documentName))) {
				documentName = PHOTO;
			}

			if (enrollCustomer.getDocuments() == null) {
				return null;
			}
			Document document = null;//enrollCustomer.getDocuments().get(documentName);

			if (document == null) {
				return null;
			}
			byte[] bytes = document.getDocumentData();

			if (bytes != null) {
				InputStream is = new ByteArrayInputStream(bytes);
				StreamedContent image = new DefaultStreamedContent(is);
				return image;
			}
			return null;

		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"Service Exception while getDocumentContent: MFI01201 ", e);
			MessageUtil.addMessage("MFI01201");

		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled Exception while getDocumentContent: MFI01201 ",
					e);
			MessageUtil.addMessage("MFI01201");

		}
		return null;
	}
*/
	/*public List<Document> getDocumentsForKyc() {
		LoggerUtil.ibsJobDebug("Starting getDocumentsForKyc");
		List<Document> documentsForKyc = new ArrayList<Document>();
		try {
			for (Document doc : enrollCustomer.getDocuments().values()) {
				if (PHOTO.equals(doc.getDocumentName())) {
					continue;
				}
				documentsForKyc.add(doc);
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"Service Exception while getDocumentsForKyc: MFI01201 ", e);
			MessageUtil.addMessage("MFI01201");

		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled Exception while getDocumentsForKyc: MFI01201 ",
					e);
			MessageUtil.addMessage("MFI01201");

		}
		return documentsForKyc;
	}*/

	public String modifyEnroll()  {
		
		////System.out.println("==8888888==="+existing.getCustEnrolKyc().getKycId1ProofType());
		////System.out.println("==999999==="+enrollCustomer.getCustEnrolKyc().getKycId1ProofType());
		
			if (
					!isValueChanged(enrollCustomer.getCustEnrolKyc().getKycId1Type(),existing.getCustEnrolKyc().getKycId1Type()) 
				&&	(!isValueChanged(enrollCustomer.getCustEnrolKyc().getKycId1ProofType(),existing.getCustEnrolKyc().getKycId1ProofType()) )
				&&  (!isValueChanged(enrollCustomer.getCustEnrolKyc().getKycId2Type(),existing.getCustEnrolKyc().getKycId2Type()) )
				&&  (!isValueChanged(enrollCustomer.getCustEnrolKyc().getKycId2ProofType(),existing.getCustEnrolKyc().getKycId2ProofType()) )
				&&  (!isValueChanged(enrollCustomer.getCustEnrolKyc().getKycId3Type(),existing.getCustEnrolKyc().getKycId3Type()) )	
				&&  (!isValueChanged(enrollCustomer.getCustEnrolKyc().getKycId3ProofType(),existing.getCustEnrolKyc().getKycId3ProofType())) 	
				 ){
					
				  MessageUtil.addMessage("MFI01203");
				  return  null;
			}else{
			    super.update();
			    return "success";
			}
			
		//return null;
	}
	
	private boolean isValueChanged(String p_val1, String p_val2){
		
		if(p_val1 == null && p_val2 ==null)
			return false;
		if(p_val1 == null && p_val2 !=null)
			return true;
		if(p_val1 != null && p_val2 ==null)
			return true;
		
		return ! p_val1.equals(p_val2);
	}

	/* When authorization not allowed for Printing . */
	/*public boolean isAuthorizeNotEnable(){
		if("A".equals(enrollCustomer.getAuthStatus()))
			return false;
		else
			return true;
	}*/
	
	//FOR PDF AND EXCEL exporter......
	/*@ManagedProperty(value = "#{auth}")
	protected AuthController authController;*/
	CustomExporterFactory exporterFactory;

	public CustomExporterFactory getExporterFactory() {
		return exporterFactory;
	}

	public void setExporterFactory(CustomExporterFactory exporterFactory) {
		this.exporterFactory = exporterFactory;
	}
	
	 //Rejected logic all.........
		public boolean isRejectAllowed() {
			LoggerUtil.ibsJobDebug("checking isRejectAllowed");
			boolean value = true;
			try {
				if (!checkAuthority(getRejectedPermissionString())) {
					value = false;
				}
			} catch (ServiceException e) {
				LoggerUtil.ibsJobError(
						"ServiceException while isRejectAllowed controller: "
								+ this.getClass().getName() + " : MFI10001", e);
				MessageUtil.addMessage("MFI10001");
				value = false;
			} catch (Exception e) {
				LoggerUtil.ibsJobError(
						"unhandled exception while isRejectAllowed controller: "
								+ this.getClass().getName() + " : MFI10001", e);
				MessageUtil.addMessage("MFI10001");
				value = false;
			}
			return value;
		}
	
			public boolean isRejectEnable() {
				if(enrollCustomer.getWorkFlowQType().equalsIgnoreCase("In Enrich Q"))
				{ //IF record is in enrichQ not able to do Reject ....
					return true;
				}
				 else {
					LoggerUtil.ibsJobDebug("checking isRejectEnable");
					try{
					//V vo = getMaintenanceVO();
						EnrollCustomerVO vo = getMaintenanceVO();
					if (("A".equals(vo.getAuthStatus()))) {
						// record already rejected, so dont allow
						return true;
					}
					// now record is not rejected
					// dont allow maker to reject his own record
					UserDetails loggedInUser = getUserDetails();
					// String userId = getMaker(vo);
					List<String> makerIds = getMaker(vo);
	
					if (makerIds.contains(loggedInUser.getUsername())
							|| getMaintenanceVO().getId().equalsIgnoreCase(
									loggedInUser.getUsername())) {//
						return true;
					}
					}
					catch (ServiceException e) {
						LoggerUtil.ibsJobError(
								"ServiceException while isRejectEnable controller: "
										+ this.getClass().getName() + " : MFI10001", e);
						MessageUtil.addMessage("MFI10001");
					} catch (Exception e) {
						LoggerUtil.ibsJobError(
								"unhandled exception while isRejectEnable controller: "
										+ this.getClass().getName() + " : MFI10001", e);
						MessageUtil.addMessage("MFI10001");
					}
					return false;
				  }
			}
			
			
			public void rejected() {
				LoggerUtil.ibsJobDebug("reject record for controller : "
						+ this.getClass().getName());
				try {
					getMaintenanceService().rejected(getMaintenanceVO());
					MessageUtil.addMessage("MFI10020", getIdForMessage());
				} catch (ServiceException e) {
					LoggerUtil.ibsJobError(
							"ServiceException while rejecteding record: controller: "
									+ this.getClass().getName() + " : MFI10015", e);
					MessageUtil.addMessage("MFI10015");
				} catch (Exception e) {
					LoggerUtil.ibsJobError(
							"unhandled exception while rejecteding record: controller: "
									+ this.getClass().getName() + " : MFI10015", e);
					MessageUtil.addMessage("MFI10015");
				}
			}
			
			//Committed bcz its not used. ==> Changes for Asomi Nirmalkanna S
			/*private boolean isDateChanged(Date newDate,Date existingDate){
				if(newDate ==null && existingDate==null)
					return false;
				if(newDate == null && existingDate!=null)
					return true;
				if(newDate != null && existingDate==null)
					return true;
				return !newDate.equals(existingDate);
			}
	
			*/
			
			@Override
			public boolean isAuthorizeEnable(){
				if(enrollCustomer.getWorkFlowQType().equalsIgnoreCase("In Enrich Q"))
				{ //IF record is in enrichQ not able to do authorize or approved....
					return true;
				}else{
				  return super.isAuthorizeEnable();
				}
			}
			
			
			 public void onTabChanged(String id){
				// //System.out.println("==========enrol id========= ? ? "+id);
				 
				 try {
						this.custEnrolBiometricVO = enrollCustomerService.getBiomatric(id);
						
						//loadAndShowAuditTrail(enrollCustomer);
						//existing = (EnrollCustomerVO) enrollCustomer.clone();
					} catch (ServiceException e) {
						LoggerUtil.ibsJobError(
								"ServiceException while load biometric data: MFI10001 ", e);
						MessageUtil.addMessage("MFI10001");
					} catch (Exception e) {
						LoggerUtil.ibsJobError(
								"Unhandled Exception while load biometric data: MFI10001 ",
								e);
						MessageUtil.addMessage("MFI10001");
					}
			 }
}