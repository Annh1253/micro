package com.example.orderservice.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_detail")
@Data
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String skuCode;
    private BigDecimal price;
    private Integer quanlity;

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}