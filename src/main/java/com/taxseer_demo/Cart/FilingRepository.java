package com.taxseer_demo.Cart;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface FilingRepository extends R2dbcRepository<Filing, Long> {
}
