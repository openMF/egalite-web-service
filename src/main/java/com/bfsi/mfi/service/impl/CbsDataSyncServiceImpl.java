package com.bfsi.mfi.service.impl;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.cbs.adapter.AdapterFactory;
import com.bfsi.mfi.cbs.adapter.CbsActionType;
import com.bfsi.mfi.cbs.adapter.CbsBranchInfoServiceAdapter;
import com.bfsi.mfi.cbs.adapter.CbsBranchSyncServiceAdapter;
import com.bfsi.mfi.cbs.adapter.CbsCcySyncServiceAdapter;
import com.bfsi.mfi.cbs.adapter.CbsCustomerAccSyncServiceAdapter;
import com.bfsi.mfi.cbs.adapter.CbsCustomerSyncServiceAdapter;
import com.bfsi.mfi.cbs.adapter.CbsDepositSyncServiceAdapter;
import com.bfsi.mfi.cbs.adapter.CbsDropListServiceAdapter;
import com.bfsi.mfi.cbs.adapter.CbsFxRatesSyncServiceAdapter;
import com.bfsi.mfi.cbs.adapter.CbsLoanSyncServiceAdapter;
import com.bfsi.mfi.cbs.model.CbsBranch;
import com.bfsi.mfi.cbs.model.CbsCurrency;
import com.bfsi.mfi.cbs.model.CbsCustomer;
import com.bfsi.mfi.cbs.model.CbsDeposit;
import com.bfsi.mfi.cbs.model.CbsDepositActivity;
import com.bfsi.mfi.cbs.model.CbsFxRates;
import com.bfsi.mfi.cbs.model.CbsLoanDetails;
import com.bfsi.mfi.cbs.model.CbsLoanDisbursements;
import com.bfsi.mfi.cbs.model.CbsLoanPaidSchedules;
import com.bfsi.mfi.cbs.model.CbsLoanSchedules;
import com.bfsi.mfi.cbs.request.BranchSyncRequest;
import com.bfsi.mfi.cbs.request.CcySyncRequest;
import com.bfsi.mfi.cbs.request.CustomerAccSyncRequest;
import com.bfsi.mfi.cbs.request.CustomerSyncRequest;
import com.bfsi.mfi.cbs.request.DepositActivitySyncRequest;
import com.bfsi.mfi.cbs.request.DepositActivitySyncResponse;
import com.bfsi.mfi.cbs.request.DepositSyncRequest;
import com.bfsi.mfi.cbs.request.DepositSyncResponse;
import com.bfsi.mfi.cbs.request.FxRatesSyncRequest;
import com.bfsi.mfi.cbs.request.LoanSyncRequest;
import com.bfsi.mfi.cbs.response.BranchSyncResponse;
import com.bfsi.mfi.cbs.response.CcySyncResponse;
import com.bfsi.mfi.cbs.response.CustomerAccSyncResponse;
import com.bfsi.mfi.cbs.response.CustomerSyncResponse;
import com.bfsi.mfi.cbs.response.DropListSyncResponse;
import com.bfsi.mfi.cbs.response.FxRatesSyncResponse;
import com.bfsi.mfi.cbs.response.LoanSyncResponse;
import com.bfsi.mfi.dao.CbsBranchSyncDao;
import com.bfsi.mfi.dao.CbsCcySyncDao;
import com.bfsi.mfi.dao.CbsCustAccountsSyncDao;
import com.bfsi.mfi.dao.CbsCustSyncDao;
import com.bfsi.mfi.dao.CbsDataSyncDao;
import com.bfsi.mfi.dao.CbsDepositSyncDao;
import com.bfsi.mfi.dao.CbsDropListDao;
import com.bfsi.mfi.dao.CbsFxRatesSyncDao;
import com.bfsi.mfi.dao.CbsLoanSyncDao;
import com.bfsi.mfi.dao.SystemParameterDao;
import com.bfsi.mfi.entity.CbsDropList;
import com.bfsi.mfi.entity.StgBranch;
import com.bfsi.mfi.entity.StgCurrency;
import com.bfsi.mfi.entity.StgCustomer;
import com.bfsi.mfi.entity.StgCustomerAccount;
import com.bfsi.mfi.entity.StgDeposit;
import com.bfsi.mfi.entity.StgDepositActivity;
import com.bfsi.mfi.entity.StgFxRates;
import com.bfsi.mfi.entity.StgLoanDetails;
import com.bfsi.mfi.entity.StgLoanDisbursements;
import com.bfsi.mfi.entity.StgLoanPaidSchedules;
import com.bfsi.mfi.entity.StgLoanSchedules;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CbsDataSyncService;
import com.bfsi.mfi.service.CbsDropListService;
import com.bfsi.mfi.util.LoggerUtil;
/**
 * 
 * @author Shabu S Francis
 *
 */
@SuppressWarnings("unused")
@Service("cbsDataSyncService")
public class CbsDataSyncServiceImpl implements CbsDataSyncService {

	@Autowired
	private CbsDepositSyncDao cbsDepositSyncDao;
	
	@Autowired
	private CbsLoanSyncDao cbsLoanSyncDao;
	
	@Autowired
	private CbsBranchSyncDao cbsBranchSyncDao;
	
	@Autowired
	private CbsCustSyncDao cbsCustSyncDao;
	
	@Autowired
	private CbsCcySyncDao cbsCcySyncDao;
	
	@Autowired
	private CbsFxRatesSyncDao cbsFxRatesSyncDao;
	
	@Autowired
	private CbsDataSyncDao cbsDataSyncDao;
	
	@Autowired
	private CbsCustAccountsSyncDao cbsCustAccountsSyncDao;
	
	@Autowired
	private SystemParameterDao systemParameterDao;
	
	@Autowired
	private CbsDropListDao cbsDropListDao;
	
	private static final String MOD_BRANCH="BN";
	private static final String MOD_FXRATE="FX";
	private static final String MOD_CURRENCY="CR";
	private static final String MOD_CUSTOMER="CU";
	private static final String MOD_LOAN="LN";
	private static final String MOD_DEPOSIT="DP";
	private static final String MOD_CUSTACCOUNT="AC";
	
	private static final String TXN_COD_LOAN="000";
	private static final String TXN_COD_LOAN_DIS="L01";
	private static final String TXN_COD_LOAN_REPAY_SCH="L02";
	private static final String TXN_COD_LOAN_PREPAY_SCH="L21";
	private static final String TXN_COD_LOAN_PAID_SCH="L99";
	private static final String TXN_COD_DEPOSIT="000";
	private static final String TXN_COD_DEPOSIT_ACT_COLL="D01";
	private static final String TXN_COD_DEPOSIT_ACT_MATU="D02";
	private static final String TXN_COD_DEPOSIT_ACT_REDE="D03";
	private static final String TXN_COD_CUSTOMER="000";
	private static final String TXN_COD_CUSTOMER_ACC="000";
	private static final String TXN_COD_BRANCH="000";
	private static final String TXN_COD_FXRATE="000";
	private static final String TXN_COD_CURRENCY="000";
	
	private static final String BUSDATE_NAM_SYSPARAM="APP_DATE_TODAY";
	
		
	@Override
	//@Transactional(rollbackFor=Exception.class)
	public void syncCbsData(ServletContext p_servletContext) throws ServiceException {
		
		LoggerUtil.ibsJobDebug("starting cbs job");
		SimpleDateFormat dateformt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//Date jobStartTime = new Date();
		//Date jobEndTime = null;
		String jobId = null;
		//java.util.Date l_cuDtTime=null;
		try {
			//String userId = getLoggedInUserId();
			//jobStartTime = dateformt.parse(dateformt.format(jobStartTime));
			jobId = cbsDataSyncDao.getJobId(); 
			//l_cuDtTime =cbsDataSyncDao.getSysDate();
			//jobId="JOB"+getDateTimeString(l_cuDtTime);
			//cbsDataSyncDao.insertJobId(jobId, userId, jobStartTime);
			syncCbsData(jobId,p_servletContext);
			//jobEndTime = new Date();
			//jobEndTime = dateformt.parse(dateformt.format(jobEndTime));
			//cbsDataSyncDao.updateWithEndTime(jobId, jobEndTime);	
		}
		catch (Exception e) {
			if(jobId!=null)
				resetData(jobId);
			throw new ServiceException("Unhandled Exception while starting Cbs Job :", e);			
		}
		                
	}
	
	
	private void syncCbsData(String p_jobId,ServletContext p_servletContext) throws Exception {
		LoggerUtil.ibsJobDebug("SYNC STARTED");
		CbsBranchInfoServiceAdapter l_adapter=(CbsBranchInfoServiceAdapter) AdapterFactory
				.getAdapter(CbsActionType.CBSBUSINESSDATE);
		l_adapter.setServletContext(p_servletContext);
		java.sql.Date l_businessDate=new java.sql.Date(l_adapter.getBranchDate().getTime());
		systemParameterDao.updateSystemParameterFor(BUSDATE_NAM_SYSPARAM,getDateString(l_businessDate));
		cbsDataSyncDao.resetSyncDetails();
		syncBranch(p_jobId,l_businessDate,p_servletContext);
		syncCurrency(p_jobId,l_businessDate,p_servletContext);
		syncFxRates(p_jobId,l_businessDate,p_servletContext);
		syncCustomers(p_jobId,l_businessDate,p_servletContext);
		syncLoans(p_jobId,l_businessDate,p_servletContext);
		syncDeposits(p_jobId,l_businessDate,p_servletContext);
		syncCustAccounts(p_jobId,l_businessDate,p_servletContext);
		// call local method
		syncDropList(p_jobId,l_businessDate,p_servletContext);
	}
	
	
	private void syncCustAccounts(String p_jobId,Date p_businessDate,ServletContext p_servletContext){
		CustomerAccSyncRequest l_syncReq=new CustomerAccSyncRequest();
		try {
			CbsCustomerAccSyncServiceAdapter l_adapter = (CbsCustomerAccSyncServiceAdapter) AdapterFactory
					.getAdapter(CbsActionType.SYNCCUSTACCOUNTS);
			l_adapter.setServletContext(p_servletContext);
			cbsCustAccountsSyncDao.deleteCustomerAccounts();			
			CustomerAccSyncResponse l_custAccRes=l_adapter.extractCustomerAccounts(l_syncReq);
			if(l_custAccRes.getCustAccList()==null||l_custAccRes.getCustAccList().isEmpty()){
				insertSyncDetails(MOD_CUSTACCOUNT,TXN_COD_CUSTOMER_ACC, p_businessDate, p_jobId,  0);
				return;
			}
			List<StgCustomerAccount> l_cbsCustAccList=new ArrayList<StgCustomerAccount>();
			for(int l_i=0;l_i<l_custAccRes.getCustAccList().size();l_i++){
				StgCustomerAccount l_cbsCustAcc=new StgCustomerAccount();
				BeanUtils.copyProperties(l_custAccRes.getCustAccList().get(l_i), l_cbsCustAcc);
				l_cbsCustAcc.setCbsUploadJobId(p_jobId);
				l_cbsCustAccList.add(l_cbsCustAcc);
			}
			cbsCustAccountsSyncDao.insertCustomerAccounts(l_cbsCustAccList);
			insertSyncDetails(MOD_CUSTACCOUNT,TXN_COD_CUSTOMER_ACC, p_businessDate, p_jobId,  l_cbsCustAccList.size());
						
		} catch (Exception e) {
			throw new ServiceException("Unhandeled Exception while Sync customer accounts from CBS : MFI10001", e);
		}		
	}
	

		private void syncDeposits(String p_jobId,Date p_businessDate,ServletContext p_servletContext) {
		try {
			DepositSyncRequest l_depoReq = new DepositSyncRequest();
			DepositActivitySyncRequest l_depoActivityReq = new DepositActivitySyncRequest();
			List<String> l_deleteList = null;
			List<StgDeposit> l_stgDepositList=new ArrayList<StgDeposit>();
			CbsDepositSyncServiceAdapter l_adapter = (CbsDepositSyncServiceAdapter) AdapterFactory
					.getAdapter(CbsActionType.SYNCDEPOSITS);
			l_adapter.setServletContext(p_servletContext);
			cbsDepositSyncDao.deleteDeposits();
			DepositSyncResponse l_depoRes = l_adapter
					.extractDeposists(l_depoReq);
			if (l_depoRes.getDepositList() != null
					&& !l_depoRes.getDepositList().isEmpty()){
				for(CbsDeposit l_cbsDepo:l_depoRes.getDepositList()){
					StgDeposit l_stgDepo=new StgDeposit();
					BeanUtils.copyProperties(l_cbsDepo, l_stgDepo);
					l_stgDepo.setCbsUploadJobId(p_jobId);
					l_stgDepositList.add(l_stgDepo);
				}
				cbsDepositSyncDao.insertDeposits(l_stgDepositList);
						
			}
			insertSyncDetails(MOD_DEPOSIT,TXN_COD_DEPOSIT, p_businessDate, p_jobId,  l_stgDepositList.size());
			
			cbsDepositSyncDao.deleteDepositActivities();
			 DepositActivitySyncResponse l_depoActivityRes=l_adapter.extractDeposistActivities(l_depoActivityReq);
			 List<StgDepositActivity> l_stgDepoActList=new ArrayList<StgDepositActivity>();
			 int l_coll=0;
			 int l_matu=0;
			 int l_rede=0;
			 if (l_depoActivityRes.getDepositActivityList() != null
						&& !l_depoActivityRes.getDepositActivityList().isEmpty()){	
				 for(CbsDepositActivity l_cbsDepAct:l_depoActivityRes.getDepositActivityList()){
					 StgDepositActivity l_stgDepAct=new StgDepositActivity();
					 BeanUtils.copyProperties(l_cbsDepAct, l_stgDepAct);
					 l_stgDepAct.setCbsUploadJobId(p_jobId);
					 l_stgDepoActList.add(l_stgDepAct);
					 if(l_cbsDepAct.getTxnType().equalsIgnoreCase("D01"))
						 l_coll++;
					 else if(l_cbsDepAct.getTxnType().equalsIgnoreCase("D02"))
						 l_matu++;
					 else if(l_cbsDepAct.getTxnType().equalsIgnoreCase("D03"))
						 l_rede++;
				 }
				 cbsDepositSyncDao.insertDepositActivities(l_stgDepoActList);				
			 }
			
			 insertSyncDetails(MOD_DEPOSIT,TXN_COD_DEPOSIT_ACT_COLL, p_businessDate, p_jobId, l_coll);
			 insertSyncDetails(MOD_DEPOSIT,TXN_COD_DEPOSIT_ACT_MATU, p_businessDate, p_jobId, l_matu);
			 insertSyncDetails(MOD_DEPOSIT,TXN_COD_DEPOSIT_ACT_REDE, p_businessDate, p_jobId,  l_rede);

		} catch (Exception e) {			
			throw new ServiceException("Unhandeled Exception while Sync Deposit from CBS : MFI10001", e);
		}
	}

	private void syncLoans(String p_jobId,Date p_businessDate,ServletContext p_servletContext) {
		try {
			LoanSyncRequest l_loanReq = new LoanSyncRequest();
			List<StgLoanDetails> l_loanList = new ArrayList <StgLoanDetails>();
			List<StgLoanDisbursements> l_loanDisbrList = new ArrayList <StgLoanDisbursements>();
			List<StgLoanPaidSchedules> l_loanPaidSchList = new ArrayList <StgLoanPaidSchedules>();
			List<StgLoanSchedules> l_loanSchList = new ArrayList <StgLoanSchedules>();			
			
			StgLoanDetails l_stgLoan = null;			
			CbsLoanSyncServiceAdapter l_adapter = (CbsLoanSyncServiceAdapter) AdapterFactory
					.getAdapter(CbsActionType.SYNCLOANS);			
			l_adapter.setServletContext(p_servletContext);
			/* Sync Loan Details start */
			cbsLoanSyncDao.deleteLoanDetails();	
			LoanSyncResponse l_loanRes = l_adapter.extractLoans(l_loanReq);				
			if (l_loanRes.getLoanDetails() != null
				&& !l_loanRes.getLoanDetails().isEmpty()){
				for(CbsLoanDetails l_cbsLoan : l_loanRes.getLoanDetails() ){
					l_stgLoan = new StgLoanDetails();
					BeanUtils.copyProperties(l_cbsLoan, l_stgLoan);
					l_stgLoan.setCbsUpldJobId(p_jobId);
					l_loanList.add(l_stgLoan);
				}							
				cbsLoanSyncDao.insertLoanDetails(l_loanList);								
			}
			insertSyncDetails(MOD_LOAN, TXN_COD_LOAN,p_businessDate, p_jobId,  l_loanList.size());
					
			/* Sync Loan Details end */
			
			/* Sync Loan Disbr start */
			cbsLoanSyncDao.deleteLoanDisbr();
			LoanSyncResponse l_loanDisbrRes = l_adapter.extractLoanDisbr(l_loanRes.getLoanDetails(), l_loanReq);
			if (l_loanDisbrRes.getLoanDisbr()!= null
					&& !l_loanDisbrRes.getLoanDisbr().isEmpty()){
				StgLoanDisbursements l_stgLoanDisbr = null;
				for(CbsLoanDisbursements l_cbsLoanDisbr : l_loanDisbrRes.getLoanDisbr() ){
					l_stgLoanDisbr = new StgLoanDisbursements();
					BeanUtils.copyProperties(l_cbsLoanDisbr, l_stgLoanDisbr);
					l_stgLoanDisbr.setCbsUploadJobId(p_jobId);
					l_loanDisbrList.add(l_stgLoanDisbr);
				}				
				cbsLoanSyncDao.insertLoanDisbr(l_loanDisbrList);
				
			}
			insertSyncDetails(MOD_LOAN, TXN_COD_LOAN_DIS,p_businessDate, p_jobId,  l_loanDisbrList.size());
			/* Sync Loan Disbr end */
			
			/* Sync Loan Paid Sch start */
			cbsLoanSyncDao.deleteLoanPaidSch();
			LoanSyncResponse l_paidSchRes = l_adapter.extractLoanPaidSch(l_loanRes.getLoanDetails(), l_loanReq);
			if (l_paidSchRes.getLoanPaidSch()!= null
					&& !l_paidSchRes.getLoanPaidSch().isEmpty()){
				StgLoanPaidSchedules l_stgLoanPaidSch = null;
				for(CbsLoanPaidSchedules l_cbsLoanPaidSch : l_paidSchRes.getLoanPaidSch() ){
					l_stgLoanPaidSch = new StgLoanPaidSchedules();
					BeanUtils.copyProperties(l_cbsLoanPaidSch, l_stgLoanPaidSch);
					l_stgLoanPaidSch.setCbsUpldJobId(p_jobId);
					l_loanPaidSchList.add(l_stgLoanPaidSch);
				}
				cbsLoanSyncDao.insertLoanPaidSch(l_loanPaidSchList);
				
			}
			insertSyncDetails(MOD_LOAN, TXN_COD_LOAN_PAID_SCH,p_businessDate, p_jobId,  l_loanPaidSchList.size());
			/* Sync Loan Paid Sch end */
			
			/* Sync Loan Sch start */
			cbsLoanSyncDao.deleteLoanSch();	
			LoanSyncResponse l_loanSchRes = l_adapter.extractLoanSch(l_loanRes.getLoanDetails(), l_loanReq);
			int l_repay=0;
			int l_prepay=0;
			if (l_loanSchRes.getLoanSch()!= null
					&& !l_loanSchRes.getLoanSch().isEmpty()){
				StgLoanSchedules l_stgLoanSch = null;
				for(CbsLoanSchedules l_cbsLoanSch : l_loanSchRes.getLoanSch() ){
					l_stgLoanSch = new StgLoanSchedules();					
					BeanUtils.copyProperties(l_cbsLoanSch, l_stgLoanSch);					
					l_stgLoanSch.setCbsUploadJobId(p_jobId);
					l_loanSchList.add(l_stgLoanSch);
					if(l_stgLoanSch.getIsFutureSch().equalsIgnoreCase("Y"))
						l_prepay++;
					else
						l_repay++;
				}									
				cbsLoanSyncDao.insertLoanSch(l_loanSchList);				
			}
			insertSyncDetails(MOD_LOAN, TXN_COD_LOAN_REPAY_SCH,p_businessDate, p_jobId,  l_repay);
			insertSyncDetails(MOD_LOAN, TXN_COD_LOAN_PREPAY_SCH,p_businessDate, p_jobId,  l_prepay);
			/* Sync Loan Sch end */
			
			
		} catch (Exception e) {
			throw new ServiceException("Unhandeled Exception while Sync Loan from CBS : MFI10001", e);
		}

	}

	private void syncCurrency(String p_jobId,Date p_businessDate,ServletContext p_servletContext) {
		try {
			CcySyncRequest l_ccyReq = new CcySyncRequest();
			List<StgCurrency> l_ccyList = new ArrayList <StgCurrency>();
			StgCurrency l_stgCcy = null;			
			CbsCcySyncServiceAdapter l_adapter = (CbsCcySyncServiceAdapter) AdapterFactory
					.getAdapter(CbsActionType.SYNCCURRENCY);	
			l_adapter.setServletContext(p_servletContext);
			//cbsCcySyncDao.deleteCcy();	
			CcySyncResponse l_ccyRes = l_adapter.extractCurrency(l_ccyReq);		
			if (l_ccyRes.getCcyList() == null
					|| l_ccyRes.getCcyList().isEmpty()){
				insertSyncDetails(MOD_CURRENCY,TXN_COD_CURRENCY, p_businessDate, p_jobId, 0);
				return;
			}
			for(CbsCurrency l_cbsCcy : l_ccyRes.getCcyList() ){
				l_stgCcy = new StgCurrency();
				BeanUtils.copyProperties(l_cbsCcy, l_stgCcy);
				l_stgCcy.setCbsUploadJobId(p_jobId);
				l_ccyList.add(l_stgCcy);
			}	
			cbsCcySyncDao.deleteCcy(l_ccyList);	
			cbsCcySyncDao.insertCcy(l_ccyList);	
			insertSyncDetails(MOD_CURRENCY,TXN_COD_CURRENCY, p_businessDate, p_jobId, l_ccyList.size());
						
		} catch (Exception e) {
			throw new ServiceException("Unhandeled Exception while Sync Currency from CBS : MFI10001",e);
		}
	}

	private void syncBranch(String p_jobId,Date p_businessDate,ServletContext p_servletContext) {
		
		try {
			BranchSyncRequest l_branReq = new BranchSyncRequest();
			List<StgBranch> l_branList = new ArrayList <StgBranch>();
			StgBranch l_stBranch = null;			
			CbsBranchSyncServiceAdapter l_adapter = (CbsBranchSyncServiceAdapter) AdapterFactory
					.getAdapter(CbsActionType.SYNCBRANCHES);
			l_adapter.setServletContext(p_servletContext);
			//cbsBranchSyncDao.deleteBranch();
			BranchSyncResponse l_branRes = l_adapter.extractBranch(l_branReq);			
			if (l_branRes.getBranchList() == null
					|| l_branRes.getBranchList().isEmpty()){
				insertSyncDetails(MOD_BRANCH,TXN_COD_BRANCH, p_businessDate, p_jobId, 0);
				return;
			}
			for(CbsBranch l_cbsBranch : l_branRes.getBranchList() ){
				l_stBranch = new StgBranch();
				BeanUtils.copyProperties(l_cbsBranch, l_stBranch);
				l_stBranch.setCbsUploadJobId(p_jobId);
				l_branList.add(l_stBranch);
			}
			LoggerUtil.ibsJobDebug("l_branList = " + l_branList.size());
			cbsBranchSyncDao.deleteBranch(l_branList);
			cbsBranchSyncDao.insertBranch(l_branList);	
			insertSyncDetails(MOD_BRANCH, TXN_COD_BRANCH,p_businessDate, p_jobId, l_branList.size());
			
		} catch (Exception e) {
			throw new ServiceException("Unhandeled Exception while Sync Branch from CBS : MFI10001",e);
		}
	}

	private void syncCustomers(String p_jobId,Date p_businessDate,ServletContext p_servletContext) {
		
		try {
			CustomerSyncRequest l_custReq = new CustomerSyncRequest();
			List<StgCustomer> l_custList = new ArrayList <StgCustomer>();
			StgCustomer l_stgCust = null;
			CbsCustomerSyncServiceAdapter l_adapter = (CbsCustomerSyncServiceAdapter) AdapterFactory
					.getAdapter(CbsActionType.SYNCCUSTOMERS);
			l_adapter.setServletContext(p_servletContext);
			cbsCustSyncDao.deleteCustomer();
			CustomerSyncResponse l_custRes = l_adapter.extractCustomer(l_custReq);
			if (l_custRes.getCustList() == null
					|| l_custRes.getCustList().isEmpty()){
				insertSyncDetails(MOD_CUSTOMER,TXN_COD_CUSTOMER, p_businessDate, p_jobId, 0);
				return;
			}
			for(CbsCustomer l_cbsCust : l_custRes.getCustList() ){
				l_stgCust = new StgCustomer();
				BeanUtils.copyProperties(l_cbsCust, l_stgCust);
				l_stgCust.setCbsUploadJobId(p_jobId);
				l_custList.add(l_stgCust);
			}					
			cbsCustSyncDao.insertCustomer(l_custList);
			insertSyncDetails(MOD_CUSTOMER,TXN_COD_CUSTOMER, p_businessDate, p_jobId, l_custList.size());
			
		} catch (Exception e) {
			throw new ServiceException("Unhandeled Exception while Sync Customer from CBS : MFI10001",e);
		}

	}

	private void syncFxRates(String p_jobId,Date p_businessDate,ServletContext p_servletContext) {
		
		try {
			FxRatesSyncRequest l_fxReq = new FxRatesSyncRequest();
			List<StgFxRates> l_fxList = new ArrayList <StgFxRates>();
			StgFxRates l_stgFx = null;
			CbsFxRatesSyncServiceAdapter l_adapter = (CbsFxRatesSyncServiceAdapter) AdapterFactory
					.getAdapter(CbsActionType.SYNCFXRATES);
			l_adapter.setServletContext(p_servletContext);
			cbsFxRatesSyncDao.deleteFxRates();	
			FxRatesSyncResponse l_fxRes = l_adapter.extractFxRates(l_fxReq);
			if (l_fxRes.getFxRatesList() == null
					|| l_fxRes.getFxRatesList().isEmpty()){
				insertSyncDetails(MOD_FXRATE,TXN_COD_FXRATE, p_businessDate, p_jobId, 0);
				return;
			}
			for(CbsFxRates l_cbsFx : l_fxRes.getFxRatesList() ){
				l_stgFx = new StgFxRates();
				BeanUtils.copyProperties(l_cbsFx, l_stgFx);
				l_stgFx.setCbsUploadJobId(p_jobId);
				l_fxList.add(l_stgFx);
			}			
			cbsFxRatesSyncDao.insertFxRates(l_fxList);	
			insertSyncDetails(MOD_FXRATE,TXN_COD_FXRATE, p_businessDate, p_jobId, l_fxList.size());
			
		} catch (Exception e) {
			throw new ServiceException("Unhandeled Exception while Sync Customer from CBS : MFI10001",e);
		}


	}
	
	private void syncDropList(String p_jobId,Date p_businessDate,ServletContext p_servletContext){
		CbsDropList l_syncReq=new CbsDropList();
		try {
			LoggerUtil.ibsJobDebug("Inside syncDropList ================================================= ");
			
			CbsDropListServiceAdapter l_adapter = (CbsDropListServiceAdapter) AdapterFactory
					.getAdapter(CbsActionType.DROPLISTREQUEST);
			l_adapter.setServletContext(p_servletContext);
			
			DropListSyncResponse l_custAccRes=  l_adapter.extractDropList();
			
			if(l_custAccRes.getCbsDropLists() != null || (!l_custAccRes.getCbsDropLists().isEmpty())){
				LoggerUtil.ibsJobDebug("Data setting for Drop List ..........................");
				cbsDropListDao.getCbsDropListValues(l_custAccRes.getCbsDropLists());
			}
						
		} catch (Exception e) {
			throw new ServiceException("Unhandeled Exception while Sync customer accounts from CBS : MFI10001", e);
		}		
	}
	
	
	public String getLoggedInUserId() {
		LoggerUtil.ibsJobDebug("getting legged in user id");
		UserDetails userDetails = getUserDetails();
		return (userDetails != null) ? userDetails.getUsername() : "";
	}

	public UserDetails getUserDetails() {
		LoggerUtil.ibsJobDebug("getting legged in user details");
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal);
		} else {
			return null;
		}
	}
	
	private String getDateTimeString(java.util.Date p_date){
		
		StringBuilder l_builder= new StringBuilder();
		Calendar l_cal=Calendar.getInstance();
		l_cal.setTime(p_date);
		l_builder.append(l_cal.get(Calendar.YEAR));
		l_builder.append((l_cal.get(Calendar.MONTH)+1) <=9?"0"+(l_cal.get(Calendar.MONTH)+1):l_cal.get(Calendar.MONTH)+1);
		l_builder.append(l_cal.get(Calendar.DATE) <=9?"0"+l_cal.get(Calendar.DATE):l_cal.get(Calendar.DATE));
		l_builder.append(l_cal.get(Calendar.HOUR));
		l_builder.append(l_cal.get(Calendar.MINUTE));
		l_builder.append(l_cal.get(Calendar.SECOND));
		l_builder.append(l_cal.get(Calendar.MILLISECOND));
		
		return l_builder.toString();
	}
	private String getDateString(Date p_date){
		
		DateFormat l_df=new SimpleDateFormat("dd-MMM-yyyy");
		return l_df.format(p_date).toUpperCase();
		/*StringBuilder l_builder= new StringBuilder();
		Calendar l_cal=Calendar.getInstance();
		  DateFormatSymbols l_dfs = new DateFormatSymbols();
		l_cal.setTime(p_date);
		l_builder.append(l_cal.get(Calendar.DATE) <=9?"0"+l_cal.get(Calendar.DATE):l_cal.get(Calendar.DATE));
		l_builder.append("-");
		l_builder.append(l_dfs.getShortMonths()[l_cal.get(Calendar.MONTH)].toUpperCase());
		l_builder.append("-");
		l_builder.append(l_cal.get(Calendar.YEAR));
		return l_builder.toString();*/
	}
	private void insertSyncDetails(String p_modCode,String p_txnCode,Date p_busDate,String p_jobId,int p_fectCount){
		java.util.Date l_sysDate=cbsDataSyncDao.getSysDate();
		cbsDataSyncDao.insertSyncJobDetails(p_modCode, p_txnCode, l_sysDate, p_busDate, p_jobId,p_fectCount);
	}
	private void resetData(String p_jobId){
		cbsDepositSyncDao.deleteDepositActivitiesOnError(p_jobId);
		cbsDepositSyncDao.deleteDepositsOnError(p_jobId);
		//cbsBranchSyncDao.deleteBrachOnError(p_jobId);
		//cbsCcySyncDao.deleteCcyOnError(p_jobId);
		cbsCustAccountsSyncDao.deleteCustAccountsOnError(p_jobId);
		cbsFxRatesSyncDao.deleteFxRatesOnError(p_jobId);
		cbsLoanSyncDao.deleteLoanDisbrOnError(p_jobId);
		cbsLoanSyncDao.deleteLoanPaidSchOnError(p_jobId);
		cbsLoanSyncDao.deleteLoanSchOnError(p_jobId);
		cbsLoanSyncDao.deleteLoansOnError(p_jobId);
		cbsCustSyncDao.deleteCustomerOnError(p_jobId);
	}

}
