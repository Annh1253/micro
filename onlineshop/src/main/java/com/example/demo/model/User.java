package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document("User")
@Data
public class User{
    @Id
    private String id;

    @Field(name = "name")
    @Indexed(unique = true)
    private String name;
}
