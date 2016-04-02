package com.bfsi.mfi.job;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bfsi.mfi.cbs.adapter.CbsDropListServiceAdapter;
import com.bfsi.mfi.entity.CbsDropList;
import com.bfsi.mfi.service.CbsDropListService;
import com.bfsi.mfi.service.CbsEnrollCustomerService;
import com.bfsi.mfi.service.CbsTransactionService;
import com.bfsi.mfi.service.SystemParameterService;
import com.bfsi.mfi.util.LoggerUtil;

public class TransactionScheduler extends TimerTask {

	private JobManager jobManager;
	
	private CbsTransactionService cbsTransactionService;
	
	private CbsEnrollCustomerService cbsEnrollCustomerService;
	
	private SystemParameterService systemParameterService;
	
	private WebApplicationContext springContext;
	
	public TransactionScheduler(ServletContext p_servletContext){
		springContext =	 WebApplicationContextUtils
				.getWebApplicationContext(p_servletContext);
		jobManager = (JobManager)springContext.getBean("jobManager");
		
		cbsTransactionService= (CbsTransactionService)springContext.getBean("cbsTransactionService");
		cbsEnrollCustomerService= (CbsEnrollCustomerService)springContext.getBean("cbsEnrollCustomerService");
		systemParameterService= (SystemParameterService)springContext.getBean("systemParameterService");
	}
	

	public JobManager getJobManager() {
		return jobManager;
	}

	public void setJobManager(JobManager jobManager) {
		this.jobManager = jobManager;
	}

	@Override
	public void run() {
		LoggerUtil.ibsJobDebug("run()-- Staring the JOB");
		JobTask jobTxnProcess = new JobTask() {
			@Override
			public void run() {
				cbsTransactionService.populateTxnTables();
				cbsTransactionService.process();
			}
		};
		try {
			jobManager.submitTask(jobTxnProcess);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JobTask jobEnrolCust = new JobTask() {
			@Override
			public void run() {
				cbsEnrollCustomerService.processEnrollCustomer();
			}
		};
		try {
			jobManager.submitTask(jobEnrolCust);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void stopJob() {

		systemParameterService.updateSystemParameterFor(
				"IBS_JOB_RUNNING_STATUS", "N");

	}

	public synchronized void startJob() {
		systemParameterService.updateSystemParameterFor(
				"IBS_JOB_RUNNING_STATUS", "Y");
	}
}
