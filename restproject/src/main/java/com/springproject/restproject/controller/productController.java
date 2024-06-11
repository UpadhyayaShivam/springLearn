package com.springproject.restproject.controller;


import com.springproject.restproject.model.product;
import com.springproject.restproject.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productController {

    @Autowired
    productService service;

//    @RequestMapping("/products")
    @GetMapping("/products")
    public List<product> getProducts(){
            return service.getProducts();
    }

    @GetMapping("/products/{prodId}")
    public  product getProductById(@PathVariable int prodId) {
        return service.getProductById(prodId);
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody product prd){
            service.addProduct(prd);
    }




}

