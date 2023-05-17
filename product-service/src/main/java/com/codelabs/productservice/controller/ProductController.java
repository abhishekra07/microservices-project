package com.codelabs.productservice.controller;

import com.codelabs.productservice.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @PostMapping
    public void createProduct() {

    }

    @GetMapping
    public void getProduct() {
        
    }
}
