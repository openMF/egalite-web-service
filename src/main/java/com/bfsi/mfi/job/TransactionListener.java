package com.bfsi.mfi.job;

import java.util.Timer;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.service.SystemParameterService;
import com.bfsi.mfi.util.LoggerUtil;

@Service("transactionListener")
public class TransactionListener {
	

	
	private TransactionScheduler transactionScheduler;

	@Autowired
	SystemParameterService systemParameterService;

	private Timer timer;

	public synchronized void startJob(ServletContext p_servletContext) {
	
		String l_jobStatus = String.valueOf(systemParameterService
				.getParamValue("IBS_JOB_RUNNING_STATUS"));
		LoggerUtil.ibsJobDebug("Job Running Status:: - " + l_jobStatus);
		if (l_jobStatus != null && l_jobStatus.equalsIgnoreCase("Y"))
			return;
		transactionScheduler=new TransactionScheduler(p_servletContext);
		transactionScheduler.startJob();
		long l_jobFreq = Long.valueOf(systemParameterService
				.getParamValue("IBS_JOB_FREQ"));

		timer = new Timer(); 
		timer.scheduleAtFixedRate(transactionScheduler, 60000, l_jobFreq);
	}

	public synchronized void stopJob(ServletContext p_servletContext) {
		LoggerUtil.ibsJobDebug("Stopping the Job");
		try {
			Thread.sleep(1000);
			if (timer != null)
				timer.cancel();
			if(transactionScheduler!=null){
				transactionScheduler.cancel();
				transactionScheduler.stopJob();
			}
			else
				(transactionScheduler=new TransactionScheduler(p_servletContext)).stopJob();
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Excpetion while stoppig job", e);
		}
		transactionScheduler=null;
		timer=null;
	}
}
