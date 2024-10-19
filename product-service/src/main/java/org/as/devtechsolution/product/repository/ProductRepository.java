package org.as.devtechsolution.product.repository;

import org.as.devtechsolution.product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Aditya Srivastva on 15-10-2024
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
