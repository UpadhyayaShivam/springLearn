package com.example.users.projectUsers.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling

public class JobScheduler {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job jobForScheduling1;

    @Autowired
    private Job jobForScheduling2;

    @Scheduled(cron =" 0 * * * * * ")
    public  void runjobScheduler1() throws Exception{
        System.out.println("job1");
        jobLauncher.run(jobForScheduling1,new JobParametersBuilder().toJobParameters());
    }

    @Scheduled(cron =" 0 * * * * *")
    public  void runjobScheduler2() throws Exception{
        System.out.println("job2");
        jobLauncher.run(jobForScheduling2,new JobParametersBuilder().toJobParameters());
    }
}
