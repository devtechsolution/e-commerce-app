package org.as.devtechsolution.order.service;

import org.as.devtechsolution.order.dto.OrderRequest;

/**
 * @author Aditya Srivastva on 19-10-2024
 */
public interface OrderService {

    void placeOrder(OrderRequest orderRequest);
}
