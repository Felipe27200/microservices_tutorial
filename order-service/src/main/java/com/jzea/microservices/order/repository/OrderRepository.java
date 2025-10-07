package com.jzea.microservices.order.repository;

import com.jzea.microservices.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
