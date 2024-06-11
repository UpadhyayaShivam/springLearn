package com.learningspring.autowire;

import org.springframework.stereotype.Component;

@Component
public class laptop implements machines {
    public void compile(){
        System.out.println("compiling the code .... in laptop");
    }
}
