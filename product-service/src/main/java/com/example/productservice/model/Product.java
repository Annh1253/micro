package com.example.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document("product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "description")
    private String description;

    @Field(name = "price")
    private BigDecimal price;

}
