package com.bfsi.mfi.vo;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.primefaces.model.StreamedContent;

import com.bfsi.mfi.entity.Customer;


public class CustomerVO extends MaintenanceVO<Customer> {
	/*
	 * private String customerName; private String phoneNumber; private String
	 * city; private String locCode; private String locName; private String
	 * viewFile; private String creditOfficer; private String syncStatus;
	 * private String addressLine1; private String addressLine2; private String
	 * uniqueIdName; private String uniqueIdvalue; private Date dob; private
	 * String sex; private String country; private String state; private Date
	 * syncTime; private String recordStat;
	 */
	// private Blob image;

	//private String syncStatusState;
	//private String syncTimeText;

/*	public String getSyncStatusState() {
		FacesContext context = FacesContext.getCurrentInstance();
		String synccId = getSyncStatus().trim();
		if (synccId.equalsIgnoreCase("A")) {
			syncStatusState = MessageUtil.getMessage(
					"customerMgmt.Acknowleged", context);
			return syncStatusState;
		} else if (synccId.equalsIgnoreCase("F")) {
			syncStatusState = MessageUtil.getMessage("customerMgmt.Fail",
					context);
			return syncStatusState;
		} else if (synccId.equalsIgnoreCase("P")) {
			syncStatusState = MessageUtil.getMessage("customerMgmt.Processing",
					context);
			return syncStatusState;
		} else {
			syncStatusState = MessageUtil.getMessage("customerMgmt.Ready",
					context);
			return syncStatusState;
		}
	}

	public void setSyncStatusState(String syncStatusState) {
		this.syncStatusState = syncStatusState;
	}
*/
	
	
	private String dobDateText;
	
	public String getDobDateText() {
		if (getDob() != null) {
			Date dobDate = getDob();
			Format formatter = new SimpleDateFormat("yyyy-MMM-dd");
			String formattedDate = formatter.format(dobDate);
			dobDateText = formattedDate.toString();
			return dobDateText;
		} else {
			dobDateText = "";
			return dobDateText;
		}
	}

	public void setDobDateText(String dobDateText) {
		this.dobDateText = dobDateText;
	}

	
	public String getCustomerFullName() {
		return entity.getCustomerFullName();
	}

	public void setCustomerFullName(String customerFullName) {
		entity.setCustomerFullName(customerFullName);
	}

	public String getCustomerShortName() {
		return entity.getCustomerShortName();
	}

	public void setCustomerShortName(String customerShortName) {
		entity.setCustomerShortName(customerShortName);
	}

	public String getCustomerCategory() {
		return entity.getCustomerCategory();
	}

	public void setCustomerCategory(String customerCategory) {
		entity.setCustomerCategory(customerCategory);
	}

	public String getGender() {
		return entity.getGender();
	}

	public void setGender(String gender) {
		entity.setGender(gender);

	}

	public Date getDob() {
		return entity.getDob();
	}

	public void setDob(Date dob) {
		entity.setDob(dob);

	}

	public Date getCustomerSince() {
		return entity.getCustomerSince();
	}

	public void setCustomerSince(Date customerSince) {
		entity.setCustomerSince(customerSince);
	}

	public String getLocationCode() {
		return entity.getLocationCode();
	}

	public void setLocationCode(String locationCode) {
		entity.setLocationCode(locationCode);
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
		entity.setAddressLine3(addressLine4);
	}

	public String getZipcode() {
		return entity.getZipcode();

	}

	public void setZipcode(String zipcode) {
		entity.setZipcode(zipcode);

	}

	public String getAllocatedAgentId() {
		return entity.getAllocatedAgentId();
	}

	public void setAllocatedAgentId(String allocatedAgentId) {
		entity.setAllocatedAgentId(allocatedAgentId);

	}

	public String getCity() {
		return entity.getCity();
	}

	public void setCity(String city) {
		entity.setCity(city);
	}

	public String getCountry() {
		return entity.getCountry();
	}

	public void setCountry(String country) {
		entity.setCountry(country);

	}

	public String getState() {
		return entity.getState();
	}

	public void setState(String state) {
		entity.setState(state);
	}

	public String getNationality() {
		return entity.getNationality();
	}

	public void setNationality(String nationality) {
		entity.setNationality(nationality);
	}

	public String getLocalBranchCode() {
		return entity.getLocalBranchCode();
	}

	public void setLocalBranchCode(String localBranchCode) {
		entity.setLocalBranchCode(localBranchCode);
	}

	public String getPreferredLanguage() {
		return entity.getPreferredLanguage();
	}

	public void setPreferredLanguage(String preferredLanguage) {
		entity.setPreferredLanguage(preferredLanguage);
	}

	public String getEmailAddress() {
		return entity.getEmailAddress();
	}

	public void setEmailAddress(String emailAddress) {
		entity.setEmailAddress(emailAddress);
	}

	
	public String getMobileNumber() {
		return entity.getMobileNumber();
	}

	public void setMobileNumber(String mobileNumber) {
		entity.setMobileNumber(mobileNumber);
	}

	public String getCreditOfficer() {
		return entity.getCreditOfficer();
	}

	public void setCreditOfficer(String creditOfficer) {
		entity.setCreditOfficer(creditOfficer);
	}

	public String getViewFile() {
		return entity.getViewFile();
	}

	public void setViewFile(String viewFile) {
		entity.setViewFile(viewFile);
	}

	public byte[] getImage() {
		return entity.getImage();
	}

	public void setImage(byte[] image) {
		entity.setImage(image);
	}

	public String getRecordStat() {
		return entity.getRecordStat();
	}

	public void setRecordStat(String recordStat) {
		entity.setRecordStat(recordStat);
	}

	public String getCbsUpldJobId() {
		return entity.getCbsUpldJobId();
	}

	public void setCbsUpldJobId(String cbsUpldJobId) {
		entity.setCbsUpldJobId(cbsUpldJobId);
	}

	/*
	 * public String getSyncStatus() { return entity.getSyncStatus(); }
	 * 
	 * public void setSyncStatus(String syncStatus) {
	 * entity.setSyncStatus(syncStatus); }
	 * 
	 * public String getSyncTime() { return entity.getSyncTime(); }
	 * 
	 * public void setSyncTime(String syncTime) { entity.setSyncTime(syncTime);
	 * }
	 */

	private StreamedContent streamImage;

	public StreamedContent getStreamImage() {
		return streamImage;
	}

	public void setStreamImage(StreamedContent streamImage) {
		this.streamImage = streamImage;
	}

	public CustomerVO() {
		entity = new Customer();
	}

	public CustomerVO(Customer entity) {
		super(entity);
	}

	private List<LoanVO> loanDetails;

	public List<LoanVO> getLoanDetails() {
		return loanDetails;
	}

	public void setLoanDetails(List<LoanVO> loanDetails) {
		this.loanDetails = loanDetails;
	}

	public String getCustomerId() {
		return super.getId();
	}

	public void setCustomerId(String customerId) {
		super.setId(customerId);
	}
	
	
	public String getCbsGroupCode() {
		return entity.getCbsGroupCode();
	}

	public void setCbsGroupCode(String cbsGroupCode) {
		entity.setCbsGroupCode(cbsGroupCode); 
	}

	public String getSmsFromIbs() {
		return entity.getSmsFromIbs();
	}

	public void setSmsFromIbs(String smsFromIbs) {
		entity.setSmsFromIbs(smsFromIbs); 
	}

	public String getSmsFromMbs() {
		return entity.getSmsFromMbs();
	}

	public void setSmsFromMbs(String smsFromMbs) {
		entity.setSmsFromMbs(smsFromMbs);
	}

	public String getCollectKyc() {
		return entity.getCollectKyc();
	}

	public void setCollectKyc(String collectKyc) {
		entity.setCollectKyc(collectKyc); 
	}

	public String getParentCustId() {
		return entity.getParentCustId();
	}

	public void setParentCustId(String parentCustId) {
		entity.setParentCustId(parentCustId); 
	}

	public String getIsParentCust() {
		return entity.getIsParentCust();
	}

	public void setIsParentCust(String isParentCust) {
		entity.setIsParentCust(isParentCust); 
	}

	public String getGroupId() {
		return entity.getGroupId();
	}

	public void setGroupId(String groupId) {
		entity.setGroupId(groupId);
	}
	
/*
	public String getSyncTimeText() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");

		String s = getSyncTime();
		String year = s.substring(0, 4);
		String month = s.substring(4, 6);
		String day = s.substring(6, 8);
		String hours = s.substring(8, 10);
		String minutes = s.substring(10, 12);
		String seconds = s.substring(12, 14);

		int months = Integer.valueOf(month) - 1;
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.valueOf(year), months, Integer.valueOf(day),
				Integer.valueOf(hours), Integer.valueOf(minutes),
				Integer.valueOf(seconds));

		Date dd = cal.getTime();
		String syncTimeText = sdf.format(dd);
		return syncTimeText;
	}

	public void setSyncTimeText(String syncTimeText) {
		this.syncTimeText = syncTimeText;
	}*/
}
