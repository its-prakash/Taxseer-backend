package com.taxseer_demo.Order;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OrderFormRepository extends ReactiveCrudRepository<OrderForm, Long> {
    Flux<OrderForm> findByOrderId(Long orderId);
}