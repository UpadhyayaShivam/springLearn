package com.example.productapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productapi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
