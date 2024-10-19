package org.as.devtechsolution.product.dto;

import java.math.BigDecimal;

/**
 * @author Aditya Srivastva on 15-10-2024
 */
public record ProductRequest(String id, String name, String description,String skuCode, BigDecimal price) {
}
