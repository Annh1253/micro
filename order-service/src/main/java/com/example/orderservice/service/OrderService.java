package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDTO;
import org.springframework.stereotype.Service;


public interface OrderService {
    public void placeOrder(OrderDTO orderDTO);
}
