package com.HM.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;


import com.HM.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	//@Query(value="SELECT p FROM clotheorder p WHERE p.idOrder = ?1",nativeQuery=true)
	
	
	
	//WHERE p.idOrder = ?1
	//Optional<Order> findById(Integer idOrder);
}
