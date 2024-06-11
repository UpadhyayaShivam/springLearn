package com.learnSpring.learntesting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @RequestMapping("/mm")
    public String helloGreet(){
        return "hello , i'm shivam";
    }
}
