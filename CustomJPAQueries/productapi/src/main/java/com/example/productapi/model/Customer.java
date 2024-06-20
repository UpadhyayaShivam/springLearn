package com.example.productapi.model;

import java.util.List;

import jakarta.persistence.*;


@Entity
public class Customer {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	  
	    private String name;
	    private String email;

	    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	    private List<Order1> orders;
	    
	    // Getters and Setters
	    
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public List<Order1> getOrders() {
			return orders;
		}

		public void setOrders(List<Order1> orders) {
			this.orders = orders;
		}

	    
	}


