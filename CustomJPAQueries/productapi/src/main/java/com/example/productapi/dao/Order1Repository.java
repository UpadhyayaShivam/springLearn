package com.example.productapi.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.productapi.model.Order1;

public interface Order1Repository extends JpaRepository<Order1, Long> {
	
	
	@Query("SELECT o FROM Order1 o WHERE o.customer.id = :customerId")
      List<Order1> findByCustomerId(Long customerId);
	
	@Query("SELECT o FROM Order1 o WHERE o.totalAmount> :amount ORDER BY o.totalAmount DESC")
	List<Order1> findOrdersWithAmountGreaterThan(@Param("amount") Double amount, Pageable pageable);
	
	@Query("SELECT o From Order1 o WHERE o.status = :status")
	List<Order1> findByStatus(@Param("status")String status);
    
   
}
