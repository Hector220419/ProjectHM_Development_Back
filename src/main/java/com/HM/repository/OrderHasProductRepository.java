package com.HM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HM.model.OrderHasProduct;

public interface OrderHasProductRepository extends JpaRepository<OrderHasProduct, Integer>{
	
}
