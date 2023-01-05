package com.swamy.service;

import com.swamy.dto.OrderRequest;
import com.swamy.dto.OrderResponse;

public interface IOrderService {

	OrderResponse placeOrder(OrderRequest orderRequest);

}
