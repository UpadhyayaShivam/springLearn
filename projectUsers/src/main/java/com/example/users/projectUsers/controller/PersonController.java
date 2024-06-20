//package com.example.users.projectUsers.controller;
//
//
//import com.example.users.projectUsers.model.Person;
//import com.example.users.projectUsers.service.PersonService;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecutionException;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class PersonController {
//
//    @Autowired
//    private JobLauncher jobLauncher;
//    @Autowired
//    private Job job;
//
//    private PersonService personService;
//    @Autowired
//    public PersonController( PersonService personService){
//        this.personService = personService;
//    }
//
////    @GetMapping("/")
////    public String greet(){
////        return "heelo test working";
////    }
////
////    @GetMapping("/person")
////    public List<Person> getAllPerson(){
////        return personService.getAllPerson();
////    }
////
////    @GetMapping("/batch/run/job")
////    public ResponseEntity <String> runBatchJob(){
////        try{
////            JobParameters jobParameters = new JobParameters();
////            jobLauncher.run(job,jobParameters);
////            return  ResponseEntity.ok("job is working fine for person,,,,,");
////        }catch (JobExecutionException e){
////            e.printStackTrace();
////            return ResponseEntity.status(500).body("batch job is failed for person : " + e.getMessage() );
////        }
////    }
//
//
//}
