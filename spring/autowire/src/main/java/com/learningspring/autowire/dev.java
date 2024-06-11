package com.learningspring.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class dev {

    // field injection
//    @Autowired
//    laptop lap ;

    // constructor injection
//    public dev(laptop lap){
//        System.out.println(" in constructor injection ..");
//        this.lap = lap;
//    }

    // setter injection
//    @Autowired
//    public void setlap (laptop lap ){
//        System.out.println("in setter injection ..");
//        this.lap = lap;
//    }

    @Autowired
    @Qualifier("laptop")
    private machines mch;
    public void did(){
        mch.compile();
        System.out.println("working on project as dev");
    }


}
