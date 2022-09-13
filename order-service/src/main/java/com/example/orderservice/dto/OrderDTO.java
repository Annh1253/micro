package com.example.orderservice.dto;

import com.example.orderservice.model.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String orderNumber;
    private List<OrderDetailDTO> orderDetailList;
}
