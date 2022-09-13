package com.example.productservice.controller;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductDTO productDTO){
        productService.createProduct(productDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
