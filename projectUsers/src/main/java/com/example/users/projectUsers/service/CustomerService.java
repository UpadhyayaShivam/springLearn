//package com.example.users.projectUsers.service;
//
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.explore.JobExplorer;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CustomerService    {
//
//    @Autowired
//    private JobLauncher jobLauncher;
//    @Autowired
//    private Job job;
//    @Autowired
//    private JobExplorer jobExplorer;
//
//    @Autowired
//    private JobRepository jobRepository;
//
//    public void clearJobExecutions(String jobName) {
//        List<JobInstance> jobInstances = jobExplorer.findJobInstancesByJobName(jobName, 0, Integer.MAX_VALUE);
//        for (JobInstance jobInstance : jobInstances) {
//            List<JobExecution> jobExecutions = jobExplorer.getJobExecutions(jobInstance);
//            for (JobExecution jobExecution : jobExecutions) {
//                jobRepository.deleteJobExecution(jobExecution);
//            }
//        }
//    }
//
//    public ResponseEntity<String> runJob() throws Exception {
//        try{
//            JobParameters jobParameters = new JobParameters();
//            jobLauncher.run(job,jobParameters);
//            return  ResponseEntity.ok("job is working fine for person,,,,,");
//        }catch (JobExecutionException e){
//            e.printStackTrace();
//            return ResponseEntity.status(500).body("batch job is failed for person : " + e.getMessage() );
//        }
//    }
//
//    public void restartJob(String jobName) throws Exception {
//        // Add logic to restart the job
//    }
//}
