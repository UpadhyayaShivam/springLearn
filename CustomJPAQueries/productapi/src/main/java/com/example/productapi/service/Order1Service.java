package com.example.productapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.productapi.dao.Order1Repository;
import com.example.productapi.model.Order1;

@Service
public class Order1Service {
    @Autowired
    private Order1Repository order1Repository;

    public List<Order1> findAll() {
        return order1Repository.findAll();
    }

    public Order1 findById(Long id) {
        return order1Repository.findById(id).orElse(null);
    }

    public Order1 save(Order1 order1) {
        return order1Repository.save(order1);
    }

    public void deleteById(Long id) {
        order1Repository.deleteById(id);
    }

    public List<Order1> findByCustomerId(Long customerId) {
        return order1Repository.findByCustomerId(customerId);
    }
    
    public List<Order1> findOrdersWithAmountGreaterThan(Double amount, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return order1Repository.findOrdersWithAmountGreaterThan(amount, pageable);
    }

    public List<Order1> findByStatus(String status) {
        return order1Repository.findByStatus(status);
    }
       
}