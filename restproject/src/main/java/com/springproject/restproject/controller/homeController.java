package com.springproject.restproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class homeController {

    @RequestMapping("/")
//    @ResponseBody
    public String greet(){
        return "hello , things are working ... 123";

    }
}
