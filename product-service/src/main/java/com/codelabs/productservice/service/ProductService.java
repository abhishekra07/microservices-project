package com.codelabs.productservice.service;

import com.codelabs.productservice.dto.ProductDTO;
import com.codelabs.productservice.dto.ProductList;
import com.codelabs.productservice.model.Product;
import com.codelabs.productservice.repository.IProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private IProductRepository repository;

    @Autowired
    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(ProductDTO productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        product = repository.save(product);
        logger.info("saved product to DB");
        return product;
    }

    public ProductList getProducts() {
        List<ProductDTO> list = repository.findAll().stream().map(product -> {
            return ProductDTO.builder()
                    .Id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .build();
        }).toList();
        logger.info("retrieved " + list.size() + " products from database");
        return new ProductList(list);
    }
}
