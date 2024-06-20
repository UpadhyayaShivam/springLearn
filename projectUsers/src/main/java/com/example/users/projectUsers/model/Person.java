package com.example.users.projectUsers.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer person_Id;

    private String person_Name;


    private String person_Email;
    public Person(){};

    public Person(Integer person_Id, String person_Name, String person_Email) {
        this.person_Id = person_Id;
        this.person_Name = person_Name;
        this.person_Email = person_Email;
    }

    public Person(String person_Name, String person_Email) {
        this.person_Name = person_Name;
        this.person_Email = person_Email;
    }

    public Integer getPerson_Id() {
        return person_Id;
    }

    public void setPerson_Id(Integer person_Id) {
        this.person_Id = person_Id;
    }

    public String getPerson_Name() {
        return person_Name;
    }

    public void setPerson_Name(String person_Name) {
        this.person_Name = person_Name;
    }

    public String getPerson_Email() {
        return person_Email;
    }

    public void setPerson_Email(String person_Email) {
        this.person_Email = person_Email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_Id=" + person_Id +
                ", person_Name='" + person_Name + '\'' +
                ", person_Email='" + person_Email + '\'' +
                '}';
    }
}
