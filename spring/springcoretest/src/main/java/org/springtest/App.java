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
//        dev obj = cntxt.getBean(dev.class); //by classs
//        dev obj1 = (dev)cntxt.getBean("dev"); // by id and object casting
//        obj.compile();
//        obj1.compile();
//        System.out.println("helooo");

//        // obj with id dev
//        dev obj = (dev)cntxt.getBean("dev");
//        obj.compile();
////        System.out.println(obj.age);
//        obj.setAge(22);
//        System.out.println(obj.getAge());
//
//        // obj with id dev1
//        // setter injection
//        dev abc = (dev)cntxt.getBean("dev1");
//        System.out.println(abc.getAge());
//
//        //constructor injection
//        // obj with id dev2
//        dev obj2 = (dev)cntxt.getBean("dev2");
//        System.out.println(obj2.getName());
//        // obj with id dev3
//        dev obj3 = (dev)cntxt.getBean("dev3");
//        System.out.println(obj3.getName() + obj3.getAge()) ;
//
//        //constructor injection with other class
//        // obj with id dev4
//        dev obj4 = (dev)cntxt.getBean("dev4");
//        obj4.getLaptop().compile();
        //setter injection with other class
        dev obj5 = (dev)cntxt.getBean("dev5");
        obj5.getLaptop().compile();
        obj5.getLaptop();
    }

}
