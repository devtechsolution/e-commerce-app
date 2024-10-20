package org.as.devtechsolution.order.service;

import lombok.AllArgsConstructor;
import org.as.devtechsolution.order.client.InventoryClient;
import org.as.devtechsolution.order.dto.OrderRequest;
import org.as.devtechsolution.order.model.Order;
import org.as.devtechsolution.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Aditya Srivastva on 19-10-2024
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl implements  OrderService{

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    @Override
    public void placeOrder(final OrderRequest orderRequest) {
        final var inStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (inStock) {
            //map orderRequest to order object
            Order order = Order.builder()
                    .orderNumber(UUID.randomUUID().toString())
                    .price(orderRequest.price())
                    .skuCode(orderRequest.skuCode())
                    .quantity(orderRequest.quantity())
                    .build();
            //save order to orderRepository
            final var saveOrder = orderRepository.save(order);


        } else {
            throw new RuntimeException("Product with SkuCode "+orderRequest.skuCode()+" is not in stock");
        }
    }
}
