package org.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext cntxt = new ClassPathXmlApplicationContext("spring.xml");
//        dev obj = (dev) cntxt.getBean("dev");
//        obj.build();
        dev obj1 = (dev) cntxt.getBean("dev1");
        obj1.build();

    }
}
