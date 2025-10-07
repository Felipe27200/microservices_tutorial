package com.jzea.microservices.order.service;

import com.jzea.microservices.order.dto.OrderRequest;
import com.jzea.microservices.order.entity.Order;
import com.jzea.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService
{
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest)
    {
        // Map Order
        Order order = Order.builder()
            .orderNumber(UUID.randomUUID().toString())
            .price(orderRequest.price())
            .skuCode(orderRequest.skuCode())
            .quantity(orderRequest.quantity())
            .build();

        orderRepository.save(order);

        log.info("Order placed successfully");
    }
}
