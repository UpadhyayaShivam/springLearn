package com.example.productapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.productapi.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Custom finder method to retrieve customers by email
    List<Customer> findByEmail(String email);
    
    List<Customer> findByName(String name);
    
    @Query("SELECT c FROM Customer c JOIN FETCH c.orders WHERE c.name =:name")
    List<Customer> findCustomersWithOrdersByName(@Param("name")String name);
    
    @Query("SELECT c FROM Customer c WHERE c.email = :email ORDER BY c.name DESC")
    List<Customer> findByEmailOrderedByNameDesc(@Param("email")String email);
    
    @Query("SELECT c FROM Customer c WHERE c.name LIKE %:name%")
    List<Customer> findByNameContaining(@Param("name")String name);
}
