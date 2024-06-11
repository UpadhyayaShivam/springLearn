package com.springproject.restproject.service;

import com.springproject.restproject.model.product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class productService{

    List <product> products = new ArrayList<>(Arrays.asList(new product(101,"table fan",5000),new product(102,"cooler",10000)));
    public List<product> getProducts(){
        return products;
    }

    public product getProductById(int pdId){
            return products.stream().filter(
                    product -> product.getProductId() == pdId
            ).findFirst().orElse(new product(100, "no item",0));
    }

    public void addProduct(product prdAdd){
        products.add(prdAdd);
    }


}


