package com.learningspring.DITest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiTestApplication {

	public static void main(String[] args) {

		ApplicationContext cntxt =  SpringApplication.run(DiTestApplication.class, args);

//		by using context and beans
		testobjviaIOC obj3 = cntxt.getBean(testobjviaIOC.class);
		obj3.build();

//		this will give null pointer exception , means we can't use it directly
//			testobj obj2 = null;
//			obj2.build();


//		here making obj not by ioc
//		testobj obj1 = new testobj();
//		obj1.build();
	}

}
