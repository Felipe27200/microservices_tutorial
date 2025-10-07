package com.jzea.microservices.product_service.service;

import com.jzea.microservices.product_service.dto.ProductRequest;
import com.jzea.microservices.product_service.dto.ProductResponse;
import com.jzea.microservices.product_service.entity.Product;
import com.jzea.microservices.product_service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/*
* This generates constructors for all final and
* non-null fields
* */
@RequiredArgsConstructor
@Slf4j
public class ProductService
{

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest)
    {
        Product product = Product.builder()
                /*
                * With Records, with access to the properties
                * just with their names.
                * */
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        product = productRepository.save(product);

        log.info("Product {} has been created", product);

        return new ProductResponse( product.getId(), product.getName(), product.getDescription(), product.getPrice() );
    }

    public List<ProductResponse> findAllProducts()
    {
        log.info("Finding all products");

        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
