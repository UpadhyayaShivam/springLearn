package com.example.productapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productapi.dao.CustomerRepository;
import com.example.productapi.model.Customer;

import java.util.List;

	@Service
	public class CustomerService {
	    @Autowired
	    private CustomerRepository customerRepository;

	    public List<Customer> findAll() {
	        return customerRepository.findAll();
	    }

	    public Customer findById(Long id) {
	        return customerRepository.findById(id).orElse(null);
	    }

	    public Customer save(Customer customer) {
	        return customerRepository.save(customer);
	    }

	    public void deleteById(Long id) {
	        customerRepository.deleteById(id);
	    }

	    public List<Customer> findByEmail(String email) {
	        return customerRepository.findByEmail(email);
	    }
	    
	    public List<Customer> findCustomersWithOrdersByName(String name) {
	        return customerRepository.findCustomersWithOrdersByName(name);
	    }

	    public List<Customer> findByName(String name) {
	        return customerRepository.findByName(name);
	    }

	    public List<Customer> findByEmailOrderedByNameDesc(String email) {
	        return customerRepository.findByEmailOrderedByNameDesc(email);
	    }

	    public List<Customer> findByNameContaining(String name) {
	        return customerRepository.findByNameContaining(name);
	    }
	}
	


