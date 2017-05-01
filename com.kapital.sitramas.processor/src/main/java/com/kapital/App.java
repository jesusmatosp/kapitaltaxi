package com.kapital;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.support.ClasspathXmlApplicationContextsFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] springConfig = {
				"spring/batch/config/database.xml",
				"spring/batch/config/context.xml",
				"spring/batch/config/job-report.xml"
		};
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(springConfig);
		JobLauncher jobLauncher = (JobLauncher)
				context.getBean("jobLauncher");
		Job job = (Job) context.getBean("reportJob");
		
		try{
			JobExecution execution = 
					jobLauncher.run(job, new JobParametersBuilder()
							.addString("carga", "d:/temp/csv/programacion_20170412.3.csv")
							.addLong("idProgramacion", 9L)
							.toJobParameters());
			System.out.println("Exit Status: "+execution.getStatus());
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
