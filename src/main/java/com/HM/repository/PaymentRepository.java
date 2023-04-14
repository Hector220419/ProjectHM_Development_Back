package com.HM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HM.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
}
