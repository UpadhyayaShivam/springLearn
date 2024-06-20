package com.example.users.projectUsers.batch;

import com.example.users.projectUsers.model.Person;
import org.springframework.batch.item.ItemProcessor;

public class SchedulingItemProcessor2 implements ItemProcessor<Person,Person> {

    @Override
    public Person process(Person person){
            final String person_Name = person.getPerson_Name().concat("ForShivam");
            final String person_Email = person.getPerson_Email().concat(".org");
            final Integer person_Id = person.getPerson_Id();

            return new Person(person_Id,person_Name,person_Email);
    }
}
