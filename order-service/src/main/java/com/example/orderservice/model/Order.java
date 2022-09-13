package com.example.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Order")
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderNumber;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetailList = new java.util.ArrayList<>();

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
        for(OrderDetail orderDetail : orderDetailList){
            orderDetail.setOrder(this);
        }
    }
}
