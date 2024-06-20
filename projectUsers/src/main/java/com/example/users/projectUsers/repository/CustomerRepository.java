package com.example.users.projectUsers.repository;

import com.example.users.projectUsers.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
