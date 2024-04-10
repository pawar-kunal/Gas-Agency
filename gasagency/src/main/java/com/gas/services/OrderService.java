package com.gas.services;

import com.gas.payloads.request.OrderRequest;
import com.gas.payloads.response.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse create(OrderRequest orderRequest);

    OrderResponse update(OrderRequest orderRequest);
    OrderResponse getOrderByOrderId(Integer orderId);
    List<OrderResponse> getAll();
    List<OrderResponse> getAllActive();
}
