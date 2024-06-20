package com.example.productapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.productapi.model.Customer;
import com.example.productapi.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {

        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {

        return customerService.findById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {

        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        customer.setId(id);
        return customerService.save(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
    }

   @GetMapping("/search/{email}")
   public List<Customer> getCustomerByEmail(@PathVariable String email) {
        return customerService.findByEmail(email);
   }

    @GetMapping("/name")
    public List<Customer> findCustomersWithOrdersByName(@RequestParam String name) {
       return customerService.findCustomersWithOrdersByName(name);
   }

    @GetMapping("/search/name")
    public List<Customer> findByName(@RequestParam  String name) {
        return customerService.findByName(name);
    }

    @GetMapping("/search/email/order")
    public List<Customer> findByEmailOrderedByNameDesc(@RequestParam String email) {
        return customerService.findByEmailOrderedByNameDesc(email);
    }

    @GetMapping("/search/name/contains")
    public List<Customer> findByNameContaining(@RequestParam String name) {
        return customerService.findByNameContaining(name);
    }
}

