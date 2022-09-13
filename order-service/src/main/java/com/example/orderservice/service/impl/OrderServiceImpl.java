package com.example.orderservice.service.impl;

import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.dto.OrderDetailDTO;
import com.example.orderservice.helper.DTOHelper;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderDetail;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    DTOHelper dtoHelper;

    @Override
    public void placeOrder(OrderDTO orderDTO) {
        Order order = new Order();
        List<OrderDetailDTO> orderDetailDTOList = orderDTO.getOrderDetailList();

        List<OrderDetail> orderDetailList = dtoHelper.mapList(orderDetailDTOList, OrderDetail.class);

        order.setOrderDetailList(orderDetailList);
        for(OrderDetail orderDetail : orderDetailList){
            System.out.println(orderDetail.getOrder().getId());
        }
        order = orderRepository.save(order);

    }
}
