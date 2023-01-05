package com.swamy.service.impl;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swamy.dto.OrderRequest;
import com.swamy.dto.OrderResponse;
import com.swamy.entity.Order;
import com.swamy.entity.Payment;
import com.swamy.exception.PaymentException;
import com.swamy.repository.OrderRepository;
import com.swamy.repository.PaymentRepository;
import com.swamy.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	@Transactional
	public OrderResponse placeOrder(OrderRequest orderRequest) {

		Order order = orderRequest.getOrder();
		order.setOrderTrackingNumber(UUID.randomUUID().toString());
		order.setStatus("IN_PROGRESS");
		orderRepository.save(order);

		Payment payment = orderRequest.getPayment();

		if (!payment.getPaymentType().equals("DEBIT")) {
			throw new PaymentException("payment card type do not support");
		}

		payment.setOrderId(order.getId());
		paymentRepository.save(payment);

		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
		orderResponse.setStatus(order.getStatus());
		orderResponse.setMessage("SUCCESS");

		return orderResponse;
	}
	

}
