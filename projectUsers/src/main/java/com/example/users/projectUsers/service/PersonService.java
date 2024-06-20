package com.example.users.projectUsers.service;

import com.example.users.projectUsers.model.Person;
import com.example.users.projectUsers.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {


    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository ){
        this.personRepository = personRepository;
    }

    public List <Person> getAllPerson(){
        return personRepository.findAll();
    }

}
