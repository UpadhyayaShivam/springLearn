//package com.example.users.projectUsers.batch;
//
//import com.example.users.projectUsers.model.Person;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.stereotype.Component;
//@Component
//public class PersonItemProcessor implements ItemProcessor<Person,Person> {
//
//
////    public PersonItemProcessor(){
////        Person temp1 = new Person(1,"shivam","sharma");
////        process(temp1);
////    }
//
//    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
//    @Override
//    public Person process( Person person) {
//        System.out.println("in processor person");
//
//        final String person_Name = person.getPerson_Name().toUpperCase();
//        final String person_Email = person.getPerson_Email().toUpperCase();
//
//        final Person transformedPerson = new Person(person_Name, person_Email);
//
//        log.info("Converting (" + person + ") into (" + transformedPerson + ")");
//
//        return transformedPerson;
//    }
//}
