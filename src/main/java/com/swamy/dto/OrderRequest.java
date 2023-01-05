package com.swamy.dto;

import com.swamy.entity.Order;
import com.swamy.entity.Payment;

import lombok.Data;

@Data
public class OrderRequest {

	private Order order;
	private Payment payment;
}
