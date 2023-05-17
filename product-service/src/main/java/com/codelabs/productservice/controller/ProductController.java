package com.codelabs.productservice.controller;

import com.codelabs.productservice.dto.ProductDTO;
import com.codelabs.productservice.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(Product.class);

    @PostMapping
    public void createProduct(@RequestBody ProductDTO productRequest) {
        logger.info("Received request to create new product");

    }

    @GetMapping
    public void getProduct() {

    }
}
