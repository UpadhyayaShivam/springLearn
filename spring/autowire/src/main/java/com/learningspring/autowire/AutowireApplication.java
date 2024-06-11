package com.learningspring.autowire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AutowireApplication {

	public static void main(String[] args) {

		 ApplicationContext cntxt =  SpringApplication.run(AutowireApplication.class, args);

		 dev obj = cntxt.getBean(dev.class);
		 obj.did();
	}

}
