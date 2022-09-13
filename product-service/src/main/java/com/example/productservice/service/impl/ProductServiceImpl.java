package com.example.productservice.service.impl;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.helper.DtoHelper;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DtoHelper dtoHelper;

    @Override
    public void createProduct(ProductDTO productDTO) {
        Product product = Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .build();
        productRepository.save(product);
        log.info("Producct {} is saved", product.getId());
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = dtoHelper.mapList(productList, ProductDTO.class);
        return productDTOList;
    }
}
