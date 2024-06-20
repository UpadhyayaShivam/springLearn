package com.example.users.projectUsers;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjectUsersApplication implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job jobForScheduling1;

	@Autowired
	private Job jobForScheduling2;

	public static void main(String[] args) {

		SpringApplication.run(ProjectUsersApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		jobLauncher.run(jobForScheduling1, new JobParametersBuilder()
				.addLong("startTime", System.currentTimeMillis())
				.toJobParameters());

		jobLauncher.run(jobForScheduling2, new JobParametersBuilder()
				.addLong("startTime", System.currentTimeMillis())
				.toJobParameters());
	}

}
