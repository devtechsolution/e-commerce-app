package org.as.devtechsolution.inventory.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.as.devtechsolution.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;

/**
 * @author Aditya Srivastva on 19-10-2024
 */

@Service
@AllArgsConstructor
@Slf4j
public class InventoryServiceImpl implements  InventoryService{

    private final InventoryRepository inventoryRepository;
    @Override
    public boolean isInStock(final String skuCode, final Integer quantity) {
        log.info(" Start -- Received request to check stock for skuCode {}, with quantity {}", skuCode, quantity);
        boolean isInStock = inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
        log.info(" End -- Product with skuCode {}, and quantity {}, is in stock - {}", skuCode, quantity, isInStock);
        return isInStock;
    }
}
