package com.bfsi.mfi.job;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

@Service("jobManager")
public class JobManager {
	//EGA-MN15-000024   START
	final ExecutorService executorService = Executors.newSingleThreadExecutor();
	//EGA-MN15-000024   END

	public void submitTask(JobTask task) {

		try {
			executorService.execute(task);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
