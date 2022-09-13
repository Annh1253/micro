package com.example.productservice.service;

import com.example.productservice.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    public void createProduct(ProductDTO productDTO);

    public List<ProductDTO> getAllProducts();
}
