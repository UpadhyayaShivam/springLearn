package com.example.users.projectUsers.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_Id;
    private String customer_Name;

    public Customer(){};

    public Customer(Long customer_Id, String customer_Name) {
        this.customer_Id = customer_Id;
        this.customer_Name = customer_Name;
    }

    public Customer(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    public Long getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(Long customer_Id) {
        this.customer_Id = customer_Id;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_Id=" + customer_Id +
                ", customer_Name='" + customer_Name + '\'' +
                '}';
    }
}
