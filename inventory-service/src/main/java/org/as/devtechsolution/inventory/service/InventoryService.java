package org.as.devtechsolution.inventory.service;

/**
 * @author Aditya Srivastva on 19-10-2024
 */
public interface InventoryService {
    boolean isInStock(String skuCode, Integer quantity);
}
