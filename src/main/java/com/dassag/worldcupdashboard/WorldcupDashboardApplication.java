package com.dassag.worldcupdashboard;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WorldcupDashboardApplication {

	public static void main(String[] args) throws BeansException, JobExecutionAlreadyRunningException,
			JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		ApplicationContext context = SpringApplication.run(WorldcupDashboardApplication.class, args);
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		jobLauncher.run((Job) context.getBean("importWinnerDataJob"), new JobParameters());
		jobLauncher.run((Job) context.getBean("importUserJob"), new JobParameters());

	}

}
