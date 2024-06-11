package com.learningspring.autowire;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component
public class desktop implements machines {
    public void compile(){
        System.out.println("compiling the code .... in desktop");
    }
}
