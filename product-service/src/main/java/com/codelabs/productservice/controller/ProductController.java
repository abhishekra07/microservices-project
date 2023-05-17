package com.codelabs.productservice.controller;

import com.codelabs.productservice.dto.ProductDTO;
import com.codelabs.productservice.model.Product;
import com.codelabs.productservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productRequest) {
        logger.info("Received request to create new product");
        Product product = productService.createProduct(productRequest);
        logger.info("Successfully completed request to create new product :- " + product.getId());
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @GetMapping
    public void getProduct() {

    }
}
