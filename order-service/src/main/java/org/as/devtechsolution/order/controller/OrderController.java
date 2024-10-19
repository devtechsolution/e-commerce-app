package org.as.devtechsolution.order.controller;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.as.devtechsolution.order.dto.OrderRequest;
import org.as.devtechsolution.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Aditya Srivastva on 19-10-2024
 */
@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }

}
