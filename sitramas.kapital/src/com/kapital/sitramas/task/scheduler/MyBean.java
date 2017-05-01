package com.kapital.sitramas.task.scheduler;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.*;*/

@Component("myBean")
public class MyBean {

	/*@Autowired
	private JobLauncher JobLauncher;
	
	@Autowired 
	private Job programacionJob;*/
	
	/*public void printMessage(){
		System.out.println("I am called by Spring scheduler");
		try{
			JobExecution jobExecution = JobLauncher.run(programacionJob, new JobParameters());
			System.out.println(jobExecution.getStatus());
			//System.err.println(jobExecution.get);
			List<Throwable> errores = jobExecution.getFailureExceptions();
			for(Throwable t:errores){
				System.err.println("Error: "+t.getMessage());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
}
