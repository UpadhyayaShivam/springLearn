//package com.example.users.projectUsers.controller;
//
//import com.example.users.projectUsers.service.CustomerService;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecutionException;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class CustomerController {
//
//
//
//
//    @Autowired
//    private JobLauncher jobLauncher;
//    @Autowired
//    private Job job;
//
//    @Autowired
//    private CustomerService customerService;
////
////    @GetMapping("/batch/run/job")
////    public ResponseEntity<String> runBatchJob(){
////        try{
////            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
////            jobLauncher.run(job,jobParameters);
////            return  ResponseEntity.ok("job is working fine for person,,,,,");
////        }catch (JobExecutionException e){
////            e.printStackTrace();
////            return ResponseEntity.status(500).body("batch job is failed for person : " + e.getMessage() );
////        }
////    }
//
//    @GetMapping("/clearJobExecutions/{jobName}")
//    public String clearJobExecutions(@PathVariable String jobName) {
//        customerService.clearJobExecutions(jobName);
//        return "Job executions cleared for job: " + jobName;
//    }
//
//    @GetMapping("/runJob")
//    public String runJob() {
//        try {
//            customerService.runJob();
//            return "Job run successfully";
//        } catch (Exception e) {
//            return "Failed to run job: " + e.getMessage();
//        }
//    }
//
//    @GetMapping("/restartJob/{jobName}")
//    public String restartJob(@PathVariable String jobName) {
//        try {
//            customerService.restartJob(jobName);
//            return "Job restarted successfully";
//        } catch (Exception e) {
//            return "Failed to restart job: " + e.getMessage();
//        }
//    }
//}
