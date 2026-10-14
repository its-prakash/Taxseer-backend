package com.taxseer_demo.Cart;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface CartRepository extends R2dbcRepository<Cart, Long> {
    Flux<Cart> findByFilerId(Long filerId);
}
