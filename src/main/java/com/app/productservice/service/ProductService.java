package com.app.productservice.service;

import com.app.productservice.models.Product;
import com.app.productservice.models.requests.ProductRequest;
import com.app.productservice.models.response.ProductResponse;
import com.app.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest request){
        log.info("Adding Product");

        var product = Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }


    public List<ProductResponse> getAllProducts() {
        log.info("Fetching All Products");

        var products = productRepository.findAll();

        return products.stream()
                .map(p -> new ProductResponse(p.getId(), p.getName(), p.getDescription(),p.getPrice()))
                .collect(Collectors.toList());

    }
}
