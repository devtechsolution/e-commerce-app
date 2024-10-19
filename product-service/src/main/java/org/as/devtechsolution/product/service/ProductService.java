package org.as.devtechsolution.product.service;

import org.as.devtechsolution.product.dto.ProductRequest;
import org.as.devtechsolution.product.dto.ProductResponse;

import java.util.List;

/**
 * @author Aditya Srivastva on 15-10-2024
 */
public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
