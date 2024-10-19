package org.as.devtechsolution.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.as.devtechsolution.product.domain.Product;
import org.as.devtechsolution.product.dto.ProductRequest;
import org.as.devtechsolution.product.dto.ProductResponse;
import org.as.devtechsolution.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aditya Srivastva on 15-10-2024
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements  ProductService{

    private final ProductRepository productRepository;
    @Override
    public ProductResponse createProduct(final ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name()).description(productRequest.description())
                .skuCode(productRequest.skuCode()).price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product created successfully");


        return new ProductResponse(product.getId(), product.getName()
                ,product.getDescription(), product.getSkuCode(),product.getPrice());
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> new ProductResponse(product.getId(), product.getName()
                        ,product.getDescription(), product.getSkuCode(),product.getPrice()))
                .toList();
    }
}
