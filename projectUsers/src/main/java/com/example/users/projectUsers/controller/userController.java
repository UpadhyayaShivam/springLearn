//package com.example.users.projectUsers.controller;
//
//
//import com.example.users.projectUsers.model.Users;
//import com.example.users.projectUsers.service.userService;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecutionException;
//import org.springframework.batch.core.JobParameter;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class userController {
//
//    @Autowired
//    private JobLauncher jobLauncher;
//
//    @Autowired
//    private Job job;
//
//    private final userService userService;
//    @Autowired
//    public userController(userService userService){
//        this.userService = userService;
//    }
//
////    @GetMapping("/")
////    public String greet(){
////        return "hello im working.";
////    }
//
//    @GetMapping("/")
//    public List<Users> getAllUsers(){
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("/batch/run")
//    public ResponseEntity<String> runBatchJob(){
//        try{
//            JobParameters jobParameters = new JobParameters();
//            jobLauncher.run(job,jobParameters);
//            return ResponseEntity.ok("job is worked fine.");
//
//        }catch (JobExecutionException e){
//                e.printStackTrace();
//                return ResponseEntity.status(500).body("batch job failed : " + e.getMessage());
//        }
//    }
//
//
//}
