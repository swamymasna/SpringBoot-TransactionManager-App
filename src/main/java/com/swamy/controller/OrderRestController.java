package com.swamy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.dto.OrderRequest;
import com.swamy.dto.OrderResponse;
import com.swamy.service.IOrderService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderRestController {

	@Autowired
	private IOrderService orderService;

	@PostMapping
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {

		return ResponseEntity.ok(orderService.placeOrder(orderRequest));
	}

}
