package com.swamy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swamy.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}