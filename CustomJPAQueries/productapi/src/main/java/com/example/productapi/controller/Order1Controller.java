package com.example.productapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.productapi.model.Order1;
import com.example.productapi.service.Order1Service;



	@RestController
	@RequestMapping("/orders")
	public class Order1Controller {
	    @Autowired
	    private Order1Service order1Service;

	    @GetMapping
	    public List<Order1> getAllOrders() {
	        return order1Service.findAll();
	    }

	    @GetMapping("/{id}")
	    public Order1 getOrderById(@PathVariable Long id) {
	        return order1Service.findById(id);
	    }

	    @PostMapping
	    public Order1 createOrder(@RequestBody Order1 order1) {
	        return order1Service.save(order1);
	    }

	    @PutMapping("/{id}")
	    public Order1 updateOrder(@PathVariable Long id, @RequestBody Order1 order) {
	        order.setId(id);
	        return order1Service.save(order);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteOrder(@PathVariable Long id) {
	        order1Service.deleteById(id);
	    }

	    @GetMapping("/customer/{customerId}")
	    public List<Order1> getOrdersByCustomerId(@PathVariable Long customerId) {
	        return order1Service.findByCustomerId(customerId);
	    }
	    
	    @GetMapping("/amount")
	    public List<Order1> findOrdersWithAmountGreaterThan(@RequestParam Double amount,
	                                                        @RequestParam int page,
	                                                        @RequestParam int size) {
	        return order1Service.findOrdersWithAmountGreaterThan(amount, page, size);
	    }

	    @GetMapping("/status")
	    public List<Order1> findByStatus(@RequestParam String status) {
	        return order1Service.findByStatus(status);
	    }

	}

