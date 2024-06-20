package com.example.users.projectUsers.repository;

import com.example.users.projectUsers.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {


}
